package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(TipoPoblacionProyecto.class)
public class TipoPoblacionProyecto_ { 

    public static volatile SingularAttribute<TipoPoblacionProyecto, BigInteger> id;
    public static volatile SingularAttribute<TipoPoblacionProyecto, SeaParametrosDet> tipoPoblacion;
    public static volatile SingularAttribute<TipoPoblacionProyecto, Proyecto> proyecto;

}