package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(CarreraProyecto.class)
public class CarreraProyecto_ { 

    public static volatile SingularAttribute<CarreraProyecto, Integer> id;
    public static volatile SingularAttribute<CarreraProyecto, Stvmajr> carrera;
    public static volatile SingularAttribute<CarreraProyecto, Integer> nroEstudiantes;
    public static volatile SingularAttribute<CarreraProyecto, Proyecto> proyecto;

}