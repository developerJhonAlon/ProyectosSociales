package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ActaDesignacionResponsable.class)
public class ActaDesignacionResponsable_ { 

    public static volatile SingularAttribute<ActaDesignacionResponsable, Integer> id;
    public static volatile SingularAttribute<ActaDesignacionResponsable, Integer> secuencial;
    public static volatile SingularAttribute<ActaDesignacionResponsable, String> documentoFirmadoUrl;
    public static volatile SingularAttribute<ActaDesignacionResponsable, SegUsuario> usuario;
    public static volatile SingularAttribute<ActaDesignacionResponsable, Date> fechaCreacion;
    public static volatile ListAttribute<ActaDesignacionResponsable, ResponsableProyecto> responsableList;
    public static volatile SingularAttribute<ActaDesignacionResponsable, String> documentoFirmadoNombre;

}