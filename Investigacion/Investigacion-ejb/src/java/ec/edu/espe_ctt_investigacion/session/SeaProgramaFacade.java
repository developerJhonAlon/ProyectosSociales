/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaPrograma;
import java.math.BigDecimal;
import java.util.List;
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
public class SeaProgramaFacade extends AbstractFacade<SeaPrograma> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaProgramaFacade() {
        super(SeaPrograma.class);
    }
    public List<SeaPrograma> findPrograma(){
        List<SeaPrograma> result = null;
        Query query = em.createQuery("SELECT o FROM SeaPrograma o ORDER BY o.progId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
//    public SeaPrograma findCoberturabyPro(BigDecimal codPro)
//    {
//        List<SeaPrograma> result = null;
//        Query q = em.createQuery("Select object(o) from SeaPrograma as o where o.progId =:codPro");
//        q.setParameter("codPro", codPro);
//       result = q.getResultList();
//        return result == null || result.isEmpty() ? null : result.get(0);        
//    }    
    
}
