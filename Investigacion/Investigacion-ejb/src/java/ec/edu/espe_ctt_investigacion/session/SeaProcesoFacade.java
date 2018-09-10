/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;


import ec.edu.espe_ctt_investigacion.entity.SeaProceso;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaProcesoFacade extends AbstractFacade<SeaProceso> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaProcesoFacade() {
        super(SeaProceso.class);
    }
     public List<SeaProceso> findSeaProceso(SeaConvoca convocatoria){
        List<SeaProceso> result = null;     
        Query query = em.createQuery("SELECT PRO.* FROM Sea_Proceso_X_Convocatoria PXP INNER JOIN SEA_PROCESO PRO ON PRO.PRO_ID = PXP.PRO_ID  WHERE PXP.CONVOCA_ID =:convocatoria");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();       
        return result == null || result.isEmpty() ? null : result;
    }   
    public List<SeaProcesoXConvocatoria> findProcesoByCodProCodConv(BigDecimal codPro, BigDecimal codConv){
        List<SeaProcesoXConvocatoria> result = null;        
        Query query = em.createQuery("SELECT o FROM SeaProcesoXConvocatoria o WHERE o.seaProceso.proId =:codPro AND o.seaConvoca.convocaId =:codConv");
        query.setParameter("codPro", codPro);
        query.setParameter("codConv", codConv);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaProceso> findProceso(){
        List<SeaProceso> result = null;     
        Query query = em.createQuery("SELECT o FROM SeaProceso o ORDER BY o.proId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();       
        return result == null || result.isEmpty() ? null : result;
    }  
}
