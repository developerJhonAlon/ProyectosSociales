/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaNoFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPorcenXCrConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class SeaPorcenXCrConvocaFacade extends AbstractFacade<SeaPorcenXCrConvoca> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaPorcenXCrConvocaFacade() {
        super(SeaPorcenXCrConvoca.class);
    }
    
     public List<SeaPorcenXCrConvoca> findPorcenbyConvocatoria(SeaConvoca convocatoria)
    {
        System.out.println(" jjj "+convocatoria);
        List<SeaPorcenXCrConvoca> result = null;
        Query query = em.createQuery("SELECT s FROM SeaPorcenXCrConvoca s where s.convocaId =:convocatoria AND s.prdId.prdId =:codFase");
        query.setParameter("convocatoria", convocatoria);
        query.setParameter("codFase", 261);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
     public List<SeaPorcenXCrConvoca> findPorcenbyConvocatoria2(SeaConvoca convocatoria)
    {
        List<SeaPorcenXCrConvoca> result = null;
        Query query = em.createQuery("SELECT s FROM SeaPorcenXCrConvoca s where s.convocaId =:convocatoria AND s.prdId.prdId =:codFase");
        query.setParameter("convocatoria", convocatoria);
        query.setParameter("codFase", 262);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
     public List<SeaPorcenXCrConvoca> findPorcAllByFase(BigDecimal codConvoca, BigInteger codFase){
        List<SeaPorcenXCrConvoca> result = null;
        Query query = em.createQuery("SELECT s FROM SeaPorcenXCrConvoca s WHERE s.convocaId.convocaId =:codConvoca and s.prdId.prdId =:codFase");
        query.setParameter("codConvoca", codConvoca);
        query.setParameter("codFase", codFase);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result;
    }
     public List<SeaPorcenXCrConvoca> findPorcenConvocatByConvoc( BigDecimal codConv){
         List<SeaPorcenXCrConvoca> result = null;
         Query query = em.createQuery("SELECT o FROM SeaPorcenXCrConvoca o WHERE o.convocaId.convocaId =:codConv AND  o.prdId.prdId =261");
         query.setParameter("codConv", codConv);
         query.setHint("eclipselink.refresh", true);
         result = query.getResultList();
         return result;
     }
     public List<SeaPorcenXCrConvoca> findPorConvocaByCodConCodFaseCodSec(BigDecimal codConvoca, BigInteger codFase, BigDecimal codSec){
        List<SeaPorcenXCrConvoca> result = null;
        Query query = em.createQuery("SELECT s FROM SeaPorcenXCrConvoca s WHERE s.convocaId.convocaId =:codConvoca and s.prdId.prdId =:codFase and s.sceId.sceId =:codSec");
        query.setParameter("codConvoca", codConvoca);
        query.setParameter("codFase", codFase);
        query.setParameter("codSec", codSec);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result;
    }
     
      
    
}
