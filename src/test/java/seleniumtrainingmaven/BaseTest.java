package seleniumtrainingmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import theinternet.pages.LoginPage;
import theinternet.pages.SecurePage;

public class BaseTest
{
	WebDriver driver;
	LoginPage loginPage;
	SecurePage securePage;
	
	String validUsername = "tomsmith";
	String validPassword = "SuperSecretPassword!";
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		securePage = new SecurePage(driver);
		
		loginPage.open();
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
