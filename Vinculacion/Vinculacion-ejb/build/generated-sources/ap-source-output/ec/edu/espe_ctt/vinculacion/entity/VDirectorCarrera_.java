package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(VDirectorCarrera.class)
public class VDirectorCarrera_ { 

    public static volatile SingularAttribute<VDirectorCarrera, Integer> id;
    public static volatile SingularAttribute<VDirectorCarrera, Stvmajr> carrera;
    public static volatile SingularAttribute<VDirectorCarrera, SegUsuario> usuario;
    public static volatile SingularAttribute<VDirectorCarrera, Stvsubj> departamento;
    public static volatile SingularAttribute<VDirectorCarrera, Stvcamp> campus;

}