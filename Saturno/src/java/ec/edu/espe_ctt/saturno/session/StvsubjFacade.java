/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.session;

import ec.edu.espe_ctt.saturno.entity.Stvsubj;
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
public class StvsubjFacade extends AbstractFacade<Stvsubj> {
    @PersistenceContext(unitName = "SaturnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StvsubjFacade() {
        super(Stvsubj.class);
    }
    public List<Stvsubj> findDepartamento(){
        List<Stvsubj> result = null;
        Query query = em.createQuery("SELECT o FROM Stvsubj o ORDER BY o.stvsubjDesc");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public Stvsubj findDepartamentoByCodDep( String codDep){
        List<Stvsubj> result = null;
        Query query = em.createQuery("SELECT o FROM Stvsubj o WHERE o.stvsubjCode =:codDep  ORDER BY o.stvsubjDesc");
        query.setParameter("codDep", codDep);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
}
