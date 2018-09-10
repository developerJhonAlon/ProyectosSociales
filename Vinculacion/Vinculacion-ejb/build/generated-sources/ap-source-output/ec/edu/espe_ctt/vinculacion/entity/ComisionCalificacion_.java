package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.MiembroComisionCalificacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ComisionCalificacion.class)
public class ComisionCalificacion_ { 

    public static volatile SingularAttribute<ComisionCalificacion, Integer> id;
    public static volatile SingularAttribute<ComisionCalificacion, String> descripcion;
    public static volatile SingularAttribute<ComisionCalificacion, Date> fechaCreacion;
    public static volatile ListAttribute<ComisionCalificacion, MiembroComisionCalificacion> miembroList;

}