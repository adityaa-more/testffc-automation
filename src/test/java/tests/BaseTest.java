package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pages.BasePage;
import utils.TakeScreenshotUtils;

public class BaseTest {

    protected ChromeDriver driver;
	public static BasePage basePage;
	protected final String baseUrl = "https://testffc.nimapinfotech.com/";
	protected final String user = "8888052888";
	protected final String pass = "abc@12345";

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = new ChromeDriver();
		
		Map<String, Object> coordinates = new HashMap<>() 
		{{
			put("latitude", 25.197197);
			put("longitude", 55.27437639);
			put("accuracy", 20);
		}};

		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		basePage = new BasePage();
		basePage.setDriver(driver);
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) {
		if(ITestResult.FAILURE == testResult.getStatus()) {
			TakeScreenshotUtils.takeScreenshot(driver, testResult.getName());
		}
	}
}
