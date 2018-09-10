/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
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
public class SeaResponsableProgFacade extends AbstractFacade<SeaResponsableProg> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaResponsableProgFacade() {
        super(SeaResponsableProg.class);
    }
        public List<SeaResponsableProg> findRespProgByUsu(BigDecimal codUsu){        
        List<SeaResponsableProg> result = null;
        Query q = em.createQuery("select object(o)from SeaResponsableProg as o where o.usuIdDocente.usuId =:codUsu");
        //Query q = em.createQuery("select object(o)from SeaResponsableProg as o where o.docId.usuId.usuId = :codUsu");
        //Query q = em.createQuery("select object(o)from SeaResponsableProg as o where o.datgeprogId = :codPro");
        q.setParameter("codUsu", codUsu);
        //q.setParameter("codPro", codPro);
        result = q.getResultList();
        return result;                
    }    

    public List<SeaResponsableProg> findRespProgByDatPro(BigDecimal codPro){        
        List<SeaResponsableProg> result = null;        
        Query q = em.createQuery("select object(o)from SeaResponsableProg as o where o.datgeprogId.datgeprogId = :codPro and o.tipresId.tiformaId.tiformaId = 2");
        //Query q = em.createQuery("select object(o)from SeaResponsableProg as o where o.datgeprogId = :codPro");
        q.setParameter("codPro", codPro);
        //q.setParameter("codPro", codPro);
        result = q.getResultList();
        return result;                
    }     
    public List<SeaResponsableProg> findRespProyByDatPro(BigDecimal codPro){  
        System.out.println("codPro " + codPro);
        List<SeaResponsableProg> result = null;        
        //Query q = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.datgeproyId.datgeproyId =:codPro AND o.tipresId.tipresId =1");
        Query q = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.datgeproyId.datgeproyId =:codPro");
        //Query q = em.createQuery("select object(o)from SeaResponsableProg as o where o.datgeprogId = :codPro");
        q.setParameter("codPro", codPro);
        result = q.getResultList();
        return result;                
    }   
    public List<SeaResponsableProg> findOrdenResProyectoByCodPro(BigDecimal codPro){
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.datgeproyId.datgeproyId =:codPro ORDER BY o.resprogOrden");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaResponsableProg> findResponsableProyByCodPro(BigDecimal codPro){
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.datgeproyId.datgeproyId =:codPro ORDER BY o.resprogOrden");
        query.setParameter("codPro", codPro);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public List<SeaResponsableProg> findNotasConceptualesByCodUsu(String codUsu){
        System.out.println("codUsu " + codUsu);
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.usuIdDocente.usuCc =:codUsu AND o.tipresId.tipresId in(3,4)");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result;
    }
    public SeaResponsableProg findCodigoProyectoByCodResp(String codUsu){
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.usuIdDocente.usuCc =:codUsu");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result.get(0);
    }
    public SeaResponsableProg findCodigoProyectoByCodRespCodProy(String codUsu, BigDecimal codProy){
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.usuIdDocente.usuCc =:codUsu AND o.datgeproyId.datgeproyId =:codProy");
        query.setParameter("codUsu", codUsu);
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result.get(0);
    }
    public SeaResponsableProg findResponsableProyByCodProy(BigDecimal codProy){
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.datgeproyId.datgeproyId =:codProy AND o.tipresId.tipresId = 3");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result.get(0);
    }
    public List<SeaResponsableProg> findResponsableProyectoByCodProy(BigDecimal codProy){
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.datgeproyId.datgeproyId =:codProy AND o.tipresId.tipresId = 3");
        query.setParameter("codProy", codProy);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result;
    }
    public SeaResponsableProg findResponsableProgByCodUsu(BigDecimal codUsu){
        List<SeaResponsableProg> result = null;
        Query query = em.createQuery("SELECT o FROM SeaResponsableProg o WHERE o.usuIdDocente.usuId =:codUsu");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null: result.get(0);
    }
  
}
