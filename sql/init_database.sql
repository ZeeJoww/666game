-- 创建数据库
CREATE DATABASE `666game`;

-- 改变 current working database
USE `666game`;

-- 建表
-- 01. login 表: 用户信息表
CREATE TABLE `login` (
    `id`       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30)  NOT NULL,
    `nickname` VARCHAR(30)  NOT NULL,
    `password` VARCHAR(30)  NOT NULL,
    `email`    VARCHAR(256) NOT NULL,
    UNIQUE INDEX(`username`),
    UNIQUE INDEX(`email`)
);

-- 02. game 表: 平台游戏表
CREATE TABLE `game` (
    `id`         BIGINT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`       VARCHAR(30) NOT NULL,
    `cover_url`  VARCHAR(255),
    `created_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 03. message 表: 消息表【后面新增的表，等完成大部分业务逻辑后再做测试】
CREATE TABLE `message` (
    `id`         BIGINT        NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `src_id`     BIGINT        NOT NULL,
    `dst_id`     BIGINT        NOT NULL,
    `content`    VARCHAR(8191) NOT NULL,
    `created_at` DATETIME      NOT NULL,
    FOREIGN KEY (`src_id`) REFERENCES `login` (`id`),
    FOREIGN KEY (`dst_id`) REFERENCES `login` (`id`)
);
