package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformanceTesting {

	public static void open_browser(WebDriver driver) {
		driver.get("https://pagespeed.web.dev/");
	}

	public static void enterurl(WebDriver driver, String url) throws Exception {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"i2\"]"));
		element.click();
		element.sendKeys(url);
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/c-wiz/div[2]/div/div[2]/form/div[2]/button/span")).click();
		ReusableFunctions.scroll(0, 300, driver);
		Thread.sleep(1000);
	}

	/*
	 * public void waitforelement() { WebDriverWait wait = new WebDriverWait(driver,
	 * 40);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.id("urelementid"))); }
	 */

	public static void scroll(WebDriver driver) throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"performance\"]/div[1]/div[1]/div[1]/a/div[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		System.out.println(element.getText());
	}

	public static void exit(WebDriver driver) {
		driver.close();
	}

	public static void performance(WebDriver driver, String url) throws Exception {
		open_browser(driver);
		enterurl(driver, url);
		scroll(driver);
		exit(driver);

	}
}
