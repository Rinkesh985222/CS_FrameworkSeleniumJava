package com.mystore.utilities;

import java.io.FileInputStream;	

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static FileInputStream inputstream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo) {

		try {
			inputstream=new FileInputStream(fileName);

			workBook=new XSSFWorkbook(inputstream);
			excelSheet=workBook.getSheet(sheetName);
			cell=workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			workBook.close();
			return cell.getStringCellValue();
		}
		catch (Exception e) {

			return "";
		}
	}

	public static int getRowCount(String fileName, String sheetName) {

		try {
			inputstream=new FileInputStream(fileName);

			workBook=new XSSFWorkbook(inputstream);
			excelSheet=workBook.getSheet(sheetName);
			int ttlRow=excelSheet.getLastRowNum()+1;
			workBook.close();
			return ttlRow;
		}

		catch (Exception e) {

			return 0;
		}

	}

	public static int getColCount(String fileName,String sheetName) {

		try {
			inputstream=new FileInputStream(fileName);

			workBook=new XSSFWorkbook(inputstream);
			excelSheet=workBook.getSheet(sheetName);
			int ttlCol=excelSheet.getRow(0).getLastCellNum();
			workBook.close();
			return ttlCol;
		}

		catch (Exception e) {

			return 0;
		}

	}

}
