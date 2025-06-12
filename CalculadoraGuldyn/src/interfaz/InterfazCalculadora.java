package interfaz;

/**Clase principal que representa la ventana de la calculadora.
 * Extiende JFrame para crear una ventana gráfica y coordina
 * la comunicación entre todos los paneles y la lógica de negocio.
 * * @author Johan Guillen
 * @version 1.0
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.Calculadora;

public class InterfazCalculadora extends JFrame {
    private static final long serialVersionUID = 1L; //Identificador único para la serialización de la clase
    
    private final PanelDatos panelDatos;           //Panel que contiene los campos de entrada
    private final PanelBotones panelBotones;       //Panel que contiene los botones de operaciones
    private final PanelResultados panelResultados; //Panel que muestra resultados y botón limpiar
    private final Calculadora calculadora;         //Objeto que contiene la lógica matemática
    
    /**Constructor que inicializa y configura la ventana principal de la calculadora.
     * Establece las propiedades de la ventana, crea todos los paneles y los organiza.
     */
    public InterfazCalculadora() {

        //CONFIGURACIÓN DE LA VENTANA PRINCIPAL
        setTitle("La calculadora mágica"); //Establecer el título que aparece en la barra de título de la ventana
        setSize(250, 270);          //Definir el tamaño inicial de la ventana (ancho: 250px, alto: 270px)
        setResizable(true);            //Permitir que el usuario pueda cambiar el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Configurar que la aplicación se cierre cuando se cierre la ventana
        setLocationRelativeTo(null);           //Centrar la ventana en la pantalla
        setLayout(new BorderLayout());           //Establecer el layout BorderLayout para organizar los paneles
            
        //INSTANCIAR - CREAR LOS OBJETOS DE LA INTERFAZ Y LÓGICA
        panelDatos = new PanelDatos();               //Crear el panel de datos (campos de entrada)
        panelBotones = new PanelBotones(this);       //Crear el panel de botones, pasando referencia de esta ventana
        panelResultados = new PanelResultados(this); //Crear el panel de resultados, pasando referencia de esta ventana
        calculadora = new Calculadora();             //Crear el objeto calculadora que contiene la lógica matemática
        
        //AGREGAR LOS PANELES A LA VENTANA PRINCIPAL USANDO BORDERLAYOUT
        add(panelDatos, BorderLayout.NORTH);      //Agregar panel de datos en la parte superior (NORTH)
        add(panelBotones, BorderLayout.CENTER);   //Agregar panel de botones en el centro (CENTER)
        add(panelResultados, BorderLayout.SOUTH); //Agregar panel de resultados en la parte inferior (SOUTH)

        //Hacer visible la ventana DESPUÉS de que todos los componentes estén agregados
        //Esto ayuda a evitar la advertencia "Leaking this in constructor" en algunos IDEs,
        //Aunque en Swing el impacto es mínimo para apps de un solo hilo.
        setVisible(true); 
    }
    
    //MÉTODOS PARA REALIZAR LAS OPERACIONES MATEMÁTICAS
    //Estos métodos son llamados desde PanelBotones cuando se presionan los botones
    
    /**Método que realiza la operación de suma.
     * Obtiene los valores de los campos de texto, realiza la suma y muestra el resultado.
     */
    public void sumar() {
        try {
            double num1 = Double.parseDouble(panelDatos.getTxtNumero1().getText()); //Obtener el texto del primer campo y convertirlo a número decimal
            double num2 = Double.parseDouble(panelDatos.getTxtNumero2().getText()); //Obtener el texto del segundo campo y convertirlo a número decimal
            double resultado = calculadora.sumar(num1, num2);                       //Realizar la suma usando el objeto calculadora
            panelResultados.setTxtResultado(resultado);                             //Mostrar el resultado en el panel de resultados
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en ambos campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**Método que realiza la operación de resta.
     * Obtiene los valores de los campos de texto, realiza la resta y muestra el resultado.
     */
    public void restar() {
        try {
            double num1 = Double.parseDouble(panelDatos.getTxtNumero1().getText()); //Obtener el texto del primer campo y convertirlo a número decimal  
            double num2 = Double.parseDouble(panelDatos.getTxtNumero2().getText()); //Obtener el texto del segundo campo y convertirlo a número decimal
            double resultado = calculadora.restar(num1, num2);                      //Realizar la resta usando el objeto calculadora
            panelResultados.setTxtResultado(resultado);                             //Mostrar el resultado en el panel de resultados
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en ambos campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**Método que realiza la operación de multiplicación.
     * Obtiene los valores de los campos de texto, realiza la multiplicación y muestra el resultado.
     */
    public void multiplicar() {
        try {
            double num1 = Double.parseDouble(panelDatos.getTxtNumero1().getText());  //Obtener el texto del primer campo y convertirlo a número decimal
            double num2 = Double.parseDouble(panelDatos.getTxtNumero2().getText());  //Obtener el texto del segundo campo y convertirlo a número decimal
            double resultado = calculadora.multiplicar(num1, num2);                  //Realizar la multiplicación usando el objeto calculadora
            panelResultados.setTxtResultado(resultado);                              //Mostrar el resultado en el panel de resultados
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en ambos campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**Método que realiza la operación de división.
     * Obtiene los valores de los campos de texto, realiza la división y maneja
     * La excepción en caso de división por cero.
     */
    public void dividir() {
        try {
            double num1 = Double.parseDouble(panelDatos.getTxtNumero1().getText());  //Obtener el texto del primer campo y convertirlo a número decimal
            double num2 = Double.parseDouble(panelDatos.getTxtNumero2().getText());  //Obtener el texto del segundo campo y convertirlo a número decimal
            //Realizar la división usando el objeto calculadora
            //Esto puede lanzar IllegalArgumentException si num2 es cero
            double resultado = calculadora.dividir(num1, num2);
            panelResultados.setTxtResultado(resultado);  //Si no hay excepción, mostrar el resultado en el panel de resultados
        }
        catch(NumberFormatException e) { //Añadido para capturar entrada no numérica
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en ambos campos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
        catch(IllegalArgumentException e) {
            //Manejar específicamente la excepción de división por cero
            //Mostrar un mensaje de error al usuario en una ventana emergente
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de cálculo", JOptionPane.ERROR_MESSAGE); //Se uso 'this' como padre del diálogo
        }
        catch(Exception e) {
            //Manejar cualquier otra excepción inesperada
            //Mostrar un mensaje de error genérico al usuario
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    /**Método que limpia todos los campos de la calculadora.
     * Es llamado cuando el usuario presiona el botón "Limpiar".
     */
    public void limpiar() {
        panelDatos.limpiar(); //Limpiar los campos de entrada (números 1 y 2)
        panelResultados.limpiar(); //Limpiar el campo de resultado
    }
}
