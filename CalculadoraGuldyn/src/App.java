
/**Clase principal de la aplicación calculadora.
 * Contiene el método main que inicia la aplicación.
 * * @author Johan Guillen
 * @version 1.0
 */

import interfaz.InterfazCalculadora;

import javax.swing.SwingUtilities;
import javax.swing.UIManager; 

public class App {
    
    /**Método principal que se ejecuta al iniciar la aplicación.
     * Configura el Look and Feel y crea la interfaz gráfica de la calculadora.
     * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //Se ejecuta la interfaz gráfica en el Event Dispatch Thread (EDT)
            
            /**Método run que se ejecuta en el EDT.
             * Configura la apariencia y crea la ventana de la calculadora.
             */
            @Override
            public void run() {
                try {
                    //Configurar el Look and Feel para que la aplicación
                    //Tenga la apariencia nativa del sistema operativo
                    //Se usa getSystemLookAndFeelClassName() para obtener el nombre de la clase
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    System.err.println("Error al configurar Look and Feel: " + e.getMessage()); //Si hay error al configurar el Look and Feel, entonces mensaje de error
                }
                new InterfazCalculadora(); //Crear y mostrar la ventana principal de la calculadora, siendo visible
            }
        });
    }
}
