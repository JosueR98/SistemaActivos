-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema activosDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema activosDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `activosDB` DEFAULT CHARACTER SET utf8 ;
USE `activosDB` ;

-- -----------------------------------------------------
-- Table `activosDB`.`Solicitudes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activosDB`.`Solicitudes` (
  `codigo` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `montoTotal` DOUBLE NOT NULL,
  `estado` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activosDB`.`Bienes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activosDB`.`Bienes` (
  `codigo` INT NOT NULL,
  `descripcion` BLOB NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NULL,
  `precioUnitario` DOUBLE NOT NULL,
  `Solicitudes_codigo` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_bienes_Solicitudes_idx` (`Solicitudes_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_bienes_Solicitudes`
    FOREIGN KEY (`Solicitudes_codigo`)
    REFERENCES `activosDB`.`Solicitudes` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `activosDB`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `activosDB`.`Usuarios` (
  `id` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

insert into usuarios values("admin_dependencia","clave_admin_dependencia",1);
insert into usuarios values("secretaria_OCCB","clave_secretaria_OCCB",2);
insert into usuarios values("jefe_OCCB","clave_jefe_OCCB",3);
insert into usuarios values("registrador","clave_registrador",4);
insert into usuarios values("jefe_RRHH","clave_jefe_RRHH",5);
insert into usuarios values("jefe_OCCB_RRHH","clave_jefe_OCCB_RRHH",7);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
