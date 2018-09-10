/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
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
public class ObjetivoProyectoFacade extends AbstractFacade<ObjetivoProyecto> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivoProyectoFacade() {
        super(ObjetivoProyecto.class);
    }
    public List<ObjetivoProyecto> findObjProyByCodFormL(BigDecimal codFormL){
        List<ObjetivoProyecto> result = null;
        Query query = em.createQuery("SELECT o FROM Szdtaobjproy o WHERE o.sflId.sflId =:codFormL AND o.szdtaobjproyPadre IS NULL ORDER BY o.szdtaobjproyCode");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<ObjetivoProyecto> findObjProyIndicByCodProy(BigDecimal codProy){
        List<ObjetivoProyecto> result = null;
        Query query = em.createQuery("SELECT o FROM Szdtaobjproy o WHERE o.szdtaobjproyPadre.szdtaobjproyCode =:codProy");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<ObjetivoProyecto> findTipObjProyCodFormL(BigDecimal codFormL){
        List<ObjetivoProyecto> result = null;
        Query query = em.createQuery("SELECT o FROM Szdtaobjproy o WHERE o.sflId.sflId =:codFormL AND o.prdId.prdId IN(303,304)");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<ObjetivoProyecto> findObjProyCodFormL(BigDecimal codFormL){
        List<ObjetivoProyecto> result = null;
        Query query = em.createQuery("SELECT o FROM Szdtaobjproy o WHERE o.sflId.sflId =:codFormL AND o.prdId.prdId =303");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
