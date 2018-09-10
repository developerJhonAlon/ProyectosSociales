package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaMeses;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaProgramaAnual.class)
public class SeaProgramaAnual_ { 

    public static volatile SingularAttribute<SeaProgramaAnual, String> spanPartida;
    public static volatile SingularAttribute<SeaProgramaAnual, BigDecimal> spanId;
    public static volatile SingularAttribute<SeaProgramaAnual, BigDecimal> spanOInstitu;
    public static volatile SingularAttribute<SeaProgramaAnual, BigDecimal> spanTotal;
    public static volatile SingularAttribute<SeaProgramaAnual, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<SeaProgramaAnual, BigDecimal> spanVEspe;
    public static volatile SingularAttribute<SeaProgramaAnual, SeaClasificadorPresup> scpId;
    public static volatile SingularAttribute<SeaProgramaAnual, SeaMeses> semeId;

}