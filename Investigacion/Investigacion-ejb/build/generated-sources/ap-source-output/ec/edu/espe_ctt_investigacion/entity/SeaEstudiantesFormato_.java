package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaSeguimientoFormato;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaEstudiantesFormato.class)
public class SeaEstudiantesFormato_ { 

    public static volatile SingularAttribute<SeaEstudiantesFormato, Date> sesfFechaFin;
    public static volatile SingularAttribute<SeaEstudiantesFormato, String> sesfTesis;
    public static volatile SingularAttribute<SeaEstudiantesFormato, String> sesfPrograma;
    public static volatile SingularAttribute<SeaEstudiantesFormato, String> sesfGeneroTesis;
    public static volatile SingularAttribute<SeaEstudiantesFormato, SegUsuario> usuId;
    public static volatile SingularAttribute<SeaEstudiantesFormato, BigDecimal> sesfId;
    public static volatile SingularAttribute<SeaEstudiantesFormato, Date> sesfFechaInicio;
    public static volatile SingularAttribute<SeaEstudiantesFormato, SeaSeguimientoFormato> ssefId;

}