package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaObplanbv;
import ec.edu.espe_ctt_investigacion.entity.SeaPrograma;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaDatGeneralProg.class)
public class SeaDatGeneralProg_ { 

    public static volatile SingularAttribute<SeaDatGeneralProg, Date> datgeprogFechaFin;
    public static volatile SingularAttribute<SeaDatGeneralProg, SeaObplanbv> obplabvId;
    public static volatile SingularAttribute<SeaDatGeneralProg, String> datgeprogNombreEspanol;
    public static volatile SingularAttribute<SeaDatGeneralProg, Date> datgeprogFechaInicio;
    public static volatile SingularAttribute<SeaDatGeneralProg, SeaPrograma> progId;
    public static volatile SingularAttribute<SeaDatGeneralProg, BigDecimal> datgeprogId;
    public static volatile SingularAttribute<SeaDatGeneralProg, String> datgeprogNombreIngles;
    public static volatile SingularAttribute<SeaDatGeneralProg, Date> datgeprogFechaPresenta;
    public static volatile SingularAttribute<SeaDatGeneralProg, String> datgeprogResumen;
    public static volatile SingularAttribute<SeaDatGeneralProg, SeaLineainves> lineaId;

}