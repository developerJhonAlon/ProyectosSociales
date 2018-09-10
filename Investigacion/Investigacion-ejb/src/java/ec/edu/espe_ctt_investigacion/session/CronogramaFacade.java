/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Cronograma;
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
public class CronogramaFacade extends AbstractFacade<Cronograma> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CronogramaFacade() {
        super(Cronograma.class);
    }
    
    public List<Cronograma> findFormatoCronogramaByFormatoLargo(BigDecimal codFormato){
        return em.createQuery("select o from CronogramaFacade as o where o.sflId.sflId = :codFormato ")
                .setHint("eclipse.link", true)
                .setParameter("codFormato", codFormato)
                .getResultList();
    }
    public List<Cronograma> findFormatoCronogramaByCodUsu(BigDecimal codUsu){
        List<Cronograma> result = null;
        Query query = em.createQuery("SELECT o FROM CronogramaFacade o WHERE o.sflId.datgeproyId.usuId.usuId =:codUsu ");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
