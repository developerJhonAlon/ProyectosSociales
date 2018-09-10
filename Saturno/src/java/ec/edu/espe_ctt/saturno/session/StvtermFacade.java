/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.session;

import ec.edu.espe_ctt.saturno.entity.Stvterm;
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
public class StvtermFacade extends AbstractFacade<Stvterm> {
    @PersistenceContext(unitName = "SaturnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StvtermFacade() {
        super(Stvterm.class);
    }
    public Stvterm findPeriodoById(String codPeriodo){
    
    List<Stvterm> lstRes = null;
        lstRes = em.createQuery("select o from Stvterm as o where o.stvtermCode = :codPeriodo")
            .setHint("eclipselink.refresh", true)
            .setParameter("codPeriodo", codPeriodo)
            .getResultList();
        return lstRes==null || lstRes.isEmpty()?null: lstRes.get(0);
    }
    
    public List<Stvterm> findPeriodoEstadoActivo(){
        List<Stvterm> result = null;
        Query query = em.createQuery("SELECT object (p) FROM Stvterm as p,Sobterm as pd WHERE p.stvtermCode = pd.sobtermTermCode and pd.sobtermDynamicSchedTermInd ='Y' order by p.stvtermDesc");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result; 
    }
    public List<Stvterm> findPeriodoAereoEstadoActivo(){
        List<Stvterm> result = null;
        Query query = em.createQuery("SELECT object (p) FROM Stvterm as p,Sobterm as pd WHERE p.stvtermCode = pd.sobtermTermCode and pd.sobtermDynamicSchedTermInd ='Y' order by p.stvtermDesc");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result; 
    }    
    
    public List<Stvterm> findPerAcadeByEstadoActivo(){
        
        List<Stvterm> result = null;
        Query query = em.createQuery("SELECT object (p) FROM Stvterm as p,Sobterm as pd WHERE p.stvtermCode = pd.sobtermTermCode and pd.sobtermDynamicSchedTermInd ='Y'");        
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result; 
    }  
}
