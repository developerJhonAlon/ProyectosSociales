/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.VResponsablesProyecto;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC1
 */
@Stateless
public class VResponsablesProyectoFacade extends AbstractFacade<VResponsablesProyecto> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VResponsablesProyectoFacade() {
        super(VResponsablesProyecto.class);
    }
    
    public List<VResponsablesProyecto> findResponsablesByDatProy(BigDecimal codDatProy){
        return em.createQuery("select o from VResponsablesProyecto as o where o.datgeproyId = :codDatProy ")
                .setHint("eclipse.link", true)
                .setParameter("codDatProy", codDatProy)
                .getResultList();
    }
    
}
