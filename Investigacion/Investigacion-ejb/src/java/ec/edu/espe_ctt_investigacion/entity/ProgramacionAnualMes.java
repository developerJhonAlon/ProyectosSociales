/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.espe_ctt_investigacion.entity;

import java.math.BigDecimal;

/**
 *
 * @author PC1
 */
public class ProgramacionAnualMes {
    private SeaMeses seaMeses;
    private SeaProgramaAnual seaProgramacionAnual;
    
    private BigDecimal inversionPersonal;
    private BigDecimal bienesYServicios;
    private BigDecimal obrasPublicas;    
    private BigDecimal otrosGastos;
    private BigDecimal bienesLargaDuracion;
    private BigDecimal total;
    private BigDecimal valorEspe;
    private BigDecimal valorOtras;
    private BigDecimal valorEspeBienSer;
    private BigDecimal valorOtrasBienSer;
    private BigDecimal valorEspeObrasP;
    private BigDecimal valorOtrasObrasP;
    private BigDecimal valorEspeGastosIn;
    private BigDecimal valorOtrasGastosIn;
    private BigDecimal valorEspeLargaD;
    private BigDecimal valorOtrasLargaD;
    private String partidaPerInver;
    private String partidaBienSer;
    private String partidaObrasP;
    private String partidaOtrosGastos;
    private String partidaBienLargaD;
    
    

    public SeaMeses getSeaMeses() {
        return seaMeses;
    }

    public void setSeaMeses(SeaMeses seaMeses) {
        this.seaMeses = seaMeses;
    }

    public BigDecimal getInversionPersonal() {
        return inversionPersonal;
    }

    public void setInversionPersonal(BigDecimal inversionPersonal) {
        this.inversionPersonal = inversionPersonal;
    }

    public BigDecimal getBienesYServicios() {
        return bienesYServicios;
    }

    public void setBienesYServicios(BigDecimal bienesYServicios) {
        this.bienesYServicios = bienesYServicios;
    }

    public BigDecimal getObrasPublicas() {
        return obrasPublicas;
    }

    public void setObrasPublicas(BigDecimal obrasPublicas) {
        this.obrasPublicas = obrasPublicas;
    }

    public BigDecimal getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(BigDecimal otrosGastos) {
        this.otrosGastos = otrosGastos;
    }

    public BigDecimal getBienesLargaDuracion() {
        return bienesLargaDuracion;
    }

    public void setBienesLargaDuracion(BigDecimal bienesLargaDuracion) {
        this.bienesLargaDuracion = bienesLargaDuracion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getValorEspe() {
        return valorEspe;
    }

    public void setValorEspe(BigDecimal valorEspe) {
        this.valorEspe = valorEspe;
    }

    public BigDecimal getValorOtras() {
        return valorOtras;
    }

    public void setValorOtras(BigDecimal valorOtras) {
        this.valorOtras = valorOtras;
    }

    public BigDecimal getValorEspeBienSer() {
        return valorEspeBienSer;
    }

    public void setValorEspeBienSer(BigDecimal valorEspeBienSer) {
        this.valorEspeBienSer = valorEspeBienSer;
    }

    public BigDecimal getValorOtrasBienSer() {
        return valorOtrasBienSer;
    }

    public void setValorOtrasBienSer(BigDecimal valorOtrasBienSer) {
        this.valorOtrasBienSer = valorOtrasBienSer;
    }

    public BigDecimal getValorEspeObrasP() {
        return valorEspeObrasP;
    }

    public void setValorEspeObrasP(BigDecimal valorEspeObrasP) {
        this.valorEspeObrasP = valorEspeObrasP;
    }

    public BigDecimal getValorOtrasObrasP() {
        return valorOtrasObrasP;
    }

    public void setValorOtrasObrasP(BigDecimal valorOtrasObrasP) {
        this.valorOtrasObrasP = valorOtrasObrasP;
    }

    public BigDecimal getValorEspeGastosIn() {
        return valorEspeGastosIn;
    }

    public void setValorEspeGastosIn(BigDecimal valorEspeGastosIn) {
        this.valorEspeGastosIn = valorEspeGastosIn;
    }

    public BigDecimal getValorOtrasGastosIn() {
        return valorOtrasGastosIn;
    }

    public void setValorOtrasGastosIn(BigDecimal valorOtrasGastosIn) {
        this.valorOtrasGastosIn = valorOtrasGastosIn;
    }

    public BigDecimal getValorEspeLargaD() {
        return valorEspeLargaD;
    }

    public void setValorEspeLargaD(BigDecimal valorEspeLargaD) {
        this.valorEspeLargaD = valorEspeLargaD;
    }

    public BigDecimal getValorOtrasLargaD() {
        return valorOtrasLargaD;
    }

    public void setValorOtrasLargaD(BigDecimal valorOtrasLargaD) {
        this.valorOtrasLargaD = valorOtrasLargaD;
    }

    public SeaProgramaAnual getSeaProgramacionAnual() {
        return seaProgramacionAnual;
    }

    public void setSeaProgramacionAnual(SeaProgramaAnual seaProgramacionAnual) {
        this.seaProgramacionAnual = seaProgramacionAnual;
    }

    public String getPartidaPerInver() {
        return partidaPerInver;
    }

    public void setPartidaPerInver(String partidaPerInver) {
        this.partidaPerInver = partidaPerInver;
    }
    

    public String getPartidaBienSer() {
        return partidaBienSer;
    }

    public void setPartidaBienSer(String partidaBienSer) {
        this.partidaBienSer = partidaBienSer;
    }

    public String getPartidaObrasP() {
        return partidaObrasP;
    }

    public void setPartidaObrasP(String partidaObrasP) {
        this.partidaObrasP = partidaObrasP;
    }

    public String getPartidaOtrosGastos() {
        return partidaOtrosGastos;
    }

    public void setPartidaOtrosGastos(String partidaOtrosGastos) {
        this.partidaOtrosGastos = partidaOtrosGastos;
    }

    public String getPartidaBienLargaD() {
        return partidaBienLargaD;
    }

    public void setPartidaBienLargaD(String partidaBienLargaD) {
        this.partidaBienLargaD = partidaBienLargaD;
    }
    
    
    
}
