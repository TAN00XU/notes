[TOC]

# JAVA注解与反射



## 注解：

---

### 一，什么是注解

1. Annotation是从JDK5.0开始引入的新技术。

2. Annotation的作用：

   * 不是程序本身，可以对程序作出解释。（这一点与注释（comment）一样）

   * ==可以被其他程序（比如：编译器等）读取==
   
3. Annotation的格式：

   ​    注解是以"==@注释名=="在代码中存在的，可以添加一些参数值，例如：`@SuppressWarnings(value = " unchecked ")`。

4. Annotation在哪里使用

   ​    可以附加在package、class、method、field等上面，相当于给他们添加了额为的辅助信息，我们可以通过反射机制编程实现对这些元素的访问。

   ---

### 二，内置注解

* **@Override**：定义在`java.lang.Override`中，此注解只适用于修辞方法，表示一个方法声明要重写超类中的另一个方法。

* **@Deprecated**：定义在`java.long.Deprecated`中，此注解可以用于修辞方法、属性、类，表示不鼓励程序员使用这样的元素，通常是因为它很危险或者存在更好的选择。

* **@SuppressWarnings**：定义在`java.lang.SuppressWarnings`中，用来抑制编译时的警告信息。

  * 与前两个有所不同，你需要添加一个参数才能正确使用，这些参数都是已经定义好了的。

  - [x] `@SuppressWarnings("all")`

  - [x] `@SuppressWarnings("unchecked")`

  - [x] `@SuppressWarnings(value = {"unchecked" , "depreciation"})`

  - [x] 等等……

    ``` java
    @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SuppressWarnings {
        /**
         * The set of warnings that are to be suppressed by the compiler in the
         * annotated element.  Duplicate names are permitted.  The second and
         * successive occurrences of a name are ignored.  The presence of
         * unrecognized warning names is <i>not</i> an error: Compilers must
         * ignore any warning names they do not recognize.  They are, however,
         * free to emit a warning if an annotation contains an unrecognized
         * warning name.
         *
         * <p> The string {@code "unchecked"} is used to suppress
         * unchecked warnings. Compiler vendors should document the
         * additional warning names they support in conjunction with this
         * annotation type. They are encouraged to cooperate to ensure
         * that the same names work across multiple compilers.
         * @return the set of warnings to be suppressed
         */
        String[] value();
    }
    ```

    ​		编译器要在带注释的元素中抑制的一组警告。允许重复名称。名称的第二次和连续出现将被忽略。存在无法识别的警告名称不是错误：编译器必须忽略它们无法识别的任何警告名称。但是，如果注释包含无法识别的警告名称，它们可以自由发出警告。字符串"unchecked"用于抑制未经检查的警告。编译器供应商应结合此注释类型记录他们支持的其他警告名称。鼓励他们合作以确保相同的名称在多个编译器中工作。
    ​	返回值：要抑制的警告集。
    
    ``` java
    @SuppressWarnings("unchecked")//执行了未检查的转换时的警告，例如当使用集合时没有用泛型(Generics) 来指定集合保存的类型。
    @SuppressWarnings("unused")  //未使用的变量
    @SuppressWarnings("resource")  //有泛型未指定类型
    @SuppressWarnings("path")  //在类路径、源文件路径等中有不存在的路径时的警告
    @SuppressWarnings("deprecation")  //使用了不赞成使用的类或方法时的警告
    @SuppressWarnings("fallthrough") //当 Switch 程序块直接通往下一种情况而没有 break; 时的警告
    @SuppressWarnings("serial")//某类实现Serializable(序列化)， 但没有定义 serialVersionUID 时的警告
    @SuppressWarnings("rawtypes") //没有传递带有泛型的参数
    @SuppressWarnings("finally") //任何 finally 子句不能正常完成时的警告。
    @SuppressWarnings("try") // 没有catch时的警告
    @SuppressWarnings("all") //所有类型的警告
    // 以下是源码引用中见到的，但实际很少用到的
    @SuppressWarnings("FragmentNotInstantiable")
    @SuppressWarnings("ReferenceEquality")
    @SuppressWarnings("WeakerAccess")
    @SuppressWarnings("UnusedParameters")
    @SuppressWarnings("NullableProblems")
    @SuppressWarnings("SameParameterValue")
    @SuppressWarnings("PointlessBitwiseExpression")
    ```
    
    
     	
  
  ---



