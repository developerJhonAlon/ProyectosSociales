/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.SeaMatrizRiesgos;
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
public class SeaMatrizRiesgosFacade extends AbstractFacade<SeaMatrizRiesgos> {
    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaMatrizRiesgosFacade() {
        super(SeaMatrizRiesgos.class);
    }
    
    public List<SeaMatrizRiesgos> findMatrizRiesgosByCodCronograma(BigDecimal codCronograma){
        return em.createQuery("select o from SeaMatrizRiesgos as o where o.sfcrId.sfcrId = :codCronograma")
                .setHint("eclipse.link", true)
                .setParameter("codCronograma", codCronograma)
                .getResultList();        
    }
    
}
