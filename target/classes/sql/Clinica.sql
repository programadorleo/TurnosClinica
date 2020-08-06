drop database proyecto_java;
create database IF NOT EXISTS proyecto_java;
use proyecto_java;

create table IF NOT EXISTS Paciente (
	id int(5) not null auto_increment,
	apellido varchar(30) not null,
	nombre varchar (30) not null,
	dni int(8) not null,
	fecha_nacimiento varchar(10) not null,
	historia_clinica int (5) not null,
	obra_social varchar(25),
	primary key (id)
);

create table IF NOT EXISTS Medico (
	id int(5) not null auto_increment,
	apellido varchar(30) not null,
	nombre varchar (30) not null,
	dni int(8) not null,
	fecha_nacimiento varchar(10) not null,
	especialidad varchar(25) not null,
	matricula int(10) not null,
	primary key (id)
);

create table IF NOT EXISTS Turnos(
    NUMEROTURNO int(5) not null auto_increment,
    especialidad varchar(25) not null,
    dia int(2) not null,
    hora int(2) not null,
    NUMEROMATRICULA int(5) not null,
    DNIPACIENTE int(8) not null,
    primary key (NUMEROTURNO)    
);




