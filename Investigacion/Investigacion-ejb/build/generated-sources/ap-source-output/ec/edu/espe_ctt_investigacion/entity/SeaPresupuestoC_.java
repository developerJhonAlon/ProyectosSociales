package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaPresupuestoC.class)
public class SeaPresupuestoC_ { 

    public static volatile SingularAttribute<SeaPresupuestoC, SeaConvoca> convocaId;
    public static volatile SingularAttribute<SeaPresupuestoC, BigDecimal> spcId;
    public static volatile SingularAttribute<SeaPresupuestoC, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaPresupuestoC, SeaRecursosConvoca> srcId;
    public static volatile SingularAttribute<SeaPresupuestoC, SeaClasificadorPresup> scpId;
    public static volatile SingularAttribute<SeaPresupuestoC, BigInteger> spcValorAsigna;
    public static volatile SingularAttribute<SeaPresupuestoC, SeaFinanciaConvoca> sfcId;

}