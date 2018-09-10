/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaInformeDirectorFormato;
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
public class SeaInformeDirectorFormatoFacade extends AbstractFacade<SeaInformeDirectorFormato> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaInformeDirectorFormatoFacade() {
        super(SeaInformeDirectorFormato.class);
    }
    public List<SeaInformeDirectorFormato> findTipoEjByCodTipoCodSeg(BigDecimal codTipo, BigDecimal codSeg){
        List<SeaInformeDirectorFormato> result= null;
        Query query = em.createQuery("SELECT o FROM SeaInformeDirectorFormato o WHERE o.prdId.prdId =:codTipo AND o.ssefId.ssefId =:codSeg");
        query.setParameter("codTipo", codTipo);
        query.setParameter("codSeg", codSeg);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null ||result.isEmpty() ? null: result;
    }
    public List<SeaInformeDirectorFormato> findInformeDirectorByCodSeg(BigDecimal codSeg){
        List<SeaInformeDirectorFormato> result= null;
        Query query = em.createQuery("SELECT o FROM SeaInformeDirectorFormato o WHERE o.ssefId.ssefId =:codSeg");
        query.setParameter("codSeg", codSeg);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null ||result.isEmpty() ? null: result;
    }
    
}
