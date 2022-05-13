`03版`只到`65536`行，拓展名为`.xsl`

`07版`无上限，拓展名为`.xlsx`

# apache POI

03版

```xml
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.2.2</version>
</dependency>
```

07版

```xml
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.2</version>
</dependency>
```



---



## Apache POI常用的类

+ `HSSF `－ 提供读写Microsoft Excel XLS格式档案的功能。
+ `XSSF `－ 提供读写Microsoft Excel OOXML XLSX格式档案的功能。
+ `HWPF `－ 提供读写Microsoft Word DOC97格式档案的功能。
+ `XWPF `－ 提供读写Microsoft Word DOC2003格式档案的功能。
+ `HSLF `－ 提供读写Microsoft PowerPoint格式档案的功能。
+ `HDGF `－ 提供读Microsoft Visio格式档案的功能。
+ `HPBF `－ 提供读Microsoft Publisher格式档案的功能。
+  `HSMF `－ 提供读Microsoft Outlook格式档案的功能。



---



## 文件写入

### 03版

```java
String path="E:\\TAN00XU\\Documents\\JAVA\\POI_EasyExcel\\src\\main\\java\\com\\tan00xu\\documents";

@Test
public void write03Test() throws IOException {
    //1、创建工作簿
    Workbook workBook = new HSSFWorkbook();
    //2、创建工作表
    Sheet sheet = workBook.createSheet("第一个工作表");
    //3、创建行
    Row row1 = sheet.createRow(0);
    //4、创建单元格
    Cell cell1 = row1.createCell(0);
    Cell cell2 = row1.createCell(1);
    //5、设置单元格内容
    cell1.setCellValue("第一行第一列");
    //第一行第二个单元格
    cell2.setCellValue("Hello World");

    Row row2 = sheet.createRow(1);
    row2.createCell(0).setCellValue("第二行第一列");
    Cell cell22 = row2.createCell(1);
    String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
    cell22.setCellValue(time);

    //03版本的excel xls
    //6、生成文件io流
    FileOutputStream fileOutputStream = new FileOutputStream(path + "\\03.xls");

    //7、写入文件
    workBook.write(fileOutputStream);

    //8、关闭流
    fileOutputStream.close();

    System.out.println("写入成功");

}
```

### 07版

```java
@Test
public void write07Test() throws IOException {
    //1、创建工作簿
    Workbook workBook = new XSSFWorkbook();
    //2、创建工作表
    Sheet sheet = workBook.createSheet("第一个工作表");
    //3、创建行
    Row row1 = sheet.createRow(0);
    //4、创建单元格
    Cell cell1 = row1.createCell(0);
    Cell cell2 = row1.createCell(1);
    //5、设置单元格内容
    cell1.setCellValue("第一行第一列");
    cell2.setCellValue("Hello World");


    Row row2 = sheet.createRow(1);
    row2.createCell(0).setCellValue("第二行第一列");
    Cell cell22 = row2.createCell(1);
    String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
    cell22.setCellValue(time);


    //07版本的excel xlsx
    //6、生成文件io流
    FileOutputStream fileOutputStream = new FileOutputStream(path + "\\07.xlsx");

    //7、写入文件
    workBook.write(fileOutputStream);

    //8、关闭流
    fileOutputStream.close();

    System.out.println("写入成功");

}
```

### 区别：03版与07版的区别在于调用的对象和生成文件的拓展名不一样

+ 03版`HSSFWorkbook()`，文件名以`.xls`结尾
+ 07版`XSSFWorkbook()`，文件名以`.xlsx`结尾



---

## 大文件写入

### 大文件写HSSF-03

缺点：最多只能处理65536行，否则会报异常

`java.lang.IllegalArgumentException:Invalid row number (65536) outside allowable range (0.. 65535)`
优点：过程中写入缓存，不操作磁盘，最后一次性写入磁盘，速度快

```java
public void write03TestBigData() throws IOException {
    long begin = System.currentTimeMillis();

    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet();
    //写入数据
    for (int rowNum = 0; rowNum < 65536; rowNum++) {
        Row row = sheet.createRow(rowNum);
        for (int cellNum = 0; cellNum < 10; cellNum++) {
            Cell cell = row.createCell(cellNum);
            cell.setCellValue(rowNum+" , "+cellNum);
        }
    }
    FileOutputStream fileOutputStream = new FileOutputStream(path + "\\03版本Excel大量数据测试.xls");
    workbook.write(fileOutputStream);
    fileOutputStream.close();
    System.out.println("write03TestBigData写入完成");

    long end = System.currentTimeMillis();
    System.out.println((double) (end - begin) / 1000);

}
```



### 大文件写XSSF-07

- 缺点：写数据时速度非常慢，非常耗内存，也会发生内存溢出，如100万条数据
- 优点：可以写较大的数据量，如20万条数据

```java
public void write07TestBigData() throws IOException {
    long begin = System.currentTimeMillis();

    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();
    //写入数据
    for (int rowNum = 0; rowNum < 10000; rowNum++) {
        Row row = sheet.createRow(rowNum);
        for (int cellNum = 0; cellNum < 10; cellNum++) {
            Cell cell = row.createCell(cellNum);
            cell.setCellValue(rowNum+" , "+cellNum);
        }
    }
    FileOutputStream fileOutputStream = new FileOutputStream(path + "\\07版本Excel大量数据测试.xlsx");
    workbook.write(fileOutputStream);
    fileOutputStream.close();
    System.out.println("write07TestBigData写入完成");

    long end = System.currentTimeMillis();
    System.out.println((double) (end - begin) / 1000);
}
```



### 大文件写SXSSF-07升级版

优点：可以写非常大量的数据库，如100万条甚至更多条，写数据速度快，占用更少的内存

注意：

过程中会产生临时文件，需要在程序运行结束后清理临时文件
默认由100条记录被保存在内存中，如果超出这数量，则最前面的数据被写入临时文件
如果想自定义内存中数据的数量，可以使用new SXSSFWorkbook（数量）

```java
public void testWrite07SupperBigData() throws IOException {
    //时间
    long begin = System.currentTimeMillis();
    //创建一个薄
    Workbook workbook = new SXSSFWorkbook(100);
    //创建表
    Sheet sheet = workbook.createSheet();
    //写入数据
    for (int rowNum = 0; rowNum < 65536; rowNum++) {
        Row row = sheet.createRow(rowNum);
        for (int cellNum = 0; cellNum < 10; cellNum++) {
            Cell cell = row.createCell(cellNum);
            cell.setCellValue(cellNum);
        }
    }
    FileOutputStream fos = new FileOutputStream(path + "\\07Supper版本Excel大量数据测试.xlsx");
    workbook.write(fos);
    fos.close();
    //清除临时缓存
    ((SXSSFWorkbook)workbook).dispose();
    System.out.println("testWrite07SupperBigData写入完成");
    long end = System.currentTimeMillis();
    System.out.println((double) (end - begin) / 1000);
}
```

