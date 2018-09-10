package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(VistaCampusDeptoCarrera.class)
public class VistaCampusDeptoCarrera_ { 

    public static volatile SingularAttribute<VistaCampusDeptoCarrera, BigInteger> id;
    public static volatile SingularAttribute<VistaCampusDeptoCarrera, Stvsubj> departamento;
    public static volatile SingularAttribute<VistaCampusDeptoCarrera, Stvcamp> campus;

}