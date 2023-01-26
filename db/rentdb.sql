-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema rentdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rentdb` ;

-- -----------------------------------------------------
-- Schema rentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rentdb` DEFAULT CHARACTER SET utf8 ;
USE `rentdb` ;

-- -----------------------------------------------------
-- Table `rentdb`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentdb`.`role` ;

CREATE TABLE IF NOT EXISTS `rentdb`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `created_date` DATETIME NULL,
  `modified_date` DATETIME NULL,
  `deleted` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentdb`.`user_tbl`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentdb`.`user_tbl` ;

CREATE TABLE IF NOT EXISTS `rentdb`.`user_tbl` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `created_date` DATETIME NULL,
  `modified_date` DATETIME NULL,
  `user_tblcol` VARCHAR(45) NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_user_tbl_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_tbl_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `rentdb`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentdb`.`property_category_tbl`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentdb`.`property_category_tbl` ;

CREATE TABLE IF NOT EXISTS `rentdb`.`property_category_tbl` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `deleted` TINYINT NULL,
  `created_date` DATETIME NULL,
  `modified_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentdb`.`property_tbl`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentdb`.`property_tbl` ;

CREATE TABLE IF NOT EXISTS `rentdb`.`property_tbl` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `property_addres` VARCHAR(255) NOT NULL,
  `property_description` VARCHAR(100) NOT NULL,
  `property_lease_type` VARCHAR(45) NULL,
  `price` FLOAT NULL,
  `deleted` TINYINT NULL,
  `created_date` DATETIME NULL,
  `modified` DATETIME NULL,
  `available` TINYINT NULL,
  `category_id` INT NOT NULL,
  `owner_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_property_tbl_property_category_tbl1_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_property_tbl_user_tbl1_idx` (`owner_id` ASC) VISIBLE,
  CONSTRAINT `fk_property_tbl_property_category_tbl1`
    FOREIGN KEY (`category_id`)
    REFERENCES `rentdb`.`property_category_tbl` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_property_tbl_user_tbl1`
    FOREIGN KEY (`owner_id`)
    REFERENCES `rentdb`.`user_tbl` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentdb`.`property_images`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentdb`.`property_images` ;

CREATE TABLE IF NOT EXISTS `rentdb`.`property_images` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `property_images` VARCHAR(255) NULL,
  `created_date` DATETIME NULL,
  `modified_date` DATETIME NULL,
  `property_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_property_images_property_tbl1_idx` (`property_id` ASC) VISIBLE,
  CONSTRAINT `fk_property_images_property_tbl1`
    FOREIGN KEY (`property_id`)
    REFERENCES `rentdb`.`property_tbl` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rentdb`.`property_booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentdb`.`property_booking` ;

CREATE TABLE IF NOT EXISTS `rentdb`.`property_booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `property_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `created_date` DATETIME NULL,
  `modified_date` DATETIME NULL,
  `deleted` TINYINT NULL,
  `booking_duration_months` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_property_booking_property_tbl1_idx` (`property_id` ASC) VISIBLE,
  INDEX `fk_property_booking_user_tbl1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_property_booking_property_tbl1`
    FOREIGN KEY (`property_id`)
    REFERENCES `rentdb`.`property_tbl` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_property_booking_user_tbl1`
    FOREIGN KEY (`user_id`)
    REFERENCES `rentdb`.`user_tbl` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
