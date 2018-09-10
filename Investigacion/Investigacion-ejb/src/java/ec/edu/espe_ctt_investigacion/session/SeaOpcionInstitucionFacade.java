/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaOpcionInstitucion;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
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
public class SeaOpcionInstitucionFacade extends AbstractFacade<SeaOpcionInstitucion> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaOpcionInstitucionFacade() {
        super(SeaOpcionInstitucion.class);
    }
    public List<SeaOpcionInstitucion> findOpcionInstitucion(BigDecimal codPro){
        List<SeaOpcionInstitucion> result = null;
        //Query query = em.createQuery("SELECT o FROM SeaOpcionInstitucion o WHERE o.datgeproyId.datgeproyId  =:codPro");
        Query query = em.createQuery("SELECT o FROM SeaOpcionInstitucion o WHERE o.datgeprogId.datgeprogId =:codPro");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public SeaOpcionInstitucion findOpcionInstitucionByPro(BigDecimal codPro){
        List<SeaOpcionInstitucion> result = null;
        Query query = em.createQuery("SELECT o FROM SeaOpcionInstitucion o WHERE o.datgeproyId.datgeproyId =:codPro");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    
    public List<SeaOpcionInstitucion> findOrdenByProyecto(BigDecimal codPro){
        List<SeaOpcionInstitucion> result = null;
        Query query = em.createQuery("SELECT o FROM SeaOpcionInstitucion o WHERE o.datgeproyId.datgeproyId =:codPro ORDER BY o.opinstiOrden");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
    /*
    public String findOrdenByProyecto(BigDecimal codPro){
        System.out.println("ingresa al select");
        String sql = "SELECT  max(SEA_OPCION_INSTITUCION.OPINSTI_ORDEN),"
                + "SEA_OPCION_INSTITUCION.OPINSTI_ID,"
                + "SEA_OPCION_INSTITUCION.OPINSTI_NOMBRE,"
                + "SEA_OPCION_INSTITUCION.OPINSTI_FECHA_CREA, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_DIRECCION,"
                + "SEA_OPCION_INSTITUCION.OPINSTI_CIUDAD, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_TELEFONO, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_PAGUINA_WEB, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_MAIL, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_FAX, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_REPRESENTA_LEGAL, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_CEDULA_RL, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_ORGANO_EJECUTOR, "
                + "SEA_OPCION_INSTITUCION.DATGEPROY_ID, "
                + "SEA_OPCION_INSTITUCION.DATGEPROG_ID "
                + "FROM SEA_OPCION_INSTITUCION "
                + "WHERE  SEA_OPCION_INSTITUCION.DATGEPROY_ID =" + codPro + " "
                + "group by "
                + "SEA_OPCION_INSTITUCION.OPINSTI_ID, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_NOMBRE,"
                + "SEA_OPCION_INSTITUCION.OPINSTI_FECHA_CREA, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_DIRECCION, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_CIUDAD, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_TELEFONO, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_PAGUINA_WEB, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_MAIL, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_FAX, "
                + "SEA_OPCION_INSTITUCION.OPINSTI_REPRESENTA_LEGAL,"
                + "SEA_OPCION_INSTITUCION.OPINSTI_CEDULA_RL,"
                + "SEA_OPCION_INSTITUCION.OPINSTI_ORGANO_EJECUTOR,"
                + "SEA_OPCION_INSTITUCION.DATGEPROY_ID,"
                + "SEA_OPCION_INSTITUCION.DATGEPROG_ID";
        Query query = em.createNativeQuery(sql);
        BigInteger result = (BigInteger) query.getSingleResult();
        System.out.println("result " + result.toString());
        return  result.toString();
    }*/
    public List<SeaOpcionInstitucion> findOpcionInstitucionByCodPro(BigDecimal codPro){
        List<SeaOpcionInstitucion> result = null;
        Query query = em.createQuery("SELECT o FROM SeaOpcionInstitucion o WHERE o.datgeproyId.datgeproyId  =:codPro");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
}
