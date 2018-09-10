/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Szdtaproduproy;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class SzdtaproduproyFacade extends AbstractFacade<Szdtaproduproy> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SzdtaproduproyFacade() {
        super(Szdtaproduproy.class);
    }
    public List<Szdtaproduproy> findProducProyBydCodFormL(BigDecimal codFormL){
        List<Szdtaproduproy> result = null;
        Query query = em.createQuery("SELECT o FROM Szdtaproduproy o WHERE o.sflId.sflId =:codFormL ORDER BY o.szdtacantprodCode.szdtacantprodCode");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result;
    }
    
}
