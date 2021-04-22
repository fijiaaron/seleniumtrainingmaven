package seleniumtrainingmaven;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class RefactoredLoginTest extends BaseTest
{
	@Test
	public void successfulLogin() 
	{
		loginPage.login(validUsername, validPassword);
		
		String heading = securePage.getHeading();
		String flashMessage = securePage.getFlashMessage();
		
		assertThat(heading).isEqualTo("Secure Area");
		assertThat(flashMessage).contains("You logged into a secure area");
	}

	@Test
	public void failedLogin() 
	{
		loginPage.login(validUsername, "invalidpassword");
	
		String heading = loginPage.getHeading();
		String flashMessage = loginPage.getFlashMessage();
		
		assertThat(heading).isEqualTo("Login Page");
		assertThat(flashMessage).contains("Your password is invalid");
	}
	
	@Test
	public void failedLoginWithInvalidUsername() 
	{
		loginPage.login("invalidusername", validPassword);
	
		String heading = loginPage.getHeading();
		String flashMessage = loginPage.getFlashMessage();
		
		assertThat(heading).isEqualTo("Login Page");
		assertThat(flashMessage).contains("Your username is invalid");
	}
}