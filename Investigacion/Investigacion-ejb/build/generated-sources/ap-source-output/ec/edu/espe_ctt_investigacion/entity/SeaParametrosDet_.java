package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaComisionXConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaParametros;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPorcenXCrConvoca;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaParametrosDet.class)
public class SeaParametrosDet_ { 

    public static volatile SingularAttribute<SeaParametrosDet, Long> prdId;
    public static volatile SingularAttribute<SeaParametrosDet, SeaParametros> seaParametros;
    public static volatile SingularAttribute<SeaParametrosDet, String> prdIdAlt;
    public static volatile ListAttribute<SeaParametrosDet, SeaConvoca> seaConvocaList;
    public static volatile ListAttribute<SeaParametrosDet, SeaComisionXConvoca> seaComisionXConvocaList;
    public static volatile ListAttribute<SeaParametrosDet, SeaParesConvoca> seaParesConvocaList;
    public static volatile ListAttribute<SeaParametrosDet, SeaFormatoLargo> seaFormatoLargoList;
    public static volatile ListAttribute<SeaParametrosDet, SeaDatGeneralProy> seaDatGeneralProyList;
    public static volatile SingularAttribute<SeaParametrosDet, String> prdEstado;
    public static volatile ListAttribute<SeaParametrosDet, SeaFormatoLargo> seaFormatoLargoList1;
    public static volatile SingularAttribute<SeaParametrosDet, BigInteger> prdOrden;
    public static volatile ListAttribute<SeaParametrosDet, SeaPorcenXCrConvoca> seaPorcenXCrConvocaList;
    public static volatile SingularAttribute<SeaParametrosDet, String> prdDescripcion;

}