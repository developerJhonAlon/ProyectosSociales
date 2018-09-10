/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt.investigacion.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase que permite ejecutar diferentes tipos de formatos usados para el despliegue de fechas
 * @author Ing. Cristian Asimbaya
 */
public class DateFormatter {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", new Locale("ES"));

	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy", new Locale("ES"));

	private static SimpleDateFormat sdfP = new SimpleDateFormat("MMM yy", new Locale("ES"));

	private static SimpleDateFormat sdfHM = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("ES"));

	public static String getDate() {
		return sdf.format(new Date());
	}
	public static String getFecha(Date fecha) {
		return sdf.format(fecha);
	}

	public static String getDateHM() {
		return sdfHM.format(new Date());
	}
	public static String format(Date fecha) {
		return sdf.format(fecha);
	}
	public static String format1(Date fecha) {
		return sdf1.format(fecha);
	}

	public static String descripcionPeriodo(Date fechaInicio, Date fechaFin) {
		String mesInicial = sdfP.format(fechaInicio);
		String mesFinal = sdfP.format(fechaFin);
		return mesInicial + " - " + mesFinal ;
	}

    
}
