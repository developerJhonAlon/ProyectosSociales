/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupAnual;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaTotalPresupAnualFacade extends AbstractFacade<SeaTotalPresupAnual> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaTotalPresupAnualFacade() {
        super(SeaTotalPresupAnual.class);
    }
    
//    public SeaTotalPresupAnual findTotalByFormatoLargo(BigDecimal codFormato){
//        return em.createQuery("select o from SeaTotalPresupAnual as o where o.")
//    }
    
}