### 三，元注解

1. 元注解的作用就是负责注解其他注解,Java定义了4个标准的*meta-annotation*类型,他们被用来提供对其他annotation类型作说明。
2. 这些类型和它们所支持的类在`java.lang.annotation`包中可以找到。(`@Target , @Retention , @Documented , @Inherited`)
   + **@Target：**用于描述注解的使用范围(即:被描述的注解可以用在什么地方)。
   + **@Retention：**表示需要在什么级别保存该注释信息,用于描述注解的生命周期。==(**SOURCE < CLASS < RUNTIME**)==
   + **@Document：**说明该注解将被包含在javadoc中。
   + **@Inherited：**说明子类可以继承父类中的该注解 。
   ---



### 四，自定义注解

1. 使用**@interface**自定义注解时，自动继承了`java.lang.annotation.Annotation`接口。
2. 分析：
   + **@interface**用来声明一个注解，格式：`public @interface 注解名{定义内容}`。
   + 其中的每一个方法实际上是声明了一个配置参数。
   + 方法的名称就是参数的名称。
   + 返回值类型就是参数的类型(返回值只能是基本类型：==**Class、 String 、 enum**== )。
   + 可以通过default来声明参数的默认值。
   + 如果只有一个参数成员,一般参数名为value。
   + 注解元素必须要有值，我们定义注解元素时，经常使用空字符，0作为默认值。 

``` java
//注解可以显示赋值，如果没有默认值，我们就必须给注解赋值
@MyAnnotation(age = 18)
public void test() {}

@interface MyAnnotation{
    //注解的参数： 参数类型 + 参数名 +();
    String name() default "";
    int id default -1;//如果默认值为-1，代表不存在
}
```

---





## 反射：

---

### 一、反射概述

#### Ⅰ. 静态与动态语言

##### 1. 动态语言

+ 是一类在运行时可以改变其结构的语言：例如新的函数、对象、甚至代码可以被引进，已有的函数可以被删除或是其他结构上的变化。

  通俗点说就是在运行时代码可以根据某些条件改变自身结构。

+ 主要动态语言： Object-C、 C#、JavaScript、PHP、Python等。

##### 2. 静态语言

+ 与动态语言相对应的,运行时结构不可变的语言就是静态语言。

  如Java、C、 C++。

+ Java不是动态语言，但Java可以称之为“准动态语言”。即Java有一定的动态性，我们可以利用反射机制获得类似动态语言的特性。

  Java的动态性让编程的时候更加灵活！


#### Ⅱ. Java Reflection

+ Reflection（反射）是Java被视为动态语言的关键，反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息（*类名、接口、方法、属性*），并能直接操作任意对象的内部属性及方法。

``` java
Class c = Class.forName("java.lang.String")
```

+ 加载完类之后,在堆内存的方法区中就产生了一个Class类型的对象（一个类只有一个Class对象），这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。这个对象就像一面镜子，透过这个镜子看到类的结构。所以，我们形象的称之为：反射。



``` mermaid
graph LR
    id>"正常方式："]-->id0(["引入需要的“包类”名称"])-->id1([通过new实例化])-->id2(["取得实例化对象"])
    1id>"反射方式："]-->1id0(["实例化对象"])-->1id1(["getClass()方法"])-->1id2(["得到完整的“包类“名称"])
```

---



### 二、Java反射机制研究及应用

#### Java反射机制提供的功能

+ 在运行时判断任意一个对象所属的类
+ 在运行时构造任意一个类的对象
+ 在运行时判断任意一个类所具有的成员变量和方法
+ 在运行时获取泛型信息
+ 在运行时调用任意一个对象的成员变量和方法
+ 在运行时处理注解
+ 生成动态代理
+ ……

---



### 三、反射优点和缺点

#### 优点：

+ 可以实现动态创建对象和编译，体现出很大的灵活性

#### 缺点：

+ 对性能有影响。使用反射基本上是一种解释操作，我们可以告诉JVM，我们希望做什么并且它满足我们的要求。这类操作总是慢于直接执行相同的操作。

---



### 四、反射相关的主要API

