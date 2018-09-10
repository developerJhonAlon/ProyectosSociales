package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.CalificacionProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ConsolidacionCalificacionProyecto.class)
public class ConsolidacionCalificacionProyecto_ { 

    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, Integer> id;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, Date> fechaFinalizacionConsolidacion;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, String> direccionCorreo;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, String> estadoFinalizado;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, Date> fechaConsolidacion;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, String> asuntoCorreo;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, String> observaciones;
    public static volatile ListAttribute<ConsolidacionCalificacionProyecto, CalificacionProyecto> calificacionProyectoList;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, Proyecto> proyecto;
    public static volatile SingularAttribute<ConsolidacionCalificacionProyecto, String> mensajeCorreo;

}