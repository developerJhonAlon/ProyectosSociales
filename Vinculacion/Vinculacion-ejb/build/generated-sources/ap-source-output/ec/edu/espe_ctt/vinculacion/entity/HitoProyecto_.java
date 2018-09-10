package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(HitoProyecto.class)
public class HitoProyecto_ { 

    public static volatile SingularAttribute<HitoProyecto, Integer> id;
    public static volatile SingularAttribute<HitoProyecto, String> logro;
    public static volatile SingularAttribute<HitoProyecto, Date> fecha;
    public static volatile SingularAttribute<HitoProyecto, ObjetivoPrograma> componenteEspecifico;
    public static volatile SingularAttribute<HitoProyecto, String> descripcion;
    public static volatile SingularAttribute<HitoProyecto, Proyecto> proyecto;

}