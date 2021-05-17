package com.payBox.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		int rowCount = sheet.getLastRowNum();
//		wb.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
//		wb.close();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e) {
			data = "";
		}
		
//		wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlSheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
//		wb.close();
		fi.close();
		fo.close();
	}
}
