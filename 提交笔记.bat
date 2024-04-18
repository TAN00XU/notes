%开关回响on/off%
echo on
title bat批处理执行git命令
E:
cd D:\RealDream\Documents\Code\notes
git add .
git commit -m %date:~0,4%年%date:~5,2%月%date:~8,2%日%time:~0,2%时%time:~3,2%分%time:~6,2%秒%time:~9,2%
git push gitee master
git push github master
%暂停命令防止cmd直接关闭，便于查看执行情况%
pause