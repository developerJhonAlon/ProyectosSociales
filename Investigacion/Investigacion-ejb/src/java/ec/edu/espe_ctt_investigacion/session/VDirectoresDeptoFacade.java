/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.VDirectoresDepto;
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
public class VDirectoresDeptoFacade extends AbstractFacade<VDirectoresDepto> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VDirectoresDeptoFacade() {
        super(VDirectoresDepto.class);
    }
    public VDirectoresDepto findByUsuario(BigDecimal codUsu){
        List<VDirectoresDepto> result = null;
        Query query = em.createQuery("SELECT o FROM VDirectoresDepto o WHERE o.usuId =:codUsu");
        query.setParameter("codUsu", codUsu);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<VDirectoresDepto> findDirectorDepartoByCodUsu(BigDecimal codUsu){
        List<VDirectoresDepto> result = null;
        Query query = em.createQuery("SELECT o FROM VDirectoresDepto o WHERE o.usuId =:codUsu");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}

