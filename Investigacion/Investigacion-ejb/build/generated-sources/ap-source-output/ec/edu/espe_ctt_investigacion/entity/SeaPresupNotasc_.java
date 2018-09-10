package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaAnio;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaPresupNotasc.class)
public class SeaPresupNotasc_ { 

    public static volatile SingularAttribute<SeaPresupNotasc, BigDecimal> spncTotal;
    public static volatile SingularAttribute<SeaPresupNotasc, BigDecimal> spncOtros;
    public static volatile SingularAttribute<SeaPresupNotasc, Date> spncFechaCrea;
    public static volatile SingularAttribute<SeaPresupNotasc, SeaAnio> saniId;
    public static volatile SingularAttribute<SeaPresupNotasc, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaPresupNotasc, BigDecimal> spncEspe;
    public static volatile SingularAttribute<SeaPresupNotasc, SeaRecursosConvoca> srcId;
    public static volatile SingularAttribute<SeaPresupNotasc, String> spncRubro;
    public static volatile SingularAttribute<SeaPresupNotasc, BigDecimal> spncId;

}