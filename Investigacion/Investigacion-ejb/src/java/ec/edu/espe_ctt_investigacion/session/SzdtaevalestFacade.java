/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Szdtaevalest;
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
public class SzdtaevalestFacade extends AbstractFacade<Szdtaevalest> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SzdtaevalestFacade() {
        super(Szdtaevalest.class);
    }
    public List<Szdtaevalest> findEvalEstByCodFormL(BigDecimal codFormL){
        List<Szdtaevalest> result = null;
        Query query = em.createQuery("SELECT o FROM Szdtaevalest o WHERE o.sflId.sflId =:codFormL");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refreh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result;
    }
}
