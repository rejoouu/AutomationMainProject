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
import pagepkg.Success_page;

public class Success_test extends Base_class {
	
	  Checkout_page chec;
	  Home_page hom;
	  Products_page pro;
	  Cart_page cart;
	  Login_page log;
	  Success_page suc;

	
	    @Test
	    public void verifyOrderSuccess() throws Exception {
	    	
	    	driver.get("https://automationteststore.com/");

	        test = extent.createTest("Order Success Page Verification");
	        
           

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
	        chec.clickConfirmOrder();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.urlContains("checkout/success"));


	        suc = new Success_page(driver);

	        // Success Heading Verification
	        if (suc.verifySuccessHeading()) {
	            test.pass("Success heading is displayed");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "SuccessHeading_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Success heading is not displayed");
	            Assert.fail("Success heading verification failed");
	        }

	        // Order Message Verification
	        if (suc.verifyOrderMessage()) {
	            test.pass("Order confirmation message is displayed");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "OrderMessage_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Order confirmation message is not displayed");
	            Assert.fail("Order message verification failed");
	        }

	        // Order Number Verification
	        if (suc.verifyOrderNumber()) {
	            test.pass("Order number format is verified");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "OrderNumber_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Order number verification failed");
	            Assert.fail("Order number verification failed");
	        }

	        // Invoice Link Verification
	        System.out.println("Current URL: " + driver.getCurrentUrl());
	        if (suc.verifyInvoiceLink()) {
	            test.pass("Invoice link is displayed and enabled");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "InvoiceLink_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Invoice link verification failed");
	            Assert.fail("Invoice link verification failed");
	        }

	        // Store Owner Link Verification
	        if (suc.verifyStoreOwnerLink()) {
	            test.pass("Store owner link is displayed and enabled");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "StoreOwnerLink_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Store owner link verification failed");
	            Assert.fail("Store owner link verification failed");
	        }

	        // Continue Button Verification
	        if (suc.verifyContinueButton()) {
	            test.pass("Continue button is displayed and enabled");
	        } else {
	            String screenshotPath = Reporter_class.screenshotMethod(
	                    driver, "ContinueButton_Failed");
	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Continue button verification failed");
	            Assert.fail("Continue button verification failed");
	        }
	        
	        suc.clickContinueButton();
	    }

}
