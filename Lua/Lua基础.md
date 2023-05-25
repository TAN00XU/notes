

# Lua基础

> lua在线测试 <https://wiki.luatos.com/_static/luatos-emulator/lua.html>

> Lua 5.3 参考手册 - 目录 <https://www.runoob.com/manual/lua53doc/contents.html#index>



## 一、注释




###### 1.1 单行注释

```lua
-- 单行注释
```

###### 1.2 多行注释

```l\ua
--[[
 多行注释
 多行注释
--]]
```



## 二、命名规范

1. Lua 标示符用于定义一个变量，函数获取其他用户定义的项。
2. 标示符以一个字母 A 到 Z 或 a 到 z 或下划线 **_** 开头后加上 0 个或多个字母，下划线，数字（0 到 9）。
3. 最好不要使用下划线加大写字母的标示符，因为Lua的保留字也是这样的。
4. Lua 不允许使用特殊字符如 **@**, **$**, 和 **%** 来定义标示符。 
5. Lua 是一个区分大小写的编程语言。



## 三、关键字

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

## 四、变量作用域

###### 4.1 全局变量

以下两种都是全局的

```lua
global = "";
function global()
    ---
end
```

###### 4.2 局部变量

我们可以使用`local`标志来新建临时变量，使用`local`创建一个局部变量，与全局变量不同，局部变量只在被声明的那个代码块内有效。

```lua
function add()
    local n = a+2
    print(n)
end
```

`n`就是一个局部变量，它只在`这个funcion`中有效，并且函数运行完后会自动回收这部分的内存。

> 尽可能的使用局部变量，以方便lua虚拟机自动回收内存空间，同时减少资源占用提高运行速度。



## 五、数据类型

### 5.1 八种数据类型

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



> 注意: Lua中只有`nil`和`false`为假，其它都为真，包括`空字符串`和`0值`



### 5.2 使用type函数测试给定变量或者值的类型

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



## 六、运算符



### 6.1 数学运算符

设定 A 的值为10，B 的值为 20：

| 操作符 | 描述                 | 实例                |
| :----- | :------------------- | :------------------ |
| +      | 加法                 | A + B 输出结果 30   |
| -      | 减法                 | A - B 输出结果 -10  |
| *      | 乘法                 | A * B 输出结果 200  |
| /      | 除法                 | B / A 输出结果 2    |
| %      | 取余                 | B % A 输出结果 0    |
| ^      | 乘幂                 | A^2 输出结果 100    |
| -      | 负号                 | -A 输出结果 -10     |
| //     | 整除运算符(>=lua5.3) | **5//2** 输出结果 2 |



### 6.2 关系运算符

设定 A 的值为10，B 的值为 20：

| 操作符 | 描述                                                         | 实例                  |
| :----- | :----------------------------------------------------------- | :-------------------- |
| ==     | 等于，检测两个值是否相等，相等返回 true，否则返回 false      | (A == B) 为 false。   |
| ~=     | 不等于，检测两个值是否相等，不相等返回 true，否则返回 false  | (A ~= B) 为 true。    |
| >      | 大于，如果左边的值大于右边的值，返回 true，否则返回 false    | (A > B) 为 false。    |
| <      | 小于，如果左边的值大于右边的值，返回 false，否则返回 true    | (A < B) 为 true。     |
| >=     | 大于等于，如果左边的值大于等于右边的值，返回 true，否则返回 false | (A >= B) 返回 false。 |
| <=     | 小于等于， 如果左边的值小于等于右边的值，返回 true，否则返回 false | (A <= B) 返回 true。  |



### 6.3 逻辑运算符

设定 A 的值为 true，B 的值为 false：

| 操作符 | 描述                                                         | 实例                   |
| :----- | :----------------------------------------------------------- | :--------------------- |
| and    | 逻辑与操作符。 若 A 为 false，则返回 A，否则返回 B。         | (A and B) 为 false。   |
| or     | 逻辑或操作符。 若 A 为 true，则返回 A，否则返回 B。          | (A or B) 为 true。     |
| not    | 逻辑非操作符。与逻辑运算结果相反，如果条件为 true，逻辑非为 false。 | not(A and B) 为 true。 |



### 6.3 其他运算符

