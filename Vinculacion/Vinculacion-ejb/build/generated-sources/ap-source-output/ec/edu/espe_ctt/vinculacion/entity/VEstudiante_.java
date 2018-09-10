package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.saturno.entity.Stvterm;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(VEstudiante.class)
public class VEstudiante_ { 

    public static volatile SingularAttribute<VEstudiante, Integer> id;
    public static volatile SingularAttribute<VEstudiante, Stvmajr> carrera;
    public static volatile SingularAttribute<VEstudiante, SegUsuario> usuario;
    public static volatile SingularAttribute<VEstudiante, Stvsubj> departamento;
    public static volatile SingularAttribute<VEstudiante, Stvterm> periodo;

}