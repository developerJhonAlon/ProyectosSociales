/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaObjetivosFormato;
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
public class SeaObjetivosFormatoFacade extends AbstractFacade<SeaObjetivosFormato> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaObjetivosFormatoFacade() {
        super(SeaObjetivosFormato.class);
    }
    public List<SeaObjetivosFormato> findObjetivoFormatoByCodFormL( BigDecimal codFormL){
        List<SeaObjetivosFormato> result = null;
        Query query = em.createQuery("SELECT o FROM SeaObjetivosFormato o WHERE o.sflId.sflId =:codFormL");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaObjetivosFormato> findObjetivoFormatoByCodProy(BigDecimal codProy){
        List<SeaObjetivosFormato> result = null;
        Query query = em.createQuery("SELECT o FROM SeaObjetivosFormato o WHERE o.sflId.sflId =:codProy");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public SeaObjetivosFormato findObjetivosFormatoByCodProy(BigDecimal codProy){
        List<SeaObjetivosFormato> result = null;
        Query query = em.createQuery("SELECT o FROM SeaObjetivosFormato o WHERE o.sflId.sflId =:codProy");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    
}
