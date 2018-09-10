/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.VDocenteInvestigacion;
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
public class VDocenteInvestigacionFacade extends AbstractFacade<VDocenteInvestigacion> {

    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VDocenteInvestigacionFacade() {
        super(VDocenteInvestigacion.class);
    }

    
    public List<VDocenteInvestigacion> findDocente() {
        List<VDocenteInvestigacion> result = null;
        Query query = em.createQuery("SELECT o FROM VDocenteInvestigacion o order by o.usuApellidos");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }

    public List<VDocenteInvestigacion> findInvestigadorByName(String nombres) {
        List<VDocenteInvestigacion> lstUsu;
//        nombres="";        
        StringBuilder sb = new StringBuilder("select u from VDocenteInvestigacion as u where ");
//        em.createQuery("select u from SegUsuario as u where concat(u.usuApellidos,' ', u.usuNombres) like :nombres ");

        if (nombres.isEmpty()) {
            sb.append(" u.usuId < 1000 ");
        } else {
            sb.append(" CONCAT (u.usuApellidos, ' ', u.usuNombres) like :nombres ");
        }

        sb.append(" order by u.usuApellidos asc, u.usuNombres asc");
        Query result = em.createQuery(sb.toString()).setHint("eclipse.link", true);
        if (!nombres.isEmpty()) {
            result.setParameter("nombres", nombres.toUpperCase() + "%");
        }
        lstUsu = result.getResultList();
        return lstUsu;
    }
    public List<VDocenteInvestigacion> findDocentInvestigadorByName(String nombres) {
        List<VDocenteInvestigacion> lstUsu;
        StringBuilder sb = new StringBuilder("select u from VDocenteInvestigacion as u where ");
        if (nombres.isEmpty()) {
            sb.append(" u.usuId < 1000 ");
        } else {
            sb.append(" CONCAT (u.usuApellidos, ' ', u.usuNombres) like :nombres ");
        }

        sb.append(" order by u.usuApellidos asc, u.usuNombres asc");
        Query result = em.createQuery(sb.toString()).setHint("eclipse.link", true);
        if (!nombres.isEmpty()) {
            result.setParameter("nombres", nombres.toUpperCase() + "%");
        }
        lstUsu = result.getResultList();
        return lstUsu;
    }

}
