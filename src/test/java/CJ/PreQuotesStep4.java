package CJ;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReportGenerator;
//import utils.ReusableFunctions;

public class PreQuotesStep4 {
	ReportGenerator report = new ReportGenerator();

	public void PEDSelectionYes(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(1000);
		System.out.println(planname + " PED Selected");
		report.allurereports(driver, planname + " PED Selected as YES on PreQuotes Step 4");
		driver.findElement(By.xpath(prop.getProperty("XpathYes"))).click();
	}

	public void PEDSelectionNo(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(1000);
		System.out.println(planname + " PED Selected");
		report.allurereports(driver, planname + " PED Selected as NO on PreQuotes Step 4");
		driver.findElement(By.xpath(prop.getProperty("XpathNo"))).click();
		Thread.sleep(2000);
	}

	public void clickNextPQ4(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPQ4Next"))).click();
	}

	public void setPED(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		report.allurereports(driver, planname + " On PreQuotes Step4");
//		String XpathPQ4Wait = prop.getProperty("XpathPQ4Wait");
//		ReusableFunctions.waitForPageToLoad(driver,XpathPQ4Wait);
		String pedvalue = sheet.getRow(i).getCell(4).getStringCellValue();
		if (pedvalue.equalsIgnoreCase("no")) {
			PEDSelectionNo(prop, driver, planname);
		} else if (pedvalue.equalsIgnoreCase("Yes")) {
			PEDSelectionYes(prop, driver, planname);
		}

	}

}
