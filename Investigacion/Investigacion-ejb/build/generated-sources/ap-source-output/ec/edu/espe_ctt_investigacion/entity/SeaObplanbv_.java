package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaObplanbv.class)
public class SeaObplanbv_ { 

    public static volatile SingularAttribute<SeaObplanbv, BigDecimal> obplabvId;
    public static volatile SingularAttribute<SeaObplanbv, String> obplabvNombre;
    public static volatile SingularAttribute<SeaObplanbv, String> obplanbvDecrip;
    public static volatile ListAttribute<SeaObplanbv, SeaDatGeneralProg> seaDatGeneralProgList;

}