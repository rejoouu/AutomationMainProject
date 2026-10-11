package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Home_page;
import pagepkg.Products_detail_page;
import pagepkg.Products_page;

public class Product_details_test extends Base_class{
	
	    Home_page hom;
	    Products_page pro;
	    Products_detail_page detail;

	    @Test
	    public void productDetailsTest() throws IOException
	    {
	    	driver.get("https://automationteststore.com/");
	    	
	        test = extent.createTest("Product Details Test");

	        // Search for conditioner
	        hom = new Home_page(driver);
	        hom.searchProduct("conditioner");

	        // Click Seaweed Conditioner
	        pro = new Products_page(driver);
	        pro.clickProduct();

	        // Initialize product details page
	        detail = new Products_detail_page(driver);

	        // Verify product name
	        if (detail.verifyProductName())
	        {
	            test.pass("Product name is displayed");
	        }
	        else
	        {
	            String screenshotName = "ProductNameFailed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath(
	                    "./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Product name is not displayed");
	            Assert.fail("Product name verification failed");
	        }

	        // Verify product price
	        if (detail.verifyProductPrice())
	        {
	            test.pass("Product price is displayed");
	        }
	        else
	        {
	            String screenshotName = "ProductPriceFailed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath(
	                    "./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Product price is not displayed");
	            Assert.fail("Product price verification failed");
	        }

	        // Select size
	        detail.selectSize("8 oz");
	        test.pass("Product size selected");

	        // Enter quantity
	        detail.enterQuantity("2");
	        test.pass("Product quantity entered");

	        // Verify total price is displayed
	        if (detail.getTotalPrice() != null
	                && !detail.getTotalPrice().trim().isEmpty())
	        {
	            test.pass("Total price is displayed: " + detail.getTotalPrice());
	        }
	        else
	        {
	            String screenshotName = "TotalPriceFailed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath(
	                    "./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Total price is not displayed");
	            Assert.fail("Total price verification failed");
	        }

	        // Verify Add to Cart button
	        if (detail.verifyAddToCart())
	        {
	            test.pass("Add to Cart button is displayed");
	        }
	        else
	        {
	            String screenshotName = "AddToCartFailed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath(
	                    "./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Add to Cart button is not displayed");
	            Assert.fail("Add to Cart verification failed");
	        }
	        
	        // Add to cart
	        detail.clickAddToCart();
	    }

}
