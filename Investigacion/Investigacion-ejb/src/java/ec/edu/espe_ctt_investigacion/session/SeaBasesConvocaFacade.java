/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaBasesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
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
public class SeaBasesConvocaFacade extends AbstractFacade<SeaBasesConvoca> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaBasesConvocaFacade() {
        super(SeaBasesConvoca.class);
    }
    public List<SeaBasesConvoca> findBasesbyConvocatoria(SeaConvoca convocatoria){
       
        List<SeaBasesConvoca> result = null;
        Query query = em.createQuery("SELECT s FROM SeaBasesConvoca s where s.convocaId =:convocatoria ORDER BY s.sbcId");
        query.setParameter("convocatoria", convocatoria);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
       
        return result == null || result.isEmpty() ? null : result;
    }
}
