/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.CalculadoraModelo;
import vista.CalculadoraVista;

// The Controller coordinates interactions
// between the View and Model
public class CalculadoraControlador {

    private CalculadoraVista theView;
    private CalculadoraModelo theModel;

    public CalculadoraControlador(CalculadoraVista theView, CalculadoraModelo theModel) {
        this.theView = theView;
        this.theModel = theModel;

        // Tell the View that when ever the calculate button
        // is clicked to execute the actionPerformed method
        // in the CalculateListener inner class

        this.theView.addCalculateListener(new CalculateListener());
    }

    public class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int firstNumber, secondNumber = 0;

            try {
                // Hace de intermediario entre Vista y Modelo
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();
                theModel.addTwoNumbers(firstNumber, secondNumber);
                theView.setCalcSolution(theModel.getCalculationValue());

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Por favor. Introduzca dos enteros"); // Mostrar mensaje si error
            }

        }
    }
}