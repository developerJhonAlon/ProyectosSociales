package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.AvanceActividad;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(AvanceComponente.class)
public class AvanceComponente_ { 

    public static volatile SingularAttribute<AvanceComponente, Integer> id;
    public static volatile ListAttribute<AvanceComponente, AvanceActividad> avanceActividadList;
    public static volatile SingularAttribute<AvanceComponente, String> observacion;
    public static volatile SingularAttribute<AvanceComponente, Date> fecha;
    public static volatile SingularAttribute<AvanceComponente, ObjetivoPrograma> componenteEspecifico;

}