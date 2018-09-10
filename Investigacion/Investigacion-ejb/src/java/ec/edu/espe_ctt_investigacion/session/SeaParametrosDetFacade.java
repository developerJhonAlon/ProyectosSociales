/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Transient;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaParametrosDetFacade extends AbstractFacade<SeaParametrosDet> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaParametrosDetFacade() {
        super(SeaParametrosDet.class);
    }
    public List<SeaParametrosDet> findTipoInves(){
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId = 93 and o.prdEstado='A' ");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
   
    public List<SeaParametrosDet> findTipoComision(){
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId = 95");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
    public List<SeaParametrosDet> findFaseComisionPar(){ 
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId = 94");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }  
    public List<SeaParametrosDet> findParamDetEstado(){ 
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId =96 ORDER BY o.prdId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    } 
    public List<SeaParametrosDet> findParamDetBieneServicios(){ 
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId = 97 ORDER BY o.prdId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    } 
    public List<SeaParametrosDet> findParamDetCategoProy(){ 
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId = 98 ORDER BY o.prdId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaParametrosDet> findParamDetTipoRecNotasC(){
        return em.createQuery("select o from SeaParametrosDet o where o.seaParametros.parId = 97 order by o.prdId")
                .setHint("eclipse.link", true)
                .getResultList();
    }
    public List<SeaParametrosDet> findParamDetEjecucion(){
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o WHERE o.seaParametros.parId = 99 order by o.prdId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
    public List<SeaParametrosDet> findByCodigoParametro(Long codParametro){ 
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId =" + codParametro + " order by o.prdOrden");
        return query.getResultList();
    } 
    public List<SeaParametrosDet> findByCodigoParametroActivos(Long codParametro){ 
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId =" + codParametro + " and o.prdEstado = 'A' order by o.prdOrden");
        return query.getResultList();
    } 
    
    public List<SeaParametrosDet> findParamObjProy(){
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o WHERE o.prdId in(302,303,304) order by o.prdId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
    public List<SeaParametrosDet> findParamTipoInvestigacion(){
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o WHERE o.prdId in(93) order by o.prdId");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result;
    }
    public List<SeaParametrosDet> findParametroEvaluacion(){ 
        List<SeaParametrosDet> result = null;
        Query query = em.createQuery("SELECT o FROM SeaParametrosDet o where o.seaParametros.parId = 113");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
    public Long getMaxPrdId(){
        Query query = em.createQuery("select max(d.prdId)+1 from SeaParametrosDet d");
        Object object = query.getSingleResult();
        if (object ==null) return 0L;
        return (Long)object;
    }
}
