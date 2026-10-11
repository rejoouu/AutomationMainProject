package testpkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Cart_page;
import pagepkg.Home_page;
import pagepkg.Login_page;
import pagepkg.Products_detail_page;
import pagepkg.Products_page;


public class Login_test extends Base_class{
	
	    Home_page hom;
	    Products_page pro;
	    Cart_page cart;
	    Login_page log;
	    Products_detail_page detail;
	
@DataProvider(name = "loginData")
	
	public Object[][] loginData() throws IOException {

	    return Utilities.Excelutils.getTestData("C:\\Users\\ronir\\OneDrive\\ye concert\\TestStore.xlsx","Sheet1");
	}

  @BeforeClass
  public void setupShoppingFlow() throws InterruptedException {
	  

    hom = new Home_page(driver);
    hom.searchProduct("conditioner");

    pro = new Products_page(driver);
    pro.clickProduct();

    detail = new Products_detail_page(driver);
    detail.selectSize("8 oz");
    detail.enterQuantity("2");
    detail.clickAddToCart();

    cart = new Cart_page(driver);
    cart.clickCheckout();

    log = new Login_page(driver);
}

@Test(dataProvider = "loginData",priority=1)
public void Login(String uname, String password)
        throws InterruptedException, IOException {
	
	
    test = extent.createTest("Login Test - " + uname);
    System.out.println("Current URL: " + driver.getCurrentUrl());
    System.out.println("Page title: " + driver.getTitle());
    log.logintests(uname, password);

    Thread.sleep(3000);

    String currentUrl = driver.getCurrentUrl();

    if (currentUrl.contains("checkout/confirm")) {
        test.pass("Login successful for user: " + uname);
    } else {
        String screenshotPath =
            Reporter_class.screenshotMethod(driver, "Failed for " + uname);

        test.addScreenCaptureFromPath(screenshotPath);
        test.fail("Login validation failed");
        Assert.fail("Login validation failed for " + uname);
    }
}

}
