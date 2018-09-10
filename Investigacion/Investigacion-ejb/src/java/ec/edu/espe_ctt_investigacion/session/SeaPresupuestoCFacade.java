/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaPresupuestoC;
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
public class SeaPresupuestoCFacade extends AbstractFacade<SeaPresupuestoC> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaPresupuestoCFacade() {
        super(SeaPresupuestoC.class);
    }
    
    public List<SeaPresupuestoC> findPresupuestoByConvoca(BigDecimal codConv){
        List<SeaPresupuestoC> result = null;
        Query query = em.createQuery("SELECT o FROM SeaPresupuestoC o WHERE o.convocaId.convocaId =:codConv ORDER BY o.srcId.srcId");
        query.setParameter("codConv", codConv);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaPresupuestoC> findPresupuestoByCodConCodProy(BigDecimal codConv, BigDecimal codProy){
        List<SeaPresupuestoC> result = null;
        Query query = em.createQuery("SELECT o FROM SeaPresupuestoC o WHERE o.convocaId.convocaId =:codConv AND o.datgeproyId.datgeproyId =:codProy ORDER BY o.srcId.srcId");
        query.setParameter("codConv", codConv);
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public SeaPresupuestoC findRecursoPartidaByConvoca(BigDecimal codConv){
        List<SeaPresupuestoC> result = null;
        Query query = em.createQuery("SELECT o FROM SeaPresupuestoC o WHERE o.convocaId.convocaId =:codConv");
        query.setParameter("codConv", codConv);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<SeaPresupuestoC> findPartidasByConvocaRecurso(BigDecimal codConv, BigDecimal codRec){
        List<SeaPresupuestoC> result = null;
        Query query = em.createQuery("SELECT o FROM SeaPresupuestoC o WHERE o.convocaId.convocaId =:codConv AND o.srcId.srcId =:codRec");
        query.setParameter("codConv", codConv);
        query.setParameter("codRec", codRec);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    /*public List<SeaPresupuestoC> findPartidasByConvocaRecursoS(BigDecimal codConv, BigDecimal codRec){
        List<SeaPresupuestoC> result = null;
        Query query = em.createQuery("SELECT o FROM SeaPresupuestoC o WHERE o.convocaId.convocaId =:codConv AND o.srcId.srcId =:codRec");
        query.setParameter("codConv", codConv);
        query.setParameter("codRec", codRec);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }*/
    public List<SeaPresupuestoC> findPartidasByConvocaRecursoCodPre(BigDecimal codConv, BigDecimal codRec, BigDecimal codPre){
        List<SeaPresupuestoC> result = null;
        Query query = em.createQuery("SELECT o FROM SeaPresupuestoC o WHERE o.convocaId.convocaId =:codConv AND o.srcId.srcId =:codRec AND o.spcId not in (:codPre)");
        query.setParameter("codConv", codConv);
        query.setParameter("codRec", codRec);
        query.setParameter("codPre", codPre);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
}
