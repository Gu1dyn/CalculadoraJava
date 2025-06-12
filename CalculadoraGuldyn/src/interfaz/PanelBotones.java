package interfaz;

/**Panel que contiene los botones para las operaciones matemáticas básicas.
 * Implementa ActionListener para manejar los eventos de los botones.
 * * @author Johan Guillen
 * @version 1.0
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L; //Identificador único para la serialización de la clase

    private final JButton butSumar;                        //Botón para realizar suma
    private final JButton butRestar;                       //Botón para realizar resta
    private final JButton butMultiplicar;                  //Botón para realizar multiplicación
    private final JButton butDividir;                      //Botón para realizar división
    private final InterfazCalculadora interfazCalculadora; //Referencia a la ventana principal

    /**Constructor que inicializa el panel con todos los botones de operaciones.
     * @param interfazCalculadora Referencia a la ventana principal para comunicación
     */
    public PanelBotones(InterfazCalculadora interfazCalculadora) {
        this.interfazCalculadora = interfazCalculadora; //Guardar la referencia a la interfaz principal para poder llamar sus métodos
        
        // CONFIGURACIÓN DEL DISEÑO DEL PANEL
        TitledBorder borde = BorderFactory.createTitledBorder("Opciones"); // Crear un borde con título para el panel
        setBorder(borde);                            // Aplicar el borde al panel actual
        borde.setTitleColor(Color.BLUE);            // Cambiar el color del título del borde a azul
        setLayout(new GridLayout(2, 2)); // Establecer un layout de grilla de 2 filas y 2 columnas
        
        // INSTANCIAR - CREAR LOS OBJETOS BOTÓN  
        butSumar = new JButton("Sumar");             //Crear botón para suma
        butSumar.addActionListener(this);                 //Registrar este panel como listener del botón suma
        butRestar = new JButton("Restar");           //Crear botón para resta
        butRestar.addActionListener(this);                //Registrar este panel como listener del botón resta
        butMultiplicar = new JButton("Multiplicar"); //Crear botón para multiplicación
        butMultiplicar.addActionListener(this);           //Registrar este panel como listener del botón multiplicar
        butDividir = new JButton("Dividir");         //Crear botón para división
        butDividir.addActionListener(this);               //Registrar este panel como listener del botón dividir
        
        // AGREGAR AL PANEL LOS BOTONES EN ORDEN
        // Los botones se distribuyen en una grilla de 2x2
        add(butSumar);       //Posición [0,0]: Botón Sumar
        add(butRestar);      //Posición [0,1]: Botón Restar
        add(butMultiplicar); //Posición [1,0]: Botón Multiplicar
        add(butDividir);     //Posición [1,1]: Botón Dividir
    }

    /**Método que maneja los eventos de clic de todos los botones del panel.
     * Se ejecuta automáticamente cuando el usuario hace clic en cualquier botón.
     * @param e El evento de acción que contiene información sobre qué botón fue presionado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(e.getSource() == butSumar) {  //Verificar cuál botón fue presionado comparando la fuente del evento
            interfazCalculadora.sumar(); //Si fue el botón sumar, llamar al método sumar de la interfaz principal
        }
        else if(e.getSource() == butRestar) {
            interfazCalculadora.restar(); //Si fue el botón restar, llamar al método restar de la interfaz principal
        }
        else if(e.getSource() == butMultiplicar) {
            interfazCalculadora.multiplicar(); //Si fue el botón multiplicar, llamar al método multiplicar de la interfaz principal
        }
        else if(e.getSource() == butDividir) {
            interfazCalculadora.dividir(); //Si fue el botón dividir, llamar al método dividir de la interfaz principal
        }	
    }
}
