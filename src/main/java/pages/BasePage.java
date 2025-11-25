package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	protected static ChromeDriver driver;
	protected final String baseUrl = "https://testffc.nimapinfotech.com/";
	
	public void setDriver(ChromeDriver driver) {
		BasePage.driver = driver;
	}
	
	protected WebElement find (By locator) {
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
		find(locator).click();
	}
	
	protected void clear(By locator) {
		find(locator).clear();
	}
	
	protected void sendKeys(By locator, String text) {
		find(locator).sendKeys(text);
	}
	
	protected String getText(By locator) {
		String text = find(locator).getText();
		System.out.println(text);
		return text;
	}
	
	
}
