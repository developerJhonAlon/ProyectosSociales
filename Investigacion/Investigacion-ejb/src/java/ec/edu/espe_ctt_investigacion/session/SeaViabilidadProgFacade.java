/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaViabilidadProg;
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
public class SeaViabilidadProgFacade extends AbstractFacade<SeaViabilidadProg> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaViabilidadProgFacade() {
        super(SeaViabilidadProg.class);
    }
    
    public SeaViabilidadProg findViabilidadbyPro(BigDecimal codPro)
    {
        List<SeaViabilidadProg> result = null;
        Query q = em.createQuery("Select object(o) from SeaViabilidadProg as o where o.datgeprogId.datgeprogId =:codPro");
        q.setParameter("codPro", codPro);
       result = q.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);        
    }     
}
