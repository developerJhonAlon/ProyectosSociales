package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.AprobacionDirectorDepartamento;
import ec.edu.espe_ctt_investigacion.entity.CalificacionComision;
import ec.edu.espe_ctt_investigacion.entity.SeaCobertura;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDepcenproy;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPresupNotasc;
import ec.edu.espe_ctt_investigacion.entity.SeaPrograma;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoInvestigacion;
import ec.edu.espe_ctt_investigacion.entity.SeaTotalPresupnc;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaDatGeneralProy.class)
public class SeaDatGeneralProy_ { 

    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyDescrip;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyImpactoResult;
    public static volatile ListAttribute<SeaDatGeneralProy, SeaTotalPresupnc> seaTotalPresupncList;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyTiempoEjecucion;
    public static volatile ListAttribute<SeaDatGeneralProy, SeaDepcenproy> departamentoList;
    public static volatile SingularAttribute<SeaDatGeneralProy, SeaLineainves> lineaId;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyConsecuencias;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyMetodologia;
    public static volatile SingularAttribute<SeaDatGeneralProy, SeaParametrosDet> prdId;
    public static volatile ListAttribute<SeaDatGeneralProy, SeaPresupNotasc> seaPresupNotascList;
    public static volatile SingularAttribute<SeaDatGeneralProy, BigDecimal> datgeproyId;
    public static volatile SingularAttribute<SeaDatGeneralProy, SeaTipoInvestigacion> tipinveId;
    public static volatile ListAttribute<SeaDatGeneralProy, AprobacionDirectorDepartamento> aprobacionDirectorDepartamentoList;
    public static volatile SingularAttribute<SeaDatGeneralProy, Date> datgeproyFechaCreacion;
    public static volatile SingularAttribute<SeaDatGeneralProy, Character> datgeproyEstado;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyConsideraciones;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyPagilegNombre;
    public static volatile SingularAttribute<SeaDatGeneralProy, byte[]> datgeproyPaglegDigi;
    public static volatile SingularAttribute<SeaDatGeneralProy, Date> fechaPriorizacion;
    public static volatile SingularAttribute<SeaDatGeneralProy, SeaConvoca> convocaId;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyPresupuestoArchi;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyObjetivo;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyResultadoEspera;
    public static volatile SingularAttribute<SeaDatGeneralProy, BigDecimal> datgeproyFinanciaTotal;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyTransferResult;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyAnexosNom;
    public static volatile SingularAttribute<SeaDatGeneralProy, byte[]> datgeproyPlanDigi;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyJustificacion;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyTitulo;
    public static volatile ListAttribute<SeaDatGeneralProy, CalificacionComision> calificacionComisionList;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyPlantNombre;
    public static volatile SingularAttribute<SeaDatGeneralProy, String> datgeproyResumen;
    public static volatile ListAttribute<SeaDatGeneralProy, SeaCobertura> coberturaList;
    public static volatile SingularAttribute<SeaDatGeneralProy, SeaPrograma> progId;
    public static volatile SingularAttribute<SeaDatGeneralProy, BigDecimal> datgeproyFinanciaOtras;
    public static volatile SingularAttribute<SeaDatGeneralProy, SegUsuario> usuId;
    public static volatile SingularAttribute<SeaDatGeneralProy, Serializable> datgeproyPresupuesto;
    public static volatile SingularAttribute<SeaDatGeneralProy, byte[]> datgeproyAnexosDigi;
    public static volatile ListAttribute<SeaDatGeneralProy, SeaResponsableProg> responsableList;
    public static volatile ListAttribute<SeaDatGeneralProy, SeaParesConvoca> parEvaluacionList;

}