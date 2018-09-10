package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.ParametroEvaluacionInv;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(ValoracionParametroEvaluacionInv.class)
public class ValoracionParametroEvaluacionInv_ { 

    public static volatile SingularAttribute<ValoracionParametroEvaluacionInv, Integer> id;
    public static volatile SingularAttribute<ValoracionParametroEvaluacionInv, Integer> orden;
    public static volatile SingularAttribute<ValoracionParametroEvaluacionInv, ParametroEvaluacionInv> parametroEvaluacion;
    public static volatile SingularAttribute<ValoracionParametroEvaluacionInv, String> descripcion;
    public static volatile SingularAttribute<ValoracionParametroEvaluacionInv, BigDecimal> puntaje;

}