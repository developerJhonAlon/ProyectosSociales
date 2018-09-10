package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(VDirectorDepartamento.class)
public class VDirectorDepartamento_ { 

    public static volatile SingularAttribute<VDirectorDepartamento, Integer> id;
    public static volatile SingularAttribute<VDirectorDepartamento, SegUsuario> usuario;
    public static volatile SingularAttribute<VDirectorDepartamento, Stvsubj> departamento;
    public static volatile SingularAttribute<VDirectorDepartamento, Stvcamp> campus;

}