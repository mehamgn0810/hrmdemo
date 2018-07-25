package com.orangehrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility{

	private static Workbook wBook;
	private static Sheet sheet;

	public static void setExcelInstance(String path, String fileName, String sheetName) throws IOException {

		File f = new File(path + fileName);
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
		System.out.println(f.canRead());
		FileInputStream fis = new FileInputStream(f);

		String fileExt = fileName.substring(fileName.indexOf("."));

		if (fileExt.equals(".xlsx")) {
			wBook = new XSSFWorkbook(fis);
		} else if (fileExt.equals(".xls")) {
			wBook = new HSSFWorkbook(fis);
		}

		sheet = wBook.getSheet(sheetName);
	}

	public static Object[][] readExcel() {

		int lastRowNum = sheet.getLastRowNum();

		Object[][] data = new Object[lastRowNum][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < lastRowNum; i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}

	public static Object[][] readExcelWithBoundary(String tableName)
			throws IOException {

		Cell[] boundaryCells = getBoundaryCells(tableName);
		
		int firstRow = boundaryCells[0].getRowIndex();
		int lastRow = boundaryCells[1].getRowIndex();
		int rowsCount = lastRow - firstRow;

		int firstCell = boundaryCells[0].getColumnIndex();
		int lastCell = boundaryCells[1].getColumnIndex();
		int cellsCount = lastCell - firstCell - 1;

		Object[][] testdata = new Object[rowsCount][cellsCount];

		for (int i = 0; i < rowsCount; i++) {
			for (int j = 0; j < cellsCount; j++) {
				testdata[i][j] = sheet.getRow(i+firstRow+1).getCell(j+firstCell+1).getStringCellValue();
			}
		}

		return testdata;
	}

	public static Cell[] getBoundaryCells(String tableName) {

		Cell[] cells = new Cell[2];
		String pos = "begin";

		for (Row row : sheet) {
			for (Cell cell : row) {
				if (tableName.equals(cell.getStringCellValue())) {
					if (pos.equals("begin")) {
						cells[0] = cell;
						pos = "end";
					} else if (pos.equals("end")) {
						cells[1] = cell;
					}
				}
			}
		}

		return cells;
	}

	public static void writeExcel(String pathName, String fileName, String sheetName, String writeData)
			throws IOException {

		Workbook wb = null;

		// Create an object of File class to open xlsx file
		File f = new File(pathName + fileName);
		FileInputStream fis = new FileInputStream(f);

		String fileExt = fileName.substring(fileName.indexOf("."));

		if (fileExt.equals(".xlsx")) {
			wb = new XSSFWorkbook(fis);
		} else if (fileExt.equals(".xls")) {
			wb = new HSSFWorkbook(fis);
		}

		Sheet mySheet = wb.getSheet(sheetName);
		int firstRowNum = mySheet.getFirstRowNum();

		int lastRowNum = mySheet.getLastRowNum();

		int rowsCount = lastRowNum - firstRowNum + 1;

		for (int i = 0; i < lastRowNum; i++) {

			Row row = mySheet.getRow(i);
			Cell cell = row.createCell(5);
			cell.setCellValue(writeData);
		}

		fis.close();

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

		fos.close();
	}

}
