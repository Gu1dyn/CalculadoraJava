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
        SwingUtilities.invokeLater(() -> {
            try { 
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException e) {
                System.err.println("Error al configurar Look and Feel: " + e.getMessage());
            }
            new InterfazCalculadora();  //Crear y mostrar la ventana principal de la calculadora, siendo visible
        });
    }
}         