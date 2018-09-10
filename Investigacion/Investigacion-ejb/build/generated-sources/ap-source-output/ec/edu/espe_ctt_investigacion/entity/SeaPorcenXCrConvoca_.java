package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaPorcenXCrConvoca.class)
public class SeaPorcenXCrConvoca_ { 

    public static volatile SingularAttribute<SeaPorcenXCrConvoca, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<SeaPorcenXCrConvoca, SeaConvoca> convocaId;
    public static volatile SingularAttribute<SeaPorcenXCrConvoca, SeaCriteriosEvalua> sceId;
    public static volatile SingularAttribute<SeaPorcenXCrConvoca, BigInteger> spxccPorcentaje;
    public static volatile SingularAttribute<SeaPorcenXCrConvoca, BigDecimal> spxccId;

}