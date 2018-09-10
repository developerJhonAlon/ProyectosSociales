package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaComisionXConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaEvaluaComisionConvoca.class)
public class SeaEvaluaComisionConvoca_ { 

    public static volatile SingularAttribute<SeaEvaluaComisionConvoca, SeaCriteriosEvalua> sceId;
    public static volatile SingularAttribute<SeaEvaluaComisionConvoca, BigDecimal> seccCalificacion;
    public static volatile SingularAttribute<SeaEvaluaComisionConvoca, Date> seccFechaEvalua;
    public static volatile SingularAttribute<SeaEvaluaComisionConvoca, BigDecimal> seccId;
    public static volatile SingularAttribute<SeaEvaluaComisionConvoca, SeaComisionXConvoca> scxcId;

}