
package rfcycurexamenn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    
  

public class   Rfcycurexamenn  extends JFrame {

    public Rfcycurexamenn() {
        // Configuración del JFrame
        setTitle("Generador CURP y RFC");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de componentes
        JLabel nombreLabel = new JLabel("Nombre:");
        JTextField nombreTextField = new JTextField();

        JLabel apellidoPaternoLabel = new JLabel("Apellido Paterno:");
        JTextField apellidoPaternoTextField = new JTextField();

        JLabel apellidoMaternoLabel = new JLabel("Apellido Materno:");
        JTextField apellidoMaternoTextField = new JTextField();

        JLabel estadoNacimientoLabel = new JLabel("Estado de Nacimiento:");
        JTextField estadoNacimientoTextField = new JTextField();

        JLabel estadoMexicoLabel = new JLabel("Estado de México:");
        JTextField estadoMexicoTextField = new JTextField();

        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento (AAAA-MM-DD):");
        JTextField fechaNacimientoTextField = new JTextField();

        JButton generarButton = new JButton("Generar CURP y RFC");
        JButton colorButton = new JButton("Seleccionar Color");

        // Configuración del diseño con GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nombreLabel)
                        .addComponent(apellidoPaternoLabel)
                        .addComponent(apellidoMaternoLabel)
                        .addComponent(estadoNacimientoLabel)
                        .addComponent(estadoMexicoLabel)
                        .addComponent(fechaNacimientoLabel)
                        .addComponent(colorButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nombreTextField)
                        .addComponent(apellidoPaternoTextField)
                        .addComponent(apellidoMaternoTextField)
                        .addComponent(estadoNacimientoTextField)
                        .addComponent(estadoMexicoTextField)
                        .addComponent(fechaNacimientoTextField)
                        .addComponent(generarButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nombreLabel)
                        .addComponent(nombreTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(apellidoPaternoLabel)
                        .addComponent(apellidoPaternoTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(apellidoMaternoLabel)
                        .addComponent(apellidoMaternoTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(estadoNacimientoLabel)
                        .addComponent(estadoNacimientoTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(estadoMexicoLabel)
                        .addComponent(estadoMexicoTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaNacimientoLabel)
                        .addComponent(fechaNacimientoTextField))
                .addComponent(colorButton)
                .addComponent(generarButton)
        );

        // Acción del botón Generar
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos de los campos
                String nombre = nombreTextField.getText();
                String apellidoPaterno = apellidoPaternoTextField.getText();
                String apellidoMaterno = apellidoMaternoTextField.getText();
                String estadoNacimiento = estadoNacimientoTextField.getText();
                String estadoMexico = estadoMexicoTextField.getText();
                String fechaNacimiento = fechaNacimientoTextField.getText();

                // Lógica para generar CURP y RFC
                String curp = generarCURP(nombre, apellidoPaterno, apellidoMaterno, estadoNacimiento, fechaNacimiento);
                String rfc = generarRFC(curp, estadoMexico);

                // Mostrar resultados
                JOptionPane.showMessageDialog(null, "CURP: " + curp + "\nRFC: " + rfc);
            }
        });

        // Acción del botón Seleccionar Color
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el selector de color
                Color color = JColorChooser.showDialog(Rfcycurexamenn.this, "Seleccionar Color", Color.BLACK);

                // Cambiar el color de fondo del JFrame
                getContentPane().setBackground(color);
            }
        });
    }

    private String generarCURP(String nombre, String apellidoPaterno, String apellidoMaterno,
                               String estadoNacimiento, String fechaNacimiento) {
        // Implementa la lógica de generación de CURP aquí
        // Este es solo un ejemplo simple
        return nombre.substring(0, 1) + apellidoPaterno.substring(0, 1) + apellidoMaterno.substring(0, 1);
    }

    private String generarRFC(String curp, String estadoMexico) {
        // Implementa la lógica de generación de RFC aquí
        // Este es solo un ejemplo simple
        return curp + estadoMexico.substring(0, 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Rfcycurexamenn().setVisible(true);
            }
        });
    }
}  

