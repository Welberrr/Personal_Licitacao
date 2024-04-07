-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`secretario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`secretario` (
  `idsecretario` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `loginSec` VARCHAR(45) NOT NULL,
  `senhaSec` INT NOT NULL,
  PRIMARY KEY (`idsecretario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`empresa` (
  `idEmpr` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `CNPJ` INT NOT NULL,
  `NomePJ` INT NOT NULL,
  `secretario_idsecretario` INT NOT NULL,
  PRIMARY KEY (`idEmpr`, `secretario_idsecretario`),
  INDEX `fk_empresa_secretario1_idx` (`secretario_idsecretario` ASC) VISIBLE,
  CONSTRAINT `fk_empresa_secretario1`
    FOREIGN KEY (`secretario_idsecretario`)
    REFERENCES `mydb`.`secretario` (`idsecretario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`acervo Tecnico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`acervo Tecnico` (
  `acervo1` VARCHAR(50) NULL,
  `acervo2` VARCHAR(50) NULL,
  `acervo3` VARCHAR(50) NULL,
  `empresa_idempresa` INT NOT NULL,
  PRIMARY KEY (`empresa_idempresa`),
  CONSTRAINT `fk_acervo Tecnico_empresa`
    FOREIGN KEY (`empresa_idempresa`)
    REFERENCES `mydb`.`empresa` (`idEmpr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
