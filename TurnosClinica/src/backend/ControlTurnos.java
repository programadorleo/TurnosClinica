package backend;

import java.util.*;
import conectaBD.ModificaBD;
import fronted.*;

public class ControlTurnos {

	private int nroDocumento;
	private String especialidad;
	private int dia;
	private int hora;

	private ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
	private ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
	//private ArrayList<Turno> listaTurnos = new ArrayList<Turno>();

	public ControlTurnos() {
		
	}
	
	public ControlTurnos(int nroDocumento, String especialidad, int dia, int hora) {
		super();
		this.nroDocumento = nroDocumento;
		this.especialidad = especialidad;
		this.dia = dia;
		this.hora = hora;
	}
	

	public void procesarTurno() {

		cargarListas();

		//mostrarLista(listaTurnos, "turnos antes de cargar");

		//boolean encontradoTurno = buscarTurno(especialidad, dia, hora);

		/*if (encontradoTurno) {

			EntradaSalida.mostrarString("El turno esta ocupado");

		} else {

			asignarTurno();

		}*/

		//mostrarLista(listaTurnos, "turnos despues de cargar");
		
		asignarTurno();

		boolean encontradoPaciente = buscarPaciente(nroDocumento);
			

		if (!encontradoPaciente) {

			EntradaSalida.mostrarString("El paciente no esta la base de datos");

			EntradaSalida.mostrarString("Ingrese Apellido o no para no ingresar al nuevo paciente a la base");

			String nuevoApellido = EntradaSalida.leerString();

			if (!nuevoApellido.equals("no")) {

				agregarBaseDatos(nuevoApellido);
			}

		}

	}

	public void asignarTurno() {
		
		ModificaBD miBD = new ModificaBD();

		int matricula = buscarMedico(especialidad);

		Turno nuevoTurno = new Turno(especialidad, dia, hora, matricula, nroDocumento);

		
		miBD.agregarTurno(nuevoTurno);
		
		//listaTurnos.add(nuevoTurno);

		//EntradaSalida.mostrarString("El turno fue asignado correctamente");

	}

	public void agregarBaseDatos(String nuevoApellido) {

		int nuevoDni = nroDocumento;

		EntradaSalida.mostrarString("Ingrese Nombre");

		String nuevoNombre = EntradaSalida.leerString();

		EntradaSalida.mostrarString("Ingrese fecha de nacimiento");

		String nuevoFechaNacimiento = EntradaSalida.leerString();

		EntradaSalida.mostrarString("Ingrese obra social");

		String nuevaObraSocial = EntradaSalida.EntradaTeclado.next();

		int nroHistoriaClinica = EntradaSalida.leerInt("Operador asigne numero historia clinica");

		Paciente nuevoPaciente = new Paciente(nuevoApellido, nuevoNombre, nuevoDni, nuevoFechaNacimiento, nroHistoriaClinica,
				nuevaObraSocial);
		
		listaPacientes.add(nuevoPaciente);
	
		EntradaSalida.mostrarString("Se ingreso el nuevo paciente correctamente");

		mostrarLista(listaPacientes, "Lista pacientes luego de ingresar a la nueva persona");

	}

	public void mostrarLista(ArrayList<?> lista, String mensaje) {

		EntradaSalida.mostrarString("Lista " + mensaje + ": \n" + lista);

	}

	public void cargarListas() {

		cargarListaMedicos();

		cargarListaPacientes();

		cargarListaTurnos();

	}

	public void cargarListaMedicos() {

		Medico medico1 = new Medico("Garcia", "Alberto", 23000000, "11-11-1970", "Cardiologia", 100);

		Medico medico2 = new Medico("Fernandez", "Susana", 27000000, "09-09-1980", "Clinica Medica", 200);

		Medico medico3 = new Medico("Lopez", "Marcos", 37000000, "05-05-1990", "Oftalmologia", 300);

		listaMedicos.add(medico1);

		listaMedicos.add(medico2);

		listaMedicos.add(medico3);

	}

	public void cargarListaPacientes() {

		Paciente paciente1 = new Paciente("Benitez", "Facundo", 25000000, "10-10-1975", 10, "Osecac");

		Paciente paciente2 = new Paciente("Gonzales", "Maria", 35000000, "10-10-1985", 20, "Medicus");

		Paciente paciente3 = new Paciente("Rodriguez", "Juan", 42000000, "10-10-2000", 30, "");

		listaPacientes.add(paciente1);

		listaPacientes.add(paciente2);

		listaPacientes.add(paciente3);

	}

	public void cargarListaTurnos() {

		Turno turno1 = new Turno("Cardiologia", 1, 1, 100, 25000000);

		Turno turno2 = new Turno("Clinica Medica", 1, 1, 200, 35000000);

		Turno turno3 = new Turno("Oftalmologia", 1, 1, 300, 42000000);

		//listaTurnos.add(turno1);

		//listaTurnos.add(turno2);

		//listaTurnos.add(turno3);

	}

	public boolean buscarPaciente(int nroDocumento) {

		Paciente aux;

		for (int i = 0; i < listaPacientes.size(); i++) {

			aux = listaPacientes.get(i);

			if (aux.dni == nroDocumento) {
					
				return true;
			}

		}

		return false;

	}
/*
	public boolean buscarTurno(String especialidad, int dia, int hora) {

		Turno aux;

		for (int i = 0; i < listaTurnos.size(); i++) {

			aux = listaTurnos.get(i);

			if (aux.getEspecialidad().equals(especialidad) && aux.getDia() == dia && aux.getHora() == hora
					&& aux.getDniPaciente() != 0) {

				return true;

			}

		}

		return false;

	}*/

	public int buscarMedico(String especialidad) {

		for (Medico medico : listaMedicos) {

			if (medico.getEspecialidad().equals(especialidad))

				return medico.getNroMatricula();
		}

		return 0;
	}
	
	/*public ArrayList<Turno> getListaTurnos() {
		return listaTurnos;
	}*/
	
	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}
	
	public ArrayList<Medico> getListaMedicos() {
		return listaMedicos;
	}	
	
}
