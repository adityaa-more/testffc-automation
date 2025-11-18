package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DataProviders;
import utils.WaitUtils;

public class LoginTest extends BaseTest {

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
