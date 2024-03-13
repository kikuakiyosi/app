CREATE TABLE `users` (
`id` SERIAL NOT NULL COMMENT 'ID',
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;