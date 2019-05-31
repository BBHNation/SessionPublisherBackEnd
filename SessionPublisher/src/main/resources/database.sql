DROP DATABASE IF EXISTS sys;
CREATE DATABASE IF NOT EXISTS session;
USE session;

CREATE TABLE IF NOT EXISTS users (
  USER_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(100) NOT NULL COMMENT 'user name',
  PHONE VARCHAR(100) NOT NULL COMMENT 'user phone'
);