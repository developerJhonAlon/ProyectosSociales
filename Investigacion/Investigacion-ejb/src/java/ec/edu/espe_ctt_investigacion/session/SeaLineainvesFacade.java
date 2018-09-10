/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
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
public class SeaLineainvesFacade extends AbstractFacade<SeaLineainves> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaLineainvesFacade() {
        super(SeaLineainves.class);
    }
    public List<SeaLineainves> findLineas(){
        List<SeaLineainves> result = null;
        Query query = em.createQuery("SELECT o FROM SeaLineainves o WHERE o.lineaIdPadre is null");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        
        return result == null || result.isEmpty() ? null : result;
    }
    
    public List<SeaLineainves> findSublinea(BigDecimal codLinea){
        List<SeaLineainves> result = null;
        Query query = em.createQuery("SELECT o FROM SeaLineainves o WHERE o.lineaIdPadre.lineaId =:codLinea ");
        query.setParameter("codLinea", codLinea);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaLineainves> findSublineaInvestiga(){
        List<SeaLineainves> result = null;
        Query query = em.createQuery("SELECT o FROM SeaLineainves o WHERE o.lineaIdPadre is not null");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaLineainves> findLineaSublinea(){
        System.out.println(" ingresa al select");
        List<SeaLineainves> result = null;
//        //Query query = em.createQuery("SELECT o FROM SeaLineainves o, SeaLineainves b WHERE b.lineaIdPadre.lineaId = o.lineaId AND o.lineaIdPadre IS NULL");
        Query query = em.createQuery("SELECT o FROM SeaLineainves o WHERE o.lineaIdPadre is null");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaLineainves> findSublineByLinea(BigDecimal codLinea){
        List<SeaLineainves> result = null;
        Query query = em.createQuery("SELECT o FROM SeaLineainves o WHERE o.lineaIdPadre.lineaId =:codLinea and o.lineaIdPadre is not null");
        query.setParameter("codLinea", codLinea);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public SeaLineainves findLineaByCodLin(BigDecimal codLin){
        List<SeaLineainves> result = null;
        Query query = em.createQuery("SELECT o FROM SeaLineainves o WHERE o.lineaId =:codLin");
        query.setParameter("codLin", codLin);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    
}
