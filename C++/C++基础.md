# C++基础



## 一、C++初识



### 1.1 Hello world

```c++
#include<iostream>
//  std命名空间
using namespace std;

int main() {

    //cout:std中的函数-字符输出 endl:换行
	cout << "Hello world" << endl;

    // 系统暂停
	system("pause");

	return 0;
}
```

以下写法效果同上

```c++
#include <iostream>

int main() {
    // "::"是作用域运算符
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
```



### 1.2 注释

**作用**：在代码中加一些说明和解释，方便自己或其他程序员程序员阅读代码

**两种格式**

1. **单行注释**：`// 单行注释` 
   - 通常放在一行代码的上方，或者一条语句的末尾，==对该行代码说明==
2. **多行注释**： `/* 多行注释 */`
   - 通常放在一段代码的上方，==对该段代码做整体说明==

> 提示：编译器在编译代码时，会忽略注释的内容



### 1.3 变量

**作用**：给一段指定的内存空间起名，方便操作这段内存

**语法**：`数据类型 变量名 = 初始值;`

**示例：**

```C++
#include<iostream>
using namespace std;

int main() {

	//变量的定义
	//语法：数据类型  变量名 = 初始值

	int a = 10;

	cout << "a = " << a << endl;
	
	system("pause");

	return 0;
}
```



> 注意：C++在创建变量时，必须给变量一个初始值，否则会报错





### 1.4 常量

**作用**：用于记录程序中不可更改的数据

C++定义常量两种方式

1. **\#define** 宏常量： `#define 常量名 常量值`
   * ==通常在文件上方定义==，表示一个常量


2. **const**修饰的变量 `const 数据类型 常量名 = 常量值`
   * ==通常在变量定义前加关键字const==，修饰该变量为常量，不可修改



**示例：**

```C++
//1、宏常量
#define day 7

int main() {

	cout << "一周里总共有 " << day << " 天" << endl;
	//day = 8;  //报错，宏常量不可以修改

	//2、const修饰变量
	const int month = 12;
	cout << "一年里总共有 " << month << " 个月份" << endl;
	//month = 24; //报错，常量是不可以修改的
	
	
	system("pause");

	return 0;
}
```



### 1.5 关键字

**作用：**关键字是C++中预先保留的单词（标识符）

* **在定义变量或者常量时候，不要用关键字**



**C++关键字如下：**

|            |              |                  |             |          |
| ---------- | ------------ | ---------------- | ----------- | -------- |
| asm        | do           | if               | return      | typedef  |
| auto       | double       | inline           | short       | typeid   |
| bool       | dynamic_cast | int              | signed      | typename |
| break      | else         | long             | sizeof      | union    |
| case       | enum         | mutable          | static      | unsigned |
| catch      | explicit     | namespace        | static_cast | using    |
| char       | export       | new              | struct      | virtual  |
| class      | extern       | operator         | switch      | void     |
| const      | false        | private          | template    | volatile |
| const_cast | float        | protected        | this        | wchar_t  |
| continue   | for          | public           | throw       | while    |
| default    | friend       | register         | true        |          |
| delete     | goto         | reinterpret_cast | try         |          |



> 在给变量或者常量起名称时候，不要用C++得关键字，否则会产生歧义。



### 1.6 标识符命名规则

**作用**：C++规定给标识符（变量、常量）命名时，有一套自己的规则

* 标识符不能是关键字
* 标识符只能由字母、数字、下划线组成
* 第一个字符必须为字母或下划线
* 标识符中字母区分大小写



> 建议：给标识符命名时，争取做到见名知意的效果，方便自己和他人的阅读





## 二、数据类型

C++规定在创建一个变量或者常量时，必须要指定出相应的数据类型，否则无法给变量分配内存



### 2.1 整型

**作用**：整型变量表示的是==整数类型==的数据

C++中能够表示整型的类型有以下几种方式，**区别在于所占内存空间不同**：

| **数据类型**        | **占用空间**                                    | 取值范围                                                     |
| ------------------- | ----------------------------------------------- | ------------------------------------------------------------ |
| short(短整型)       | 2字节                                           | (-2^15 ~ 2^15-1)(-32768~32767)                               |
| int(整型)           | 4字节                                           | (-2^31 ~ 2^31-1)(-2147483648~2147483647)                     |
| long(长整形)        | Windows为4字节，Linux为4字节(32位)，8字节(64位) | (-2^31 ~ 2^31-1)(-2147483648~2147483647)                     |
| long long(长长整形) | 8字节                                           | (-2^63 ~ 2^63-1)(-9,223,372,036,854,775,808~9,223,372,036,854,775,807) |



### 2.2 sizeof关键字

**作用：**利用sizeof关键字可以==**统计数据类型所占内存大小**==

**语法：** `sizeof( 数据类型 / 变量)`

**示例：**

```C++
int main() {

	cout << "short 类型所占内存空间为： " << sizeof(short) << endl;

	cout << "int 类型所占内存空间为： " << sizeof(int) << endl;

	cout << "long 类型所占内存空间为： " << sizeof(long) << endl;

	cout << "long long 类型所占内存空间为： " << sizeof(long long) << endl;

	system("pause");

	return 0;
}
//short 类型所占内存空间为： 2
//int 类型所占内存空间为： 4
//long 类型所占内存空间为： 4
//long long 类型所占内存空间为： 8

```



> **整型结论**：==short < int <= long <= long long==



### 2.3 实型（浮点型）

**作用**：用于==表示小数==

浮点型变量分为两种：

1. 单精度`float` 
2. 双精度`double`

两者的**区别**在于表示的有效数字范围不同。

| **数据类型** | **占用空间** | **有效数字范围** |
| ------------ | ------------ | ---------------- |
| float        | 4字节        | 7位有效数字      |
| double       | 8字节        | 15～16位有效数字 |

**示例：**

```C++
int main() {

	float f1 = 3.14f;
	double d1 = 3.14;

	cout << f1 << endl;
	cout << d1<< endl;

	cout << "float  sizeof = " << sizeof(f1) << endl;
	cout << "double sizeof = " << sizeof(d1) << endl;

	//科学计数法
	float f2 = 3e2; // 3 * 10 ^ 2 
	cout << "f2 = " << f2 << endl;

	float f3 = 3e-2;  // 3 * 0.1 ^ 2
	cout << "f3 = " << f3 << endl;

	system("pause");

	return 0;
}
```



