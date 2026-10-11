package basepkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter_class {
	
	WebDriver driver;
	ExtentTest test;
	public static ExtentReports generatereport()
	{
		ExtentSparkReporter reporter= new ExtentSparkReporter (".\\Reports\\TestStore.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("os", "Windows 11");
        extent.setSystemInfo("tester name", "rejo");
        extent.setSystemInfo("browsername", "chrome");
        
        return extent;
        
	}
	
	 @AfterMethod
	    public void browserclose(ITestResult result) throws IOException {

	        if (result.getStatus() == ITestResult.FAILURE) {

	            test.log(Status.FAIL,"Test case failed: " + result.getName());

	            test.log(Status.FAIL,"Error: " + result.getThrowable());

	            String screenshotpath =screenshotMethod(driver, result.getName());

	            test.addScreenCaptureFromPath(screenshotpath);
	        }

	        else if (result.getStatus() == ITestResult.SKIP) {

	            test.log(Status.SKIP,"Test case skipped: " + result.getName());
	        }

	        else if (result.getStatus() == ITestResult.SUCCESS) {

	            test.log(Status.PASS,
	                    "Test case passed: " + result.getName());
	        }
	    }

	    public static String screenshotMethod(WebDriver driver,String screenshotname)
	            throws IOException {

	        File src = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.FILE);

	        String destination = "./Reports/screenshots/" + screenshotname + ".png";

	        FileHandler.copy(src, new File(destination));

	        return destination;
	    }

}
