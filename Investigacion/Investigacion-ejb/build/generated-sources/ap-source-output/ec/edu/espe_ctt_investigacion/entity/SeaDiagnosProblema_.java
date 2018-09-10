package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.entity.SeaTablaContenido;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaDiagnosProblema.class)
public class SeaDiagnosProblema_ { 

    public static volatile SingularAttribute<SeaDiagnosProblema, BigDecimal> sdpId;
    public static volatile SingularAttribute<SeaDiagnosProblema, String> sdpSituacionActualTema;
    public static volatile SingularAttribute<SeaDiagnosProblema, SeaFormatoLargo> sflId;
    public static volatile SingularAttribute<SeaDiagnosProblema, String> sdpIdentificaDescripProblem;
    public static volatile ListAttribute<SeaDiagnosProblema, SeaTablaContenido> tablaContenidoList;

}