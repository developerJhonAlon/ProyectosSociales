/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ing. Cristian Asimbaya
 */
@Stateless
public class SeaProcesoXConvocatoriaFacade extends AbstractFacade<SeaProcesoXConvocatoria> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaProcesoXConvocatoriaFacade() {
        super(SeaProcesoXConvocatoria.class);
    }
    
     public SeaProcesoXConvocatoria obtenerPeriodoActivo(String proceso) {
         System.out.println(" proceso es"+proceso);
        List<SeaProcesoXConvocatoria> lprocesos = em.createNativeQuery("SELECT PXP.* FROM Sea_Proceso_X_Convocatoria PXP INNER JOIN SEA_PROCESO PRO ON PRO.PRO_ID = PXP.PRO_ID  WHERE SYSDATE BETWEEN PPC_FECINI AND PPC_FECIFIN AND PPC_ESTADO = 1 AND PRO.PRO_DESCRIP=?", SeaProcesoXConvocatoria.class).setParameter(1, proceso).setHint("eclipselink.refresh", true).getResultList();
        if (lprocesos.size() == 1) {
            return lprocesos.get(0);
        } else {
            return null;
        }
    }
//     public List<SeaProcesoXConvocatoria> findAllProcesoByConvocatoria( BigDecimal codConvoca)
//     {
//         List<SeaProcesoXConvocatoria> result = null;
//         Query query = em.createQuery("SELECT s FROM SeaProcesoXConvocatoria s WHERE s.convocaId.convocaId =:codConvoca");
//        query.setParameter("codConvoca", codConvoca);
//        query.setHint("eclipselink.refresh", true);
//        result = query.getResultList();
//        return result;
//     }
    
     public List<SeaProcesoXConvocatoria> findProcesoByConvocatoria(SeaConvoca convocatoria)
    {
       
        List<SeaProcesoXConvocatoria> result = null;
        Query query = em.createQuery("SELECT s FROM SeaProcesoXConvocatoria s where s.seaConvoca.convocaId =:convocatoria");
        query.setParameter("convocatoria", convocatoria.getConvocaId());
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public SeaProcesoXConvocatoria findProcesoXConvByCodCon(BigDecimal codCon)
    {
        List<SeaProcesoXConvocatoria> result = null;
        Integer idProceso = ParametrosGlobales.AMBIENTE_PRODUCCION1?28:29;
        Query query= em.createQuery("SELECT s FROM SeaProcesoXConvocatoria s where s.seaConvoca.convocaId =:codCon AND s.seaProceso.proId =" + idProceso);
        query.setParameter("codCon", codCon);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public SeaProcesoXConvocatoria findProcesoXConvProyLargoByCodCon(BigDecimal codCon)
    {
        List<SeaProcesoXConvocatoria> result = null;
        Boolean a = ParametrosGlobales.AMBIENTE_PRODUCCION1;
        Integer idProceso = ParametrosGlobales.AMBIENTE_PRODUCCION1?24:48;
        Query query= em.createQuery("SELECT s FROM SeaProcesoXConvocatoria s where s.seaConvoca.convocaId =:codCon AND s.seaProceso.proId =" + idProceso); 
        query.setParameter("codCon", codCon);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<SeaProcesoXConvocatoria> findProcesosConvocatoria(){
        List<SeaProcesoXConvocatoria> result = null;
        Query query = em.createQuery("SELECT o FROM SeaProcesoXConvocatoria o ORDER BY o.seaConvoca.convocaId");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result== null || result.isEmpty() ? null: result;
    }
       
}
