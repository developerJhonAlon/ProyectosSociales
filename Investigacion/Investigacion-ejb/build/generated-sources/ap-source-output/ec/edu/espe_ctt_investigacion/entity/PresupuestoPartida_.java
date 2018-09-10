package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.Cronograma;
import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(PresupuestoPartida.class)
public class PresupuestoPartida_ { 

    public static volatile SingularAttribute<PresupuestoPartida, BigDecimal> id;
    public static volatile SingularAttribute<PresupuestoPartida, Cronograma> cronograma;
    public static volatile SingularAttribute<PresupuestoPartida, String> especificacionesTecnicas;
    public static volatile SingularAttribute<PresupuestoPartida, BigDecimal> valor;
    public static volatile SingularAttribute<PresupuestoPartida, SeaClasificadorPresup> partida;
    public static volatile SingularAttribute<PresupuestoPartida, String> codigoCategoriaCPC;
    public static volatile SingularAttribute<PresupuestoPartida, String> institucionNombre;
    public static volatile SingularAttribute<PresupuestoPartida, Integer> institucionTipo;

}