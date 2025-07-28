-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         10.4.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla tododb.todos
CREATE TABLE IF NOT EXISTS `todos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `completed` bit(1) NOT NULL,
  `title` varchar(200) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9605g76a1dggbvs18f2r80gvu` (`user_id`),
  CONSTRAINT `FK9605g76a1dggbvs18f2r80gvu` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla tododb.todos: ~3 rows (aproximadamente)
INSERT INTO `todos` (`id`, `completed`, `title`, `user_id`) VALUES
	(20, b'1', 'pasear al perro', 2);
INSERT INTO `todos` (`id`, `completed`, `title`, `user_id`) VALUES
	(21, b'1', 'aprender spring básico', 2);
INSERT INTO `todos` (`id`, `completed`, `title`, `user_id`) VALUES
	(22, b'0', 'encontrar curro', 2);
INSERT INTO `todos` (`id`, `completed`, `title`, `user_id`) VALUES
	(42, b'1', 'Todo prueba 1', 1);

-- Volcando estructura para tabla tododb.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla tododb.users: ~2 rows (aproximadamente)
INSERT INTO `users` (`id`, `city`, `country`, `street`, `zipcode`, `name`, `password`, `username`) VALUES
	(1, 'bcn', 'spain', 'laforja', '08021', 'UserTest1', 'fer', 'UserTest1');
INSERT INTO `users` (`id`, `city`, `country`, `street`, `zipcode`, `name`, `password`, `username`) VALUES
	(2, 'bcn', 'spain', 'laforja', '08021', 'Fer', 'fer', 'Fer');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
