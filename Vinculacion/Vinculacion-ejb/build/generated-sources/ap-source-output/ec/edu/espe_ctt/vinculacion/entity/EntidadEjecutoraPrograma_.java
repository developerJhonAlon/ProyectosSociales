package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.Programa;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:17")
@StaticMetamodel(EntidadEjecutoraPrograma.class)
public class EntidadEjecutoraPrograma_ { 

    public static volatile SingularAttribute<EntidadEjecutoraPrograma, SeaProvincia> proId;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, Date> sopinFechaCrea;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinRepresentaLegal;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, BigDecimal> sopinId;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, BigInteger> sopinOrden;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, Programa> programa;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinDireccion;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinNombre;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinPaguinaWeb;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinFax;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinCiudad;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinCedulaRl;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinOrganoEjecutor;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinTelefono;
    public static volatile SingularAttribute<EntidadEjecutoraPrograma, String> sopinMail;

}