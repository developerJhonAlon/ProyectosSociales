package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaObjAdquisisiones;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaObjEntregables.class)
public class SeaObjEntregables_ { 

    public static volatile SingularAttribute<SeaObjEntregables, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<SeaObjEntregables, BigDecimal> soeId;
    public static volatile SingularAttribute<SeaObjEntregables, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<SeaObjEntregables, String> soeDescripcion;
    public static volatile ListAttribute<SeaObjEntregables, SeaObjAdquisisiones> adquisicionList;

}