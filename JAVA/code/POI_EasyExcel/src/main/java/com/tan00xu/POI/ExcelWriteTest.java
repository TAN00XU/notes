package com.tan00xu.POI;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteTest {
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

    @Test
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

    @Test
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

    @Test
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

}
