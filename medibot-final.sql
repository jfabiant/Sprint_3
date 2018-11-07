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


-- Volcando estructura de base de datos para medi_bot
CREATE DATABASE IF NOT EXISTS `medi_bot` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `medi_bot`;

-- Volcando estructura para tabla medi_bot.enfermedades
CREATE TABLE IF NOT EXISTS `enfermedades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `enf_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla medi_bot.enfermedades: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `enfermedades` DISABLE KEYS */;
REPLACE INTO `enfermedades` (`id`, `nombre`, `descripcion`, `enf_img`) VALUES
	(1, 'Eczema', 'Inflamacion a la piel', NULL),
	(2, 'Acne', 'Irritacion en el rostro', NULL),
	(3, 'Psoriasis', 'Hongos en la piel', NULL),
	(4, 'Alopecia', 'Hongos en el cuero cabelludo', NULL),
	(5, 'Urticaria', 'Afeccion de la piel', NULL);
/*!40000 ALTER TABLE `enfermedades` ENABLE KEYS */;

-- Volcando estructura para tabla medi_bot.hospital
CREATE TABLE IF NOT EXISTS `hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `c_distrito` varchar(250) DEFAULT NULL,
  `hosp_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_hospital_distrito` (`c_distrito`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla medi_bot.hospital: ~32 rows (aproximadamente)
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
REPLACE INTO `hospital` (`id`, `nombre`, `c_distrito`, `hosp_img`) VALUES
	(1, 'INSTITUTO NACIONAL DE REHABILITACION \'DRA. ADRIANA REBAZA FLORES\' AMISTAD PERU - JAPON', 'CHORRILLOS', NULL),
	(2, 'HOSPITAL NACIONAL CAYETANO HEREDIA', 'SAN MARTIN DE PORRES', NULL),
	(3, ' HOSPITAL SAN JUAN DE LURIGANCHO', 'SAN JUAN DE LURIGANCHO', NULL),
	(4, ' INSTITUTO NACIONAL DE SALUD DEL NIÑO-SAN BORJA', 'SAN BORJA', NULL),
	(5, ' INSTITUTO NACIONAL MATERNO PERINATAL', 'LIMA', NULL),
	(6, ' HOSPITAL DE APOYO SANTA ROSA', 'PUEBLO LIBRE', NULL),
	(7, ' CENTRO DE SALUD EL EL PORVENIR', 'LA VICTORIA', NULL),
	(8, ' CENTRO MATERNO INFANTIL DE SALUD - \'VIRGEN DEL CARMEN\'', 'CHORRILLOS', NULL),
	(9, ' HOSPITAL CARLOS LANFRANCO LA HOZ', 'PUENTE PIEDRA', NULL),
	(10, ' HOSPITAL NACIONAL HIPOLITO UNANUE', 'EL AGUSTINO', NULL),
	(11, ' CHOSICA HOSPITAL AGURTO TELLO CHOSICA', 'LURIGANCHO', NULL),
	(12, ' HOSPITAL LOCAL VITARTE', 'ATE', NULL),
	(13, ' HOSPITAL LOCAL DE HUAYCAN', 'ATE', NULL),
	(14, ' HOSPITAL NACIONAL DOS DE MAYO', 'CERCADO DE LIMA', NULL),
	(15, ' HOSPITAL NACIONAL ARZOBISPO LOAYZA', 'CERCADO DE LIMA', NULL),
	(16, 'HOSPITAL MARIA AUXILIADORA', 'SAN JUAN DE MIRAFLORES', NULL),
	(17, 'CENTRO MATERNO INFANTIL-SUREÑOS', 'PUENTE PIEDRA', NULL),
	(18, 'CENTRO MATERNO INFANTIL-SANTA ROSA', 'ANCON', NULL),
	(19, 'CENTRO DE SALUD-MENTAL-COMUNITARIO \'RENATO CASTRO DE LA MATA CAMPAÑA\'', 'PUENTE PIEDRA', NULL),
	(20, 'CENTRO DE SALUD-VILLA ESTELA', 'ANCON', NULL),
	(21, 'CENTRO MATERNO INFANTIL-SURQUILLO', 'SURQUILLO', NULL),
	(22, ' CENTRO DE SALUD-PROGRESO', 'CARABAYLLO', NULL),
	(23, 'CENTRO DE SALUD-TAHUANTIINSUYO BAJO', 'INDEPENDENCIA', NULL),
	(24, ' CENTRO MATERNO INFANTIL-MANUEL BARRETO', 'SAN JUAN DE MIRAFLORES', NULL),
	(25, 'CENTRO MATERNO INFANTIL-SANTA LUZMILA II', 'COMAS', NULL),
	(26, ' CENTRO DE SALUD-MAGDALENA', 'MAGDALENA DEL MAR', NULL),
	(27, ' CENTRO MATERNO INFANTIL-JUAN PABLO II', 'VILLA EL SALVADOR', NULL),
	(28, 'CENTRO MATERNO INFANTIL-DANIEL ALCIDES CARRION', 'VILLA MARIA DEL TRIUNFO', NULL),
	(29, ' CENTRO DE SALUD-PIEDRA LIZA', 'SAN JUAN DE LURIGANCHO', NULL),
	(30, 'CENTRO MATERNO INFANTIL-RIMAC', 'RIMAC', NULL),
	(31, ' CENTRO DE SALUD-PORTADA DE MANCHAY', 'CIENEGUILLA', NULL),
	(32, 'CENTRO MATERNO INFANTIL', 'ANCON', NULL);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;

-- Volcando estructura para tabla medi_bot.h_medico
CREATE TABLE IF NOT EXISTS `h_medico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_usuario` int(11) NOT NULL DEFAULT '0',
  `fecha` date DEFAULT NULL,
  `c_enfermedad` int(11) DEFAULT NULL,
  `c_hospital` int(11) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h_medico_usuarios` (`c_usuario`),
  KEY `FK_h_medico_enfermedades` (`c_enfermedad`),
  KEY `FK_h_medico_hospital` (`c_hospital`),
  CONSTRAINT `FK_h_medico_enfermedades` FOREIGN KEY (`c_enfermedad`) REFERENCES `enfermedades` (`id`),
  CONSTRAINT `FK_h_medico_usuarios` FOREIGN KEY (`c_usuario`) REFERENCES `usuarios` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla medi_bot.h_medico: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `h_medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `h_medico` ENABLE KEYS */;

-- Volcando estructura para tabla medi_bot.usuarios
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

-- Volcando datos para la tabla medi_bot.usuarios: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
REPLACE INTO `usuarios` (`Id`, `nombre`, `correo`, `telefono`, `usu_img`, `password`) VALUES
	(1, 'Baldeon', 'junior@gmail.com', 949087275, '0', NULL),
	(2, 'Aguilar', 'aguilar@gmail.com', 865677323, '0', NULL),
	(5, 'John Fabian', 'john.fabian@tecsup.edu.pe', 932323244, '0', NULL),
	(8, 'Cafu', 'junior968711@gmail.com', 949087275, '0', NULL),
	(10, 'Gomez', 'jaime@gmail.com', 9123123, '0', NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
