# Windows连接Linux并传输文件

#  一、查看Linux的ip

 打开Linux的终端输入ifconfig命令查看Linux的ip地址

`ifconfig`

找到12位ip地址

![ip](E:\TAN00XU\Documents\Notes\NotesImg\watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA6aWu5qKm,size_20,color_FFFFFF,t_70,g_se,x_16-16466174618082.png)

# 二、用window连接

打开Windows的cmd或终端

输入要远程登录的用户和Linux的ip地址

`ssh 用户名@你的ip地址`

![登录](E:\TAN00XU\Documents\Notes\NotesImg\watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA6aWu5qKm,size_20,color_FFFFFF,t_70,g_se,x_16.png)

![连接成功](E:\TAN00XU\Documents\Notes\NotesImg\watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA6aWu5qKm,size_20,color_FFFFFF,t_70,g_se,x_16-16466174994784.png)

# 三、文件传输

以下操是在退出ssh的情况下进行

## 下载

`scp username@servername:/path/filename /local(本地目录)`

scp 用户名@网络地址:[文件位置] [本地路径]

## 上传

`scp /path/filename username@servername:/path`

scp [本地文件位置] 用户名@网络地址:[远端路径]