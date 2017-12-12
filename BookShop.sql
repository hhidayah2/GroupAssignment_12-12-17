drop schema if exists bookshop;
create schema bookshop;
Use bookshop;

DROP TABLE IF EXISTS CatalogItem;
CREATE TABLE CatalogItem (
  itemID varchar(30) NOT NULL ,
  shortDescription varchar(200) NOT NULL,
  longDescription varchar(500) NOT NULL,
  cost float(7,4) NOT NULL,
  PRIMARY KEY (itemID)
) ;

DROP TABLE IF EXISTS ItemOrder;
CREATE TABLE ItemOrder (
  numItems int(10) NOT NULL,
  itemID varchar(30),
  Foreign key (itemID) References CatalogItem(itemID) 
);

INSERT INTO `bookshop`.`catalogitem` (`itemID`, `shortDescription`, `longDescription`, `cost`) VALUES ('hall001', 'Core Servlet and JavaServer Pages 2nd Edition (Volumes 1) by Martin Hall', 'The definitive reference on servlets and JSP from Prentice Hall and Sun Microsystems Press.', '39.95');
INSERT INTO `bookshop`.`catalogitem` (`itemID`, `shortDescription`, `longDescription`, `cost`) VALUES ('hall002', 'Core Web Programming, 2nd Edition by Marty Hall and Larry Brown', 'One stop shopping for the Web programmer. Topics include', '49.99');
INSERT INTO `bookshop`.`catalogitem` (`itemID`, `shortDescription`, `longDescription`, `cost`) VALUES ('lewis001', 'The Chronicles of Narnia by C.S. Lewis', 'The classic children\'s adventure pitting Aslan the Great Lion and his followers against the White Witch and the forces of evil. Dragons, magicians, quests, and talking animals wound around a deep spiritual allegory. Series includes The Magician\'s Nephew, The Lion, the Witch and the Wardrobe, The Horse and His Boy, Prince Caspian, The Voyage of the Dawn Treader, The Silver Chair, and The Last Battle. ', '19.95');
INSERT INTO `bookshop`.`catalogitem` (`itemID`, `shortDescription`, `longDescription`, `cost`) VALUES ('alexander001', 'The Prydain Series by Lloyd Alexander', 'Humble pig-keeper Taran joins mighty Lord Gwydion in his battle against Arawn the Lord of Annuvin. Joined by his loyal friends the beautiful princess Eilonwy, wannabe bard Fflewddur Fflam,and furry half-man Gurgi, Taran discovers courage, nobility, and other values along the way. Series includes The Book of Three, The Black Cauldron, The Castle of Llyr, Taran Wanderer, and The High King.', '19.95');
INSERT INTO `bookshop`.`catalogitem` (`itemID`, `shortDescription`, `longDescription`, `cost`) VALUES ('rowling001', 'The Harry Potter Series by J.K. Rowling', 'The first five of the popular stories about wizard-in-training Harry Potter topped both the adult and children\'s best-seller lists. Series includes Harry Potter and the Sorcerer\'s Stone, Harry Potter and the Chamber of Secrets, Harry Potter and the Prisoner of Azkaban, Harry Potter and the Goblet of Fire, and Harry Potter and the Order of the Phoenix. ', '59.95');

INSERT INTO `bookshop`.`itemorder` (`numItems`, `itemID`) VALUES ('1', 'rowling001');
INSERT INTO `bookshop`.`itemorder` (`numItems`, `itemID`) VALUES ('3', 'alexander001');
INSERT INTO `bookshop`.`itemorder` (`numItems`, `itemID`) VALUES ('4', 'lewis001');
INSERT INTO `bookshop`.`itemorder` (`numItems`, `itemID`) VALUES ('2', 'hall002');
INSERT INTO `bookshop`.`itemorder` (`numItems`, `itemID`) VALUES ('1', 'hall001');
