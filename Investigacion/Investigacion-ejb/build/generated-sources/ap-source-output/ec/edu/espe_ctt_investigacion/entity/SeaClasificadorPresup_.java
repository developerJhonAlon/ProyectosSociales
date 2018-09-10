package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaClasificadorPresup;
import ec.edu.espe_ctt_investigacion.entity.SeaProgramaAnual;
import ec.edu.espe_ctt_investigacion.entity.SeaRecursosConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupAnual;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaClasificadorPresup.class)
public class SeaClasificadorPresup_ { 

    public static volatile ListAttribute<SeaClasificadorPresup, SeaTotalPresupAnual> seaTotalPresupAnualList;
    public static volatile ListAttribute<SeaClasificadorPresup, SeaProgramaAnual> seaProgramaAnualList;
    public static volatile ListAttribute<SeaClasificadorPresup, SeaClasificadorPresup> seaClasificadorPresupList;
    public static volatile SingularAttribute<SeaClasificadorPresup, SeaClasificadorPresup> scpPadre;
    public static volatile SingularAttribute<SeaClasificadorPresup, String> scpNombre;
    public static volatile SingularAttribute<SeaClasificadorPresup, BigDecimal> scpId;
    public static volatile SingularAttribute<SeaClasificadorPresup, BigInteger> scpEjercicio;
    public static volatile ListAttribute<SeaClasificadorPresup, SeaRecursosConvoca> seaRecursosConvocaList;

}