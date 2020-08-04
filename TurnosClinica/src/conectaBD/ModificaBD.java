package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import backend.Turno;

public class ModificaBD {

	private static int contadorNumeroTurno = 71;

	private static Connection miConexion;

	public ModificaBD() {

	}

	public void agregarTurno(Turno nvoTurno) {

		int numeroTurno = contadorNumeroTurno++;
		String especialidad = nvoTurno.getEspecialidad();
		int dia = nvoTurno.getDia();
		int hora = nvoTurno.getHora();
		int matricula = nvoTurno.getNroMatricula();
		int dni = nvoTurno.getDniPaciente();

		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java", "root", "");

		} catch (Exception e) {

			System.out.println("No conecta" + e.getMessage());

		}

		try {

			PreparedStatement ps = miConexion.prepareStatement(
					"INSERT INTO turnos(NUMEROTURNO,ESPECIALIDAD,DIA,HORA,NUMEROMATRICULA,DNIPACIENTE)VALUES(?,?,?,?,?,?)");

			ps.setInt(1, numeroTurno);
			ps.setString(2, especialidad);
			ps.setInt(3, dia);
			ps.setInt(4, hora);
			ps.setInt(5, matricula);
			ps.setInt(6, dni);

			ps.executeUpdate();

			System.out.println("Datos insertados correctamente");

		} catch (SQLException e) {

			System.out.println("No se ingresaron los datos " + e.getMessage());

			e.printStackTrace();
		}

	}


	public void mostrarTurnos() {

		try {

			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java", "root", "");

			Statement miStatement = miConexion.createStatement();

			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM turnos");

			while (miResultSet.next()) {

				System.out.println(miResultSet.getString("NUMEROTURNO") + " " + miResultSet.getString("ESPECIALIDAD")
						+ " " + miResultSet.getString("DIA") + " " + miResultSet.getString("HORA") + " "
						+ miResultSet.getString("NUMEROMATRICULA") + " " + miResultSet.getString("DNIPACIENTE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
