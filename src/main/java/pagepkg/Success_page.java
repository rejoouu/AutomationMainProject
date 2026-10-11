package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Success_page {
	
	WebDriver driver;

    @FindBy(css = "span.maintext")
    WebElement successHeading;
    
    @FindBy(xpath = "//p[contains(text(),'Your order #')]")
    WebElement orderMessage;
    
    @FindBy(linkText = "invoice page")
    WebElement invoiceLink;
    
    @FindBy(linkText = "store owner")
    WebElement storeOwnerLink;
    
    @FindBy(xpath = "//a[contains(normalize-space(.),'Continue')]")
    WebElement continueButton;
    
    public Success_page(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	public boolean verifySuccessHeading() {
        return successHeading.isDisplayed();
    }
    
    public boolean verifyOrderMessage() {
        return orderMessage.isDisplayed();
    }
    
    public boolean verifyOrderNumber() {
        return orderMessage.getText().matches(
                "Your order #\\d+ has been created!");
    }

    public boolean verifyInvoiceLink() {
        return invoiceLink.isDisplayed()
                && invoiceLink.isEnabled();
    }

    public boolean verifyStoreOwnerLink() {
        return storeOwnerLink.isDisplayed()
                && storeOwnerLink.isEnabled();
    }

    public boolean verifyContinueButton() {
        return continueButton.isDisplayed()
                && continueButton.isEnabled();
    }

    public void clickInvoiceLink() {
        invoiceLink.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

}
