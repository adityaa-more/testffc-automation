package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static WebElement waitForVisible(WebDriver driver, By locator, int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForPresence(WebDriver driver, By locator, int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebElement waitForClickable(WebDriver driver, By locator, int seconds) {
		return new WebDriverWait(driver, Duration.ofSeconds(seconds))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitForUrlContains(WebDriver driver, String text, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.urlContains(text));
	}

	public static void waitForNoOverlay(WebDriver driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.cssSelector(".cdk-overlay-container .cdk-overlay-backdrop")));
	}

}
