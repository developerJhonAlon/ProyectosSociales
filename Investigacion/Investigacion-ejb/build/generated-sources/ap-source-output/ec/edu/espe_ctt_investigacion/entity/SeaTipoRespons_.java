package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaComisionXConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoFormato;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaTipoRespons.class)
public class SeaTipoRespons_ { 

    public static volatile SingularAttribute<SeaTipoRespons, String> tipresDescrip;
    public static volatile ListAttribute<SeaTipoRespons, SeaComisionXConvoca> seaComisionXConvocaList;
    public static volatile SingularAttribute<SeaTipoRespons, BigInteger> tipresOrden;
    public static volatile ListAttribute<SeaTipoRespons, SeaResponsableProg> seaResponsableProgList;
    public static volatile SingularAttribute<SeaTipoRespons, SeaTipoFormato> tiformaId;
    public static volatile SingularAttribute<SeaTipoRespons, BigDecimal> tipresId;

}