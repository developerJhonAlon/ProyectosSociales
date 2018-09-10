/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaLocaliza;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaLocalizaFacade extends AbstractFacade<SeaLocaliza> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaLocalizaFacade() {
        super(SeaLocaliza.class);
    }
    
    public List<SeaLocaliza> findLocalizaByOrden(){
        return em.createQuery("select object (o) from SeaLocaliza as o order by o.localOrden asc")
                .setHint("eclipselink.refresh", true)
                .getResultList();
        
        
    }
    
}
