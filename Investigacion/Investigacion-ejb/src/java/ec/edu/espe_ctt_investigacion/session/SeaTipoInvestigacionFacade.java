/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaTipoInvestigacion;
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
public class SeaTipoInvestigacionFacade extends AbstractFacade<SeaTipoInvestigacion> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaTipoInvestigacionFacade() {
        super(SeaTipoInvestigacion.class);
    }
    public List<SeaTipoInvestigacion> findTipologia(){
        List<SeaTipoInvestigacion> result = null;
        Query query = em.createQuery("SELECT o FROM SeaTipoInvestigacion o");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
}
