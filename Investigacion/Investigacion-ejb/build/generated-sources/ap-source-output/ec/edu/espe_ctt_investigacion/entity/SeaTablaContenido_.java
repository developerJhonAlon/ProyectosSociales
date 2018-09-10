package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDiagnosProblema;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaTablaContenido.class)
public class SeaTablaContenido_ { 

    public static volatile SingularAttribute<SeaTablaContenido, String> stcOtros;
    public static volatile SingularAttribute<SeaTablaContenido, String> stcBaseDatos;
    public static volatile SingularAttribute<SeaTablaContenido, BigDecimal> stcId;
    public static volatile SingularAttribute<SeaTablaContenido, SeaDiagnosProblema> sdpId;
    public static volatile SingularAttribute<SeaTablaContenido, String> stcNumeroPatente;
    public static volatile SingularAttribute<SeaTablaContenido, String> stcDenominacion;

}