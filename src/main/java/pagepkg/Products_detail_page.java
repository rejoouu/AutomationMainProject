package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Products_detail_page {
	
	WebDriver driver;
	
	@FindBy(css = "span.bgnone")
	WebElement productName;
	
	@FindBy(css = "div.productfilneprice")
	WebElement productPrice;
	
	@FindBy(id = "option317")
	WebElement size;
	
	@FindBy(id = "product_quantity")
	WebElement quantity;
	
	@FindBy(css = "a.cart")
	WebElement addToCart;
	
	@FindBy(css = "span.total-price")
	WebElement totalPrice;
	
	public Products_detail_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public boolean verifyProductName()
	{
	    return productName.isDisplayed();
	}
	
	public boolean verifyProductPrice()
	{
	    return productPrice.isDisplayed();
	}
	
	public void selectSize(String value)
	{
	    Select dropdown = new Select(size);
	    dropdown.selectByVisibleText(value);
	}
	
	public void enterQuantity(String qty)
	{
	    quantity.clear();
	    quantity.sendKeys(qty);
	}
	
	public boolean verifyAddToCart()
	{
	    return addToCart.isDisplayed();
	}
	
	public void clickAddToCart()
	{
	    addToCart.click();
	}
	
	public String getTotalPrice()
	{
	    return totalPrice.getText();
	}

}
