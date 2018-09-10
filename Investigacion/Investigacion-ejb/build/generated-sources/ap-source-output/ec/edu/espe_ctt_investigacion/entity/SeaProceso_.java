package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegSistemas;
import ec.edu.espe_ctt_investigacion.entity.SeaProcesoXConvocatoria;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaProceso.class)
public class SeaProceso_ { 

    public static volatile SingularAttribute<SeaProceso, BigDecimal> proId;
    public static volatile SingularAttribute<SeaProceso, String> proDescrip;
    public static volatile ListAttribute<SeaProceso, SeaProcesoXConvocatoria> seaProcesoXConvocatoriaList;
    public static volatile SingularAttribute<SeaProceso, SegSistemas> segSistemas;

}