package testExamples.StartingWithExel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// File > workBook > sheet > row > cell

public class ReadDataFromExel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testData\\DDT_ex_1.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(file);
		
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
		
		int col=sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total rows :"+rows);		// rows count from 0,1,2,.....
		System.out.println("Total coloumns :"+col);		//coloumns count form 1,2,3....
		
		System.out.println();
		for(int r=0;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<col;c++)
			{
				XSSFCell cell=row.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		wb.close();
		file.close();
		
	}

}
