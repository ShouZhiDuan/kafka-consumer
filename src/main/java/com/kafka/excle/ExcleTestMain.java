package com.kafka.excle;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: ShouZhi@Duan
 * @Description:
 */
public class ExcleTestMain {

    public static void main(String[] args) {
        try {
            showExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  void showExcel() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("E:/as/vte-real.xls")));
        HSSFSheet sheet = null;
        System.out.println("sheet页数量：" + workbook.getNumberOfSheets());
        List<String> titles = new ArrayList<>();
        List<List<String>> values = new ArrayList<>();

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            List<String> sheetData = new ArrayList<>();
            sheet = workbook.getSheetAt(i);
            for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
                HSSFRow row = sheet.getRow(j);
                //行
                for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
                    if(k == 0 && i == 0){
                           titles.add(row.getCell(k) == null ? "无题目" : row.getCell(k).getStringCellValue());
                    }
                    if (k == 1){
                        sheetData.add(row.getCell(k) == null ? "无答案" : row.getCell(k).getStringCellValue());
                    }
                }
            }
            values.add(sheetData);
            System.out.println("---Sheet表"+i+"处理完毕---");
        }
        //开始导出
        String[] array = titles.stream().toArray(String[]::new);
        exportExcelPaper(values,array);
    }



    // 设置列宽()
    private static void setColumnWidth(XSSFSheet sheet, int colNum) {
        for (int i = 0; i < colNum; i++) {
            int v = 0;
            v = Math.round(Float.parseFloat("15.0") * 37F);
            v = Math.round(Float.parseFloat("20.0") * 267.5F);
            sheet.setColumnWidth(i, v);
        }
    }

    public static void exportExcelPaper(List<List<String>> list, String[] title) {
        // 标题
        //String[] title = { "题目", "类型", "A选项", "B选项", "C选项", "D选项", "答案", "解析" };
        // 创建一个工作簿
        //HSSFWorkbook workbook = new HSSFWorkbook();
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个工作表sheet
        XSSFSheet sheet = workbook.createSheet();
        // 设置列宽
        setColumnWidth(sheet, 8);
        // 创建第一行
        XSSFRow row = sheet.createRow(0);
        // 创建一个单元格
        XSSFCell cell = null;
        // 创建表头
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            // 设置样式
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 13);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(title[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            XSSFRow nextRow = sheet.createRow(i+1); // 创建第i行
            for (int j = 0; j < list.get(i).size(); j++) {
                XSSFCell cell2 = nextRow.createCell(j);
                cell2.setCellValue(list.get(i).get(j));
            }
        }
        // 创建一个文件
        File file = new File("E:/VTE已提交数据.xls");
        try {
            file.createNewFile();
            // 打开文件流
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
