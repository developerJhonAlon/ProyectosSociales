/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.seguridades.navegacion;
import ec.edu.espe_ctt.seguridades.entity.SegUsuario;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ing. Cristian Asimbaya
 * Contiene variables globales del sistema
 */
@ManagedBean
@SessionScoped
public class SesionBean  implements Serializable{

       //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
      private SegUsuario usu_login;  
    //</editor-fold>
 
    /**
     * Creates a new instance of SesionBean
     */
    public SesionBean() {
         // Recoger los Objetos de la Sesion
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (usu_login == null) {
                SegUsuario obj = (SegUsuario) context.getExternalContext().getSessionMap().get("usu_login");
                if (obj == null) {
                    try {
                        context.getExternalContext().getRequestContextPath();
                    } catch (Exception ex) {
                        Logger.getLogger(SesionBean.class.getName()).log(Level.SEVERE, "No se pudo redireccionar", ex);
                        // en Caso que no pueda Redireccionar
                        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario No Autorizado");
                    }
                } else {
                    usu_login = obj;
                    //AuditBakenBean.audit(AuditBakenBean.tipomensaje.ACCESAR, "El usuario Ingreso al sistema");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SesionBean.class.getName()).log(Level.SEVERE, "Excepcion en el constructor del Bean", ex);
        }

    }
    
      
    

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public SegUsuario getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(SegUsuario usu_login) {
        this.usu_login = usu_login;
    }
    //</editor-fold>
}
