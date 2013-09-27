CREATE SCHEMA PRESUPUESTAR;

CREATE TABLE PRESUPUESTAR.CATEGORY
(
	CATEGORY_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	NAME VARCHAR(30) NOT NULL,
	PRIMARY KEY (CATEGORY_ID)
);
CREATE TABLE PRESUPUESTAR.PROFFESION
(
	PROFFESION_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	NAME VARCHAR(30) NOT NULL,
	CATEGORY_ID BIGINT NOT NULL,
	LIST_INDEX INTEGER DEFAULT NULL,
	FOREIGN KEY (CATEGORY_ID) REFERENCES PRESUPUESTAR.CATEGORY(CATEGORY_ID), 
	PRIMARY KEY (PROFFESION_ID)
);

CREATE TABLE PRESUPUESTAR.STORE
(
	STORE_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	NAME VARCHAR(30) NOT NULL,
	PRIMARY KEY (STORE_ID)
);
CREATE TABLE PRESUPUESTAR.PRODUCT
(
	PRODUCT_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	CODE VARCHAR(20) NOT NULL,
	NAME VARCHAR(30) NOT NULL,
	DESCRIPTION VARCHAR(500) NULL,
	PRICE DECIMAL(10,2) NOT NULL,
	STORE_ID BIGINT NOT NULL,
	LIST_INDEX INTEGER DEFAULT NULL,
	FOREIGN KEY (STORE_ID) REFERENCES PRESUPUESTAR.STORE(STORE_ID), 
	PRIMARY KEY (PRODUCT_ID)
);

CREATE TABLE PRESUPUESTAR.BASIC_PROFILE (
	BASIC_PROFILE_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	FIRST_NAME VARCHAR(15) NOT NULL,
	LAST_NAME VARCHAR(15) NOT NULL,
	PRIMARY KEY (BASIC_PROFILE_ID)
);
CREATE TABLE PRESUPUESTAR.FULL_PROFILE
(
	FULL_PROFILE_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	FIRST_NAME VARCHAR(15) NULL,
	LAST_NAME VARCHAR(15) NULL,
	REASON VARCHAR(25) NULL,
	WEB_PAGE VARCHAR(50) NULL,
	PRIMARY KEY (FULL_PROFILE_ID)
);

CREATE TABLE PRESUPUESTAR.PHONE
(
	PHONE_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	PHONE_NUMBER VARCHAR(20) NOT NULL,
	PROFILE_ID BIGINT NOT NULL,
	LIST_INDEX INTEGER DEFAULT NULL,
	FOREIGN KEY (PROFILE_ID) REFERENCES PRESUPUESTAR.FULL_PROFILE(FULL_PROFILE_ID), 
	PRIMARY KEY (PHONE_ID)
);
CREATE TABLE PRESUPUESTAR.ADDRESS
(
	ADDRESS_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	ADDRESS_LINE_1 VARCHAR(40) NOT NULL,
	ADDRESS_LINE_2 VARCHAR(40) DEFAULT '' NULL,
	ZIP_CODE VARCHAR(10) NOT NULL,
	CITY VARCHAR(15) DEFAULT '' NULL,
	STATE VARCHAR(15) DEFAULT '' NULL,
	COUNTRY VARCHAR(15) DEFAULT '' NULL,
	PROFILE_ID BIGINT NOT NULL,
	LIST_INDEX INTEGER DEFAULT NULL,
	FOREIGN KEY (PROFILE_ID) REFERENCES PRESUPUESTAR.FULL_PROFILE(FULL_PROFILE_ID), 
	PRIMARY KEY (ADDRESS_ID)
);

