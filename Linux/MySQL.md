# MySQL 远端连接需要更改权限

```mysql
use mysql

update user set host='%' where user='root'

flush privileges;
```

