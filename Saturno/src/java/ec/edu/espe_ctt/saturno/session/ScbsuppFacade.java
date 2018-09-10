/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.saturno.session;

import ec.edu.espe_ctt.saturno.entity.Scbsupp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC1
 */
@Stateless
public class ScbsuppFacade extends AbstractFacade<Scbsupp> {
    @PersistenceContext(unitName = "SaturnoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ScbsuppFacade() {
        super(Scbsupp.class);
    }
    
}
