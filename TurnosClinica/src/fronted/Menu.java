package fronted;

import backend.ControlTurnos;
import backend.Paciente;
import backend.Medico;

public class Menu {

	private static int nroDocumento;

	private static String especialidad;

	private static int dia;

	private static int hora;
	
	private static ControlTurnos control;
	
	private static boolean controlCreado = false;

	public void ejecutar() {

        EntradaSalida.mostrarString("Programa para procesar los turnos de una clínica" + "\n");
        System.out.println("---------------");
        System.out.println("Escoja una opción:");
        System.out.println("1 - Asignar un nuevo turno");
        System.out.println("2 - Ver lista de turnos");
        System.out.println("3 - Ver datos de paciente");
        System.out.println("4 - Ver datos de médico");
        System.out.println("5 - Salir del programa");
        System.out.println("---------------");
        int op = 0;
		
        try {
			op = EntradaSalida.leerInt(":");
		} catch (Exception e) {
			EntradaSalida.nuevaLinea();
			EntradaSalida.mostrarString("Ingreso incorreto. Intente nuevamente.\n");
			ejecutar();
		}		
        switch (op) {
        // Asignar un nuevo turno
        case 1:	
        	//Llama al método ingresarDatos() para cargar un nuevo turno.
        	ingresarDatos();
        	control = new ControlTurnos(nroDocumento, especialidad, dia, hora);
    		controlCreado = true;
    		control.procesarTurno();
    		//System.out.println("Turno asignado correctamente.\n");
    		ejecutar();
        	break;
        // Ver todos los turnos programados
        case 2:
        	if (!controlCreado)	control = new ControlTurnos();
        	
        /*	if (control.getListaTurnos().size()==0) {
        		control.cargarListaTurnos();      		
        	}*/
        	
        //	control.mostrarLista(control.getListaTurnos(), "de turnos");
        	ejecutar();
        	break;
        // Buscar paciente por número de DNI
        case 3:
        	ControlTurnos control3 = new ControlTurnos();
        	control3.cargarListaPacientes();
        	System.out.println("Ingrese DNI del paciente:");
        	int dniPaciente = chequeaNumeros(op);
        	// Busca en la lista de pacientes alguno que coincida con el DNI ingresado
        	boolean existePaciente = false;
        	for (Paciente p : control3.getListaPacientes()) {
        		if (dniPaciente == p.getDni()) {
        			System.out.println(p.toString());
        			existePaciente = true;
        			break;
        		}
        	}
        	// Si no encuentra ninguno, muestra monsaje de error y vuelve al menú principal
        	if (!existePaciente) System.out.println("Paciente no encontrado");
        	// Vuelve al menú principal
        	ejecutar();
        	break;
        // Buscar médico por número de DNI        	
        case 4:
        	ControlTurnos control4 = new ControlTurnos();
        	control4.cargarListaMedicos();
        	System.out.println("Ingrese DNI del médico:");
        	int dniMedico = chequeaNumeros(op);
        	// Busca en la lista de pacientes alguno que coincida con el DNI ingresado
        	boolean existeMedico = false;
        	for (Medico m : control4.getListaMedicos()) {
        		if (dniMedico == m.getDni()) {
        			System.out.println(m.toString());
        			existeMedico = true;
        			break;
        		}
        	}
        	// Si no encuentra ninguno, muestra monsaje de error y vuelve al menú principal
        	if (!existeMedico) System.out.println("Médico no encontrado");
        	// Vuelve al menú principal
        	ejecutar();
        	break;        	
        case 5:
        	//Cierra el programa
        	System.out.println("Gracias por utilizar el servicio.");
        	System.exit(0);
        default:
        	ejecutar();
        }		

		
	} // End ejecutar()
	

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
		
	} // End ingresarDatos()
	
	public static int chequeaNumeros (int num) {
		
		try {
			num =  EntradaSalida.leerInt(":");
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
	} // End chequeaNumeros
	
	public static void imprimirInformacion() {
		System.out.println("DNI: " + nroDocumento);
		System.out.println("Especialidad: " + especialidad);
		System.out.println("Día: " + dia);
		System.out.println("Hora: " + hora);
	}
		
} // End Menu
