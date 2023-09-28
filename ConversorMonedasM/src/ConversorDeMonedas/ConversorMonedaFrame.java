package ConversorDeMonedas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedaFrame extends JFrame {
    private JTextField cantidadTextField;
    private JComboBox<String> monedaOrigenComboBox;
    private JComboBox<String> monedaDestinoComboBox;
    private JLabel resultadoLabel;

    private static final double ARS_A_USD = 0.011; // Tipo de cambio ARS a USD
    private static final double ARS_A_EUR = 0.009; // Tipo de cambio ARS a EUR
    private static final double ARS_A_GBP = 0.007; // Tipo de cambio ARS a GBP
    private static final double ARS_A_JPY = 1.24;  // Tipo de cambio ARS a JPY
    private static final double ARS_A_KRW = 14.16; // Tipo de cambio ARS a KRW

    public ConversorMonedaFrame() {
        setTitle("Conversor de Moneda");
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Cantidad: "));
        cantidadTextField = new JTextField();
        panel.add(cantidadTextField);

        panel.add(new JLabel("De: "));
        monedaOrigenComboBox = new JComboBox<>(new String[]{"ARS", "USD", "EUR", "GBP", "JPY", "KRW"});
        panel.add(monedaOrigenComboBox);

        panel.add(new JLabel("A: "));
        monedaDestinoComboBox = new JComboBox<>(new String[]{"ARS", "USD", "EUR", "GBP", "JPY", "KRW"});
        panel.add(monedaDestinoComboBox);

        JButton convertirButton = new JButton("Convertir");
        convertirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirMoneda();
            }
        });
        panel.add(convertirButton);

        resultadoLabel = new JLabel("Resultado: ");
        panel.add(resultadoLabel);

        add(panel);
    }

    private void convertirMoneda() {
        try {
            double cantidad = Double.parseDouble(cantidadTextField.getText());
            String monedaOrigen = monedaOrigenComboBox.getSelectedItem().toString();
            String monedaDestino = monedaDestinoComboBox.getSelectedItem().toString();
            double resultado = convertir(cantidad, monedaOrigen, monedaDestino);
            resultadoLabel.setText("Resultado: " + resultado + " " + monedaDestino);
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Ingrese una cantidad válida.");
        }
    }

    private double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        if ("ARS".equals(monedaOrigen) && "USD".equals(monedaDestino)) {
            return cantidad * ARS_A_USD;
        } else if ("ARS".equals(monedaOrigen) && "EUR".equals(monedaDestino)) {
            return cantidad * ARS_A_EUR;
        } else if ("ARS".equals(monedaOrigen) && "GBP".equals(monedaDestino)) {
            return cantidad * ARS_A_GBP;
        } else if ("ARS".equals(monedaOrigen) && "JPY".equals(monedaDestino)) {
            return cantidad * ARS_A_JPY;
        } else if ("ARS".equals(monedaOrigen) && "KRW".equals(monedaDestino)) {
            return cantidad * ARS_A_KRW;
        } else if ("USD".equals(monedaOrigen) && "ARS".equals(monedaDestino)) {
            return cantidad / ARS_A_USD;
        } else if ("EUR".equals(monedaOrigen) && "ARS".equals(monedaDestino)) {
            return cantidad / ARS_A_EUR;
        } else if ("GBP".equals(monedaOrigen) && "ARS".equals(monedaDestino)) {
            return cantidad / ARS_A_GBP;
        } else if ("JPY".equals(monedaOrigen) && "ARS".equals(monedaDestino)) {
            return cantidad / ARS_A_JPY;
        } else if ("KRW".equals(monedaOrigen) && "ARS".equals(monedaDestino)) {
            return cantidad / ARS_A_KRW;
        } else {
            return 0.0; // Manejar conversiones no admitidas
        }
    }
}