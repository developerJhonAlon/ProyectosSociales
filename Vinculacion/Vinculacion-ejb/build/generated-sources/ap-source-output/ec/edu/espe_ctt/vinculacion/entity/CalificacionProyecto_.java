package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ConsolidacionCalificacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.DetalleCalificacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.MiembroComisionCalificacion;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(CalificacionProyecto.class)
public class CalificacionProyecto_ { 

    public static volatile SingularAttribute<CalificacionProyecto, Integer> id;
    public static volatile SingularAttribute<CalificacionProyecto, Date> fecha;
    public static volatile SingularAttribute<CalificacionProyecto, String> estadoFinalizado;
    public static volatile SingularAttribute<CalificacionProyecto, ConsolidacionCalificacionProyecto> consolidacionCalificacionProyecto;
    public static volatile ListAttribute<CalificacionProyecto, DetalleCalificacionProyecto> detalleCalificacionList;
    public static volatile SingularAttribute<CalificacionProyecto, String> cumpleRequisitos;
    public static volatile SingularAttribute<CalificacionProyecto, String> observaciones;
    public static volatile SingularAttribute<CalificacionProyecto, Proyecto> proyecto;
    public static volatile SingularAttribute<CalificacionProyecto, MiembroComisionCalificacion> miembroComisionCalificacion;

}