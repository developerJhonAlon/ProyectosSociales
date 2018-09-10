/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.seguridades.session;

import ec.edu.espe_ctt.seguridades.entity.SegPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuPerfil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.primefaces.model.SortOrder;

/**
 *
 * @author PC1
 */
@Stateless
public class SegUsuPerfilFacade extends AbstractFacade<SegUsuPerfil> {

    @PersistenceContext(unitName = "Seguridades-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUsuPerfilFacade() {
        super(SegUsuPerfil.class);
    }

    public SegUsuPerfil findPerfilByUser(SegUsuario usu, BigDecimal sistema) {

        System.out.println("verificando perfil de usuario");
        System.out.println("codigoSistema: " + sistema);
        System.out.println("codigoUsuario: " + usu.getUsuId());
        List<SegUsuPerfil> l;
        Query query = em.createQuery("select object(u) from SegUsuPerfil as u, SegPerfil as p"
                + " where u.segPerfil.perId=p.perId and p.segSistemas.sisId = :codigoSistema and u.uspFechaFin is null "
                + " and u.segUsuario.usuId=:codigoUsuario")
                .setParameter("codigoUsuario", usu.getUsuId())
                .setParameter("codigoSistema", sistema)
                .setHint("eclipselink.refresh", true);
        l = query.getResultList();
        if (!l.isEmpty()) {
            System.out.println("SegUsuPerfil encontrado");
            return l.get(0);
        } else {
            System.out.println("SegUsuPerfil No encontrado");
            return null;
        }
    }

    public List<SegUsuPerfil> findPerfilesByUser(SegUsuario usu, BigDecimal sistema) {

        System.out.println("verificando perfil de usuario");
        System.out.println("codigoSistema: " + sistema);
        System.out.println("codigoUsuario: " + usu.getUsuId());
        List<SegUsuPerfil> l;
        Query query = em.createQuery("select object(u) from SegUsuPerfil as u, SegPerfil as p"
                + " where u.segPerfil.perId=p.perId and p.segSistemas.sisId = :codigoSistema and u.uspFechaFin is null "
                + " and u.segUsuario.usuId=:codigoUsuario")
                .setParameter("codigoUsuario", usu.getUsuId())
                .setParameter("codigoSistema", sistema)
                .setHint("eclipselink.refresh", true);
        l = query.getResultList();
        if (!l.isEmpty()) {
            System.out.println("SegUsuPerfil encontrado");
            return l;
        } else {
            System.out.println("SegUsuPerfil No encontrado");
            return null;
        }
    }

    public List<SegPerfil> findPerfilesByUsuario(SegUsuario usu, BigDecimal sistema) {

        System.out.println("verificando perfil de usuario");
        System.out.println("codigoSistema: " + sistema);
        System.out.println("codigoUsuario: " + usu.getUsuId());
        List<SegPerfil> l;
        Query query = em.createQuery("select distinct object(p) from SegUsuPerfil as u, SegPerfil as p"
                + " where u.segPerfil.perId=p.perId and p.segSistemas.sisId = :codigoSistema and u.uspFechaFin is null "
                + " and u.segUsuario.usuId=:codigoUsuario")
                .setParameter("codigoUsuario", usu.getUsuId())
                .setParameter("codigoSistema", sistema)
                .setHint("eclipselink.refresh", true);
        l = query.getResultList();
        if (!l.isEmpty()) {
            System.out.println("SegUsuPerfil encontrado");
            return l;
        } else {
            System.out.println("SegUsuPerfil No encontrado");
            return null;
        }
    }

    public List<SegUsuPerfil> findPerfilByUserAndPerfil(BigDecimal codUsu, BigDecimal codPer) {
        List<SegUsuPerfil> result
                = em.createQuery("select up from SegUsuPerfil as up where up.segUsuario.usuId = :codUsu AND up.segPerfil.perId = :codPer")
                .setHint("eclipselink.refresh", true)
                .setParameter("codUsu", codUsu)
                .setParameter("codPer", codPer)
                .getResultList();
        return result;
    }

