package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.AvanceComponente;
import ec.edu.espe_ctt.vinculacion.entity.HitoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(ObjetivoPrograma.class)
public class ObjetivoPrograma_ { 

    public static volatile SingularAttribute<ObjetivoPrograma, String> svopMverifica;
    public static volatile SingularAttribute<ObjetivoPrograma, Date> fechaFin;
    public static volatile ListAttribute<ObjetivoPrograma, HitoProyecto> hitoProyectoList;
    public static volatile SingularAttribute<ObjetivoPrograma, Proyecto> proyecto;
    public static volatile SingularAttribute<ObjetivoPrograma, String> svopIndicador;
    public static volatile SingularAttribute<ObjetivoPrograma, String> svopObjetivoProy;
    public static volatile SingularAttribute<ObjetivoPrograma, Programa> programa;
    public static volatile ListAttribute<ObjetivoPrograma, ObjetivoPrograma> svinObjetivoHijoList;
    public static volatile SingularAttribute<ObjetivoPrograma, ObjetivoPrograma> svinObjetivoPadre;
    public static volatile SingularAttribute<ObjetivoPrograma, Integer> svopTipo;
    public static volatile SingularAttribute<ObjetivoPrograma, Integer> indicadorValorEjecutado;
    public static volatile SingularAttribute<ObjetivoPrograma, Integer> indicadorValor;
    public static volatile SingularAttribute<ObjetivoPrograma, String> svopSupuestos;
    public static volatile SingularAttribute<ObjetivoPrograma, Integer> svopOrden;
    public static volatile ListAttribute<ObjetivoPrograma, AvanceComponente> avanceComponenteList;
    public static volatile SingularAttribute<ObjetivoPrograma, Integer> indicadorTipo;
    public static volatile SingularAttribute<ObjetivoPrograma, BigDecimal> svopId;
    public static volatile SingularAttribute<ObjetivoPrograma, Date> fechaInicio;

}