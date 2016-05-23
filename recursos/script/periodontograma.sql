-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2016 a las 19:34:49
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `periodontograma`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_diente`
--

CREATE TABLE IF NOT EXISTS `detalle_diente` (
  `ID_DETALLE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DIENTE` int(11) DEFAULT NULL,
  `ID_PERIODONTOGRAMA` int(11) DEFAULT NULL,
  `MG11` int(11) DEFAULT NULL,
  `PS11` int(11) DEFAULT NULL,
  `NI11` int(11) DEFAULT NULL,
  `MG12` int(11) DEFAULT NULL,
  `PS12` int(11) DEFAULT NULL,
  `NI12` int(11) DEFAULT NULL,
  `MG21` int(11) DEFAULT NULL,
  `PS21` int(11) DEFAULT NULL,
  `NI21` int(11) DEFAULT NULL,
  `MG22` int(11) DEFAULT NULL,
  `PS22` int(11) DEFAULT NULL,
  `NI22` int(11) DEFAULT NULL,
  `MG31` int(11) DEFAULT NULL,
  `PS31` int(11) DEFAULT NULL,
  `NI31` int(11) DEFAULT NULL,
  `MG32` int(11) DEFAULT NULL,
  `PS32` int(11) DEFAULT NULL,
  `NI32` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DETALLE`),
  KEY `FK_REFERENCE_4` (`ID_DIENTE`),
  KEY `FK_REFERENCE_7` (`ID_PERIODONTOGRAMA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diagnostico`
--

CREATE TABLE IF NOT EXISTS `diagnostico` (
  `ID_TRATAMIENTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERIODONTOGRAMA` int(11) DEFAULT NULL,
  `NOTAS` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID_TRATAMIENTO`),
  KEY `FK_REFERENCE_6` (`ID_PERIODONTOGRAMA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diente`
--

CREATE TABLE IF NOT EXISTS `diente` (
  `ID_DIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(5) DEFAULT NULL,
  `ESTADO` varchar(20) DEFAULT NULL,
  `CATEGORIA` varchar(20) DEFAULT NULL,
  `posi` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_DIENTE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=67 ;

--
-- Volcado de datos para la tabla `diente`
--

INSERT INTO `diente` (`ID_DIENTE`, `CODIGO`, `ESTADO`, `CATEGORIA`, `posi`) VALUES
(3, '1,8', 'normal', 'vestibular', 'abajo'),
(4, '1,7', 'normal', 'vestibular', 'abajo'),
(5, '1,6', 'normal', 'vestibular', 'abajo'),
(6, '1,5', 'normal', 'vestibular', 'abajo'),
(7, '1,4', 'normal', 'vestibular', 'abajo'),
(8, '1,3', 'normal', 'vestibular', 'abajo'),
(9, '1,2', 'normal', 'vestibular', 'abajo'),
(10, '1,1', 'normal', 'vestibular', 'abajo'),
(11, '2,1', 'normal', 'vestibular', 'abajo'),
(12, '2,2', 'normal', 'vestibular', 'abajo'),
(13, '2,3', 'normal', 'vestibular', 'abajo'),
(14, '2,4', 'normal', 'vestibular', 'abajo'),
(15, '2,5', 'normal', 'vestibular', 'abajo'),
(16, '2,6', 'normal', 'vestibular', 'abajo'),
(17, '2,7', 'normal', 'vestibular', 'abajo'),
(18, '2,8', 'normal', 'vestibular', 'abajo'),
(19, '1,8', 'normal', 'palatino', 'arriba'),
(20, '1,7', 'normal', 'palatino', 'arriba'),
(21, '1,6', 'normal', 'palatino', 'arriba'),
(22, '1,5', 'normal', 'palatino', 'arriba'),
(23, '1,4', 'normal', 'palatino', 'arriba'),
(24, '1,3', 'normal', 'palatino', 'arriba'),
(25, '1,2', 'normal', 'palatino', 'arriba'),
(26, '1,1', 'normal', 'palatino', 'arriba'),
(27, '2,1', 'normal', 'palatino', 'arriba'),
(28, '2,2', 'normal', 'palatino', 'arriba'),
(29, '2,3', 'normal', 'palatino', 'arriba'),
(30, '2,4', 'normal', 'palatino', 'arriba'),
(31, '2,5', 'normal', 'palatino', 'arriba'),
(32, '2,6', 'normal', 'palatino', 'arriba'),
(33, '2,7', 'normal', 'palatino', 'arriba'),
(34, '2,8', 'normal', 'palatino', 'arriba'),
(35, '4,8', 'normal', 'lingual', 'abajo'),
(36, '4,7', 'normal', 'lingual', 'abajo'),
(37, '4,6', 'normal', 'lingual', 'abajo'),
(38, '4,5', 'normal', 'lingual', 'abajo'),
(39, '4,4', 'normal', 'lingual', 'abajo'),
(40, '4,3', 'normal', 'lingual', 'abajo'),
(41, '4,2', 'normal', 'lingual', 'abajo'),
(42, '4,1', 'normal', 'lingual', 'abajo'),
(43, '3,1', 'normal', 'lingual', 'abajo'),
(44, '3,2', 'normal', 'lingual', 'abajo'),
(45, '3,3', 'normal', 'lingual', 'abajo'),
(46, '3,4', 'normal', 'lingual', 'abajo'),
(47, '3,5', 'normal', 'lingual', 'abajo'),
(48, '3,6', 'normal', 'lingual', 'abajo'),
(49, '3,7', 'normal', 'lingual', 'abajo'),
(50, '3,8', 'normal', 'lingual', 'abajo'),
(51, '4,8', 'normal', 'vestibular', 'arriba'),
(52, '4,7', 'normal', 'vestibular', 'arriba'),
(53, '4,6', 'normal', 'vestibular', 'arriba'),
(54, '4,5', 'normal', 'vestibular', 'arriba'),
(55, '4,4', 'normal', 'vestibular', 'arriba'),
(56, '4,3', 'normal', 'vestibular', 'arriba'),
(57, '4,2', 'normal', 'vestibular', 'arriba'),
(58, '4,1', 'normal', 'vestibular', 'arriba'),
(59, '3,1', 'normal', 'vestibular', 'arriba'),
(60, '3,2', 'normal', 'vestibular', 'arriba'),
(61, '3,3', 'normal', 'vestibular', 'arriba'),
(62, '3,4', 'normal', 'vestibular', 'arriba'),
(63, '3,5', 'normal', 'vestibular', 'arriba'),
(64, '3,6', 'normal', 'vestibular', 'arriba'),
(65, '3,7', 'normal', 'vestibular', 'arriba'),
(66, '3,8', 'normal', 'vestibular', 'arriba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE IF NOT EXISTS `historial` (
  `ID_HISTORIAL` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PACIENTE` int(11) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_HISTORIAL`),
  KEY `FK_REFERENCE_5` (`ID_PACIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `ID_PACIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `CEDULA` varchar(15) NOT NULL,
  `NOMBRES` varchar(50) DEFAULT NULL,
  `HCL` varchar(15) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_PACIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodontograma`
--

CREATE TABLE IF NOT EXISTS `periodontograma` (
  `ID_PERIODONTOGRAMA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PACIENTE` int(11) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_PERIODONTOGRAMA`),
  KEY `FK_REFERENCE_2` (`ID_PACIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE IF NOT EXISTS `tratamiento` (
  `ID_TRATAMIENTO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PERIODONTOGRAMA` int(11) DEFAULT NULL,
  `NOTAS` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID_TRATAMIENTO`),
  KEY `FK_REFERENCE_8` (`ID_PERIODONTOGRAMA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO` varchar(25) NOT NULL,
  `CONTRASENA` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_diente`
--
ALTER TABLE `detalle_diente`
  ADD CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`ID_PERIODONTOGRAMA`) REFERENCES `periodontograma` (`ID_PERIODONTOGRAMA`),
  ADD CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`ID_DIENTE`) REFERENCES `diente` (`ID_DIENTE`);

--
-- Filtros para la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
  ADD CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`ID_PERIODONTOGRAMA`) REFERENCES `periodontograma` (`ID_PERIODONTOGRAMA`);

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`ID_PACIENTE`) REFERENCES `paciente` (`ID_PACIENTE`);

--
-- Filtros para la tabla `periodontograma`
--
ALTER TABLE `periodontograma`
  ADD CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`ID_PACIENTE`) REFERENCES `paciente` (`ID_PACIENTE`);

--
-- Filtros para la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`ID_PERIODONTOGRAMA`) REFERENCES `periodontograma` (`ID_PERIODONTOGRAMA`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
