package backend;

public class Medico extends Persona{
	
	private String especialidad;
	
	private int nroMatricula; 

	public Medico(String apellido, String nombre, int dni, String fachaNacimiento, String especialidad,
			int nroMatricula) {

		super(apellido, nombre, dni, fachaNacimiento);
		
		this.especialidad=especialidad;
		
		this.nroMatricula=nroMatricula;
		
	}
	
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getNroMatricula() {
		return nroMatricula;
	}

	public void setNroMatricula(int nroMatricula) {
		this.nroMatricula = nroMatricula;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public String toString () {
		
		return "Apellido: "+apellido+" Nombre: "+nombre+" DNI: "+dni+" Fecha Nacimiento: "+fechaNacimiento+
				" Especialidad: "+especialidad+" Matricula: "+nroMatricula+ "\n";
	} 
 
}