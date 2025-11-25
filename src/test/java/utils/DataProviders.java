package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return new Object[][] { { "9519519519", "12345678", "success" }, { "wrong@test.com", "wrong123", "invalid" },
				{ "", "", "required" }, };
	}

	@DataProvider(name = "newCustomerData")
	public Object[][] getCustomerData() {
		return new Object[][] { { "John Doe", "john@example.com", "India", "C:/Hero.jpg" },
				{ "Maria Smith", "maria@mail.com", "Afghanistan", "C:/Hero.jpg" },
				{ "Ravi Sharma", "ravi@gmail.com", "Qatar", "C:/Hero.jpg" }, };
	}
}
