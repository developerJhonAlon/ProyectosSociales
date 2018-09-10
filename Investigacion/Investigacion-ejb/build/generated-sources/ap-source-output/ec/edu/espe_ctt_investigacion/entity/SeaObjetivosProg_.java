package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaObjetivosProg.class)
public class SeaObjetivosProg_ { 

    public static volatile SingularAttribute<SeaObjetivosProg, BigInteger> objprogOrden;
    public static volatile SingularAttribute<SeaObjetivosProg, String> objprogObjetivo;
    public static volatile SingularAttribute<SeaObjetivosProg, SeaDatGeneralProg> datgeprogId;
    public static volatile SingularAttribute<SeaObjetivosProg, BigDecimal> objprogId;

}