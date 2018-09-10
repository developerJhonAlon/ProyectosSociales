package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaPresupNotasc;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupnc;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaAnio.class)
public class SeaAnio_ { 

    public static volatile ListAttribute<SeaAnio, SeaPresupNotasc> seaPresupNotascList;
    public static volatile SingularAttribute<SeaAnio, BigDecimal> saniId;
    public static volatile SingularAttribute<SeaAnio, String> saniDetalle;
    public static volatile ListAttribute<SeaAnio, SeaTotalPresupnc> seaTotalPresupncList;

}