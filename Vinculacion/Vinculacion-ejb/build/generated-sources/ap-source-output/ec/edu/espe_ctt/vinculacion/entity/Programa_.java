package ec.edu.espe_ctt.vinculacion.entity;

import ec.edu.espe_ctt.saturno.entity.Stvcamp;
import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.vinculacion.entity.ActividadPrograma;
import ec.edu.espe_ctt.vinculacion.entity.AnexoProyecto;
import ec.edu.espe_ctt.vinculacion.entity.CarreraPrograma;
import ec.edu.espe_ctt.vinculacion.entity.DepartamentoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.EntidadEjecutoraPrograma;
import ec.edu.espe_ctt.vinculacion.entity.EstrategiaPlanVinculaPrograma;
import ec.edu.espe_ctt.vinculacion.entity.IndicadorEstrategiaProyecto;
import ec.edu.espe_ctt.vinculacion.entity.LeccionAprendidaPrograma;
import ec.edu.espe_ctt.vinculacion.entity.LocalizacionPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoBVivirPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPlanVinculaPrograma;
import ec.edu.espe_ctt.vinculacion.entity.ObjetivoPrograma;
import ec.edu.espe_ctt.vinculacion.entity.Proyecto;
import ec.edu.espe_ctt.vinculacion.entity.ResponsableProyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:20:18")
@StaticMetamodel(Programa.class)
public class Programa_ { 

    public static volatile ListAttribute<Programa, EntidadEjecutoraPrograma> entidadEjecutoraList;
    public static volatile SingularAttribute<Programa, String> politicas;
    public static volatile SingularAttribute<Programa, String> factorCExito;
    public static volatile ListAttribute<Programa, DepartamentoPrograma> departamentoProgramaList;
    public static volatile ListAttribute<Programa, Proyecto> proyectoList;
    public static volatile SingularAttribute<Programa, Date> fechaFin;
    public static volatile SingularAttribute<Programa, Date> fechaPresentacion;
    public static volatile ListAttribute<Programa, ObjetivoPrograma> objetivoProgramaList;
    public static volatile SingularAttribute<Programa, String> perderiaNoEjecuta;
    public static volatile SingularAttribute<Programa, String> nombre;
    public static volatile SingularAttribute<Programa, Integer> id;
    public static volatile ListAttribute<Programa, ActividadPrograma> actividadPlanificadaList;
    public static volatile ListAttribute<Programa, ObjetivoPlanVinculaPrograma> objetivoPlanVinculacionList;
    public static volatile ListAttribute<Programa, IndicadorEstrategiaProyecto> objetivoEstrategicoList;
    public static volatile SingularAttribute<Programa, Stvsubj> departamento;
    public static volatile SingularAttribute<Programa, Date> fechaCierre;
    public static volatile ListAttribute<Programa, ObjetivoBVivirPrograma> objetivoBVivirProyectoList;
    public static volatile SingularAttribute<Programa, String> evaluacionCualitativa;
    public static volatile SingularAttribute<Programa, String> metas;
    public static volatile SingularAttribute<Programa, String> ubicacion;
    public static volatile SingularAttribute<Programa, Date> fechaInicio;
    public static volatile SingularAttribute<Programa, String> viabilidadTecnica;
    public static volatile SingularAttribute<Programa, String> beneficios;
    public static volatile SingularAttribute<Programa, String> lineaBase;
    public static volatile SingularAttribute<Programa, String> estadoActivo;
    public static volatile SingularAttribute<Programa, String> resumen;
    public static volatile SingularAttribute<Programa, String> resultadosImpacto;
    public static volatile ListAttribute<Programa, EstrategiaPlanVinculaPrograma> estrategiasPlanVinculacionList;
    public static volatile ListAttribute<Programa, LocalizacionPrograma> objetivosProvCanParr;
    public static volatile SingularAttribute<Programa, String> estado;
    public static volatile ListAttribute<Programa, AnexoProyecto> anexoList;
    public static volatile SingularAttribute<Programa, String> diagnostico;
    public static volatile ListAttribute<Programa, LeccionAprendidaPrograma> leccionAprendidaList;
    public static volatile ListAttribute<Programa, CarreraPrograma> carreraProgramaList;
    public static volatile SingularAttribute<Programa, Date> fechaEvaluacionFinal;
    public static volatile SingularAttribute<Programa, Integer> cobertura;
    public static volatile ListAttribute<Programa, ResponsableProyecto> responsableList;
    public static volatile SingularAttribute<Programa, Stvcamp> campus;

}