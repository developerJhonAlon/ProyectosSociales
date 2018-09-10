package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaResplineai.class)
public class SeaResplineai_ { 

    public static volatile SingularAttribute<SeaResplineai, String> rplineaiDocNombre;
    public static volatile SingularAttribute<SeaResplineai, BigDecimal> rlineaiId;
    public static volatile SingularAttribute<SeaResplineai, Date> rplineaiFechaCrea;
    public static volatile SingularAttribute<SeaResplineai, String> rplineaiEstado;
    public static volatile SingularAttribute<SeaResplineai, Serializable> rplineaiDocDigital;
    public static volatile SingularAttribute<SeaResplineai, SegUsuario> usuId;
    public static volatile SingularAttribute<SeaResplineai, SeaLineainves> lineaId;

}