+ `java.lang.Class` ：代表一个类
+ `java.lang.reflect. Method` ：代表类的方法
+ `java.lang.reflect.Field` ：代表类的成员变量
+ `java.lang.reflect.Constructor` ：代表类的构造器
+ ……

---



### 五、Class类

在Object类中定义了以下的方法，此方法将被所有的子类继承

``` java 
public final Class getClass();
```

+ 以上的方法返回值的类型是一个Class类，此类是Java反射的源头，实际上所谓反射从程序的运行结果来看也很好理解，即：可以通过对象反射求出类的名称。

``` mermaid
graph BT
	A((Person类)) & B((Animal类))-->X((Class))
	Aa((张三)) & Ab((李四)) & Ac((王五))-->A
	Ba((小猫)) & Bb((小狗))-->B
```

对象照镜子后可以得到的信息：某个类的属性、方法和构造器、某个类到底实现了哪些接口。对于每个类而言，JRE都为其保留一个不变的Class类型的对象。一个Class对象包含了特定某个结构(class/interface/enum/annotation/primitive type/void/[ ])的有关信息。

+ Class本身也是一个类
+ Class对象只能由系统建立对象
+ 一个加载的类在JVM中只会有一个Class实例
+ 一个Class对象对应的是一个加载到JVM中的一个.class文件
+ 每个类的实例都会记得自己是由哪个Class实例所生成
+ 通过Class可以完整地得到一个类中的所有被加载的结构
+ Class类是Reflection的根源，针对任何你想动态加载、运行的类，唯有先获得相应的Class对象

---



### 六、Class类的常用方法

| 方法名                                       | 功能说明                               |
|-------------------------------------------|------------------------------------|
| static ClassforName( String name)         | 返回指定类名name的Class对象                 |
| Object newInstance                        | 调用缺省构造函数，返回Class对象的一个实例            |
| getName()                                 | 返回此Class对象所表示的实体(类，接口，数组类或void)的名称 |
| Class getSuperClass()                     | 返回当前Class对象的父类的Class对象             |
| Class[ ] getInterfaces()                  | 获取当前Class对象的接口                     |
| ClassLoader getClassLoader()              | 返回该类的类加载器                          |
| Constructor[ ] getConstructor()           | 返回一个包含某些Construction对象的数组          |
| Method getMothed(String name, Class...T ) | 返回一个Method对象，此对象的形参类型为paramType    |
| Field[ ] getDeclaredFields()              | 返回Field对象的一个数组                     |

---



### 七、获取Class类的实例

1. 若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最高。

   ``` java
   Class c = Person.class;
   ```

2. 已知某个类的实例，调用该实例的getClass()方法获取Class对象

   ``` java
   Class c = person.getClass();
   ```

3. 已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException

   ```java 
   Class c = Class.forName("demo.Student");
   ```

4. 内置基本数据类型可以直接用类名.Type
5. 还可以利用ClassLoader

```java
package com.tan00xu.test;
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);//这个人是：学生
        //方式一：通过类名.class获得
        Class c1 = Student.class;
        System.out.println(c1);//class com.tan00xu.test.Student
        //方式二：通过对象获得
        Class c2 = person.getClass();
        System.out.println(c2.hashCode());//685325104
        //方式三：forName获得
        Class c3 = Class.forName("com.tan00xu.test.Student");
        System.out.println(c3.hashCode());//685325104
        //方式四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);//int
        //获得父类类型
        Class c5 = c2.getSuperclass();
        System.out.println(c5);//class com.tan00xu.test.Person
    }
}
class Person {
    String name;
    public Person(){}
    public Person(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}
class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}
```

---



### 八、哪些类型可以有Class对象

+ class：外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类。
+ interface：接口
+ [ ]：数组
+ enum：枚举
+ annotation：注解@interface
+ primitive type：基本数据类型
+ void

