package Conversor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class ConversorMonedas {

    List<Moneda> listaMoneda = new ArrayList();

    public ConversorMonedas() {
        listaMoneda.add(new Moneda("Dolar", "$", "Estados Unidos",new BigDecimal(1) , "USD", "Dólares"));
        listaMoneda.add(new Moneda("Euro", "€", "Europa",new BigDecimal(0.91) , "EUR", "Euros"));
        listaMoneda.add(new Moneda("Libra Esterlina", "£", "Reino Unido", new BigDecimal(0.78), "GBP", "Libras Esterlinas"));
        listaMoneda.add(new Moneda("Yen Japones", "¥", "Japón", new BigDecimal(142.08), "JPY", "Yen japonés"));
        listaMoneda.add(new Moneda("Won surcoreano", "₩", "Corea del Sur", new BigDecimal(1298.37), "KRW", "Won surcoreano"));
        listaMoneda.add(new Moneda("Sol", "S/", "Perú", new BigDecimal(3.61), "PEN", "Soles"));
        listaMoneda.add(new Moneda("Real Brasileño", "R$", "Brasil", new BigDecimal(4.90), "BRL", "Reales"));
    }

    public String Convertir(String MonedaOrigen, String MonedaDestino, BigDecimal Cantidad) {
        Moneda monedaOrigen = getMoneda(MonedaOrigen);
        Moneda monedaDestino = getMoneda(MonedaDestino);//Moneda de Origen se convierte a Dolar
        BigDecimal CantidadEnDolar = Cantidad.divide(monedaOrigen.getTasaDeCambio(),new MathContext(4))  ;
        //Dolar se covierte a Moneda Destino
        BigDecimal CantidadFinal = CantidadEnDolar.multiply(monedaDestino.getTasaDeCambio()) ;

        return (CantidadFinal.compareTo(new BigDecimal(1))==0) //comparamos si la cantidad final en dolares es igual a 1
                ? "Tienes " + monedaDestino.getSimbolo() + " " + String.format("%.0f", CantidadFinal) + " " + monedaDestino.getNombreMoneda()
                : "Tienes " + monedaDestino.getSimbolo() + " " + String.format("%.2f", CantidadFinal) + " " + monedaDestino.getNombrePlural();

    }

    public List getListaMonedas() {
        List lista = new ArrayList();
        for (Moneda m : listaMoneda) {
            lista.add(m.getNombrePlural());
        }
        return lista;
    }

    private Moneda getMoneda(String Moneda) {
        Moneda moneda = null;
        for (Moneda m : listaMoneda) {
            if (m.getNombrePlural().equalsIgnoreCase(Moneda)) {
                moneda = m;
                break;
            }
        }
        return moneda;

    }
}
