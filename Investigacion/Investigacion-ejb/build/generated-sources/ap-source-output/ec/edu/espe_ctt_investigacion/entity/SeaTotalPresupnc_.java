package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaAnio;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaTotalPresupnc.class)
public class SeaTotalPresupnc_ { 

    public static volatile SingularAttribute<SeaTotalPresupnc, BigDecimal> stpnId;
    public static volatile SingularAttribute<SeaTotalPresupnc, BigDecimal> stpnPorcentaje;
    public static volatile SingularAttribute<SeaTotalPresupnc, BigDecimal> stpnTotalOtros;
    public static volatile SingularAttribute<SeaTotalPresupnc, SeaAnio> saniId;
    public static volatile SingularAttribute<SeaTotalPresupnc, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaTotalPresupnc, SeaRecursosConvoca> srcId;
    public static volatile SingularAttribute<SeaTotalPresupnc, BigDecimal> stpnTotalEspe;

}