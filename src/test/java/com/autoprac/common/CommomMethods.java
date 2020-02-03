package com.autoprac.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class CommomMethods extends Base{

	//Implicit Wait
	public static void waitTime() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	//Explicit Wait
	public static WebElement waitForElement(WebElement element) {
		WebDriverWait exwait = new WebDriverWait(driver,10);
		return exwait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	//Fluent Wait
	public WebElement presenceOfTheElement(final WebElement webElement) {
		FluentWait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class); 
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println(webElement);
				return driver.findElement((By) webElement);
			}
		});
	}


	//Scroll to Element
	public static void scrollTillElement(WebElement element) throws Exception{ 
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	//Scroll length
	public static void scrollLength(int x, int y) {
		JavascriptExecutor jsl = (JavascriptExecutor) driver;
		jsl.executeScript("window.scrollBy(x,y)");
	}


	//Mouse hover
	public static void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}


}
