/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.utils;

import ec.edu.espe_ctt.seguridades.entity.SegOpcion;
import ec.edu.espe_ctt.seguridades.session.SegOpcionFacade;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author PC1
 */
@ManagedBean
@ApplicationScoped
public class Imagenes {
@EJB
private SegOpcionFacade  segOpcionFacade;
    
    /**
     * Creates a new instance of Imagenes
     */
   
// 
//      public StreamedContent getImageUsuario() throws IOException {
//       
//        FacesContext context = FacesContext.getCurrentInstance();
//      
//        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.        
//            String id = context.getExternalContext().getRequestParameterMap().get("id");         
//            return new DefaultStreamedContent();
//            
//        } else {
//            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
//            String id = context.getExternalContext().getRequestParameterMap().get("id");
//          
//            SeaDatPersonal datPersonal = datPersonalFacade.fineByUsuario(new BigDecimal(id));
//            
//            if (datPersonal.getDpaFotografia() == null){ datPersonal.setDpaFotografia(new byte[0]);}
//            return new DefaultStreamedContent(new ByteArrayInputStream(datPersonal.getDpaFotografia()));
//        }
//       
//    }
     
      public StreamedContent getImageMenu( SegOpcion opcion1) throws IOException {
          System.out.println(" llamo llamo llamo + "+opcion1);
        FacesContext context = FacesContext.getCurrentInstance();
      
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            System.out.println(" if si ");
            // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.        
            String id = context.getExternalContext().getRequestParameterMap().get("id");   
            System.out.println(" id "+id);
            return new DefaultStreamedContent();
            
        } else {
            
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
            String id = context.getExternalContext().getRequestParameterMap().get("id");
           
            SegOpcion aux = new SegOpcion();
            aux.setOpcId(new BigDecimal(id));
            SegOpcion segOpcion = segOpcionFacade.find(aux);
            
//            if (segOpcion.getOpcImagen() == null){ segOpcion.setOpcImagen(new byte[0]);}
         //   return new DefaultStreamedContent(new ByteArrayInputStream(segOpcion.getOpcImagen()));
            
             return new DefaultStreamedContent();
        }
       
    }

}
