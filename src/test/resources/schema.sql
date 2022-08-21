DROP ALL OBJECTS;

CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT, -- `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
); -- DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