```java
package com.tan00xu.test;

import java.lang.annotation.ElementType;

//所有类型的Class
public class Test {
    public static void main(String[] args) {

        Class c1 = Object.class;//类
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;//一维数组
        Class c4 = int[][].class;//二位数组
        Class c5 = Override.class;//注解
        Class c6 = ElementType.class;//枚举
        Class c7 = Integer.class;//基本数据类型
        Class c8 = void.class;//void
        Class c9 = Class.class;//Class

        System.out.println(c1);//class java.lang.Object
        System.out.println(c2);//interface java.lang.Comparable
        System.out.println(c3);//class [Ljava.lang.String;
        System.out.println(c4);//class [[I
        System.out.println(c5);//interface java.lang.Override
        System.out.println(c6);//class java.lang.annotation.ElementType
        System.out.println(c7);//class java.lang.Integer
        System.out.println(c8);//void
        System.out.println(c9);//class java.lang.Class

        //只要元素类型与维度一样，就是同一个Class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());//685325104
        System.out.println(b.getClass().hashCode());//685325104
    }
}
```

---



### 九、Java内存分析

``` mermaid
	flowchart  LR
		A([Java内存])-->B1(堆) & B2(栈) & B3(方法区)
		B1-->B1b1[存放new的对象和数组] & B1b2["可以被所有的线程共享，不会存放别的对象引用"]
		B2-->B2b1["存放基本变量类型（会包含这个基本类型的具体数值）"] & B2b2["引用对象的变量（会存放这个引用在堆里面的具体地址）"]
		B3-->B3b1[可以被所有的线程共享] & B3b2[包含了所有的class和static变量]
	
```

---



### 十、了解类的加载过程

​		当程序主动使用某个类时,如果该类还未被加载到内存中,则系统会通过如下	三个步骤来对该类进行初始化。 

``` mermaid
graph BT
    A["类的加载（Load）"]==>B["类的链接（Link）"]==>C["类的初始化（Initialize）"]
    a("将类的class文件读入内存，<br/>并为之创建一java.lang.Class对象。<br/>此过程由类加载器完成。 ").->A
    b("将类的二进制数据合并到JRE中").->B
    c("JVM负责对类进行初始化").->C
style a stroke-dasharray: 5, 5
style b stroke-dasharray: 5, 5
style c stroke-dasharray: 5, 5

```

---



### 十一、类的加载与ClassLoader的理解

#### 1. 加载：

​		将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构,然后生成一个代表这个类的`java.lang.Class`对象。

#### 2. 链接：

​		将Java类的二进制代码合并到JVM的运行状态之中的过程。

+ 验证：确保加载的类信息符合JVM规范没有安全方面的问题。
+ 准备：正式为类变量(static)分配内存并设置类变量默认初始值的阶段,这些内存都将在方法区中进行分配。
+ 解析：虚拟机常量池内的符号引用(常量名)替换为直接引用(地址)的过程。 

#### 3. 初始化：

+ 执行类构造器`<clinit>()`方法的过程。类构造器`<clinit>()`方法是由编译期自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。(类构造器是构造类信息的，不是构造该类对象的构造器)。
+ 当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化。
+ 虚拟机会保证一个类的`<clinit>()`方法在多线程环境中被正确加锁和同步。 

---



### 十二、什么时候发生类的初始化

#### 1. 类的主动引用(一定会发生类的初始化)

+ 当虚拟机启动，先初始化main方法所在的类
+ new一个类的对象
+ 调用类的静态成员(除了final常量)和静态方法
+ 使用`java.lang.reflect`包的方法对类进行反射调用
+ 当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类 

#### 2. 类的被动引用(不会发生类的初始化)

+ 当访问一个静态域时，只有真正声明这个域的类才会被初始化。如:当通过子类引用父类的静态变量,不会导致子类初始化。
+ 通过数组定义类引用,不会触发此类的初始化
+ 引用常量不会触发此类的初始化(常量在链接阶段就存入调用类的常量池中了) 

```java
public class Test {
    static {
        System.out.println("main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用
//        Son son = new Son();
        //反射也会产生主动引用
//        Class.forName("com.tan00xu.test.Son");
        
        //不会产生类的引用的方法
//        System.out.println(Son.b);
//        Son[] array = new Son[5];
//        System.out.println(Son.M);
    }
}
class Father{
    static int b =2;
    static {
        System.out.println("父类被加载");
    }
}
class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static  int m = 2;
    static final int M =1;
}
```



==**初始化顺序依次是：**==

``` mermaid
graph LR
	a["静态变量、静态初始化块"]==>b["变量、初始化块"]==>构造器
```

==**如果有父类，则顺序是：**==

``` mermaid
graph LR
    父类static方法==>子类static方法==>父类构造方法==>子类构造方法
```

