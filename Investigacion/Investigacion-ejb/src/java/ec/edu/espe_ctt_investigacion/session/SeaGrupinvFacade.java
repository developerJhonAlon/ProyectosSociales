/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaGrupinv;
import ec.edu.espe_ctt_investigacion.session.AbstractFacade;
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
public class SeaGrupinvFacade extends AbstractFacade<SeaGrupinv> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaGrupinvFacade() {
        super(SeaGrupinv.class);
    }
    public List<SeaGrupinv> findGrupoInvestiga(){
       List<SeaGrupinv> result = null;
       Query query = em.createQuery("SELECT o FROM SeaGrupinv o");
       query.setHint("eclipselink.refresh",true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
    }
    
}
