package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import backend.Turno;

public class ModificaBD {

	private static int contadorNumeroTurno = 20;

	private static int numeroTurno;

	private static Connection miConexion;

	private static Statement miStatement;

 
     public void mostrarMensaje(){
    	 
    	 System.out.println("Mensaje mostrados");
     }
	
	public void agregarTurno(Turno nvoTurno) {

	
		  numeroTurno = 50;
		  
		  String especialidad= nvoTurno.getEspecialidad();  		  
		  int dia= nvoTurno.getDia(); 
		  int hora=nvoTurno.getHora(); 
		  int matricula=nvoTurno.getNroMatricula(); 
		  int dni=nvoTurno.getDniPaciente();
		 
		  String datos =          "INSERT INTO turnos(NUMEROTURNO,ESPECIALIDAD,DIA,HORA,NUMEROMATRICULA,DNIPACIENTE)VALUE(numeroTurno ,'+especialidad+','+dia+','+hora+','+matricula+','+dni+)";
	   // String instruccionSql = "INSERT INTO turnos(NUMEROTURNO,ESPECIALIDAD,DIA,HORA,NUMEROMATRICULA,DNIPACIENTE)VALUE()";
		  
		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java", "root", "");

			miStatement = miConexion.createStatement();

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}

		 //String instruccionSql = "INSERT INTO turnos(NUMEROTURNO,ESPECIALIDAD,DIA,HORA,NUMEROMATRICULA,DNIPACIENTE)VALUE(nroTurno,especialidad,dia,hora,matricula,dni)";

		//String instruccionSql = "INSERT INTO turnos(NUMEROTURNO,ESPECIALIDAD,DIA,HORA,NUMEROMATRICULA,DNIPACIENTE)VALUE(16,'Cardiologia',3,10,450,46000000)";

		try {

			miStatement.executeUpdate(datos);

			System.out.println("Datos insertados correctamente");

		} catch (SQLException e) {

			System.out.println("No se ingresaron los datos " + e.getMessage());

			e.printStackTrace();
		}

	}

}
