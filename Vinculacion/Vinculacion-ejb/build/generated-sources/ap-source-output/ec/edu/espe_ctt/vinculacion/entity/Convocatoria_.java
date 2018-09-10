package ec.edu.espe_ctt.vinculacion.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(Convocatoria.class)
public class Convocatoria_ { 

    public static volatile SingularAttribute<Convocatoria, BigDecimal> id;
    public static volatile SingularAttribute<Convocatoria, String> nombre;
    public static volatile SingularAttribute<Convocatoria, String> observacion;
    public static volatile SingularAttribute<Convocatoria, String> nombreDocumento;
    public static volatile SingularAttribute<Convocatoria, String> urlDocumento;
    public static volatile SingularAttribute<Convocatoria, byte[]> documento;
    public static volatile SingularAttribute<Convocatoria, Date> fechaFin;
    public static volatile SingularAttribute<Convocatoria, Date> fechaInicio;

}