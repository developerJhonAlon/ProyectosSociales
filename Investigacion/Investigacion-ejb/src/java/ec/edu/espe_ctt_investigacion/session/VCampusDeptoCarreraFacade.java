/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.VCampusDeptoCarrera;
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
public class VCampusDeptoCarreraFacade extends AbstractFacade<VCampusDeptoCarrera> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VCampusDeptoCarreraFacade() {
        super(VCampusDeptoCarrera.class);
    }
    public List<VCampusDeptoCarrera> findCentroRespByCampus(String codCamp){
        List<VCampusDeptoCarrera> result = null;
        Query query = em.createQuery("SELECT o FROM VCampusDeptoCarrera o WHERE o.stvcampCode =:codCamp ORDER BY o.stvsubjDesc");
        query.setParameter("codCamp", codCamp);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public VCampusDeptoCarrera findDeptCarreraByCodId(BigDecimal codId){
        List<VCampusDeptoCarrera> result = null;
        Query query = em.createQuery("SELECT o FROM VCampusDeptoCarrera o WHERE o.id =:codId");
        query.setParameter("codId", codId);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    /*
    
        
        
        
        
        
    }
    */
}
