/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupnc;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaTotalPresupncFacade extends AbstractFacade<SeaTotalPresupnc> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaTotalPresupncFacade() {
        super(SeaTotalPresupnc.class);
    }
    public List<SeaTotalPresupnc> findTotalPresupuestoByProyId(BigDecimal codProyecto){
        return em.createQuery("select o from SeaTotalPresupnc o where o.datgeproyId.datgeproyId = :codProyecto")
                .setHint("eclipse.link", true)
                .setParameter("codProyecto", codProyecto)
                .getResultList();
    }
    public int deleteTotalPresupuestoByProyId(BigDecimal codProyecto){
        return em.createQuery("DELETE FROM SeaTotalPresupnc o where o.datgeproyId.datgeproyId = :codProyecto")
                .setParameter("codProyecto", codProyecto)
                .executeUpdate();
    }    
    
}
