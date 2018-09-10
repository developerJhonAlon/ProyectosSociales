package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaProceso;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaProcesoXConvocatoria.class)
public class SeaProcesoXConvocatoria_ { 

    public static volatile SingularAttribute<SeaProcesoXConvocatoria, BigDecimal> ppcId;
    public static volatile SingularAttribute<SeaProcesoXConvocatoria, Date> ppcFecifin;
    public static volatile SingularAttribute<SeaProcesoXConvocatoria, Date> ppcFecini;
    public static volatile SingularAttribute<SeaProcesoXConvocatoria, SeaProceso> seaProceso;
    public static volatile SingularAttribute<SeaProcesoXConvocatoria, BigInteger> ppcEstado;
    public static volatile SingularAttribute<SeaProcesoXConvocatoria, SeaConvoca> seaConvoca;

}