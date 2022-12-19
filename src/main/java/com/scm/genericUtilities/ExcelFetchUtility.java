package com.scm.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class used to store methods associated with excel sheet
 * @author HP
 *
 */
public class ExcelFetchUtility {
	FileInputStream fis = null;
	Workbook w = null;

	/**
	 * this method used to get data from excel sheet
	 * 
	 * @param excelPath
	 * @param SheetName
	 * @param rownum
	 * @param columnnum
	 * @return
	 */
	public String getFromExcelSheet(String excelPath, String SheetName, int rownum, int columnnum) {

		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {

		}
		try {
			w = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {

		} catch (IOException e) {

		}
		DataFormatter df = new DataFormatter();
		String data = df.formatCellValue(w.getSheet(SheetName).getRow(rownum).getCell(columnnum));
		return data;
	}

	public String[][] getFromExcelSheet(String excelPath, String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
		}
		try {
			w = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
		} catch (IOException e) {
		}

		int rnum = w.getSheet(sheetName).getLastRowNum();
		int cnum = w.getSheet(sheetName).getRow(0).getLastCellNum();
		DataFormatter df = new DataFormatter();

		String[][] arr = new String[rnum][cnum];
		for (int i = 0; i < rnum; i++) {
			for (int j = 0; j < cnum; j++) {
				arr[i][j] = df.formatCellValue(w.getSheet("practice").getRow(i + 1).getCell(j));
			}
		}
		return arr;
	}

	/**
	 * this method used to close excel sheet
	 */
	public void closeExcel() {
		try {
			w.close();
			fis.close();
		} catch (IOException e) {

		}
	}
}
