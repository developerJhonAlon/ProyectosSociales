/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaCobertura;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaCoberturaFacade extends AbstractFacade<SeaCobertura> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaCoberturaFacade() {
        super(SeaCobertura.class);
    }
    
    public SeaCobertura findCoberturaByPro(BigDecimal codPro)
    {
        List<SeaCobertura> result = null;
        Query q = em.createQuery("Select object(o) from SeaCobertura as o where o.datgeprogId.datgeprogId = :codPro");
        q.setParameter("codPro", codPro);
       result = q.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);        
    }
    public SeaCobertura findLocalidadByProy(BigDecimal codPro){
        List <SeaCobertura> result= null;
        Query query = em.createQuery("SELECT o FROM SeaCobertura o WHERE o.datgeproyId.datgeproyId =:codPro");
        query.setParameter("codPro", codPro);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);    
    }
    public List<SeaCobertura> findCoberturaByProy(BigDecimal codPro){
        List <SeaCobertura> result= null;
        Query query = em.createQuery("SELECT o FROM SeaCobertura o WHERE o.datgeproyId.datgeproyId =:codPro");
        query.setParameter("codPro", codPro);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;    
    }
    public List<Object> findDatosCoberturaByCodPro(BigDecimal codPro) {
        String sql = "SELECT SEA_ZONA_PLANIFICACION.ZOP_NOMBRE_LARGO AS ZONA, "
                + "SEA_LOCALIZA.LOCAL_DESCRIP AS LOCALIDAD, "
                + "SEA_PROVINCIA.PRO_NOMBRE AS PROVINCIA, "
                + "SEA_CANTON.CAN_NOMBRE AS CANTON "
                + "FROM SEA_COBERTURA, SEA_ZONA_DETALLE, SEA_ZONA_PLANIFICACION,"
                + "SEA_LOCALIZA, "
                + "SEA_PROVINCIA, SEA_CANTON  "
                + "WHERE (SEA_COBERTURA.LOCAL_ID = SEA_LOCALIZA.LOCAL_ID) AND "
                + "(SEA_ZONA_DETALLE.COBERT_ID(+) = SEA_COBERTURA.COBERT_ID) AND "
                + "(SEA_ZONA_DETALLE.ZOP_ID = SEA_ZONA_PLANIFICACION.ZOP_ID(+)) AND "
                + "(SEA_ZONA_DETALLE.PRO_ID = SEA_PROVINCIA.PRO_ID(+))  AND "
                + "(SEA_ZONA_DETALLE.CAN_ID = SEA_CANTON.CAN_ID(+))  AND "
                + "(SEA_COBERTURA.DATGEPROY_ID = ?)  "
                + "ORDER BY SEA_COBERTURA.LOCAL_ID ASC";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, codPro);
        List<Object> results = query.getResultList();
        return results;
    }
}
