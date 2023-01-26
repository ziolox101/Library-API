-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema library_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `library_db` ;

-- -----------------------------------------------------
-- Table `library_db`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `bio` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `library_db`.`library`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`library` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `library_db`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`genre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `library_db`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number_of_rack` INT NOT NULL,
  `number_of_shelf` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `library_db`.`publisher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`publisher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `library_db`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `amount` INT NOT NULL,
  `library_id_book` INT NOT NULL,
  `author_id_book` INT NOT NULL,
  `genre_id_book` INT NOT NULL,
  `location_id_book` INT NOT NULL,
  `publisher_id_book` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `book_fk0` (`library_id_book` ASC) VISIBLE,
  INDEX `book_fk1` (`author_id_book` ASC) VISIBLE,
  INDEX `book_fk2` (`genre_id_book` ASC) VISIBLE,
  INDEX `book_fk3` (`location_id_book` ASC) VISIBLE,
  INDEX `book_fk4` (`publisher_id_book` ASC) VISIBLE,
  CONSTRAINT `book_fk0`
    FOREIGN KEY (`library_id_book`)
    REFERENCES `library_db`.`library` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `book_fk1`
    FOREIGN KEY (`author_id_book`)
    REFERENCES `library_db`.`author` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `book_fk2`
    FOREIGN KEY (`genre_id_book`)
    REFERENCES `library_db`.`genre` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `book_fk3`
    FOREIGN KEY (`location_id_book`)
    REFERENCES `library_db`.`location` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `book_fk4`
    FOREIGN KEY (`publisher_id_book`)
    REFERENCES `library_db`.`publisher` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `library_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `role` VARCHAR(10) NULL DEFAULT 'USER',
  `library_id_user` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_fk1` (`library_id_user` ASC) VISIBLE,
  CONSTRAINT `user_fk1`
    FOREIGN KEY (`library_id_user`)
    REFERENCES `library_db`.`library` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


-- -----------------------------------------------------
-- Table `library_db`.`book_lend`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`book_lend` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from_lend` DATE NOT NULL,
  `to_lend` DATE NOT NULL,
  `book_id_book_lend` INT NOT NULL,
  `user_id_book_lend` INT NOT NULL,
  `library_id_book_lend` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `book_lend_fk0` (`book_id_book_lend` ASC) VISIBLE,
  INDEX `book_lend_fk1` (`user_id_book_lend` ASC) VISIBLE,
  INDEX `book_lend_fk2` (`library_id_book_lend` ASC) VISIBLE,
  CONSTRAINT `book_lend_fk0`
    FOREIGN KEY (`book_id_book_lend`)
    REFERENCES `library_db`.`book` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `book_lend_fk1`
    FOREIGN KEY (`user_id_book_lend`)
    REFERENCES `library_db`.`user` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `book_lend_fk2`
    FOREIGN KEY (`library_id_book_lend`)
    REFERENCES `library_db`.`library` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_polish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
set character_set_client='utf8';
set character_set_connection='utf8';
set character_set_database='utf8';
set character_set_results='utf8';
set character_set_server='utf8';
show variables like 'char%';










