package CJ;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ReportGenerator;
//import utils.ReusableFunctions;

public class PreQuotesStep3 {
	ReportGenerator report = new ReportGenerator();

	public void setPreQuotesStep3(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On PreQuotes Step3");
//		String XpathPQ3Wait = prop.getProperty("XpathPQ3Wait");
//		ReusableFunctions.waitForPageToLoad(driver,XpathPQ3Wait);
		valueselection(prop, driver, i, sheet);
		System.out.println(planname + " Age Selected");
		report.allurereports(driver, planname + " Traveller selected of age: ");
		clickNextPQ3(prop, driver);
		System.out.println(planname + " PQ3 Next Clicked");
		report.allurereports(driver, planname + " Next Clicked On PreQuotes Step3");

	}

	public void valueselection(Properties prop, WebDriver driver, int i, XSSFSheet sheet) throws Exception {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div[2]/div/div")).click();
		Thread.sleep(1000);
		String Age = sheet.getRow(i).getCell(3).getStringCellValue();
		// driver.findElement(By.xpath("//*[@id=\"optionBox_0_wrapper\"]/div[28]/label")).click();
		driver.findElement(By.xpath("//label[contains(text(),'" + Age + "')]")).click();

	}

	public void clickNextPQ3(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPQ3Next"))).click();
		Thread.sleep(1000);

	}
}
