/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class SeaFormatoLargoFacade extends AbstractFacade<SeaFormatoLargo> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaFormatoLargoFacade() {
        super(SeaFormatoLargo.class);
    }
    public SeaFormatoLargo findIdFormatoByCodPro(BigDecimal codPro){
        List<SeaFormatoLargo> result = null ;
        Query query = em.createQuery("SELECT o FROM SeaFormatoLargo o WHERE o.datgeproyId.datgeproyId =:codPro");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<SeaFormatoLargo> findFormatoByCodPro(BigDecimal codPro){
        List<SeaFormatoLargo> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFormatoLargo o WHERE o.datgeproyId.datgeproyId =:codPro");
        query.setParameter("codPro", codPro);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
   public List<SeaFormatoLargo> findFormatoLargo(){
        List<SeaFormatoLargo> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFormatoLargo o");
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }  
   public List<SeaFormatoLargo> findFormatoLargoByCodUsu(BigDecimal codUsu){
       List<SeaFormatoLargo> result = null;
       Query query = em.createQuery("SELECT o FROM SeaFormatoLargo o WHERE o.datgeproyId.usuId.usuId =:codUsu");
       query.setParameter("codUsu", codUsu);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
   }
   public List<SeaFormatoLargo> findByConvocatoria(BigDecimal idConvocatoria){
       String hql = "SELECT o FROM SeaFormatoLargo o";
       if (idConvocatoria!=null){
           hql+=" WHERE o.datgeproyId.convocaId.convocaId =:idConvocatoria";
       }
       Query query = em.createQuery(hql);
       if (idConvocatoria!=null){
           query.setParameter("idConvocatoria", idConvocatoria);
       }
       return query.getResultList();
   }
   public List<SeaFormatoLargo> findByAprobadoPar(BigDecimal idConvocatoria){
        String hql = "SELECT o FROM SeaFormatoLargo o WHERE o.datgeproyId.datgeproyEstado = :estado";
       if (idConvocatoria!=null){
           hql+=" AND o.datgeproyId.convocaId.convocaId = :idConvocatoria";
       }
       Query query = em.createQuery(hql);
       if (idConvocatoria!=null){
           query.setParameter("idConvocatoria", idConvocatoria);
       }
       query.setParameter("estado", SeaDatGeneralProy.ESTADO_EVALUADO_PAR);
       return query.getResultList();       
   }
   
}
