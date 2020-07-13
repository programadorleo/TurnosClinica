package fronted;

import backend.ControlTurnos;

public class Menu {

	private static int nroDocumento;

	private static String especialidad;

	private static int dia;

	private static int hora;

	public void ejecutar() {

		ControlTurnos control = new ControlTurnos();

		EntradaSalida.mostrarString("Programa para procesar los turnos de una clinina" + "\n\n Primero cargamos los turno");
		
		ingresarDatos();

		control.procesarTurno(nroDocumento, especialidad, dia, hora);
		
	}

	public static void ingresarDatos() {

		nroDocumento = EntradaSalida.leerInt("Ingrese Numero Documento");

		especialidad = EntradaSalida.leerString("Ingrese Especialidad\n Cardiologia - Clinica Medica - Oftalmologia");

		dia = EntradaSalida.leerInt("Ingrese dia de la consulta");

		hora = EntradaSalida.leerInt("Ingrese hora de la consulta");

	}

}
