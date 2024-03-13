CREATE TABLE ` productlist` (
	`id` SERIAL NOT NULL COMMENT 'ID',
	`name` VARCHAR(64) NOT NULL,
	`number` INT(16) NOT NULL,
	`price` INT(16) NOT NULL,
	`stock` INT(4),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;