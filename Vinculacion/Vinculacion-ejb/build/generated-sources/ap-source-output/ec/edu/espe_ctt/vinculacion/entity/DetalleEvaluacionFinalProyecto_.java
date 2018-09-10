package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.EvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(DetalleEvaluacionFinalProyecto.class)
public class DetalleEvaluacionFinalProyecto_ { 

    public static volatile SingularAttribute<DetalleEvaluacionFinalProyecto, Integer> id;
    public static volatile SingularAttribute<DetalleEvaluacionFinalProyecto, ObjetivoPrograma> objetivoMatrizMarcoLogico;
    public static volatile SingularAttribute<DetalleEvaluacionFinalProyecto, String> idAspectoEvaluacion;
    public static volatile SingularAttribute<DetalleEvaluacionFinalProyecto, String> infoAdicional;
    public static volatile SingularAttribute<DetalleEvaluacionFinalProyecto, EvaluacionFinalProyecto> evaluacionFinalProyecto;
    public static volatile SingularAttribute<DetalleEvaluacionFinalProyecto, ValoracionParametroEvaluacion> valoracionParametroEvaluacion;
    public static volatile SingularAttribute<DetalleEvaluacionFinalProyecto, Integer> puntaje;

}