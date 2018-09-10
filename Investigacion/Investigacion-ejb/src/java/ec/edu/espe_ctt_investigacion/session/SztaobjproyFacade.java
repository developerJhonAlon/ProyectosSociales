/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Sztaobjproy;
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
public class SztaobjproyFacade extends AbstractFacade<Sztaobjproy> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SztaobjproyFacade() {
        super(Sztaobjproy.class);
    }
    public List<Sztaobjproy> findObjProyByCodFormL(BigDecimal codFormL){
        List<Sztaobjproy> result = null;
         Query query = em.createQuery("SELECT o FROM Sztaobjproy o WHERE o.sflId.sflId =:codFormL AND o.sztaobjproyPadre IS NULL ORDER BY o.sztaobjproyCode");
         query.setParameter("codFormL", codFormL);
         query.setHint("eclipselink.refresh", true);
         result = query.getResultList();
         return result == null || result.isEmpty() ? null : result;
    }
    public List<Sztaobjproy> findObjProyIndicByCodProy(BigDecimal codProy){
        List<Sztaobjproy> result = null;
        Query query = em.createQuery("SELECT o FROM Sztaobjproy o WHERE o.sztaobjproyPadre.sztaobjproyCode =:codProy");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<Sztaobjproy> findTipObjProyCodFormL(BigDecimal codFormL){
        List<Sztaobjproy> result = null;
        Query query = em.createQuery("SELECT o FROM Sztaobjproy o WHERE o.sflId.sflId =:codFormL AND o.prdId.prdId IN(303,304)");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
