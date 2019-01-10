/*
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

drop database filmotecaII;
create database if not exists filmotecaII;
use filmotecaII;

create table director (
id int(3) auto_increment not null PRIMARY KEY,
nombre varchar(50)
);

insert into director values (NULL,"Steven Spielberg");
insert into director values (NULL,"Joss Whedon");
insert into director values (NULL,"Alberto Rodríguez Librero");
insert into director values (NULL,"Roberto Benigni");
insert into director values (NULL,"James Gunn");

create table Pelicula (
id int(3) auto_increment not null PRIMARY KEY,
titulo varchar(50),
director int (3),
pais varchar (50),
duracion varchar (20),
genero varchar (50),
FOREIGN KEY (`director`) REFERENCES `director` (`id`)
);

insert into Pelicula values (NULL,"jurassic park",1,"Estados Unidos","120 minutos","Ciencia Ficcion");
insert into Pelicula values (NULL,"Los Vengadores",2,"Estados Unidos","120 minutos","Ciencia Ficcion");
insert into Pelicula values (NULL,"La Isla Minima",3,"España","120 minutos","Suspense");
insert into Pelicula values (NULL,"La vida es bella",4,"Italia","120 minutos","Comedia/Drama");
insert into Pelicula values (NULL,"Guardianes de la galaxia",5,"Estados Unidos","120 minutos","Ciencia Ficcion");
