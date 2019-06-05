DROP DATABASE IF EXISTS sys;
CREATE DATABASE IF NOT EXISTS session DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE session;

CREATE TABLE IF NOT EXISTS users
(
  ID            VARCHAR(100) NOT NULL UNIQUE PRIMARY KEY,
  EMAIL         VARCHAR(100) NOT NULL UNIQUE COMMENT 'user email',
  NAME          VARCHAR(100) NOT NULL COMMENT 'user name',
  SECURITY_CODE VARCHAR(100) NOT NULL COMMENT 'security code'
) DEFAULT CHARSET utf8;

CREATE TABLE IF NOT EXISTS sessions
(
  ID            VARCHAR(100) NOT NULL UNIQUE PRIMARY KEY,
  TITLE         VARCHAR(100) NOT NULL UNIQUE COMMENT 'title',
  SUB_TITLE     VARCHAR(200) NOT NULL COMMENT 'sub title',
  CURRENT_STAGE INT(8)       NOT NULL COMMENT 'current stage',
  TOTAL_STAGE   INT(8)       NOT NULL COMMENT 'total stage',
  PUBLISHED     BOOLEAN      NOT NULL DEFAULT FALSE COMMENT 'published',
  CREATOR_ID    VARCHAR(100) NOT NULL COMMENT 'creator / user id'
) DEFAULT CHARSET utf8;
