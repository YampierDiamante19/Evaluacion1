package pe.edu.upeu.sysventas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CompCarritoController {

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtPUnitario;

    @FXML
    private Label lbnMsg;

    @FXML
    public void initialize() {
        System.out.println("CompCarritoController ejecutándose...");
    }

    @FXML
    public void guardar() {

        String nombre = txtNombreProducto.getText();
        String cantidad = txtCantidad.getText();
        String precio = txtPUnitario.getText();

        if (nombre.isEmpty() || cantidad.isEmpty() || precio.isEmpty()) {
            lbnMsg.setText("Complete todos los campos");
            return;
        }

        try {
            double cant = Double.parseDouble(cantidad);
            double punitario = Double.parseDouble(precio);

            double total = cant * punitario;

            lbnMsg.setText(
                    "Guardado: " + nombre +
                            " | Cantidad: " + cant +
                            " | Total: S/ " + total
            );

            System.out.println("PRODUCTO: " + nombre);
            System.out.println("CANTIDAD: " + cant);
            System.out.println("PRECIO UNITARIO: " + punitario);
            System.out.println("TOTAL: " + total);

        } catch (NumberFormatException e) {
            lbnMsg.setText("Cantidad y precio deben ser números");
        }
    }
}