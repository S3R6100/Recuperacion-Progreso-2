import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoubleCirculGUI {
    private JButton button1; // Insertar
    private JButton button2; // Eliminar
    private JButton button3; // Buscar
    private JButton button4; // Ordenar Asc.
    private JButton button5; // Ordenar Desc.
    private JTextArea textArea1;
    private JPanel pGeneral;
    private JTextField textField1;

    private DoubleCircul lista;

    public DoubleCirculGUI() {
        lista = new DoubleCircul();

        // Configuración de eventos
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertar();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenar(true); // Ascendente
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenar(false); // Descendente
            }
        });
    }

    private void insertar() {
        try {
            int dato = Integer.parseInt(textField1.getText());
            lista.insertar(dato);
            actualizarVista();
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido.");
        }
    }

    private void eliminar() {
        try {
            int dato = Integer.parseInt(textField1.getText());
            if (lista.eliminar(dato)) {
                mostrarMensaje("Número eliminado.");
            } else {
                mostrarMensaje("Número no encontrado.");
            }
            actualizarVista();
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido.");
        }
    }

    private void buscar() {
        try {
            int dato = Integer.parseInt(textField1.getText());
            if (lista.buscar(dato)) {
                mostrarMensaje("Número encontrado.");
            } else {
                mostrarMensaje("Número no encontrado.");
            }
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un número válido.");
        }
    }

    private void ordenar(boolean ascendente) {
        lista.ordenar(ascendente);
        actualizarVista();
    }

    private void actualizarVista() {
        textArea1.setText(lista.mostrar());
    }

    private void mostrarMensaje(String mensaje) {
        textArea1.setText(mensaje + "\n" + textArea1.getText());
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista Circular Doble");
        DoubleCirculGUI gui = new DoubleCirculGUI();

        frame.setContentPane(gui.pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

