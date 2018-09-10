package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(AprobacionDirectorDepartamento.class)
public class AprobacionDirectorDepartamento_ { 

    public static volatile SingularAttribute<AprobacionDirectorDepartamento, BigDecimal> id;
    public static volatile SingularAttribute<AprobacionDirectorDepartamento, String> observacion;
    public static volatile SingularAttribute<AprobacionDirectorDepartamento, SeaDatGeneralProy> notaConceptual;
    public static volatile SingularAttribute<AprobacionDirectorDepartamento, String> estado;
    public static volatile SingularAttribute<AprobacionDirectorDepartamento, Date> fecha;
    public static volatile SingularAttribute<AprobacionDirectorDepartamento, byte[]> archivoDigital;
    public static volatile SingularAttribute<AprobacionDirectorDepartamento, SegUsuario> usuario;
    public static volatile SingularAttribute<AprobacionDirectorDepartamento, String> archivoNombre;

}