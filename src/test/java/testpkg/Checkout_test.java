package testpkg;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Cart_page;
import pagepkg.Checkout_page;
import pagepkg.Home_page;
import pagepkg.Login_page;
import pagepkg.Products_detail_page;
import pagepkg.Products_page;

public class Checkout_test extends Base_class{
	
	  Checkout_page chec;
	  Home_page hom;
	  Products_page pro;
	  Cart_page cart;
	  Login_page log;


	  @Test
	    public void checkoutVerification() throws Exception {

	        test = extent.createTest("Checkout Page Verification");
	        
	   
	        hom = new Home_page(driver);
	        hom.searchProduct("conditioner");

	        pro = new Products_page(driver);
	        pro.clickProduct();
	        
	        Products_detail_page detail =
	                new Products_detail_page(driver);

	        detail.selectSize("8 oz");
	        detail.enterQuantity("2");
	        detail.clickAddToCart();

	        cart = new Cart_page(driver);
	        cart.clickCheckout();
	        
	        log=new Login_page(driver);
	        log.logintests("Reej2", "z3Vf@eNeLdx@7n4");

	        chec = new Checkout_page(driver);

	        // Checkout Heading Verification
	        if (chec.verifyCheckoutHeading()) {
	            test.pass("Checkout heading is displayed");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "CheckoutHeading_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Checkout heading is not displayed");
	            Assert.fail("Checkout heading verification failed");
	        }

	        // Order Summary Verification
	        if (chec.verifyOrderSummary()) {
	            test.pass("Order Summary is displayed");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "OrderSummary_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Order Summary is not displayed");
	            Assert.fail("Order Summary verification failed");
	        }

	        // Product Name Verification
	        if (chec.verifyProductName()) {
	            test.pass("Product Name is displayed");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "ProductName_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Product name is not displayed");
	            Assert.fail("Product name verification failed");
	        }

	        // Product Quantity Verification
	        if (chec.verifyProductQuantity()) {
	            test.pass("Product quantity is verified as 2");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "ProductQuantity_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Product quantity verification failed");
	            Assert.fail("Product quantity verification failed");
	        }

//	        // Product Total Verification
//	        if (chec.verifyProductTotal()) {
//	            test.pass("Product total is verified as $40.00");
//	        } else {
//	            String screenshotPath = Reporter_class.screenshotMethod(
//	                    driver, "ProductTotal_Failed");
//	            test.addScreenCaptureFromPath(screenshotPath);
//	            test.fail("Product total verification failed");
//	            Assert.fail("Product total verification failed");
//	        }

	        // Confirm Order Button Verification
	        if (chec.verifyConfirmOrderButton()) {
	            test.pass("Confirm Order button is displayed and enabled");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "ConfirmOrderButton_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Confirm Order button verification failed");
	            Assert.fail("Confirm Order button verification failed");
	        }

	     // Click Confirm Order
	        chec.clickConfirmOrder();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.urlContains("checkout/success"));

	        String currentUrl = driver.getCurrentUrl();

	        if (currentUrl.contains("checkout/success")) {
	            test.pass("Order confirmed successfully");
	        } else {
	            String screenshotPath =
	                    Reporter_class.screenshotMethod(driver, "OrderConfirmation_Failed");

	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Order confirmation failed");
	            Assert.fail("Order confirmation failed. Current URL: " + currentUrl);
	        }
	  }
	  
	  
}
