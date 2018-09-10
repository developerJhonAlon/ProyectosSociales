package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(DepartamentoProyecto.class)
public class DepartamentoProyecto_ { 

    public static volatile SingularAttribute<DepartamentoProyecto, Integer> id;
    public static volatile SingularAttribute<DepartamentoProyecto, Stvsubj> departamento;
    public static volatile SingularAttribute<DepartamentoProyecto, Integer> nroDocentes;
    public static volatile SingularAttribute<DepartamentoProyecto, Proyecto> proyecto;
    public static volatile SingularAttribute<DepartamentoProyecto, Stvcamp> campus;

}