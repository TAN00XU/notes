[TOC]

# MySQL

## 一、数据库分类

1. ### 关系型数据库（SQL）

   + MySQL, Oracle, Sql Server, DB2, SQLlite

   + 通过表和表之间，行和列之间的关系进行数据的存储。学员信息表,考勤表,

     + 优点：

       1. 易于维护：都是使用表结构，格式一致;

       2. 使用方便：SQL语言通用，可用于复杂查询;

       3. 复杂操作：支持SQL，可用于一个表以及多个表之间非常复杂的查询。

     + 缺点：

       1. 读写性能比较差，尤其是海量数据的高效率读写;

       2. 固定的表结构，灵活度稍欠;

       3. 高并发读写需求，传统关系型数据库来说，硬盘I/O是一个很大的瓶颈

2. ### 非关系型数据库（NoSQL）Not Only

   + Redis，MongDB

   + 非关系型数据库,对象存储,通过对象的自身的属性来决定。 

     + 优点：

       1. 格式灵活：存储数据的格式可以是key,value形式、文档形式、图片形式等等，文档形式、图片形式等等，使用灵活，应用场景广泛，而关系型数据库则只支持基础类型。

       2. 速度快：nosql可以使用硬盘或者随机存储器作为载体，而关系型数据库只能使用硬盘;

       3. 高扩展性;

       4. 成本低：nosql数据库部署简单，基本都是开源软件。

     + 缺点：

       1. 不提供sql支持，学习和使用成本较高;

       2. 无事务处理;

       3. 数据结构相对复杂，复杂查询方面稍欠。

3. ### ==DBMS（数据库管理系统）==

+ 数据库的管理软件，科学有效的管理我们的数据，维护和获取数据
+ MySQL，数据库管理系统

---



## 二、连接数据库

1. ### 启动与关闭服务

   ```mysql
   net start mysql --启动
   net stop mysql --关闭
   ```

2. ### 连接数据库

   ```mysql
   mysql -uroot -p[密码（可选）]
   ```

   

   

## 三、基本命令

```mysql
show databases;  --查看所有的数据库

use [数据库名] --切换数据库
Database changed

show tables;  --查看数据库中所有的表

describe [表名];  --显示数据库中表的所有信息

create database [数据库名];  --创建一个数据库

exit;  --退出连接
```

---



## 四、操作数据库

操作数据库 > 操作数据库中的表 > 操作数据库中表的数据

==mysql关键字不区分大小写==

### 1. 创建数据库

```mysql
CREATE DATABASE [IF NOT EXISTS] mydata;
```

### 2. 删除数据库

```mysql
DROP DATABASE [IF EXISTS] mydata;
```

### 3. 使用数据库

```mysql
--如果表名或者字段名是一个特殊的字符需要加上`learning`
USE learning
```

### 4. 查看数据库

```mysql
SHOW DATABASES;  --查看所有的数据库
```

---



## 五、数据库的列类型

### 1. 数值

| 数据类型 | 特点 | 长度 |
| :------: | :--: | :--: |
| tinyint | 十分小的数据 |1个字节 |
| smallint | 较小的数据 | 2个字节 |
| mediumint | 中等大小的数据 | 3个字节 |
| int |标准的整数 | 4个字节 |
| bigint | 较大的数据 | 8个字节 |
| float | 浮点数 | 4个字节 |
| double | 浮点数 | 8个字节 |
| decimal | 字符串形势的浮点数 | 金融计算时，一般是使用decimal |

### 2. 字符串

| 数据类型 |        特点        |  长度   |
| :------: | :----------------: | :-----: |
|   char   |  字符串固定大写的  |  0~25   |
| varchar  |     可变字符串     | 0~65535 |
| tinytext |      微型文本      |  2^8-1  |
|   text   | 文本串，保存大文本 | 2^16-1  |

### 3. 日期

`java.util.Date`

