# 一、Hello GoLang

```go
package main

import "fmt" //导入系统包fmt用来输出

func main() { //main主函数 程序入口
   fmt.Println("Hello world")
}
```

# 二、Golang执行流程

```mermaid
graph LR
    id(源文件 .go文件)--go build 编译-->id1(可执行文件 .exe文件)--运行-->id2(执行结果)
    

```

 或者

```mermaid
graph LR
     id(源文件 .go文件)--go run 编译运行一步-->id2(执行结果)
```

# 二、注释

## 2.1 单行注释

```go
// 这是单行注释
```

## 2.2 多行注释

```go
 /*
     这是多行注释
 */
```



# 三、变量
