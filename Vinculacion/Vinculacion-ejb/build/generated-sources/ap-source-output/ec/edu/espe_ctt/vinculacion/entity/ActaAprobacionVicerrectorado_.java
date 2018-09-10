package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(ActaAprobacionVicerrectorado.class)
public class ActaAprobacionVicerrectorado_ { 

    public static volatile SingularAttribute<ActaAprobacionVicerrectorado, Integer> id;
    public static volatile SingularAttribute<ActaAprobacionVicerrectorado, Integer> secuencial;
    public static volatile SingularAttribute<ActaAprobacionVicerrectorado, String> documentoFirmadoUrl;
    public static volatile SingularAttribute<ActaAprobacionVicerrectorado, SegUsuario> usuario;
    public static volatile ListAttribute<ActaAprobacionVicerrectorado, Proyecto> proyectoList;
    public static volatile SingularAttribute<ActaAprobacionVicerrectorado, Date> fechaCreacion;
    public static volatile SingularAttribute<ActaAprobacionVicerrectorado, String> documentoFirmadoNombre;

}