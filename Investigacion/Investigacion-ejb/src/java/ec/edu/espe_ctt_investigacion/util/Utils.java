/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe_ctt_investigacion.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author PC1
 */
public class Utils {
    
    public static String decimalToString(BigDecimal valor) {
        DecimalFormat decimalFormat;
        Locale locale = new Locale("es", "ES");
        String pattern = "###,###,##0.00";

        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(valor);
    }
}
