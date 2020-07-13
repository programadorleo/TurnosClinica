package backend;

import java.util.*;

public class ControlTurnos {

	private ArrayList<Medico> listaMedicos = new ArrayList<Medico>();

	private ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();

	private ArrayList<Turno> listaTurnos = new ArrayList<Turno>();

	public void procesarTurno(int nroDocumento, String especialidad, int dia, int hora) {

		cargarListas();
	
		mostrarLista(listaTurnos, "turnos antes de cargar");

		boolean encontrado = buscarTurno(especialidad,dia,hora);

		if (encontrado) {

			System.out.println("El turno esta ocupado");

		} else {

			int matricula = buscarMedico(especialidad);

			Turno nuevoTurno = new Turno(especialidad, dia, hora, matricula, nroDocumento);

			listaTurnos.add(nuevoTurno);
			
			System.out.println("El turno fue asignado correctamente");

		}

		mostrarLista(listaTurnos, "turnos despues de cargar");

	}

	public void mostrarLista(ArrayList<?> lista, String mensaje) {

		System.out.println("Lista " + mensaje + ": \n" + lista);

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

		listaTurnos.add(turno1);

		listaTurnos.add(turno2);

		listaTurnos.add(turno3);

	}

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

	}

	public int buscarMedico(String especialidad) {

		for (Medico medico : listaMedicos) {

			if (medico.getEspecialidad().equals(especialidad))

				return medico.getNroMatricula();
		}

		return 0;
	}

}
