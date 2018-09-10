/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Sztainanex;
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
public class SztainanexFacade extends AbstractFacade<Sztainanex> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SztainanexFacade() {
        super(Sztainanex.class);
    }
    public List<Sztainanex> findByProyecto(BigDecimal codProyecto, Character tipoAnexo){
        List<Sztainanex> result = null;
        Query query = em.createQuery("SELECT o FROM Sztainanex o WHERE o.datgeproyId.datgeproyId =:codProyecto AND o.tipoAnexo =:tipoAnexo ");
         query.setParameter("codProyecto", codProyecto);
         query.setParameter("tipoAnexo", tipoAnexo);
         query.setHint("eclipselink.refresh", true);
         result = query.getResultList();
         return result == null || result.isEmpty() ? null : result;
    }
}
