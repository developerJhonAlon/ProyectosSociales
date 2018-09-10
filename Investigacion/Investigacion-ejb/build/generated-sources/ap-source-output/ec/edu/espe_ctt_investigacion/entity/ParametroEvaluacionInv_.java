package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.ConfiguracionParametrosEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.ValoracionParametroEvaluacionInv;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(ParametroEvaluacionInv.class)
public class ParametroEvaluacionInv_ { 

    public static volatile SingularAttribute<ParametroEvaluacionInv, Integer> orden;
    public static volatile SingularAttribute<ParametroEvaluacionInv, Integer> id;
    public static volatile SingularAttribute<ParametroEvaluacionInv, ParametroEvaluacionInv> parametroEvaluacionPadre;
    public static volatile ListAttribute<ParametroEvaluacionInv, ParametroEvaluacionInv> parametroEvaluacionList;
    public static volatile SingularAttribute<ParametroEvaluacionInv, ConfiguracionParametrosEvaluacionInv> configuracionParametrosEvaluacion;
    public static volatile SingularAttribute<ParametroEvaluacionInv, String> descripcion;
    public static volatile SingularAttribute<ParametroEvaluacionInv, BigDecimal> puntajeMaximo;
    public static volatile SingularAttribute<ParametroEvaluacionInv, String> tieneSubitems;
    public static volatile ListAttribute<ParametroEvaluacionInv, ValoracionParametroEvaluacionInv> valoracionList;

}