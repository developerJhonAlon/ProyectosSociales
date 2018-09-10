package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaCobertura;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaPlanificacion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaZonaDetalle.class)
public class SeaZonaDetalle_ { 

    public static volatile SingularAttribute<SeaZonaDetalle, SeaProvincia> proId;
    public static volatile SingularAttribute<SeaZonaDetalle, SeaZonaPlanificacion> zopId;
    public static volatile SingularAttribute<SeaZonaDetalle, SeaCanton> canId;
    public static volatile SingularAttribute<SeaZonaDetalle, SeaCobertura> cobertId;
    public static volatile SingularAttribute<SeaZonaDetalle, BigDecimal> zondetaId;

}