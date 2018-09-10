package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaOpcionInstitucion.class)
public class SeaOpcionInstitucion_ { 

    public static volatile SingularAttribute<SeaOpcionInstitucion, BigDecimal> opinstiId;
    public static volatile SingularAttribute<SeaOpcionInstitucion, Date> opinstiFechaCrea;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiFax;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiDireccion;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiCiudad;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiOrganoEjecutor;
    public static volatile SingularAttribute<SeaOpcionInstitucion, BigInteger> opinstiOrden;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiNombre;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiCedulaRl;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiPaguinaWeb;
    public static volatile SingularAttribute<SeaOpcionInstitucion, SeaDatGeneralProg> datgeprogId;
    public static volatile SingularAttribute<SeaOpcionInstitucion, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiRepresentaLegal;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiTelefono;
    public static volatile SingularAttribute<SeaOpcionInstitucion, String> opinstiMail;

}