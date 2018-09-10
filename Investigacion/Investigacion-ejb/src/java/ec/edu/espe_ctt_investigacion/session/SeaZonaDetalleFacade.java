/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;


import ec.edu.espe_ctt_investigacion.entity.SeaZonaDetalle;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaZonaDetalleFacade extends AbstractFacade<SeaZonaDetalle> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaZonaDetalleFacade() {
        super(SeaZonaDetalle.class);
    }
    
    public SeaZonaDetalle findZonaByCobertura(BigDecimal codCober){
        List<SeaZonaDetalle> result = null;
        Query query = em.createQuery("SELECT o FROM SeaZonaDetalle O WHERE o.cobertId.cobertId =:codCober");
        query.setParameter("codCober", codCober);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0); 
    }
    public List<SeaZonaDetalle> findZonaDetalleByCobertura(BigDecimal codCober){
        List<SeaZonaDetalle> result = null;
        Query query = em.createQuery("SELECT o FROM SeaZonaDetalle O WHERE o.cobertId.cobertId =:codCober");
        query.setParameter("codCober", codCober);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result; 
    }
    public List<SeaZonaDetalle> findZonaDetalleByCoberturaOrdenado(BigDecimal codCober){
        List<SeaZonaDetalle> result = null;
        Query query = em.createQuery("SELECT o FROM SeaZonaDetalle o WHERE o.cobertId.cobertId =:codCober ORDER BY o.zopId asc");
        query.setParameter("codCober", codCober);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result; 
    }
}
