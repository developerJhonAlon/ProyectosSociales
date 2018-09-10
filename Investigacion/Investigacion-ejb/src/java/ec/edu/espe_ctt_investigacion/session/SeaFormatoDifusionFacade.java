/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaFormatoDifusion;
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
public class SeaFormatoDifusionFacade extends AbstractFacade<SeaFormatoDifusion> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaFormatoDifusionFacade() {
        super(SeaFormatoDifusion.class);
    }
    public List<SeaFormatoDifusion> findFormatoDifuByCodFDif(BigDecimal codFDif){
        List<SeaFormatoDifusion> result = null;
        Query query = em.createQuery("SELECT o FROM SeaFormatoDifusion o WHERE o.sfdeId.sfdeId =:codFDif");
        query.setParameter("codFDif", codFDif);
        query.setHint("eclipselink.refresh", true);
        result =query.getResultList();
        return  result == null|| result.isEmpty() ? null : result;
    }
}
