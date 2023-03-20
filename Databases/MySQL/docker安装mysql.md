# docker 安装MySQL

## 启动镜像

```shell
docker run -p 33068:3306 --name mysql8.0.29 -e MYSQL_ROOT_PASSWORD=123123  -d mysql:8.0.29
```

## 启动成功后，进入容器内部拷贝配置文件，到宿主主机

```shell
docker cp  mysql8.0.29:/etc/mysql /home/mysql/mysql8.0.29
```

## 删除mysql容器，重新创建容器

```shell
docker stop mysql
docker rm mysql
```



## shell脚本

```shell
#!/bin/sh
docker run \
-p 33068:3306 \
--name mysql8.0.29 \
--privileged=true \
--restart unless-stopped \
-v /home/mysql/mysql8.0.29/mysql:/etc/mysql \
-v /home/mysql/mysql8.0.29/logs:/logs \
-v /home/mysql/mysql8.0.29/data:/var/lib/mysql \
-v /etc/localtime:/etc/localtime \
-e MYSQL_ROOT_PASSWORD=123123 \
-d mysql:8.0.29 

# -p 端口映射
-p 33068:3306 \
--name mysql8.0.29 \
# --privileged=true  挂载文件权限设置
--privileged=true \
# 设置 开机后自动重启容器
--restart unless-stopped \
# 挂载配置文件
-v /home/mysql/mysql8.0.29/mysql:/etc/mysql \
# 挂载日志
-v /home/mysql/mysql8.0.29/logs:/logs \
# 挂载数据文件 持久化到主机
-v /home/mysql/mysql8.0.29/data:/var/lib/mysql \
# 容器时间与宿主机同步
-v /etc/localtime:/etc/localtime \
# 设置密码
-e MYSQL_ROOT_PASSWORD=123123 \
# 后台启动mysql
-d mysql:8.0.29 
```

```sh
sh mysql8.0.20.sh
```

