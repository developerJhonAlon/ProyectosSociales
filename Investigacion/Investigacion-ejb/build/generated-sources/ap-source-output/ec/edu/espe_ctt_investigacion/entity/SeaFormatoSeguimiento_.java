package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaFormatoSeguimiento.class)
public class SeaFormatoSeguimiento_ { 

    public static volatile SingularAttribute<SeaFormatoSeguimiento, Date> sfsFechaInicio;
    public static volatile SingularAttribute<SeaFormatoSeguimiento, BigDecimal> sfsPresupuesto;
    public static volatile SingularAttribute<SeaFormatoSeguimiento, String> sfsDescripcionHito;
    public static volatile SingularAttribute<SeaFormatoSeguimiento, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<SeaFormatoSeguimiento, String> sfsMes;
    public static volatile SingularAttribute<SeaFormatoSeguimiento, BigDecimal> sfsId;
    public static volatile SingularAttribute<SeaFormatoSeguimiento, Date> sfsFechaFin;

}