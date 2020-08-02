package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import backend.Turno;

public class ModificaBD {
	
	private static int contadorNumeroTurno=20;
	
	private static int numeroTurno;
	
	private Connection miConexion;
	
	private static Statement miStatement;
	
	
	public ModificaBD() {
		
		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java", "root",
					"");

			miStatement = miConexion.createStatement();

			

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}		
		
	}

	public static void agregarTurno (Turno nvoTurno)  {

		numeroTurno = 50;
		
		//String especialidad= nvoTurno.getEspecialidad();
		String especialidad="Oftalmologia";
		int dia= nvoTurno.getDia();
		int hora=nvoTurno.getHora();
		int matricula=nvoTurno.getNroMatricula();
		int dni= nvoTurno.getDniPaciente();
		
	
		
		//String instruccionSql = "INSERT INTO turnos(NUMEROTURNO,ESPECIALIDAD,DIA,HORA,NUMEROMATRICULA,DNIPACIENTE)VALUE(nroTurno,especialidad,dia,hora,matricula,dni)";
		
		String instruccionSql = "INSERT INTO turnos(NUMEROTURNO,ESPECIALIDAD,DIA,HORA,NUMEROMATRICULA,DNIPACIENTE)VALUE(11,'Cardiologia',2,10,450,44000000)";
			
		
		try {
			
			miStatement.executeUpdate(instruccionSql);
			
			System.out.println("Datos insertados correctamente");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
	}

}
