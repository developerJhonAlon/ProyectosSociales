package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaPrograma.class)
public class SeaPrograma_ { 

    public static volatile SingularAttribute<SeaPrograma, BigDecimal> progId;
    public static volatile ListAttribute<SeaPrograma, SeaDatGeneralProy> seaDatGeneralProyList;
    public static volatile SingularAttribute<SeaPrograma, String> progDescrip;
    public static volatile ListAttribute<SeaPrograma, SeaDatGeneralProg> seaDatGeneralProgList;

}