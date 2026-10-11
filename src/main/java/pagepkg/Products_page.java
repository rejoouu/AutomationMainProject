package pagepkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Products_page {
	WebDriver driver;

	@FindBy(css = "a[title='Seaweed Conditioner']")
	WebElement productName;
	 
    @FindBy(css = "div.oneprice")
    List<WebElement> productPrices;
    
    @FindBy(id = "sort")
    WebElement sort;
    

    public Products_page(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
    

	public boolean verifyProduct()
    {
        return productName.isDisplayed();
    }
    
    public void clickProduct()
    {
        productName.click();
    }
    
    public void printAllProductDetails()
    {
    	List<WebElement> products =
    	        driver.findElements(By.cssSelector("div.col-md-3.col-sm-6.col-xs-12"));

        System.out.println("Total Products: " + products.size());

        for (WebElement product : products)
        {
            System.out.println(product.getText());
            System.out.println("----------------------");
        }
    }
    
    public String getPageTitle()
    {
        return driver.getTitle();
    }
    
    public boolean verifySort()
    {
        return sort.isDisplayed();
    }
    
    public void sortByPriceLowToHigh()
    {
        Select select = new Select(sort);
        select.selectByVisibleText("Price Low > High");
    }

}
