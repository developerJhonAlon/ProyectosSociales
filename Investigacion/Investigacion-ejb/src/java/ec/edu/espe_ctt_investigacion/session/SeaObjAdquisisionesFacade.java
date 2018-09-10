/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaObjAdquisisiones;
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
public class SeaObjAdquisisionesFacade extends AbstractFacade<SeaObjAdquisisiones> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaObjAdquisisionesFacade() {
        super(SeaObjAdquisisiones.class);
    }
    public List<SeaObjAdquisisiones> findObjAdquisicionesByCodEntr(BigDecimal codEntr){
        List<SeaObjAdquisisiones> result = null;
        Query query = em.createQuery("SELECT o FROM SeaObjAdquisisiones o WHERE o.soeId.soeId =:codEntr");
        query.setParameter("codEntr", codEntr);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null || result.isEmpty() ? null : result;
    }   
}
