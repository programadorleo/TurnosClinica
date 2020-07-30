package conectaBD;

import java.sql.*;

public class ConectaBaseDatos {

	public static void main(String[] args) {

		try {

			// Crear Conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java", "root",
					"");

			// crar objeto statement
			Statement miStatement = miConexion.createStatement();

			// ejecutar sql
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM TURNOS");

			// recorrer el resulset
			while (miResultSet.next()) {

				System.out.println(miResultSet.getString("NUMEROTURNO") + " " + miResultSet.getString("ESPECIALIDAD")
						+ " " + miResultSet.getString("DIA") + " " + miResultSet.getString("HORA") + " "
						+ miResultSet.getString("NUMEROMATRICULA") + " " + miResultSet.getString("DNIPACIENTE"));
			}

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}

	}

}
