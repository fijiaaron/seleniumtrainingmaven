package seleniumtrainingmaven;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/** This needs run through TestNG.xml to get parameters **/

public class ParameterizedLoginTest extends BaseTest
{
	@Test
	@Parameters({"username", "password", "loginSucceeds", "browser"})
	public void loginTest(String username, String password, Boolean loginSucceeds, String browser) 
	{	
		this.browser = browser;
		loginPage.login(username, password);
		
		if (loginSucceeds)
		{
			String heading = securePage.getHeading();
			String flashMessage = securePage.getFlashMessage();
			
			assertThat(heading).isEqualTo("Secure Area");
			assertThat(flashMessage).contains("You logged into a secure area");
		}
		else
		{
			String heading = loginPage.getHeading();
			String flashMessage = loginPage.getFlashMessage();
			
			assertThat(heading).isEqualTo("Login Page");
			assertThat(flashMessage).contains("invalid");
		}
	}
	
}
