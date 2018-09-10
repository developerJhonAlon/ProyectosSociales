package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivir;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(PlanNacional.class)
public class PlanNacional_ { 

    public static volatile SingularAttribute<PlanNacional, Integer> id;
    public static volatile SingularAttribute<PlanNacional, String> estado;
    public static volatile SingularAttribute<PlanNacional, String> descripcion;
    public static volatile ListAttribute<PlanNacional, ObjetivoBVivir> objetivoBVivirList;
    public static volatile SingularAttribute<PlanNacional, Date> fechaConfiguracion;

}