CREATE TABLE PRESUPUESTAR.PERSON (

	PERSON_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	EMAIL VARCHAR(35) NOT NULL,
	PASSWORD VARCHAR(10) NOT NULL,
	PROFILE_ID BIGINT NOT NULL,
	FOREIGN KEY (PROFILE_ID) REFERENCES PRESUPUESTAR.BASIC_PROFILE(BASIC_PROFILE_ID), 
	PRIMARY KEY (PERSON_ID)
);
CREATE TABLE PRESUPUESTAR.PROFFESIONAL
(
	PROFFESIONAL_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	EMAIL VARCHAR(35) NOT NULL,
	PASSWORD VARCHAR(10) NOT NULL,
	PROFFESIONAL_TYPE VARCHAR(15) NOT NULL,
	PROFFESION_ID BIGINT NOT NULL,
	PROFILE_ID BIGINT NOT NULL,
	AVG_SCORE FLOAT DEFAULT 0 NOT NULL,
	FOREIGN KEY (PROFFESION_ID) REFERENCES PRESUPUESTAR.PROFFESION(PROFFESION_ID), 
	FOREIGN KEY (PROFILE_ID) REFERENCES PRESUPUESTAR.FULL_PROFILE(FULL_PROFILE_ID), 
	PRIMARY KEY (PROFFESIONAL_ID)
);
CREATE TABLE PRESUPUESTAR.COMMERCE
(
	COMMERCE_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	EMAIL VARCHAR(35) NOT NULL,
	PASSWORD VARCHAR(10) NOT NULL,
	STORE_ID BIGINT NULL,
	PROFILE_ID BIGINT NOT NULL,
	AVG_SCORE FLOAT DEFAULT 0 NOT NULL,
	FOREIGN KEY (STORE_ID) REFERENCES PRESUPUESTAR.STORE(STORE_ID), 
	FOREIGN KEY (PROFILE_ID) REFERENCES PRESUPUESTAR.FULL_PROFILE(FULL_PROFILE_ID), 
	PRIMARY KEY (COMMERCE_ID)
);

CREATE TABLE PRESUPUESTAR.PRODUCTS_DETAIL
(
	PRODUCTS_DETAIL_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	DESCRIPTION VARCHAR(1000) DEFAULT '' NULL,
	AMOUNT DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (PRODUCTS_DETAIL_ID)
);
CREATE TABLE PRESUPUESTAR.LABOR_DETAIL
(
	LABOR_DETAIL_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	DESCRIPTION VARCHAR(1000) DEFAULT '' NULL,
	AMOUNT DECIMAL(10,2) NOT NULL,
	PRIMARY KEY (LABOR_DETAIL_ID)
);

CREATE TABLE PRESUPUESTAR.LABOR_BUDGET
(
	LABOR_BUDGET_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	AMOUNT DECIMAL(10,2) NOT NULL,
	PROFFESIONAL_ID BIGINT NOT NULL,
	LABOR_DETAIL_ID BIGINT NOT NULL,
	PRODUCTS_DETAIL_ID BIGINT NULL,
	PROFFESIONAL_ID2 BIGINT NOT NULL,
	PROF_BUDGET_IDX  INTEGER DEFAULT NULL,
	FOREIGN KEY (PROFFESIONAL_ID) REFERENCES PRESUPUESTAR.PROFFESIONAL(PROFFESIONAL_ID), 
	FOREIGN KEY (LABOR_DETAIL_ID) REFERENCES PRESUPUESTAR.LABOR_DETAIL(LABOR_DETAIL_ID), 
	FOREIGN KEY (PRODUCTS_DETAIL_ID) REFERENCES PRESUPUESTAR.PRODUCTS_DETAIL(PRODUCTS_DETAIL_ID), 
	FOREIGN KEY (PROFFESIONAL_ID2) REFERENCES PRESUPUESTAR.PROFFESIONAL(PROFFESIONAL_ID), 
	PRIMARY KEY (LABOR_BUDGET_ID)
);

