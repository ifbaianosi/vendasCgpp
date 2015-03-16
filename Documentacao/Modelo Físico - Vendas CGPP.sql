-- MySQL Script generated by MySQL Workbench
-- 03/16/15 17:27:54
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vendasCgpp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vendasCgpp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `vendasCgpp` ;

-- -----------------------------------------------------
-- Table `vendasCgpp`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`usuario` (
  `idusuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `login` VARCHAR(12) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `status` TINYINT NULL,
  `ultimoAcesso` DATETIME NULL,
  `tentativasErro` SMALLINT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`operador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`operador` (
  `idoperador` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(12) NOT NULL,
  `usuario_idusuario` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idoperador`),
  INDEX `fk_operador_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_operador_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `vendasCgpp`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`administrador` (
  `idadministrador` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `siape` VARCHAR(7) NOT NULL,
  `cargo` VARCHAR(50) NULL,
  `funcao` VARCHAR(50) NULL,
  `usuario_idusuario` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idadministrador`),
  INDEX `fk_administrador_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_administrador_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `vendasCgpp`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`coordenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`coordenador` (
  `idcoordenador` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `siape` VARCHAR(7) NOT NULL,
  `cargo` VARCHAR(50) NULL,
  `funcao` VARCHAR(50) NULL,
  `usuario_idusuario` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idcoordenador`),
  INDEX `fk_coordenador_usuario_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_coordenador_usuario`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `vendasCgpp`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`categoria` (
  `idcategoria` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(250) NULL,
  PRIMARY KEY (`idcategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`produto` (
  `idproduto` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(250) NULL,
  `unidade` CHAR(20) NULL,
  `preco` DOUBLE NOT NULL,
  `estoque` INT NOT NULL,
  `estoqueMinimo` INT NULL,
  `categoria_idcategoria` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idproduto`),
  INDEX `fk_produto_categoria1_idx` (`categoria_idcategoria` ASC),
  CONSTRAINT `fk_produto_categoria1`
    FOREIGN KEY (`categoria_idcategoria`)
    REFERENCES `vendasCgpp`.`categoria` (`idcategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`cliente` (
  `idcliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`venda` (
  `idvenda` INT NOT NULL,
  `data` DATETIME NULL,
  `desconto` DOUBLE NULL,
  `valorTotal` DOUBLE NULL,
  `cliente_idcliente` INT UNSIGNED NULL,
  `usuario_idusuario` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idvenda`),
  INDEX `fk_venda_cliente1_idx` (`cliente_idcliente` ASC),
  INDEX `fk_venda_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `vendasCgpp`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `vendasCgpp`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`item` (
  `iditem` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `preco` DOUBLE NOT NULL,
  `produto_idproduto` INT UNSIGNED NOT NULL,
  `venda_idvenda` INT NOT NULL,
  PRIMARY KEY (`iditem`),
  INDEX `fk_item_produto1_idx` (`produto_idproduto` ASC),
  INDEX `fk_item_venda1_idx` (`venda_idvenda` ASC),
  CONSTRAINT `fk_item_produto1`
    FOREIGN KEY (`produto_idproduto`)
    REFERENCES `vendasCgpp`.`produto` (`idproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_venda1`
    FOREIGN KEY (`venda_idvenda`)
    REFERENCES `vendasCgpp`.`venda` (`idvenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`logPreco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`logPreco` (
  `idlogPreco` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `preco` DOUBLE NOT NULL,
  `dataAtualizacao` DATETIME NOT NULL,
  `produto_idproduto` INT UNSIGNED NOT NULL,
  `usuario_idusuario` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idlogPreco`),
  INDEX `fk_logPreco_produto1_idx` (`produto_idproduto` ASC),
  INDEX `fk_logPreco_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_logPreco_produto1`
    FOREIGN KEY (`produto_idproduto`)
    REFERENCES `vendasCgpp`.`produto` (`idproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_logPreco_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `vendasCgpp`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendasCgpp`.`logEstoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendasCgpp`.`logEstoque` (
  `idlogEstoque` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `estoque` INT NOT NULL,
  `estoqueMinimo` INT NULL,
  `dataAtualizacao` DATETIME NOT NULL,
  `produto_idproduto` INT UNSIGNED NOT NULL,
  `usuario_idusuario` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idlogEstoque`),
  INDEX `fk_logEstoque_produto1_idx` (`produto_idproduto` ASC),
  INDEX `fk_logEstoque_usuario1_idx` (`usuario_idusuario` ASC),
  CONSTRAINT `fk_logEstoque_produto1`
    FOREIGN KEY (`produto_idproduto`)
    REFERENCES `vendasCgpp`.`produto` (`idproduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_logEstoque_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `vendasCgpp`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
