package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Home_page;
import pagepkg.Products_page;

public class Products_test extends Base_class{
	
	Home_page hom;
	Products_page pro;
	

		    @Test
		    public void productTest() throws IOException
		    {
		    	driver.get("https://automationteststore.com/");
		    	
		        test = extent.createTest("Product Test");

		        hom = new Home_page(driver);

		        hom.searchProduct("conditioner");

		        pro = new Products_page(driver);

		        // Page title verification
		        String title = pro.getPageTitle();

		        if (title.equals("Search"))
		        {
		            test.pass("Page title is correct");
		        }
		        else
		        {
		            String screenshotName = "ProductPageTitleFailed";

		            Reporter_class.screenshotMethod(driver, screenshotName);

		            test.addScreenCaptureFromPath(
		                    "./Reports/screenshots/" + screenshotName + ".png");

		            test.fail("Page title is incorrect. Actual title: " + title);

		            Assert.fail("Page title verification failed");
		        }
		        
		        // Verify product is displayed
		        if (pro.verifyProduct())
		        {
		            test.pass("Seaweed Conditioner is displayed");
		        }
		        else
		        {
		            String screenshotName = "ProductNotDisplayed";

		            Reporter_class.screenshotMethod(driver, screenshotName);

		            test.addScreenCaptureFromPath(
		                    "./Reports/screenshots/" + screenshotName + ".png");

		            test.fail("Seaweed Conditioner is not displayed");

		            Assert.fail("Product verification failed");
		        }

		     // Print all product details
		        pro.printAllProductDetails();

		        test.pass("All product details printed successfully");
		    }
		    
		    @Test
		    public void sortTest() throws IOException
		    {
		    	driver.get("https://automationteststore.com/");
		        test = extent.createTest("Sort Product Test");

		        hom = new Home_page(driver);
		        hom.searchProduct("conditioner");

		        pro = new Products_page(driver);

		        if (pro.verifySort())
		        {
		            test.pass("Sort dropdown is displayed");
		        }
		        else
		        {
		            String screenshotName = "SortDropdownFailed";

		            Reporter_class.screenshotMethod(driver, screenshotName);

		            test.addScreenCaptureFromPath(
		                    "./Reports/screenshots/" + screenshotName + ".png");

		            test.fail("Sort dropdown is not displayed");

		            Assert.fail("Sort dropdown verification failed");
		        }
		        
		        //sorting
		        pro.sortByPriceLowToHigh();

		        test.pass("Products sorted by Price Low to High successfully");
		        
		        // Click product
		        pro.clickProduct();

		        test.pass("Product clicked successfully");
		        
		       
		    }
		    
		    
	}

