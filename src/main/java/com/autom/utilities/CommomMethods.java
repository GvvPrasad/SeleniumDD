package com.autom.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;
import com.google.common.base.Function;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommomMethods extends Base{

	//Implicit Wait
	public static void waitTime() throws InterruptedException {
		Thread.sleep(5000);
	}

	//Explicit Wait
	public static WebElement waitForElement(WebElement element) {
		WebDriverWait exwait = new WebDriverWait(driver,10);
		return exwait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	//Fluent Wait
	public static void presenceOfTheElement(final WebElement webElement) {
		Wait <WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(Exception.class); 
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement((By) webElement);
			}
		});
	}

	//Element Screenshot
	public static void elementScreenshot(WebElement element) throws IOException {
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver, element); 
		ImageIO.write(screenshot.getImage(),"PNG",new File(ObjectRespo.screenShotName));
	}

	//Visible Page Screenshots
	public static void visiablePageScreenShot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,new File(ObjectRespo.screenShotName));
	}

	//Full Page ScreenShot
	public static void fullPageScreenshot() throws IOException {
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver); 
		ImageIO.write(screenshot.getImage(),"PNG",new File(ObjectRespo.screenShotName));
	}
}