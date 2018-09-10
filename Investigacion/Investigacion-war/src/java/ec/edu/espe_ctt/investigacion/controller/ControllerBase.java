/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.controller;
import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author PC1
 */
public class ControllerBase {
    
     public ControllerBase(){
    
    
    }
    
      public void timeout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/SeguimientoAcademicoB-war/faces/sessionTimeout.xhtml");

    }  
    
}
