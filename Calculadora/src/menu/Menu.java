package menu;
import java.util.Scanner;
/**
 * 
 * @author ikaslea
 * @version 1.0
 *
 */
public class Menu {
    private static Scanner teclado = new Scanner(System.in);
    
    /**
     * Pide al usuario los numeros para las operaciones
     * 
     * @return devuelve el array con los numeros introducidos
     */
    public int[] pedirNumeros(){
        int[] ret = new int[2];
        System.out.print ("Operando 1: ");
        ret [0] = teclado.nextInt();
        System.out.print ("Operando 2: ");
        ret [1] = teclado.nextInt();
        return ret;
    }
    
    /**
     * 
     * Controla que el usuario introduzca solo los signos de las operaciones
     * 
     * @return Devuelve un string vacio
     */
    public String menuOpciones() {
        String ret = "";
        do {
            System.out.print ("Operaciones [+, -, *, /, %]: ");
            ret = teclado.next();
        } while (!((ret.equalsIgnoreCase("+")) || (ret.equalsIgnoreCase("-")) ||
                (ret.equalsIgnoreCase("*")) || (ret.equalsIgnoreCase("/")) ||
                (ret.equalsIgnoreCase("%"))
                ));
                return ret;
    }
    
    /**
     * Repite la ejucion del programa
     * 
     * @return Devulve un booleano
     */
    public boolean repetir(){
        boolean ret = false;
        String respuesta;
        do {
            System.out.print ("�Desea continuar trabajando con la calculadora? [s / n]");
            respuesta = teclado.next();
        } while (!((respuesta.equalsIgnoreCase("s")) || (respuesta.equalsIgnoreCase("n"))
                    ));
                    
        if (respuesta.equalsIgnoreCase("s")){
            ret = true;
        }
        return ret;
    }
}