package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaDetalle;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaZonaPlanificacion.class)
public class SeaZonaPlanificacion_ { 

    public static volatile ListAttribute<SeaZonaPlanificacion, SeaZonaDetalle> seaZonaDetalleList;
    public static volatile SingularAttribute<SeaZonaPlanificacion, BigDecimal> zopId;
    public static volatile SingularAttribute<SeaZonaPlanificacion, String> zopNombre;
    public static volatile SingularAttribute<SeaZonaPlanificacion, String> zopNombreLargo;
    public static volatile ListAttribute<SeaZonaPlanificacion, SeaCanton> seaCantonList;

}