create database if not exists activos;

use activos;

create table if not exists usuarios(

	id varchar(64) primary key NOT NULL unique,
    clave varchar(64) NOT NULL,
    tipo_usuario INT NOT NULL 


)engine = innoDB;

