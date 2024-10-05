package CJ;

import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ReportGenerator;
//import utils.ReusableFunctions;

public class PreQuotesStep5 {
	ReportGenerator report = new ReportGenerator();

	public void setPrequotesStep5proposal(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		Thread.sleep(1000);
		report.allurereports(driver, planname + " Mobile Number Popup Shown");
//		String XpathPQ5Wait = prop.getProperty("XpathPQ5Wait");
//		ReusableFunctions.waitForPageToLoad(driver,XpathPQ5Wait);
		Thread.sleep(2000);
		String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();
		try {
			enterMobileNumber(prop, driver, mobilenumber);
			System.out.println(planname + " Mobile Number Entered");
			report.allurereports(driver, planname + " Mobile Number Entered");
			clickSubmitPlans(prop, driver);
			System.out.println(planname + " View Plans Clicked");
			report.allurereports(driver, planname + " View Plans clicked On PreQuotes Step5");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Retry");
		}
		Thread.sleep(1000);
	}
//
//	public void setPrequotesStep5(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
//			throws Exception {
//		WebElement XpathMobilePopup = driver.findElement(By.xpath(prop.getProperty("XpathMobilePopup")));
//		if ( XpathMobilePopup.isDisplayed()) {
//			Thread.sleep(1000);
//			report.allurereports(driver, planname + " Mobile Number Popup Shown");
////		String XpathPQ5Wait = prop.getProperty("XpathPQ5Wait");
////		ReusableFunctions.waitForPageToLoad(driver,XpathPQ5Wait);
//			Thread.sleep(2000);
//			String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();
//			try {
//				enterMobileNumber(prop, driver, mobilenumber);
//				System.out.println(planname + " Mobile Number Entered");
//				report.allurereports(driver, planname + " Mobile Number Entered");
//				clickSubmitPlans(prop, driver);
//				System.out.println(planname + " View Plans Clicked");
//				report.allurereports(driver, planname + " View Plans clicked On PreQuotes Step5");
//				Thread.sleep(2000);
//			} catch (Exception e) {
//				System.out.println("Retry");
//			}
//		} else {
//			System.out.println("skip mobile");
//		}
//	}
	public void setPrequotesStep5(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
	        throws Exception {
	    try {
	        // Define the locator for the mobile popup
	        By mobilePopupLocator = By.xpath(prop.getProperty("XpathMobilePopup"));

	        // Check if the mobile popup element is present
	        List<WebElement> mobilePopupElements = driver.findElements(mobilePopupLocator);

	        if (!mobilePopupElements.isEmpty() && mobilePopupElements.get(0).isDisplayed()) {
	    //        WebElement XpathMobilePopup = mobilePopupElements.get(0);

	            Thread.sleep(1000);
	            report.allurereports(driver, planname + " Mobile Number Popup Shown");

	            String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();

	            enterMobileNumber(prop, driver, mobilenumber);
	            System.out.println(planname + " Mobile Number Entered");
	            report.allurereports(driver, planname + " Mobile Number Entered");

	            clickSubmitPlans(prop, driver);
	            System.out.println(planname + " View Plans Clicked");
	            report.allurereports(driver, planname + " View Plans clicked On PreQuotes Step5");

	            Thread.sleep(1000);
	        } else {
	            System.out.println("Mobile number popup not displayed, moving forward.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("NoSuchElementException in setPrequotesStep5: " + e.getMessage());
	        e.printStackTrace();
	        throw e; // Rethrow the exception to fail the test
	    } catch (Exception e) {
	        System.out.println("General exception in setPrequotesStep5: " + e.getMessage());
	        e.printStackTrace();
	        throw e; // Rethrow the exception to fail the test
	    }
	}

	public void setPrequotesStep5onpq(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On PreQuotes Step5");
		Thread.sleep(1000);
		String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();
		try {
			enterMobileNumber(prop, driver, mobilenumber);
			System.out.println(planname + " Mobile Number Entered");
			report.allurereports(driver, planname + " Mobile Number Entered");
			clickViewPlans(prop, driver);
			System.out.println(planname + " View Plans Clicked");
			report.allurereports(driver, planname + " View Plans clicked On PreQuotes Step5");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Retry");
		}

	}

	public void enterMobileNumber(Properties prop, WebDriver driver, String mobilenumber) throws Exception {
		// long a = ReusableFunctions.enterMobileNumber();
		driver.findElement(By.xpath(prop.getProperty("XpathMobileNumber"))).sendKeys(mobilenumber);

	}

	public void clickViewPlans(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathViewPlans"))).click();
		Thread.sleep(3000);
	}

	public void clickSubmitPlans(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathSubmitMobilePopup"))).click();
		Thread.sleep(3000);
	}

	public void checkMobileNumber(Properties prop, WebDriver driver, String mobile) throws Exception {
		// long a = ReusableFunctions.enterMobileNumber();
		driver.findElement(By.xpath(prop.getProperty("XpathMobileNumber"))).sendKeys(mobile);

	}

	public void checkPrequotesStep5(Properties prop, WebDriver driver, String mobile) throws Exception {

		try {
			checkMobileNumber(prop, driver, mobile);
			System.out.println(" Mobile Number Entered");
			clickViewPlans(prop, driver);
		} catch (Exception e) {
			System.out.println("Skip Mobile scenario");
		}

	}

}
