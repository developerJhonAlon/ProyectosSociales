package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.EstrategiaPlanVincula;
import ec.edu.espe_ctt.vinculacion.entity.Programa;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(EstrategiaPlanVinculaPrograma.class)
public class EstrategiaPlanVinculaPrograma_ { 

    public static volatile SingularAttribute<EstrategiaPlanVinculaPrograma, BigDecimal> id;
    public static volatile SingularAttribute<EstrategiaPlanVinculaPrograma, Programa> programa;
    public static volatile SingularAttribute<EstrategiaPlanVinculaPrograma, EstrategiaPlanVincula> estrategiaPlanVinculacion;

}