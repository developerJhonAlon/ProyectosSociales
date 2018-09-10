package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.EvaluacionParDetalle;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(EvaluacionPar.class)
public class EvaluacionPar_ { 

    public static volatile SingularAttribute<EvaluacionPar, Integer> id;
    public static volatile SingularAttribute<EvaluacionPar, SeaParesConvoca> par;
    public static volatile SingularAttribute<EvaluacionPar, String> estadoFinalizado;
    public static volatile SingularAttribute<EvaluacionPar, Date> fechaCreacion;
    public static volatile ListAttribute<EvaluacionPar, EvaluacionParDetalle> evaluacionDetalleList;
    public static volatile SingularAttribute<EvaluacionPar, String> observaciones;
    public static volatile SingularAttribute<EvaluacionPar, Date> fechaModificacion;

}