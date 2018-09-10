/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
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
public class SeaClasificadorPresupFacade extends AbstractFacade<SeaClasificadorPresup> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaClasificadorPresupFacade() {
        super(SeaClasificadorPresup.class);
    }
    public List<SeaClasificadorPresup> findClasificadorByRecFis(){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o WHERE LENGTH(o.scpId)=6 AND SUBSTRING(o.scpId,1,1)= '6'");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaClasificadorPresup> findClasificadorByRecHum(){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o WHERE LENGTH(o.scpId)=6 AND SUBSTRING(o.scpId,1,1)= '5'");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaClasificadorPresup> findClasificadorByRecLogFis(){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o WHERE LENGTH(o.scpId)=6 AND SUBSTRING(o.scpId,1,1)= '7'");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaClasificadorPresup> findClasificadorByPrepupuesto(){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o WHERE o.scpId in (71,73,75,77,84)");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }  
    public List<SeaClasificadorPresup> findSubPartidaByCodCp (BigDecimal codCla){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o WHERE o.scpPadre.scpId =:codCla");
        query.setParameter("codCla", codCla);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaClasificadorPresup> findPartidaPrespByCodCp (BigDecimal codCla){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o WHERE o.scpPadre.scpId =:codCla");
        query.setParameter("codCla", codCla);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }
    public List<SeaClasificadorPresup> findClasificadorPadre(){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o WHERE o.scpPadre = NULL order by o.scpId");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    }    
    /*@Override
    public List<SeaClasificadorPresup> findAll(){
        List<SeaClasificadorPresup> result = null;
        Query query = em.createQuery("SELECT o FROM SeaClasificadorPresup o order by o.scpId");
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result;
    } */   
}
