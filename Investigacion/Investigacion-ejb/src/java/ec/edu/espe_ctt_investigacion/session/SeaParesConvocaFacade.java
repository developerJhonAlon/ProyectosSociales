/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
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
public class SeaParesConvocaFacade extends AbstractFacade<SeaParesConvoca> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaParesConvocaFacade() {
        super(SeaParesConvoca.class);
    }
    
    public List<SeaParesConvoca> findByUsuario(BigDecimal codUsu){
        List<SeaParesConvoca> result = null;
        Query query =em.createQuery("SELECT o FROM SeaParesConvoca O WHERE o.usuId.usuId =:codUsu "
                + " and o.notaConceptual.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_INGRESO_PERFIL
                + "' and o.notaConceptual.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ELIMINADO
                + "' and o.notaConceptual.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_FINALIZADO_PERFIL
                + "' and o.notaConceptual.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_ACEPTADO_DIRECTOR_DEPARTAMENTO
                + "' and o.notaConceptual.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_RECHAZADO_DIRECTOR_DEPARTAMENTO
                + "' and o.notaConceptual.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_APROBADO_COMISION
                + "' and o.notaConceptual.datgeproyEstado != '" + SeaDatGeneralProy.ESTADO_RECHAZADO_COMISION
                + "' ");
        query.setParameter("codUsu", codUsu);
        result = query.getResultList();
        return result;
    }
  
    
    public SeaParesConvoca findByProyectoUsuario(BigDecimal idProyecto, BigDecimal idUsuario){
        Query query =em.createQuery("SELECT o FROM SeaParesConvoca O WHERE o.usuId.usuId =:idUsuario "
                + " and o.notaConceptual.datgeproyId =:idProyecto");
        query.setParameter("idUsuario", idUsuario);
        query.setParameter("idProyecto", idProyecto);
        List<SeaParesConvoca> result  = query.getResultList();
        if (!result.isEmpty()){
            return result.get(0);
        }
        return null;
    }


}

