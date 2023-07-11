package Conversor;

import java.util.ArrayList;
import java.util.List;

public class ConversorMonedas {

    List<Moneda> listaMoneda = new ArrayList();

    public ConversorMonedas() {
        listaMoneda.add(new Moneda("Dolar", "$", "Estados Unidos", 1.0, "USD", "Dólares"));
        listaMoneda.add(new Moneda("Euro", "€", "Europa", 0.91, "EUR", "Euros"));
        listaMoneda.add(new Moneda("Libra Esterlina", "£", "Reino Unido", 0.78, "GBP", "Libras Esterlinas"));
        listaMoneda.add(new Moneda("Yen Japones", "¥", "Japón", 142.08, "JPY", "Yen japonés"));
        listaMoneda.add(new Moneda("Won surcoreano", "₩", "Corea del Sur", 1298.37, "KRW", "Won surcoreano"));
        listaMoneda.add(new Moneda("Sol", "S/", "Perú", 3.61, "PEN", "Soles"));
        listaMoneda.add(new Moneda("Real Brasileño", "R$", "Brasil", 4.90, "BRL", "Reales"));
    }

    public String Convertir(String MonedaOrigen, String MonedaDestino, Double Cantidad) {
        Moneda monedaOrigen = getMoneda(MonedaOrigen);
        Moneda monedaDestino = getMoneda(MonedaDestino);//Moneda de Origen se convierte a Dolar
        Double CantidadEnDolar = Cantidad / monedaOrigen.getTasaDeCambio();
        //Dolar se covierte a Moneda Destino
        Double CantidadFinal = CantidadEnDolar * monedaDestino.getTasaDeCambio();

        return (CantidadFinal == 1.0)
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
