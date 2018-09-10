package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.Programa;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ActividadPrograma.class)
public class ActividadPrograma_ { 

    public static volatile SingularAttribute<ActividadPrograma, Integer> id;
    public static volatile SingularAttribute<ActividadPrograma, Programa> programa;
    public static volatile SingularAttribute<ActividadPrograma, BigDecimal> presupuestoGastoNoPermanente;
    public static volatile SingularAttribute<ActividadPrograma, Integer> anio;
    public static volatile SingularAttribute<ActividadPrograma, BigDecimal> presupuestoGastoPermanente;
    public static volatile SingularAttribute<ActividadPrograma, Integer> nroBeneficiarios;
    public static volatile SingularAttribute<ActividadPrograma, String> descripcion;
    public static volatile SingularAttribute<ActividadPrograma, Date> fechaFin;
    public static volatile SingularAttribute<ActividadPrograma, Date> fechaInicio;

}