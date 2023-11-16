-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-11-2023 a las 22:49:44
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_examen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `properties`
--

CREATE TABLE `properties` (
  `id` smallint(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `direction` varchar(200) NOT NULL,
  `characteristics` varchar(200) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `priceRent` decimal(6,2) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `properties`
--

INSERT INTO `properties` (`id`, `name`, `direction`, `characteristics`, `state`, `priceRent`, `created_at`, `updated_at`) VALUES
(1, 'ddsa', 'adsdsadsa', 'dsadsa', 'dsa', 312.00, '2023-11-16 19:17:16', '2023-11-16 19:17:16'),
(3, 'FVCV', 'BCBDGF', 'GFDGFDGFD', 'GFDGFDGFDGFD', 3.00, '2023-11-16 20:47:27', '2023-11-16 20:47:27'),
(4, 'VBBVC', 'BVCVBC', 'BVCVCB', 'GFDGFDGFDGFD', 43.00, '2023-11-16 20:47:39', '2023-11-16 21:45:54'),
(6, 'GDF', 'GDF', 'DFG', 'GFHV', 4.47, '2023-11-16 20:48:50', '2023-11-16 20:48:50'),
(7, '312', '321', '321', '312', 32.15, '2023-11-16 20:56:06', '2023-11-16 20:56:06'),
(8, 'fsd', 'df', 'sfd', 'sfd', 321.30, '2023-11-16 20:58:27', '2023-11-16 21:46:33'),
(9, 'fe', 'dsffds', 'fdsfdsdsf', 'dfsdsf', 231.00, '2023-11-16 20:58:44', '2023-11-16 20:58:44'),
(10, 'rg', 'gr', 'geg', 'gergre', 12.77, '2023-11-16 21:47:26', '2023-11-16 21:47:26');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `properties`
--
ALTER TABLE `properties`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD UNIQUE KEY `direction` (`direction`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `properties`
--
ALTER TABLE `properties`
  MODIFY `id` smallint(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
