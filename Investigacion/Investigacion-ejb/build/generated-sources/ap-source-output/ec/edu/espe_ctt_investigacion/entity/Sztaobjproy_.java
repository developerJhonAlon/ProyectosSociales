package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.Sztaobjproy;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(Sztaobjproy.class)
public class Sztaobjproy_ { 

    public static volatile SingularAttribute<Sztaobjproy, String> sztaobjproyDescr;
    public static volatile SingularAttribute<Sztaobjproy, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<Sztaobjproy, BigDecimal> sztaobjproyCode;
    public static volatile SingularAttribute<Sztaobjproy, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<Sztaobjproy, String> sztaobjproyResult;
    public static volatile SingularAttribute<Sztaobjproy, Sztaobjproy> sztaobjproyPadre;
    public static volatile ListAttribute<Sztaobjproy, Sztaobjproy> sztaobjproyList;

}