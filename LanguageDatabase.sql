CREATE DATABASE `LanguageDatabase` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `clause` (
  `title` mediumtext NOT NULL,
  `keyword` varchar(45) NOT NULL,
  `description` mediumtext,
  `text` longtext,
  PRIMARY KEY (`keyword`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `clause` (`title`,`keyword`,`description`,`text`) VALUES ('title1 title1 title1 title1 title1','keyword1','description1 description1description1 description1 description1 description1','text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1 text1');
INSERT INTO `clause` (`title`,`keyword`,`description`,`text`) VALUES ('title2 title2 title2 title2 title2','keyword2','description2 description2 description2 description2 description2 description2','text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2 text2');
INSERT INTO `clause` (`title`,`keyword`,`description`,`text`) VALUES ('title3 title3 title3 title3 title3','keyword3','description3 description3 description3 description3 description3 description3 description3 description3 description3 description3 description3 description3','text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3 text3');
