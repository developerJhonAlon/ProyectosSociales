/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaSeguimientoFormato;
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
public class SeaSeguimientoFormatoFacade extends AbstractFacade<SeaSeguimientoFormato> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaSeguimientoFormatoFacade() {
        super(SeaSeguimientoFormato.class);
    }
    public SeaSeguimientoFormato findSeguimientoByCodFormL(BigDecimal codFrmL){
        List<SeaSeguimientoFormato> result = null;
        Query query = em.createQuery("SELECT o FROM SeaSeguimientoFormato o WHERE o.sflId.sflId =:codFrmL");
        query.setParameter("codFrmL", codFrmL);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public SeaSeguimientoFormato findSeguimientoFormatoByCodSeg(BigDecimal codSeg){
        List<SeaSeguimientoFormato> result = null;
        Query query = em.createQuery("SELECT o FROM SeaSeguimientoFormato o WHERE o.ssefId =:codSeg");
        query.setParameter("codSeg", codSeg);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<SeaSeguimientoFormato> findSeguimientoFormato(){
        List<SeaSeguimientoFormato> result = null;
        Query query = em.createQuery("SELECT o FROM SeaSeguimientoFormato o WHERE o.ssfeEstado ='T' and o.ssfeRevisado ='S'");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
   
}
