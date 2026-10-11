package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Home_page;

public class Home_test extends Base_class {
	
	Home_page hom;
	
	 @Test(priority = 1)
	    public void verifyHomePage() throws IOException {
		 
		 driver.get("https://automationteststore.com/");

	        hom = new Home_page(driver);

	        test = extent.createTest("Home Page Verification");

	        // Logo Verification
	        if (hom.verifyLogo()) {
	            test.pass("Automation Test Store logo is displayed");
	        } else {
	            String screenshotName = "Logo Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Automation Test Store logo is not displayed");
	            Assert.fail("Automation Test Store logo is not displayed");
	        }

	        // Search Box Verification
	        if (hom.verifySearchBox()) {
	            test.pass("Search box is displayed");
	        } else {
	            String screenshotName = "Search Box Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Search box is not displayed");
	            Assert.fail("Search box is not displayed");
	        }

	        // Search Button Verification
	        if (hom.verifySearchButton()) {
	            test.pass("Search button is displayed");
	        } else {
	            String screenshotName = "Search Button Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Search button is not displayed");
	            Assert.fail("Search button is not displayed");
	        }

	        // Login or Register Verification
	        if (hom.verifyLoginRegister()) {
	            test.pass("Login or register link is displayed");
	        } else {
	            String screenshotName = "Login Register Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Login or register link is not displayed");
	            Assert.fail("Login or register link is not displayed");
	        }

	        // Cart Verification
	        if (hom.verifyCart()) {
	            test.pass("Cart is displayed");
	        } else {
	            String screenshotName = "Cart Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Cart is not displayed");
	            Assert.fail("Cart is not displayed");
	        }

	        // Navigation Menu Verification
	        if (hom.verifyNavigationMenu()) {
	            test.pass("Navigation menu is displayed");
	        } else {
	            String screenshotName = "Navigation Menu Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Navigation menu is not displayed");
	            Assert.fail("Navigation menu is not displayed");
	        }

	        // Featured Section Verification
	        if (hom.verifyFeatured()) {
	            test.pass("Featured section is displayed");
	        } else {
	            String screenshotName = "Featured Section Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Featured section is not displayed");
	            Assert.fail("Featured section is not displayed");
	        }

	        // Featured Product Verification
	        if (hom.verifyFeaturedProduct()) {
	            test.pass("Featured product is displayed");
	        } else {
	            String screenshotName = "Featured Product Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Featured product is not displayed");
	            Assert.fail("Featured product is not displayed");
	        }

	        // Footer Verification
	        if (hom.verifyFooterSocial()) {
	            test.pass("Footer social section is displayed");
	        } else {
	            String screenshotName = "Footer Verification Failed";
	            Reporter_class.screenshotMethod(driver, screenshotName);
	            test.addScreenCaptureFromPath("./Reports/screenshots/" + screenshotName + ".png");
	            test.fail("Footer social section is not displayed");
	            Assert.fail("Footer social section is not displayed");
	        }
	    }

}
