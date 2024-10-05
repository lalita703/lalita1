package CJ;

import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReportGenerator;
import utils.ReusableFunctions;

public class PreQuotesStep1 {
	ReportGenerator report = new ReportGenerator();

	// XSSFSheet sheet;
//	@Step("Step 1: Perform some action in PreQuotesStep1")
	public void setPreQuotesStep1(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On PreQuotes Step1");
//		ReusableFunctions.skipmobile(driver);
//		ReusableFunctions.removefilter(driver);
		Thread.sleep(5000);
		entercountry(prop, driver, i, sheet, planname);
		clickcountry(prop, driver);
		ReusableFunctions.scroll(0, 100, driver);
		ReusableFunctions.exit(driver);
		clickNextPQ1(prop, driver);
		System.out.println(planname + " PQ1 Next Clicked");
		report.allurereports(driver, planname + " Next clicked on PrequotesStep1");
		Thread.sleep(6000);

	}

	public void entercountry(Properties prop, WebDriver driver, int i, XSSFSheet sheet, String planname)
			throws Exception {
		Thread.sleep(1000);
//		WebElement country1 = driver.findElement(By.xpath(prop.getProperty("XpathCountry")));
//		country1.sendKeys(Sheet1.getRow(1).getCell(1).getStringCellValue());
		WebElement countrytext = driver.findElement(By.xpath(prop.getProperty("XpathCountry")));
		countrytext.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		System.out.println(planname + " Country Selected");
		countrytext.click();	
//		logStepWithScreenshot(driver," Next clicked on PrequotesStep1");
		report.allurereports(driver,
				planname + " Country Selected: " + sheet.getRow(i).getCell(2).getStringCellValue());
	}

	public void clickNextPQ1(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPQ1Next"))).click();

	}

	public void clickcountry(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathCountryClick"))).click();
	}
	
//	private void logStep(String stepDescription) {
//        AllureListener.logStep(stepDescription);
//    }

//    private void logStepWithScreenshot(WebDriver driver,String stepDescription) {
//        AllureListener.logStepWithScreenshot(driver,stepDescription);
//    }

}