| 操作符 | 描述                               | 实例                                                         |
| :----- | :--------------------------------- | :----------------------------------------------------------- |
| ..     | 连接两个字符串                     | a..b ，其中 a 为 "Hello " ， b 为 "World", 输出结果为 "Hello World"。 |
| #      | 一元运算符，返回字符串或表的长度。 | #"Hello" 返回 5                                              |



#### 6.3.1 运算符`#`取长度问题

lua的table可以用数字或字符串等作为key， #号得到的是用整数作为索引的最开始连续部分的大小

```lua
tab1 = {"1","2"}
print("tab1长度"..#tab1)
tab2 = {key1="1","2"}
print("tab2长度"..#tab2)
tab3 = {}
tab3[1]="1"
tab3[2]="2"
tab3[4]="4"
print("tab3长度"..#tab3)

-- tab1长度2
-- tab2长度1
-- tab3长度2

local tab = {}
tab[1] = 1
tab[2] = 2
tab[3] = nil
print(#tab)
--结果为2

local tab2 = {}
tab2[1] = nil
tab2[2] = 2
tab2[3] = 3
print(#tab2)
--结果为0
```

如果table的第一个元素key为非数字，那么#tb获取到的长度也是0

```lua
local tab1 = {}
tab1["1"] = 1
tab1["2"] = 2
tab1["3"] = 3
print(#tab1)
--结果为0
```



==在平时开发过程中不建议直接使用`#`来直接获取table的元素个数==

可使用该封装方法:

```lua
function table.length(t)
    local i = 0
    for k, v in pairs(t) do
        i = i + 1
    end
    return i
end
```





### 6.4 运算符优先级

从高到低的顺序：

```lua
^
not    - (unary)
*      /       %
+      -
..
<      >      <=     >=     ~=     ==
and
or
```

==除了 **^** 和 **..** 外所有的二元运算符都是左连接的==

```lua
a+i < b/2+1          <-->       (a+i) < ((b/2)+1)
5+x^2*8              <-->       5+((x^2)*8)
a < y and y <= z     <-->       (a < y) and (y <= z)
-x^2                 <-->       -(x^2)
x^y^z                <-->       x^(y^z)
```



## 七、流程控制

Lua 提供了以下控制结构语句：

| 语句                   | 描述                                                         |
| :--------------------- | :----------------------------------------------------------- |
| if 语句                | **if 语句** 由一个布尔表达式作为条件判断，其后紧跟其他语句组成。 |
| if...else 语句         | **if 语句** 可以与 **else 语句**搭配使用, 在 if 条件表达式为 false 时执行 else 语句代码。 |
| if...elseif...else语句 | 当**if语句**的判断条件不成立时执行**elseif语句**的判断条件，可以多个**elseif语句**连续判断，**else语句**可以省略，当且仅当上面所有的**if语句**和**elseif语句**的判断条件都不成立时执行**else语句**中的代码。<br />在**if...elseif...else语句**中，从上到下执行，只要有一个条件满足后，就会短路，不再执行之后的语句。 |
| if 嵌套语句            | 你可以在**if** 或 **else if**中使用一个或多个 **if** 或 **else if** 语句 。 |




### 7.1 if语句

**if 语句语法格式如下：**

```lua
if (布尔表达式) then
   --[ 在布尔表达式为 true 时执行的语句 --]
end
```



### 7.2 if...else 语句

 **if...else 语句语法格式如下：**

```lua
if (布尔表达式) then
   --[ 布尔表达式为 true 时执行该语句块 --]
else
   --[ 布尔表达式为 false 时执行该语句块 --]
end
```



### 7.3 if...elseif...else 语句

**if...elseif...else 语句语法格式如下：**

```lua
if (布尔表达式 1) then
   --[ 在布尔表达式 1 为 true 时执行该语句块 --]

elseif (布尔表达式 2) then
   --[ 在布尔表达式 2 为 true 时执行该语句块 --]
elseif (布尔表达式 3) then
   --[ 在布尔表达式 3 为 true 时执行该语句块 --]
else 
   --[ 如果以上布尔表达式都不为 true 则执行该语句块 --]
end
```

**示例：**

