/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.session;

import ec.edu.espe_ctt_investigacion.entity.ProgramacionAnualMes;
import ec.edu.espe_ctt_investigacion.entity.SeaMeses;
import ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC1
 */
@Stateless
public class SeaProgramaAnualFacade extends AbstractFacade<SeaProgramaAnual> {

    @PersistenceContext(unitName = "Investigacion-ejbPU")
    private EntityManager em;

    @EJB
    private SeaMesesFacade mesesFacade;
    @EJB
    private SeaProgramaAnualFacade programaAnualFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeaProgramaAnualFacade() {
        super(SeaProgramaAnual.class);
    }

    public List<SeaProgramaAnual> findProgramaAnualByFormatoCronograma(BigDecimal codCronograma) {
        return em.createQuery("select o from SeaProgramaAnual as o where o.sflId.sflId = :codCronograma")
                .setHint("eclipse.link", true)
                .setParameter("codCronograma", codCronograma)
                .getResultList();
    }

    public List<SeaProgramaAnual> findProgramaAnualByFormatoCronogramaAndMes(BigDecimal codCronograma, BigDecimal mes) {
        List<SeaProgramaAnual> lstPA
                = em.createQuery("select o from SeaProgramaAnual as o where o.sflId.sflId = :codCronograma and o.semeId.semeId = :mes")
                .setHint("eclipse.link", true)
                .setParameter("codCronograma", codCronograma)
                .setParameter("mes", mes)
                .getResultList();
        return lstPA;
    }

    public SeaProgramaAnual findProgramaAnualByFormatoCronogramaMesAndCriterio(BigDecimal codCronograma, BigDecimal codMes, BigDecimal codCriterio) {
        List<SeaProgramaAnual> lstPA
                = em.createQuery("select o from SeaProgramaAnual as o where o.sflId.sflId = :codCronograma and o.semeId.semeId = :codMes and o.scpId.scpId = :codCriterio")
                .setHint("eclipse.link", true)
                .setParameter("codCronograma", codCronograma)
                .setParameter("codMes", codMes)
                .setParameter("codCriterio", codCriterio)
                .getResultList();
        return lstPA == null || lstPA.isEmpty() ? new SeaProgramaAnual() : lstPA.get(0);
    }

    public List<ProgramacionAnualMes> findMesAndProgramaAnual(BigDecimal codCronograma) {
        List<ProgramacionAnualMes> lstPAM = new ArrayList<>();

        List<SeaMeses> lstMes = mesesFacade.findAll();
//        List<SeaProgramaAnual> lstPA = programaAnualFacade.findProgramaAnualByFormatoCronograma(codCronograma);

        for (SeaMeses m : lstMes) {
            ProgramacionAnualMes am = new ProgramacionAnualMes();
            am.setSeaMeses(m);

            List<SeaProgramaAnual> lstPA = this.findProgramaAnualByFormatoCronogramaAndMes(codCronograma, m.getSemeId());

            for (SeaProgramaAnual pa : lstPA) {
                if (pa.getSpanId() != null) {
                    switch (pa.getScpId().getScpId().intValueExact()) {
                        case 71:
                            am.setPartidaPerInver(pa.getSpanPartida());
                            am.setValorEspe(pa.getSpanVEspe());
                            am.setValorOtras(pa.getSpanOInstitu());
                            //am.setInversionPersonal(pa.getSpanTotal());//GASTOS EN PERSONAL PARA INVERSION
                            break;
                        case 73:
                            am.setPartidaBienSer(pa.getSpanPartida());
                            am.setValorEspeBienSer(pa.getSpanVEspe());
                            am.setValorOtrasBienSer(pa.getSpanOInstitu());
                            //am.setBienesYServicios(pa.getSpanTotal());//BIENES Y SERVICIOS PARA INVERSION
                            break;
                        case 75:
                            am.setPartidaObrasP(pa.getSpanPartida());
                            am.setValorEspeObrasP(pa.getSpanVEspe());
                            am.setValorOtrasObrasP(pa.getSpanOInstitu());
                            //am.setObrasPublicas(pa.getSpanTotal());//OBRAS PUBLICAS
                            break;
                        case 77:
                            am.setPartidaOtrosGastos(pa.getSpanPartida());
                            am.setValorEspeGastosIn(pa.getSpanVEspe());
                            am.setValorOtrasGastosIn(pa.getSpanOInstitu());
                            //am.setOtrosGastos(pa.getSpanTotal());//OTROS GASTOS DE INVERSION
                            break;
                        case 84:
                            am.setPartidaBienLargaD(pa.getSpanPartida());
                            am.setValorEspeLargaD(pa.getSpanVEspe());
                            am.setValorOtrasLargaD(pa.getSpanOInstitu());
                            //am.setBienesLargaDuracion(pa.getSpanTotal());//BIENES DE LARGA DURACION                            
                            break;
                    }
                }
            }
            lstPAM.add(am);
        }
        return lstPAM;
    }
}