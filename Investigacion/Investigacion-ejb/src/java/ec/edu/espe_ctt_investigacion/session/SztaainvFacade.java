/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Sztaainv;
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
public class SztaainvFacade extends AbstractFacade<Sztaainv> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SztaainvFacade() {
        super(Sztaainv.class);
    }
    public List<Sztaainv> findAreasInvestiga(){
        List<Sztaainv> result = null;
        Query query = em.createQuery("SELECT o FROM Sztaainv o ORDER BY o.sztaainvCode");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
