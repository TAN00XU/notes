[toc]

官网 : [Home - Docker](https://www.docker.com/)

# 一、安装与拆卸

[帮助文档](https://docs.docker.com/engine/install/centos/)

## 安装

```shell
# 1. 卸载旧的版本
 sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
                  
# 2. 需要的安装包
sudo yum install -y yum-utils

# 3. 设置镜像仓库
# 国外镜像
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
# 阿里云镜像
sudo yum-config-manager \
     --add-repo \
     https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
   
# 更新域名软件包索引
yum makecache fast

# 4. 安装docker相关 docker-ce社区版 ee企业版
sudo yum install docker-ce docker-ce-cli containerd.io docker-compose-plugin

# 5.启动docker
sudo systemctl start docker

# 6. 看是否安装成功
docker version

# 7. hello-world 验证Docker引擎是否正确安装
sudo docker run hello-world

```



## 卸载

```shell
# 1. 卸载依赖
sudo yum remove docker-ce docker-ce-cli containerd.io docker-compose-plugin

# 2. 删除资源
sudo rm -rf /var/lib/docker
sudo rm -rf /var/lib/containerd

# /var/lib/docker docker的默认工作路径
```



# 二、Docker的常用命令



## 2.1、帮助命令

```shell
docker version          #查看docker的版本信息
docker info             #查看docker的系统信息,包括镜像和容器的数量
docker 命令 --help       #帮助命令(可查看可选的参数)
docker COMMAND --help
```

命令行帮助文档地址（Command-line reference）：https://docs.docker.com/reference/



## 2.2、镜像命令



```shell
[root@tan00xu ~]# docker images
REPOSITORY    TAG       IMAGE ID       CREATED         SIZE
hello-world   latest    feb5d9fea6a5   12 months ago   13.3kB

#解释:
1.REPOSITORY  镜像的仓库源

2.TAG  镜像的标签

3.IMAGE ID 镜像的id

4.CREATED 镜像的创建时间

5.SIZE 镜像的大小


# 可选参数

-a , --all 列出所有镜像

-q , --quiet 只显示镜像的id
```



## 2.3、**docker search** 搜索镜像

```shell
[root@tan00xu ~]# docker search mysql

[root@linuxlearn ~]# docker search mysql
NAME                            DESCRIPTION                                     STARS     OFFICIAL   AUTOMATED
mysql                           MySQL is a widely used, open-source relation…   13206     [OK]
mariadb                         MariaDB Server is a high performing open sou…   5048      [OK]
phpmyadmin                      phpMyAdmin - A web interface for MySQL and M…   629       [OK]
percona                         Percona Server is a fork of the MySQL relati…   586       [OK]
bitnami/mysql                   Bitnami MySQL Docker Image                      77                   [OK]


```

