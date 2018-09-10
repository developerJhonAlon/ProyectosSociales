package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ConfiguracionParametrosEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ParametroEvaluacionFinalCabecera.class)
public class ParametroEvaluacionFinalCabecera_ { 

    public static volatile SingularAttribute<ParametroEvaluacionFinalCabecera, Integer> orden;
    public static volatile SingularAttribute<ParametroEvaluacionFinalCabecera, String> nombre;
    public static volatile SingularAttribute<ParametroEvaluacionFinalCabecera, Integer> id;
    public static volatile ListAttribute<ParametroEvaluacionFinalCabecera, ParametroEvaluacion> parametroEvaluacionList;
    public static volatile SingularAttribute<ParametroEvaluacionFinalCabecera, ConfiguracionParametrosEvaluacion> configuracionParametrosEvaluacion;
    public static volatile SingularAttribute<ParametroEvaluacionFinalCabecera, String> descripcion2;
    public static volatile SingularAttribute<ParametroEvaluacionFinalCabecera, Integer> tipo;
    public static volatile SingularAttribute<ParametroEvaluacionFinalCabecera, String> descripcion1;

}