package testExamples.StartingWithExel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//If exel file exist write into it else create and writes into it
public class WriteDataIntoExel {
	
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of rows: ");
		int rows=sc.nextInt();
		System.out.println("Enter number of columns:");
		int cols=sc.nextInt();
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("DataSheet");
		
		for(int i=0;i<=rows;i++)
		{
			System.out.println("Enter row"+i+"Value");
			XSSFRow row=sheet.createRow(i);
			for(int j=0;j<cols;j++)
			{
				XSSFCell cell=row.createCell(j);
				System.out.println("Enter col"+i+" "+j+"value");
				cell.setCellValue(sc.next());
			}
		}
		
		FileOutputStream out=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\writeFile.xlsx");
		
		workbook.write(out);
		workbook.close();
		
		out.close();
		
		System.out.println("Created sucessfully.....");
		
	}
	
}
