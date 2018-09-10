/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
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
public class SeaCantonFacade extends AbstractFacade<SeaCanton> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaCantonFacade() {
        super(SeaCanton.class);
    }
     public List<SeaCanton> findByProvincia(String codProvincia) {
        return em.createQuery("select object(o) from SeaCanton as o  "
                + "where o.proId.proId =:codProvincia "
                + "order by o.canNombre asc").setHint("eclipselink.refresh", true).setParameter("codProvincia", codProvincia).getResultList();
    }
    public List<SeaCanton> findCantonByCodProvincia(String codProv){
        List<SeaCanton> result = null;
        Query query = em.createQuery("SELECT o FROM SeaCanton o WHERE o.proId.proId =:codProv");
        query.setParameter("codProv", codProv);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
            
    
    
}
