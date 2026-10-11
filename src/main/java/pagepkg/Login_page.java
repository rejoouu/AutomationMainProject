package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	WebDriver driver;
	
	@FindBy(id = "loginFrm_loginname")
	WebElement loginName;
	
	@FindBy(id = "loginFrm_password")
	WebElement password;
	
	@FindBy(css = "button[title='Login']")
	WebElement loginButton;
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		// TODO Auto-generated constructor stub
	}

	public void logintests(String name, String pass) {

	    loginName.clear();
	    loginName.sendKeys(name);

	    password.clear();
	    password.sendKeys(pass);

	    System.out.println("Username entered: " + loginName.getAttribute("value"));
	    System.out.println("Password field populated: " +
	            !password.getAttribute("value").isEmpty());

	    loginButton.click();

	    System.out.println("URL after login: " + driver.getCurrentUrl());
	}
}
