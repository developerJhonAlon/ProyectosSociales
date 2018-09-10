/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
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
public class SeaRecursosConvocaFacade extends AbstractFacade<SeaRecursosConvoca> {

    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaRecursosConvocaFacade() {
        super(SeaRecursosConvoca.class);
    }

    public List<SeaRecursosConvoca> findTipoRecurso() {
        List<SeaRecursosConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaRecursosConvoca o  order by o.scpId asc");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }

    public BigDecimal getMaxSrcId() {
        
        Query query = em.createQuery("select max(o.srcId)+1 from SeaRecursosConvoca as o");
        Object object = query.getSingleResult();
        return (BigDecimal) object;
    }
}
