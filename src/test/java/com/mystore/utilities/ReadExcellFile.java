package com.mystore.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcellFile {
	
	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName, String sheetName, int rowNo,int cellNo) {
		
		try {
			inputStream=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(inputStream);
			cell=workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			 workBook.close();
			 workBook.close();
			 return cell.getStringCellValue();
			
		} catch (Exception e) {
			return "";
		}

	}
	
	public static int getRowCount(String fileName,String sheetName) {
		
		try {
			
			inputStream=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(inputStream);
			excelSheet= workBook.getSheet(sheetName);
			int ttlRows=excelSheet.getLastRowNum();
			workBook.close();
			
			return ttlRows;
			
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	public static int getColCount(String fileName,String sheetName) {
		
		try {
			inputStream=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(inputStream);
			int ttlRow=workBook.getSheet(sheetName).getRow(0).getLastCellNum();
			workBook.close();
			return ttlRow;
		} catch (Exception e) {

			return 0;
		}
		
		
	}
	
	

}
