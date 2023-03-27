# 一、常用命令

| 命令名称                                                    | 作用      |
| ------------------------------------------------------- | ------- |
| git config --global user.name 用户名                       | 设置用户签名  |
| git config --global user.email 邮箱                       | 设置用户签名  |
| <span style="color:red">git init</span>                 | 初始化本地库  |
| <span style="color:red">git status</span>               | 查看本地库状态 |
| <span style="color:red">git add 文件名</span>              | 添加到暂存区  |
| <span style="color:red">git commit -m "日志信息" 文件名</span> | 提交到本地库  |
| <span style="color:red">git reflog</span>               | 查看历史记录  |
| <span style="color:red"> git reset --hard 版本号</span>    | 版本穿梭    |



# 二、分支操作

| 命令名称             | 作用             |
| ---------------- | -------------- |
| git branch  分支名  | 创建分支           |
| git branch -v    | 查看分支           |
| git checkout 分支名 | 切换分支           |
| git merge 分支名    | 把指定的分支合并到当前分支上 |





# 三、远程操作



| 命令名称                                | 作用                           |
| ----------------------------------- | ---------------------------- |
| git remote -v                       | 查看当前所有远程地址别名                 |
| git remote add 别名 远程地址              | 起别名                          |
| git push 别名 分支                      | 推送本地分支上的内容到远程仓库              |
| git clone 远程地址                      | 将远程仓库的内容克隆到本地                |
| git pull 远程库地址别名 远程分支名              | 将远程仓库对于分支最新内容拉下来后与当前本地分支直接合并 |
| git remote rename old-name new-name | 修改远程仓库别名                     |





# 四、Git配置多个SSH-Key

1. 生成gitee用的SSH-Key

```shell
$ ssh-keygen -t rsa -C 'xxxxx@company.com' -f ~/.ssh/gitee_id_rsa
```

2. 生成一个github用的SSH-Key

```shell
$ ssh-keygen -t rsa -C 'xxxxx@qq.com' -f ~/.ssh/github_id_rsa
```

3. 在 ~/.ssh 目录下新建一个*config*文件 (注意：文件名就叫config无任何尾缀)，添加如下内容（其中Host和HostName填写git服务器的域名，IdentityFile指定私钥的路径）

```
# gitee
Host gitee.com
HostName gitee.com
PreferredAuthentications publickey
IdentityFile ~/.ssh/gitee_id_rsa
# github
Host github.com
HostName github.com
PreferredAuthentications publickey
IdentityFile ~/.ssh/github_id_rsa
```

4. 用ssh命令分别测试

```shell
$ ssh -T git@gitee.com
$ ssh -T git@github.com
```





# Windows中文乱码解决办法

```shell
$ git config --global core.quotepath false          # 显示 status 编码
$ git config --global gui.encoding utf-8            # 图形界面编码
$ git config --global i18n.commit.encoding utf-8    # 提交信息编码
$ git config --global i18n.logoutputencoding utf-8    # 输出 log 编码
$ export LESSCHARSET=utf-8 (windows下为：set LESSCHARSET=utf-8)
```
