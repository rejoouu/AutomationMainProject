package pagepkg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	
	 WebDriver driver;

	 @FindBy(css = "img[alt='Automation Test Store']")
	 WebElement logo;
	 
	 @FindBy(id = "filter_keyword")
	 WebElement searchBox;
	 
	 @FindBy(css = "div.button-in-search[title='Go']")
	 WebElement searchButton;
	 
	 @FindBy(linkText = "Login or register")
	 WebElement loginRegister;
	 
	 @FindBy(css = "a.top.nobackground[href*='checkout/cart']")
	 WebElement cart;
	 
	 @FindBy(id = "categorymenu")
	 WebElement navigationMenu;
	 
	 @FindBy(css = "span.maintext")
	 WebElement featured;
	 
	 @FindBy(css = "a.prdocutname")
	 WebElement featuredProduct;
	 
	 @FindBy(css = "section.footersocial")
	 WebElement footerSocial;
	 
	 
	 public Home_page(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements( driver,this);
		// TODO Auto-generated constructor stub
	}

	 public boolean verifyLogo()
	 {
	     return logo.isDisplayed();
	 }
	 
	 public boolean verifySearchBox()
	 {
	     return searchBox.isDisplayed();
	 }
	 
	 public boolean verifySearchButton()
	 {
	     return searchButton.isDisplayed();
	 }
	 
	 public boolean verifyLoginRegister()
	 {
	     return loginRegister.isDisplayed();
	 }
	 
	 public boolean verifyCart()
	 {
	     return cart.isDisplayed();
	 }
	 
	 public boolean verifyNavigationMenu()
	 {
	     return navigationMenu.isDisplayed();
	 }
	 
	 public boolean verifyFeatured()
	 {
	     return featured.isDisplayed();
	 }
	 
	  public boolean verifyFeaturedProduct()
	 {
	     return featuredProduct.isDisplayed();
	 }
	  
	  public boolean verifyFooterSocial()
	  {
	      return footerSocial.isDisplayed();
	  }
	  
	  public void searchProduct(String product)
	  {
	      searchBox.sendKeys(product);
	      searchButton.click();
	  }
	  
	  public void clickCart() {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", cart);
		    cart.click();
		}
	 
}
