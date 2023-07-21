 package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageBy {

	WebDriver driver;
	
	public LoginPageBy (WebDriver driver){
		this.driver=driver;
	}
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By btnLogin = By.xpath("//button[@type='submit']['Log in']");
	By btnLogout = By.xpath("//a[@class='nav-link'][@href='/logout']");
	
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void enterEmail(String email) {
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public void clickLogout() {
		driver.findElement(btnLogout).click();
	}
	
	
	
}
