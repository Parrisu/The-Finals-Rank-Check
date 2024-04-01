-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema finalsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `finalsdb` ;

-- -----------------------------------------------------
-- Schema finalsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finalsdb` DEFAULT CHARACTER SET utf8 ;
USE `finalsdb` ;

-- -----------------------------------------------------
-- Table `contestant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `contestant` ;

CREATE TABLE IF NOT EXISTS `contestant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `rank` INT NULL,
  `changes` INT NULL,
  `league` VARCHAR(45) NULL,
  `league_number` INT NULL,
  `cashouts` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rank_changes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rank_changes` ;

CREATE TABLE IF NOT EXISTS `rank_changes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rank` INT NULL,
  `change` INT NULL,
  `date_changed` DATETIME NULL,
  `contestant_id` INT NOT NULL,
  PRIMARY KEY (`id`, `contestant_id`),
  INDEX `fk_rank_changes_contestant_idx` (`contestant_id` ASC),
  CONSTRAINT `fk_rank_changes_contestant`
    FOREIGN KEY (`contestant_id`)
    REFERENCES `contestant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS contestant@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'contestant'@'localhost' IDENTIFIED BY 'finals';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'contestant'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
