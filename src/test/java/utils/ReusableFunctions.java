package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.HashMap;

public class ReusableFunctions {

	public static void scroll(int x, int y, WebDriver driver) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
		Thread.sleep(1000);
	}

	public static void exit(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("localStorage.setItem('exitIntentEnabled', '1');");
	}

	public static void country(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("localStorage.setItem('travelCountry', '0');");
	}

//	public static void waitForPageToLoad(WebDriver driver, String xpath) {
//		// WebDriverWait wait = new WebDriverWait(driver,10);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//		System.out.println(element);
////		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(13)); 
////		 wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
//
//	}

	public static void skipmobile(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("sessionStorage.setItem('skipMobile', '0');");
	}


	public static void removefilter(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("sessionStorage.removeItem('isNewFilter');");
	}

	public Properties readPropertiesFile(String fileName) throws Exception {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

	public static long enterMobileNumber() throws Exception {
		long min = 6000000000l;
		long max = 9999999999l;
		long a = (long) (Math.random() * (max - min + 1) + min);
		Thread.sleep(1000);
		return a;
	}

	public static String passport() throws Exception {
		int min = 00000001;
		int max = 99999999;
		int a1 = (int) (Math.random() * (max - min + 1) + min);
		Random r = new Random();
		char c = (char) (r.nextInt(26) + 'A');
		String a = c + String.valueOf(a1);
		return a;
	}

	public void selectelement(WebDriver driver, String ID) throws Exception {
		WebElement element = driver.findElement(By.id(ID));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
				element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
		Long viewportHeight = (Long) js.executeScript("return window.innerHeight;");
		Long elementHeight = (Long) js.executeScript("return arguments[0].offsetHeight;", element);
		Long newPosition = scrollPosition - (viewportHeight / 2) + (elementHeight / 2);
		js.executeScript("window.scrollTo(0, " + newPosition + ");");
		element.click();
	}

	public void selectelementxpath(WebDriver driver, String xpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
				element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
		Long viewportHeight = (Long) js.executeScript("return window.innerHeight;");
		Long elementHeight = (Long) js.executeScript("return arguments[0].offsetHeight;", element);
		Long newPosition = scrollPosition - (viewportHeight / 2) + (elementHeight / 2);
		js.executeScript("window.scrollTo(0, " + newPosition + ");");
		element.click();

	}

	public void enterelementxpath(WebDriver driver, String xpath, String name) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
				element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
		Long viewportHeight = (Long) js.executeScript("return window.innerHeight;");
		Long elementHeight = (Long) js.executeScript("return arguments[0].offsetHeight;", element);
		Long newPosition = scrollPosition - (viewportHeight / 2) + (elementHeight / 2);
		js.executeScript("window.scrollTo(0, " + newPosition + ");");
		element.sendKeys(name);

	}

	public Map.Entry<XSSFSheet, Integer> getProposalRow(String planname) throws IOException {
		Map<XSSFSheet, Integer> proposaldata = new HashMap<>();
		final XSSFSheet sheet = ExcelReader.readExcelFile("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("y")
					&& sheet.getRow(i).getCell(36).getStringCellValue().equalsIgnoreCase("proposal")) {
				String cell = sheet.getRow(i).getCell(1).getStringCellValue();
				if (cell.equalsIgnoreCase("Care") && planname.equalsIgnoreCase("Care")) {
					proposaldata.put(sheet, i);

				}
			} else {
				proposaldata.put(sheet, i);
			}

		}
		Map.Entry<XSSFSheet, Integer> entry = proposaldata.entrySet().iterator().next();
		return entry;
	}

}
