package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected DashboardPage dashPage;
	protected CustomerPage custPage;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testffc.nimapinfotech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		loginPage = new LoginPage(driver);
		dashPage = new DashboardPage(driver);
		custPage = new CustomerPage(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
