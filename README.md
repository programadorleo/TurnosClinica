# TurnosClinica 

#Programa para asignar turnos de una clinica#

##Esata divididido en dos carpetas fronted y backend## 

###fronted  tiene los archivos### 
	-Main:  comienza el programa
	-Menu: se ingresan los datos
	-EntradaSalida: metodos para el ingresar y ver los datos


###backend tiene los archivos###
	-ControlTurnos  con tres ArrayList turnos medicos pacientes (que en un futuro seran tablas)
               Turno
	-Persona 
		-Medico subclase de Persona 
		-Paciente subclase de Persona 
		

El que quiera participar lo asigno como colaborador asi pueden trabajar la rama master,
crea una rama personal para probar y despues sube directo al repositorio que trabajamos juntos 


Que se puede hacer cualquiercosa es para practicar git

Lo que me parece que le falta 

	-Control de ingreso de datos, que los datos ingresados sean los correctos
	-Que se pueda ingresar medicos nuevos
	-Que se pueda ingresar pacientes nuevos
	-Hacer un fronted con swing 
	-un metodo que me traiga los datos de los pacientes cuando ingreso el dni 
  
	
  Me avisa su usuario, lo invito a participar, le va a llegar un mail, me aceptan la invitacion y ya los 
dos podemos modificar el proyecto 

 Descargan el proyecto,  lo clonan 
**git clone https://github.com/programadorleo/TurnosClinica.git**
 Aca los dos estamos en la rama master y podemos trabajar con el mismo proyecto 

 Crean su propia rama para probar el codigo que van a modificar,  
 llamo a mi rama  "desarrollo" 
**git branch desarrollo**

 Ingreso a esa rama 
**git checkout desarrollo**

  Realizo los cambios que creo necesarios, ya que estoy en una rama distinta puedo probar 
  lo que quiero 

 Uno mi rama "desarrolo" con la rama master principal 
**git merge desarrollo** 

 Si todo esta bien borro la rama desarrollo(ya no me sirve mas, no se vuelve a utilizar)
**git branch -d desarrollo**

terminado 


cuando alguien hace un cambio en la rama principal, me los traigo con
**git pull origin master** 

y vuelvo a empezar -creo rama - ingreso a esa rama - modifico los archivos - uno mi rama a la principal 
para seguir trabajando en el proyecto 


