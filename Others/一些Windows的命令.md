# 一些Windows的命令

## 生成哈希值

```shell
certutil -hashfile 文件地址 md5
```

## Bat自动执行git命令

```bash
%开关回响on/off%
echo on
title bat批处理执行git命令
E:
cd E:/TAN00XU/Documents/Notes
git add .
git commit -m %date:~0,4%年%date:~5,2%月%date:~8,2%日%time:~0,2%时%time:~3,2%分%time:~6,2%秒%time:~9,2%
git push notes master
%暂停命令防止cmd直接关闭，便于查看执行情况%
pause
```

## git-GUI汉化

[git-GUI汉化]([stayor/git-gui-zh (github.com)](https://github.com/stayor/git-gui-zh))
