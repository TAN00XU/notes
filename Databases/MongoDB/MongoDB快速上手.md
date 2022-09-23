# 一、MongoDB相关概念



## 1.1 业务场景

传统的关系型数据库（如MySQL），在数据操作的“三高”需求以及应对Web2.0的网站需求面前，显得力不从心。 

解释：“三高”需求： 

+ High performance - 对数据库高并发读写的需求。 

+ Huge Storage - 对海量数据的高效率存储和访问的需求。

+ High Scalability && High Availability- 对数据库的高可扩展性和高可用性的需求。

**而MongoDB可应对“三高”需求。**



### 1.1.1 具体应用场景

1. 社交场景，使用 MongoDB 存储存储用户信息，以及用户发表的朋友圈信息，通过地理位置索引实现附近的人、地点等功能。
2. 游戏场景，使用 MongoDB 存储游戏用户信息，用户的装备、积分等直接以内嵌文档的形式存储，方便查询、高效率存储和访问。 
3. 物流场景，使用 MongoDB 存储订单信息，订单状态在运送过程中会不断更新，以 MongoDB 内嵌数组的形式来存储，一次查询就能将 订单所有的变更读取出来。
4. 物联网场景，使用 MongoDB 存储所有接入的智能设备信息，以及设备汇报的日志信息，并对这些信息进行多维度的分析。
5. 视频直播，使用 MongoDB 存储用户信息、点赞互动信息等。

这些应用场景中，数据操作方面的共同特点是： 

1. 数据量大 
2. 写入操作频繁（读写都很频繁） 
3. 价值较低的数据，对事务性要求不高 

对于这样的数据，我们更适合使用MongoDB来实现数据的存储。



### 1.1.2 什么时候选择MongoDB?

在架构选型上，除了上述的三个特点外，如果你还犹豫是否要选择它？

可以考虑以下的一些问题： 

1. 应用不需要事务及复杂 join 支持 
2. 新应用，需求会变，数据模型无法确定，想快速迭代开发 
3. 应用需要2000-3000以上的读写QPS（更高也可以）
4.  应用需要TB甚至 PB 级别数据存储 
5. 应用发展迅速，需要能快速水平扩展 
6. 应用要求存储的数据不丢失 
7. 应用需要99.999%高可用 
8. 应用需要大量的地理位置查询、文本查询

如果上述有1个符合，可以考虑 MongoDB，2个及以上的符合，选择 MongoDB 绝不会后悔。

**相对MySQL，可以以更低的成本解决问题（包括学习、开发、运维等成本）**



## 1.2 MongoDB简介

​	MongoDB是一个开源、高性能、无模式的文档型数据库，当初的设计就是用于简化开发和方便扩展，是NoSQL数据库产品中的一种。是最 像关系型数据库（MySQL）的非关系型数据库。

​	它支持的数据结构非常松散，是一种类似于 JSON 的 格式叫BSON，所以它既可以存储比较复杂的数据类型，又相当的灵活。

​	MongoDB中的记录是一个文档，它是一个由字段和值对（field:value）组成的数据结构。MongoDB文档类似于JSON对象，即一个文档认 为就是一个对象。字段的数据类型是字符型，它的值除了使用基本的一些类型外，还可以包括其他文档、普通数组和文档数组。



## 1.3 体系结构



### 1.3.1 MySQL和MongoDB对比

![MySQL和MongoDB对比](/assets/MySQL和MongoDB对比.png)

| SQL术语/概念 | MongoDB术语/概念 | 解释/说明                           |
| ------------ | ---------------- | ----------------------------------- |
| database     | database         | 数据库                              |
| table        | collection       | 数据库表/集合                       |
| row          | document         | 数据记录行/文档                     |
| column       | field            | 数据字段/域                         |
| index        | index            | 索引                                |
| table joins  |                  | 表连接,MongoDB不支持                |
|              | 嵌入文档         | MongoDB通过嵌入式文档来替代多表连接 |
| primary key  | primary key      | 主键,MongoDB自动将_id字段设置为主键 |

  

## 1.4 数据模型

​	MongoDB的最小存储单位就是文档(document)对象。文档(document)对象对应于关系型数据库的行。数据在MongoDB中以 BSON（Binary-JSON）文档的格式存储在磁盘上。 

​	BSON（Binary Serialized Document Format）是一种类json的一种二进制形式的存储格式，简称Binary JSON。BSON和JSON一样，支持 内嵌的文档对象和数组对象，但是BSON有JSON没有的一些数据类型，如Date和BinData类型。

​	BSON采用了类似于 C 语言结构体的名称、对表示方法，支持内嵌的文档对象和数组对象，具有轻量性、可遍历性、高效性的三个特点，可 以有效描述非结构化数据和结构化数据。这种格式的优点是灵活性高，但它的缺点是空间利用率不是很理想。 

​	Bson中，除了基本的JSON类型：string,integer,boolean,double,null,array和object，mongo还使用了特殊的数据类型。这些类型包括 date,object id,binary data,regular expression 和code。每一个驱动都以特定语言的方式实现了这些类型，查看你的驱动的文档来获取详 细信息。

