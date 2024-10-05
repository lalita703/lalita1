package CJ;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReportGenerator;
import utils.ReusableFunctions;

public class NewPreQuotes {
	ReportGenerator report = new ReportGenerator();

	public void selectCountry(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On select Country");
		Thread.sleep(3000);
		entercountry(prop, driver, i, sheet, planname);
		clickcountry(prop, driver);
		ReusableFunctions.exit(driver);
		System.out.println(planname + " Country Selected");
		report.allurereports(driver, planname + " Country selected ");
		Thread.sleep(4000);
	}

	public void entercountry(Properties prop, WebDriver driver, int i, XSSFSheet sheet, String planname)
			throws Exception {
		Thread.sleep(1000);
		WebElement countrytext = driver.findElement(By.xpath(prop.getProperty("XpathCountry")));
		countrytext.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
		countrytext.click();
		System.out.println(planname + " Country name enter");
//		logStepWithScreenshot(driver," Next clicked on PrequotesStep1");
		report.allurereports(driver,
				planname + " Country Name Enter: " + sheet.getRow(i).getCell(2).getStringCellValue());
	}

	public void clickcountry(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathofCountryClick"))).click();
	}

//	@Step("Select Trip Duration")
	public void selectTripDuration(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(2000);
		System.out.println(planname + " On Trip dutation ");
		report.allurereports(driver, planname + " On Trip duration");
		driver.findElement(By.xpath("//*[@id='newPq_mainWrapper']/section/section[2]/article[2]/div[1]")).click();
		System.out.println(planname + " Open calendar");
		Thread.sleep(6000);
		selectstartdate(driver, planname);
		Thread.sleep(3000);
		selectenddate(prop, driver);
		System.out.println(planname + " End Date Selected");
		report.allurereports(driver, planname + " End Date Selected");
		Thread.sleep(4000);
		clickOnDone(prop, driver);
		System.out.println(planname + " Duration selected");
		report.allurereports(driver, planname + " Duration selected ");
	}

	public void selectstartdate(WebDriver driver, String planname) throws Exception {
//		WebElement dateButton = driver.findElement(By.xpath("//*[@aria-label='".concat(todaysdate()).concat("']")));
//		dateButton.click();
		driver.findElement(By.xpath("(//*[text()='25'])[1]")).click();             
		System.out.println("Start date entered");
		Thread.sleep(1000);

	}

	public void selectenddate(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
//		WebElement dateButton = driver.findElement(By.xpath("//*[@aria-label='".concat(laterdate()).concat("']")));
//		dateButton.click();
		driver.findElement(By.xpath("(//*[text()='25'])[2]")).click();
		System.out.println("End date entered");
	}

