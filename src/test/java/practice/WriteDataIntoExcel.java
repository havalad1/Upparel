package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// 1. create object for fileinputstream
		FileInputStream fis = new FileInputStream("./src/test/resources/scmtestdata.xlsx");
		// 2.open the workbook
		Workbook w = WorkbookFactory.create(fis);
		// 3.get control on particular sheet
		Sheet sheet = w.getSheet("product_addproducts");
		int lastrownum = sheet.getLastRowNum();
		short lastcellvalue = sheet.getRow(1).getLastCellNum();
		// 4.get the control on particular row
		Row row = sheet.getRow(1);
		// 5.get the control on particular cell and create the cell
		Cell cell = row.createCell(4);
		// 6.set the data into cell
		cell.setCellValue("pass");
		// 7.save the excel file
		FileOutputStream fos = new FileOutputStream("./src/test/resources/scmtestdata.xlsx");
		w.write(fos);
		w.close();
		fis.close();
		System.out.println("data updated successfully");
	}
}
