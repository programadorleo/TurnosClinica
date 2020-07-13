package backend;

public class Paciente extends Persona {

	private int numeroHistoriaClinica;

	private String obraSocial;

	public Paciente(String apellido, String nombre, int dni, String fachaNacimiento, int numeroHistoriaClinica,
			String obraSocial) {

		super(apellido, nombre, dni, fachaNacimiento);

		this.numeroHistoriaClinica = numeroHistoriaClinica;

		this.obraSocial = obraSocial;

	}

	public int getNumeroHistoriaClinica() {

		return numeroHistoriaClinica;

	}

	public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {

		this.numeroHistoriaClinica = numeroHistoriaClinica;
	}

	public String getObraSocial() {

		return obraSocial;

	}

	public void setObraSocial(String obraSocial) {

		this.obraSocial = obraSocial;
	}
	
	public String toString() {
		
		return "Apellido: "+apellido+" Nombre: "+nombre+" DNI: "+dni+" Fecha Nacimiento: "+fechaNacimiento+
				" Numero historia clinica: "+numeroHistoriaClinica+" Obra social: "+obraSocial+ "\n";
	}

}
