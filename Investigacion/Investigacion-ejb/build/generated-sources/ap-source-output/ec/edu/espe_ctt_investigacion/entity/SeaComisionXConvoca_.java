package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoRespons;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaComisionXConvoca.class)
public class SeaComisionXConvoca_ { 

    public static volatile SingularAttribute<SeaComisionXConvoca, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<SeaComisionXConvoca, SeaConvoca> convocaId;
    public static volatile SingularAttribute<SeaComisionXConvoca, Date> scxcFechaCrea;
    public static volatile SingularAttribute<SeaComisionXConvoca, String> scxcEstado;
    public static volatile SingularAttribute<SeaComisionXConvoca, String> scxcDocNombre;
    public static volatile SingularAttribute<SeaComisionXConvoca, SegUsuario> usuIdCrea;
    public static volatile SingularAttribute<SeaComisionXConvoca, SegUsuario> usuId;
    public static volatile SingularAttribute<SeaComisionXConvoca, byte[]> scxcDocDigital;
    public static volatile SingularAttribute<SeaComisionXConvoca, BigDecimal> scxcId;
    public static volatile SingularAttribute<SeaComisionXConvoca, SeaTipoRespons> tipresId;

}