package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaSeguimientoFormato;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaInformeDirectorFormato.class)
public class SeaInformeDirectorFormato_ { 

    public static volatile SingularAttribute<SeaInformeDirectorFormato, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<SeaInformeDirectorFormato, BigDecimal> sidfId;
    public static volatile SingularAttribute<SeaInformeDirectorFormato, String> sidfAnalisis;
    public static volatile SingularAttribute<SeaInformeDirectorFormato, BigDecimal> sidfPorcentajeProgram;
    public static volatile SingularAttribute<SeaInformeDirectorFormato, BigDecimal> sidfPorcetajeRealizada;
    public static volatile SingularAttribute<SeaInformeDirectorFormato, String> sidfObservacion;
    public static volatile SingularAttribute<SeaInformeDirectorFormato, SegUsuario> usuId;
    public static volatile SingularAttribute<SeaInformeDirectorFormato, SeaSeguimientoFormato> ssefId;

}