### BSON数据类型参考列表：

| 数据类型       | 描述                                                         | 举例                                                  |
| -------------- | ------------------------------------------------------------ | ----------------------------------------------------- |
| 字符串         | UTF-8字符串都可表示为字符串类型的数据                        | {"x" : "foobar"}                                      |
| 对象id         | 对象id是文档的12字节的唯一 ID                                | {"X" :ObjectId() }                                    |
| 布尔值         | 真或者假：true或者false                                      | {"x":true}+                                           |
| 数组           | 值的集合或者列表可以表示成数组                               | {"x" ： ["a", "b", "c"]}                              |
| 64位整数       | 不支持这个类型。shell会使用一个特殊的内嵌文档来显示64位 整数 | shell是不支持该类型的，shell中默认会转换成64 位浮点数 |
| 64位浮点数     | shell中的数字就是这一种类型                                  | {"x"：3.14159，"y"：3}                                |
| null           | 表示空值或者未定义的对象                                     | {"x":null}                                            |
| undefined      | 文档中也可以使用未定义类型                                   | {"x":undefined}                                       |
| 符号           | shell不支持，shell会将数据库中的符号类型的数据自动转换成字符串 |                                                       |
| 正则表达式     | 文档中可以包含正则表达式，采用JavaScript的正则表达式语法     | {"x" ： /foobar/i}                                    |
| 代码           | 文档中还可以包含JavaScript代码                               | {"x" ： function() { /* …… */ }}                      |
| 二进制数据     | 二进制数据可以由任意字节的串组成，不过shell中无法使用        |                                                       |
| 最大值/最 小值 | BSON包括一个特殊类型，表示可能的最大值。shell中没有这个 类型。 |                                                       |

### 提示：

+ shell默认使用64位浮点型数值。{“x”：3.14}或{“x”：3}。

+ 对于整型值，可以使用NumberInt（4字节符号整数）或NumberLong（8字节符 号整数），{“x”:NumberInt(“3”)}{“x”:NumberLong(“3”)}



## 1.5 MongoDB的特点

### 1.5.1 高性能

​	MongoDB提供高性能的数据持久性。

​	特别是, 对嵌入式数据模型的支持减少了数据库系统上的I/O活动。 

​	索引支持更快的查询，并且可以包含来自嵌入式文档和数组的键。（文本索引解决搜索的需求、TTL索引解决历史数据自动过期的需求、地 理位置索引可用于构建各种 O2O 应用） 

​	mmapv1、wiredtiger、mongorocks（rocksdb）、in-memory 等多引擎支持满足各种场景需求。 

​	Gridfs解决文件存储的需求。 

### 1.5.2 高可用性

​	MongoDB的复制工具称为副本集（replica set），它可提供自动故障转移和数据冗余。 

### 1.5.3 高扩展性

​	MongoDB提供了水平可扩展性作为其核心功能的一部分。 

​	分片将数据分布在一组集群的机器上。（海量数据存储，服务能力水平扩展） 

​	从3.4开始，MongoDB支持基于片键创建数据区域。在一个平衡的集群中，MongoDB将一个区域所覆盖的读写只定向到该区域内的那些片。 

### 1.5.4 丰富的查询支持

​	MongoDB支持丰富的查询语言，支持读和写操作(CRUD)，比如数据聚合、文本搜索和地理空间查询等。 

### 1.5.5 其他特点

​	如无模式（动态模式）、灵活的文档模型



# 二、单机部署



## 2.1 Windows系统中的安装启动



### 2.1.1  第一步：下载安装包 

MongoDB 提供了可用于 32 位和 64 位系统的预编译二进制包，你可以从MongoDB官网下载安装，MongoDB 预编译二进制包下载地址： https://www.mongodb.com/download-center#community

MongoDB的版本命名规范如：x.y.z； 

y为奇数时表示当前版本为开发版，如：1.5.2、4.1.13； 

y为偶数时表示当前版本为稳定版，如：1.6.3、4.0.10；

z是修正版本号，数字越大越好。 

详情：http://docs.mongodb.org/manual/release-notes/#release-version-numbers



### 2.1.2 第二步：解压安装启动

> 将压缩包解压到一个目录中。 
>
> 在解压目录中，手动建立一个目录用于存放数据文件，如 data/db

#### 2.1.2.1 方式1：命令行参数方式启动服务

在 bin 目录中打开命令行提示符，输入如下命令： 

```shell
mongod --dbpath=..\data\db
```

我们在启动信息中可以看到，mongoDB的默认端口是*27017*，如果我们想改变默认的启动端口，可以通过`--port`来指定端口。 

为了方便我们每次启动，可以将安装目录的bin目录设置到环境变量的path中， bin 目录下是一些常用命令，比如 mongod 启动服务用的， mongo 客户端连接服务用的。

#### 2.1.2.2 方式2：配置文件方式启动服务