| 数据类型  |                    特点                    |
| :-------: | :----------------------------------------: |
|   date    |            YYYY-MM-DD,日期格式             |
|   time    |            HH：mm：ss，时间格式            |
| datetime  |   YYYY-MM-DD HH：mm：ss 最常用的时间格式   |
| timestamp | 时间戳，1970.1.1到现在的毫秒数。也较为常用 |
|   year    |                    年份                    |

### 4. null

+ 没有值
+ ==注意不要使用NULL进行运算，结果为NULL==

---



### 六、数据库的字段类型（重点）

### 1. Unsigned

+ 无符号的整数
+ 声明了该列不能声明为负数

### 2. zerofill

+ 0填充
+ 不足的位数，使用0来填充。int(3) , 6 --> 006.

### 3. 自增

+ 通常理解为自增，自动在上一条记录的基础上+1(默认)
+ 通常用来设计唯一的主键~index，必须是整数类型
+ 可以自定义设计主键自增的起始值和步长 

### 4. 空/非空 NULL/not null

+ 假设设置为not null，如果不给它赋值，就会报错!
+ NUII，如果不填写值，默认就是null! 

### 5. 默认default

+ 设置默认值

---



## 七、创建数据库表

```mysql
-- 注意点，使用英文()，表的名称和字段尽量使用` `括起来
-- AUTO_INCREMENT 自增
-- 字符串使用' '单引号括起来
-- 所有的语句后面加,(英文的) , 最后一个不用加
-- PRIMARY KEY主键,一般一个表只有一个唯一的主键
CREATE TABLE IF NOT EXISTS `student` (
    `id` int(10) NOT NULL AUTO_INCREMENT comment '学生的id',
    `name` varchar(30) NOT NULL default '匿名' comment '学生姓名',
    `password` varchar(20) not null default '123123' comment '学生密码',
     `birthday` datetime default null comment '出生日期',
     primary key (`id`)
)ENGINE=INNODB DEFAULT CHARSET utf8
```



### 格式

```mysql
CREATE TABLE [IF NOT EXISTS] `表名`(
	`字段名` 列类型 [属性] [索引] [类型],
    `字段名` 列类型 [属性] [索引] [类型],
    ……
    `字段名` 列类型 [属性] [索引] [类型],
    `字段名` 列类型 [属性] [索引] [类型]
)[表类型][字符集设置][注释]
```



### 常用命令

``` mysql
-- 查看创建数据库的语句
show create database `learning`;
-- 查看student数据表的定义语句
show create table `student`;
-- 显示表结构
desc `student`;
```



## 八、关于数据库引擎

==**INNODB**== 默认使用

==**MYISAM**== 早些年使用

|              | INNODB       | MYISAM         |
| ------------ | ------------ | -------------- |
| 事务支持     | 支持         | 不支持         |
| 数据行锁定   | 支持（行锁） | 不支持（表锁） |
| 外键约束     | 支持         | 不支持         |
| 全文索引     | 不支持       | 支持           |
| 表空间的大小 | 较大，约两倍 | 较小           |

+ **INNODB** 安全性高，事务的处理，多表多用户操作
+ **MYISAM** 节约空间 ，速度较快

#### 在物理空间存在的位置

所有的数据库文件都存在data目录下

本质还是文件的存储!



MySQL引擎在物理文件上的区别

+ **INNODB** 在数据库表中只有一个`*.frm`文件，以及上级目录下的ibdata1
+ **MYISAM** 对应文件
  + `*.frm` - 表结构的定义文件
  + `*.MYD` 数据文件(data)
  + `*.MYI` 索引文件(index)

---



## 九、设置数据库表的字符集编码

```mysql
CHARSET=utf8mb4
```

不设置的话，会是mysql默认的字符集编码Latin1（不支持中文）

在my.ini中配置默认的编码

```
 character-set-server=utf8mb4 
```

---



## 十、修改和删除表

