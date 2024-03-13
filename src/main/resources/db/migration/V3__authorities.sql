CREATE TABLE `authorities` (
`id` SERIAL NOT NULL COMMENT 'ID',
`username` varchar(255) NOT NULL,
`authority` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;