    public List<SegUsuPerfil> findByPaginacion(
            int first,
            int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters
    ) {
        StringBuilder hql = new StringBuilder("SELECT o FROM SegUsuPerfil o WHERE 1=1 ");
        String filtroSistema = (String) filters.get("segPerfil.segSistemas.sisNombre");
        String filtroPerfil = (String) filters.get("segPerfil.perNombre");
        String filtroCedula = (String) filters.get("segUsuario.usuCc");
        String filtroNombres = (String) filters.get("segUsuario.usuNombres");
        String filtroApellidos = (String) filters.get("segUsuario.usuApellidos");
        if (filtroSistema != null) {
            hql.append("and upper(o.segPerfil.segSistemas.sisNombre) like :sistema ");
        }
        if (filtroPerfil != null) {
            hql.append("and upper(o.segPerfil.perNombre) like :perfil ");
        }
        if (filtroCedula != null) {
            hql.append("and upper(o.segUsuario.usuCc) like :cedula ");
        }
        if (filtroNombres != null) {
            hql.append("and upper(o.segUsuario.usuNombres) like :nombres ");
        }
        if (filtroApellidos != null) {
            hql.append("and upper(o.segUsuario.usuApellidos) like :apellidos ");
        }

        if (sortField != null) {
            hql.append(" order by o.").append(sortField).append(" ").append((sortOrder.equals(SortOrder.ASCENDING) ? "ASC" : "DESC"));
        }
        Query query = em.createQuery(hql.toString()).setFirstResult(first).setMaxResults(pageSize);
        if (filtroSistema != null) {
            query.setParameter("sistema", "%" + filtroSistema.trim().toUpperCase() + "%");
        }
        if (filtroPerfil != null) {
            query.setParameter("perfil", "%" + filtroPerfil.trim().toUpperCase() + "%");
        }
        if (filtroCedula != null) {
            query.setParameter("cedula", "%" + filtroCedula.trim() + "%");
        }
        if (filtroNombres != null) {
            query.setParameter("nombres", "%" + filtroNombres.trim().toUpperCase() + "%");
        }
        if (filtroApellidos != null) {
            query.setParameter("apellidos", "%" + filtroApellidos.trim().toUpperCase() + "%");
        }

        return query.getResultList();
    }

    public int count(Map<String, Object> filters) {
        StringBuilder hql = new StringBuilder("SELECT count(o) FROM SegUsuPerfil o WHERE 1=1 ");
        String filtroSistema = (String) filters.get("segPerfil.segSistemas.sisNombre");
        String filtroPerfil = (String) filters.get("segPerfil.perNombre");
        String filtroCedula = (String) filters.get("segUsuario.usuCc");
        String filtroNombres = (String) filters.get("segUsuario.usuNombres");
        String filtroApellidos = (String) filters.get("segUsuario.usuApellidos");
        if (filtroSistema != null) {
            hql.append("and upper(o.segPerfil.segSistemas.sisNombre) like :sistema ");
        }
        if (filtroPerfil != null) {
            hql.append("and upper(o.segPerfil.perNombre) like :perfil ");
        }
        if (filtroCedula != null) {
            hql.append("and upper(o.segUsuario.usuCc) like :cedula ");
        }
        if (filtroNombres != null) {
            hql.append("and upper(o.segUsuario.usuNombres) like :nombres ");
        }
        if (filtroApellidos != null) {
            hql.append("and upper(o.segUsuario.usuApellidos) like :apellidos ");
        }

        TypedQuery<Long> query = em.createQuery(hql.toString(), Long.class);

        if (filtroSistema != null) {
            query.setParameter("sistema", "%" + filtroSistema.trim().toUpperCase() + "%");
        }
        if (filtroPerfil != null) {
            query.setParameter("perfil", "%" + filtroPerfil.trim().toUpperCase() + "%");
        }
        if (filtroCedula != null) {
            query.setParameter("cedula", "%" + filtroCedula.trim() + "%");
        }
        if (filtroNombres != null) {
            query.setParameter("nombres", "%" + filtroNombres.trim().toUpperCase() + "%");
        }
        if (filtroApellidos != null) {
            query.setParameter("apellidos", "%" + filtroApellidos.trim().toUpperCase() + "%");
        }
        return query.getSingleResult().intValue();
    }
}
