package fronted;

import java.util.Scanner;

public class EntradaSalida {

	private static Scanner l = new Scanner(System.in);

	public static String leerString(String msje) {

		System.out.println(msje + ": ");

		return l.next();
		
	}

	public static int leerInt(String msje) {

		System.out.println(msje + ": ");

		return l.nextInt();

	}

	public static void mostrarString(String msje) {

		System.out.println(msje);

	}

}
