/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.seguridades.session;

import ec.edu.espe_ctt.seguridades.entity.SegOpcion;
import java.math.BigDecimal;
import java.util.Date;
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
public class SegOpcionFacade extends AbstractFacade<SegOpcion> {

    @PersistenceContext(unitName = "Seguridades-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegOpcionFacade() {
        super(SegOpcion.class);
    }

    public List<SegOpcion> listaOpciones(BigDecimal codigoSistema, BigDecimal codigoUsuario) {
        StringBuilder sb = new StringBuilder("select distinct object(o)");
        sb.append(" from  SegOpcPerfil as op,  SegOpcion as o, SegUsuPerfil as up where ");
        sb.append(" op.segOpcion.opcId = o.opcId and op.segPerfil.perId = up.segPerfil.perId ");
        sb.append(" and o.segSistemas.sisId = :codigoSistema and op.oppActInact = 1 ");
        sb.append(" and up.segUsuario.usuId = :codigoUsuario and o.segOpcion is null ");
        sb.append(" order by o.opcOrden");
        Query q = em.createQuery(sb.toString()).setHint("eclipselink.refresh", true);
        q.setParameter("codigoUsuario", codigoUsuario);
        q.setParameter("codigoSistema", codigoSistema);

        return q.getResultList();
    }

    public List<SegOpcion> listaOpcionesHijo(BigDecimal codigoSistema, BigDecimal codigoUsuario) {
        StringBuilder sb = new StringBuilder("select distinct object(o)");
        sb.append(" from  SegOpcPerfil as op,  SegOpcion as o, SegUsuPerfil as up where ");
        //sb.append(" op.segOpcion.opcId = o.opcId and op.segPerfil.perId = up.segPerfil.perId and CURRENT_DATE between COALESCE(FUNC('TRUNC',up.uspFechaIni),CURRENT_DATE) and COALESCE(FUNC('TRUNC',up.uspFechaFin),CURRENT_DATE)");
        sb.append(" op.segOpcion.opcId = o.opcId and op.segPerfil.perId = up.segPerfil.perId and :fechaActual between COALESCE(FUNC('TRUNC',up.uspFechaIni), :fechaActual) and COALESCE(FUNC('TRUNC',up.uspFechaFin), :fechaActual)");
        sb.append(" and o.segSistemas.sisId = :codigoSistema and op.oppActInact = 1 ");
        sb.append(" and up.segUsuario.usuId = :codigoUsuario and o.segOpcion is not null ");
        sb.append(" order by o.opcOrden");
        Query q = em.createQuery(sb.toString()).setHint("eclipselink.refresh", true);
        q.setParameter("fechaActual", new Date());
        q.setParameter("codigoUsuario", codigoUsuario);
        q.setParameter("codigoSistema", codigoSistema);

        return q.getResultList();
    }

    public List<SegOpcion> listaOpcionesPapaPerfil(BigDecimal codigoPapa, BigDecimal codigoSistema, BigDecimal codigoUsuario) {
        StringBuilder sb = new StringBuilder("select distinct object(o)");
        sb.append(" from  SegOpcPerfil as op,  SegOpcion as o, SegUsuPerfil as up where ");
        sb.append(" op.segOpcion.opcId = o.opcId and op.segPerfil.perId = up.segPerfil.perId ");
        sb.append(" and o.segSistemas.sisId = :codigoSistema and op.oppActInact = 1 and CURRENT_DATE between COALESCE(FUNC('TRUNC',up.uspFechaIni),CURRENT_DATE) and COALESCE(FUNC('TRUNC',up.uspFechaFin),CURRENT_DATE)");
        sb.append(" and up.segUsuario.usuId = :codigoUsuario and o.segOpcion.opcId = :codigoPapa ");
        sb.append(" order by o.opcOrden");

        Query q = em.createQuery(sb.toString()).setHint("eclipselink.refresh", true);
        q.setParameter("codigoUsuario", codigoUsuario);
        q.setParameter("codigoSistema", codigoSistema);
        q.setParameter("codigoPapa", codigoPapa);
        // return q.getResultList();  
        return q.getResultList();

    }

    public List<SegOpcion> listaOpciones() {
        return em.createQuery("select o from SegOpcion as o where o.segOpcion IS NOT NULL order by o.opcNombre,o.segSistemas.sisNombre,o.opcOrden")
                .setHint("eclipselink.refresh", true)
                .getResultList();
    }

    public List<SegOpcion> listaOpcionesPadreHijo() {
        return em.createQuery("select o from SegOpcion as o order by o.opcNombre,o.segSistemas.sisNombre,o.opcOrden")
                .setHint("eclipselink.refresh", true)
                .getResultList();
    }

    public List<SegOpcion> listaOpcionesPorPadre(BigDecimal codOpcionPadre) {
        return em.createQuery("select o from SegOpcion as o where o.segOpcion.opcId = :codOpcionPadre")
                .setHint("eclipselink.refresh", true)
                .setParameter("codOpcionPadre", codOpcionPadre)
                .getResultList();
    }

    public List<SegOpcion> listaOpcionesPadre() {
        return em.createQuery("select o from SegOpcion as o where o.segOpcion IS NULL order by o.opcNombre,o.segSistemas.sisNombre")
                .setHint("eclipselink.refresh", true)
                .getResultList();
    }

    public List<SegOpcion> listaOpcionesPadreSistema(BigDecimal codSistema) {
        return em.createQuery("select o from SegOpcion as o where o.segOpcion IS NULL and o.segSistemas.sisId = :codSistema order by o.opcNombre,o.segSistemas.sisNombre")
                .setHint("eclipselink.refresh", true)
                .setParameter("codSistema", codSistema)
                .getResultList();
    }

    public List<SegOpcion> listaOpcionesHijoSistemaUsuario(BigDecimal codSistema, BigDecimal codigoUsuario) {
        return em.createQuery("select o from SegOpcion as o where o.segOpcion IS NOT NULL and o.segSistemas.sisId = :codSistema and o order by o.opcNombre,o.segSistemas.sisNombre")
                .setHint("eclipselink.refresh", true)
                .setParameter("codSistema", codSistema)
                .getResultList();
    }
}
