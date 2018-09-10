package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaParroquia.class)
public class SeaParroquia_ { 

    public static volatile SingularAttribute<SeaParroquia, String> prqNombre;
    public static volatile SingularAttribute<SeaParroquia, BigInteger> prqGrupoRecinto;
    public static volatile SingularAttribute<SeaParroquia, SeaCanton> canId;
    public static volatile SingularAttribute<SeaParroquia, String> prqTipo;
    public static volatile SingularAttribute<SeaParroquia, String> prqId;

}