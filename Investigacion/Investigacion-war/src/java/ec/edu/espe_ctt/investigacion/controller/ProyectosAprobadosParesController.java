/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt.investigacion.controller;

import ec.edu.espe_ctt.investigacion.utils.FacesUtils;
import ec.edu.espe_ctt.investigacion.utils.JasperReportUtil;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;
import ec.edu.espe_ctt_investigacion.entity.SeaConvoca;
import ec.edu.espe_ctt_investigacion.entity.SeaFormatoLargo;
import ec.edu.espe_ctt_investigacion.session.SeaComisionXConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaConvocaFacade;
import ec.edu.espe_ctt_investigacion.session.SeaFormatoLargoFacade;
import ec.edu.espe_ctt_investigacion.session.SeaParesConvocaFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC1
 */
@ManagedBean
@ViewScoped
public class ProyectosAprobadosParesController implements Serializable {

    @EJB
    private SeaFormatoLargoFacade proyectoFacade;
    private List<SeaFormatoLargo> proyectoList;
    private SegUsuario usuarioActual;
    private List<SeaConvoca> convocatoriaList;
    @EJB
    private SeaParesConvocaFacade paresFacade;
    @EJB
    private SeaComisionXConvocaFacade comisionConvocatoriaFacade;
    private BigDecimal idConvocatoriaSelected;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        usuarioActual = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
        List<SeaConvoca> convList = comisionConvocatoriaFacade.findConvocatoriaByUsuario(usuarioActual.getUsuId());
        List<SeaFormatoLargo> proyList = proyectoFacade.findByAprobadoPar(null);
        convocatoriaList= new ArrayList<>();
        for (SeaConvoca c : convList) {
            for (SeaFormatoLargo p : proyList) {
                if (c.equals(p.getDatgeproyId().getConvocaId())){
                    convocatoriaList.add(c);
                    break;
                }
            }
        }
    }
    public void listarProyectos() {
        proyectoList = new ArrayList<>();
        if (idConvocatoriaSelected!=null){
            proyectoList = proyectoFacade.findByAprobadoPar(idConvocatoriaSelected);
        }
    }

    public List<SeaFormatoLargo> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<SeaFormatoLargo> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public List<SeaConvoca> getConvocatoriaList() {
        return convocatoriaList;
    }

    public void setConvocatoriaList(List<SeaConvoca> convocatoriaList) {
        this.convocatoriaList = convocatoriaList;
    }

    public BigDecimal getIdConvocatoriaSelected() {
        return idConvocatoriaSelected;
    }

    public void setIdConvocatoriaSelected(BigDecimal idConvocatoriaSelected) {
        this.idConvocatoriaSelected = idConvocatoriaSelected;
    }



    public void exportarReportePDF() {
        generarReporte(JasperReportUtil.TIPO_PDF);
    }    

    public void exportarReporteXLS() {
        generarReporte(JasperReportUtil.TIPO_XLS);
    }    
    private void generarReporte(String tipoReporte) {
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("SUBREPORT_DIR", JasperReportUtil.PATH);
            parametros.put("pathAplicacion", JasperReportUtil.PATH_APLICACION);
            for (SeaConvoca c : convocatoriaList) {
                if (c.getConvocaId().equals(idConvocatoriaSelected)){
                    parametros.put("convocatoria", c.getConvocaTitulo());
                    parametros.put("presidenteComision", c.getNombrePresidenteComision());
                    break;
                }
            }
            
            JasperReportUtil jasperBean = (JasperReportUtil) FacesUtils.getManagedBean(JasperReportUtil.NOMBRE_BEAN);
            jasperBean.generarReporte(JasperReportUtil.PATH_REPORTE_PROYECTOS_APROBADOS_PARES, tipoReporte, parametros, proyectoList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
