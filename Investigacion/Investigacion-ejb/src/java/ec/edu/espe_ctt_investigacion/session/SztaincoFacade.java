/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Sztainco;
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
public class SztaincoFacade extends AbstractFacade<Sztainco> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SztaincoFacade() {
        super(Sztainco.class);
    }
    public List<Sztainco> findAreasNotasCByCodProy(BigDecimal codProy){
        List<Sztainco> result = null;
        Query query = em.createQuery("SELECT o FROM Sztainco o WHERE o.datgeproyId.datgeproyId =:codProy");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public Sztainco findAreasIngresadasCByCodProyCodArea(BigDecimal codAre,BigDecimal codProy ){
        List<Sztainco> result = null;
        Query query = em.createQuery("SELECT o FROM Sztainco o WHERE o.sztaainvCode.sztaainvCode =:codAre AND o.datgeproyId.datgeproyId =:codProy");
        query.setParameter("codAre", codAre);
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    
}
