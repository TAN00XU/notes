> lua在线测试 [LuatOS 在线模拟 - lua在线测试](https://wiki.luatos.com/_static/luatos-emulator/lua.html)

# 一、注释


## 1.1 单行注释

```lua
-- 单行注释
```

## 1.2 多行注释

```l\ua
--[[
 多行注释
 多行注释
--]]
```



# 二、命名规范

1. Lua 标示符用于定义一个变量，函数获取其他用户定义的项。
2. 标示符以一个字母 A 到 Z 或 a 到 z 或下划线 **_** 开头后加上 0 个或多个字母，下划线，数字（0 到 9）。
3. 最好不要使用下划线加大写字母的标示符，因为Lua的保留字也是这样的。
4. Lua 不允许使用特殊字符如 **@**, **$**, 和 **%** 来定义标示符。 
5. Lua 是一个区分大小写的编程语言。



# 三、关键字

==以下列出了 Lua 的保留关键词。保留关键字不能作为常量或变量或其他用户自定义标示符：==

|          |       |       |        |
| -------- | ----- | ----- | ------ |
| and      | break | do    | else   |
| elseif   | end   | false | for    |
| function | if    | in    | local  |
| nil      | not   | or    | repeat |
| return   | then  | true  | until  |
| while    | goto  |       |        |

一般约定，以下划线开头连接一串大写字母的名字（比如 _VERSION）被保留用于 Lua 内部全局变量。

# 四、变量作用域

## 4.1 全局变量

以下两种都是全局的

```lua
global = "";
function global()
    ---
end
```

## 4.2 局部变量

我们可以使用`local`标志来新建临时变量，使用`local`创建一个局部变量，与全局变量不同，局部变量只在被声明的那个代码块内有效。

```lua
function add()
    local n = a+2
    print(n)
end
```

`n`就是一个局部变量，它只在`这个funcion`中有效，并且函数运行完后会自动回收这部分的内存。

> 尽可能的使用局部变量，以方便lua虚拟机自动回收内存空间，同时减少资源占用提高运行速度。



# 五、数据类型

## 5.1 八种数据类型

| 数据类型 | 描述                                                         |
| :------- | :----------------------------------------------------------- |
| nil      | 这个最简单，只有值nil属于该类，表示一个无效值（在条件表达式中相当于false）。 |
| boolean  | 包含两个值：false和true。                                    |
| number   | 表示双精度类型的实浮点数                                     |
| string   | 字符串由一对双引号或单引号来表示                             |
| function | 由 C 或 Lua 编写的函数                                       |
| userdata | 自定义数据格式，表示任意存储在变量中的C数据结构              |
| thread   | 表示执行的独立线路，用于执行协同程序                         |
| table    | Lua 中的表（table）其实是一个"关联数组"（associative arrays），数组的索引可以是数字、字符串或表类型。在 Lua 里，table 的创建是通过"构造表达式"来完成，最简单构造表达式是{}，用来创建一个空表。 |



## 5.2 使用type函数测试给定变量或者值的类型

`type(X)` 函数实质是返回的是字符串，是一个` string` 类型，做比较时应该使用`type(X)=="nil"`

```lua
print(type("Hello world"))      --> string
print(type(1*2))             --> number
print(type(print))              --> function
print(type(type))               --> function
print(type(true))               --> boolean
print(type(nil))                --> nil
print(type(type(X)))            --> string
```

