package fronted;

import java.util.Scanner;

public class EntradaSalida {

	public static Scanner EntradaTeclado = new Scanner(System.in);

	public static String leerString() {
		
		 return EntradaTeclado.next();
	
	}

	public static int leerInt(String msje) {

		System.out.println(msje + ": ");
		return EntradaTeclado.nextInt();

	}

	public static void mostrarString(String msje) {

		System.out.println(msje);

	}
	
	//Mueve el cursor del buffer una línea abajo
	public static void nuevaLinea() {

		EntradaTeclado.nextLine();

	}	

}
