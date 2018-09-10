/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.VDirectFormatoLargo;
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
public class VDirectFormatoLargoFacade extends AbstractFacade<VDirectFormatoLargo> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VDirectFormatoLargoFacade() {
        super(VDirectFormatoLargo.class);
    }
    public List<VDirectFormatoLargo> findFormatoLargo(BigDecimal idConvocatoria) {
        List<VDirectFormatoLargo> result = null;
        String hql = "SELECT o FROM VDirectFormatoLargo o ";
        if (idConvocatoria!=null){
            hql+=" where o.convocaId = " + idConvocatoria;
        }
        Query query = em.createQuery(hql);
        result = query.getResultList();
        return result== null || result.isEmpty() ? null : result;
    }
}
