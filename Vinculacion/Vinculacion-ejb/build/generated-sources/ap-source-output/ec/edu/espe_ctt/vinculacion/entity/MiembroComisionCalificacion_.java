package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.ComisionCalificacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(MiembroComisionCalificacion.class)
public class MiembroComisionCalificacion_ { 

    public static volatile SingularAttribute<MiembroComisionCalificacion, Integer> id;
    public static volatile SingularAttribute<MiembroComisionCalificacion, SegUsuario> usuarioCrea;
    public static volatile SingularAttribute<MiembroComisionCalificacion, ComisionCalificacion> comisionCalificacion;
    public static volatile SingularAttribute<MiembroComisionCalificacion, String> estado;
    public static volatile SingularAttribute<MiembroComisionCalificacion, SegUsuario> usuario;
    public static volatile SingularAttribute<MiembroComisionCalificacion, Date> fechaAsignacion;

}