/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaDatGeneralProyFacade extends AbstractFacade<SeaDatGeneralProy> {

    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaDatGeneralProyFacade() {
        super(SeaDatGeneralProy.class);
    }

    public SeaDatGeneralProy findDatoProyectobyPro(BigDecimal codPro) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.datgeproyId =:codPro");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public SeaDatGeneralProy findCoberturabyPro(BigDecimal codPro) {
        List<SeaDatGeneralProy> result = null;
        Query q = em.createQuery("Select object(o) from SeaDatGeneralProy as o where o.datgeproyId =:codPro");
        q.setParameter("codPro", codPro);
        result = q.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public SeaDatGeneralProy findProyectoByConvocat(BigDecimal codConv) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.convocaId.convocaId =:codConv");
        query.setParameter("codConv", codConv);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public SeaDatGeneralProy findProyectoByCodConCodProy(BigDecimal codConv, BigDecimal codProy) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.convocaId.convocaId =:codConv AND o.datgeproyId =:codProy");
        query.setParameter("codConv", codConv);
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public List<String[]> findCalificacionProyectoByConvocat(BigDecimal codConv) {
        List<SeaDatGeneralProy> lstProy = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.convocaId.convocaId =:codConv");
        query.setParameter("codConv", codConv);
        query.setHint("eclipselink.refresh", true);
        lstProy = query.getResultList();
        int dimension = 2;
        List<String[]> lstCal = new ArrayList<>();
        for (SeaDatGeneralProy p : lstProy) {
            String[] e = new String[dimension];
            e[0] = "Titulo del Proyecto";
            e[1] = p.getDatgeproyTitulo();
            lstCal.add(e);

            e = new String[dimension];
            e[0] = "Resumen del Proyecto";
            e[1] = p.getDatgeproyResumen();
            lstCal.add(e);

            e = new String[dimension];
            e[0] = "Descripcion del Proyecto";
            e[1] = p.getDatgeproyDescrip();
            lstCal.add(e);

            e = new String[dimension];
            e[0] = "Consideraciones  del Proyecto";
            e[1] = p.getDatgeproyConsideraciones();
            lstCal.add(e);

            /*e = new String[dimension];
            e[0] = "Monitoreo y Evaluacion del Proyecto";
            e[1] = p.getDatgeproyMonitoreoEvalua();
            lstCal.add(e);*/

            e = new String[dimension];
            e[0] = "Consecuecias del Proyecto";
            e[1] = p.getDatgeproyConsecuencias();
            lstCal.add(e);

            e = new String[dimension];
            e[0] = "Transferencia de Resultados  del Proyecto";
            e[1] = p.getDatgeproyTransferResult();
            lstCal.add(e);

            e = new String[dimension];
            e[0] = "Impacto de Resultados del Proyecto";
            e[1] = p.getDatgeproyImpactoResult();
            lstCal.add(e);

            e = new String[dimension];
            e[0] = "Pagina Legal del Proyecto";
            e[1] = p.getDatgeproyPagilegNombre();
            lstCal.add(e);

        }
        return lstCal;
    }

    public SeaDatGeneralProy findDatProyByCodUsu(BigDecimal codUsu) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.usuId.usuId =:codUsu");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public List<SeaDatGeneralProy> findDatGenProyByCodUsu(BigDecimal codUsu) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.usuId.usuId =:codUsu "
                + " AND o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ELIMINADO
                + "'");
        query.setParameter("codUsu", codUsu);
        result = query.getResultList();
        return result;
    }

    public List<SeaDatGeneralProy> findDatGenProyByFormatoExtCodUsu(BigDecimal codUsu) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.usuId.usuId =:codUsu "
                //+ "AND o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_INGRESO_PERFIL 
                + " AND o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ELIMINADO
                //+ "' AND o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO 
                //+ "' AND o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO 
                //+ "' AND o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_RECHAZADO_COMISION 
                + "'");
        query.setParameter("codUsu", codUsu);
        result = query.getResultList();
        return result;
    }

    public SeaDatGeneralProy findDatProyByCodProy(BigDecimal codProy) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.datgeproyId =:codProy");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public List<SeaDatGeneralProy> findDatosProyectoByCodProy(BigDecimal codProy) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.datgeproyId =:codProy");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }

    public List<SeaDatGeneralProy> findDatosGeneralesByCoddUsu(BigDecimal codUsu) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.usuId.usuId =:codUsu");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }

    public SeaDatGeneralProy findProyectoByCodConCodUsu(BigDecimal codConv, BigDecimal codUsu) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.convocaId.convocaId =:codConv AND o.usuId.usuId =:codUsu");
        query.setParameter("codConv", codConv);
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public SeaDatGeneralProy findDatosGeneralesProyByCodUsuCodProy(BigDecimal codUsu, BigDecimal codProy) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.usuId.usuId =:codUsu AND o.datgeproyId =:codProy");
        query.setParameter("codUsu", codUsu);
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public List<SeaDatGeneralProy> findNotasConceptuales(
            String estado,
            BigDecimal idConvocatoria) {
        StringBuilder hql = new StringBuilder("SELECT o FROM SeaDatGeneralProy o WHERE 1=1 and o.datgeproyEstado !='" + SeaDatGeneralProy.ESTADO_ELIMINADO + "' ");
        if (estado != null && estado.equals("T")) { //terminadas
            hql.append(" AND o.datgeproyPagilegNombre is not null ");
        }
        if (idConvocatoria != null) {
            hql.append(" and o.convocaId.convocaId = :idConvocatoria");
        }

        Query query = em.createQuery(hql.toString());
        if (idConvocatoria != null) {
            query.setParameter("idConvocatoria", idConvocatoria);
        }
        return (query.getResultList());
    }

    public List<SeaDatGeneralProy> findByAsignacionParConvocatoria(BigDecimal idConvocatoria) {
        StringBuilder hql = new StringBuilder("SELECT o FROM SeaDatGeneralProy o WHERE 1=1 "
                + " and o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_INGRESO_PERFIL
                + "' and o.datgeproyEstado !='" + SeaDatGeneralProy.ESTADO_ELIMINADO
                + "' and o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_FINALIZADO_PERFIL
                + "' and o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO
                + "' and o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO
                + "' and o.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_RECHAZADO_COMISION
                + "' ");
        if (idConvocatoria != null) {
            hql.append(" and o.convocaId.convocaId = :idConvocatoria");
        }

        Query query = em.createQuery(hql.toString());
        if (idConvocatoria != null) {
            query.setParameter("idConvocatoria", idConvocatoria);
        }
        return (query.getResultList());
    }

    public List<SeaDatGeneralProy> findByAsignacionParUsuario(BigDecimal idUsuario) {
        StringBuilder hql = new StringBuilder("SELECT d FROM SeaComisionXConvoca o, SeaDatGeneralProy d  WHERE 1=1 ");
        hql.append(" and o.convocaId=d.convocaId and o.usuId.usuId =:idUsuario")
                .append(" and d.datgeproyEstado != '").append(SeaDatGeneralProy.ESTADO_INGRESO_PERFIL)
                .append("' and d.datgeproyEstado !='").append(SeaDatGeneralProy.ESTADO_ELIMINADO)
                .append("' and d.datgeproyEstado != '").append(SeaDatGeneralProy.ESTADO_FINALIZADO_PERFIL)
                .append("' and d.datgeproyEstado != '").append(SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO)
                .append("' and d.datgeproyEstado != '").append(SeaDatGeneralProy.ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO)
                .append("' and d.datgeproyEstado != '").append(SeaDatGeneralProy.ESTADO_RECHAZADO_COMISION)
                .append("' ");
        Query query = em.createQuery(hql.toString());
        query.setParameter("idUsuario", idUsuario);
        return (query.getResultList());
    }

    public List<SeaDatGeneralProy> findByEstado(Character estado) {
        String hql = "SELECT o FROM SeaDatGeneralProy o WHERE 1=1 and o.datgeproyEstado ='" + estado + "'";
        Query query = em.createQuery(hql);
        return (query.getResultList());
    }

    public List<SeaDatGeneralProy> findDatGenProyPagLegByCodProy(BigDecimal codProy) {
        List<SeaDatGeneralProy> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDatGeneralProy o WHERE o.datgeproyId =:codProy AND o.datgeproyPagilegNombre IS NOT NULL ");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizarProyectos(List<SeaDatGeneralProy> notaConceptualList) {
        for (SeaDatGeneralProy notaConceptual : notaConceptualList) {
            this.edit(notaConceptual);
        }
    }

}
