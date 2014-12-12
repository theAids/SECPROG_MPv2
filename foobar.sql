CREATE DATABASE IF NOT EXISTS foobar;

CREATE TABLE IF NOT EXISTS foobar.foo_user(
	userID int NOT NULL UNIQUE AUTO_INCREMENT,
	username varchar(50) NOT NULL UNIQUE,
    fname varchar(50) NOT NULL,
    minitial varchar(50) NOT NULL,
    lname varchar(50) NOT NULL,
    pword varchar(50) NOT NULL,
    email varchar(255) NOT NULL,
    ustatus int NOT NULL,
    userType varchar(50) NOT NULL,
    billingAddress varchar(255),
    deliveryAddress varchar(255),
    date_created timestamp NOT NULL,
    PRIMARY KEY(userID)
);

CREATE TABLE IF NOT EXISTS foobar.product(
	productID INT NOT NULL UNIQUE AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    summary varchar(255) NOT NULL,
    price FLOAT NOT NULL,
    stock FLOAT NOT NULL,
    pstatus INT NOT NULL,
    PRIMARY KEY (productID)
);

CREATE TABLE IF NOT EXISTS foobar.book(
	productID INT NOT NULL,
    author varchar(255) NOT NULL,
    PRIMARY KEY (productID),
    FOREIGN KEY (productID) REFERENCES foobar.product(productID)
);

CREATE TABLE IF NOT EXISTS foobar.cd(
	productID INT NOT NULL,
    artist varchar(255) NOT NULL,
    PRIMARY KEY (productID),
    FOREIGN KEY (productID) REFERENCES foobar.product(productID)
);

CREATE TABLE IF NOT EXISTS foobar.dvd(
	productID INT NOT NULL,
    director varchar(255) NOT NULL,
    PRIMARY KEY (productID),
    FOREIGN KEY (productID) REFERENCES foobar.product(productID)
);

CREATE TABLE IF NOT EXISTS foobar.mag(
	productID INT NOT NULL,
    volNo INT NOT NULL,
    issueNo INT NOT NULL,
    PRIMARY KEY (productID),
    FOREIGN KEY (productID) REFERENCES foobar.product(productID)
);

CREATE TABLE IF NOT EXISTS foobar.review(
	reviewID int UNIQUE auto_increment NOT NULL,
    review varchar(500) NOT NULL,
    reviewDate timestamp NOT NULL,
    userID int NOT NULL,
    productID int NOT NULL,
    PRIMARY KEY(reviewID),
    FOREIGN KEY (userID) REFERENCES foobar.foo_user(userID) ON DELETE CASCADE,
    FOREIGN KEY (productID) REFERENCES foobar.product(productID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS foobar.foo_order(
	orderID INT UNIQUE  NOT NULL AUTO_INCREMENT,
    orderDate timestamp NOT NULL,
    userID INT NOT NULL,
    PRIMARY KEY (orderID),
    FOREIGN KEY (userID) REFERENCES foobar.foo_user(userID)
);

CREATE TABLE IF NOT EXISTS foobar.ordering(
	orderID INT NOT NULL,
    productID INT NOT NULL,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (orderID, productID),
    FOREIGN KEY (orderID) REFERENCES foobar.foo_order(orderID),
    FOREIGN KEY (productID) REFERENCES foobar.product(productID)
);

CREATE TABLE IF NOT EXISTS foobar.productLog(
	userID INT NOT NULL,
    productID INT NOT NULL,
    logDate timestamp NOT NULL,
    activity varchar(10) NOT NULL,
    PRIMARY KEY(userID, productID, logDate),
    FOREIGN KEY (userID) REFERENCES foobar.foo_user(userID),
    FOREIGN KEY (productID) REFERENCES foobar.product(productID)
);

CREATE TABLE IF NOT EXISTS foobar.signLog(
	logID INT NOT NULL UNIQUE auto_increment,
    userID INT NOT NULL,
    logDate timestamp NOT NULL,
    lstatus int NOT NULL,
    PRIMARY KEY(logID),
    FOREIGN KEY (userID) REFERENCES foobar.foo_user(userID)
);