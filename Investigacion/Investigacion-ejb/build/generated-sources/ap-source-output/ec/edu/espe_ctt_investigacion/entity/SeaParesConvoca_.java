package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.EvaluacionPar;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaParesConvoca.class)
public class SeaParesConvoca_ { 

    public static volatile SingularAttribute<SeaParesConvoca, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<SeaParesConvoca, SeaConvoca> convocaId;
    public static volatile SingularAttribute<SeaParesConvoca, SeaDatGeneralProy> notaConceptual;
    public static volatile SingularAttribute<SeaParesConvoca, BigDecimal> spcId;
    public static volatile ListAttribute<SeaParesConvoca, EvaluacionPar> evaluacionList;
    public static volatile SingularAttribute<SeaParesConvoca, Serializable> spcDocDigital;
    public static volatile SingularAttribute<SeaParesConvoca, String> spcDocNombre;
    public static volatile SingularAttribute<SeaParesConvoca, String> spcEstado;
    public static volatile SingularAttribute<SeaParesConvoca, SegUsuario> usuIdCrea;
    public static volatile SingularAttribute<SeaParesConvoca, SegUsuario> usuId;
    public static volatile SingularAttribute<SeaParesConvoca, Date> spcFechaCrea;

}