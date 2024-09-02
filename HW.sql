CREATE SCHEMA `animals` ;
-- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
CREATE TABLE `animals` . `creacher_type`(
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`type` VARCHAR(45) NOT NULL
);

CREATE TABLE `animals`.`pets` (
  `id` INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `type_id` INT NOT NULL,
  `birthday date` DATETIME NOT NULL,
  `commands` VARCHAR(45) NULL,
  FOREIGN KEY (type_id) REFERENCES `animals` . `creacher_type` (id)
  );

CREATE TABLE `animals`.`pack_animals` (
  `id` INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `type_id` INT NOT NULL,
  `birthday date` DATETIME NOT NULL,
  `commands` VARCHAR(45) NULL,
  FOREIGN KEY (type_id) REFERENCES `animals` . `creacher_type` (id)
  );

ALTER TABLE `pets` ADD COLUMN sex VARCHAR(50) NOT NULL AFTER name;
ALTER TABLE `pack_animals` ADD COLUMN sex VARCHAR(50) NOT NULL AFTER name;

-- Заполнить таблицы данными о животных, их командах и датами рождения.

INSERT INTO `animals`.`creacher_type` (`type`) VALUES ('кошка');
INSERT INTO `animals`.`creacher_type` (`type`) VALUES ('Собака');
INSERT INTO `animals`.`creacher_type` (`type`) VALUES ('Хомяк');
INSERT INTO `animals`.`creacher_type` (`type`) VALUES ('Лошадь');
INSERT INTO `animals`.`creacher_type` (`type`) VALUES ('Осёл');
INSERT INTO `animals`.`creacher_type` (`type`) VALUES ('Верблюд');

INSERT INTO `animals`.`pets` (`name`, `sex`, `type_id`, `birthday date`, `commands`) VALUES ('Оскар', 'М', '1', '2022-11-29', 'Есть');
INSERT INTO `animals`.`pets` (`name`, `sex`, `type_id`, `birthday date`, `commands`) VALUES ('Хальта', 'Ж','2', '2020-08-04', 'Сидеть. Лежать. Домой');
INSERT INTO `animals`.`pets` (`name`, `sex`, `type_id`, `birthday date`) VALUES ('Хома', 'М', '3', '2024-04-20');
INSERT INTO `animals`.`pets` (`name`, `sex`, `type_id`, `birthday date`, `commands`) VALUES ('Пёсель', 'М', '2', '2023-03-14', 'Место. Домой');

INSERT INTO `animals`. `pack_animals` (`name`, `sex`, `type_id`, `birthday date`, `commands`) VALUES ('Хорси', 'Ж', '4', '2019-07-10', 'Домой. Сидеть. Прыжок.');
INSERT INTO `animals`. `pack_animals` (`name`, `sex`, `type_id`, `birthday date`) VALUES ('Дони', 'М', '5', '2022-09-11');
INSERT INTO `animals`. `pack_animals` (`name`, `sex`, `type_id`, `birthday date`, `commands`) VALUES ('Самец', 'М', '6', '2015-04-24', 'Плюнь');
INSERT INTO `animals`. `pack_animals` (`name`, `sex`, `type_id`, `birthday date`) VALUES ('Элека', 'Ж', '4', '2022-012-15');

-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов. (Вопрос: Если ослы и лошади и так в одной таблице, зачем их объединять?)

DELETE FROM `animals`.`pack_animals` WHERE type_id='6';

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

CREATE TABLE `animals`.`young_animals` AS
	SELECT `pets`.`name` AS `name`, `pets`.`type_id` AS `type_id`, `pets`.`sex` AS `sex`, `pets`.`birthday date` AS `birthday date`, `pets`.`commands` AS `commands`, TIMESTAMPDIFF(YEAR,
            `pets`.`birthday date`,
            CURDATE()) AS `Year`,
        (TIMESTAMPDIFF(MONTH,
            `pets`.`birthday date`,
            CURDATE()) % 12) AS `Month` FROM `animals`.`pets`
		WHERE FLOOR(DATEDIFF(CURDATE(), `birthday date`)/365) > 0 AND  FLOOR(DATEDIFF(CURDATE(), `birthday date`)/365) < 4
	UNION ALL 
    SELECT  `pack_animals`.`name` AS `name`, `pack_animals`.`type_id` AS `type_id`, `pack_animals`.`sex` AS `sex`, `pack_animals`.`birthday date` AS `birthday_date`, `pack_animals`.`commands` AS `commands`, TIMESTAMPDIFF(YEAR,
            `pack_animals`.`birthday date`,
            CURDATE()) AS `Year`,
        (TIMESTAMPDIFF(MONTH,
            `pack_animals`.`birthday date`,
            CURDATE()) % 12) AS `Month` FROM `animals`.`pack_animals`
		WHERE FLOOR(DATEDIFF(CURDATE(), `birthday date`)/365) > 0 AND  FLOOR(DATEDIFF(CURDATE(), `birthday date`)/365) < 4
    ;



-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.
/* Не понял, что означает "сохраняя информацию о принадлежности к исходным таблицам" Поэтому:
 вариант 1 - соединяет все таблицы в одну длинную горизонтально с повторяющимися столбцами
 вариант 2 - объединяет таблицы в одну вертикаьную с "костыльными" разделениями
 */
SELECT * FROM `animals`.`creacher_type` AS ct
	LEFT JOIN `animals`.`pack_animals` AS pa ON ct.id = pa.type_id 
	LEFT JOIN `animals`.`pets` AS p ON ct.id = p.type_id
    LEFT JOIN `animals`.`young_animals` AS ya ON ct.id = ya.type_id;
    
    
    SELECT NULL, NULL, NULL, 'pack_animals', NULL
    UNION ALL SELECT 
        `pack_animals`.`name` AS `name`,
        `creacher_type`.`type` AS `type`,
		`pack_animals`.`sex`,
        `pack_animals`.`birthday date` AS `birthday date`,
        `pack_animals`.`commands` AS `commands`
    FROM
        (`pack_animals`
        JOIN `creacher_type` ON ((`pack_animals`.`type_ID` = `creacher_type`.`id`)))
        UNION SELECT NULL, NULL, NULL, 'PETS', NULL
        UNION ALL 
			SELECT
            `pets`.`name` AS `name`,
			`creacher_type`.`type` AS `type`,
            `pets`.`sex`,
			`pets`.`birthday date` AS `birthday date`,
			`pets`.`commands` AS `commands`
            FROM
            (`pets`
				JOIN `creacher_type` ON ((`pets`.`type_ID` = `creacher_type`.`id`)))
			UNION SELECT NULL, NULL, NULL, 'young_animals', NULL
		 UNION ALL 
			SELECT
            `young_animals`.`name` AS `name`,
			`creacher_type`.`type` AS `type`,
            `young_animals`.`sex`,
			`young_animals`.`birthday date` AS `birthday date`,
			`young_animals`.`commands` AS `commands`
            FROM
            (`young_animals`
				JOIN `creacher_type` ON ((`young_animals`.`type_ID` = `creacher_type`.`id`)))
        ;