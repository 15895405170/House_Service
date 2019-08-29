package com.yrxh.util;

import com.yrxh.modle.House;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/8/24.
 */
public class XmlUtil {
    public  List<House> addInfo() {
        List<House> list =new ArrayList<>();
        try {
            //同时支持Excel 2003、2007
            File excelFile = new File("E:/information.xlsx"); //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量
//            System.out.println("表数"+sheetCount);
            //遍历每个Sheet
            for (int s = 0; s < sheetCount; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                Row titleRow=sheet.getRow(1);
                if(titleRow!=null){
                    int titleCount=titleRow.getPhysicalNumberOfCells();
                    String[] titleNames=new String[titleCount];
                    //获取表中的列名
                    for(int q=0;q<titleCount;q++){
                        titleNames[q]=titleRow.getCell(q).getStringCellValue();
                    }
//                    //获得类中的所有属性
//    				Set<Field> totalField=ReflectUtil.findClassField(Profession.class);
//    				//获得类中的所有方法
//    				Set<Method> totalMethod=ReflectUtil.findClassMethod(Profession.class);
                    list=getInfo(sheet);
                }

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public  List<House> getInfo(Sheet sheet){
        List<House> list =new ArrayList<>();
        int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数
        System.out.println(sheet.getSheetName());
        //遍历每一行
        for (int r = 2; r < rowCount; r++) {

            Row row = sheet.getRow(r);

//            System.out.println(sheet.getRow(0).getFirstCellNum());
            int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
            if(row.getCell(0).getNumericCellValue()==0)
                return list;
            //遍历每一列
            for (int c = 0; c < cellCount; c++) {

                Cell cell = row.getCell(c);
                int cellType = cell.getCellType();
                String cellValue = null;
                switch(cellType) {
                    case Cell.CELL_TYPE_STRING: //文本
                        cellValue = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC: //数字、日期
                        if(DateUtil.isCellDateFormatted(cell)) {
                            cellValue = String.valueOf(cell.getNumericCellValue());
                        }
                        else {
                            DecimalFormat df = new DecimalFormat("0");
                            cellValue = df.format(cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN: //布尔型
                        cellValue = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_BLANK: //空白
                        cellValue = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_ERROR: //错误
                        cellValue = "错误";
                        break;

                    default:
                        cellValue = "";
                }
                System.out.print(cellValue + "    ");
            }
            System.out.println();
        }
        return list;
    }
}