CREATE TABLE PRESUPUESTAR.ITEM
(
	ITEM_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	NAME VARCHAR(30) NOT NULL,
	PRICE DECIMAL(10,2) NOT NULL,
	QUANTITY INTEGER DEFAULT 1 NOT NULL,
	PRODUCTS_DETAIL_ID BIGINT NOT NULL,
	PRODUCTS_DETAIL_ITEM_IDX INTEGER DEFAULT NULL,
	FOREIGN KEY (PRODUCTS_DETAIL_ID) REFERENCES PRESUPUESTAR.PRODUCTS_DETAIL(PRODUCTS_DETAIL_ID), 
	PRIMARY KEY (ITEM_ID)
);
CREATE TABLE PRESUPUESTAR.PRODUCTS_BUDGET
(
	PRODUCTS_BUDGET_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	AMOUNT DECIMAL(10,2) NOT NULL,
	COMMERCE_ID BIGINT NOT NULL,
	COMMERCE_ID2 BIGINT NOT NULL,
	COMM_BUDGET_IDX INTEGER DEFAULT NULL,
	FOREIGN KEY (COMMERCE_ID) REFERENCES PRESUPUESTAR.COMMERCE(COMMERCE_ID), 
	FOREIGN KEY (COMMERCE_ID2) REFERENCES PRESUPUESTAR.COMMERCE(COMMERCE_ID), 
	PRIMARY KEY (PRODUCTS_BUDGET_ID)
);
CREATE TABLE PRESUPUESTAR.ITEM_BUDGET
(
	ITEM_BUDGET_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	AMOUNT DECIMAL(10,2) NOT NULL,
	PRODUCTS_BUDGET_ID BIGINT NOT NULL,
	ITEM_ID BIGINT NOT NULL,
	PRODUCT_ID BIGINT NULL,
	PRODBGT_ITEM_IDX INTEGER DEFAULT NULL,
	FOREIGN KEY (PRODUCTS_BUDGET_ID) REFERENCES PRESUPUESTAR.PRODUCTS_BUDGET(PRODUCTS_BUDGET_ID), 
	FOREIGN KEY (ITEM_ID) REFERENCES PRESUPUESTAR.ITEM(ITEM_ID), 
	FOREIGN KEY (PRODUCT_ID) REFERENCES PRESUPUESTAR.PRODUCT(PRODUCT_ID), 
	PRIMARY KEY (ITEM_BUDGET_ID)
);

CREATE TABLE PRESUPUESTAR.BUDGET
(
	BUDGET_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	AMOUNT DECIMAL(10,2) NOT NULL,
	LABOR_BUDGET_ID BIGINT NOT NULL,
	PRODUCTS_BUDGET_ID BIGINT NOT NULL,
	AVG_SCORE FLOAT DEFAULT 0 NOT NULL,
	FOREIGN KEY (LABOR_BUDGET_ID) REFERENCES PRESUPUESTAR.LABOR_BUDGET(LABOR_BUDGET_ID), 
	FOREIGN KEY (PRODUCTS_BUDGET_ID) REFERENCES PRESUPUESTAR.PRODUCTS_BUDGET(PRODUCTS_BUDGET_ID), 
	PRIMARY KEY (BUDGET_ID)
);

CREATE TABLE PRESUPUESTAR.FEEDBACK
(
	FEEDBACK_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	FEEDBACK_TYPE VARCHAR(10) NOT NULL,
	SCORE INTEGER NOT NULL,
	FEEDBACK_ON_CLASS VARCHAR(12) NOT NULL,
	FEEDBACK_ON_ID BIGINT NOT NULL,
	PROFFESIONAL_ID BIGINT DEFAULT NULL,
	PROF_FBK_IDX INTEGER DEFAULT NULL,
	COMMERCE_ID BIGINT DEFAULT NULL,
	COMM_FBK_IDX INTEGER DEFAULT NULL,
	BUDGET_ID BIGINT DEFAULT NULL,
	BGT_FBK_IDX INTEGER DEFAULT NULL,
	FOREIGN KEY (PROFFESIONAL_ID) REFERENCES PRESUPUESTAR.PROFFESIONAL(PROFFESIONAL_ID), 
	PRIMARY KEY (FEEDBACK_ID)
);
CREATE TABLE PRESUPUESTAR.COMMENT
(
	COMMENT_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,
	COMMENT VARCHAR(300) NOT NULL,
	COMMENT_DATE DATE NOT NULL,
	AUTHOR_CLASS VARCHAR(12) NOT NULL,
	AUTHOR_ID BIGINT NOT NULL,	
	FEEDBACK_ID BIGINT NOT NULL,
	FBK_COMMENT_IDX INTEGER DEFAULT NULL,
	FOREIGN KEY (FEEDBACK_ID) REFERENCES PRESUPUESTAR.FEEDBACK(FEEDBACK_ID), 
	PRIMARY KEY (COMMENT_ID)
);