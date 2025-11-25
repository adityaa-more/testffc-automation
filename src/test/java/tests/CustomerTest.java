package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DataProviders;
import utils.WaitUtils;

public class CustomerTest extends BaseTest {

	private CustomerPage custPage = new CustomerPage();

	@BeforeClass
	public void setUpPages() {
		new LoginPage().login(user, pass);
		WaitUtils.waitForUrlContains(driver, "dashboard", 10);
		new DashboardPage().openCustomerPage();
		WaitUtils.waitForUrlContains(driver, "customers", 10);
	}

	@Test
	public void testNewCustomerToastDisplayed() {
		custPage.clickNewCustButton();
		Assert.assertTrue(custPage.checkFormVisible(), "New Customer Form Popup Not displayed");
	}

	@Test(dataProvider = "newCustomerData", dataProviderClass = DataProviders.class)
	public void testNewCustomer(String name, String email, String country, String filepath) {
		custPage.clickNewCustButton();
		custPage.fillForm(name, email, country, filepath);
		custPage.saveForm();
		boolean isCreated = custPage.validateUserCreated(name);
		Assert.assertTrue(isCreated, "User not created");
	}

}
