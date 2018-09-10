/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaComisionXConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
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
public class SeaComisionXConvocaFacade extends AbstractFacade<SeaComisionXConvoca> {

    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaComisionXConvocaFacade() {
        super(SeaComisionXConvoca.class);
    }

    public List<SeaComisionXConvoca> findComisionByConvocatoria(BigDecimal codConvoca) {
        return em.createQuery("select o from SeaComisionXConvoca as o where o.convocaId.convocaId = :codConvoca")
                .setHint("eclipse.link", true)
                .setParameter("codConvoca", codConvoca)
                .getResultList();
    }

    public List<SeaConvoca> findConvocatoriaByUsuario(BigDecimal idUsuario) {
        return em.createQuery("select o.convocaId from SeaComisionXConvoca as o where o.usuId.usuId = :codUsu")
                .setHint("eclipse.link", true)
                .setParameter("codUsu", idUsuario)
                .getResultList();
    }

    public List<SeaComisionXConvoca> findComisionByConvocatoriaAndTipoResponsabilidad(BigDecimal codConvoca, BigDecimal codTipoResponsabilidad) {
        return em.createQuery("select o from SeaComisionXConvoca as o where o.convocaId.convocaId = :codConvoca and o.tipresId.tipresId = :codTipoResponsabilidad")
                .setHint("eclipse.link", true)
                .setParameter("codConvoca", codConvoca)
                .setParameter("codTipoResponsabilidad", codTipoResponsabilidad)
                .getResultList();
    }

}
