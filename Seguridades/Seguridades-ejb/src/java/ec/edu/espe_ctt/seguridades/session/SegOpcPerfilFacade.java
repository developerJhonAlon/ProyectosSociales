/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.session;

import ec.edu.espe_ctt.seguridades.entity.SegOpcPerfil;
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
public class SegOpcPerfilFacade extends AbstractFacade<SegOpcPerfil> {
    @PersistenceContext(unitName = "Seguridades-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegOpcPerfilFacade() {
        super(SegOpcPerfil.class);
    }
    
    public List<SegOpcPerfil> findOpcionPerfil(){
         List<SegOpcPerfil> result = null;
         Query query = em.createQuery("SELECT o FROM SegOpcPerfil o");
         query.setHint("eclipselink.refresh",true);
         result = query.getResultList();
         return result == null || result.isEmpty() ? null : result;
     }
}
