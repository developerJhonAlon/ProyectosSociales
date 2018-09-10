package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupAnual;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaMeses.class)
public class SeaMeses_ { 

    public static volatile ListAttribute<SeaMeses, SeaTotalPresupAnual> seaTotalPresupAnualList;
    public static volatile ListAttribute<SeaMeses, SeaProgramaAnual> seaProgramaAnualList;
    public static volatile SingularAttribute<SeaMeses, String> semeDetalle;
    public static volatile SingularAttribute<SeaMeses, BigDecimal> semeId;

}