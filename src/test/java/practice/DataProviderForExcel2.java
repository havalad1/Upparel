package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scm.genericUtilities.ExcelFetchUtility;
import com.scm.genericUtilities.IConstantPath;

public class DataProviderForExcel2 {
	@DataProvider
	public String[][] getData() throws EncryptedDocumentException, IOException {
		ExcelFetchUtility efu = new ExcelFetchUtility();
		String[][] arr = efu.getFromExcelSheet(IConstantPath.EXCEL_PATH, "practice");
		return arr;
	}

	@Test(dataProvider = "getData")
	public void main(String username, String password) {
		System.out.println("username----->" + username + "      password------->" + password);
	}
}
