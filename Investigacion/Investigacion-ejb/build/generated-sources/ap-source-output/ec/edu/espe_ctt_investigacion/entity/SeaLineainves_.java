package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaLineainves.class)
public class SeaLineainves_ { 

    public static volatile SingularAttribute<SeaLineainves, BigInteger> lineaUnesco;
    public static volatile ListAttribute<SeaLineainves, SeaDepcenproy> seaDepcenproyList;
    public static volatile SingularAttribute<SeaLineainves, String> lineaDescip;
    public static volatile SingularAttribute<SeaLineainves, SeaLineainves> lineaIdPadre;
    public static volatile ListAttribute<SeaLineainves, SeaLineainves> seaLineainvesList;
    public static volatile ListAttribute<SeaLineainves, SeaDatGeneralProy> seaDatGeneralProyList;
    public static volatile SingularAttribute<SeaLineainves, BigDecimal> lineaId;

}