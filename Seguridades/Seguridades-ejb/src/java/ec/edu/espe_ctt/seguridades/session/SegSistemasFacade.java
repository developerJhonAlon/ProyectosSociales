/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.session;

import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
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
public class SegSistemasFacade extends AbstractFacade<SegSistemas> {
    @PersistenceContext(unitName = "Seguridades-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegSistemasFacade() {
        super(SegSistemas.class);
    }
    public List<SegSistemas> findSistemas(){
        List<SegSistemas> result = null;
        Query query = em.createQuery("SELECT o FROM SegSistemas o");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
}
