package test;

import controlador.CalculadoraControlador;
import modelo.CalculadoraModelo;
import vista.CalculadoraVista;

/**
 *
 * @author david
 */
public class Run {

    public static void main(String[] args) {
        CalculadoraVista theView = new CalculadoraVista();
        CalculadoraModelo theModel = new CalculadoraModelo();
        CalculadoraControlador theController = new CalculadoraControlador(theView, theModel);

        theView.setVisible(true);
    }
}