### 十三、类加载器的作用

+ 类加载的作用:

  ​		将class文件字节码内容加载到内存中,并将这些静态数据转换成方法区的运行时数据结构,然后在堆中生成一个代表这个类的`java.lang.Class`对象,作为方法区中类数据的访问入口。

+ 类缓存:
  		标准的JavaSE类加载器可以按要求查找类,但一旦某个类被加载到类加载器中,它将维持加载(缓存)一段时间。不过JVM垃圾回收机制可以回收这些Class对象

``` mermaid
graph TB
	a["源程序（*.java文件）"]
	==>
	b([Java编译器])
	==>
	c[["字节码（*.class文件）"]]
	==>
	d([类装载器])
	==>
	e([字节码校验器])
	==>
	f[(操作系统平台)]
```

+ 类加载器作用是用来把类(class)装载进内存的。JVM规范定义了如下类型的类的加载器
  1. *BootstrapClassLoader* **启动类加载器（引导类加载器）：**用C++编写的,是JVM自带的类加载器，==负责Java平台核心库==，用来装载核心类库。该加载器无法直接获取。
  2. *ExtentionClassLoader* **扩展类加载器：**负责jre/lib/ext目录下的jar包或java.ext.dirs指定目录下的jar包装入工作库 
  3. *AppClassLoader* **应用类加载器（系统类加载器）：**负责java-classpath或java.class.path所指的目录下的类与jar包装入工作，是最常用的加载器 

```java
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@14dad5dc

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);//sun.misc.Launcher$ExtClassLoader@28d93b30

        //获取扩展类加载器的父类加载器-->根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);//null

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.tan00xu.test.Test").getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@14dad5dc

        //测试JDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);//null

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\charsets.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\deploy.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\access-bridge-64.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\cldrdata.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\dnsns.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\jaccess.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\jfxrt.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\localedata.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\nashorn.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\sunec.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\sunjce_provider.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\sunmscapi.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\sunpkcs11.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\ext\zipfs.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\javaws.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\jce.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\jfr.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\jfxswt.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\jsse.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\management-agent.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\plugin.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\resources.jar;
        D:\JavaPackage\JDK\jdk1.8.0_40\jre\lib\rt.jar;
        E:\TAN00XU\Documents\JAVA\learn\out\production\learn;
        D:\IDE\Jetbrains\IntelliJ IDEA 2021.3.2\lib\idea_rt.jar
         */
    }
}
```

#### 拓展：双亲委派机制

​	当某个类加载器需要加载某个`.class`字节码文件时，它首先把这个任务委托给他的上级类加载器，递归这个操作，如果上级的类加载器没有加载该类，自己才会去加载这个类。

​	当一个Hello.class这样的文件要被加载时。不考虑我们自定义类加载器，首先会在AppClassLoader中检查是否加载过，如果有那就无需再加载了。如果没有，那么会拿到父加载器，然后调用父加载器的loadClass方法。父类中同理也会先检查自己是否已经加载过，如果没有再往上。注意这个类似递归的过程，直到到达Bootstrap classLoader之前，都是在检查是否加载过，并不会选择自己去加载。直到BootstrapClassLoader，已经没有父加载器了，这时候开始考虑自己是否能加载了，如果自己无法加载，会下沉到子加载器去加载，一直到最底层，如果没有任何加载器能加载，就会抛出ClassNotFoundException。

##### 双亲委派机制的作用：

1. ==防止重复加载同一个`.class`。==通过委托去询问上级是否加载过改`.class`，如果加载过了，就不用再加载一遍。保证了数据安全。
2. ==保证核心`.class`不能被篡改。==通过委托方式，保证核心的`.class`不会被篡改，即使篡改也不会被加载，即使加载也不会是同一个`.class`对象了。因为不同的加载器加载同一个`.class`也不是同一个`Class`对象。这样保证了`Class`执行安全。

![加载](../NotesImg/双亲委派机制.jpg)

---



### 十三、获取运行时类的完整结构

+ 通过反射获取运行时类的完整结构
	Field, Method, Constructor, Superclass, Interface, Annotation
	+ 实现的全部接口
	+ 所继承的父类
	+ 全部的构造器
	+ 全部的方法
	+ 全部的Field
	+ 注解 

---

 

### 十四、动态创建对象执行方法

