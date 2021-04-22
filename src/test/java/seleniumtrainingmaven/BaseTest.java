package seleniumtrainingmaven;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import theinternet.pages.LoginPage;
import theinternet.pages.SecurePage;

public abstract class BaseTest
{
	WebDriver driver;
	
	LoginPage loginPage;
	SecurePage securePage;
	
	String browser = "chrome";
	String validUsername = "tomsmith";
	String validPassword = "SuperSecretPassword!";
	
	@BeforeMethod
	public void setup()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		capabilities.setPlatform(Platform.MAC);
		
		driver = new RemoteWebDriver(capabilities);
		loginPage = new LoginPage(driver);
		securePage = new SecurePage(driver);
		
		loginPage.open();
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