```lua
--[ 定义变量 --]
a = 100
--[ 检查布尔条件 --]
if (a > 100)  then
   --[ 如果条件为 true 打印以下信息 --]
   print("a 大于 100")
elseif a > 90 then
   --[ if else if 条件为 true 时打印以下信息 --]
   print("a 大于 90")
elseif( a > 80 )then
   --[ if else if condition 条件为 true 时打印以下信息 --]
   print("a 大于 80")
else
   --[ 以上条件语句没有一个为 true 时打印以下信息 --]
   print("a不大于以上值" )
end

--输出-- a 大于 90
```



### 7.4 if 嵌套语句

**if 嵌套语句语法格式如下：**

```lua
if( 布尔表达式 1)then
   --[ 布尔表达式 1 为 true 时执行该语句块 --]
   if(布尔表达式 2)then
      --[ 布尔表达式 2 为 true 时执行该语句块 --]
   end
end
```



## 八、循环

Lua 语言提供了以下几种循环处理方式：

| 循环类型       | 描述                                                         |
| :------------- | :----------------------------------------------------------- |
| while 循环     | 在条件为 true 时，让程序重复地执行某些语句。执行语句前会先检查条件是否为 true。 |
| for 循环       | 重复执行指定语句，重复次数可在 for 语句中控制。              |
| repeat...until | 重复执行循环，直到 指定的条件为真时为止                      |
| 循环嵌套       | 可以在循环内嵌套一个或多个循环语句（while do ... end;for ... do ... end;repeat ... until;） |

> while 循环中，条件不成立时，结束循环
>
> repeat...until中，条件成立时，结束循环



Lua 支持以下循环控制语句：

| 控制语句   | 描述                                             |
| :--------- | :----------------------------------------------- |
| break 语句 | 退出当前循环或语句，并开始脚本执行紧接着的语句。 |
| goto 语句  | 将程序的控制点转移到一个标签处。                 |



### 8.1 while 循环

**while 循环语法：**

```lua
while(condition)do
   -- 语句 statements
end
```

在 **condition(条件)** 为 **true **时执行循环体语句



### 8.2 repeat...until循环

 **repeat...until 循环语法格式：**

```lua
repeat
    -- 语句 statements
until( condition )
```

循环条件判断语句（condition）在循环体末尾部分，所以在条件进行判断前循环体都会执行一次。

如果条件判断语句（condition）为 **false**，循环会重新开始执行，直到条件判断语句（condition）为 **true **才会停止执行



### 8.3 for 循环

```mermaid
graph LR
 A(Lua的for循环)-->B>数值for循环]
 A-->C>泛型for循环]
```



#### 8.3.1 数值for循环

**数值 for 循环语法格式：**

```lua
for var=exp1,exp2,exp3 do  
    --执行语句  
end  

for 变量名=初始值,结束值,步长(默认值为1，可省略) do  
    --执行语句  
end  
```

expression可以是函数

for的三个表达式在循环开始前一次性求值，以后不再进行求值。f(x)只会在循环开始前执行一次

```lua
function f1(x)
    print("function1")  
    return x
end

function f2(x)  
    print("function2")  
    return x*2  
end  

for i=f1(1),f2(5) do 
    print(i)  
end

--输出--
function1
function2
1
2
3
4
5
6
7
8
9
10
```



#### 8.3.2 泛型for循环

泛型 for 循环通过一个迭代器函数来遍历所有值，类似 java 中的 foreach 语句。

**泛型 for 循环语法格式：**

```lua
--打印数组a的所有值  
aTable = {"one", "two", "three"}
for i, v in ipairs(aTable) do
    print(i, v)
end 

--输出--
1	one
2	two
3	three
```



```mermaid
graph LR
 A(迭代函数)-->B>ipairs]
 A-->C>pairs]
 ipairs["顺序遍历，中间的序号不能断开，从下标为1开始遍历，然后下标累加1，如果某个下标元素不存在就终止遍历\n如果下标不连续或者不是从1开始的表就会中断或者遍历不到元素\n遇到k=v键值对会直接跳过,遇到第一个nil就会直接终止\n一般情况下，用于数值类型的集合遍历，如{1,2,3}\n"]
 pairs["遇到nil会跳过\n同时适用于数组类型和k=v键值对\n可以混搭，但是在混搭时优先获取数组类型的数据"]
 B-->ipairs
 C-->pairs
 
```

