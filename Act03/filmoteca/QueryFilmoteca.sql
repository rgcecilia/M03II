/*
 * @author Raúl Gutiérrez Cecilia
 * @Asignatura DAW M03II
 */

drop database filmoteca;
create database if not exists filmoteca;
use filmoteca;

create table Pelicula (
titulo varchar(50),
director varchar (50),
pais varchar (50),
duracion varchar (20),
genero varchar (50)
);

insert into Pelicula values ("jurassic park","Steven Spielberg","Estados Unidos","120 minutos","Ciencia Ficcion");
insert into Pelicula values ("Los Vengadores","Joss Whedon","Estados Unidos","120 minutos","Ciencia Ficcion");
insert into Pelicula values ("La Isla Minima","Alberto Rodríguez Librero","España","120 minutos","Suspense");
insert into Pelicula values ("La vida es bella","Roberto Benigni","Italia","120 minutos","Comedia/Drama");
insert into Pelicula values ("Guardianes de la galaxia","James Gunn","Estados Unidos","120 minutos","Ciencia Ficcion");
