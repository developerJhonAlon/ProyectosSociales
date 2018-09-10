package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(DepartamentoPrograma.class)
public class DepartamentoPrograma_ { 

    public static volatile SingularAttribute<DepartamentoPrograma, Integer> id;
    public static volatile SingularAttribute<DepartamentoPrograma, Stvmajr> carrera;
    public static volatile SingularAttribute<DepartamentoPrograma, Programa> programa;
    public static volatile SingularAttribute<DepartamentoPrograma, Stvsubj> departamento;
    public static volatile SingularAttribute<DepartamentoPrograma, Stvcamp> campus;

}