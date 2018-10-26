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
-- Table `activos`.`Funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Funcionarios` (
  `cedula` INT(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `puesto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cedula`),
  UNIQUE INDEX `id_UNIQUE` (`cedula` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activos`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Usuarios` (
  `id` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `tipo` TINYINT(5) NOT NULL,
  `Dependencias_codigo` INT(45) NOT NULL,
  `Funcionarios_cedula` INT(45) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Usuarios_Dependencias1_idx` (`Dependencias_codigo` ASC) VISIBLE,
  INDEX `fk_Usuarios_Funcionarios1_idx` (`Funcionarios_cedula` ASC) VISIBLE,
  CONSTRAINT `fk_Usuarios_Dependencias1`
    FOREIGN KEY (`Dependencias_codigo`)
    REFERENCES `activos`.`Dependencias` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuarios_Funcionarios1`
    FOREIGN KEY (`Funcionarios_cedula`)
    REFERENCES `activos`.`Funcionarios` (`cedula`)
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
-- Table `activos`.`Activos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activos`.`Activos` (
  `codigo` INT(45) NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `Dependencias_codigo` INT(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_Activos_Dependencias1_idx` (`Dependencias_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Activos_Dependencias1`
    FOREIGN KEY (`Dependencias_codigo`)
    REFERENCES `activos`.`Dependencias` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into Dependencias(codigo,nombre,ubicacion) values(1234,'Benjamin Nuñez','Lagunilla-Heredia');

insert into Funcionarios(cedula,nombre,puesto) values(403013010,"Oscar Campos", "Administrador");
insert into Funcionarios(cedula,nombre,puesto) values(104294103,"Gabriel Jimenez", "Secretario del OCCB");
insert into Funcionarios(cedula,nombre,puesto) values(204030103,"Jose Quiroz", "Jefe del OCCB");
insert into Funcionarios(cedula,nombre,puesto) values(304014014,"Josue Ramirez", "Registrador de bienes");
insert into Funcionarios(cedula,nombre,puesto) values(550240204,"Daniel Ortega", "Jefe de RRHH");
insert into Funcionarios(cedula,nombre,puesto) values(634203014,"Bryan Ruiz", "Varios puestos");


insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("admin_dependencia","clave_admin_dependencia",1,1234,403013010);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("secretaria_OCCB","clave_secretaria_OCCB",2,1234,104294103);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("jefe_OCCB","clave_jefe_OCCB",3,1234,204030103);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("registrador","clave_registrador",4,1234,304014014);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("jefe_RRHH","clave_jefe_RRHH",5,1234,550240204);
insert into Usuarios(id,clave,tipo,Dependencias_codigo,Funcionarios_cedula) values("jefe_OCCB_RRHH","clave_jefe_OCCB_RRHH",7,1234,634203014);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