#### 1. 有了Class对象，能做什么？

+ 创建类的对象:调用Class对象的`newlnstance()`方法
  1. 类必须有一个无参数的构造器
  2. 类的构造器的访问权限需要足够
+ 思考？难道没有无参的构造器就不能创建对象了吗？只要在操作的时候明确的调用类中的构造器,并将参数传递进去之后,才可以实例化操作。
  + 步骤如下：
    1. 通过Class类的`getDeclaredConstructor(Class ... parameterTypes)`取得本类的指定形参类型的构造器
    2. 类的构造器的访问权限需要足够>步骤如下:1)2)向构造器的形参中传递一个对象数组进去,里面包含了构造器中所需的各个参数。
    3. 通过Constructor实例化对象 

#### 2. 调用指定的方法

通过反射,调用类中的方法,通过Method类完成。

1. 通过Class类的`getMethod(String name,Class...parameterTypes)`方法取得一个Method对象,并设置此方法操作时所需要的参数类型。
2. 之后使用`Object invoke(Object obj, Object[] args)`进行调用,并向方法中传递要设置的obj对象的参数信息。 

![image-20220309093810069](../NotesImg/image-20220309093810069.png)



`Object invoke(Object obj, Object[] args)`

+ Object 对应原方法的返回值,若原方法无返回值,此时返回null
+ 若原方法若为静态方法,此时形参Object obj可为null
+ 若原方法形参列表为空,则`Object[] args`为null
+ 若原方法声明为private,则需要在调用此`invoke()`方法前,显式调用方法对象的`setAccessible(true)`方法,将可访问private的方法。

#### 3. setAccessible

+ Method和Field, Constructor对象都有setAccessible()方法。
+ setAccessible作用是启动和禁用访问安全检查的开关。
+ 参数值为true则指示反射的对象在使用时应该取消Java语言访问检查。
  1. 提高反射的效率。如果代码中必须用反射，而该句代码需要频繁的被调用，那么请设置为true。
  2. 使得原本无法访问的私有成员也可以访问

+ 参数值为false则指示反射的对象应该实施Java语言访问检查

#### 4. 分析性能问题

```java
package com.tan00xu.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//分析性能问题
public class Test {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }
    //普通方式调用
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <10_0000_0000; i++){
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行10亿次：" + (endTime - startTime) + "ms");//普通方式执行10亿次：1ms
    }

    //反射方式调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <10_0000_0000; i++){
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式执行10亿次：" + (endTime - startTime) + "ms");//反射方式执行10亿次：1497ms
    }

    //反射方式调用 关闭权限检测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <10_0000_0000; i++){
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭权限检测执行10亿次：" + (endTime - startTime) + "ms");///关闭权限检测执行10亿次：975ms
    }
}

class User{
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
```

---


### 十五、获取反射信息

#### 反射操作泛型

1. Java采用泛型擦除的机制来引入泛型，Java中的泛型仅仅是给编译器javac使用的,确保数据的安全性和免去强制类型转换问题。但是，一旦编译完成，所有和泛型有关的类型全部擦除。

2. 为了通过反射操作这些类型， Java新增了ParameterizedType, GenericArrayType，TypeVariable 和WildcardType几种类型来代表不能被归一到Class类中的类型但是又和原始类型齐名的类型 。
   + **ParameterizedType：**表示一种参数化类型，比如`Collection<String>`
   + **GenericArrayType：**表示一种元素类型是参数化类型或者类型变量的数组类型
   + **TypeVariable：**是各种类型变量的公共父接口
   + **WildcardType：**代表一种通配符类型表达式 

```java
//通过反射获取泛型
public class Test {

    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
        System.out.println("=====================");
        method = Test.class.getMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }

}

class User{
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
```

---


### 十六、获取注解信息

#### 1. 反射操作注解

+ getAnnotations
+ getAnnotation

#### 2. ORM

+ 什么是ORM？

  1. Object relationship Mapping --> 对象关系映射
  ![image-20220309165950831](../NotesImg/image-20220309165950831.png)
  2. 类和表结构对应
  3. 属性和字段对应
  4. 对象和记录对应

---

###### 学习资源与笔记来源于[狂神说Java](https://www.bilibili.com/video/BV1p4411P7V3?share_source=copy_web)
