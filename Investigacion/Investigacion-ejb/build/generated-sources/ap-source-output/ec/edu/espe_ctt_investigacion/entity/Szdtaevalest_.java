package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaEstudiantesFormato;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(Szdtaevalest.class)
public class Szdtaevalest_ { 

    public static volatile SingularAttribute<Szdtaevalest, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<Szdtaevalest, String> szdtaevalestAnalpa;
    public static volatile SingularAttribute<Szdtaevalest, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<Szdtaevalest, BigDecimal> szdtaevalestCode;
    public static volatile SingularAttribute<Szdtaevalest, SeaEstudiantesFormato> sesfId;

}