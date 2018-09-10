package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvterm;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(VEstudianteCarreraPregrado.class)
public class VEstudianteCarreraPregrado_ { 

    public static volatile SingularAttribute<VEstudianteCarreraPregrado, Integer> id;
    public static volatile SingularAttribute<VEstudianteCarreraPregrado, Stvmajr> carrera;
    public static volatile SingularAttribute<VEstudianteCarreraPregrado, Integer> nroEstudiantes;
    public static volatile SingularAttribute<VEstudianteCarreraPregrado, Stvterm> periodo;
    public static volatile SingularAttribute<VEstudianteCarreraPregrado, Stvcamp> campus;

}