> pairs的适用范围大于ipairs
>
> 不确定用什么的时候，优先选pairs



+ ipairs

  

  ```lua
  for i, v in ipairs({1,2,nil,3,4,5}) do
      print(i, v)
  end 
  --输出--
  1	1
  2	2
  
  for i, v in ipairs({"TX",1,2,3,4,5}) do
      print(i, v)
  end 
  --输出--
  1	TX
  2	1
  3	2
  4	3
  5	4
  6	5
  
  for i, v in ipairs({name="TX",1,2,3,4,5}) do
      print(i, v)
  end 
  --输出--
  1	TX
  2	1
  3	2
  4	3
  5	4
  6	5
  ```

  

+ pairs

  

  ```lua
  for k, v in pairs({1,2,3,4,5}) do
      print(k, v)
  end 
  --输出--
  1	1
  2	2
  3	3
  4	4
  5	5
  
  for k, v in pairs({"TX",1,2,3,4,5}) do
      print(k, v)
  end 
  --输出--
  1	TX
  2	1
  3	2
  4	3
  5	4
  6	5
  
  for k, v in pairs({name="TX",1,2,3,4,5}) do
      print(k, v)
  end 
  --输出--
  1	1
  2	2
  3	3
  4	4
  5	5
  name	TX
  ```

  



### 8.4 循环嵌套

示例

```lua
for i = 1, 9 do
    for j = 1, i do
        io.write(string.format("%d*%d=%d ", j, i, i * j))
        --io.write(j, "*", i, "=", i * j, "\t")
    end
    io.write("\n")
end
--输出--
1*1=1 
1*2=2 2*2=4 
1*3=3 2*3=6 3*3=9 
1*4=4 2*4=8 3*4=12 4*4=16 
1*5=5 2*5=10 3*5=15 4*5=20 5*5=25 
1*6=6 2*6=12 3*6=18 4*6=24 5*6=30 6*6=36 
1*7=7 2*7=14 3*7=21 4*7=28 5*7=35 6*7=42 7*7=49 
1*8=8 2*8=16 3*8=24 4*8=32 5*8=40 6*8=48 7*8=56 8*8=64 
1*9=9 2*9=18 3*9=27 4*9=36 5*9=45 6*9=54 7*9=63 8*9=72 9*9=81 
```



### 8.5 break语句

Lua 编程语言 break 语句插入在循环体中，用于退出当前循环或语句，并开始脚本执行紧接着的语句。

如果你使用循环嵌套，break语句将停止最内层循环的执行，并开始执行的外层的循环语句。

```lua
--[ 定义变量 --]
a = 10

--[ while 循环 --]
while (a < 20) do
    print("a 的值为:", a)
    a = a + 1
    if (a > 15) then
        --[ 使用 break 语句终止循环 --]
        break
    end
end
--输出--
a 的值为:	10
a 的值为:	11
a 的值为:	12
a 的值为:	13
a 的值为:	14
a 的值为:	15
```



### 8.6  goto 语句

Lua 语言中的 goto 语句允许将控制流程无条件地转到被标记的语句处。

语法格式如下所示：

```lua
goto Label
```

Label 的格式为：

```lua
:: Label ::
```



示例

```lua
local a = 1
:: label ::
print("--- goto label ---" .. a)

a = a + 1
if a < 3 then
    goto label   -- a 小于 3 的时候跳转到标签 label
end
--输出--
--- goto label ---1
--- goto label ---2
```

```lua
for i=1, 3 do
    if i <= 2 then
        print(i, "yes continue")
        goto continue
    end
    print(i, " no continue")
    ::continue::
    print([[i'm end]])
end
--输出--
1   yes continue
i'm end
2   yes continue
i'm end
3    no continue
i'm end
```



#### label不可见原则

**代码块**：`do ... end`



1. 不能从外面`goto`到代码块里面去，因为代码块里面的`lable`，对外面的`goto`来说是不可见的。
   
   
   ```lua
   goto label;
   do
       :: label :: ;
       print("Hello, world!");
   end
   print("END")
   --输出--
   no visible label 'label' for <goto> at line 1
   ```

   
   
