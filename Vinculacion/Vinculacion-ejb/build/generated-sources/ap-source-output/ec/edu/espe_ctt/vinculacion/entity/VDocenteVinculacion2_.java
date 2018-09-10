package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(VDocenteVinculacion2.class)
public class VDocenteVinculacion2_ { 

    public static volatile SingularAttribute<VDocenteVinculacion2, BigInteger> id;
    public static volatile SingularAttribute<VDocenteVinculacion2, SegUsuario> usuario;
    public static volatile SingularAttribute<VDocenteVinculacion2, Stvsubj> departamento;
    public static volatile SingularAttribute<VDocenteVinculacion2, String> cargo;
    public static volatile SingularAttribute<VDocenteVinculacion2, Stvcamp> campus;

}