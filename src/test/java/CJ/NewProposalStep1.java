package CJ;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ReportGenerator;
import utils.ReusableFunctions;

public class NewProposalStep1 {
	ReportGenerator report = new ReportGenerator();
	ReusableFunctions reusableFunctions = new ReusableFunctions();
	CheckOut co = new CheckOut();

	public void ProposalStep(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On Proposal-Step 1");
		System.out.println(planname + " On Proposal-Step 1");
		NPStep1(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 2");
		System.out.println(planname + " On Proposal-Step 2");
		NPStep2(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 3");
		System.out.println(planname + " On Proposal-Step 3");
		NPStep3(prop, driver, planname, i, sheet);
		co.NewProposalaccept(prop, driver, planname);
	}
	
	
	public void PartnerProposalStep(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On Proposal-Step 1");
		System.out.println(planname + " On Proposal-Step 1");
		PartnerNPStep1(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 2");
		System.out.println(planname + " On Proposal-Step 2");
		PartnerNPStep2(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 3");
		System.out.println(planname + " On Proposal-Step 3");
		PartnerNPStep3(prop, driver, planname, i, sheet);
		co.NewProposalaccept(prop, driver, planname);
	}
	
	public void ProposalStepMulti(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On Proposal-Step 1");
		System.out.println(planname + " On Proposal-Step 1");
		NPStep1(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 2");
		System.out.println(planname + " On Proposal-Step 2");
		NPStep2(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 3");
		System.out.println(planname + " On Proposal-Step 3");
		NPStep3(prop, driver, planname, i, sheet);
		co.NewProposalacceptmulti(prop, driver, planname);
	}

	public void NPStep1(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
	//	String XpathNPName = prop.getProperty("XpathNPName");
	//	ReusableFunctions.waitForPageToLoad(driver,XpathNPName);
		Thread.sleep(2000);
		String name = sheet.getRow(i).getCell(6).getStringCellValue();
		String gender = sheet.getRow(i).getCell(7).getStringCellValue();
		String dob = sheet.getRow(i).getCell(8).getStringCellValue();
		String passport = sheet.getRow(i).getCell(9).getStringCellValue();
		String passportissue = sheet.getRow(i).getCell(10).getStringCellValue();
		String passportexpiry = sheet.getRow(i).getCell(11).getStringCellValue();
		String pan = sheet.getRow(i).getCell(12).getStringCellValue();
		String nomineename = sheet.getRow(i).getCell(13).getStringCellValue();
		String nomineedob = sheet.getRow(i).getCell(15).getStringCellValue();
		String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();
		enterName(prop, driver, name);
		report.allurereports(driver, planname + " Name entered");
		System.out.println(planname + " Name entered");
		selectGender(prop, driver, gender, planname);
		report.allurereports(driver, planname + " Gender Selected");
		System.out.println(planname + " Gender Selected");
		enterDOB(prop, driver, dob);
		report.allurereports(driver, planname + " DOB Entered");
		System.out.println(planname + " DOB Entered");
		enterpassport(prop, driver, passport);
		report.allurereports(driver, planname + " Passport entered");
		System.out.println(planname + " Passport entered");
		ReusableFunctions.scroll(0, 300, driver);
		if (planname.equalsIgnoreCase("NIA")) {
			enterpassportissue(prop, driver, passportissue);
			report.allurereports(driver, planname + " Passport issue entered");
			System.out.println(planname + " Passport issue entered");
			enterpassportexpiry(prop, driver, passportexpiry);
			report.allurereports(driver, planname + " Passport Expiry entered");
			System.out.println(planname + " Passport Expiry entered");
		}
		Thread.sleep(1000);
		enterpan(prop, driver, pan);
		report.allurereports(driver, planname + " PAN entered");
		System.out.println(planname + " PAN entered");
		ReusableFunctions.scroll(0, 500, driver);
		Thread.sleep(1000);
		enterMobileNo(prop, driver, mobilenumber);
		Thread.sleep(1000);
		report.allurereports(driver, planname + " Mobile number entered");
		System.out.println(planname + " Mobile number entered");
		enterNomineeName(prop, driver, nomineename);
		report.allurereports(driver, planname + " Nominee name entered");
		System.out.println(planname + " Nominee name entered");
		Thread.sleep(2000);
		// String nomineerelation=sheet.getRow(i).getCell(14).getStringCellValue();
		selectNomineeRelation(prop, driver, planname);
		report.allurereports(driver, planname + " Nominee relation selected");
		System.out.println(planname + " Nominee relation selected");
		if (planname.equalsIgnoreCase("NIA") || planname.equalsIgnoreCase("NIC")) {
			enternomineedob(prop, driver, nomineedob);
			report.allurereports(driver, planname + " Nominee DOB entered");
			System.out.println(planname + " Nominee DOB entered");
			ReusableFunctions.scroll(0, 100, driver);
		}
		clickcontinue(prop, driver);
		Thread.sleep(3000);
	}
	
	public void PartnerNPStep1(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		//	String XpathNPName = prop.getProperty("XpathNPName");
		//	ReusableFunctions.waitForPageToLoad(driver,XpathNPName);
			Thread.sleep(2000);
			String name = sheet.getRow(i).getCell(6).getStringCellValue();
			String gender = sheet.getRow(i).getCell(7).getStringCellValue();
			String dob = sheet.getRow(i).getCell(8).getStringCellValue();
			String passport = sheet.getRow(i).getCell(9).getStringCellValue();
			String nomineename = sheet.getRow(i).getCell(13).getStringCellValue();
			String nomineedob = sheet.getRow(i).getCell(15).getStringCellValue();
			enterName(prop, driver, name);
			report.allurereports(driver, planname + " Name entered");
			System.out.println(planname + " Name entered");
			selectGender(prop, driver, gender, planname);
			report.allurereports(driver, planname + " Gender Selected");
			System.out.println(planname + " Gender Selected");
			enterDOB(prop, driver, dob);
			report.allurereports(driver, planname + " DOB Entered");
			System.out.println(planname + " DOB Entered");
			enterpassport(prop, driver, passport);
			report.allurereports(driver, planname + " Passport entered");
			System.out.println(planname + " Passport entered");
			ReusableFunctions.scroll(0, 300, driver);
			Thread.sleep(1000);
			enterNomineeName(prop, driver, nomineename);
			report.allurereports(driver, planname + " Nominee name entered");
			System.out.println(planname + " Nominee name entered");
			Thread.sleep(2000);
			selectNomineeRelation(prop, driver, planname);
			report.allurereports(driver, planname + " Nominee relation selected");
			System.out.println(planname + " Nominee relation selected");
			if (planname.equalsIgnoreCase("TravelPartnerTataAIG") ) {
				enternomineedob(prop, driver, nomineedob);
				report.allurereports(driver, planname + " Nominee DOB entered");
				System.out.println(planname + " Nominee DOB entered");
				ReusableFunctions.scroll(0, 100, driver);
			}
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		}

	public void enterpan(Properties prop, WebDriver driver, String pan) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPan"))).sendKeys(pan);
	}

	public void NPStep2(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		Thread.sleep(2000);
		if (planname.equalsIgnoreCase("Care") || planname.equalsIgnoreCase("StudentCare")
				|| planname.equalsIgnoreCase("MultiCare") || planname.equalsIgnoreCase("Chola")) {
			careQ1(prop, driver);
			ReusableFunctions.scroll(0, 400, driver);
			careQ2(prop, driver);
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		} else {
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		}
		Thread.sleep(2000);
		PreQuotesStep5 preQuotesStep5 = new PreQuotesStep5();
		preQuotesStep5.setPrequotesStep5proposal(prop, driver, planname, i, sheet);
	}
	
	public void PartnerNPStep2(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		Thread.sleep(2000);
		if (planname.equalsIgnoreCase("Care") || planname.equalsIgnoreCase("StudentCare")
				|| planname.equalsIgnoreCase("MultiCare") || planname.equalsIgnoreCase("Chola")) {
			careQ1(prop, driver);
			ReusableFunctions.scroll(0, 400, driver);
			careQ2(prop, driver);
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		} else {
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		}
	
	}

	
	public void NPStep3(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
	//	String XpathNPEmail = prop.getProperty("XpathNPEmail");
	//	ReusableFunctions.waitForPageToLoad(driver,XpathNPEmail);
		Thread.sleep(3000);
		String email = sheet.getRow(i).getCell(17).getStringCellValue();
		String pincode = sheet.getRow(i).getCell(18).getStringCellValue();
		String address = sheet.getRow(i).getCell(19).getStringCellValue();
		String alternateno = sheet.getRow(i).getCell(20).getStringCellValue();
		enterEmail(prop, driver, email);
		report.allurereports(driver, planname + " Email entered");
		System.out.println(planname + " Email entered");
		selectPincode(driver, prop, pincode);
		report.allurereports(driver, planname + " Pincode/City selected");
		System.out.println(planname + " Pincode/City selected");
		ReusableFunctions.scroll(0, 50, driver);
		enterAddress(prop, driver, address);
		report.allurereports(driver, planname + " Address entered");
		System.out.println(planname + " Address entered");
		enterAlternateNo(prop, driver, alternateno);
		report.allurereports(driver, planname + " AlternateNo Entered");
		System.out.println(planname + " AlternateNo Entered");
		clickDeclaration(prop, driver, planname);
		report.allurereports(driver, planname + " Declaration checked");
		System.out.println(planname + " Declaration checked");
		clickcontinue(prop, driver);
		report.allurereports(driver, planname + " Pay now clicked");
		System.out.println(planname + " Pay now clicked");
		Thread.sleep(4000);

	}
	
	
	public void PartnerNPStep3(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		//	String XpathNPEmail = prop.getProperty("XpathNPEmail");
		//	ReusableFunctions.waitForPageToLoad(driver,XpathNPEmail);
			Thread.sleep(4000);
			String email = sheet.getRow(i).getCell(17).getStringCellValue();
			String pincode = sheet.getRow(i).getCell(18).getStringCellValue();
			String address = sheet.getRow(i).getCell(19).getStringCellValue();
			String alternateno = sheet.getRow(i).getCell(20).getStringCellValue();
			enterEmail(prop, driver, email);
			report.allurereports(driver, planname + " Email entered");
			System.out.println(planname + " Email entered");
			selectPincode(driver, prop, pincode);
			report.allurereports(driver, planname + " Pincode/City selected");
			System.out.println(planname + " Pincode/City selected");
			ReusableFunctions.scroll(0, 50, driver);
			enterAddress(prop, driver, address);
			report.allurereports(driver, planname + " Address entered");
			System.out.println(planname + " Address entered");
			enterAlternateNo(prop, driver, alternateno);
			report.allurereports(driver, planname + " AlternateNo Entered");
			System.out.println(planname + " AlternateNo Entered");
			clickDeclarationPartner(prop, driver, planname);
			report.allurereports(driver, planname + " Declaration checked");
			System.out.println(planname + " Declaration checked");
			clickcontinue(prop, driver);
			report.allurereports(driver, planname + " Pay now clicked");
			System.out.println(planname + " Pay now clicked");
			Thread.sleep(4000);

		}
	public void enterName(Properties prop, WebDriver driver, String name) throws Exception {
		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPName")))
//				.sendKeys(ReusableFunctions.name(6) + " " + ReusableFunctions.name(5));
//		driver.findElement(By.xpath(prop.getProperty("XpathNPName"))).sendKeys(name);
		String XpathName = prop.getProperty("XpathNPName");
		reusableFunctions.enterelementxpath(driver, XpathName, name);

	}

	public void selectGender(Properties prop, WebDriver driver, String InsurerGender, String planname)
			throws Exception {
		Thread.sleep(1000);
			if (InsurerGender.equalsIgnoreCase("Male")) {
				String XpathNPMale = prop.getProperty("XpathTataNPMale");
				reusableFunctions.selectelementxpath(driver, XpathNPMale);
			} else if (InsurerGender.equalsIgnoreCase("Female")) {
				String XpathNPFemale = prop.getProperty("XpathTataNPFemale");
				reusableFunctions.selectelementxpath(driver, XpathNPFemale);
			}
		
	}

	public void enterDOB(Properties prop, WebDriver driver, String dob) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPDOB"))).sendKeys(dob);
	}

	public void enterpassportissue(Properties prop, WebDriver driver, String passportissue) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPassportIssue"))).sendKeys(passportissue);
	}

	public void enterpassportexpiry(Properties prop, WebDriver driver, String passportexpiry) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPassportExpiry"))).sendKeys(passportexpiry);
	}

	public void enternomineedob(Properties prop, WebDriver driver, String nomineedob) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNomineeDOB"))).sendKeys(nomineedob);
	}

	public void clickcontinue(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPContinue"))).click();
	}

	public void careQ1(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ1"))).click();
	}

	public void careQ2(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ2"))).click();
	}

	public void enterpassport(Properties prop, WebDriver driver, String passport) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPPassport"))).sendKeys(passport);
	}

