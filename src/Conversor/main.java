package Conversor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class main {

    private static final String tipoConversion[] = {"Conversor de Monedas", "Conversor de Temperaturas"};

    public static void main(String[] args) {
        iniciarAplicacion();
    }

    private static void iniciarAplicacion() {
        Object opcion = JOptionPane.showInputDialog(null, "Seleccione la opcion de conversion", "Menu", JOptionPane.QUESTION_MESSAGE, null, tipoConversion, tipoConversion[0]);
        if (opcion != null) {
            input(opcion);
        } else {
            DialogFinPrograma();
        }
    }

    private static void input(Object opcion) {
        try {
            if (opcion.equals(tipoConversion[0])) {
                BigDecimal valor = new BigDecimal(JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero que deseas convertir:", "input", JOptionPane.QUESTION_MESSAGE));
                if ((valor.compareTo(BigDecimal.ZERO)) == -1) {
                    throw new IllegalArgumentException("El valor tiene que ser mayor a 0, por favor vuelva a ingresar correctamente");
                }
                ConversorMonedas cm = new ConversorMonedas();
                List listaMonedas = cm.getListaMonedas();
                listaMonedas.remove("Soles");
                String opcionesDeCambio[] = new String[listaMonedas.size() * 2];
                for (int i = 0; i < listaMonedas.size(); i++) {
                    opcionesDeCambio[i] = "De Soles a " + listaMonedas.get(i);
                    opcionesDeCambio[i + listaMonedas.size()] = "De " + listaMonedas.get(i) + " a Soles";
                }
                String seleccion = JOptionPane.showInputDialog(null, "Elija la moneda a la que deseas convertir tu dinero", "Monedas", JOptionPane.PLAIN_MESSAGE, null, opcionesDeCambio, opcionesDeCambio[0]).toString();
                String MonedaOrigen = seleccion.substring(seleccion.indexOf(" ") + 1, seleccion.indexOf(" a"));
                String MonedaDestino = seleccion.substring(seleccion.lastIndexOf("a ") + 2, seleccion.length());
                mostrarResultado(cm.Convertir(MonedaOrigen, MonedaDestino, valor));
            } else {
                Double valor = Double.valueOf(JOptionPane.showInputDialog(null, "Ingrese el valor de la temperatura que deseas convertir:", "input", JOptionPane.QUESTION_MESSAGE));
                ConversorTemperaturas ct = new ConversorTemperaturas();
                List temperaturas = ct.listNombreTemperaturas();
                List opciones = new ArrayList();
                for (int i = 0; i < temperaturas.size(); i++) {
                    for (int j = 0; j < temperaturas.size(); j++) {
                        if (temperaturas.get(i) != temperaturas.get(j)) {
                            opciones.add("De " + temperaturas.get(i) + " a " + temperaturas.get(j));
                        }
                    }
                }
                String seleccion = JOptionPane.showInputDialog(null, "Elija la moneda a la que deseas convertir tu dinero", "Monedas", JOptionPane.PLAIN_MESSAGE, null, opciones.toArray(), opciones.get(0)).toString();
                mostrarResultado(ct.Convertir(seleccion.substring(seleccion.indexOf(" ") + 1, seleccion.indexOf(" a")), seleccion.substring(seleccion.indexOf("a ") + 2, seleccion.length()), valor));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor ingresado no es numerico", "Error", JOptionPane.ERROR_MESSAGE);
            input(opcion);
        } catch (IllegalArgumentException i) {
            JOptionPane.showMessageDialog(null, i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            input(opcion);
        } catch (NullPointerException ex) {
            iniciarAplicacion();

        }

    }

    private static void mostrarResultado(String texto) {
        JOptionPane.showMessageDialog(null, texto);
        if (JOptionPane.showConfirmDialog(null, "¿Quiere continuar?", "Selecciona una opción", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null) == 0) {
            iniciarAplicacion();
        } else {
            DialogFinPrograma();
        }

    }

    private static void DialogFinPrograma() {
        JOptionPane.showMessageDialog(null, "Programa Terminado");
    }
}
