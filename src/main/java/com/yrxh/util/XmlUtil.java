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
    List<House> houstList =new ArrayList<>();

    public static void main(String[] args){
        XmlUtil x=new XmlUtil();
        x.addInfo();
    }

    public  List<House> addInfo() {
        try {
            //同时支持Excel 2003、2007
            File excelFile = new File("D:/add3.xls"); //创建文件对象
            FileInputStream is = new FileInputStream(excelFile); //文件流
            Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的
            int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量
            //遍历每个Sheet
            House house=null;
            for (int s = 0; s < sheetCount; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                Row titleRow=sheet.getRow(1);
                if(titleRow!=null){
//                    int titleCount=titleRow.getPhysicalNumberOfCells();
//                    String[] titleNames=new String[titleCount];
////                    获取表中的列名
//                    for(int q=0;q<titleCount;q++){
//                        titleNames[q]=titleRow.getCell(q).getStringCellValue();
//                    }
//                    //获得类中的所有属性
//    				Set<Field> totalField=ReflectUtil.findClassField(Profession.class);
//    				//获得类中的所有方法
//    				Set<Method> totalMethod=ReflectUtil.findClassMethod(Profession.class);
                    getInfo(sheet);
//                    if(house !=null){
//                        list.add(house);
//                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return houstList;
    }

    public  void getInfo(Sheet sheet){
        int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数
        System.out.println(sheet.getSheetName());
        //遍历每一行
        for (int r = 3; r < rowCount; r++) {

            Row row = sheet.getRow(r);

//            System.out.println(sheet.getRow(0).getFirstCellNum());
            int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
            if(row.getCell(0).getNumericCellValue()==0)
                return;
            //遍历每一列\
            String[] list =new String[]{"","","","","","","","","","","","","","",""};
            for (int c = 0; c < cellCount && c<8; c++) {
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
                list[c] = cellValue;
            }
            setInfo3(list);
        }
    }

    public void setInfo(String[] list){
        for(String x:list){
            System.out.print(x);
        }
        System.out.println();
        House house = new House();
        house.setCommunity(list[1]);
        house.setLocation(list[2]);
        house.setOwner(list[3]);
        if(!list[4].equals(""))
            house.setArea(Integer.parseInt(list[4]));
        house.setPhone(list[5]);
        house.setHouseType1(list[6]);
        house.setHouseType2(list[7]);
        house.setHouseType3(list[8]);
        house.setRepair1(list[9]);
        house.setRepair2(list[10]);
        house.setRemark(list[11]);
        houstList.add(house);
    }

    public void setInfo1(String[] list){
        for(String x:list){
            System.out.print(x);
        }
        System.out.println();
        House house = new House();
        house.setOwner(list[2]);
        house.setCommunity(list[3]);
        house.setPhone(list[5]);
        house.setLocation(list[4]);
        house.setRemark(list[6]);
        houstList.add(house);
    }

    public void setInfo2(String[] list){
        for(String x:list){
            System.out.print(x);
        }
        System.out.println();
        House house = new House();
        house.setOwner(list[1]);
        house.setCommunity("金澄明珠");
        house.setPhone(list[5].equals("")?list[4]:list[4]+"/"+list[5]);
        house.setArea(Integer.parseInt(list[6]));
        house.setLocation(list[2]);
        houstList.add(house);
    }

    public void setInfo3(String[] list){
        for(String x:list){
            System.out.print(x);
        }
        System.out.println();
        House house = new House();
        house.setOwner(list[4]);
        house.setCommunity("澄湖水岸");
        house.setPhone(list[7]);
        house.setLocation(list[5]);
        houstList.add(house);
    }
}