package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.WaitUtils;

public class DashboardTest extends BaseTest {

	@BeforeMethod
	public void setUpPages() {

		loginPage.login("9519519519", "12345678");

		WaitUtils.waitForUrlContains(driver, "dashboard", 10);
	}

	@Test
	public void testPunchInToastDisplayed() {

		dashPage.clickPunchinButton();
		boolean toastVisible = dashPage.punchinToastDisplayed();
		Assert.assertTrue(toastVisible, "Punch In popup/toast was NOT displayed after clicking button");
	}

	@Test
	public void testPunchInToastInteraction() {

		dashPage.clickPunchinButton();

		Assert.assertTrue(dashPage.punchinToastDisplayed(), "Punch In popup did NOT open!");

		dashPage.interactToast("report");
	}

}
