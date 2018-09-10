/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
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
public class SeaDatGeneralProgFacade extends AbstractFacade<SeaDatGeneralProg> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaDatGeneralProgFacade() {
        super(SeaDatGeneralProg.class);
    }
    
     public SeaDatGeneralProg findCoberturabyPro(BigDecimal codPro)
    {
        List<SeaDatGeneralProg> result = null;
        Query q = em.createQuery("Select object(o) from SeaDatGeneralProg as o where o.datgeprogId =:codPro");
        q.setParameter("codPro", codPro);
        result = q.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);        
    } 
    
       public List<SeaDatGeneralProg> findActivos()
    {
        List<SeaDatGeneralProg> result = null;
        Query q = em.createQuery("Select object(o) from SeaDatGeneralProg as o ");       
        result = q.getResultList();
        return result == null || result.isEmpty() ? null : result;        
    } 
     public List<SeaDatGeneralProg> findPrograma(){
         List<SeaDatGeneralProg> result= null;
         Query query = em.createQuery("SELECT o FROM SeaDatGeneralProg o");
         result = query.getResultList();
         return result == null || result.isEmpty() ? null : result;     
     }
    
    
}
