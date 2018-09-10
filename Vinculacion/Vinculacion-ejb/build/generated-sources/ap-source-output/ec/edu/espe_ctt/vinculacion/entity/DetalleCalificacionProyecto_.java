package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.CalificacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.ParametroEvaluacion;
import ec.edu.espe_ctt.vinculacion.entity.ValoracionParametroEvaluacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(DetalleCalificacionProyecto.class)
public class DetalleCalificacionProyecto_ { 

    public static volatile SingularAttribute<DetalleCalificacionProyecto, Integer> id;
    public static volatile SingularAttribute<DetalleCalificacionProyecto, CalificacionProyecto> calificacionProyecto;
    public static volatile SingularAttribute<DetalleCalificacionProyecto, ParametroEvaluacion> parametroEvaluacion;
    public static volatile SingularAttribute<DetalleCalificacionProyecto, String> observaciones;
    public static volatile SingularAttribute<DetalleCalificacionProyecto, ValoracionParametroEvaluacion> valoracionParametroEvaluacion;
    public static volatile SingularAttribute<DetalleCalificacionProyecto, Integer> puntaje;

}