package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvmajr;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaGrupinv;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaProgPostgrado;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaDepcenproy.class)
public class SeaDepcenproy_ { 

    public static volatile SingularAttribute<SeaDepcenproy, SeaConvoca> convocaId;
    public static volatile SingularAttribute<SeaDepcenproy, Stvmajr> stvmajrCode;
    public static volatile SingularAttribute<SeaDepcenproy, SeaGrupinv> grupiId;
    public static volatile SingularAttribute<SeaDepcenproy, Stvsubj> stvsubjCode;
    public static volatile SingularAttribute<SeaDepcenproy, SeaDatGeneralProy> datgeproyId;
    public static volatile SingularAttribute<SeaDepcenproy, BigDecimal> depceId;
    public static volatile SingularAttribute<SeaDepcenproy, SeaLineainves> lineaId;
    public static volatile SingularAttribute<SeaDepcenproy, Stvcamp> stvcampCode;
    public static volatile SingularAttribute<SeaDepcenproy, SeaProgPostgrado> postprogId;

}