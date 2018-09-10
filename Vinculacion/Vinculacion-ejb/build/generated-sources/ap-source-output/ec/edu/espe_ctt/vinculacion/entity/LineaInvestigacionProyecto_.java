package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(LineaInvestigacionProyecto.class)
public class LineaInvestigacionProyecto_ { 

    public static volatile SingularAttribute<LineaInvestigacionProyecto, Integer> id;
    public static volatile SingularAttribute<LineaInvestigacionProyecto, SeaLineainves> lineaInvestigacion;
    public static volatile SingularAttribute<LineaInvestigacionProyecto, Proyecto> proyecto;

}