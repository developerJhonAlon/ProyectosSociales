package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupuestoC;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaFinanciaConvoca.class)
public class SeaFinanciaConvoca_ { 

    public static volatile SingularAttribute<SeaFinanciaConvoca, SeaConvoca> convocaId;
    public static volatile SingularAttribute<SeaFinanciaConvoca, BigInteger> sfcPorcentaje;
    public static volatile SingularAttribute<SeaFinanciaConvoca, SeaRecursosConvoca> srcId;
    public static volatile ListAttribute<SeaFinanciaConvoca, SeaPresupuestoC> seaPresupuestoCList;
    public static volatile SingularAttribute<SeaFinanciaConvoca, BigDecimal> sfcId;

}