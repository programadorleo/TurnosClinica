package backend;

public class Turno {

	private String especialidad;

	private int dia = 0;

	private int hora = 0;

	private int nroMatricula = 0;

	private int dniPaciente = 0;

	public Turno(String especialidad, int dia, int hora, int nroMatricula, int dniPaciente) {

		super();

		this.especialidad = especialidad;

		this.dia = dia;

		this.hora = hora;

		this.nroMatricula = nroMatricula;

		this.dniPaciente = dniPaciente;

	}
	
	public String toString () {
		
		return "Especialidad: "+especialidad+" Dia: "+ dia+ " Hora: "+ hora + 
				" Numero Matricula: "+nroMatricula+ " Dni Paciente: "+ dniPaciente+"\n";
	}

	public String getEspecialidad() {

		return especialidad;

	}

	public void setEspecialidad(String especialidad) {

		this.especialidad = especialidad;
	}

	public int getDia() {

		return dia;
	}

	public void setDia(int dia) {

		this.dia = dia;

	}

	public int getHora() {

		return hora;

	}

	public void setHora(int hora) {

		this.hora = hora;

	}

	public int getNroMatricula() {

		return nroMatricula;

	}

	public void setNroMatricula(int nroMatricula) {

		this.nroMatricula = nroMatricula;

	}

	public int getDniPaciente() {

		return dniPaciente;

	}

	public void setDniPaciente(int dniPaciente) {

		this.dniPaciente = dniPaciente;

	}

}
