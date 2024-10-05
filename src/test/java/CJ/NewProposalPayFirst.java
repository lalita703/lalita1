package CJ;

import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import utils.ReportGenerator;
import utils.ReusableFunctions;

public class NewProposalPayFirst {
	ReportGenerator report = new ReportGenerator();
	ReusableFunctions reusableFunctions = new ReusableFunctions();
	CheckOut co = new CheckOut();

	public void ProposalStep(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		if (driver.getCurrentUrl().contains("proposalPrePayment")) {
			report.allurereports(driver, planname + " On Proposal-Step 1");
			System.out.println(planname + " On Proposal-Step 1");
			Thread.sleep(5000);
			NPStep1(prop, driver, planname, i, sheet);
			report.allurereports(driver, planname + " On Proposal-Step 2");
			System.out.println(planname + " On Proposal-Step 2");
			NPStep2(prop, driver, planname, i, sheet);
			co.NewProposalaccept(prop, driver, planname);
		} else if (driver.getCurrentUrl().contains("expressPrePayment")) {
			report.allurereports(driver, planname + " On Express Proposal-Step 1");
			System.out.println(planname + " On Express Proposal-Step 1");
			Thread.sleep(5000);
			NPStep1Express(prop, driver, planname, i, sheet);
			co.NewExpressProposalaccept(prop, driver, planname);
		} else {
			System.out.println(planname + " not on Payment First");
			report.allurereports(driver, planname + " not on Payment First");
			report.allurereports(driver, planname + "Test skipped as it's not on Payment First");
			throw new SkipException("Test skipped as it's not on Payment First");
		}
	}

	public void ProposalStepMulti(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On Proposal-Step 1");
		System.out.println(planname + " On Proposal-Step 1");
		NPStep1(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 2");
		System.out.println(planname + " On Proposal-Step 2");
		NPStep2(prop, driver, planname, i, sheet);
		co.NewProposalacceptmulti(prop, driver, planname);
	}

	public void NPStep1(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		String name = sheet.getRow(i).getCell(6).getStringCellValue();
		String gender = sheet.getRow(i).getCell(7).getStringCellValue();
		String dob = sheet.getRow(i).getCell(8).getStringCellValue();
		String email = sheet.getRow(i).getCell(17).getStringCellValue();
		enterName(prop, driver, name);
		report.allurereports(driver, planname + " Name entered");
		System.out.println(planname + " Name entered");
		selectGender(prop, driver, gender, planname);
		report.allurereports(driver, planname + " Gender Selected");
		System.out.println(planname + " Gender Selected");
		enterDOB(prop, driver, dob);
		report.allurereports(driver, planname + " DOB Entered");
		System.out.println(planname + " DOB Entered");
		enterEmail(prop, driver, email);
		report.allurereports(driver, planname + " Email entered");
		System.out.println(planname + " Email entered");
		enterMobile(prop, driver, email, sheet, i);
		report.allurereports(driver, planname + " Mobile entered");
		System.out.println(planname + " Mobile entered");
		clickcontinue(prop, driver);

	}

	public void NPStep1Express(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		String name = sheet.getRow(i).getCell(6).getStringCellValue();
		String dob = sheet.getRow(i).getCell(8).getStringCellValue();
		String email = sheet.getRow(i).getCell(17).getStringCellValue();
		enterName(prop, driver, name);
		report.allurereports(driver, planname + " Name entered");
		System.out.println(planname + " Name entered");
		enterDOB(prop, driver, dob);
		report.allurereports(driver, planname + " DOB Entered");
		System.out.println(planname + " DOB Entered");
		enterEmail(prop, driver, email);
		report.allurereports(driver, planname + " Email entered");
		System.out.println(planname + " Email entered");
		enterMobile(prop, driver, email, sheet, i);
		report.allurereports(driver, planname + " Mobile entered");
		System.out.println(planname + " Mobile entered");
		Thread.sleep(4000);
		if (planname.equalsIgnoreCase("Care") || planname.equalsIgnoreCase("StudentCare")
				|| planname.equalsIgnoreCase("MultiCare") || planname.equalsIgnoreCase("Chola")) {
			ExpressCareQ1(prop, driver);
		}
		ExpressDeclaration(prop, driver);
		clickcontinue(prop, driver);

	}

	public void NPStep2(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		if (planname.equalsIgnoreCase("Care") || planname.equalsIgnoreCase("StudentCare")
				|| planname.equalsIgnoreCase("MultiCare") || planname.equalsIgnoreCase("Chola")) {
			careQ1(prop, driver);
			ReusableFunctions.scroll(0, 400, driver);
			careQ2(prop, driver);
			clickPayFirstContinue(prop, driver);
		} else {
			clickPayFirstContinue(prop, driver);
		}
	}

	public void enterName(Properties prop, WebDriver driver, String name) throws Exception {
		Thread.sleep(2000);
		String XpathName = prop.getProperty("XpathNPName");
		reusableFunctions.enterelementxpath(driver, XpathName, name);

	}

	public void selectGender(Properties prop, WebDriver driver, String InsurerGender, String planname)
			throws Exception {
		Thread.sleep(1000);
		if (planname.equalsIgnoreCase("TataAig") || planname.equalsIgnoreCase("MultiTata")) {
			if (InsurerGender.equalsIgnoreCase("Male")) {
				String XpathNPMale = prop.getProperty("XpathTataNPMale");
				reusableFunctions.selectelementxpath(driver, XpathNPMale);
			} else if (InsurerGender.equalsIgnoreCase("Female")) {
				String XpathNPFemale = prop.getProperty("XpathTataNPFemale");
				reusableFunctions.selectelementxpath(driver, XpathNPFemale);
			}
		} else {
			if (InsurerGender.equalsIgnoreCase("Male")) {
				String XpathNPMale = prop.getProperty("XpathNPMale");
				reusableFunctions.selectelementxpath(driver, XpathNPMale);
			} else if (InsurerGender.equalsIgnoreCase("Female")) {
				String XpathNPFemale = prop.getProperty("XpathNPFemale");
				reusableFunctions.selectelementxpath(driver, XpathNPFemale);
			}
		}
	}

	public void enterDOB(Properties prop, WebDriver driver, String dob) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPDOB"))).sendKeys(dob);
	}

