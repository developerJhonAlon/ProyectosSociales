package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvtops;
import ec.edu.espe_ctt_investigacion.entity.Cronograma;
import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaAreacUnesco;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaObjEntregables;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupAnual;
import ec.edu.espe_ctt_investigacion.entity.Sztaobjbvpr;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaFormatoLargo.class)
public class SeaFormatoLargo_ { 

    public static volatile SingularAttribute<SeaFormatoLargo, Stvtops> stvtopsCode;
    public static volatile SingularAttribute<SeaFormatoLargo, BigDecimal> sflPresupEntidadAuspicia;
    public static volatile SingularAttribute<SeaFormatoLargo, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<SeaFormatoLargo, SeaAreacUnesco> sacuId;
    public static volatile SingularAttribute<SeaFormatoLargo, BigDecimal> sflPresupEspe;
    public static volatile ListAttribute<SeaFormatoLargo, Cronograma> cronogramaList;
    public static volatile SingularAttribute<SeaFormatoLargo, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaFormatoLargo, String> sflTituloIngles;
    public static volatile SingularAttribute<SeaFormatoLargo, String> sflNombreFinan;
    public static volatile SingularAttribute<SeaFormatoLargo, Date> sflFechaPresenta;
    public static volatile SingularAttribute<SeaFormatoLargo, String> bibliografia;
    public static volatile ListAttribute<SeaFormatoLargo, SeaTotalPresupAnual> seaTotalPresupAnualList;
    public static volatile ListAttribute<SeaFormatoLargo, ObjetivoProyecto> objetivoList;
    public static volatile SingularAttribute<SeaFormatoLargo, BigDecimal> sflId;
    public static volatile SingularAttribute<SeaFormatoLargo, String> sflTituloEspaniol;
    public static volatile ListAttribute<SeaFormatoLargo, SeaObjEntregables> entregableList;
    public static volatile SingularAttribute<SeaFormatoLargo, Date> sflFechaFinaliza;
    public static volatile SingularAttribute<SeaFormatoLargo, SeaParametrosDet> prdIdCategoria;
    public static volatile ListAttribute<SeaFormatoLargo, Sztaobjbvpr> objetivoBuenVivirList;
    public static volatile SingularAttribute<SeaFormatoLargo, BigDecimal> sflPresupRiesgo;
    public static volatile ListAttribute<SeaFormatoLargo, SeaProgramaAnual> seaProgramaAnualList;
    public static volatile SingularAttribute<SeaFormatoLargo, Date> sflFechaInicio;
    public static volatile SingularAttribute<SeaFormatoLargo, String> sflMetodologia;
    public static volatile SingularAttribute<SeaFormatoLargo, byte[]> sflDigiFinan;
    public static volatile SingularAttribute<SeaFormatoLargo, BigDecimal> sflPresupTotal;

}