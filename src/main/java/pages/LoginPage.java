package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class LoginPage {

	private WebDriver driver;
	
	private By usernameInput = By.cssSelector("input[formcontrolname='username']");
	private By passwordInput = By.cssSelector("input[formcontrolname='password']");
	private By submitButton = By.id("kt_login_signin_submit");
	
	private By alertMessage = By.cssSelector(".toast-message");
	
	private By requiredMessage = By.xpath("//strong[text() = 'Required field']");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
		//check for url change
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
		}catch(TimeoutException e) {
			return false;
		}
	}
	
}
