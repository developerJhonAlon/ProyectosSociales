package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPlanVincula;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ObjetivoPlanVinculaPrograma.class)
public class ObjetivoPlanVinculaPrograma_ { 

    public static volatile SingularAttribute<ObjetivoPlanVinculaPrograma, BigDecimal> id;
    public static volatile SingularAttribute<ObjetivoPlanVinculaPrograma, Programa> programa;
    public static volatile SingularAttribute<ObjetivoPlanVinculaPrograma, ObjetivoPlanVincula> objetivoPlanVinculacion;

}