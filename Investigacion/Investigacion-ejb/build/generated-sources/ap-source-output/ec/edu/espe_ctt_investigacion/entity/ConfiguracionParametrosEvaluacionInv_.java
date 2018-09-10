package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(ConfiguracionParametrosEvaluacionInv.class)
public class ConfiguracionParametrosEvaluacionInv_ { 

    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacionInv, Integer> id;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacionInv, String> estado;
    public static volatile ListAttribute<ConfiguracionParametrosEvaluacionInv, ParametroEvaluacionInv> parametroEvaluacionList;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacionInv, BigDecimal> puntajeMinimoRequerido;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacionInv, Integer> tipo;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacionInv, String> descripcion;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacionInv, Date> fechaConfiguracion;

}