```mysql
-- 修改表
alter table [旧表名] rename as [新表名];
-- 增加字段
alter table [表名] add [字段名] [列属性];
-- 修改表的字段
alter table [表名] modify [字段名] [列属性];  -- 修改约束
alter table [表名] change [字段名] [新的字段名] [列属性];  --字段重命名
-- 删除表的字段
alter table [表名] drop [字段名];
-- 删除表
drop table [IF EXISTS] [表名];
```

+ change用来字段重命名,不能修改字段类型和约束;
+ modify不用来字段重命名,只能修改字段类型和约束;

---



## 十一、MySQL数据管理

### 1. 外键（了解）

#### 方式一、在创建表时增加约束（比较麻烦、复杂）

```sql
key `FK_[A表字段名]` ([A表字段名]),
constraint `FK_约束名` foreign key (`[A表字段名]`) references `[B表名]`(`[B表字段名]`)
```

#### 方式二、创建表时未添加外键

```sql
alter table `[A表名]`
add constraint `FK_约束名` foreign key(`[A表字段名]`) references `[B表名]`(`[B表字段名]`);
```



以上的操作都是物理外键，数据库级别的外键，不建议使用! (避免数据库过多造成困扰)

最佳方式：

+ 数据库就是单纯的表，只用来存数据，只有行(数据)和列(字段)
+ 我们想使用多张表的数据，想使用外键（采用程序去实现） 

### 2. DML语言（全部记住）

**数据库的意义**：数据存储，数据管理

DML语言；数据库操作语言

+ insert
+ update
+ delete

### 3. 添加（insert）

```sql
insert into `表名`(`字段名1`) values('值1');

insert into `表名`(`字段名1`,`字段名2`,`字段名3`) values('值1','值2','值3');

insert int `表名`(`字段名1`,`字段名2`)
values('值1','值2'),
		('值1','值2');
```



**语法**：`insert into 表名([字段名1,字段名2,字段名3])values('值1.1','值1.2','值1.3'),('值2.1','值2.2','值2.3'),('值3.1','值3.2','值3.3');`



==**注意事项**：==

1. 字段和字段之问使用英文运号隔开
2. 字段是可以省略的，但是后面的值必须受要一一对应，不能少
2. 可以同时插入多条数据,VALUES后面的值,需要使用,隔开即可 `values(),(),(),...`

### 4. 修改(update)

```sql
update [`表名`] set `字段名`='新值' where [条件];  -- 不指定where条件会改动所有的表
update [`表名`] set `字段名1`='新值1',`字段名2`='新值2' where [条件];  -- 修改多个属性，逗号隔开
update [`表名`] set `字段名`='新值' where [条件1] and [条件2];  --多个条件定位数据
```



条件：where子句

|      操作符      |           含义           |
| :--------------: | :----------------------: |
|        =         |           等于           |
|      <>或!=      |          不等于          |
|        >         |           大于           |
|        <         |           小于           |
|        >=        |        大于或等于        |
|        <=        |        小于或等于        |
| between...and... | 闭合区间（在一个范围内） |
|       and        |           a和b           |
|        or        |           a或b           |

### 5. 删除(delete)

==**语法**==：`delete form 表名 [where 条件]`

```sql
-- 删除数据（避免，会删除整张表的数据）
delete from `表名`
-- 删除指定数据
delete from `表名` where 条件

```



==**truncate**==

作用：完全清空一个数据库表，表的结构和索引约束不会变! 

`truncate 表名 ` 或 `truncate table 表名`



**delete与truncate的区别**

+ 相同点:都能删除数据,都不会删除表结构
+ 不同:
  + TRUNCATE 重新设置 自增列计数器会归零
  + TRUNCATE 不会影响事务 

==delete删除问题==，重启数据库

+ InnoDB 自增列会重1开始 (存在内存当中的,所电即失)
+ MyISAM 继续从上一个白增开始(存在文件中的,不会丢失) 

#### runcate与drop,delete的对比

