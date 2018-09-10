/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.AprobacionDirectorDepartamento;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
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
public class AprobacionDirectorDepartamentoFacade extends AbstractFacade<AprobacionDirectorDepartamento> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AprobacionDirectorDepartamentoFacade() {
        super(AprobacionDirectorDepartamento.class);
    } 
    public List<AprobacionDirectorDepartamento> findNotasAprobadasByCodUsuCodProy(String codUsu, BigDecimal codProy){
        List<AprobacionDirectorDepartamento> result = null;
        Query query = em.createQuery("SELECT o FROM AprobacionDirectorDepartamento o WHERE o.usuario.usuCc =:codUsu AND o.notaConceptual.datgeproyId =:codProy");
        query.setParameter("codUsu", codUsu);
        query.setParameter("codProy", codProy);
        result = query.getResultList();
        return result ;
    }
    public List<AprobacionDirectorDepartamento> findNotasAprobadasByCodConv(BigDecimal codConv){
        List<AprobacionDirectorDepartamento> result = null;
        Query query = em.createQuery("SELECT o FROM AprobacionDirectorDepartamento o WHERE o.notaConceptual.convocaId.convocaId =:codConv AND o.estado='A'");
        query.setParameter("codConv", codConv);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result ;
    }
    public List<AprobacionDirectorDepartamento> findNotasAprobadasByCodProy(BigDecimal codProy){
        List<AprobacionDirectorDepartamento> result = null;
        Query query = em.createQuery("SELECT o FROM AprobacionDirectorDepartamento o WHERE o.notaConceptual.datgeproyId =:codProy AND o.estado ='A'");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result ;
    }
}
