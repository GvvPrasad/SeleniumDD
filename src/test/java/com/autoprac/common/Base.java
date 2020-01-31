package com.autoprac.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.autoprac.config.AppConfig;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {

	//Global Variables
	public static String browserName;
	public static String urlLink;
	protected static WebDriver driver;
	static String projectPath = System.getProperty("user.dir");
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 


	//Browser config
	public static void browserSetUp() {

		AppConfig.getProperties();

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
			driver = new InternetExplorerDriver();
		}

		driver.get(urlLink);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}


	//Screenshots
	public static void screenshot() throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,new File(projectPath+"//ScreenShots//"+timeStamp+".png"));
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
	
	
	//Vertical Scroll
	public static void verticalScrollElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void verticalScroll(int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(x,y)");
	}
	
	
	//Mousehover
	public static void mouseHover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
}