2. 不能跳出或跳入一个函数，因为函数也是一个block(块)
   
   
   ```lua
   function func()
       :: label :: ;
       print("func");
   end
   
   print("Hello World");
   func();
   goto label;
   --输出--
   no visible label 'label' for <goto> at line 8
   ```
   
   
   
   ```lua
   function func()
       print("func");
       goto label;
   end
   
   func();
   :: label :: ;
   print("Hello World");
   --输出--
   no visible label 'label' for <goto> at line 3
   ```
   
   
   
3. 不能跳入本地变量作用域
   
   
   ```lua
   do
       print("Hello World");
       goto label;
       local a = 1;
       print(a);
       :: label ::
       print("本地变量作用域");
   end
   --输出--
   <goto label> at line 3 jumps into the scope of local 'a'
   
   --goto在本地变量作用域内可以跳转
   do
       print("Hello World");
       local a = 1;
       print(a);
       :: label ::
       print("本地变量作用域");
       goto label;
   end
   --输出--
   --[[死循环]]--
   ```

   

   

## 九、表Table常用api

   

### 9.1 `table.concat(list[, sep [, i [, j]]])`

将数组中的元素拼接成一个字符串

返回字符串 `list[i]..sep..list[i+1] ··· sep..list[j]`

+ `separation` 默认为空字符串
+ `i` 默认值为1
+ `j` 默认值为`#list`
+ 如果 `i` 比 `j` 大，返回空串

   

### 9.2 `table.insert (list, [pos,] value)`

向指定位置插入元素，默认插入到最后

   在 `list` 的位置 `pos` 处插入元素 `value` ， 并后移元素 `list[pos], list[pos+1], ···, list[#list]`

+ `position`的默认值为 `#list+1`。直接调用 `table.insert(t,x)` 会将 `x` 插在列表 `t` 的末尾

   

### 9.3 `table.remove (list [, pos])`

删除数组中的元素，默认删除最后一个

移除 `list` 中 `pos` 位置上的元素，并返回这个被**移除的值**，其后的元素会被前移。

+ `pos` 默认为 `#list`， 因此调用 `table.remove(l)` 将移除表 `l` 的最后一个元素



### 9.4 `table.move(a1,f,e,t[,a2])` 

把表a1中从下标f到e的value移动到表a2中，位置为a2下标从t开始

+ `a2` 默认值为`a1`

```lua
local table1 = { 1, 2, 3, 4, 5 };

local table2 = { "TX" };
table.move(table1, 1, 5, 2, table2);

print(table.concat(table1, "-"));
print(table.concat(table2, "-"));
--输出--
1-2-3-4-5
TX-1-2-3-4-5
```



### 9.5 `table.sort (list [, comp])`

数组排序，默认从小到大，可自定义排序规则

+ 在表内从 `list[1]` 到 `list[#list]` *原地* 对其间元素按指定次序排序，直接操作原表无返回值
+  如果提供了 `comp` ， 它必须是一个可以接收两个列表内元素为参数的函数。
+ 如果没有提供 `comp`， 将使用标准 Lua 操作 `<` 作为替代品。及**从小到大**排序。

```lua
local myTable = { 5, 4, 1, 3, 2 }
table.sort(myTable)
print(table.concat(myTable, "-"))
--输出--
1-2-3-4-5
```

```lua
local myTable = { 5, 4, 1, 3, 2 }
function desc(a, b)
    return a > b
end
table.sort(myTable, desc)
print(table.concat(myTable, "-"))
--输出--
5-4-3-2-1
```



## 十、String常用api

### 10.1 字符串，转义字符

Lua 语言中字符串可以使用以下三种方式来表示：

- 单引号间的一串字符。
- 双引号间的一串字符。
- **[[** 与 **]]** 间的一串字符。

义字符用于表示不能直接显示的字符，比如后退键，回车键，等。如在字符串转换双引号可以使用 "\""。

所有的转义字符和所对应的意义：

