/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.session;

import ec.edu.espe_ctt.saturno.entity.Stvmajr;
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
public class StvmajrFacade extends AbstractFacade<Stvmajr> {
    @PersistenceContext(unitName = "SaturnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StvmajrFacade() {
        super(Stvmajr.class);
    }
    public List<Stvmajr> findCarrera(){
        List<Stvmajr> result = null;
        Query query = em.createQuery("SELECT o FROM Stvmajr o order by o.stvmajrDesc");
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    public Stvmajr findCarreraByCodCar(String codCar){
        List<Stvmajr> result = null;
        Query query = em.createQuery("SELECT o FROM Stvmajr o WHERE o.stvmajrCode =:codCar");
        query.setParameter("codCar", codCar);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<Stvmajr> findByNombre(String nombre){
        Query query = em.createQuery("SELECT o FROM Stvmajr o WHERE UPPER(o.stvmajrDesc) LIKE :nombre");
        query.setParameter("nombre", "%" + nombre.toUpperCase() + "%");
        query.setHint("eclipselink.refresh",true);
        return query.getResultList();
    }
}
