-- phpMyAdmin SQL Dump
-- version 4.0.10.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.8.127.130:3306
-- Tiempo de generación: 07-11-2016 a las 15:25:54
-- Versión del servidor: 5.5.52
-- Versión de PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sis2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Asistencia`
--

CREATE TABLE IF NOT EXISTS `Asistencia` (
  `Fecha` date NOT NULL,
  `CIEmpleado` int(10) unsigned NOT NULL,
  `IDEstado` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Fecha`,`CIEmpleado`,`IDEstado`),
  KEY `CIEmpleado` (`CIEmpleado`),
  KEY `IDEstado` (`IDEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Asistencia`
--

INSERT INTO `Asistencia` (`Fecha`, `CIEmpleado`, `IDEstado`) VALUES
('2016-11-04', 6464, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Balance`
--

CREATE TABLE IF NOT EXISTS `Balance` (
  `nroBalance` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idDepartamento` int(10) unsigned NOT NULL,
  `ingreso` decimal(10,0) NOT NULL,
  `egreso` decimal(10,0) NOT NULL,
  `deudas` decimal(10,0) NOT NULL,
  PRIMARY KEY (`nroBalance`,`idDepartamento`),
  KEY `idDepartamento` (`idDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cargo`
--

CREATE TABLE IF NOT EXISTS `Cargo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Cargo` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `Cargo`
--

INSERT INTO `Cargo` (`ID`, `Cargo`) VALUES
(1, 'Jefe de departamento'),
(2, 'Vendedor'),
(3, 'Mecanico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Comprador`
--

CREATE TABLE IF NOT EXISTS `Comprador` (
  `ciComprador` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `calleDomicilio` varchar(50) NOT NULL,
  `nroDomicilio` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  PRIMARY KEY (`ciComprador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Comprador`
--

INSERT INTO `Comprador` (`ciComprador`, `nombre`, `apellidos`, `calleDomicilio`, `nroDomicilio`, `ciudad`) VALUES
(9395861, 'German Hugp', 'Terceros Paz Soldan', 'Inominada', 'I-11', 'Sacaba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Departamento`
--

CREATE TABLE IF NOT EXISTS `Departamento` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Departamento` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Deparatamento` (`Departamento`),
  KEY `Deparatamento_2` (`Departamento`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `Departamento`
--

INSERT INTO `Departamento` (`ID`, `Departamento`) VALUES
(1, 'taller');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetallePedido`
--

CREATE TABLE IF NOT EXISTS `DetallePedido` (
  `Pedido` int(11) NOT NULL,
  `Vehiculo` int(11) NOT NULL,
  PRIMARY KEY (`Pedido`,`Vehiculo`),
  KEY `Pedido` (`Pedido`),
  KEY `Vehiculo` (`Vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetalleVenta`
--

CREATE TABLE IF NOT EXISTS `DetalleVenta` (
  `nroDetalle` int(11) NOT NULL,
  `ciComprador` int(10) NOT NULL,
  `auto` int(11) NOT NULL,
  `tipoVenta` varchar(7) NOT NULL DEFAULT 'contado',
  PRIMARY KEY (`nroDetalle`),
  KEY `ciComprador` (`ciComprador`,`auto`),
  KEY `auto` (`auto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Empleado`
--

CREATE TABLE IF NOT EXISTS `Empleado` (
  `CIEmpleado` int(10) unsigned NOT NULL,
  `IdDepartamento` int(10) unsigned NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  PRIMARY KEY (`CIEmpleado`),
  KEY `IdDepartamento` (`IdDepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Empleado`
--

INSERT INTO `Empleado` (`CIEmpleado`, `IdDepartamento`, `Nombre`, `Apellidos`) VALUES
(6464, 1, 'jose', 'memmemem'),
(9898, 1, 'mario', 'lkaslkaslask');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `EmpleadoCargo`
--

CREATE TABLE IF NOT EXISTS `EmpleadoCargo` (
  `fecha` date NOT NULL,
  `CIEmpleado` int(10) unsigned NOT NULL,
  `IDCargo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`fecha`,`CIEmpleado`,`IDCargo`),
  KEY `CIEmpleado` (`CIEmpleado`),
  KEY `IDCargo` (`IDCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `EmpleadoCargo`
--

INSERT INTO `EmpleadoCargo` (`fecha`, `CIEmpleado`, `IDCargo`) VALUES
('2014-07-12', 6464, 2),
('2015-03-26', 9898, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `EstadoAsistencia`
--

CREATE TABLE IF NOT EXISTS `EstadoAsistencia` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Estado` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `EstadoAsistencia`
--

INSERT INTO `EstadoAsistencia` (`ID`, `Estado`) VALUES
(1, 'Ausente'),
(2, 'Permiso'),
(3, 'Retrasado'),
(4, 'Puntual');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Herramienta`
--

CREATE TABLE IF NOT EXISTS `Herramienta` (
  `idHerramienta` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`idHerramienta`),
  KEY `idHerramienta` (`idHerramienta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Herramienta_Empleado`
--

CREATE TABLE IF NOT EXISTS `Herramienta_Empleado` (
  `Herramienta` int(11) NOT NULL,
  `Empleado` int(10) unsigned NOT NULL,
  `Fecha` date NOT NULL,
  PRIMARY KEY (`Herramienta`,`Empleado`,`Fecha`),
  KEY `Herramienta` (`Herramienta`),
  KEY `Empleado` (`Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Marca`
--

CREATE TABLE IF NOT EXISTS `Marca` (
  `idMarca` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) NOT NULL,
  PRIMARY KEY (`idMarca`),
  KEY `idMarca` (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Modelo`
--

CREATE TABLE IF NOT EXISTS `Modelo` (
  `idModelo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `modelo` varchar(50) NOT NULL,
  `idMarca` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idModelo`),
  KEY `idMarca` (`idMarca`),
  KEY `idMarca_2` (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pedido`
--

CREATE TABLE IF NOT EXISTS `Pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `proveedora` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `proveedora` (`proveedora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proveedor`
--

CREATE TABLE IF NOT EXISTS `Proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TipoVehiculo`
--

CREATE TABLE IF NOT EXISTS `TipoVehiculo` (
  `idTipoVehiculo` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipoVehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Vehiculo`
--

CREATE TABLE IF NOT EXISTS `Vehiculo` (
  `nroMotor` int(11) NOT NULL,
  `modelo` int(10) unsigned NOT NULL,
  `tipo` int(11) unsigned NOT NULL,
  `chasis` varchar(50) NOT NULL,
  PRIMARY KEY (`nroMotor`),
  KEY `marca` (`modelo`),
  KEY `tipo` (`tipo`),
  KEY `modelo` (`modelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Asistencia`
--
ALTER TABLE `Asistencia`
  ADD CONSTRAINT `Asistencia_ibfk_1` FOREIGN KEY (`CIEmpleado`) REFERENCES `Empleado` (`CIEmpleado`),
  ADD CONSTRAINT `Asistencia_ibfk_2` FOREIGN KEY (`IDEstado`) REFERENCES `EstadoAsistencia` (`ID`);

--
-- Filtros para la tabla `Balance`
--
ALTER TABLE `Balance`
  ADD CONSTRAINT `Balance_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `Departamento` (`ID`);

--
-- Filtros para la tabla `DetallePedido`
--
ALTER TABLE `DetallePedido`
  ADD CONSTRAINT `DetallePedido_ibfk_2` FOREIGN KEY (`Vehiculo`) REFERENCES `Vehiculo` (`nroMotor`),
  ADD CONSTRAINT `DetallePedido_ibfk_1` FOREIGN KEY (`Pedido`) REFERENCES `Pedido` (`idPedido`);

--
-- Filtros para la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  ADD CONSTRAINT `DetalleVenta_ibfk_2` FOREIGN KEY (`auto`) REFERENCES `Vehiculo` (`nroMotor`),
  ADD CONSTRAINT `DetalleVenta_ibfk_1` FOREIGN KEY (`ciComprador`) REFERENCES `Comprador` (`ciComprador`);

--
-- Filtros para la tabla `Empleado`
--
ALTER TABLE `Empleado`
  ADD CONSTRAINT `Empleado_ibfk_1` FOREIGN KEY (`IdDepartamento`) REFERENCES `Departamento` (`ID`);

--
-- Filtros para la tabla `EmpleadoCargo`
--
ALTER TABLE `EmpleadoCargo`
  ADD CONSTRAINT `EmpleadoCargo_ibfk_2` FOREIGN KEY (`IDCargo`) REFERENCES `Cargo` (`ID`),
  ADD CONSTRAINT `EmpleadoCargo_ibfk_1` FOREIGN KEY (`CIEmpleado`) REFERENCES `Empleado` (`CIEmpleado`);

--
-- Filtros para la tabla `Herramienta_Empleado`
--
ALTER TABLE `Herramienta_Empleado`
  ADD CONSTRAINT `Herramienta_Empleado_ibfk_2` FOREIGN KEY (`Empleado`) REFERENCES `Empleado` (`CIEmpleado`),
  ADD CONSTRAINT `Herramienta_Empleado_ibfk_1` FOREIGN KEY (`Herramienta`) REFERENCES `Herramienta` (`idHerramienta`);

--
-- Filtros para la tabla `Modelo`
--
ALTER TABLE `Modelo`
  ADD CONSTRAINT `Modelo_ibfk_1` FOREIGN KEY (`idMarca`) REFERENCES `Marca` (`idMarca`);

--
-- Filtros para la tabla `Pedido`
--
ALTER TABLE `Pedido`
  ADD CONSTRAINT `Pedido_ibfk_1` FOREIGN KEY (`proveedora`) REFERENCES `Proveedor` (`idProveedor`);

--
-- Filtros para la tabla `Vehiculo`
--
ALTER TABLE `Vehiculo`
  ADD CONSTRAINT `Vehiculo_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `TipoVehiculo` (`idTipoVehiculo`),
  ADD CONSTRAINT `Vehiculo_ibfk_1` FOREIGN KEY (`modelo`) REFERENCES `Modelo` (`idModelo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
