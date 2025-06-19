package interfaz;

/**Panel que contiene los campos de entrada para los dos números
 * que se utilizarán en las operaciones de la calculadora.
 * * @author Johan Guillen
 * @version 1.0
 */

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel {
    private static final long serialVersionUID = 1L; //Identificador único para la serialización de la clase
  
    private JLabel labNumero1;      //Etiqueta para el primer número
    private JTextField txtNumero1;  //Campo de texto para ingresar el primer número
    private JLabel labNumero2;      //Etiqueta para el segundo número
    private JTextField txtNumero2;  //Campo de texto para ingresar el segundo número
    
    /**Constructor que inicializa y configura todos los componentes del panel.
     * Establece el diseño, crea los objetos y los agrega al panel.
     */
    public PanelDatos() {
        
        //CONFIGURACIÓN DEL DISEÑO DEL PANEL
        TitledBorder borde = BorderFactory.createTitledBorder("Datos"); //Crear un borde con título para el panel
        setBorder(borde);                                    //Aplicar el borde al panel actual
        borde.setTitleColor(Color.BLUE);                 //Cambiar el color del título del borde a azul
        setLayout(new GridLayout(2, 2));  //Establecer un layout de grilla de 2 filas y 2 columnas
        
        //INSTANCIAR - CREAR LOS OBJETOS DE LA INTERFAZ
        labNumero1 = new JLabel("Número 1: ");
        // Crear campo de texto para ingresar el primer número
        txtNumero1 = new JTextField();
        // Crear etiqueta para el segundo número
        labNumero2 = new JLabel("Número 2: ");
        // Crear campo de texto para ingresar el segundo número
        txtNumero2 = new JTextField();
        
        // AGREGAR AL PANEL LOS OBJETOS EN ORDEN
        // Los componentes se agregan de izquierda a derecha, de arriba hacia abajo
        add(labNumero1);    // Posición [0,0]: Etiqueta "Número 1"
        add(txtNumero1);    // Posición [0,1]: Campo de texto para número 1
        add(labNumero2);    // Posición [1,0]: Etiqueta "Número 2"
        add(txtNumero2);    // Posición [1,1]: Campo de texto para número 2
    }

    // MÉTODOS GETTER Y SETTER PARA ACCEDER A LOS CAMPOS DE TEXTO
    
    /**
     * Método getter que devuelve la referencia al campo de texto del primer número.
     * * @return txtNumero1 - El JTextField del primer número
     */
    public JTextField getTxtNumero1() 
    {
        return txtNumero1;
    }

    /**
     * Método setter que permite cambiar la referencia del campo de texto del primer número.
     * * @param txtNumero1 - El nuevo JTextField para el primer número
     */
    public void setTxtNumero1(JTextField txtNumero1) 
    {
        // Asignar el nuevo campo de texto al atributo de la clase
        this.txtNumero1 = txtNumero1;
    }

    /**
     * Método getter que devuelve la referencia al campo de texto del segundo número.
     * * @return txtNumero2 - El JTextField del segundo número
     */
    public JTextField getTxtNumero2() 
    {
        return txtNumero2;
    }

    /**
     * Método setter que permite cambiar la referencia del campo de texto del segundo número.
     * * @param txtNumero2 - El nuevo JTextField para el segundo número
     */
    public void setTxtNumero2(JTextField txtNumero2) 
    {
        // Asignar el nuevo campo de texto al atributo de la clase
        this.txtNumero2 = txtNumero2;
    }
    
    /**
     * Método que limpia el contenido de ambos campos de texto.
     * Se utiliza cuando el usuario presiona el botón "Limpiar".
     */
    public void limpiar()
    {
        // Limpiar el campo del primer número estableciendo texto vacío
        txtNumero1.setText("");
        // Limpiar el campo del segundo número estableciendo texto vacío
        txtNumero2.setText("");
    }
}
