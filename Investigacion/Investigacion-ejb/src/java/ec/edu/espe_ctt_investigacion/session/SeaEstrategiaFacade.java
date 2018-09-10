/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaEstrategia;
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
public class SeaEstrategiaFacade extends AbstractFacade<SeaEstrategia> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaEstrategiaFacade() {
        super(SeaEstrategia.class);
    }
    public List<SeaEstrategia> findEstrategia(){
        List<SeaEstrategia> result = null;
        Query query = em.createQuery("SELECT o FROM SeaEstrategia o where o.estrategIdPadre is null");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaEstrategia> findEstrategiaByEstrat(BigDecimal codEst){
        List<SeaEstrategia> result = null;
        Query query = em.createQuery("SELECT o FROM SeaEstrategia o WHERE o.estrategIdPadre.estrategId =:codEst AND o.estrategIdPadre is not null");
        query.setParameter("codEst", codEst);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
