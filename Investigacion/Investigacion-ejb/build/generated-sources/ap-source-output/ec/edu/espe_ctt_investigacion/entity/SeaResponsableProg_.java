package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoRespons;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaResponsableProg.class)
public class SeaResponsableProg_ { 

    public static volatile SingularAttribute<SeaResponsableProg, BigInteger> cargoId;
    public static volatile SingularAttribute<SeaResponsableProg, Stvsubj> stvsubjCode;
    public static volatile SingularAttribute<SeaResponsableProg, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaResponsableProg, SeaDatGeneralProg> datgeprogId;
    public static volatile SingularAttribute<SeaResponsableProg, SegUsuario> usuIdDocente;
    public static volatile SingularAttribute<SeaResponsableProg, BigDecimal> resprogId;
    public static volatile SingularAttribute<SeaResponsableProg, BigInteger> resprogOrden;
    public static volatile SingularAttribute<SeaResponsableProg, SeaTipoRespons> tipresId;

}