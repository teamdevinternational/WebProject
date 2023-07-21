package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']['Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@class='nav-link'][@href='/logout']")
	WebElement btnLogout; 
	
	
	
	
	
	public void enterEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
