package operaciones;

/**
 * 
 * @author ikaslea
 *
 */

public class Operaciones{
	/**
	 * 
	 * @param valor1
	 * @param valor2
	 * @return el resultado de la suma 
	 */
    public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1
     * @param valor2
     * @return el resultado de la resta
     */
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    /**
     * 
     * 
     * @param valor1
     * @param valor2
     * @return el resultado de la multiplicacion
     */
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    
    /**
     * 
     * @param valor1
     * @param valor2
     * @return el resultado de la division
     */
    public int dividir (int valor1, int valor2) throws ArithmeticException{
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    /**
     * 
     * @param valor1
     * @param valor2
     * @return el resto de la division 
     */
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}