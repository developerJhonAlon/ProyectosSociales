package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.vinculacion.entity.ActaDesignacionResponsable;
import ec.edu.espe_ctt.vinculacion.entity.HorasResponsableProyecto;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.TipoResponsable;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ResponsableProyecto.class)
public class ResponsableProyecto_ { 

    public static volatile SingularAttribute<ResponsableProyecto, Programa> programa;
    public static volatile SingularAttribute<ResponsableProyecto, Stvmajr> carrera;
    public static volatile SingularAttribute<ResponsableProyecto, Integer> id;
    public static volatile SingularAttribute<ResponsableProyecto, Integer> nroCertificadosEmtregados;
    public static volatile SingularAttribute<ResponsableProyecto, String> estado;
    public static volatile SingularAttribute<ResponsableProyecto, SegUsuario> usuario;
    public static volatile SingularAttribute<ResponsableProyecto, Stvsubj> departamento;
    public static volatile SingularAttribute<ResponsableProyecto, ActaDesignacionResponsable> actaDesignacionResponsable;
    public static volatile SingularAttribute<ResponsableProyecto, Integer> horasPlanificadas;
    public static volatile SingularAttribute<ResponsableProyecto, Date> fechaCreacion;
    public static volatile SingularAttribute<ResponsableProyecto, Proyecto> proyecto;
    public static volatile SingularAttribute<ResponsableProyecto, TipoResponsable> tipoResponsable;
    public static volatile ListAttribute<ResponsableProyecto, HorasResponsableProyecto> horasDedicadasList;
    public static volatile SingularAttribute<ResponsableProyecto, Stvcamp> campus;

}