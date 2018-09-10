package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivir;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ObjetivoBVivirPrograma.class)
public class ObjetivoBVivirPrograma_ { 

    public static volatile SingularAttribute<ObjetivoBVivirPrograma, Integer> id;
    public static volatile SingularAttribute<ObjetivoBVivirPrograma, Programa> programa;
    public static volatile SingularAttribute<ObjetivoBVivirPrograma, Proyecto> proyecto;
    public static volatile SingularAttribute<ObjetivoBVivirPrograma, ObjetivoBVivir> objetivoBVivir;

}