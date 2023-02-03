package principal;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora {
	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());
	public static void main(String[] args) {
		int resultado = 0;
		String operacion = "";
		int[] operandos = new int[2];

		Menu menu = new Menu();
		Operaciones operaciones = new Operaciones();
		
		try {
			Handler consoleHandler = new ConsoleHandler();
			Handler fileHandler  = new FileHandler("./operaciones.log");
            
            //Asignar handlers al objeto LOGGER
            //LOGGER.setUseParentHandlers(false);
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);
             
            //Establecer niveles a handlers y LOGGER
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            
            LOGGER.config("Configuración hecha.");
            
            //Eliminamos handler de la consola
            LOGGER.removeHandler(consoleHandler);
             
            LOGGER.log(Level.FINE, "Nivel de log cambiado a FINE");
		}
		catch(IOException exception){
			LOGGER.log(Level.SEVERE, "Ocurrió un error en FileHandler.", exception);
		}
		
		/**
		 * Bucle
		 * Un bucle donde se piden numeros y dependiendo de el signo que el usuario introduzca se llamará a una función distinta
		 */
		do {
			operandos = menu.pedirNumeros();
			operacion = menu.menuOpciones();

			if (operacion.equalsIgnoreCase("+")) {
				resultado = operaciones.sumar(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
				LOGGER.log(Level.FINE, "Suma realizada correctamente");
			} else if (operacion.equalsIgnoreCase("-")) {
				resultado = operaciones.restar(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
				LOGGER.log(Level.FINE, "Resta realizada correctamente");
			} else if (operacion.equalsIgnoreCase("*")) {
				resultado = operaciones.multiplicar(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
				LOGGER.log(Level.FINE, "Multiplicacion realizada correctamente");
			} else if (operacion.equalsIgnoreCase("/")) {
				try {
					resultado = operaciones.dividir(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
				} catch (ArithmeticException e) {
					LOGGER.log(Level.WARNING, "Division entre 0");
					System.out.println("Error aritmetico: " + e.getMessage());
				}

			} else if (operacion.equalsIgnoreCase("%")) {
				resultado = operaciones.resto(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
			} else {
				System.out.println("Operaci�n no v�lida");
			}
		} while (menu.repetir());
	}
}