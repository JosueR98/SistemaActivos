-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema activos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema activos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `activos` DEFAULT CHARACTER SET utf8 ;
USE `activos` ;

-- -----------------------------------------------------
-- Table `activos`.`Funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Funcionarios` (
  `cedula` INT(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cedula`),
  UNIQUE INDEX `id_UNIQUE` (`cedula` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activos`.`Dependencias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Dependencias` (
  `codigo` INT(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `Ubicacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activos`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Usuarios` (
  `id` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `tipo` TINYINT(5) NOT NULL,
  `Funcionarios_cedula` INT(45) NULL,
  `Dependencias_codigo` INT(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Usuarios_Funcionarios1_idx` (`Funcionarios_cedula` ASC) VISIBLE,
  INDEX `fk_Usuarios_Dependencias1_idx` (`Dependencias_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_Funcionarios1`
    FOREIGN KEY (`Funcionarios_cedula`)
    REFERENCES `activos`.`Funcionarios` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_Dependencias1`
    FOREIGN KEY (`Dependencias_codigo`)
    REFERENCES `activos`.`Dependencias` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activos`.`Solicitudes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Solicitudes` (
  `codigo` INT(45) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `montoTotal` DOUBLE NOT NULL,
  `cantidad` TINYINT(5) NOT NULL,
  `estado` TINYINT(5) NOT NULL,
  `tipo` TINYINT(5) NOT NULL,
  `motivoC` VARCHAR(45) NULL DEFAULT 'No cancelada',
  `Dependencias_codigo` INT(45) NOT NULL,
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_Solicitudes_Dependencias1_idx` (`Dependencias_codigo` ASC) VISIBLE,
  PRIMARY KEY (`codigo`),
  CONSTRAINT `fk_Solicitudes_Dependencias1`
    FOREIGN KEY (`Dependencias_codigo`)
    REFERENCES `activos`.`Dependencias` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activos`.`Bienes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Bienes` (
  `codigo` INT(45) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NULL,
  `precioUnitario` DOUBLE NOT NULL,
  `estaRegistrado` TINYINT NOT NULL DEFAULT 0,
  `Solicitudes_codigo` INT(45) NOT NULL,
  `Usuarios_id` VARCHAR(45) NULL DEFAULT 'No asignado',
  INDEX `fk_Bienes_Solicitudes1_idx` (`Solicitudes_codigo` ASC) VISIBLE,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_Bienes_Usuarios1_idx` (`Usuarios_id` ASC) VISIBLE,
  CONSTRAINT `fk_Bienes_Solicitudes1`
    FOREIGN KEY (`Solicitudes_codigo`)
    REFERENCES `activos`.`Solicitudes` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bienes_Usuarios1`
    FOREIGN KEY (`Usuarios_id`)
    REFERENCES `activos`.`Usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activos`.`Puestos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Puestos` (
  `codigo` INT(45) NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NOT NULL,
  `Funcionarios_cedula` INT(45) NULL,
  `Dependencias_codigo` INT(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_Puestos_Funcionarios1_idx` (`Funcionarios_cedula` ASC) VISIBLE,
  INDEX `fk_Puestos_Dependencias1_idx` (`Dependencias_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Puestos_Funcionarios1`
    FOREIGN KEY (`Funcionarios_cedula`)
    REFERENCES `activos`.`Funcionarios` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Puestos_Dependencias1`
    FOREIGN KEY (`Dependencias_codigo`)
    REFERENCES `activos`.`Dependencias` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activos`.`Activos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Activos` (
  `codigo` INT(45) NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `Puestos_codigo` INT(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_Activos_Puestos1_idx` (`Puestos_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Activos_Puestos1`
    FOREIGN KEY (`Puestos_codigo`)
    REFERENCES `activos`.`Puestos` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into Dependencias(codigo,nombre,ubicacion) values(1234,'Escuela de informatica','Lagunilla-Heredia');
insert into Dependencias(codigo,nombre,ubicacion) values(2345,'Escuela de matematica','Heredia Centro');


insert into Funcionarios(cedula,nombre,correo) values(403013010,"Oscar Campos", "papadelostomates@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(104294103,"Gabriel Jimenez", "secrekun@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(204030103,"Jose Quiroz", "jfeda@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(304014014,"Josue Ramirez", "Reigstrrer1@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(550240204,"Daniel Ortega", "Jefs@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(634203014,"Bryan Ruiz", "capsxD@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(421421412,"Jose Sanchez", "joses@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(532523523,"Marta Quriroz", "Reigstrrer1@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(532525276,"Oscar Ortega", "oscu@gmail.com");
insert into Funcionarios(cedula,nombre,correo) values(421412423,"Felipe Ruiz", "felie@gmail.com");


insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Administrador de la dependencia", 403013010,1234);
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Secretaria de la OCCB", 104294103,1234);
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Jefe de la OCCB", 204030103,1234);
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Registrador de bienes", 304014014,1234);
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Registrador de bienes", 532525276,1234);
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Registrador de bienes", 421412423,1234);
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Jefe de RRHH", 550240204,1234 );
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Jefe de RRHH Y OCCB", 634203014,1234 );
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Profesor Arqui", 421421412,1234 );
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Conserje", 532523523,1234 );

insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Profesor programacion 1", NULL,1234 );
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Contador", NULL,1234);
insert into puestos(codigo,rol,Funcionarios_cedula,Dependencias_codigo) values (0,"Conserje", NULL,1234);

insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("admin_dependencia","aaa",1,1234,403013010);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("secretaria_OCCB","bbb",2,1234,104294103);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("jefe_OCCB","ccc",3,1234,204030103);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("registrador1","ddd",4,1234,304014014);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("registrador2","ddd",4,1234,532525276);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("registrador3","ddd",4,1234,421412423);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("jefe_RRHH","eeee",5,1234,550240204);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("jefe_OCCB_RRHH","fff",7,1234,634203014);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
