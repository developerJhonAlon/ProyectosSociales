package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaCobertura;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaLocaliza.class)
public class SeaLocaliza_ { 

    public static volatile SingularAttribute<SeaLocaliza, String> localDescrip;
    public static volatile ListAttribute<SeaLocaliza, SeaCobertura> seaCoberturaList;
    public static volatile SingularAttribute<SeaLocaliza, BigInteger> localOrden;
    public static volatile SingularAttribute<SeaLocaliza, BigDecimal> localId;

}