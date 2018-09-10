package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.ObjetivoEstrategico;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(IndicadorEstrategiaProyecto.class)
public class IndicadorEstrategiaProyecto_ { 

    public static volatile SingularAttribute<IndicadorEstrategiaProyecto, BigDecimal> id;
    public static volatile SingularAttribute<IndicadorEstrategiaProyecto, Programa> programa;
    public static volatile SingularAttribute<IndicadorEstrategiaProyecto, ObjetivoEstrategico> objetivoEstrategico;
    public static volatile SingularAttribute<IndicadorEstrategiaProyecto, Proyecto> proyecto;

}