| 转义字符 | 意义                                | ASCII码值（十进制） |
| -------- | ----------------------------------- | ------------------- |
| \a       | 响铃(BEL)                           | 007                 |
| \b       | 退格(BS) ，将当前位置移到前一列     | 008                 |
| \f       | 换页(FF)，将当前位置移到下页开头    | 012                 |
| \n       | 换行(LF) ，将当前位置移到下一行开头 | 010                 |
| \r       | 回车(CR) ，将当前位置移到本行开头   | 013                 |
| \t       | 水平制表(HT) （跳到下一个TAB位置）  | 009                 |
| \v       | 垂直制表(VT)                        | 011                 |
| \\       | 代表一个反斜线字符''\'              | 092                 |
| \'       | 代表一个单引号（撇号）字符          | 039                 |
| \"       | 代表一个双引号字符                  | 034                 |
| \0       | 空字符(NULL)                        | 000                 |
| \ddd     | 1到3位八进制数所代表的任意字符      | 三位八进制          |
| \xhh     | 1到2位十六进制所代表的任意字符      | 二位十六进制        |



### 10.2 `string.upper (s)`

接收一个字符串，将其中的小写字符都转为大写后返回其副本。 其它的字符串不会更改。 对小写字符的定义取决于当前的区域设置。

```lua
local s = "Hello World";
print(string.upper(s));
--输出--
HELLO WORLD
```



### 10.3 `string.lower (s)`

接收一个字符串，将其中的大写字符都转为小写后返回其副本。 其它的字符串不会更改。 对大写字符的定义取决于当前的区域设置。

```lua
local s = "Hello World";
print(string.lower(s));
--输出--
hello world
```



### 10.4 `string.len (s)`

接收一个字符串，返回其长度。 空串 `""` 的长度为 0 。 内嵌零也统计在内，因此 `"a\000bc\000"` 的长度为 5 。

```lua
local s = "Hello World";
print(string.len(s));
--输出--
11
```

 

### 10.5 `string.reverse (s)`

返回字符串 `s` 的翻转串。

```lua
local s = "Hello World";
print(string.reverse(s))
--输出--
dlroW olleH
```



### 10.6 连接符`..`

字符串连接符

```lua
print("Hello" .. "World")
--输出--
HelloWorld
```



### 10.7 `string.sub (s, i [, j])`

截取字符串

- s：要截取的字符串。
- i：截取开始位置。
- j：截取结束位置，默认为 -1，最后一个字符。

+ 返回 `s` 的子串， 该子串从 `i` 开始到 `j` 为止； `i` 和 `j` 都可以为负数。 
+ 如果不给出 `j` ，就当它是 -1 （和字符串长度相同）。 特别是， 调用 `string.sub(s,1,j)` 可以返回 `s` 的长度为 `j` 的前缀串， 而 `string.sub(s, -i)` 返回长度为 `i` 的后缀串。
+ 如果在对负数索引转义后 `i` 小于 1 的话，就修正回 1 。 如果 `j` 比字符串的长度还大，就修正为字符串长度。 如果在修正之后，`i` 大于 `j`， 函数返回空串。

```lua
local s = "Hello World";
print("原始字符串", "\'" .. s .. "\'", "字符串长度", string.len(s));
print("第一次截取", string.sub(s, 1, 4));
print("第二次截取", string.sub(s, 1, -1));
print("第三次截取", string.sub(s, 1, 22));
print("第四次截取", string.sub(s, 5, 11));
print("第五次截取", string.sub(s, 7));
print("第六次截取", string.sub(s, 7, -1));
print("第七次截取", string.sub(s, 7, -3));
print("第八次截取", string.sub(s, -5));
print("第九次截取", string.sub(s, -5, -1));
print("第十次截取", string.sub(s, -5, -3));
print("第十一次截取", string.sub(s, -11));
print("第十二次截取", string.sub(s, -22));
print("第十三次截取", string.sub(s, -22, -5));

--输出--
原始字符串	'Hello World'	字符串长度	11
第一次截取	Hell
第二次截取	Hello World
第三次截取	Hello World
第四次截取	o World
第五次截取	World
第六次截取	World
第七次截取	Wor
第八次截取	World
第九次截取	World
第十次截取	Wor
第十一次截取	Hello World
第十二次截取	Hello World
第十三次截取	Hello W
```



### 10.8 `string.find (s, pattern [, init [, plain]])`

