package testpkg;



import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Cart_page;
import pagepkg.Home_page;
import pagepkg.Products_detail_page;
import pagepkg.Products_page;

public class Cart_test extends Base_class{
	
	    Home_page hom;
	    Products_page pro;
	    Cart_page cart;

	    @Test(priority=2)
	    public void cartTest() throws Exception {

	        test = extent.createTest("Cart Page Test");

	        hom = new Home_page(driver);
	        hom.searchProduct("conditioner");

	        pro = new Products_page(driver);
	        pro.clickProduct();

	        Products_detail_page detail =
	                new pagepkg.Products_detail_page(driver);

	        detail.selectSize("8 oz");
	        detail.enterQuantity("2");
	        detail.clickAddToCart();

	        cart = new Cart_page(driver);

	        if (cart.verifyCartHeading()) {
	            test.pass("Cart heading is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "CartHeadingFailed");
	            test.fail("Cart heading is not displayed");
	            Assert.fail("Cart heading verification failed");
	        }

	        if (cart.verifyProductName()) {
	            test.pass("Product name is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "CartProductNameFailed");
	            test.fail("Product name is not displayed");
	            Assert.fail("Product name verification failed");
	        }

	        if (cart.verifyProductModel()) {
	            test.pass("Product model is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "CartProductModelFailed");
	            test.fail("Product model is not displayed");
	            Assert.fail("Product model verification failed");
	        }

	        if (cart.verifyProductPrice()) {
	            test.pass("Product price is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "CartProductPriceFailed");
	            test.fail("Product price is not displayed");
	            Assert.fail("Product price verification failed");
	        }

	        if (cart.verifyUpdateButton()) {
	            test.pass("Update button is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "UpdateButtonFailed");
	            test.fail("Update button is not displayed");
	            Assert.fail("Update button verification failed");
	        }

	        if (cart.verifyRemoveButton()) {
	            test.pass("Remove button is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "RemoveButtonFailed");
	            test.fail("Remove button is not displayed");
	            Assert.fail("Remove button verification failed");
	        }

	        if (cart.verifyCartTotal()) {
	            test.pass("Cart total is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "CartTotalFailed");
	            test.fail("Cart total is not displayed");
	            Assert.fail("Cart total verification failed");
	        }

	        if (cart.verifyCheckoutButton()) {
	            test.pass("Checkout button is displayed");
	        } else {
	            Reporter_class.screenshotMethod(driver, "CheckoutButtonFailed");
	            test.fail("Checkout button is not displayed");
	            Assert.fail("Checkout button verification failed");
	        }
	        
	        cart.clickCheckout();
	        String currentUrl = "https://automationteststore.com/index.php?rt=account/login";
	        if (currentUrl.equals(driver.getCurrentUrl())) {
	            test.pass("Checkout navigation successful. Current URL: " + currentUrl);
	        } else {
	            Reporter_class.screenshotMethod(driver, "CheckoutFailed");
	            test.fail("Checkout navigation failed. Current URL: " + currentUrl);
	            Assert.fail("Checkout URL verification failed");
	        }
	    }
	    
	    @Test(priority=1)
	    public void removeProductTest() {
	    	
	    	

	        test = extent.createTest("Remove Product Test");
	       
	        hom = new Home_page(driver);
	        hom.searchProduct("conditioner");

	        pro = new Products_page(driver);
	        pro.clickProduct();
	        
	        Products_detail_page detail =
	                new pagepkg.Products_detail_page(driver);

	        detail.selectSize("8 oz");
	        detail.enterQuantity("2");
	        detail.clickAddToCart();
	        
	        cart = new Cart_page(driver);
	        cart.clickRemove();

	        if (cart.verifyProductRemoved()) {
	            test.pass("Product was successfully removed from the cart");
	        } else {
	            test.fail("Product was not removed from the cart");
	            Assert.fail("Remove product verification failed");
	        }
	    }

}
