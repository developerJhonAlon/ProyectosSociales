package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaSeguimientoFormato.class)
public class SeaSeguimientoFormato_ { 

    public static volatile SingularAttribute<SeaSeguimientoFormato, String> ssefAnalisis;
    public static volatile SingularAttribute<SeaSeguimientoFormato, String> ssfeEstado;
    public static volatile SingularAttribute<SeaSeguimientoFormato, String> ssefCodigoProy;
    public static volatile SingularAttribute<SeaSeguimientoFormato, Date> ssfeFechaHasta;
    public static volatile SingularAttribute<SeaSeguimientoFormato, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<SeaSeguimientoFormato, Date> ssfeFechaDesde;
    public static volatile SingularAttribute<SeaSeguimientoFormato, String> ssefInforme;
    public static volatile SingularAttribute<SeaSeguimientoFormato, BigDecimal> ssefId;
    public static volatile SingularAttribute<SeaSeguimientoFormato, String> ssfeRevisado;
    public static volatile SingularAttribute<SeaSeguimientoFormato, BigDecimal> ssfeFinanDevengado;

}