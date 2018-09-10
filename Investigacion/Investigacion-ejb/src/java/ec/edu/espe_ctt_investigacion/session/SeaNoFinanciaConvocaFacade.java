/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaNoFinanciaConvoca;
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
public class SeaNoFinanciaConvocaFacade extends AbstractFacade<SeaNoFinanciaConvoca> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaNoFinanciaConvocaFacade() {
        super(SeaNoFinanciaConvoca.class);
    }
    public List<SeaNoFinanciaConvoca> findNoFinanciabyConvocatoria(SeaConvoca convocatoria)
    {
        List<SeaNoFinanciaConvoca> result = null;
        Query query = em.createQuery("SELECT s FROM SeaNoFinanciaConvoca s where s.convocaId =:convocatoria");
        query.setParameter("convocatoria", convocatoria);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
    
   }
