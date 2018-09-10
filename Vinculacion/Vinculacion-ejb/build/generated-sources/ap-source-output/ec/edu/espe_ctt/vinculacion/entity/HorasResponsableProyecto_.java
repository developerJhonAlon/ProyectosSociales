package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(HorasResponsableProyecto.class)
public class HorasResponsableProyecto_ { 

    public static volatile SingularAttribute<HorasResponsableProyecto, Integer> id;
    public static volatile SingularAttribute<HorasResponsableProyecto, Date> fechaDesde;
    public static volatile SingularAttribute<HorasResponsableProyecto, Integer> cantidadHoras;
    public static volatile SingularAttribute<HorasResponsableProyecto, Date> fechaHasta;
    public static volatile SingularAttribute<HorasResponsableProyecto, ResponsableProyecto> responsableProyecto;

}