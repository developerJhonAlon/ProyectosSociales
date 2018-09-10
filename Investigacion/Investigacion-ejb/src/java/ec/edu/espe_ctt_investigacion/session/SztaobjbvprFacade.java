/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Sztaobjbvpr;
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
public class SztaobjbvprFacade extends AbstractFacade<Sztaobjbvpr> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SztaobjbvprFacade() {
        super(Sztaobjbvpr.class);
    }
    public List<Sztaobjbvpr> findObjetivoBvPrByCodFormLargo (BigDecimal codForL){
        List<Sztaobjbvpr> result = null;
        Query query = em.createQuery("SELECT o FROM Sztaobjbvpr o WHERE o.sflId.sflId =:codForL");
        query.setParameter("codForL", codForL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<Sztaobjbvpr> findObjetivoIngByCodObj (BigDecimal codObj, BigDecimal codForL){
        List<Sztaobjbvpr> result = null;
        Query query = em.createQuery("SELECT o FROM Sztaobjbvpr o WHERE o.obplabvId.obplabvId =:codObj AND o.sflId.sflId =:codForL");
        query.setParameter("codObj", codObj);
        query.setParameter("codForL", codForL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
