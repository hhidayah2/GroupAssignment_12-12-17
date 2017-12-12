create schema bookshop;
Use bookshop;

DROP TABLE IF EXISTS CatalogItem;
CREATE TABLE CatalogItem (
  itemID varchar(30) NOT NULL ,
  shortDescription varchar(50) NOT NULL,
  longDescription varchar(500) NOT NULL,
  cost float(7,4) NOT NULL,
  PRIMARY KEY (itemID)
) ;

DROP TABLE IF EXISTS ItemOrder;
CREATE TABLE ItemOrder (
  numItems int(10) NOT NULL,
  itemID varchar(30),
  PRIMARY KEY (numItems),
  Foreign key (itemID) References CatalogItem(itemID) 
) 