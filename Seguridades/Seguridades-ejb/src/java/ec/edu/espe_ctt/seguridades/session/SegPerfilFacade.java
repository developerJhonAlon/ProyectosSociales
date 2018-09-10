/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.session;

import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
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
public class SegPerfilFacade extends AbstractFacade<SegPerfil> {
    @PersistenceContext(unitName = "Seguridades-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegPerfilFacade() {
        super(SegPerfil.class);
    }
    public List<SegPerfil> findPerfilSistema(){
        List<SegPerfil> result = null;
        Query query =em.createQuery("SELECT o FROM SegPerfil o ORDER BY o.segSistemas.sisNombre asc,o.perNombre asc");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SegPerfil> findPerfilBySistema(BigDecimal codSistema){
        return em.createQuery("select p from SegPerfil as p where p.segSistemas.sisId = :codSistema")
                .setHint("eclipselink.refresh", true)
                .setParameter("codSistema", codSistema)
                .getResultList();
    }
     public String getNombrePerfil(BigDecimal codigoSistema, BigDecimal codigoUsuario) {
        List<SegPerfil> lstRes = em.createQuery("select p from SegPerfil as p,SegUsuPerfil up,SegUsuario u where p.perId = up.segPerfil.perId and u.usuId =  up.segUsuario.usuId and p.segSistemas.sisId = :codigoSistema and u.usuId = :codigoUsuario")
                .setHint("eclipselink.refresh", true)
                .setParameter("codigoUsuario", codigoUsuario)
                .setParameter("codigoSistema", codigoSistema)
                .getResultList();
        return lstRes == null || lstRes.isEmpty()? "":lstRes.get(0).getPerNombre();
    }
    
}