	public void clickcontinue(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String XpathContinue = prop.getProperty("XpathNPContinue");
		reusableFunctions.selectelementxpath(driver, XpathContinue);
	}

	public void clickPayFirstContinue(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathDeclaration"))).click();
		Thread.sleep(1000);
		clickcontinue(prop, driver);

	}

	public void ExpressCareQ1(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String XpathNPExpressCareQ1 = prop.getProperty("XpathNPExpressCareQ1");
		reusableFunctions.selectelementxpath(driver, XpathNPExpressCareQ1);
		Thread.sleep(1000);
		String XpathNPExpressCareQ2 = prop.getProperty("XpathNPExpressCareQ2");
		reusableFunctions.selectelementxpath(driver, XpathNPExpressCareQ2);
	}

	public void ExpressDeclaration(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String XpathExpressDeclaration = prop.getProperty("XpathExpressDeclaration");
		reusableFunctions.selectelementxpath(driver, XpathExpressDeclaration);
		Thread.sleep(1000);

	}

	public void careQ1(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ1"))).click();
	}

	public void careQ2(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ2"))).click();

	}

	public void enterEmail(Properties prop, WebDriver driver, String email) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPEmail"))).sendKeys(email);
	}

	public void enterMobile(Properties prop, WebDriver driver, String email, XSSFSheet sheet, int i) throws Exception {
		WebElement mobile = driver.findElement(By.xpath(prop.getProperty("XpathMobile")));
		String text = mobile.getText();
		String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();
		Thread.sleep(1000);
		if (mobile.isDisplayed() && text.isEmpty()) {
			try {
				driver.findElement(By.xpath(prop.getProperty("XpathMobile"))).sendKeys(mobilenumber);
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("Retry");
			}
		}

	}
}
