package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.entity.SeaZonaPlanificacion;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaCanton.class)
public class SeaCanton_ { 

    public static volatile SingularAttribute<SeaCanton, SeaProvincia> proId;
    public static volatile SingularAttribute<SeaCanton, BigInteger> canGrupo;
    public static volatile SingularAttribute<SeaCanton, String> canBanner;
    public static volatile SingularAttribute<SeaCanton, BigInteger> canLatitud;
    public static volatile SingularAttribute<SeaCanton, SeaZonaPlanificacion> zopId;
    public static volatile SingularAttribute<SeaCanton, String> canId;
    public static volatile ListAttribute<SeaCanton, SeaParroquia> seaParroquiaList;
    public static volatile SingularAttribute<SeaCanton, BigInteger> canLongitud;
    public static volatile SingularAttribute<SeaCanton, String> canNombre;

}