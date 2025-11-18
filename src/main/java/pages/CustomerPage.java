package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.JavaScriptUtils;
import utils.WaitUtils;

public class CustomerPage {
	private WebDriver driver;

	private By newCustButton = By.xpath("//span[normalize-space()='New Customer']/..");
	private By toastTitle = By.xpath("//h3[normalize-space()='New customer']");

	private By nameField = By.cssSelector("input[formcontrolname='LeadName']");
	private By emailField = By.cssSelector("input[formcontrolname='Email']");

	private By selectCountry = By.xpath(
			"//mat-select[@formcontrolname='CountryId' and @placeholder='Country']//div[contains(@class,'mat-select-trigger')]");

	private By visibleToAllCheckbox = By
			.cssSelector("mat-checkbox[formcontrolname='IsVisibleToAll'] .mat-checkbox-inner-container");
	private By attachVisitingCard = By.cssSelector("input[placeholder='Attach Front Visiting Card']");

	private By saveButton = By.xpath("//button[normalize-space(@mattooltip)='Save changes']");

	private By customerNameInList = By.xpath("(//mat-cell[contains(@class,'mat-column-LeadName')])[1]");

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickNewCustButton() {
		WaitUtils.waitForClickable(driver, newCustButton, 5).click();
	}

	public boolean checkFormVisible() {
		return WaitUtils.waitForVisible(driver, toastTitle, 5).isDisplayed();
	}

	public void fillForm(String name, String email, String country, String filepath) {
		WaitUtils.waitForVisible(driver, nameField, 10).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);

		WebElement select = driver.findElement(selectCountry);
		JavaScriptUtils.scrollToElement(driver, select);
		JavaScriptUtils.clickElement(driver, select);

		String optionXpath = "//span[normalize-space(text())='" + country + "']/..";
		By optionLocator = By.xpath(optionXpath);
		WebElement option = WaitUtils.waitForClickable(driver, optionLocator, 10);
		JavaScriptUtils.scrollToElement(driver, option);
		option.click();

		WebElement checkbox = WaitUtils.waitForPresence(driver, visibleToAllCheckbox, 5);
		JavaScriptUtils.scrollToElement(driver, checkbox);
		if (!checkbox.getAttribute("class").contains("mat-checkbox-checked")) {
			JavaScriptUtils.clickElement(driver, checkbox);
		}

		WebElement attachCard = WaitUtils.waitForVisible(driver, attachVisitingCard, 5);
		JavaScriptUtils.scrollToElement(driver, attachCard);
		attachCard.sendKeys(filepath);
	}

	public void saveForm() {
		driver.findElement(saveButton).click();
	}

	public boolean validateUserCreated(String name) {
		driver.navigate().refresh();
		String data = WaitUtils.waitForVisible(driver, customerNameInList, 15).getText().trim();
		if (data.equalsIgnoreCase(name)) {
			return true;
		} else {
			return false;
		}
	}
}