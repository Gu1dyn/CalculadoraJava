package mundo;

/**Clase que representa una calculadora básica con las cuatro operaciones fundamentales.
 * Esta clase contiene la lógica de negocio para realizar cálculos matemáticos.
 * * @author Johan Guillen
 * @version 1.0
 */

public class Calculadora {

    /**Método que realiza la suma de dos números decimales.
     * @param num1 Primer número a sumar (sumando)
     * @param num2 Segundo número a sumar (sumando)
     * @return El resultado de la suma de num1 + num2
     */
    public double sumar(double num1, double num2) {
        return num1 + num2; //Retorna la suma directa de los dos números
    }
    
    /**Método que realiza la resta de dos números decimales.
     * @param num1 Número del cual se va a restar (minuendo)
     * @param num2 Número que se va a restar (sustraendo)
     * @return El resultado de la resta num1 - num2
     */
    public double restar(double num1, double num2){
        return num1 - num2; //Retorna la resta del primer número menos el segundo
    }
    
    /**Método que realiza la multiplicación de dos números decimales.
     * @param num1 Primer factor de la multiplicación
     * @param num2 Segundo factor de la multiplicación
     * @return El resultado de la multiplicación num1 * num2
     */
    public double multiplicar(double num1, double num2) {
        return num1 * num2; //Retorna el producto de los dos números
    }
    
    /**Método que realiza la división de dos números decimales.
     * Valida que el divisor no sea cero para evitar división por cero.
     * @param num1 Número que se va a dividir (dividendo)
     * @param num2 Número por el cual se va a dividir (divisor)
     * @return El resultado de la división num1 / num2
     * @throws IllegalArgumentException Si el divisor (num2) es igual a cero
     */
    public double dividir(double num1, double num2) throws IllegalArgumentException {
        if(num2 != 0) { //Verificar si el divisor es diferente de cero
            return num1 / num2; //Si el divisor no es cero, realizar la división normalmente
        }
        throw new IllegalArgumentException("No se puede dividir por cero"); //Si el divisor es cero, lanzar excepción IllegalArgumentException
    }
}
