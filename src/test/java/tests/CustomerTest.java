package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.DataProviders;
import utils.WaitUtils;

public class CustomerTest extends BaseTest {

	@BeforeMethod
	public void setUpPages() {
		loginPage.login("9519519519", "12345678");
		WaitUtils.waitForUrlContains(driver, "dashboard", 5);
		dashPage.openCustomerPage();
		WaitUtils.waitForUrlContains(driver, "customers", 5);
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
