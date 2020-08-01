# JDBC  

## JDBC: Java Data Base Connectivity

#### Driver que concecta a una aplicacion java y una base de datos 

1.  Establece una conexion
2.  Permite manipular a BBDD para leer insertar actualizar o borrar registro de la misma

##### Antes de comemzar debemos
- instalar servidor mysql, (tengo wampserver  y creo las bases con phpmyadmin)
- instalar driver jdbc mysql
- agregar driver al classpath


#### Vamos necesitar dos paquetes  java.sql y javax.sql 


## Pasos para conectar

#### 	1 Establecer una conexion con la BBDD


Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java","root", "" );


#### 2 Crear un objeto statement

Statement miStatement = miConexion.createStatement();  

#### 3 Ejecutar la sentencia sql  devuelve una table que se almacena en memoria

ResultSet miResultSet=miStatement.executeQuery("SELECT * FROM PRODUCTOS");

#### 4 Leer resultset tabla   mediante getString() next()

while(miResultSet.next()) {

System.out.println(miResultSet.getString("CODIGOARTICULO")+ " " + miResultSet.getString("NOMBREARTICULO")+ 
" "+ miResultSet.getString("PRECIO"));
			}


####     Las conexiones lanzan excepciones debe estar dentro de try catch


##### Clase completa 


package conectaBD;
import java.sql.*;

public class Conecta_Pruebas {

	public static void main(String[] args) {
        try {
		
								/* 1_ Creo conexion */
								/* Base de datos llamada  proyecto_java*/
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_java","root", "" );
	
	 						/* 2_ Creo Objeto staement*/
			Statement miStatement = miConexion.createStatement();  
			
							/* 3_Ejecuto sql */
			ResultSet miResultSet=miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
							/*4_ Recorrer resulset */																														
			while(miResultSet.next()) {				
				System.out.println(miResultSet.getString("CODIGOARTICULO")+ " " + miResultSet.getString("NOMBREARTICULO")+ 
				" "+ miResultSet.getString("PRECIO"));
			}			
			
		}catch(Exception e) {
			
			System.out.println("No conecta"+ e.getMessage());			
		}
	  }
	}
