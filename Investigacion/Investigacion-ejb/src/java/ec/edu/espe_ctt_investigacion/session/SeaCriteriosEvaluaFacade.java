/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import java.math.BigDecimal;
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
public class SeaCriteriosEvaluaFacade extends AbstractFacade<SeaCriteriosEvalua> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaCriteriosEvaluaFacade() {
        super(SeaCriteriosEvalua.class);
    }
    
    public List<SeaCriteriosEvalua> findCriterioEvalua(){
        List<SeaCriteriosEvalua> result = null;
        Query query = em.createQuery("SELECT s FROM SeaCriteriosEvalua s WHERE s.scePadre IS NULL");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaCriteriosEvalua> findCriterioHijoByCodCr(BigDecimal codCri){
        List<SeaCriteriosEvalua> result = null;
        Query query = em.createQuery("SELECT o FROM SeaCriteriosEvalua o WHERE o.scePadre.sceId =:codCri");
        query.setParameter("codCri", codCri);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaCriteriosEvalua> findCriterConvoCrByCodCr(BigDecimal codCri){
        List<SeaCriteriosEvalua> result = null;
        Query query = em.createQuery("SELECT o FROM SeaCriteriosEvalua o WHERE o.scePadre.sceId =:codCri");
        query.setParameter("codCri", codCri);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaCriteriosEvalua> findCriterioValor(){
        List<SeaCriteriosEvalua> result = null;
        Query query = em.createQuery("SELECT o FROM SeaCriteriosEvalua o WHERE o.sceId in(7,8,9,10,11,13,14,18,19,20)");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    
    public BigDecimal getMaxSceId(){
        Query query = em.createQuery("select max(o.sceId)+1 from SeaCriteriosEvalua o");
                Object object = query.getSingleResult();
                return (BigDecimal) object;
    }
    
}
/*
public List<SeaCriteriosEvalua> findCriterConvoCrByCodCr(BigDecimal codCri){
        List<SeaCriteriosEvalua> result = null;
        Query query = em.createQuery("SELECT o FROM SeaCriteriosEvalua o WHERE o.scePadre.sceId =:codCri");
        query.setParameter("codCri", codCri);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
*/