	public void enterEmail(Properties prop, WebDriver driver, String email) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPEmail"))).sendKeys(email);
	}

	public void selectPincode(WebDriver driver, Properties prop, String pincode) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPPincode"))).sendKeys(pincode);

	}

	public void enterAddress(Properties prop, WebDriver driver, String address) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPAddress"))).sendKeys(address);
	}

	public void enterAlternateNo(Properties prop, WebDriver driver, String alternateno) throws Exception {
		Thread.sleep(1000);
		// long number = ReusableFunctions.enterMobileNumber();
		// driver.findElement(By.xpath(prop.getProperty("XpathNPAltMobile"))).sendKeys(String.valueOf(number));
		driver.findElement(By.xpath(prop.getProperty("XpathNPAltMobile"))).sendKeys(alternateno);
		ReusableFunctions.scroll(0, 150, driver);
		Thread.sleep(2500);
	}

	public void enterNomineeName(Properties prop, WebDriver driver, String nomineename) throws Exception {
		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPNomineeName")))
//				.sendKeys(ReusableFunctions.name(5) + " " + ReusableFunctions.name(4));
		driver.findElement(By.xpath(prop.getProperty("XpathNPNomineeName"))).sendKeys(nomineename);

	}

	public void selectNomineeRelation(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("XpathNP1NomineeRelation"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPNomineeSelect"))).click();
	}

	public void clickDeclaration(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(1500);
		if (planname.equalsIgnoreCase("TataAIG") || planname.equalsIgnoreCase("StudentTata")
				|| planname.equalsIgnoreCase("MultiTata")) {
			driver.findElement(By.xpath(prop.getProperty("XpathNPTataCheck"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
			driver.findElement(By.xpath(prop.getProperty("XpathNPKYCDeclaration"))).click();
		} else if (planname.equalsIgnoreCase("Chola")) {
			driver.findElement(By.xpath(prop.getProperty("XpathNPCholaCheck"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
			driver.findElement(By.xpath(prop.getProperty("XpathNPKYCDeclaration"))).click();
		} else if (planname.equalsIgnoreCase("HDFC")) {
			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
			driver.findElement(By.xpath(prop.getProperty("XpathNPKYCDeclaration"))).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(prop.getProperty("XpathNPCISDeclaration"))).click();
		} 
		else {
			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
			driver.findElement(By.xpath(prop.getProperty("XpathNPKYCDeclaration"))).click();

		}

	}
	
	public void clickDeclarationPartner(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(1500);
		
			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
			//driver.findElement(By.xpath(prop.getProperty("XpathNPKYCDeclaration"))).click();
	}
	public void enterMobileNo(Properties prop, WebDriver driver, String mobilenumber) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathOfMobileNumber"))).sendKeys(mobilenumber);
		Thread.sleep(1000);
	}


}
