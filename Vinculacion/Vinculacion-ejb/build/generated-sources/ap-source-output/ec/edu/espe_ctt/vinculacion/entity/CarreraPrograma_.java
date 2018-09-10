package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(CarreraPrograma.class)
public class CarreraPrograma_ { 

    public static volatile SingularAttribute<CarreraPrograma, BigDecimal> codigo;
    public static volatile SingularAttribute<CarreraPrograma, Programa> programa;
    public static volatile SingularAttribute<CarreraPrograma, Stvmajr> carrera;

}