/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.session;

import ec.edu.espe_ctt.saturno.entity.Sfrstcr;
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
public class SfrstcrFacade extends AbstractFacade<Sfrstcr> {
    @PersistenceContext(unitName = "SaturnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SfrstcrFacade() {
        super(Sfrstcr.class);
    }
    
    public List<Sfrstcr> buscarXCedNomApe(String cedula, String nombres, String apellidos)
    {
        Query query = em.createQuery("SELECT o FROM Sfrstcr o where o.usuario.usuCc =: cedula AND UPPER(o.usuario.usuApellidos) like: nombres AND UPPER(o.usuario.usuNombres) like: nombres");
        query.setParameter("cedula", cedula);
        query.setParameter("nombres", "%" +  nombres.toUpperCase() + "%");
        query.setParameter("apellidos", "%" + apellidos.toUpperCase() + "%");
        return query.getResultList();
    }
}
