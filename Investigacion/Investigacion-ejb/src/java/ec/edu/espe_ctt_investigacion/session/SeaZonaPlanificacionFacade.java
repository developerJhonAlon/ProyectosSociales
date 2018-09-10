/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaZonaPlanificacion;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaZonaPlanificacionFacade extends AbstractFacade<SeaZonaPlanificacion> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaZonaPlanificacionFacade() {
        super(SeaZonaPlanificacion.class);
    }
    
    public BigDecimal getMaxZopId(){
        Query query = em.createQuery("select max(o.zopId)+1 from SeaZonaPlanificacion o ");
        Object object= query.getSingleResult();
        return (BigDecimal)object;
    }
    
}
