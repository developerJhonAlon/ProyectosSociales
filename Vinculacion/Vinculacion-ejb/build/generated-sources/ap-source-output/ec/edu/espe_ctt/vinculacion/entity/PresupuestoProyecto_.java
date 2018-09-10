package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.PartidaPresupuestaria;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(PresupuestoProyecto.class)
public class PresupuestoProyecto_ { 

    public static volatile SingularAttribute<PresupuestoProyecto, BigInteger> id;
    public static volatile SingularAttribute<PresupuestoProyecto, String> tipoGasto;
    public static volatile SingularAttribute<PresupuestoProyecto, PartidaPresupuestaria> partidaPresupuestaria;
    public static volatile SingularAttribute<PresupuestoProyecto, BigDecimal> totalEjecutado;
    public static volatile SingularAttribute<PresupuestoProyecto, String> especificacionesTecnicas;
    public static volatile SingularAttribute<PresupuestoProyecto, BigDecimal> valor;
    public static volatile SingularAttribute<PresupuestoProyecto, Integer> cantidad;
    public static volatile SingularAttribute<PresupuestoProyecto, Integer> tipo;
    public static volatile SingularAttribute<PresupuestoProyecto, String> bienServicio;
    public static volatile SingularAttribute<PresupuestoProyecto, Proyecto> proyecto;

}