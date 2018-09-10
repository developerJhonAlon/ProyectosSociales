/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaAnalisisFormato;
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
public class SeaAnalisisFormatoFacade extends AbstractFacade<SeaAnalisisFormato> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaAnalisisFormatoFacade() {
        super(SeaAnalisisFormato.class);
    }
    public SeaAnalisisFormato findAnalisiFormatoByCodForml(BigDecimal codFormL){
        List<SeaAnalisisFormato> result = null;
        Query query=em.createQuery("SELECT o FROM SeaAnalisisFormato o WHERE o.sflId.sflId =:codFormL");
        query.setParameter("codFormL", codFormL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }    
}
