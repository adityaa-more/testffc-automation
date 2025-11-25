package pages;

import org.openqa.selenium.By;

import utils.WaitUtils;

public class DashboardPage extends BasePage{
	
	private By punchInButton = By.xpath("//span[text()='Punch In']/..");
	private By toastTitle = By.xpath("//h3[text()='Punch In Report']");
	private By toastTextarea = By.cssSelector("textarea[data-placeholder='Report']");
	private By toastDoneButton = By.xpath("//span[text()='Done']/..");
	
	private By customerPageLink = By.xpath("//a[@href='/customers']");


	public void clickPunchinButton() {
		WaitUtils.waitForNoOverlay(driver, 10);
		WaitUtils.waitForClickable(driver, punchInButton, 10);
		click(punchInButton);
	}
	
	public boolean punchinToastDisplayed() {
		return WaitUtils.waitForVisible(driver, toastTitle, 5).isDisplayed();
	}
	
	public void interactToast(String reportMessage) {
		clear(toastTextarea);
		sendKeys(toastTextarea, reportMessage);
		click(toastDoneButton);
	}
	
	public void openCustomerPage() {
		WaitUtils.waitForVisible(driver, customerPageLink, 5).click();
	}
	
}

