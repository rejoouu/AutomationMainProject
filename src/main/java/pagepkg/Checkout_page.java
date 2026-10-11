package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_page {
	
	 WebDriver driver;

	    @FindBy(css = "span.maintext")
	    WebElement checkoutHeading;
	    
	    @FindBy(xpath = "//span[text()='Order Summary']")
	    WebElement orderSummary;
	    
	    @FindBy(linkText = "Seaweed Conditioner")
	    WebElement productName;
	    
	    @FindBy(xpath = "//td[contains(text(),'2 x')]")
	    WebElement productQuantity;

	    @FindBy(xpath = "//span[@class='bold totalamout' and contains(text(),'$40.00')]")
	    WebElement productTotal;
	    
	    @FindBy(id = "checkout_btn")
	    WebElement confirmOrderButton;
	    
	    
	    public Checkout_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	    	// TODO Auto-generated constructor stub
		}

		public boolean verifyCheckoutHeading() {
	        return checkoutHeading.isDisplayed();
	    }
	    
	    public boolean verifyOrderSummary() {
	        return orderSummary.isDisplayed();
	    }
	    
	    public boolean verifyProductName() {
	        return productName.isDisplayed();
	    }
	    
	    public boolean verifyProductQuantity() {
	        return productQuantity.isDisplayed();
	    }
	    
	    public boolean verifyProductTotal() {
	        return productTotal.isDisplayed()
	                && productTotal.getText().equals("$40.00");
	        
	        
	    }
	    
	    public boolean verifyConfirmOrderButton() {
	        return confirmOrderButton.isDisplayed()
	                && confirmOrderButton.isEnabled();
	    }
	    
	    public void clickConfirmOrder() {
	        confirmOrderButton.click();
	    }
	    
	    
	   
}
