/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
import java.util.List;
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
public class SeaConvocaFacade extends AbstractFacade<SeaConvoca> {

    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaConvocaFacade() {
        super(SeaConvoca.class);
    }
    public List<SeaConvoca> findDatoConByIdConv(BigDecimal codCon){
        List<SeaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaConvoca o WHERE o.convocaId =:codCon");
        query.setParameter("codCon", codCon);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }

    public List<SeaConvoca> findSeaConvoca() {

        List<SeaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaConvoca o ");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();

        return result == null || result.isEmpty() ? null : result;
    }

    public List<SeaConvoca> findConvocatoria() {
        List<SeaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaConvoca o");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }

    public String findAnio() {
        System.out.println(" anio es ");
        Object fecha = em.createNativeQuery("SELECT TO_CHAR(SYSDATE,'YYYY') FROM DUAL")
                .getSingleResult();

        return fecha.toString();
    }

    public SeaConvoca findConvocaByIdConvoca(BigDecimal codConv) {
        List<SeaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaConvoca o WHERE o.convocaId =:codConv");
        query.setParameter("codConv", codConv);
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }

    public List<SeaConvoca> findConvocatoriaByUsuId(BigDecimal codUsu) {
        return em.createQuery("select con from SeaConvoca con,SeaComisionXConvoca com  where con.convocaId = com.convocaId.convocaId and com.usuId.usuId = :codUsu")
                .setHint("eclipse.link", true)
                .setParameter("codUsu", codUsu)
                .getResultList();
    }

    public List<SeaConvoca> findFinancimiento() {
        List<SeaConvoca> result = null;
        return result;

    }
    public SeaConvoca findConvocatByUsuId(BigDecimal codUsu) {
        List<SeaConvoca> result = null;
        Query query = em.createQuery("select con from SeaConvoca con,SeaComisionXConvoca com  where con.convocaId = com.convocaId.convocaId and com.usuId.usuId = :codUsu");
        query.setParameter("codUsu", codUsu);
        query.setHint("eclipselink.refresh",true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result.get(0);
    }
    public List<SeaConvoca> findDatosConvocatoria(){
        List<SeaConvoca> result = null;
        Query query = em.createQuery("SELECT o FROM SeaConvoca o ");
        query.setHint("eclipselink.refresh", true);
        result = query.getResultList();
        return result == null || result.isEmpty() ? null : result;
    }
    
    public List<SeaConvoca> findByUsuario(BigDecimal codUsuario) {
        Query query = em.createQuery("SELECT o.convocaId FROM SeaComisionXConvoca o where o.usuId.usuId =:codUsuario");
        query.setParameter("codUsuario", codUsuario);
        return query.getResultList();
    }

}
