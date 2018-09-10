/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.session;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
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
public class StvcampFacade extends AbstractFacade<Stvcamp> {
    @PersistenceContext(unitName = "SaturnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StvcampFacade() {
        super(Stvcamp.class);
    }
    public List<Stvcamp> findCampus(){
        List<Stvcamp> result = null;
        Query query = em.createQuery("SELECT o FROM Stvcamp o ORDER BY o.stvcampCode ");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public Stvcamp findCampusByCodCamp(String codCamp){
        List<Stvcamp> result = null;
        Query query = em.createQuery("SELECT o FROM Stvcamp o WHERE o.stvcampCode =:codCamp");
        query.setParameter("codCamp", codCamp);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    
}
