/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
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
public class SeaParroquiaFacade extends AbstractFacade<SeaParroquia> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaParroquiaFacade() {
        super(SeaParroquia.class);
    }
      public List<SeaParroquia> findByCanton(String codCanton) {
        return em.createQuery("select object(o) from SeaParroquia as o where o.canId.canId =:codCanton order by o.prqNombre asc").setHint("eclipselink.refresh", true).setParameter("codCanton", codCanton).getResultList();
    }
    public List<SeaParroquia> findParroquiaByCodCant(String codCant){
        List<SeaParroquia> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParroquia o WHERE o.canId.canId =:codCant");
        query.setParameter("codCant", codCant);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
