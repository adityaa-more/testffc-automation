package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utils.WaitUtils;


public class DashboardTest extends BaseTest {

	private DashboardPage dashPage  = new DashboardPage() ;
	@BeforeClass
	public void setUpPages(){
		new LoginPage().login(user, pass);
		WaitUtils.waitForUrlContains(driver, "dashboard", 10);
    }
	
	
	@AfterMethod
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	@Test
	public void testPunchInToastDisplayed() {
		dashPage.clickPunchinButton();
		Assert.assertTrue(dashPage.punchinToastDisplayed(), "Punch In popup/toast was NOT displayed after clicking button");
	}

	@Test
	public void testPunchInToastInteraction() {
		dashPage.clickPunchinButton();
		Assert.assertTrue(dashPage.punchinToastDisplayed(), "Punch In popup did NOT open!");
		dashPage.interactToast("report");
	}

}
