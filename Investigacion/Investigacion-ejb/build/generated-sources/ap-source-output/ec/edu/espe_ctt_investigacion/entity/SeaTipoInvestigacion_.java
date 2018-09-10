package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaTipoInvestigacion.class)
public class SeaTipoInvestigacion_ { 

    public static volatile SingularAttribute<SeaTipoInvestigacion, BigDecimal> tipinveId;
    public static volatile SingularAttribute<SeaTipoInvestigacion, String> tipinveDescrip;
    public static volatile ListAttribute<SeaTipoInvestigacion, SeaDatGeneralProy> seaDatGeneralProyList;

}