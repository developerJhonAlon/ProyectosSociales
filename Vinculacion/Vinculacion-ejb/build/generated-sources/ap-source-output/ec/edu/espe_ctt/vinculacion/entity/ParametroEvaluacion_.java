package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ConfiguracionParametrosEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacionFinalCabecera;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ParametroEvaluacion.class)
public class ParametroEvaluacion_ { 

    public static volatile SingularAttribute<ParametroEvaluacion, Integer> orden;
    public static volatile SingularAttribute<ParametroEvaluacion, Integer> id;
    public static volatile SingularAttribute<ParametroEvaluacion, ParametroEvaluacionFinalCabecera> parametroEvaluacionFinalCabecera;
    public static volatile SingularAttribute<ParametroEvaluacion, String> idAspectoEvaluacion;
    public static volatile SingularAttribute<ParametroEvaluacion, ConfiguracionParametrosEvaluacion> configuracionParametrosEvaluacion;
    public static volatile SingularAttribute<ParametroEvaluacion, String> preguntaInfoAdicional;
    public static volatile SingularAttribute<ParametroEvaluacion, String> solicitarInfoAdicional;
    public static volatile SingularAttribute<ParametroEvaluacion, String> opcionMenu;
    public static volatile SingularAttribute<ParametroEvaluacion, String> descripcion;
    public static volatile ListAttribute<ParametroEvaluacion, ValoracionParametroEvaluacion> valoracionList;

}