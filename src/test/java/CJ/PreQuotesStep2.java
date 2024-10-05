package CJ;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import utils.ReportGenerator;
//import utils.ReusableFunctions;
//import utils.ReusableFunctions;

public class PreQuotesStep2 {
	ReportGenerator report = new ReportGenerator();

	public void setPreQuotesStep2(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(3000);
		System.out.println(planname + " On PreQuotes Step2");
		report.allurereports(driver, planname + " On PreQuotes Step2");
		Thread.sleep(10000);
	//	String XpathPQ2Wait = prop.getProperty("XpathPQ2Wait");
	//	ReusableFunctions.waitForPageToLoad(driver,XpathPQ2Wait);
		selectstartdate(driver,planname);
		Thread.sleep(2500);
		selectenddate(prop, driver);
		Thread.sleep(2500);
		System.out.println(planname + " End Date Selected");
		report.allurereports(driver, planname + " End Date Selected");
		clickNextPQ2(prop, driver);
		System.out.println(planname + " PQ2 Next Clicked");
		report.allurereports(driver, planname + " Next Clicked on PreQuotes Step2");
	}

	public void startdateclick(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("XpathStartDateClick"))).click();
		Thread.sleep(2500);
		report.allurereports(driver,  " Selected");
	}

	public void selectstartdate(WebDriver driver,String planname) throws Exception {
		 WebElement inputField = driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input"));
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	     jsExecutor.executeScript("arguments[0].removeAttribute('readonly');", inputField);
		 inputField.clear();
		 inputField.sendKeys(todaysdate());
		 System.out.println("Start date entered");
		//String xpath = "/html/body/div[3]/div[2]/div/div/div[1]/div[3]/div/div[" + weeknum() + "]/div[" + daynum()+ "]";
//		driver.findElement(By.xpath(xpath)).click();
//		Thread.sleep(2000);
		Thread.sleep(2000);

	}

	public void selectenddate(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		WebElement inputField = driver.findElement(By.xpath("//*[@id='prequote-wrapper']/div[2]/div/div[1]/div/div[2]/div/div/input")); JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	     jsExecutor.executeScript("arguments[0].removeAttribute('readonly');", inputField);
		 inputField.clear();
		 inputField.sendKeys(laterdate());
		 System.out.println("End date entered");
		 driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[4]/div/div/div[4]/div[2]")).click();
	//	driver.findElement(By.xpath(prop.getProperty("XpathEndDate"))).click();
	}

	public void clickNextPQ2(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
	//	ReusableFunctions.waitandclick(driver, prop.getProperty("XpathPQ2Next"));
	driver.findElement(By.xpath(prop.getProperty("XpathPQ2Next"))).click();
	}

	public static int weeknum() {
		LocalDate date = LocalDate.now();
		TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfMonth();
		int weekNumber = date.get(woy);
		return weekNumber;
	}

	public static int daynum() {
		LocalDate date = LocalDate.now();
		DayOfWeek day = date.getDayOfWeek();
		int daynum = day.getValue() + 1;
		return daynum;
	}
	
	public static String todaysdate() {
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
        String formattedDate = today.format(formatter);
		return formattedDate;
	}
	
	public static String twoslaterdate() {
		LocalDate today = LocalDate.now();
		LocalDate twodaylater= today.plusDays(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
        String formattedDate = twodaylater.format(formatter);
		return formattedDate;
	}
	public static String laterdate() {
		LocalDate today = LocalDate.now();
        LocalDate oneMonthLater = today.plusMonths(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
        String formattedDate = oneMonthLater.format(formatter);
		return formattedDate;
	}
	public void selectstartdatepayfirst(WebDriver driver,String planname) throws Exception {
		 WebElement inputField = driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input"));
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	     jsExecutor.executeScript("arguments[0].removeAttribute('readonly');", inputField);
		 inputField.clear();
		 inputField.sendKeys(twoslaterdate());
		 System.out.println("Start date entered");
		Thread.sleep(2000);

	}
	
	public void setPreQuotesStep2Payfirst(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(2000);
		System.out.println(planname + " On PreQuotes Step2");
		report.allurereports(driver, planname + " On PreQuotes Step2");
//		String XpathPQ2Wait = prop.getProperty("XpathPQ2Wait");
//		ReusableFunctions.waitForPageToLoad(driver,XpathPQ2Wait);
		selectstartdatepayfirst(driver,planname);
		Thread.sleep(2500);
		selectenddate(prop, driver);
		Thread.sleep(2500);
		System.out.println(planname + " End Date Selected");
		report.allurereports(driver, planname + " End Date Selected");
		clickNextPQ2(prop, driver);
		System.out.println(planname + " PQ2 Next Clicked");
		report.allurereports(driver, planname + " Next Clicked on PreQuotes Step2");
	}
}
