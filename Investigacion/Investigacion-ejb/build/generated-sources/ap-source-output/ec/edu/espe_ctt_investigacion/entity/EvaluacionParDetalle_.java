package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.EvaluacionPar;
import ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv;
import ec.edu.espe_ctt_investigacion.entity.ValoracionParametroEvaluacionInv;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(EvaluacionParDetalle.class)
public class EvaluacionParDetalle_ { 

    public static volatile SingularAttribute<EvaluacionParDetalle, Integer> id;
    public static volatile SingularAttribute<EvaluacionParDetalle, String> justificacion;
    public static volatile SingularAttribute<EvaluacionParDetalle, ParametroEvaluacionInv> parametroEvaluacion;
    public static volatile SingularAttribute<EvaluacionParDetalle, EvaluacionPar> evaluacionPar;
    public static volatile SingularAttribute<EvaluacionParDetalle, ValoracionParametroEvaluacionInv> valoracionParametroEvaluacion;
    public static volatile SingularAttribute<EvaluacionParDetalle, BigDecimal> puntaje;

}