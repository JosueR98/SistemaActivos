-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SistemaActivos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SistemaActivos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SistemaActivos` DEFAULT CHARACTER SET utf8 ;
USE `SistemaActivos` ;

-- -----------------------------------------------------
-- Table `SistemaActivos`.`Bienes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaActivos`.`Bienes` (
  `codigo_bien` INT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `precio` INT UNSIGNED NOT NULL,
  `descripcion` VARCHAR(240) NULL,
  PRIMARY KEY (`codigo_bien`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo_bien` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaActivos`.`Comprobante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaActivos`.`Comprobante` (
  `codigo_comprobante` INT NOT NULL,
  `fecha_adquisicion` DATE NOT NULL,
  `cantidad_bienes` INT UNSIGNED NOT NULL,
  `monto_total` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_comprobante`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo_comprobante` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SistemaActivos`.`Solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaActivos`.`Solicitud` (
  `codigo_solicitud` INT NOT NULL,
  `estado` TINYINT NOT NULL,
  `fecha` DATE NOT NULL,
  `Comprobante_codigo_comprobante` INT NOT NULL,
  PRIMARY KEY (`codigo_solicitud`, `Comprobante_codigo_comprobante`),
  UNIQUE INDEX `codigo_solicitud_UNIQUE` (`codigo_solicitud` ASC) VISIBLE,
  INDEX `fk_Solicitud_Comprobante1_idx` (`Comprobante_codigo_comprobante` ASC) VISIBLE,
  CONSTRAINT `fk_Solicitud_Comprobante1`
    FOREIGN KEY (`Comprobante_codigo_comprobante`)
    REFERENCES `SistemaActivos`.`Comprobante` (`codigo_comprobante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
