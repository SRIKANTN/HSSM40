package Com_ActiTime_Generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtils 
{
	/***
	 * 
	 * @param webdriver reference
	 * @param screen shot name
	 * @author srikanth
	 * @category screen shot
	 * @
	 */
	public static void getScreenShot(WebDriver driver,String name)
	{
		Date d = new Date();
//		String date = d.toString().replaceAll(":","_");
		SimpleDateFormat s1 = new SimpleDateFormat("dd_MM_yyyy");
		String date = s1.format(d);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+date+"_"+name+".png");
		try
		{
			Files.copy(src, dest);
		}
		catch (Exception e) 
		{
		}
	}
	
	
	public static void selectByIndex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
