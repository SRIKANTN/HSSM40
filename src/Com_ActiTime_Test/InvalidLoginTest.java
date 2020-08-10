package Com_ActiTime_Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Page.actiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority = 2)
	public void InvalidLogin() throws InterruptedException
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		String eErrorMessage = ExcelData.getData(file_path, "TC02", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		//verify the login page title
		lp.verifyTitle(title);
		int rc = ExcelData.getRowCount(file_path, "TC02");
		for(int i = 1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			//Enter invalid username
			Reporter.log("User Name = "+un,true);
			lp.enterUserName(un);
			//Enter invalid password
			Reporter.log("Password = "+pw,true);
			lp.enterPassword(pw);
			//click on login button
			lp.clickOnLogin();
			String aErrorMessage = lp.errorMessage();
			//Verify Error message
			Assert.assertEquals(aErrorMessage, eErrorMessage);
			Reporter.log("============================",true);
			Thread.sleep(1000);
		}
	}

}
