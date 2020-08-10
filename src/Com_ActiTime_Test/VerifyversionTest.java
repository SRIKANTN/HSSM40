package Com_ActiTime_Test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Page.actiTIMELoginPage;

public class VerifyversionTest extends BaseTest
{
	@Test(priority = 3)
	public void Verifyversion()
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		String eVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		//verify the login page title
		lp.verifyTitle(title);
		String aVersion = lp.verifyVersion();
		SoftAssert sa = new SoftAssert();
		//Verify version
		sa.assertEquals(aVersion, eVersion);
		Reporter.log("Matching version "+aVersion,true);
		sa.assertAll();
	}
}
