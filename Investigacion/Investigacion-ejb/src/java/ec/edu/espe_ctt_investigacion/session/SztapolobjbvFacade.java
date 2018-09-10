/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.Sztapolobjbv;
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
public class SztapolobjbvFacade extends AbstractFacade<Sztapolobjbv> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SztapolobjbvFacade() {
        super(Sztapolobjbv.class);
    }
    public List<Sztapolobjbv> findPoliticasByCodObj (BigDecimal codObj){
       List<Sztapolobjbv>  result = null;
       Query query = em.createQuery("SELECT o FROM Sztapolobjbv o WHERE o.sztaobjbvprCode.sztaobjbvprCode =:codObj");
       query.setParameter("codObj", codObj);
       query.setHint("eclipselink.refresh", true);
       result = query.getResultList();
       return result == null || result.isEmpty() ? null : result;
    }
}
