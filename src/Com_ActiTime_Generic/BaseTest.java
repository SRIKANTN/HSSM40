package Com_ActiTime_Generic;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements Autoconstant
{
	public WebDriver driver;
//	static
//	{
//		System.setProperty(chrome_key, chrome_value);
//		System.setProperty(firefox_key, firefox_value);
//	}
	@Parameters({"nodeURL","browser","appURL"})
	@BeforeMethod
	public void Precondition(String nodeURL, String browser, String appURL) throws MalformedURLException
	{
		URL url = new URL(nodeURL);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver = new RemoteWebDriver(url, dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(appURL);
		
	}
	@AfterMethod
	public void Postcondition(ITestResult res)
	{
		int status  = res.getStatus();
		if(status== 2)
		{
			GenericUtils.getScreenShot(driver, res.getName());
		}
		driver.close();
	}
}

