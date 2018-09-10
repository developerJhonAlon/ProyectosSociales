package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.ObjetivoProyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(ObjetivoProyecto.class)
public class ObjetivoProyecto_ { 

    public static volatile SingularAttribute<ObjetivoProyecto, Integer> orden;
    public static volatile SingularAttribute<ObjetivoProyecto, BigDecimal> id;
    public static volatile SingularAttribute<ObjetivoProyecto, String> supuestos;
    public static volatile SingularAttribute<ObjetivoProyecto, Integer> indicadorValor;
    public static volatile SingularAttribute<ObjetivoProyecto, SeaParametrosDet> tipo;
    public static volatile SingularAttribute<ObjetivoProyecto, String> descripcion;
    public static volatile SingularAttribute<ObjetivoProyecto, Integer> indicadorTipo;
    public static volatile ListAttribute<ObjetivoProyecto, ObjetivoProyecto> objetivoHijoList;
    public static volatile SingularAttribute<ObjetivoProyecto, ObjetivoProyecto> objetivoPadre;
    public static volatile SingularAttribute<ObjetivoProyecto, String> medioVerificacion;
    public static volatile SingularAttribute<ObjetivoProyecto, SeaFormatoLargo> proyecto;
    public static volatile SingularAttribute<ObjetivoProyecto, String> indicadorDescripcion;

}