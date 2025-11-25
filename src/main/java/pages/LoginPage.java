package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import utils.WaitUtils;

public class LoginPage extends BasePage {

	private By usernameInput = By.cssSelector("input[formcontrolname='username']");
	private By passwordInput = By.cssSelector("input[formcontrolname='password']");
	private By submitButton = By.id("kt_login_signin_submit");

	private By alertMessage = By.cssSelector(".toast-message");

	private By requiredMessage = By.xpath("//strong[text() = 'Required field']");

	public void enterUsername(String username) {
		sendKeys(usernameInput, username);
	}

	public void enterPassword(String password) {
		sendKeys(passwordInput, password);
	}

	public void clickSubmitButton() {
		click(submitButton);
	}

	public void login(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickSubmitButton();
	}

	public String getAlertMessage() {
		return WaitUtils.waitForVisible(driver, alertMessage, 5).getText();
	}

	public boolean checkRequiredMessage() {
		try {
			WaitUtils.waitForVisible(driver, requiredMessage, 5);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

}
