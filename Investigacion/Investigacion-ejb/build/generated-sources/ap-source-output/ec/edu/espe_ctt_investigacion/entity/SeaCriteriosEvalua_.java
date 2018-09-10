package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaCriteriosEvalua;
import ec.edu.espe_ctt_investigacion.entity.SeaEvaluaComisionConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaEvaluaParConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPorcenXCrConvoca;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaCriteriosEvalua.class)
public class SeaCriteriosEvalua_ { 

    public static volatile SingularAttribute<SeaCriteriosEvalua, SeaCriteriosEvalua> scePadre;
    public static volatile ListAttribute<SeaCriteriosEvalua, SeaEvaluaComisionConvoca> seaEvaluaComisionConvocaList;
    public static volatile SingularAttribute<SeaCriteriosEvalua, BigDecimal> sceId;
    public static volatile SingularAttribute<SeaCriteriosEvalua, String> sceNombre;
    public static volatile ListAttribute<SeaCriteriosEvalua, SeaPorcenXCrConvoca> seaPorcenXCrConvocaList;
    public static volatile ListAttribute<SeaCriteriosEvalua, SeaCriteriosEvalua> seaCriteriosEvaluaList;
    public static volatile ListAttribute<SeaCriteriosEvalua, SeaEvaluaParConvoca> seaEvaluaParConvocaList;

}