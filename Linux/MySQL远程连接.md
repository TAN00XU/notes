# docker 运行

```shell
docker run -itd --name mysql8 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123123 mysql
```



# MySQL 远端连接需要更改权限

```mysql
use mysql

update user set host='%' where user='root'

flush privileges;
```

