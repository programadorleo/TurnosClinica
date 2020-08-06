use proyecto_java;

insert into Paciente (apellido, nombre, dni, fecha_nacimiento, historia_clinica, obra_social) values ('Benitez', 'Facundo', 25000000, '10-10-1975', 10, 'Osecac');
insert into Paciente (apellido, nombre, dni, fecha_nacimiento, historia_clinica, obra_social) values ('Gonzales', 'María', 35000000, '10-10-1985', 10, 'Medicus');
insert into Paciente (apellido, nombre, dni, fecha_nacimiento, historia_clinica, obra_social) values ('Rodríguez', 'Juan', 42000000, '10-10-2000', 30, ' ');


insert into Medico (apellido, nombre, dni, fecha_nacimiento, especialidad, matricula) values ('Garcia', 'Alberto', 23000000, '11-11-1970', 'Cardiologia', 100);
insert into Medico (apellido, nombre, dni, fecha_nacimiento, especialidad, matricula) values ('Fernandez', 'Susana', 27000000, '09-09-1980', 'Clinica Medica', 200);
insert into Medico (apellido, nombre, dni, fecha_nacimiento, especialidad, matricula) values ('Lopez', 'Marcos', 37000000, '05-05-1990', 'Oftalmología', 300);

insert into Turnos (especialidad, dia, hora, NUMEROMATRICULA, DNIPACIENTE) values ('Cardiología', 1, 1, 100, 25000000);
insert into Turnos (especialidad, dia, hora, NUMEROMATRICULA, DNIPACIENTE) values ('Clinica Medica', 1, 1, 200, 35000000);
insert into Turnos (especialidad, dia, hora, NUMEROMATRICULA, DNIPACIENTE) values ('Oftalmologia', 1, 1, 300, 42000000);