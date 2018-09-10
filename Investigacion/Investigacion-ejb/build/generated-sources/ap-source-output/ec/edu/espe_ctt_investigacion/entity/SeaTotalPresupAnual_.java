package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaMeses;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaTotalPresupAnual.class)
public class SeaTotalPresupAnual_ { 

    public static volatile SingularAttribute<SeaTotalPresupAnual, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<SeaTotalPresupAnual, SeaClasificadorPresup> scpId;
    public static volatile SingularAttribute<SeaTotalPresupAnual, BigDecimal> stpaTotalMes;
    public static volatile SingularAttribute<SeaTotalPresupAnual, BigDecimal> stpaId;
    public static volatile SingularAttribute<SeaTotalPresupAnual, BigDecimal> stpaTotalPartida;
    public static volatile SingularAttribute<SeaTotalPresupAnual, SeaMeses> semeId;

}