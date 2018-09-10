package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.AvanceComponente;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(AvanceActividad.class)
public class AvanceActividad_ { 

    public static volatile SingularAttribute<AvanceActividad, Integer> id;
    public static volatile SingularAttribute<AvanceActividad, Integer> porcentajeAvance;
    public static volatile SingularAttribute<AvanceActividad, String> observacion;
    public static volatile SingularAttribute<AvanceActividad, ObjetivoPrograma> actividad;
    public static volatile SingularAttribute<AvanceActividad, AvanceComponente> avanceComponente;
    public static volatile SingularAttribute<AvanceActividad, String> resultado;

}