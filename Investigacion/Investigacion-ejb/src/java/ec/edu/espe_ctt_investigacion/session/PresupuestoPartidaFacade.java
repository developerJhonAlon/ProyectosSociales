/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
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
public class PresupuestoPartidaFacade extends AbstractFacade<PresupuestoPartida> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoPartidaFacade() {
        super(PresupuestoPartida.class);
    }
    
    public List<PresupuestoPartida> findPrespuestoXPartidaByFormatoLargo(BigDecimal codFormato){
        System.out.println("codFormato " + codFormato);
        return em.createQuery("select o from SeaPresupuestoXPartida as o where o.sflId.sflId = :codFormato")
                .setHint("eclipse.link", true)
                .setParameter("codFormato", codFormato)
                .getResultList();
    }
    
}
