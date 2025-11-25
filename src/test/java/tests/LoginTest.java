package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DataProviders;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

	private LoginPage loginPage =  new LoginPage();
	
	@AfterMethod
	public void resetLoginState() {
		if (driver.manage().getCookieNamed("currentUser") != null) {
			driver.manage().deleteCookieNamed("currentUser");
		}
		driver.navigate().refresh();
		WaitUtils.waitForUrlContains(driver, baseUrl, 10);
	}
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void testLogin(String username, String password, String expectedResult) {

		loginPage.login(username, password);

		switch (expectedResult.toLowerCase()) {

		case "success":
			WaitUtils.waitForUrlContains(driver, "dashboard", 10);
			Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Valid login FAILED!");
			break;

		case "invalid":
			String alertMsg = loginPage.getAlertMessage();
			Assert.assertTrue(alertMsg.toLowerCase().contains("invalid"), "Invalid login alert not shown!");
			break;

		case "required":
			Assert.assertTrue(loginPage.checkRequiredMessage(), "Required field message NOT displayed!");
			break;

		default:
			Assert.fail("Invalid expectedResult in DataProvider: " + expectedResult);
		}
		
	}
}
