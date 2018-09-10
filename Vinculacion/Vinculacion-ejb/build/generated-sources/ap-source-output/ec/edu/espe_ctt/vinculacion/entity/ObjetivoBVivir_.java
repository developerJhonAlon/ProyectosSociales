package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivir;
import ec.edu.espe_ctt.vinculacion.entity.PlanNacional;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ObjetivoBVivir.class)
public class ObjetivoBVivir_ { 

    public static volatile SingularAttribute<ObjetivoBVivir, Integer> orden;
    public static volatile SingularAttribute<ObjetivoBVivir, ObjetivoBVivir> svobviIdPadre;
    public static volatile CollectionAttribute<ObjetivoBVivir, ObjetivoBVivir> svinObjetivoBVivirCollection;
    public static volatile SingularAttribute<ObjetivoBVivir, String> svobviDescripcion;
    public static volatile SingularAttribute<ObjetivoBVivir, BigDecimal> svobviId;
    public static volatile SingularAttribute<ObjetivoBVivir, PlanNacional> configuracionPlanNacional;

}