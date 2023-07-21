package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.LoginPageBy;

public class TC001_LoginSteps extends BaseClass {

	@Before
	public void setup() throws IOException {

		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		// System.getProperty("user.dir") + "//Drivers/chromedriver.exe");

		String br = configProp.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} 
		else if (br.equals("mozilla")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("ffpath"));
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		} 
		else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", configProp.getProperty("edgepath"));
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		lp = new LoginPage(driver);

	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.enterEmail(email);
		lp.enterPassword(password);

	}

	@When("User clicks login")
	public void user_clicks_login() {
		lp.clickLogin();
	}

	@Then("Verify page title is {string}")
	public void verify_page_title_is(String title) {

		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
		lp.clickLogout();
	}

	@Then("Close Browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}

}
