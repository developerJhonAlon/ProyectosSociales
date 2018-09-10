package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.PresupuestoPartida;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(Cronograma.class)
public class Cronograma_ { 

    public static volatile SingularAttribute<Cronograma, BigDecimal> id;
    public static volatile SingularAttribute<Cronograma, ObjetivoProyecto> actividad;
    public static volatile ListAttribute<Cronograma, PresupuestoPartida> presupuestoList;
    public static volatile SingularAttribute<Cronograma, Date> fechaFin;
    public static volatile SingularAttribute<Cronograma, SeaFormatoLargo> proyecto;
    public static volatile SingularAttribute<Cronograma, Date> fechaInicio;

}