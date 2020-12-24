package com.autom.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
import com.google.common.base.Function;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommomMethods extends Base{
	
	public static String projectPath = System.getProperty("user.dir");
	public static String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());

	//Implicit Wait
	public static void waitTime() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	//Explicit Wait
	public static WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
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
	public static String elementScreenshot(WebElement element, String nameofCurrMethod) throws IOException {
		File src = element.getScreenshotAs(OutputType.FILE);
		String dest = projectPath+"//ScreenShots//"+nameofCurrMethod+"_"+timeStamp+".png";
		File destination = new File(dest);
		FileUtils.copyFile(src,destination);
		return dest;
	}

	//Visible Page Screenshots
	public static String visiablePageScreenShot(String nameofCurrMethod) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = projectPath+"//ScreenShots//"+nameofCurrMethod+"_"+timeStamp+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source,destination);
		return dest;
	}

	//Full Page ScreenShot
	public static String fullPageScreenshot(String nameofCurrMethod) throws IOException {
		String dest = projectPath+"//ScreenShots//"+nameofCurrMethod+"_"+timeStamp+".png";
		File destination = new File(dest);
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver); 
		ImageIO.write(screenshot.getImage(),"PNG",destination);
		return dest;
	}
}