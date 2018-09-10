/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
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
public class SeaProvinciaFacade extends AbstractFacade<SeaProvincia> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaProvinciaFacade() {
        super(SeaProvincia.class);
    }
     public List<SeaProvincia> findAllOrdenados(){
        return em.createQuery("select object(o) from SeaProvincia as o order by o.proNombre asc").getResultList();
       // return em.createQuery("select object(o) from SeaProvincia as o where o.proNombre <>'OTRA' and o.proNombre <>'EXTRANJERO'").getResultList();
    }
    public List<SeaProvincia> findProvincias(){
        List<SeaProvincia> result = null;
        Query query = em.createQuery("SELECT o FROM SeaProvincia o");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
        
    }
     
}
