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

		nroDocumento = EntradaSalida.leerInt("Ingrese Número Documento");
		
		int op = 0;
		boolean bandera = false;
		while (!bandera) {
			System.out.println("Ingrese Especialidad\n1. Cardiologia\n2. Clinica Medica\n3. Oftalmologia");
			try {
				op =  EntradaSalida.leerInt("Número");
				
			} catch (Exception e) {
				System.out.println("Ingrese un número del 1 al 3.\n");
				EntradaSalida.nuevaLinea();
			}
			bandera = (op >=1 && op<=3) ? true : false; 			
		}

		dia = EntradaSalida.leerInt("Ingrese día de la consulta");

		hora = EntradaSalida.leerInt("Ingrese hora de la consulta");

	}

}
