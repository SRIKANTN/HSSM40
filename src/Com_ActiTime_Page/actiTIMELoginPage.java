package Com_ActiTime_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_ActiTime_Generic.BasePage;

public class actiTIMELoginPage extends BasePage
{
	//Declaration
	@FindBy(id = "username")
	private WebElement unTB;
	
	@FindBy(name = "pwd")
	private WebElement pwTB;
	
	@FindBy(xpath = "//div[.='Login ']")
	private WebElement lgBT;
	
	@FindBy(xpath = "//span[.='Username or Password is invalid. Please try again.']")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//nobr[.='actiTIME 2020 Online']")
	private WebElement version;
	
	
	//Intilization
	public actiTIMELoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//Utilization
	
	//Enter the user name
	public void enterUserName(String un)
	{
		unTB.sendKeys(un);
	}
	//Enter the password
	public void enterPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	//click on login button
	public void clickOnLogin()
	{
		lgBT.click();
	}
	//verify The error message
	public String errorMessage()
	{
		verifyElement(errorMessage);
		String aErrorMessage = errorMessage.getText();
		return aErrorMessage;
	}
	
	//verify the Version
	public String verifyVersion()
	{
		verifyElement(version);
		String aVersion = version.getText();
		return aVersion;
	}

}
