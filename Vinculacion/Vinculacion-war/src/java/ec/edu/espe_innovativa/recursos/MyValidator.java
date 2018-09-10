/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_innovativa.recursos;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author PC1
 */
@FacesValidator("ec.edu.espe_ctt.recursos.MyValidator")
public class MyValidator implements Validator{
    
    /*
    en el boton que se desee que NO se haga la validacion, colocar:
    
    <!--<f:param name="skipValidator" value="true"/>-->
    
    */

  public void validate(FacesContext ct, UIComponent co, Object obj) throws ValidatorException { 
    if(!continueValidation()){
      return;
    }
    String a = (String) obj;
        if (!a.equals("7")) {
      FacesMessage msg =
              new FacesMessage(" E-mail validation failed.",
              "Please provide E-mail address in this format: abcd@abc.com");
      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
    
      throw new ValidatorException(msg);
    }
    // validation process
  }

protected boolean continueValidation() {
    String skipValidator= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("skipValidator");
    if (skipValidator != null && skipValidator.equalsIgnoreCase("true")) {
      return false;
    }
    return true;
  } 
}