package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(CalificacionComision.class)
public class CalificacionComision_ { 

    public static volatile SingularAttribute<CalificacionComision, String> justificacion;
    public static volatile SingularAttribute<CalificacionComision, BigDecimal> id;
    public static volatile SingularAttribute<CalificacionComision, SeaDatGeneralProy> notaConceptual;
    public static volatile SingularAttribute<CalificacionComision, String> estado;
    public static volatile SingularAttribute<CalificacionComision, Date> fecha;
    public static volatile SingularAttribute<CalificacionComision, SegUsuario> usuario;

}