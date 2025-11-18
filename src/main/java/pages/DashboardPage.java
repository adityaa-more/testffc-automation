package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class DashboardPage {
	
	private WebDriver driver;
	
	private By punchInButton = By.xpath("//span[text()='Punch In']/..");
	private By toastTitle = By.xpath("//h3[text()='Punch In Report']");
	private By toastTextarea = By.cssSelector("textarea[data-placeholder='Report']");
	private By toastDoneButton = By.xpath("//span[text()='Done']/..");
	
	private By customerPageLink = By.xpath("//a[@href='/customers']");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickPunchinButton() {
		WaitUtils.waitForNoOverlay(driver, 5);
		WaitUtils.waitForClickable(driver, punchInButton, 5);
		driver.findElement(punchInButton).click();
	}
	
	public boolean punchinToastDisplayed() {
		return WaitUtils.waitForVisible(driver, toastTitle, 5).isDisplayed();
	}
	
	public void interactToast(String report) {
		driver.findElement(toastTextarea).clear();
		driver.findElement(toastTextarea).sendKeys(report);
		driver.findElement(toastDoneButton).click();
	}
	
	public void openCustomerPage() {
		WaitUtils.waitForVisible(driver, customerPageLink, 5).click();
	}
	
}

