package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupNotasc;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupuestoC;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupnc;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaRecursosConvoca.class)
public class SeaRecursosConvoca_ { 

    public static volatile ListAttribute<SeaRecursosConvoca, SeaPresupNotasc> seaPresupNotascList;
    public static volatile SingularAttribute<SeaRecursosConvoca, String> srcDescripcion;
    public static volatile ListAttribute<SeaRecursosConvoca, SeaTotalPresupnc> seaTotalPresupncList;
    public static volatile SingularAttribute<SeaRecursosConvoca, BigDecimal> srcId;
    public static volatile SingularAttribute<SeaRecursosConvoca, String> srcNombre;
    public static volatile ListAttribute<SeaRecursosConvoca, SeaPresupuestoC> seaPresupuestoCList;
    public static volatile SingularAttribute<SeaRecursosConvoca, SeaClasificadorPresup> scpId;
    public static volatile ListAttribute<SeaRecursosConvoca, SeaFinanciaConvoca> seaFinanciaConvocaList;

}