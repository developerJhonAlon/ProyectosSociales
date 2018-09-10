/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.saturno.entity.Stvsubj;
import ec.edu.espe_ctt.saturno.session.StvsubjFacade;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt.seguridades.navegacion.MensajeController;
import ec.edu.espe_ctt.seguridades.session.SegUsuarioFacade;
import ec.edu.espe_ctt_investigacion.entity.SeaCanton;
import ec.edu.espe_ctt_investigacion.entity.SeaCobertura;
import ec.edu.espe_ctt_investigacion.entity.SeaDatGeneralProg;
import ec.edu.espe_ctt_investigacion.entity.SeaLineainves;
import ec.edu.espe_ctt_investigacion.entity.SeaLocaliza;
import ec.edu.espe_ctt_investigacion.entity.SeaObjetivosProg;
import ec.edu.espe_ctt_investigacion.entity.SeaObplanbv;
import ec.edu.espe_ctt_investigacion.entity.SeaOpcionInstitucion;
import ec.edu.espe_ctt_investigacion.entity.SeaParroquia;
import ec.edu.espe_ctt_investigacion.entity.SeaPrograma;
import ec.edu.espe_ctt_investigacion.entity.SeaProvincia;
import ec.edu.espe_ctt_investigacion.entity.SeaResponsableProg;
import ec.edu.espe_ctt_investigacion.entity.SeaTipoRespons;
import ec.edu.espe_ctt_investigacion.entity.SeaViabilidadProg;
import ec.edu.espe_ctt_investigacion.entity.Szdtaproglin;
import ec.edu.espe_ctt_investigacion.entity.VDocenteDeptoB;
import ec.edu.espe_ctt_investigacion.session.SeaCantonFacade;
import ec.edu.espe_ctt_investigacion.session.SeaCoberturaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaDatGeneralProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaLineainvesFacade;
import ec.edu.espe_ctt_investigacion.session.SeaLocalizaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObjetivosProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaObplanbvFacade;
import ec.edu.espe_ctt_investigacion.session.SeaOpcionInstitucionFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParroquiaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProgramaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaProvinciaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaResponsableProgFacade;
import ec.edu.espe_ctt_investigacion.session.SeaTipoResponsFacade;
import ec.edu.espe_ctt_investigacion.session.SeaViabilidadProgFacade;
import ec.edu.espe_ctt_investigacion.session.SzdtaproglinFacade;
import ec.edu.espe_ctt_investigacion.session.VDocenteDeptoBFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ProgramaController implements Serializable {

    @Resource(name = "ds_conn")
    private DataSource ds_conn;
    private Connection connection;
    private String realPath = "";
    public boolean controlPDF = false;
    private String nombreArchivoPdf;

    /**
     * Creates a new instance of ProgramaController
     */
    public ProgramaController() {
    }

    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    @EJB
    private SegUsuarioFacade usuarioFacade;
    private SegUsuario usuario;
    private boolean botonInicio = true;
    private boolean habilitaTab = true;
    @EJB
    private SeaResponsableProgFacade seaResProFacade;
    private List<SeaResponsableProg> seaResProList;
    private String programa = "";

    ///tab1
    @EJB
    private SeaProgramaFacade programaFacade;
    private SeaPrograma seaprograma;
    private List<SeaPrograma> programaList;
    private boolean validaVaciosP1 = true;
    private String idPrograma = "";
    private String prgIngles = "";
    private String nombre = "";

    //private String lineaInvest ="";
    private String sublinea;
    private String var;

    /// LÃ­neas de Investigacion
    @EJB
    private SeaLineainvesFacade lineasinvesFacade;
    private SeaLineainves lineasInvestigacion;
    private List<SeaLineainves> lineasinvesList;
    private List<SeaLineainves> sublineaList;
    private String lineaInvest;
    private SeaLineainves sublineasInvestigacion;

    /// Datos Generales Programa
    @EJB
    private SeaDatGeneralProgFacade datgeneralFacade;
    private SeaDatGeneralProg datosGeneralesPrograma;
    private List<SeaDatGeneralProg> datosGeneralesProList;
    private boolean validaVaciosP5 = true;
    private String resumenProg = "";
    private String objetProg = "";

    //variables Tab 2
    @EJB
    private SeaProgramaFacade seaProFacade;
    private SeaPrograma seaPro;
    @EJB
    private SeaCoberturaFacade seaCobFacade;
    private SeaCobertura seaCob;
    @EJB
    private SeaLocalizaFacade seaLocFacade;
    private SeaLocaliza seaLoc;
    private List<SeaLocaliza> seaLocList;

    @EJB
    private SeaDatGeneralProgFacade seaDatGenProFacade;
    private SeaDatGeneralProg seaDatGenPro;

    @EJB
    private SeaObplanbvFacade seaBueVivFacade;
    private List<SeaObplanbv> seaBueVivList;

    @EJB
    private SeaProvinciaFacade proFacade;
    private List<SelectItem> itemListProCob = new ArrayList<>();
    private boolean controlProCob = true;
    @EJB
    private SeaCantonFacade canFacade;
    private List<SelectItem> itemListCanCob = new ArrayList<>();
    private boolean controlCanCob = true;
    @EJB
    private SeaParroquiaFacade parFacade;
    private List<SelectItem> itemListParCob = new ArrayList<>();
    private boolean controlParCob = true;
    private boolean controlGrabar = true;
    private boolean validaVaciosP2 = true;

    //// tab3
    @EJB
    private SeaOpcionInstitucionFacade opcionInstitucionFacade;
    private SeaOpcionInstitucion opcionInstitucion;
    private SeaOpcionInstitucion opcionInstitucionSelected;
    private List<SeaOpcionInstitucion> institucionList;
    private boolean validaVaciosP3 = true;
    private String institucion = "";
    private String direccInst = "";
    private String ciudadInst = "";
    private String correoInst = "";
    private String paginaWebInst = "";
    private String telefInst = "";
    private String faxInst = "";
    private String fechPresentacion = "";
    private Date fechPresentacionDate = null;
    private String fechInicio = "";
    private Date fechInicioDate = null;
    private String fechFin = "";
    private Date fechFinDate = null;
    private boolean controlGrabar3 = false;
    private boolean controlGrabarP11 = false;
    private boolean validaVaciosP11 = true;
    //variables Tab 4    
    @EJB
    private SeaResponsableProgFacade responsableProgFacade;
    private List<SeaResponsableProg> responsableProgList;
    private boolean validaVaciosP4 = true;
    private boolean controlGrabarP4 = false;
    private SeaResponsableProg responsablePrograma;
    private SeaResponsableProg responsableProgramaSelected;

    @EJB
    private SegUsuarioFacade docenteProgFacade;
    private List<SegUsuario> docenteProgList;
    @EJB
    private SeaTipoResponsFacade tipoResponDoceFacade;
    private List<SeaTipoRespons> tipoResponDoceList;

    ///Objetivos Programa tab5
    @EJB
    private SeaObjetivosProgFacade objetivoProgFacade;
    private SeaObjetivosProg objetivoPrograma;
    private List<SeaObjetivosProg> objPrgList;
    private SeaObjetivosProg objetivoPrgSelected;
    private Integer ordenObjetivo;
    private String ordenObj;

    //variables Tab 6
    private boolean validaVaciosP6 = true;
    @EJB
    private SeaViabilidadProgFacade seaViaProFacade;
    private SeaViabilidadProg seaViaPro;

    ///Vista Docente Departamento B
    @EJB
    private VDocenteDeptoBFacade docenteDeptoBFacade;
    private VDocenteDeptoB docenteDeptoB;
    private List<VDocenteDeptoB> docenteDeptoBList;

    @EJB
    private StvsubjFacade subjFacade;
    private Stvsubj stvSubj;
    private String viatec = "";
    private String perPai = "";
    private String impEsp = "";
    private String impAmb = "";

    /// Líneas y Sub líneas por Proyecto
    @EJB
    private SzdtaproglinFacade szdtaproglinFacade;
    private Szdtaproglin szdtaproglin;
    private Szdtaproglin szdtaproglinSelected;
    private List<Szdtaproglin> szdtaproglinList;

    //</editor-fold>
    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        seaResProList = seaResProFacade.findRespProgByUsu(usuario.getUsuId());
        datosGeneralesProList = datgeneralFacade.findActivos();
        programaList = programaFacade.findPrograma();
        lineasinvesList = lineasinvesFacade.findLineas();
        seaLocList = seaLocFacade.findLocalizaByOrden();
        seaBueVivList = seaBueVivFacade.findAll();
        docenteDeptoBList = docenteDeptoBFacade.findAll();
        tipoResponDoceList = tipoResponDoceFacade.findTipoResponDocentePrograma(new BigDecimal(2));

        

    }

    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public String inicioProgramas() {
        if (botonInicio) {
            /// regresar a lista de programas 
            controlGrabar = true;
            habilitaTab = true;

        } else {
            //// es nuevo 
            datosGeneralesPrograma = new SeaDatGeneralProg();
            controlGrabar = false;
            programaList = programaFacade.findPrograma();
            lineasinvesList = lineasinvesFacade.findLineas();
            cargaDatosPrograma();
        }
        cancelarTotal();
        return "";
    }

    public String seleccionaProyecto() {

        controlGrabar = false;
        botonInicio = false;
        habilitaTab = false;
        cargaDatosPrograma();

        return "";
    }

    void cancelarTotal() {
        cancelarP1();
        cancelarP3();
        cancelarP4();
        cancelarP5();
        cancelarP6();

    }

    public void cargaDatosPrograma() {

        //tab 1
        if (datosGeneralesPrograma.getDatgeprogId() != null) {
            idPrograma = datosGeneralesPrograma.getProgId().getProgId().toString();
            prgIngles = datosGeneralesPrograma.getDatgeprogNombreIngles();
            if (datosGeneralesPrograma.getLineaId() != null) {
                sublinea = datosGeneralesPrograma.getLineaId().getLineaId().toString();
            }
            szdtaproglinList = szdtaproglinFacade.findLineaProgByCodProg(datosGeneralesPrograma.getDatgeprogId());
        }

        //tab 2
        if (seaCob == null) {
            seaCob = new SeaCobertura();
        }

        if (seaCob.getLocalId() == null) {
            seaCob.setLocalId(new SeaLocaliza());
        }
        if (seaDatGenPro == null) {
            seaDatGenPro = new SeaDatGeneralProg();
        }
        if (seaDatGenPro.getObplabvId() == null) {
            seaDatGenPro.setObplabvId(new SeaObplanbv());
        }
        if (seaCob.getPrqId() == null) {
            seaCob.setPrqId(new SeaParroquia());
            seaCob.getPrqId().setCanId(new SeaCanton());
            seaCob.getPrqId().getCanId().setProId(new SeaProvincia());
        }
        //// tab3
        if (datosGeneralesPrograma.getDatgeprogId() != null) {
            institucionList = opcionInstitucionFacade.findOpcionInstitucion(datosGeneralesPrograma.getDatgeprogId());
            fechPresentacionDate = datosGeneralesPrograma.getDatgeprogFechaPresenta();
            fechInicioDate = datosGeneralesPrograma.getDatgeprogFechaInicio();
            fechFinDate = datosGeneralesPrograma.getDatgeprogFechaFin();
        }

        ///tab 4
        if (datosGeneralesPrograma.getDatgeprogId() != null) {
            responsableProgList = responsableProgFacade.findRespProgByDatPro(datosGeneralesPrograma.getDatgeprogId());
        }

        docenteProgList = docenteProgFacade.findEsTudiantesByName(nombre);
        if (responsablePrograma == null) {
            responsablePrograma = new SeaResponsableProg();
            responsablePrograma.setUsuIdDocente(new SegUsuario());
            responsablePrograma.setTipresId(new SeaTipoRespons());
        }

        /// tab 5
        // objPrgList = objetivoProgFacade.findObjetivoProgramabyPro(datosProgramaSelected.getDatgeprogId());
        if (datosGeneralesPrograma.getDatgeprogId() != null) {
            objPrgList = objetivoProgFacade.findObjetivoProgramabyPro(datosGeneralesPrograma.getDatgeprogId());

        }
        objetivoPrograma = new SeaObjetivosProg();
        //tab6
        if (datosGeneralesPrograma.getDatgeprogId() != null) {
            seaViaPro = seaViaProFacade.findViabilidadbyPro(datosGeneralesPrograma.getDatgeprogId());
        }
        if (seaViaPro == null) {
            seaViaPro = new SeaViabilidadProg();
            seaViaPro.setDatgeprogId(datosGeneralesPrograma);

        }
    }

    public boolean validarVaciosP1() {
        validaVaciosP1 = false;
        idPrograma = idPrograma.trim();
        prgIngles = prgIngles.trim();
        if (idPrograma.isEmpty()) {
            validaVaciosP1 = true;
        }
        if (prgIngles.isEmpty()) {
            validaVaciosP1 = true;
        }
        return validaVaciosP1;
    }

    public String registraP1() {
        SeaPrograma programaEspanol = new SeaPrograma();
        programaEspanol.setProgId(new BigDecimal(idPrograma));
        datosGeneralesPrograma.setDatgeprogNombreIngles(prgIngles);
        datosGeneralesPrograma.setProgId(programaEspanol);
        if (datosGeneralesPrograma.getDatgeprogId() != null) {
            datgeneralFacade.edit(datosGeneralesPrograma);
        } else {
            datgeneralFacade.create(datosGeneralesPrograma);
            habilitaTab = false;
            validaVaciosP1 = true;
        }
        datosGeneralesPrograma= datgeneralFacade.find(datosGeneralesPrograma.getDatgeprogId());
        cargaDatosPrograma();
        validaVaciosP1 = true;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "La información se guardó exitosamente"));
        return "";
    }

    public void onLineaChange() {
        SeaLineainves subl = new SeaLineainves();
        sublineaList = lineasinvesFacade.findSublinea(new BigDecimal(lineaInvest));

    }

    public void cancelarP1() {
        //inicializar variables de entrada
        // datosGeneralesPrograma = null;
        idPrograma = "";
        prgIngles = "";
        lineaInvest = "";
        sublinea = "";
        validaVaciosP1 = true;

    }

    public String agregarP11() {
        controlGrabarP11 = true;
        return "";
    }

    public String registraP11() {
        lineasInvestigacion = new SeaLineainves();
        lineasInvestigacion.setLineaId(new BigDecimal(sublinea));
        szdtaproglin = new Szdtaproglin();
        szdtaproglin.setLineaId(lineasInvestigacion);
        szdtaproglin.setDatgeprogId(datosGeneralesPrograma);
        szdtaproglinFacade.create(szdtaproglin);
        szdtaproglinList = szdtaproglinFacade.findLineaProgByCodProg(datosGeneralesPrograma.getDatgeprogId());
        cancelarP1();
        return "";
    }

    public void cancelarP11() {
        controlGrabarP11 = false;
        sublinea = "";
        validaVaciosP11 = true;
    }

    public void eliminarP11() {
        szdtaproglinFacade.remove(szdtaproglin);
        szdtaproglinList = szdtaproglinFacade.findLineaProgByCodProg(datosGeneralesPrograma.getDatgeprogId());
    }

    public boolean validarVaciosP11() {
        validaVaciosP11 = false;
        sublinea = sublinea.trim();
        if (sublinea.isEmpty()) {
            validaVaciosP11 = true;
        }
        return validaVaciosP11;
    }
    //funciones Tab2

    public void onChangeProvinciaCobertura(ValueChangeEvent event) {
        if (event.getNewValue() != null) {
            itemListCanCob = obtenerCantonCobertura((String) event.getNewValue(), itemListCanCob);
        } else {
            itemListCanCob.clear();
        }
        itemListParCob.clear();
    }

    public void onChangeCantonCobertura(ValueChangeEvent event) {
        if (event.getNewValue() != null) {
            itemListParCob = this.obtenerParroquiaCobertura((String) event.getNewValue(), itemListParCob);
        } else {
            itemListParCob.clear();
        }
        //eliminar_mensajes_info();
    }

    private List<SelectItem> obtenerProvinciaCobertura(List<SelectItem> item) {
        item.clear();
        List<SeaProvincia> lprovincia = proFacade.findAllOrdenados();
        Iterator<SeaProvincia> iterat = lprovincia.iterator();
        while (iterat.hasNext()) {
            SeaProvincia provi = iterat.next();
            item.add(new SelectItem(provi.getProId(), provi.getProNombre()));
        }
        lprovincia = null;
        iterat = null;
        return item;
    }

    private List<SelectItem> obtenerCantonCobertura(String codProv, List<SelectItem> item) {
        item.clear();
        List<SeaCanton> lcanton = canFacade.findByProvincia(codProv);
        Iterator<SeaCanton> iterat = lcanton.iterator();
        while (iterat.hasNext()) {
            SeaCanton cant = iterat.next();
            item.add(new SelectItem(cant.getCanId(), cant.getCanNombre()));
        }
        lcanton = null;
        iterat = null;
        return item;
    }

    private List<SelectItem> obtenerParroquiaCobertura(String codCanton, List<SelectItem> item) {
        item.clear();
        List<SeaParroquia> lparroquia = parFacade.findByCanton(codCanton);
        Iterator<SeaParroquia> iterat = lparroquia.iterator();
        while (iterat.hasNext()) {
            SeaParroquia parro = iterat.next();
            item.add(new SelectItem(parro.getPrqId(), parro.getPrqNombre()));
        }
        lparroquia = null;
        iterat = null;
        return item;
    }

    public void registraP2() {
        SeaParroquia parroquia = new SeaParroquia();
        SeaLocaliza localizacion = new SeaLocaliza();
        SeaObplanbv objetivo = new SeaObplanbv();

        localizacion.setLocalId(seaCob.getLocalId().getLocalId());
        parroquia.setPrqId(seaCob.getPrqId().getPrqId());
        objetivo.setObplabvId(seaDatGenPro.getObplabvId().getObplabvId());
        seaCob.setLocalId(localizacion);
        seaCob.setPrqId(parroquia);

        seaDatGenPro = datosGeneralesPrograma;
        seaDatGenPro.setObplabvId(objetivo);
        datgeneralFacade.edit(seaDatGenPro);

        seaCob.setDatgeprogId(datosGeneralesPrograma);
        if (seaCob.getCobertId() == null) {
            seaCobFacade.create(seaCob);
        } else {
            seaCobFacade.edit(seaCob);
        }

        //seaDatGenProFacade.edit(seaDatGenPro);
        cancelarP2();
    }

    public void cancelarP2() {
        validaVaciosP2 = true;
    }

    public boolean validarVaciosP2() {
        validaVaciosP2 = false;
        //validar que no esten vacias

        if (seaCob.getLocalId().getLocalId() == null) {
            validaVaciosP2 = true;
        }
        if (seaCob.getPrqId().getPrqId() == null) {
            validaVaciosP2 = true;
        }
        if (seaDatGenPro.getObplabvId().getObplabvId() == null) {
            validaVaciosP2 = true;
        }
        return validaVaciosP2;
    }
    //funciones tab 3

    public String aregarP3() {
        controlGrabar3 = true;
        return "";
    }

    public void cancelarP3() {
        //inicializar variables de entrada
        controlGrabar3 = false;
        institucion = "";
        direccInst = "";
        ciudadInst = "";
        correoInst = "";
        paginaWebInst = "";
        telefInst = "";
        faxInst = "";
        fechInicio = "";
        fechInicioDate = null;
        fechPresentacion = "";
        fechPresentacionDate = null;
        fechFin = "";
        fechFinDate = null;
        validaVaciosP3 = true;
    }

    public boolean validarVaciosP3() {
        validaVaciosP3 = false;
        institucion = institucion.trim();
        direccInst = direccInst.trim();
        ciudadInst = ciudadInst.trim();
        correoInst = correoInst.trim();
        paginaWebInst = paginaWebInst.trim();
        telefInst = telefInst.trim();
        if (fechPresentacionDate != null) {
            fechPresentacion = fechPresentacionDate.toString();
            fechPresentacion = fechPresentacion.trim();
        }
        if (fechInicioDate != null) {
            fechInicio = fechInicioDate.toString();
            fechInicio = fechInicio.trim();
        }
        if (fechFinDate != null) {
            fechFin = fechFinDate.toString();
            fechFin = fechFin.trim();
        }
        faxInst = faxInst.trim();
        if (institucion.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (direccInst.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (ciudadInst.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (correoInst.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (paginaWebInst.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (telefInst.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (fechPresentacion.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (fechInicio.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (fechFin.isEmpty()) {
            validaVaciosP3 = true;
        }
        if (faxInst.isEmpty()) {
            validaVaciosP3 = true;
        }

        return validaVaciosP3;
    }

    public String registraP3() {

        opcionInstitucion = new SeaOpcionInstitucion();
        opcionInstitucion.setOpinstiNombre(institucion);
        opcionInstitucion.setOpinstiDireccion(direccInst);
        opcionInstitucion.setOpinstiCiudad(ciudadInst);
        opcionInstitucion.setOpinstiMail(correoInst);
        opcionInstitucion.setOpinstiPaguinaWeb(paginaWebInst);
        opcionInstitucion.setOpinstiTelefono(telefInst);
        opcionInstitucion.setOpinstiFax(faxInst);
        opcionInstitucion.setDatgeprogId(datosGeneralesPrograma);
        opcionInstitucionFacade.create(opcionInstitucion);

        institucionList = opcionInstitucionFacade.findOpcionInstitucion(datosGeneralesPrograma.getDatgeprogId());
        cancelarP3();
        validaVaciosP3 = true;
        return "";
    }

    public void eliminarP3() {
        Integer registro = 0;
        if (opcionInstitucionSelected != null) {
            SeaOpcionInstitucion eliminar = null;
            for (int i = 0; i < institucionList.size(); i++) {
                SeaOpcionInstitucion elemento = this.institucionList.get(i);
                if (opcionInstitucionSelected.getOpinstiId() == institucionList.get(i).getOpinstiId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println(" ingreso a eliminar");
                this.institucionList.remove(eliminar);
                opcionInstitucionFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP3(RowEditEvent event) {
        SeaOpcionInstitucion opcionInstEdit = new SeaOpcionInstitucion();
        opcionInstEdit = (SeaOpcionInstitucion) event.getObject();
        opcionInstitucionFacade.edit(opcionInstEdit);
        institucionList = opcionInstitucionFacade.findOpcionInstitucion(datosGeneralesPrograma.getDatgeprogId());
    }

    public void onRowCancelP3(RowEditEvent event) {

    }

    //funciones tab p4
    public String agregarP4() {
        controlGrabarP4 = true;
        return "";
    }

    public boolean validarVaciosP4() {
        validaVaciosP4 = false;
        // if (responsablePrograma.getDocId().getDocId() == null) {validaVaciosP4 = true;}
        if (responsablePrograma.getUsuIdDocente().getUsuId() == null) {
            validaVaciosP4 = true;
        }
        if (responsablePrograma.getTipresId().getTipresId() == null) {
            validaVaciosP4 = true;
        }
        return validaVaciosP4;
    }

    public String registraP4() {
        SegUsuario docente = new SegUsuario();
        stvSubj = new Stvsubj();

        SeaTipoRespons tipoRespo = new SeaTipoRespons();
        docenteDeptoB = docenteDeptoBFacade.findCodDeptoByUsuId(responsablePrograma.getUsuIdDocente().getUsuId());
        if (docenteDeptoB != null) {
            String codDepto = docenteDeptoB.getStvsubjCode();
            stvSubj = subjFacade.findDepartamentoByCodDep(codDepto);
        }
        docente = usuarioFacade.findInvstOtrosByCodId(responsablePrograma.getUsuIdDocente().getUsuId());
        tipoRespo = tipoResponDoceFacade.findTipoResponsabilidadByCodTipRes(responsablePrograma.getTipresId().getTipresId());
        if (docente != null) {
            BigDecimal codUsu = docente.getUsuId();
            responsablePrograma = responsableProgFacade.findResponsableProgByCodUsu(codUsu);
        }
        if (responsablePrograma == null) {
            responsablePrograma = new SeaResponsableProg();
            responsablePrograma.setUsuIdDocente(docente);
            responsablePrograma.setTipresId(tipoRespo);
            responsablePrograma.setStvsubjCode(stvSubj);
            responsablePrograma.setDatgeprogId(datosGeneralesPrograma);
            responsableProgFacade.create(responsablePrograma);
        } else {
            RequestContext.getCurrentInstance().execute("alert('El Profesor ya se encuentra Asignado')");
        }

//            if (responsablePrograma.getResprogId() == null){
//                
//            }
//            else{
//                responsableProgFacade.edit(responsablePrograma);
//            }
        responsableProgList = responsableProgFacade.findRespProgByDatPro(datosGeneralesPrograma.getDatgeprogId());
        cancelarP4();
        return "";
    }

    public void cancelarP4() {
        //inicializar variables de entrada
        responsablePrograma.getUsuIdDocente().setUsuId(null);
        responsablePrograma.getTipresId().setTipresId(null);
        controlGrabarP4 = false;
        validaVaciosP4 = true;
        //responsableProgList.clear();
    }

    public void eliminarP4() {
        Integer registro = 0;
        if (responsableProgramaSelected != null) {
            SeaResponsableProg eliminar = null;
            for (int i = 0; i < responsableProgList.size(); i++) {
                SeaResponsableProg elemento = this.responsableProgList.get(i);
                if (responsableProgramaSelected.getResprogId() == responsableProgList.get(i).getResprogId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println(" ingreso a eliminar");
                this.responsableProgList.remove(eliminar);
                responsableProgFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP4(RowEditEvent event) {
        SeaResponsableProg responsableProgEdit = new SeaResponsableProg();

        responsableProgEdit = (SeaResponsableProg) event.getObject();
        responsableProgFacade.edit(responsableProgEdit);
        responsableProgList = responsableProgFacade.findRespProgByDatPro(datosGeneralesPrograma.getDatgeprogId());

    }

    public void onRowCancelP4(RowEditEvent event) {
    }

    //funciones tab p5     
    public void cancelarP5() {
        //inicializar variables de entrada
        objetivoPrograma = null;
        objetProg = "";
        resumenProg = "";
        objPrgList = null;
        validaVaciosP5 = true;
    }

    public boolean validarVaciosP5() {
        validaVaciosP5 = false;
        resumenProg = resumenProg.trim();
        objetProg = objetProg.trim();

        if (resumenProg.isEmpty()) {
            validaVaciosP5 = true;
        }
        if (objetProg.isEmpty()) {
            validaVaciosP5 = true;
        }
        return validaVaciosP5;
    }

    public String registrarP5() {
        System.out.println("datosProgramaSelected  " + datosGeneralesPrograma);
        if (datosGeneralesPrograma != null) {
            datosGeneralesPrograma.setDatgeprogResumen(resumenProg);
            datgeneralFacade.edit(datosGeneralesPrograma);
        }
        objPrgList = objetivoProgFacade.findObjetivoProgramabyPro(datosGeneralesPrograma.getDatgeprogId());
        if (objPrgList != null) {
            ordenObjetivo = objPrgList.size() + 1;
            ordenObj = Integer.toString(ordenObjetivo);
        } else {
            ordenObjetivo = 1;
            ordenObj = Integer.toString(ordenObjetivo);
        }

        if (objetivoPrograma != null) {
            objetivoPrograma = new SeaObjetivosProg();
            objetivoPrograma.setObjprogObjetivo(objetProg);
            objetivoPrograma.setObjprogOrden(new BigInteger(ordenObj));
            objetivoPrograma.setDatgeprogId(datosGeneralesPrograma);
            objetivoProgFacade.create(objetivoPrograma);
        }
        objPrgList = objetivoProgFacade.findObjetivoProgramabyPro(datosGeneralesPrograma.getDatgeprogId());
        return "";
    }

    public void eliminarP5() {
        Integer registro = 0;
        if (objetivoPrgSelected != null) {
            SeaObjetivosProg eliminar = null;
            for (int i = 0; i < objPrgList.size(); i++) {
                SeaObjetivosProg elemento = this.objPrgList.get(i);
                if (objetivoPrgSelected.getObjprogId() == objPrgList.get(i).getObjprogId()) {
                    eliminar = elemento;
                    break;
                }
            }
            System.out.println("eliminar " + eliminar);
            if (eliminar != null) {
                System.out.println(" ingreso a eliminar");
                this.objPrgList.remove(eliminar);
                objetivoProgFacade.remove(eliminar);
                MensajeController m = null;
            }
        }
    }

    public void onRowEditP5(RowEditEvent event) {
        SeaObjetivosProg objetivoProgEdit = new SeaObjetivosProg();
        objetivoProgEdit = (SeaObjetivosProg) event.getObject();

        objetivoProgFacade.edit(objetivoProgEdit);
        objPrgList = objetivoProgFacade.findObjetivoProgramabyPro(datosGeneralesPrograma.getDatgeprogId());

    }

    public void onRowCancelP5(RowEditEvent event) {
    }

    //funcion  tab 6
    public void registraP6() {
        System.out.println(" registra");

        if (seaViaPro.getViaprogId() == null) {
            seaViaProFacade.create(seaViaPro);
        } else {
            seaViaProFacade.edit(seaViaPro);
        }
    }

    public boolean validarVaciosP6() {
        validaVaciosP6 = false;
        if (seaViaPro.getViaprogViabilidadTecnica() == null) {
            validaVaciosP6 = true;
        } else if (seaViaPro.getViaprogViabilidadTecnica().equals("")) {
            validaVaciosP6 = true;
        }
        if (seaViaPro.getViaprogPerderiaPais() == null) {
            validaVaciosP6 = true;
        } else if (seaViaPro.getViaprogPerderiaPais().equals("")) {
            validaVaciosP6 = true;
        }
        if (seaViaPro.getViaprogImpactEsperado() == null) {
            validaVaciosP6 = true;
        } else if (seaViaPro.getViaprogImpactEsperado().equals("")) {
            validaVaciosP6 = true;
        }
        if (seaViaPro.getViaprogImpactAmbiental() == null) {
            validaVaciosP6 = true;
        } else if (seaViaPro.getViaprogImpactAmbiental().equals("")) {
            validaVaciosP6 = true;
        }

        return validaVaciosP6;
    }

    public void cancelarP6() {
    }
    ///// genera Reporte

    public void generaReporteProgramas() throws SQLException, JRException {
        try {
            if (datosGeneralesPrograma != null) {
                String idPrograma = datosGeneralesPrograma.getDatgeprogId().toString();
                connection = ds_conn.getConnection();
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                realPath = servletContext.getRealPath("/reportes/programas");
                Date fecha = new Date();
                String nombreRandomico = Long.toString(fecha.getTime());
                nombreArchivoPdf = nombreRandomico + ".pdf";
                JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(realPath + "/programa.jasper");
                Map<String, Object> parametros = new HashMap<>();
                String logo = servletContext.getRealPath("/resources/images/");
                System.out.println("logo " + logo);
                parametros.put("path", realPath + "/");
                parametros.put("dirPhoto", logo + "/");
                parametros.put("SUBREPORT_DIR", realPath + "/");
                parametros.put("DATGEPROG_ID", idPrograma);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(realPath + "/" + nombreArchivoPdf));
                exporter.exportReport();
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Cache-Control", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Pragma", "no-cache");
                FacesContext.getCurrentInstance().getExternalContext().addResponseHeader("Expires", "0");
                FacesContext.getCurrentInstance().getExternalContext().setResponseContentType("application/pdf");
                connection.close();
                System.out.println("salio");
                controlPDF = true;

            }

        } catch (Exception e) {
            System.out.println("error " + e.getLocalizedMessage());
        }

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public boolean isHabilitaTab() {
        return habilitaTab;
    }

    public void setHabilitaTab(boolean habilitaTab) {
        this.habilitaTab = habilitaTab;
    }

    public boolean isBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(boolean botonInicio) {
        this.botonInicio = botonInicio;
    }

    public List<SeaDatGeneralProg> getDatosGeneralesProList() {
        return datosGeneralesProList;
    }

    public void setDatosGeneralesProList(List<SeaDatGeneralProg> datosGeneralesProList) {
        this.datosGeneralesProList = datosGeneralesProList;
    }

    public List<SeaResponsableProg> getSeaResProList() {
        return seaResProList;
    }

    public void setSeaResProList(List<SeaResponsableProg> seaResProList) {
        this.seaResProList = seaResProList;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public boolean isControlGrabarP11() {
        return controlGrabarP11;
    }

    public void setControlGrabarP11(boolean controlGrabarP11) {
        this.controlGrabarP11 = controlGrabarP11;
    }

    public boolean isValidaVaciosP11() {
        return validaVaciosP11;
    }

    public void setValidaVaciosP11(boolean validaVaciosP11) {
        this.validaVaciosP11 = validaVaciosP11;
    }

    //setter y getter 2
    public SeaPrograma getSeaPro() {
        return seaPro;
    }

    public void setSeaPro(SeaPrograma seaPro) {
        this.seaPro = seaPro;
    }

    public SeaCobertura getSeaCob() {
        return seaCob;
    }

    public void setSeaCob(SeaCobertura seaCob) {
        this.seaCob = seaCob;
    }

    public List<SeaLocaliza> getSeaLocList() {
        return seaLocList;
    }

    public void setSeaLocList(List<SeaLocaliza> seaLocList) {
        this.seaLocList = seaLocList;
    }

    public SeaDatGeneralProg getSeaDatGenPro() {
        return seaDatGenPro;
    }

    public void setSeaDatGenPro(SeaDatGeneralProg seaDatGenPro) {
        this.seaDatGenPro = seaDatGenPro;
    }

    public List<SeaObplanbv> getSeaBueVivList() {
        return seaBueVivList;
    }

    public void setSeaBueVivList(List<SeaObplanbv> seaBueVivList) {
        this.seaBueVivList = seaBueVivList;
    }

    public List<SelectItem> getItemListProCob() {
        if (controlProCob) {
            itemListProCob = this.obtenerProvinciaCobertura(itemListProCob);
            controlProCob = false;
        }
        return itemListProCob;
    }

    public void setItemListProCob(List<SelectItem> itemListProCob) {
        this.itemListProCob = itemListProCob;
    }

    public boolean isControlProCob() {
        return controlProCob;
    }

    public void setControlProCob(boolean controlProCob) {
        this.controlProCob = controlProCob;
    }

    public List<SelectItem> getItemListCanCob() {
        //String codProv = datPernonal.getPrqId().getCanId().getProId().getProId();                
        if (controlCanCob) {

            if (!seaCob.getPrqId().toString().contains("null")) {

                itemListCanCob = this.obtenerCantonCobertura(seaCob.getPrqId().getCanId().getProId().getProId(), itemListCanCob);
            } else {
                itemListCanCob = new ArrayList();
            }

            controlCanCob = false;
        }

        return itemListCanCob;
    }

    public void setItemListCanCob(List<SelectItem> itemListCanCob) {
        this.itemListCanCob = itemListCanCob;
    }

    public boolean isControlCanCob() {
        return controlCanCob;
    }

    public void setControlCanCob(boolean controlCanCob) {
        this.controlCanCob = controlCanCob;
    }

    public List<SelectItem> getItemListParCob() {
        if (controlParCob) {

            if (!seaCob.getPrqId().toString().contains("null")) {
                itemListParCob = this.obtenerParroquiaCobertura(seaCob.getPrqId().getCanId().getCanId(), itemListParCob);
            } else {
                itemListParCob = new ArrayList();
            }

            controlParCob = false;
        }

        return itemListParCob;
    }

    public void setItemListParCob(List<SelectItem> itemListParCob) {
        this.itemListParCob = itemListParCob;
    }

    public boolean isControlParCob() {
        return controlParCob;
    }

    public boolean isControlGrabar() {
        return controlGrabar;
    }

    public void setControlGrabar(boolean controlGrabar) {
        this.controlGrabar = controlGrabar;
    }

    public void setControlParCob(boolean controlParCob) {
        this.controlParCob = controlParCob;
    }

    public boolean isValidaVaciosP2() {
        return validaVaciosP2;
    }

    public void setValidaVaciosP2(boolean validaVaciosP2) {
        this.validaVaciosP2 = validaVaciosP2;
    }

    /// get and set paso1
    public boolean isValidaVaciosP1() {
        return validaVaciosP1;
    }

    public void setValidaVaciosP1(boolean validaVaciosP1) {
        this.validaVaciosP1 = validaVaciosP1;
    }

    public String getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(String idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getPrgIngles() {
        return prgIngles;
    }

    public void setPrgIngles(String prgIngles) {
        this.prgIngles = prgIngles;
    }

    public List<SeaPrograma> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<SeaPrograma> programaList) {
        this.programaList = programaList;
    }

    public List<SeaLineainves> getSublineaList() {
        return sublineaList;
    }

    public void setSublineaList(List<SeaLineainves> sublineaList) {
        this.sublineaList = sublineaList;
    }

    public List<SeaLineainves> getLineasinvesList() {
        return lineasinvesList;
    }

    public void setLineasinvesList(List<SeaLineainves> lineasinvesList) {
        this.lineasinvesList = lineasinvesList;
    }

    public String getSublinea() {
        return sublinea;
    }

    public void setSublinea(String sublinea) {
        this.sublinea = sublinea;
    }

    public String getLineaInvest() {
        return lineaInvest;
    }

    public void setLineaInvest(String lineaInvest) {
        this.lineaInvest = lineaInvest;
    }

    /// get and set p3
    public boolean isValidaVaciosP3() {
        return validaVaciosP3;
    }

    public void setValidaVaciosP3(boolean validaVaciosP3) {
        this.validaVaciosP3 = validaVaciosP3;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDireccInst() {
        return direccInst;
    }

    public void setDireccInst(String direccInst) {
        this.direccInst = direccInst;
    }

    public String getCiudadInst() {
        return ciudadInst;
    }

    public void setCiudadInst(String ciudadInst) {
        this.ciudadInst = ciudadInst;
    }

    public String getCorreoInst() {
        return correoInst;
    }

    public void setCorreoInst(String correoInst) {
        this.correoInst = correoInst;
    }

    public String getPaginaWebInst() {
        return paginaWebInst;
    }

    public void setPaginaWebInst(String paginaWebInst) {
        this.paginaWebInst = paginaWebInst;
    }

    public String getTelefInst() {
        return telefInst;
    }

    public void setTelefInst(String telefInst) {
        this.telefInst = telefInst;
    }

    public String getFaxInst() {
        return faxInst;
    }

    public void setFaxInst(String faxInst) {
        this.faxInst = faxInst;
    }

    public String getFechInicio() {
        return fechInicio;
    }

    public void setFechInicio(String fechInicio) {
        this.fechInicio = fechInicio;
    }

    public Date getFechInicioDate() {
        return fechInicioDate;
    }

    public void setFechInicioDate(Date fechInicioDate) {
        this.fechInicioDate = fechInicioDate;
    }

    public String getFechPresentacion() {
        return fechPresentacion;
    }

    public void setFechPresentacion(String fechPresentacion) {
        this.fechPresentacion = fechPresentacion;
    }

    public Date getFechPresentacionDate() {
        return fechPresentacionDate;
    }

    public void setFechPresentacionDate(Date fechPresentacionDate) {
        this.fechPresentacionDate = fechPresentacionDate;
    }

    public String getFechFin() {
        return fechFin;
    }

    public void setFechFin(String fechFin) {
        this.fechFin = fechFin;
    }

    public Date getFechFinDate() {
        return fechFinDate;
    }

    public void setFechFinDate(Date fechFinDate) {
        this.fechFinDate = fechFinDate;
    }

    public boolean isControlGrabar3() {
        return controlGrabar3;
    }

    public void setControlGrabar3(boolean controlGrabar3) {
        this.controlGrabar3 = controlGrabar3;
    }

    public List<SeaOpcionInstitucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<SeaOpcionInstitucion> institucionList) {
        this.institucionList = institucionList;
    }

    public SeaOpcionInstitucion getOpcionInstitucionSelected() {
        return opcionInstitucionSelected;
    }

    public void setOpcionInstitucionSelected(SeaOpcionInstitucion opcionInstitucionSelected) {
        this.opcionInstitucionSelected = opcionInstitucionSelected;
    }

    //setter y getter tab p4
    public List<SeaResponsableProg> getResponsableProgList() {
        return responsableProgList;
    }

    public void setResponsableProgList(List<SeaResponsableProg> responsableProgList) {
        this.responsableProgList = responsableProgList;
    }

    public List<SegUsuario> getDocenteProgList() {
        return docenteProgList;
    }

    public void setDocenteProgList(List<SegUsuario> docenteProgList) {
        this.docenteProgList = docenteProgList;
    }

    public List<SeaTipoRespons> getTipoResponDoceList() {
        return tipoResponDoceList;
    }

    public void setTipoResponDoceList(List<SeaTipoRespons> tipoResponDoceList) {
        this.tipoResponDoceList = tipoResponDoceList;
    }

    public SeaResponsableProg getResponsablePrograma() {
        return responsablePrograma;
    }

    public void setResponsablePrograma(SeaResponsableProg responsablePrograma) {
        this.responsablePrograma = responsablePrograma;
    }

    public SeaResponsableProg getResponsableProgramaSelected() {
        return responsableProgramaSelected;
    }

    public void setResponsableProgramaSelected(SeaResponsableProg responsableProgramaSelected) {
        this.responsableProgramaSelected = responsableProgramaSelected;
    }

    public boolean isValidaVaciosP4() {
        return validaVaciosP4;
    }

    public void setValidaVaciosP4(boolean validaVaciosP4) {
        this.validaVaciosP4 = validaVaciosP4;
    }
    //setter y getter tab p4 

    public boolean isControlGrabarP4() {
        return controlGrabarP4;
    }

    public void setControlGrabarP4(boolean controlGrabarP4) {
        this.controlGrabarP4 = controlGrabarP4;
    }

    //// get and set p5
    public boolean isValidaVaciosP5() {
        return validaVaciosP5;
    }

    public void setValidaVaciosP5(boolean validaVaciosP5) {
        this.validaVaciosP5 = validaVaciosP5;
    }

    public String getResumenProg() {
        return resumenProg;
    }

    public void setResumenProg(String resumenProg) {
        this.resumenProg = resumenProg;
    }

    public String getObjetProg() {
        return objetProg;
    }

    public void setObjetProg(String objetProg) {
        this.objetProg = objetProg;
    }

    /// get and set p5
    public List<SeaObjetivosProg> getObjPrgList() {
        return objPrgList;
    }

    public void setObjPrgList(List<SeaObjetivosProg> objPrgList) {
        this.objPrgList = objPrgList;
    }

    public SeaObjetivosProg getObjetivoPrgSelected() {
        return objetivoPrgSelected;
    }

    public void setObjetivoPrgSelected(SeaObjetivosProg objetivoPrgSelected) {
        this.objetivoPrgSelected = objetivoPrgSelected;
    }

    //getter y setter 6
    public boolean isValidaVaciosP6() {
        return validaVaciosP6;
    }

    public void setValidaVaciosP6(boolean validaVaciosP6) {
        this.validaVaciosP6 = validaVaciosP6;
    }

    public SeaViabilidadProg getSeaViaPro() {
        return seaViaPro;
    }

    public void setSeaViaPro(SeaViabilidadProg seaViaPro) {
        this.seaViaPro = seaViaPro;
    }

    public List<VDocenteDeptoB> getDocenteDeptoBList() {
        return docenteDeptoBList;
    }

    public void setDocenteDeptoBList(List<VDocenteDeptoB> docenteDeptoBList) {
        this.docenteDeptoBList = docenteDeptoBList;
    }

    public String getViatec() {
        return viatec;
    }

    public void setViatec(String viatec) {
        this.viatec = viatec;
    }

    public String getPerPai() {
        return perPai;
    }

    public void setPerPai(String perPai) {
        this.perPai = perPai;
    }

    public String getImpEsp() {
        return impEsp;
    }

    public void setImpEsp(String impEsp) {
        this.impEsp = impEsp;
    }

    public String getImpAmb() {
        return impAmb;
    }

    public void setImpAmb(String impAmb) {
        this.impAmb = impAmb;
    }

    public boolean isControlPDF() {
        return controlPDF;
    }

    public void setControlPDF(boolean controlPDF) {
        this.controlPDF = controlPDF;
    }

    public String getNombreArchivoPdf() {
        return nombreArchivoPdf;
    }

    public void setNombreArchivoPdf(String nombreArchivoPdf) {
        this.nombreArchivoPdf = nombreArchivoPdf;
    }

    public Szdtaproglin getSzdtaproglin() {
        return szdtaproglin;
    }

    public void setSzdtaproglin(Szdtaproglin szdtaproglin) {
        this.szdtaproglin = szdtaproglin;
    }

    public List<Szdtaproglin> getSzdtaproglinList() {
        return szdtaproglinList;
    }

    public void setSzdtaproglinList(List<Szdtaproglin> szdtaproglinList) {
        this.szdtaproglinList = szdtaproglinList;
    }

    public Szdtaproglin getSzdtaproglinSelected() {
        return szdtaproglinSelected;
    }

    public void setSzdtaproglinSelected(Szdtaproglin szdtaproglinSelected) {
        this.szdtaproglinSelected = szdtaproglinSelected;
    }

//</editor-fold>
    public SeaDatGeneralProg getDatosGeneralesPrograma() {
        return datosGeneralesPrograma;
    }

    public void setDatosGeneralesPrograma(SeaDatGeneralProg datosGeneralesPrograma) {
        this.datosGeneralesPrograma = datosGeneralesPrograma;
    }
}