1. truncate与drop是DDL语句，执行后**无法回滚**；delete是DML语句，**可回滚**。
2. truncate只能作用于表；delete，drop可作用于表、视图等。
3. truncate会清空表中的所有行，但表结构及其约束、索引等保持不变；drop会删除表的结构及其所依赖的约束、索引等。
4. truncate会重置表的自增值；delete不会。
5. truncate不会激活与表有关的删除触发器；delete可以。
6. truncate后会使表和索引所占用的空间会恢复到初始大小；delete操作不会减少表或索引所占用的空间，drop语句将表所占用的空间全释放掉。

### 6. DQL查询数据（最重点）

(Data Query LANGUAGE :数据查询语句)：

+ 所有的查询操作都用它  Select
+ 简单的查询,复杂的查询它都能做
+ ==数据库中最核心的语言,最重要的语句==
+ 使用频率最高的语句 

#### 6.1 指定查询字段

```sql
-- 查询全部的学生 SELECT 字段 FROM 表名
SELECT * FROM student
-- 查询指定字段
SELECT `StudentNo`, `StudentName` FROM student
-- 别名,给结果起一个名字 AS 可以给字段起别名,也可以给表起别名
SELECT `StudentNo` AS 学号， `studentName` AS 学生姓名 FROM student AS 学生表
-- 函数 concat (a, b)  拼接字符串
SELECT CONCAT('姓名: ', StudentName) AS 新名字 FROM student 
```



#### 6.2 去重distinct

```sql
select distinct `字段名` from 表名
```



#### 6.3 数据库的列

```sql
select version()  -- 查询系统的版本
select 6*6*6 as 计算结果  -- 用来计算
select @@auto_increment_increment  -- 查询自增的步长

-- 学员考试成绩+1分查看
select `StudentNo`,`StudentResult`+1 as '提分后' from result;
```

数据库中的表达式：文本值，列，NULL，函数，计算表达式，系统变量

`select 表达式 from 表`



#### 6.4 where条件子句

作用：检索数据中符合条件的值

搜索的条件由一个或者多个表达式组成，返回结果是布尔值

##### 逻辑运算符



|  运算符   |       语法        |              描述              |
| :-------: | :---------------: | :----------------------------: |
| and , &&  | a and b , a && b  |  逻辑与，两个都为真，结果为真  |
| or , \|\| | a or b , a \|\| b | 逻辑或，其中一个为真，结果为真 |
|  not , !  |    not a , !a     |     逻辑非，真为假，假为真     |

##### 模糊查询：比较运算符

|   运算符    |        语法         |                      描述                      |
| :---------: | :-----------------: | :--------------------------------------------: |
|   is null   |      a is null      |           如果操作符为null，结果为真           |
| is not null |    a is not null    |          如果操作符不为null，结果为真          |
|   between   |  a between b and c  |            若a在b和c之间，结果为真             |
|  **like**   |      a like b       |        SQL匹配，如果a匹配b，则结果为真         |
|   **in**    | a in (a1,a2,a3,...) | 假设a在a1，或者a2...其中的某一个值中，结果为真 |

```sql
-- like 结合 %（代表0到任意个字符）  _（一个字符）
select `studentNo`,`studentName` from `student`
where studentName like '杨%'
--查询杨姓后面一个字
select `studentNo`,`studentName` from `student`
where studentName like '杨_'
--查询杨姓后面两个字
select `studentNo`,`studentName` from `student`
where studentName like '杨__'
--查询名字中间有某字的
select `studentNo`,`studentName` from `student`
where studentName like '%某%'

-- 查询1001,1002,1003学号
select `studentNo`,`studentName` from `student`
where studentNo in (10001,1002,1003);
-- 查询在广安的学生
select `studentNo`,`studentName` from `student`
where `address` in ('广安');

-- 查询地址为空的学生
select `studentNo`,`studentName` from `student`
where address=null or address is null;
-- 查询有出生日期的学生
select `studentNo`,`studentName` from `student`
where bornDate is not null;
```



#### 6.5 联表查询
