package com.testleaf.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static String[][] excelDataFetch(String fileName) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook("./data/" + fileName + ".xlsx");
		// index based approach , all excel index starts with 0
		XSSFSheet sheet = book.getSheetAt(0);
		// based on sheet name , book.getSheet("order");

		// It returns row count except header
		int rowCount = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(1);
		int cellCount = row.getLastCellNum();

		// create a string array to store the fetched data from excel wrt row and cell
		// count
		String[][] data = new String[rowCount][cellCount];

		// read the data from Excel sheet wrt to cell- two dimensional

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = stringCellValue;
			}
		}

		return data;

	}


}
