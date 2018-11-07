-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.31-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5284
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para medibot_bd
CREATE DATABASE IF NOT EXISTS `medibot_bd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `medibot_bd`;

-- Volcando estructura para tabla medibot_bd.enfermedades
CREATE TABLE IF NOT EXISTS `enfermedades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `enf_img` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla medibot_bd.hospital
CREATE TABLE IF NOT EXISTS `hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `c_distrito` varchar(250) DEFAULT NULL,
  `hosp_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hospital_distrito` (`c_distrito`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla medibot_bd.h_medico
CREATE TABLE IF NOT EXISTS `h_medico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_usuario` int(11) NOT NULL DEFAULT '0',
  `fecha` date DEFAULT NULL,
  `c_enfermedad` int(11) DEFAULT NULL,
  `c_hospital` int(11) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h_medico_usuarios` (`c_usuario`),
  KEY `FK_h_medico_hospital` (`c_hospital`),
  KEY `FK_h_medico_enfermedades2` (`c_enfermedad`),
  CONSTRAINT `FK_h_medico_enfermedades2` FOREIGN KEY (`c_enfermedad`) REFERENCES `enfermedades` (`id`),
  CONSTRAINT `FK_h_medico_hospital` FOREIGN KEY (`c_hospital`) REFERENCES `hospital` (`id`),
  CONSTRAINT `FK_h_medico_usuarios` FOREIGN KEY (`c_usuario`) REFERENCES `usuarios` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla medibot_bd.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  `correo` varchar(200) NOT NULL DEFAULT '0',
  `telefono` int(9) NOT NULL DEFAULT '0',
  `usu_img` varchar(250) NOT NULL DEFAULT '0',
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
