package practice;

import com.scm.genericUtilities.BrowserAndApplicationLaunch;
import com.scm.genericUtilities.IConstantPath;
import com.scm.genericUtilities.PropertyFileFetchUtility;

public class AddRetailerTest 
{
	public static void main(String[] args) 
	{
		PropertyFileFetchUtility pffu=new PropertyFileFetchUtility();
		String browser=pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "browser");
		String url=pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "url");
		String username=pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "username");
		String password=pffu.getDataFromPropertyFile(IConstantPath.PROPERTY_FILE_PATH, "password");
		
		BrowserAndApplicationLaunch bal=new BrowserAndApplicationLaunch();
		bal.launch(null, null, 0);
		
	}

}
