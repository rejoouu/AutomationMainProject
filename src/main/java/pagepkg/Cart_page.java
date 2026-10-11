package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_page {
	

    WebDriver driver;

    @FindBy(linkText = "Seaweed Conditioner")
    WebElement productName;
    
    @FindBy(xpath = "//a[text()='Seaweed Conditioner']/ancestor::tr//td[contains(@class,'align_right')]")
    WebElement productPrice;
    
    @FindBy(id = "cart_checkout1")
    WebElement checkoutButton;
    
    @FindBy(css = "td.align_left")
    WebElement productModel;
    
    @FindBy(id = "cart_update")
    WebElement updateButton;
    
    @FindBy(css = "a[href*='remove=']")
    WebElement removeButton;
    
    @FindBy(xpath = "//td[@class='align_right']")
    WebElement cartTotal;
    
    @FindBy(css = "span.maintext")
    WebElement cartHeading;
    
    @FindBy(css = "span.contentpanel")
    WebElement emptyCartMessage;
    
    


    public Cart_page(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyProductName() {
    return productName.isDisplayed();    
    }
    
    public boolean verifyProductPrice() {
        return productPrice.isDisplayed();
    }
    
    public boolean verifyCheckoutButton() {
        return checkoutButton.isDisplayed();
    }
    
    public boolean verifyProductModel() {
        return productModel.isDisplayed();
    }
    
    public boolean verifyUpdateButton() {
        return updateButton.isDisplayed();
    }
    
    public void clickUpdate() {
        updateButton.click();
    }
    
    public boolean verifyRemoveButton() {
        return removeButton.isDisplayed();
    }
    
    public boolean verifyCartTotal() {
        return cartTotal.isDisplayed();
    }
    
    public boolean verifyCartHeading() {
        return cartHeading.isDisplayed();
    }
    
    public void clickCheckout() {
        checkoutButton.click();
    }
    
    public void clickRemove() {
        removeButton.click();
    }
    
    public boolean verifyProductRemoved() {
        return driver.findElements(By.linkText("Seaweed Conditioner")).isEmpty();
    }

}
