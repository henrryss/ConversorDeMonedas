/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conversor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henrry
 */
public class ConversorTemperaturas {

    List<Temperatura> temperaturas = new ArrayList();

    public ConversorTemperaturas() {
        //inicializar las temperaturas
        temperaturas.add(new Temperatura("Celcius", "°C"));
        temperaturas.add(new Temperatura("Kelvin", "°K"));
        temperaturas.add(new Temperatura("Fahrenheit", "°F"));
        temperaturas.add(new Temperatura("Rankine", "°R"));
        temperaturas.add(new Temperatura("Réaumur", "°Ré"));
    }

    public List listNombreTemperaturas() {
        List lista = new ArrayList();
        for (Temperatura t : temperaturas) {
            lista.add(t.getTipoTemperatura());
        }
        return lista;
    }

    private Temperatura getTemperatura(String temperatura) {
        Temperatura temp = null;
        for (Temperatura t : temperaturas) {
            if (t.getTipoTemperatura().equalsIgnoreCase(temperatura)) {
                temp = t;
                break;
            }
        }
        return temp;
    }

    public String Convertir(String Origen, String Destino, Double valor) {
        Temperatura origen = getTemperatura(Origen);
        origen.setValor(valor);
        Temperatura destino = getTemperatura(Destino);
        //convertir a temperatura destino
        destino.convertirDeKelvin(origen.getValorEnKelvin());
        return (origen.getValor() == 1.0 || destino.getValor() == 1.0) ? origen.getInformacion() + " es " + destino.getInformacion()
                : origen.getInformacion() + " son " + destino.getInformacion();
    }


}
