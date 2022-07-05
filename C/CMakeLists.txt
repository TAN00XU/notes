cmake_minimum_required(VERSION 3.21)
project(test C)
set(CMAKE_C_STANDARD 99)

#递归所有的c文件
file (GLOB_RECURSE files *.c)

#add_executable(test com.tan00xu.test/main.c)
#add_executable(一百以内的奇数偶数之和 com.tan00xu.test/一百以内的奇数偶数之和.c)
#add_executable(test1 com.tan00xu.test/数字倒序输出.c)
#add_executable(test3 com.tan00xu.test/一百以内的奇数偶数之和.c)


#file (GLOB_RECURSE files *.c)
#file (GLOB files *.c */*.c */*/*.c)
#foreach (file ${files})
#    string(REGEX REPLACE ".+/(.+)/(.+)\\..*" "\\1-\\2" exe ${file})
#    add_executable (${exe} ${file} )
#endforeach ()

#[\\u4e00-\\u9fa5_a-zA-Z0-9]+

# 遍历项目根目录下所有的 .c 文件
foreach (file ${files})
    string(REGEX REPLACE ".+/(.+)/(.+)\\.*" "\\1-\\2" exe ${file})
    add_executable (${exe} ${file} )
    message (\ \ \ \ --\ src/${exe}.c\ will\ be\ compiled\ to\ bin/${exe})
endforeach ()

## 获取cpp文件相对于当前工作路径的相对路径，即文件名
## 工作路径${CMAKE_CURRENT_SOURCE_DIR}就是CMakeList.txt所在的文件夹
#file (GLOB files RELATIVE ${CMAKE_CURRENT_SOURCE_DIR} *.c)
##file (GLOB_RECURSE files *.c)
## 遍历每个文件名
#foreach (file ${files})
#    # 将去掉后缀的文件名存入exe变量（executable的缩写，不是代表.exe）
#    string(REGEX REPLACE "(.+).c" "\\1" exe ${file})
#    # 分别生成add_executable(<name> <source>)命令
#    add_executable (${exe} ${file})
#endforeach ()
