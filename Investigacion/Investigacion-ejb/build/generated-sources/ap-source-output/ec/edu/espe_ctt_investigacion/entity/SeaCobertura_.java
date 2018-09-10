package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaLocaliza;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaDetalle;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaCobertura.class)
public class SeaCobertura_ { 

    public static volatile ListAttribute<SeaCobertura, SeaZonaDetalle> zonaDetalleList;
    public static volatile SingularAttribute<SeaCobertura, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaCobertura, SeaDatGeneralProg> datgeprogId;
    public static volatile SingularAttribute<SeaCobertura, SeaLocaliza> localId;
    public static volatile SingularAttribute<SeaCobertura, SeaParroquia> prqId;
    public static volatile SingularAttribute<SeaCobertura, BigDecimal> cobertId;

}