在解压目录中新建 config 文件夹，该文件夹中新建配置文件 mongod.conf ，内如参考如下：

```yaml
storage:
    #The directory where the mongod instance stores its data.Default Value is "\data\db" on Windows.
    dbPath: D:\02_Server\DBServer\mongodb-win32-x86_64-2008plus-ssl-4.0.1\data
```

详细配置项内容可以参考官方文档：https://docs.mongodb.com/manual/reference/configuration-options/

##### 【注意】 

1. 配置文件中如果使用双引号，比如路径地址，自动会将双引号的内容转义。如果不转义，则会报错：

`error-parsing-yaml-config-file-yaml-cpp-error-at-line-3-column-15-unknown-escape-character-d`

解决： 

+ 对 \ 换成 / 或 \\\\
+  如果路径中没有空格，则无需加引号

2. 配置文件中不能以Tab分割字段

解决： 

+ 将其转换成空格

##### 启动方式

```shell
mongod -f ../config/mongod.conf
或
mongod --config ../config/mongod.conf
```

更多参数配置：

```yaml
systemLog:
    destination: file
    #The path of the log file to which mongod or mongos should send all diagnostic logging information
    path: "D:/02_Server/DBServer/mongodb-win32-x86_64-2008plus-ssl-4.0.1/log/mongod.log"
    logAppend: true
storage:
	journal:
    	enabled: true
    #The directory where the mongod instance stores its data.Default Value is "/data/db".
    dbPath: "D:/02_Server/DBServer/mongodb-win32-x86_64-2008plus-ssl-4.0.1/data"
net:
    #bindIp: 127.0.0.1
    port: 27017
setParameter:
    enableLocalhostAuthBypass: false
```



## 2.2 Shell连接(mongo命令)

> 在命令提示符输入以下shell命令即可完成登陆

```shel
mongo
或
mongo --host=127.0.0.1 --port=27017
```

> 查看已经有的数据库

```shell
show databases
```

> 退出mongodb

```shell
exit
```

> 更多参数可以通过帮助查看

```shell
mongo --help
```

### 提示： 

​	MongoDB javascript shell是一个基于javascript的解释器，故是支持js程序的。



## 2.3 Compass-图形化界面客户端

到MongoDB官网下载MongoDB Compass，

地址：https://www.mongodb.com/download-center/v2/compass?initial=true 

如果是下载安装版，则按照步骤安装；

如果是下载加压缩版，直接解压，执行里面的 MongoDBCompassCommunity.exe 文件即可。

 在打开的界面中，输入主机地址、端口等相关信息，点击连接



## 2.4  Linux系统中的安装启动和连接

### 2.4.1 官网下载压缩包 

### 2.4.1 上传压缩包到Linux中，解压到当前目录

```shell
tar -xvf mongodb-linux-x86_64-4.0.10.tgz
```

### 2.4.2 移动解压后的文件夹到指定的目录中

```shell
mv mongodb-linux-x86_64-4.0.10 /usr/local/mongodb
```

2.4.3 新建目录，分别用来存储数据和日志

```shell
#数据存储目录
mkdir -p /mongodb/single/data/db
#日志存储目录
mkdir -p /mongodb/single/log
```

### 2.4.4 新建并修改配置文件

```shell
vi /mongodb/single/mongod.conf
```

#### 配置文件的内容:

```yaml
systemLog:
    #MongoDB发送所有日志输出的目标指定为文件
    # #The path of the log file to which mongod or mongos should send all diagnostic logging information
    destination: file
    #mongod或mongos应向其发送所有诊断日志记录信息的日志文件的路径
    path: "/mongodb/single/log/mongod.log"
    #当mongos或mongod实例重新启动时，mongos或mongod会将新条目附加到现有日志文件的末尾。
    logAppend: true
storage:
    #mongod实例存储其数据的目录。storage.dbPath设置仅适用于mongod。
    ##The directory where the mongod instance stores its data.Default Value is "/data/db".
    dbPath: "/mongodb/single/data/db"
    journal:
        #启用或禁用持久性日志以确保数据文件保持有效和可恢复。
        enabled: true
processManagement:
    #启用在后台运行mongos或mongod进程的守护进程模式。
    fork: true
net:
    #服务实例绑定的IP，默认是localhost
    bindIp: localhost,192.168.0.2
    #bindIp
    #绑定的端口，默认是27017
    port: 27017

```

### 2.4.5 启动MongoDB服务

```shell
/usr/local/mongodb/bin/mongod -f /mongodb/single/mongod.conf

about to fork child process, waiting until server is ready for connections.
forked process: 90384
child process started successfully, parent exiting
```

#### 注意： 

如果启动后不是 successfully ，则是启动失败了。原因基本上就是配置文件有问题。

2.4.6 远程连接，连不上的问题

```shell
#查看防火墙状态
systemctl status firewalld
#临时关闭防火墙
systemctl stop firewalld
#开机禁止启动防火墙
systemctl disable firewalld
```

