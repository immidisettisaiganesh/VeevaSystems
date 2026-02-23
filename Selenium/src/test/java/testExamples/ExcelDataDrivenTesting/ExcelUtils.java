package testExamples.ExcelDataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        int rowcount = ws.getLastRowNum();

        wb.close();
        fi.close();

        return rowcount;
    }

    public static int getCellCount(String xlfile, String xlsheet, int rowNum) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        row = ws.getRow(rowNum);
        int cellcount = row.getLastCellNum();

        wb.close();
        fi.close();

        return cellcount;
    }

    public static String getCellData(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        wb.close();
        fi.close();

        return data;
    }

    public static void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data)
            throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        row = ws.getRow(rowNum);
        if (row == null)
            row = ws.createRow(rowNum);

        cell = row.getCell(colNum);
        if (cell == null)
            cell = row.createCell(colNum);

        cell.setCellValue(data);

        fi.close();

        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        fo.close();
        wb.close();
    }

    public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        row = ws.getRow(rownum);
        if (row == null)
            row = ws.createRow(rownum);

        cell = row.getCell(colnum);
        if (cell == null)
            cell = row.createCell(colnum);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        fi.close();

        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        fo.close();
        wb.close();
    }

    public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {

        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);

        row = ws.getRow(rownum);
        if (row == null)
            row = ws.createRow(rownum);

        cell = row.getCell(colnum);
        if (cell == null)
            cell = row.createCell(colnum);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);

        fi.close();

        fo = new FileOutputStream(xlfile);
        wb.write(fo);

        fo.close();
        wb.close();
    }
}
