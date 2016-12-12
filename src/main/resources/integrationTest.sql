CREATE TABLE if not exists `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
)AUTO_INCREMENT=2;

insert into employee(first_name, last_name, description) values('abc', 'def', 'jhshgd');
