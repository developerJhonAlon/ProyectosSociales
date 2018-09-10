/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Szdtaproglin;
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
public class SzdtaproglinFacade extends AbstractFacade<Szdtaproglin> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SzdtaproglinFacade() {
        super(Szdtaproglin.class);
    }
    public List<Szdtaproglin> findLineaProgByCodProg(BigDecimal codProg){
        List<Szdtaproglin> result = null;
        Query query = em.createQuery("SELECT o FROM Szdtaproglin o WHERE o.datgeprogId.datgeprogId =:codProg");
        query.setParameter("codProg", codProg);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
                
    }
}
