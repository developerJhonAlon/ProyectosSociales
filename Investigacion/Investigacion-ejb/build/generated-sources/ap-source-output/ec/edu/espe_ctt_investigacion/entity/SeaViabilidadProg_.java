package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaViabilidadProg.class)
public class SeaViabilidadProg_ { 

    public static volatile SingularAttribute<SeaViabilidadProg, BigDecimal> viaprogId;
    public static volatile SingularAttribute<SeaViabilidadProg, SeaDatGeneralProg> datgeprogId;
    public static volatile SingularAttribute<SeaViabilidadProg, String> viaprogImpactEsperado;
    public static volatile SingularAttribute<SeaViabilidadProg, String> viaprogPerderiaPais;
    public static volatile SingularAttribute<SeaViabilidadProg, String> viaprogViabilidadTecnica;
    public static volatile SingularAttribute<SeaViabilidadProg, String> viaprogImpactAmbiental;

}