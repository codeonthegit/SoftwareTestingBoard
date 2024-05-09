package com.SoftwareTestingBoard.utility;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception {
		String path = ".\\TestData\\TestData.xlsx";
		ExcelUtility excelUtility = new ExcelUtility(path);
		int totalrows = excelUtility.getRowCount("Login");
		int totalcols = excelUtility.getCellCount("Login", 1);

		String testData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
				testData[i - 1][j] = excelUtility.getCellData("Login", i, j);  // 1 0
			}

		}

		return testData;
	}
	
	@DataProvider(name = "ChangePassword")
	public String[][] getData1() throws Exception {
		String path = ".\\TestData\\TestData.xlsx";
		ExcelUtility excelUtility = new ExcelUtility(path);
		int totalrows = excelUtility.getRowCount("ChangePwd");
		int totalcols = excelUtility.getCellCount("ChangePwd", 1);

		String testData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
				testData[i - 1][j] = excelUtility.getCellData("ChangePwd", i, j);  // 1 0
			}

		}

		return testData;
	}
}
