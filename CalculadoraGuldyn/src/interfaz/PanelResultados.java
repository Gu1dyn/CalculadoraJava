package interfaz;

/**Panel que muestra el resultado de las operaciones y contiene el botón limpiar.
 * Implementa ActionListener para manejar el evento del botón limpiar.
 * * @author Johan Guillen
 * @version 1.0
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L; //Identificador único para la serialización de la clase

    private final JLabel labResultado;                     //Etiqueta que dice "Resultado"
    private final JTextField txtResultado;                 //Campo de texto que muestra el resultado (solo lectura)
    private final JLabel labVacio1;                        //Etiqueta vacía para mantener el diseño de la grilla
    private final JButton butLimpiar;                      //Botón para limpiar todos los campos
    private final InterfazCalculadora interfazCalculadora; //Referencia a la ventana principal

    /**Constructor que inicializa el panel de resultados con todos sus componentes.
     * @param interfazCalculadora Referencia a la ventana principal para comunicación
     */
    public PanelResultados(InterfazCalculadora interfazCalculadora) {
        this.interfazCalculadora = interfazCalculadora; //Guardar la referencia a la interfaz principal para poder llamar sus métodos
        
        //CONFIGURACIÓN DEL DISEÑO DEL PANEL
        TitledBorder borde = BorderFactory.createTitledBorder("Resultados"); //Crear un borde con título para el panel
        setBorder(borde);                              //Aplicar el borde al panel actual
        borde.setTitleColor(Color.BLUE);              //Cambiar el color del título del borde a azul
        setLayout(new GridLayout(2, 2));   //Establecer un layout de grilla de 2 filas y 2 columnas
        
        //INSTANCIAR - CREAR LOS OBJETOS DE LA INTERFAZ
        labResultado = new JLabel("Resultado"); //Crear etiqueta que dice "Resultado"
        txtResultado = new JTextField();             //Crear campo de texto para mostrar el resultado
        txtResultado.setEditable(false);           //Hacer que el campo de texto no sea editable (solo lectura)
        labVacio1 = new JLabel("");             //Crear etiqueta vacía para ocupar espacio en la grilla
        butLimpiar = new JButton("Limpiar");    //Crear botón para limpiar todos los campos
        butLimpiar.addActionListener(this);          //Registrar este panel como listener del botón limpiar
        
        //AGREGAR AL PANEL LOS OBJETOS EN ORDEN
        //Los componentes se distribuyen en una grilla de 2x2
        add(labResultado);   //Posición [0,0]: Etiqueta "Resultado"
        add(txtResultado);   //Posición [0,1]: Campo de texto del resultado
        add(labVacio1);      //Posición [1,0]: Etiqueta vacía (espacio)
        add(butLimpiar);     //Posición [1,1]: Botón "Limpiar"
    }

    /**Método que actualiza el campo de texto del resultado con un nuevo valor.
     * @param resultado El valor numérico que se mostrará como resultado
     */
    public void setTxtResultado(double resultado) {
        //Convertir el número a texto y establecerlo en el campo de resultado
        //Se concatena con "" para convertir el double a String
        txtResultado.setText("" + resultado);
    }

    /**Método que maneja el evento de clic del botón limpiar.
     * Se ejecuta automáticamente cuando el usuario hace clic en "Limpiar".
     * @param e El evento de acción que contiene información sobre el botón presionado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == butLimpiar) { //Verificar si el botón presionado fue el botón limpiar
            interfazCalculadora.limpiar(); // Llamar al método limpiar de la interfaz principal, esto limpiará todos los campos de la calculadora
        }
    }
    
    /**Método que limpia únicamente el campo de resultado.
     * Es llamado desde la interfaz principal cuando se ejecuta la limpieza general.
     */
    public void limpiar() {
        txtResultado.setText(""); //Establecer texto vacío en el campo de resultado
    }
}
