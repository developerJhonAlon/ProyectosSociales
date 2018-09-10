/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaValorXCeConvoca;
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
public class SeaValorXCeConvocaFacade extends AbstractFacade<SeaValorXCeConvoca> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaValorXCeConvocaFacade() {
        super(SeaValorXCeConvoca.class);
    }
    public List<SeaValorXCeConvoca> findValorCeConvByCodConv(BigDecimal codCon){
        List<SeaValorXCeConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaValorXCeConvoca o WHERE o.convocaId.convocaId =:codCon");
        query.setParameter("codCon", codCon);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result;
    }
    public SeaValorXCeConvoca findValorXCeConvByCodIdConCodCon(BigDecimal codVCon,BigDecimal codCon){
        List<SeaValorXCeConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaValorXCeConvoca o WHERE o.sceId.sceId =:codVCon AND o.convocaId.convocaId =:codCon");
        query.setParameter("codVCon", codVCon);
        query.setParameter("codCon", codCon);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return  result == null|| result.isEmpty() ? null: result.get(0);
    }
}

