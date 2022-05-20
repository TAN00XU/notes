package com.tan00xu.POI;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelReadTest {

    final String PATH = "E:\\TAN00XU\\Documents\\JAVA\\POI_EasyExcel\\src\\main\\java\\com\\tan00xu\\documents\\";
    @Test
    public void testRead03And07() throws Exception {
        //1、获取文件流
        FileInputStream fileInputStream = new FileInputStream("E:\\TAN00XU\\Documents\\JAVA\\POI_EasyExcel\\src\\main\\java\\com\\tan00xu\\documents\\03.xls");
        //2、获取工作簿
        //03版本的excel xls
        Workbook workBook = new HSSFWorkbook(fileInputStream);
        //07版本的excel xlsx
//        Workbook workBook = new XSSFWorkbook(fileInputStream);

        //3、获取工作表
        Sheet sheet = workBook.getSheetAt(0);
        //4、获取行
        Row row = sheet.getRow(0);
        //5、获取单元格
        Cell cell = row.getCell(0);
        //6、获取单元格内容 读取值需要注意类型
        String value = cell.getStringCellValue();

        System.out.println(value);
        //7、关闭流
        fileInputStream.close();
    }

    //获取不同的数据类型
    @Test
    public void testCellType() throws IOException, ParseException {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH+"明细表.xlsx");
        //获取一个工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //获取一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        //获取到标题行
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null){
            //获取所有的列
            int cells = rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < cells; cellNum++){
                //获取当前列
                Cell cell = rowTitle.getCell(cellNum);
                if (cell != null){
                    //获取当前行的第 col 列的值
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue+" | ");
                }
            }
        }
        System.out.println("\n");

        //获取表中的所有行
        int rows = sheet.getPhysicalNumberOfRows();
        for(int rowNum = 1; rowNum < rows; rowNum++ ){
            //获取到当前行
            Row rowData = sheet.getRow(rowNum);
            if (rowData != null){
                //获取当前行的列数
                int cells = rowData.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cells; cellNum++){
                    //获取当前列
                    Cell cell = rowData.getCell(cellNum);

                    String cellValue = "";

                    //匹配列的数据类型，并获取数据
                    if(cell != null){
                        CellType cellType = cell.getCellType();
                        switch (cellType){
                            case STRING:
                                System.out.print("String类型");
                                cellValue = cell.getStringCellValue();
                                break;
                            case BOOLEAN:
                                System.out.print("Boolean类型");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case BLANK:
                                System.out.print("空类型");
                                break;
                            case NUMERIC:
                                System.out.print("NUMERIC类型（整数、小数、日期）");
                                if (DateUtil.isCellDateFormatted(cell)){
                                    System.out.print("日期类型");
                                    Date dateCellValue = cell.getDateCellValue();
                                    //设置日期格式
                                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    cellValue = format.format(dateCellValue);
                                }else {
                                    //不是日期格式，防止数字过长，被转换为科学计数法
                                    System.out.print("数字类型");
                                    /*
                                     * 该方法已经过时，不推荐使用
                                     * cell.setCellType(CellType.STRING);
                                     * DataFormatter formatter = new DataFormatter();
                                     * cellValue = String.valueOf(cell.getStringCellValue());
                                     */
                                    DataFormatter dataFormatter = new DataFormatter();
                                    cellValue = dataFormatter.formatCellValue(cell);
                                }
                                break;
                            case ERROR:
                                    System.out.print("错误类型");
                                    break;
                            default:
                                }

                    }
                    System.out.println(" =>表格的值：=>"+cellValue+" | ");

                }
                System.out.println("\n");
            }
        }
    }

    @Test
    public void testFormula() throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH+"公式.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = xssfWorkbook.getSheetAt(0);
        Row row = sheet.getRow(5);
        Cell cell = row.getCell(0);
        //拿到计算公式
        FormulaEvaluator formulaEvaluator = new XSSFFormulaEvaluator(xssfWorkbook);
        //输出单元格的值
        CellType cellType = cell.getCellType();
        switch (cellType){
            case FORMULA:
                System.out.println("公式类型");
                String cellFormula = cell.getCellFormula();
                System.out.println("公式为："+cellFormula);
                //计算公式
                CellValue cellValue = formulaEvaluator.evaluate(cell);
                System.out.println(cellValue);
                System.out.println(cellValue.getNumberValue());
                System.out.println(cellValue.formatAsString());
                break;
        }


    }

}
