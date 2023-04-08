-- 一、插入

-- PS: 两张表的 id 字段均设为 AUTO INCREMENT, 因此插入时可省略不写; game 表的 `created_at` 与 `updated_at` 字段同理. 
-- 01. login 表 
INSERT INTO `login` (`username`, `nickname`, `password`, `email`) VALUES ('joww', 'joww', 'joww001', 'joww@mail1.com');
INSERT INTO `login` (`username`, `nickname`, `password`, `email`) VALUES ('hello', 'Hello', 'hello002', 'hello@mail2.com');
INSERT INTO `login` (`username`, `nickname`, `password`, `email`) VALUES ('potato', 'potato', 'potato003', 'potato@mail3.com');
INSERT INTO `login` (`username`, `nickname`, `password`, `email`) VALUES ('yet_another_joww', 'joww', 'joww004', 'joww@mail4.com');

-- 02. game 表 
INSERT INTO `game` (`name`, `created_at`, `updated_at`) VALUES ('贪吃蛇', '2023-03-29 18:43:20', '2023-03-29 18:43:20');
INSERT INTO `game` (`name`, `created_at`, `updated_at`) VALUES ('推箱子', '2023-03-30 12:44:15', '2023-03-30 12:44:15');
INSERT INTO `game` (`name`, `created_at`, `updated_at`) VALUES ('贪吃蛇2', '2023-03-30 06:01:52', '2023-03-30 08:01:52');
INSERT INTO `game` (`name`, `created_at`, `updated_at`) VALUES ('2048', '2023-03-31 10:47:00', '2023-03-31 10:47:00');
INSERT INTO `game` (`name`) VALUES ('POTATO GAME');


-- 二、查询

-- 01. 【用户登录】 根据用户名('potato')查询密码
SELECT `username`, `password` FROM `login` WHERE `username` = 'potato';
-- 02. 【用户检索】 列出给定昵称('joww')的所有用户的用户名、昵称和邮箱
SELECT `username`, `nickname`, `email` FROM `login` WHERE `nickname` = 'joww';
-- 03. 【游戏检索】 查询在某一天(2023-03-30)内上传的所有游戏
SELECT * FROM `game` WHERE `created_at` BETWEEN '2023-03-30 00:00:00' AND '2023-03-30 23:59:59';


-- 三、修改

-- 01. 修改昵称
UPDATE `login` SET `nickname` = 'tomato' WHERE `id` = '3';
-- 02. 修改用户信息
UPDATE `login` SET `nickname` = 'hello!', `password` = 'hellohello', `email` = 'hello@mail2.edu.cn' WHERE `username` = 'hello';
-- 03. 游戏更新（事实上，由于设置了 ON UPDATE CURRENT_TIME_STAMP, 该工作是徒劳的）
UPDATE `game` SET `updated_at` = NOW() WHERE `id` = '5';


-- 四、删除

-- 00. 删除游戏 '贪吃蛇2'
DELETE FROM `game` where `name` = '贪吃蛇2';


-- 五、查询 plus

-- Ⅰ. 查询前 N 条 [LIMIT N]; 或 从 B 开始的 (zero-indexed) 接下来 C 条 [LIMIT B, C]
SELECT * FROM `game` LIMIT 2;
SELECT * FROM `game` LIMIT 1, 2;

-- Ⅱ. 模糊查询 like: 两种通配符, '%' <=> string, '_' <=> char
-- 01. 查询用户名中含有两个 'o' 的用户
SELECT * FROM `login` WHERE `username` LIKE '%o%o%';
-- 02. 查询名字共三个字的游戏
SELECT * FROM `game` WHERE `name` LIKE '___';

-- Ⅲ. 排序 => ORDER BY `字段名` [ASC/DESC] (默认是升序 ASC)
-- 01. 用户 按 昵称字典序   升序
SELECT * FROM `login` ORDER BY `nickname`;
-- 02. 游戏 按 最近更新日期 降序
SELECT * FROM `game` ORDER BY `updated_at` DESC;

-- Ⅳ. 分组/5个统计函数
-- 01. COUNT() 查询游戏总数
SELECT COUNT(*) FROM `game`;
-- 02. MIN() 查询最早上传的游戏 (+嵌套+连接)
SELECT * FROM `game` JOIN (SELECT MIN(`created_at`) as `earlist` FROM `game`) as `tmp` ON `game`.`created_at` = `tmp`.`earlist`;
-- 03. MAX() 查询最近更新的游戏 (+嵌套+连接)
SELECT * FROM `game` JOIN (SELECT MAX(`updated_at`) as `latest` FROM `game`) as `tmp` ON `game`.`updated_at` = `tmp`.`latest`;
-- 04. SUM() 查询所有用户的昵称长度之和
SELECT SUM(LENGTH(`nickname`)) FROM `login`;
-- 05. AVG() 查询所有游戏名称长度的平均值
SELECT AVG(LENGTH(`name`)) FROM `game`;

-- Ⅴ. 多表连接查询 【由于业务逻辑有变，原 game.publisher 字段已删除 (原为引用 login.username 的外键)，以下 01,02,03 不再能正常运行】
-- 01. 内连接 (INNER) JOIN: 都有才会有
-- SELECT * FROM `login` JOIN `game` ON `login`.`username` = `game`.`publisher`;
-- 02. 左外连接  LEFT JOIN: 左边有就有
-- SELECT * FROM `login` LEFT JOIN `game` ON `login`.`username` = `game`.`publisher`;
-- 03. 右外连接 RIGHT JOIN: 右边有就有
-- SELECT * FROM `game` RIGHT JOIN `login` ON `game`.`publisher` = `login`.`username`;
-- 04. 全外连接  FULL JOIN: 一边有就有 (mysql 不支持)
-- [X] unsupported in mysql 
-- 05. 交叉链接 CROSS JOIN: 笛卡尔积
SELECT * FROM `game` CROSS JOIN `login`;
