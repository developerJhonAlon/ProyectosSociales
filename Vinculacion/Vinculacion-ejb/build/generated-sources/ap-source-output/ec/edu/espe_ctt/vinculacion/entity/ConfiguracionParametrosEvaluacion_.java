package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ConfiguracionParametrosEvaluacion.class)
public class ConfiguracionParametrosEvaluacion_ { 

    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacion, Integer> id;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacion, String> estado;
    public static volatile ListAttribute<ConfiguracionParametrosEvaluacion, ParametroEvaluacion> parametroEvaluacionList;
    public static volatile ListAttribute<ConfiguracionParametrosEvaluacion, ParametroEvaluacionFinalCabecera> parametroEvaluacionFinalCabeceraList;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacion, Integer> puntajeMinimoRequerido;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacion, Integer> tipo;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacion, String> descripcion;
    public static volatile SingularAttribute<ConfiguracionParametrosEvaluacion, Date> fechaConfiguracion;

}