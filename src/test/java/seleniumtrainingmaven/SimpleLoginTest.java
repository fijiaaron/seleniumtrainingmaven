package seleniumtrainingmaven;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SimpleLoginTest
{
	@Test
	public void successfulLogin() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
	
		try {
			driver.get("https://the-internet.herokuapp.com/login");
			
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
			driver.findElement(By.cssSelector("button.radius")).click();
			
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			driver.quit();
		}
	}
	
	@Test
	public void failedLogin() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
	
		try {
			driver.get("https://the-internet.herokuapp.com/login");
			
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("InvalidPassword!");
			driver.findElement(By.cssSelector("button.radius")).click();
			
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			driver.quit();
		}
	}
}
