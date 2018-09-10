package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.DetalleEvaluacionFinalProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(EvaluacionFinalProyecto.class)
public class EvaluacionFinalProyecto_ { 

    public static volatile SingularAttribute<EvaluacionFinalProyecto, Integer> id;
    public static volatile SingularAttribute<EvaluacionFinalProyecto, Date> fecha;
    public static volatile ListAttribute<EvaluacionFinalProyecto, DetalleEvaluacionFinalProyecto> detalleEvaluacionFinalProyectoList;
    public static volatile SingularAttribute<EvaluacionFinalProyecto, String> observaciones;
    public static volatile SingularAttribute<EvaluacionFinalProyecto, Proyecto> proyecto;

}