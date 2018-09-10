package ec.edu.espe_ctt_investigacion.entity;

import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaBasesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaComisionXConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProy;
import ec.edu.espe_ctt_investigacion.entity.SeaFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaNoFinanciaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaParametrosDet;
import ec.edu.espe_ctt_investigacion.entity.SeaParesConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaPorcenXCrConvoca;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T16:19:09")
@StaticMetamodel(SeaConvoca.class)
public class SeaConvoca_ { 

    public static volatile SingularAttribute<SeaConvoca, BigDecimal> convocaFinanciamiento;
    public static volatile SingularAttribute<SeaConvoca, Date> convocaFechaFin;
    public static volatile SingularAttribute<SeaConvoca, String> convocaEvalua1;
    public static volatile SingularAttribute<SeaConvoca, String> convocaEvalua2;
    public static volatile ListAttribute<SeaConvoca, SeaPorcenXCrConvoca> seaPorcenXCrConvocaList;
    public static volatile ListAttribute<SeaConvoca, SeaNoFinanciaConvoca> noFinanciamientoRecursoList;
    public static volatile SingularAttribute<SeaConvoca, SeaParametrosDet> prdId;
    public static volatile SingularAttribute<SeaConvoca, String> financiamientoObservaciones;
    public static volatile SingularAttribute<SeaConvoca, String> convocaAnio;
    public static volatile ListAttribute<SeaConvoca, SeaComisionXConvoca> seaComisionXConvocaList;
    public static volatile SingularAttribute<SeaConvoca, String> documentoComisionNombre;
    public static volatile SingularAttribute<SeaConvoca, String> convocaDocNombre;
    public static volatile ListAttribute<SeaConvoca, SeaDatGeneralProy> seaDatGeneralProyList;
    public static volatile SingularAttribute<SeaConvoca, String> convocaFormatoF1;
    public static volatile SingularAttribute<SeaConvoca, String> convocaEstado;
    public static volatile SingularAttribute<SeaConvoca, String> convocaFormatoF2;
    public static volatile SingularAttribute<SeaConvoca, String> convocaCalifica1;
    public static volatile SingularAttribute<SeaConvoca, BigDecimal> convocaId;
    public static volatile SingularAttribute<SeaConvoca, String> convocaCalifica2;
    public static volatile SingularAttribute<SeaConvoca, Date> convocaFechaInicia;
    public static volatile ListAttribute<SeaConvoca, SeaBasesConvoca> seaBasesConvocaList;
    public static volatile SingularAttribute<SeaConvoca, byte[]> documentoComisionDigital;
    public static volatile SingularAttribute<SeaConvoca, BigInteger> convocaSecuencial;
    public static volatile SingularAttribute<SeaConvoca, String> convocaTitulo;
    public static volatile ListAttribute<SeaConvoca, SeaFinanciaConvoca> financiamientoRecursoList;
    public static volatile SingularAttribute<SeaConvoca, Serializable> convocaDigital;
    public static volatile SingularAttribute<SeaConvoca, String> convocaCodigo;
    public static volatile ListAttribute<SeaConvoca, SeaParesConvoca> seaParesConvocaList;
    public static volatile SingularAttribute<SeaConvoca, String> convocaSeleccionF2;
    public static volatile SingularAttribute<SeaConvoca, SegUsuario> usuId;

}