package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Base_class {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	String url="https://automationteststore.com/";
	
	@BeforeSuite
	public void setup()
	{
		extent = Reporter_class.generatereport();
		driver= new ChromeDriver();
		driver.get(url);
//		driver.manage().window().maximize();
//		
	}
	
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
		extent.flush();
	}
	
	

}
