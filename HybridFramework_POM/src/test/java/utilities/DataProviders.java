package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import testBase.BaseClass;

public class DataProviders {

	// DataProvider 1
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		System.out.println("DataProvider Started");

		String path = System.getProperty("user.dir") + "//testdata//LoginData.xlsx";

		ExelUtility util = new ExelUtility(path);

		int rows = util.getRowCount("Sheet1");
		int cols = util.getCellCount("Sheet1", 1);

		System.out.println("Rows: " + rows);
		System.out.println("Cols: " + cols);

		String[][] logData = new String[rows][cols];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				logData[i - 1][j] = util.getCellValue("Sheet1", i, j);
			}
		}
		return logData;
	}

}
