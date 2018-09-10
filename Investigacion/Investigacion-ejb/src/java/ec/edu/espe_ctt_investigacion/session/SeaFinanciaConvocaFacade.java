/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class SeaFinanciaConvocaFacade extends AbstractFacade<SeaFinanciaConvoca> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaFinanciaConvocaFacade() {
        super(SeaFinanciaConvoca.class);
    }
    public SeaFinanciaConvoca findFinanRecurFisByConvocatoria(BigDecimal codConvoca){
        List<SeaFinanciaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFinanciaConvoca o WHERE o.convocaId.convocaId =:codConvoca AND o.srcId.srcId=1");
        query.setParameter("codConvoca", codConvoca);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result==null || result.isEmpty() ? null:result.get(0);
    }
    public SeaFinanciaConvoca findFinanRecurHumaByConvocatoria(BigDecimal codConvoca){
        List<SeaFinanciaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFinanciaConvoca o WHERE o.convocaId.convocaId =:codConvoca AND o.srcId.srcId =2");
        query.setParameter("codConvoca", codConvoca);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result==null || result.isEmpty() ? null:result.get(0);
    }
    public SeaFinanciaConvoca findFinanRecurLogisByConvocatoria(BigDecimal codConvoca){
        List<SeaFinanciaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFinanciaConvoca o WHERE o.convocaId.convocaId =:codConvoca AND o.srcId.srcId =3");
        query.setParameter("codConvoca", codConvoca);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result==null || result.isEmpty() ? null:result.get(0);
    }
    
    public List<SeaFinanciaConvoca> findFinanAllByConvocatoria(BigDecimal codConvoca){
        List<SeaFinanciaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFinanciaConvoca o WHERE o.convocaId.convocaId =:codConvoca");
        query.setParameter("codConvoca", codConvoca);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result;
    }    

    public List<SeaFinanciaConvoca> findFinanAllByConvocatoriaActivo(BigDecimal codConvoca){
        List<SeaFinanciaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFinanciaConvoca o WHERE o.convocaId.convocaId =:codConvoca ");
        query.setParameter("codConvoca", codConvoca);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result;
    }    
    
    public List<SeaFinanciaConvoca> findFinanAllByRecurso(BigDecimal codConvoca, BigInteger codRec){
        List<SeaFinanciaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFinanciaConvoca o WHERE o.convocaId.convocaId =:codConvoca and o.srcId.srcId = :codRec");
        query.setParameter("codConvoca", codConvoca);
        query.setParameter("codRec", codRec);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result;
    }    
    
}