	public static String todaysdate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String formattedDate = today.format(formatter);
		return formattedDate;
	}

	public static String twoslaterdate() {
		LocalDate today = LocalDate.now();
		LocalDate twodaylater = today.plusDays(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String formattedDate = twodaylater.format(formatter);
		return formattedDate;
	}

	public static String laterdate() {
		LocalDate today = LocalDate.now();
		LocalDate oneMonthLater = today.plusMonths(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		String formattedDate = oneMonthLater.format(formatter);
		return formattedDate;
	}

	public void selectstartdatepayfirst(WebDriver driver, String planname) throws Exception {
		WebElement dateButton = driver.findElement(By.xpath("//*[@aria-label='".concat(twoslaterdate()).concat("']")));
		dateButton.click();
		System.out.println("Start date entered");
		Thread.sleep(2000);
	}

	public void selectDurationPayfirst(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(2000);
		System.out.println(planname + " On Trip Duration payfirst ");
		report.allurereports(driver, planname + " On Trip Duration payfirst");
		driver.findElement(By.xpath("//*[@id='newPq_mainWrapper']/section/section[2]/article[2]/div[1]")).click();
		System.out.println(planname + " Open calendar");
		Thread.sleep(5000);
		selectstartdatepayfirst(driver, planname);
		Thread.sleep(2500);
		selectenddate(prop, driver);
		Thread.sleep(2500);
		System.out.println(planname + " End Date Selected");
		report.allurereports(driver, planname + " End Date Selected");
		clickOnDone(prop, driver);
		System.out.println(planname + " Trip duration selected");
		report.allurereports(driver, planname + " Trip duration selected ");
	}

//	@Step("Select Member and PED")
	public void selectMemberAndPED(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On Member selection");
		driver.findElement(By.xpath("//*[@id='newPq_mainWrapper']/section/section[2]/article[3]")).click();
		System.out.println(planname + " Open Member selection popup");
		Thread.sleep(3000);
		valueselection(prop, driver, i, sheet);
		System.out.println(planname + " Age Selected");
		report.allurereports(driver, planname + " Traveller selected of age: ");
		String pedvalue = sheet.getRow(i).getCell(4).getStringCellValue();
		if (pedvalue.equalsIgnoreCase("no")) {
			PEDSelectionNo(prop, driver, planname);
		} else if (pedvalue.equalsIgnoreCase("Yes")) {
			PEDSelectionYes(prop, driver, planname);
		}
		report.allurereports(driver, planname + " PED selected ");
		Thread.sleep(1000);
		clickOnDone(prop, driver);
		System.out.println(planname + " Member and PED selected");
		report.allurereports(driver, planname + " Member and PED selected ");
		Thread.sleep(3000);
		clickViewPlans(prop, driver);
		System.out.println(planname + " view plans clicked");
		report.allurereports(driver, planname + " view plans clicked ");
		Thread.sleep(8000);
	}

	public void valueselection(Properties prop, WebDriver driver, int i, XSSFSheet sheet) throws Exception {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='divarrow_undefined']")).click();
		Thread.sleep(1000);
		String Age = sheet.getRow(i).getCell(3).getStringCellValue();
		// driver.findElement(By.xpath("//*[@id=\"optionBox_0_wrapper\"]/div[28]/label")).click();
		driver.findElement(By.xpath("//label[contains(text(),'" + Age + "')]")).click();
	}

	public void PEDSelectionYes(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPEDYes"))).click();
		System.out.println(planname + " PED Selected");
		report.allurereports(driver, planname + " PED select as YES ");
	}

	public void PEDSelectionNo(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPEDNo"))).click();
		System.out.println(planname + " PED Selected");
		report.allurereports(driver, planname + " PED select as NO ");
		Thread.sleep(2000);
	}

	public void clickOnDone(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Done']")).click();
//		driver.findElement(By.xpath(prop.getProperty("XpathDone"))).click();
	}

	public void clickViewPlans(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='View plans ›']")).click();
		Thread.sleep(2000);
	}

	public boolean verifyViewPlanButtonDisplayed(WebDriver driver) {
		int a = driver.findElements(By.xpath("//*[text()='View plans ›']")).size();
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setMobilePopup(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		try {
			// Define the locator for the mobile popup
			By mobilePopupLocator = By.xpath(prop.getProperty("XpathMobilePopup"));

			// Check if the mobile popup element is present
			List<WebElement> mobilePopupElements = driver.findElements(mobilePopupLocator);

			if (!mobilePopupElements.isEmpty() && mobilePopupElements.get(0).isDisplayed()) {
				// WebElement XpathMobilePopup = mobilePopupElements.get(0);

				Thread.sleep(1000);
				report.allurereports(driver, planname + " Mobile Number Popup Shown");

				String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();

				enterMobileNumber(prop, driver, mobilenumber);
				System.out.println(planname + " Mobile Number Entered");
				report.allurereports(driver, planname + " Mobile Number Entered");

				clickSubmitPlans(prop, driver);
				System.out.println(planname + " View Plans Clicked");
				report.allurereports(driver, planname + " View Plans clicked ");
				Thread.sleep(1000);
			} else {
				System.out.println("Mobile number popup not displayed, moving forward.");
				Thread.sleep(5000);
			}
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException in NewPreQuotes: " + e.getMessage());
			e.printStackTrace();
			throw e; // Rethrow the exception to fail the test
		} catch (Exception e) {
			System.out.println("General exception in NewPreQuotes: " + e.getMessage());
			e.printStackTrace();
			throw e; // Rethrow the exception to fail the test
		}
	}

	public void enterMobileNumber(Properties prop, WebDriver driver, String mobilenumber) throws Exception {
		// long a = ReusableFunctions.enterMobileNumber();
		driver.findElement(By.xpath(prop.getProperty("XpathOfMobileNumber"))).sendKeys(mobilenumber);

	}

	public void clickSubmitPlans(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathSubmitMobilePopup"))).click();
		Thread.sleep(3000);
	}

}
