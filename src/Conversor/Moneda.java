/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversor;
/**
 *
 * @author henrr
 */
public class Moneda {

    private String nombreMoneda;
    private String simbolo;
    private String pais;
    private Double tasaDeCambio; //precio de la moneda a 1 dolar
    private String sigla;
    private String nombrePlural;

    public Moneda(String nombreMoneda, String simbolo, String pais, Double tasaDeCambio, String sigla, String nombrePlural) {
        this.nombreMoneda = nombreMoneda;
        this.simbolo = simbolo;
        this.pais = pais;
        this.tasaDeCambio = tasaDeCambio;
        this.sigla = sigla;
        this.nombrePlural = nombrePlural;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public void setTasaDeCambio(Double tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombrePlural() {
        return nombrePlural;
    }

    public void setNombrePlural(String nombrePlural) {
        this.nombrePlural = nombrePlural;
    }

}