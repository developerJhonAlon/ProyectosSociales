/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.ConfiguracionParametrosEvaluacionInv;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class ConfiguracionParametrosEvaluacionInvFacade extends AbstractFacade<ConfiguracionParametrosEvaluacionInv> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConfiguracionParametrosEvaluacionInvFacade() {
        super(ConfiguracionParametrosEvaluacionInv.class);
    }
 
    public List<ConfiguracionParametrosEvaluacionInv> findXEvaluacionInicial() {
        return findXTipo(ConfiguracionParametrosEvaluacionInv.TIPO_EVALUACION_INICIAL);
    }
    public ConfiguracionParametrosEvaluacionInv findXEvaluacionInicialAndActivo() {
        return findXTipoAndActivo(ConfiguracionParametrosEvaluacionInv.TIPO_EVALUACION_INICIAL);
    }
    
    private List<ConfiguracionParametrosEvaluacionInv> findXTipo(Integer tipo) {
        Query query = em.createQuery("SELECT o FROM ConfiguracionParametrosEvaluacionInv o WHERE o.tipo = :tipo ");
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }   
    private ConfiguracionParametrosEvaluacionInv findXTipoAndActivo(Integer tipo) {
        List<ConfiguracionParametrosEvaluacionInv> result= null;
        Query query = em.createQuery("SELECT o FROM ConfiguracionParametrosEvaluacionInv o WHERE o.tipo = :tipo AND o.estado = 'A' ");
        query.setParameter("tipo", tipo);
        result = query.getResultList();
        if (result!=null && !result.isEmpty()){
            return result.get(0);
        }
        return null;
    }   
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void edit(ConfiguracionParametrosEvaluacionInv configuracionParametrosEvaluacion, boolean actualizarEstado){
        if (actualizarEstado){
            ConfiguracionParametrosEvaluacionInv conf = findXTipoAndActivo(configuracionParametrosEvaluacion.getTipo());
            if (conf!=null){
                conf.setEstado(ConfiguracionParametrosEvaluacionInv.ESTADO_INACTIVA);
                this.edit(conf);
            }
        }
        this.edit(configuracionParametrosEvaluacion);
    }
    @Override
    public void create(ConfiguracionParametrosEvaluacionInv configuracionParametrosEvaluacion){
        if (configuracionParametrosEvaluacion.getEstado().equals(ConfiguracionParametrosEvaluacionInv.ESTADO_ACTIVA)){
            ConfiguracionParametrosEvaluacionInv conf = findXTipoAndActivo(configuracionParametrosEvaluacion.getTipo());
            if (conf!=null){
                conf.setEstado(ConfiguracionParametrosEvaluacionInv.ESTADO_INACTIVA);
                this.edit(conf);
            }
        }
        super.create(configuracionParametrosEvaluacion);
    }
    
}