+ 在一个指定的目标字符串 `s`中搜索指定的内容 `pattern `，如果找到了一个匹配的子串，就会返回这个子串的起始索引和结束索引，不存在则返回 nil。

+ **init** 指定了搜索的起始位置，默认为 1，可以一个负数，表示从后往前数的字符个数。

+ **plain** 表示是否使用简单模式，默认为 false，true 只做简单的查找子串的操作，false 表示使用正则模式匹配。

```lua
print(string.find("Hello Lua user", "Lua", 1));
--输出--
7    9

print(string.find("Hello Lua user", "%w+", 1, false));
--输出--
1	5
```



### 10.9 `string.gsub (s, pattern, repl [, n])`

将字符串 `s` 中，所有的（或是在 `n` 给出时的前 `n` 个） `pattern` 都替换成 `repl` ，并返回其副本。 `repl` 可以是字符串、表、或函数。 `gsub` 还会在第二个返回值返回一共发生了多少次匹配。 `gsub` 这个名字来源于 *Global SUBstitution* 。

```lua
-- 全部替换
print(string.gsub("TTTT", "T", "X"))
--输出--
XXXX	4

--替换3次
print(string.gsub("TTTT", "T", "X", 3))
--输出--
XXXT	3
```



```lua
print(string.gsub("hello world", "(%w+)", "%1 %1"))
--输出--
hello hello world world	2
-----------------------------------
print(string.gsub("hello world", "%w+", "%0 %0", 1))
--输出--
hello hello world	1
-----------------------------------
print(string.gsub("hello world from Lua", "(%w+)%s*(%w+)", "%2 %1"))
--输出--
world hello Lua from	2
-----------------------------------
print(string.gsub("4+5 = $return 4+5$", "%$(.-)%$",
        function(s)
            return load(s)() --将字符串 s 转换为函数，然后执行这个函数，返回函数的返回值
        end)
)
--输出--
4+5 = 9	1
-----------------------------------
-- 使用 load() 函数加载字符串并编译为函数
local func = load("print('Hello, World!')")
-- 调用刚刚生成的函数
func()
--输出--
Hello, World!
-----------------------------------
local t = { name = "lua", version = "5.3" }
print(string.gsub("$name-$version.tar.gz", "%$(%w+)", t))
--输出--
lua-5.3.tar.gz	2
```



### 10.10 `string.byte (s [, i [, j]])`和`string.char (···)`

+  `byte `转换字符为整数值(可以指定某个字符，默认第一个字符)。 `i` 的默认值是 1 ； `j` 的默认值是 `i`。
+ `char `将整型数字转成字符并连接。接收零或更多的整数。 返回和参数数量相同长度的字符串。 其中每个字符的内部编码值等于对应的参数值

```lua
print(string.byte("ABCD"))
print(string.byte("ABCD", 2))
print(string.byte("ABCD", 1, 4))
--输出--
65
66
65	66	67	68

print(string.char(65, 66, 67, 68, 97, 98, 99, 100))
--输出--
ABCDabcd
```



### 10.11 `string.format (formatstring, ···)`

+ 返回不定数量参数的格式化版本， 格式化串为第一个参数（必须是一个字符串）。 
+ 格式化字符串遵循 ISO C 函数 `sprintf` 的规则。 不同点在于选项 `*`, `h`, `L`, `l`, `n`, `p` 不支持， 另外还增加了一个选项 `q`。 `q` 选项将一个字符串格式化为两个双引号括起，对内部字符做恰当的转义处理的字符串。

```lua
print(string.format("the value is:%d", 4))
--输出--
the value is:4

print(string.format('%q', 'a string with "quotes" and \n new line'))
--输出--
"a string with \"quotes\" and \
 new line"
```



### 10.12 `string.match (s, pattern [, init])`

+ 在字符串 `s` 中找到第一个能用 `pattern` 匹配到的部分。 如果能找到，`match` 返回其中的捕获物； 否则返回 **nil** 。 
+ 如果 `pattern` 中未指定捕获， 返回整个 `pattern` 捕获到的串。 
+ 第三个可选数字参数 `init` 指明从哪里开始搜索； 它默认为 1 且可以是负数。
