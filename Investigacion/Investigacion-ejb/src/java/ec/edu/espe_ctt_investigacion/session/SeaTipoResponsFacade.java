/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaTipoRespons;
import java.math.BigDecimal;
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
public class SeaTipoResponsFacade extends AbstractFacade<SeaTipoRespons> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaTipoResponsFacade() {
        super(SeaTipoRespons.class);
    }
    
    public List<SeaTipoRespons> findTipoResponDocentePrograma(BigDecimal codForma){
        List<SeaTipoRespons> result = null;
        Query query = em.createQuery("SELECT o FROM SeaTipoRespons o WHERE o.tiformaId.tiformaId = :codForma ");
        query.setParameter("codForma", codForma);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result;
    }
    public SeaTipoRespons findTipoResponsabilidadByCodTipRes(BigDecimal codTipRes){
        List<SeaTipoRespons> result = null;
        Query query = em.createQuery("SELECT o FROM SeaTipoRespons o WHERE o.tipresId = :codTipRes ");
        query.setParameter("codTipRes", codTipRes);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    
    public List<SeaTipoRespons> findTipoResponDocenteProyecto(BigDecimal codForma){
        List<SeaTipoRespons> result = null;
        //Query query = em.createQuery("SELECT o FROM SeaTipoRespons o WHERE o.tiformaId.tiformaId = :codForma and o.tipresId not in (3,4)");
        Query query = em.createQuery("SELECT o FROM SeaTipoRespons o WHERE o.tiformaId.tiformaId = :codForma and o.tiformaId.tiformaId in (1) ORDER BY o.tipresDescrip");
        query.setParameter("codForma", codForma);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result;
    }    
    
    public List<SeaTipoRespons> findTipoResponComision(){
        List<SeaTipoRespons> result = null;
        Query query = em.createQuery("SELECT o FROM SeaTipoRespons o WHERE o.tiformaId.tiformaId = 4");        
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result;
    }        
}
