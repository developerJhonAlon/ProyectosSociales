/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaTablaContenido;
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
public class SeaTablaContenidoFacade extends AbstractFacade<SeaTablaContenido> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaTablaContenidoFacade() {
        super(SeaTablaContenido.class);
    }
    public List<SeaTablaContenido> findTablaContenidoByCodFormL(BigDecimal codFormL){
        List<SeaTablaContenido> result = null;
        Query query = em.createQuery("SELECT o FROM SeaTablaContenido o WHERE o.sdpId.sflId.sflId =:codFormL");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
