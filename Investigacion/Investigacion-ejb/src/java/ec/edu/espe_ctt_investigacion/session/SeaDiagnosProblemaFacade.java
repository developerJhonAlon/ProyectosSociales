/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaDiagnosProblema;
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
public class SeaDiagnosProblemaFacade extends AbstractFacade<SeaDiagnosProblema> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaDiagnosProblemaFacade() {
        super(SeaDiagnosProblema.class);
    }
    public List<SeaDiagnosProblema> findDiagnosProblemByCodForLarg(BigDecimal codFlg){
        List<SeaDiagnosProblema> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDiagnosProblema o WHERE o.sflId.sflId =:codFlg");
        query.setParameter("codFlg", codFlg);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public SeaDiagnosProblema findDiagnosticoProblemByCodForLarg(BigDecimal codFlg){
        List<SeaDiagnosProblema> result = null;
        Query query = em.createQuery("SELECT o FROM SeaDiagnosProblema o WHERE o.sflId.sflId =:codFlg");
        query.setParameter("codFlg", codFlg);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
}
