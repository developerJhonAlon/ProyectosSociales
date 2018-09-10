package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaProvincia.class)
public class SeaProvincia_ { 

    public static volatile SingularAttribute<SeaProvincia, String> proId;
    public static volatile SingularAttribute<SeaProvincia, String> proCodInen;
    public static volatile SingularAttribute<SeaProvincia, String> proRegion;
    public static volatile ListAttribute<SeaProvincia, SeaCanton> seaCantonList;
    public static volatile SingularAttribute<SeaProvincia, String> proNombre;

}