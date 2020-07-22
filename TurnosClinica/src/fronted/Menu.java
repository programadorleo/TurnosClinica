package fronted;

import backend.ControlTurnos;

public class Menu {

	private static int nroDocumento;

	private static String especialidad;

	private static int dia;

	private static int hora;

	public void ejecutar() {

		ControlTurnos control = new ControlTurnos();

		EntradaSalida.mostrarString("Programa para procesar los turnos de una clínica" + "\n\nPrimero se cargan los turnos");
		
		ingresarDatos();

		control.procesarTurno(nroDocumento, especialidad, dia, hora);
		
	}

	public static void ingresarDatos() {

		int op = 0;

		//Número DNI
		do {
			System.out.println("Ingrese Número Documento");	
			nroDocumento = chequeaNumeros(op);
		} while (nroDocumento == 0);		
		
		//Especialidad
		do {
			System.out.println("Ingrese Especialidad\n1. Cardiologia\n2. Clinica Médica\n3. Oftalmología");
			op = chequeaNumeros(op);
			switch (op) {
			case 1:
				especialidad = "Cardiología";
				break;
			case 2:
				especialidad = "Clínica Médica";
				break;
			case 3:
				especialidad = "Oftalmología";
				break;		
			default:
				System.out.println("Error. Especialidad no encontrada. Intente nuevamente.");
				op = 0;
			}
			
		} while (op == 0); 
		
		//Día
		do {
			System.out.println("Ingrese día de la consulta");	
			dia = chequeaNumeros(op);
			if (dia < 1 || dia > 7) System.out.println("Ingrese sólo números del 1 al 7");
		} while (dia < 1 || dia >7); 

		//Hora
		do {
			System.out.println("Ingrese hora de la consulta");	
			hora = chequeaNumeros(op);
			if (hora < 8 || hora > 20) System.out.println("Ingrese sólo números del 8 al 20");
		} while (hora < 8 || hora > 20);
		
		//Imprime la información ingresada
		imprimirInformacion();
		System.out.println("\n");
		
	}
	
	public static int chequeaNumeros (int num) {
		
		try {
			num =  EntradaSalida.leerInt("Número");
			//Si se introdujo un número, la función devuelve su valor
			return num;
		} catch (Exception e) {
			//Si se introdujeron caracteres no numéricos, se ejecuta lo siguiente
			System.out.println("Ingrese sólo valores numéricos.\n");
			//Se ingresa una nueva línea en el buffer para que no se ejecute infinitamente el código
			EntradaSalida.nuevaLinea();
			//La función devuelve 0 si se encontró este error
			return 0;
		}	
	}
	
	public static void imprimirInformacion() {
		System.out.println("DNI: " + nroDocumento);
		System.out.println("Especialidad: " + especialidad);
		System.out.println("Día: " + dia);
		System.out.println("Hora: " + hora);
	}
		

}
