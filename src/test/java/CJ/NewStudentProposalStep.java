package CJ;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ReportGenerator;
import utils.ReusableFunctions;

public class NewStudentProposalStep {
	ReportGenerator report = new ReportGenerator();
	CheckOut co = new CheckOut();
	ReusableFunctions reusableFunctions = new ReusableFunctions();

	public void enterStudentProposalDetails(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		report.allurereports(driver, planname + " On Proposal-Step 1");
		System.out.println(planname + " On Proposal-Step 1");
		Thread.sleep(1000);
		NPStep1(prop, driver, planname, i, sheet);
		report.allurereports(driver, planname + " On Proposal-Step 2");
		System.out.println(planname + " On Proposal-Step 2");
		NPStep2(prop, driver, planname, i, sheet);
		if (planname.equalsIgnoreCase("StudentCare") || planname.equalsIgnoreCase("StudentReliance")
				|| planname.equalsIgnoreCase("StudentRSA") || planname.equalsIgnoreCase("StudentTata")
				|| planname.equalsIgnoreCase("StudentNiva")) {
			report.allurereports(driver, planname + " On Student proposal");
			System.out.println(planname + " On Student proposal");
			enterStudentDetails(prop, driver, planname, i, sheet);
		}
		report.allurereports(driver, planname + " On Proposal-Step 3");
		System.out.println(planname + " On Proposal-Step 3");
		Thread.sleep(2000);
		NPStep3(prop, driver, planname, i, sheet);
		co.NewProposalacceptstudent(prop, driver, planname);

	}

	public void NPStep1(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		Thread.sleep(2000);
		String name = sheet.getRow(i).getCell(6).getStringCellValue();
		enterName(prop, driver, name);
		report.allurereports(driver, planname + " Name entered");
		System.out.println(planname + " Name entered");
		String gender = sheet.getRow(i).getCell(7).getStringCellValue();
		selectGender(prop, driver, gender, planname);
		report.allurereports(driver, planname + " Gender Selected");
		System.out.println(planname + " Gender Selected");
		String dob = sheet.getRow(i).getCell(8).getStringCellValue();
		enterDOB(prop, driver, dob);
		report.allurereports(driver, planname + " DOB Entered");
		System.out.println(planname + " DOB Entered");
		String passport = sheet.getRow(i).getCell(9).getStringCellValue();
		enterpassport(prop, driver, passport);
		report.allurereports(driver, planname + " Passport entered");
		System.out.println(planname + " Passport entered");
		ReusableFunctions.scroll(0, 300, driver);
		String pan = sheet.getRow(i).getCell(12).getStringCellValue();
		enterpan(prop, driver, pan);
		report.allurereports(driver, planname + " Pannumber entered");
		System.out.println(planname + " Pannumber entered");
		String mobilenumber = sheet.getRow(i).getCell(5).getStringCellValue();
		Thread.sleep(1000);
		enterMobileNo(prop, driver, mobilenumber);
		report.allurereports(driver, planname + " Mobile number entered");
		System.out.println(planname + " Mobile number entered");
		Thread.sleep(1000);
		String nomineename = sheet.getRow(i).getCell(13).getStringCellValue();
		enterNomineeName(prop, driver, nomineename);
		report.allurereports(driver, planname + " Nominee name entered");
		System.out.println(planname + " Nominee name entered");
		Thread.sleep(2000);
//		String nomineerelation=sheet.getRow(i).getCell(14).getStringCellValue();
		selectNomineeRelation(prop, driver, planname);
		report.allurereports(driver, planname + " Nominee relation selected");
		System.out.println(planname + " Nominee relation selected");
		clickcontinue(prop, driver);
		Thread.sleep(3000);
	}

	public void enterMobileNo(Properties prop, WebDriver driver, String mobilenumber) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathOfMobileNumber"))).sendKeys(mobilenumber);
		Thread.sleep(1000);
	}

	public void NPStep2(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		Thread.sleep(3000);
		if (planname.equalsIgnoreCase("StudentCare")) {
			Thread.sleep(1000);
			careQ1(prop, driver);
			ReusableFunctions.scroll(0, 400, driver);
			careQ2(prop, driver);
			clickcontinue(prop, driver);
			Thread.sleep(2000);
		} else {
			clickcontinue(prop, driver);
			Thread.sleep(2000);
		}
		System.out.println(planname + " Proposal Step 2 Continue clicked");

		Thread.sleep(2000);
		PreQuotesStep5 preQuotesStep5 = new PreQuotesStep5();
		preQuotesStep5.setPrequotesStep5proposal(prop, driver, planname, i, sheet);
	}

	public void enterpan(Properties prop, WebDriver driver, String pan) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPan"))).sendKeys(pan);
	}

	public void careQ1(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ1"))).click();
	}

	public void careQ2(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ2"))).click();
	}

	public void enterName(Properties prop, WebDriver driver, String name) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPName"))).sendKeys(name);
	}

	public void selectGender(Properties prop, WebDriver driver, String InsurerGender, String planname)
			throws Exception {
		Thread.sleep(1000);
		if (planname.equalsIgnoreCase("StudentTata")) {
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

	public void enterpassport(Properties prop, WebDriver driver, String passport) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPPassport"))).sendKeys(passport);
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

	public void clickcontinue(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPContinue"))).click();
	}

	public void enterStudentDetails(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet)
			throws Exception {
		Thread.sleep(4000);
//		String courseduration = sheet.getRow(i).getCell(21).getStringCellValue();
		String coursefee = sheet.getRow(i).getCell(22).getStringCellValue();
		String coursename = sheet.getRow(i).getCell(23).getStringCellValue();
		String sponsoraddress = sheet.getRow(i).getCell(24).getStringCellValue();
		String sponsorcity = sheet.getRow(i).getCell(25).getStringCellValue();
		// String sponsorcountry = sheet.getRow(i).getCell(26).getStringCellValue();
		String sponsordob = sheet.getRow(i).getCell(27).getStringCellValue();
		String sponsorname = sheet.getRow(i).getCell(28).getStringCellValue();
		// String sponsorrelation = sheet.getRow(i).getCell(29).getStringCellValue();
		String sponsorstate = sheet.getRow(i).getCell(30).getStringCellValue();
		String universitycity = sheet.getRow(i).getCell(31).getStringCellValue();
		String universityaddress = sheet.getRow(i).getCell(32).getStringCellValue();
		// String universitycountry = sheet.getRow(i).getCell(33).getStringCellValue();
		String universityname = sheet.getRow(i).getCell(34).getStringCellValue();
		String universitystate = sheet.getRow(i).getCell(35).getStringCellValue();
		String semesterduration = sheet.getRow(i).getCell(37).getStringCellValue();

		if (planname.equalsIgnoreCase("StudentCare")) {
			enterUniversityName(driver, prop, universityname, planname);
			enterUniversityAddress(driver, prop, universityaddress, planname);
			enterCourseName(driver, prop, coursename, planname);
			enterSponsorname(driver, prop, sponsorname, planname);
			enterSponsorDOB(prop, driver, sponsordob, planname);
			ReusableFunctions.scroll(0, 300, driver);
			enterSponsorRelation(prop, driver, planname);
			enterSponsorState(driver, prop, sponsorstate, planname);
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		} else if (planname.equalsIgnoreCase("StudentReliance")) {
			enterUniversityName(driver, prop, universityname, planname);
			enterUniversityAddress(driver, prop, universityaddress, planname);
			enterUniversityCity(driver, prop, universitycity, planname);
			enterUniversityState(driver, prop, universitystate, planname);
			ReusableFunctions.scroll(0, 250, driver);
			enterUniversityCountry(driver, prop, planname);
			enterCourseFee(driver, prop, coursefee, planname);
			enterCourseDuration(driver, prop, planname);
			enterSemesterDuration(driver, prop, semesterduration, planname);
			ReusableFunctions.scroll(0, 250, driver);
			enterSponsorname(driver, prop, sponsorname, planname);
			enterSponsorAddress(driver, prop, sponsoraddress, planname);
			enterSponsorCity(driver, prop, sponsorcity, planname);
			enterSponsorState(driver, prop, sponsorstate, planname);
			enterSponsorCountry(driver, prop, planname);
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		} else if (planname.equalsIgnoreCase("StudentRSA")) {
			enterUniversityName(driver, prop, universityname, planname);
			enterUniversityAddress(driver, prop, universityaddress, planname);
			enterUniversityCity(driver, prop, universitycity, planname);
			enterUniversityState(driver, prop, universitystate, planname);
			enterUniversityCountry(driver, prop, planname);
			enterCourseName(driver, prop, coursename, planname);
			enterCourseFee(driver, prop, coursefee, planname);
			ReusableFunctions.scroll(0, 250, driver);
			enterSponsorname(driver, prop, sponsorname, planname);
			enterSponsorDOB(prop, driver, sponsordob, planname);
			ReusableFunctions.scroll(0, 250, driver);
			enterSponsorRelation(prop, driver, planname);
			enterSponsorAddress(driver, prop, sponsoraddress, planname);
			enterSponsorCity(driver, prop, sponsorcity, planname);
			enterSponsorState(driver, prop, sponsorstate, planname);
			enterSponsorCountry(driver, prop, planname);
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		} else if (planname.equalsIgnoreCase("StudentTata")) {
			ReusableFunctions.scroll(0, 250, driver);
			enterUniversityName(driver, prop, universityname, planname);
			enterUniversityAddress(driver, prop, universityaddress, planname);
			enterCourseName(driver, prop, coursename, planname);
			enterCourseDuration(driver, prop, planname);
			ReusableFunctions.scroll(0, 100, driver);
			enterSponsorname(driver, prop, sponsorname, planname);
			enterSponsorDOB(prop, driver, sponsordob, planname);
			enterSponsorRelation(prop, driver, planname);
			ReusableFunctions.scroll(0, 50, driver);
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		} else if (planname.equalsIgnoreCase("StudentNiva")) {
			ReusableFunctions.scroll(0, 250, driver);
			enterUniversityName(driver, prop, universityname, planname);
			enterUniversityAddress(driver, prop, universityaddress, planname);
			enterCourseName(driver, prop, coursename, planname);
			enterCourseDuration(driver, prop, planname);
			ReusableFunctions.scroll(0, 150, driver);
			enterSponsorname(driver, prop, sponsorname, planname);
			enterSponsorRelation(prop, driver, planname);
			ReusableFunctions.scroll(0, 50, driver);
			enterSponsorAddress(driver, prop, sponsoraddress, planname);
			clickcontinue(prop, driver);
			Thread.sleep(3000);
		}

	}

	public void enterUniversityName(WebDriver driver, Properties prop, String universityname, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewUniversityName"))).sendKeys(universityname);
		System.out.println(planname + " University Name entered");
		report.allurereports(driver, planname + " University Name entered");
		;
	}

	public void enterUniversityAddress(WebDriver driver, Properties prop, String universityaddress, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewUniversityAddress"))).sendKeys(universityaddress);
		System.out.println(planname + " University Address entered");
		report.allurereports(driver, planname + " University Address entered");
	}

	public void enterUniversityCity(WebDriver driver, Properties prop, String universitycity, String planname)
			throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("NewUniveristyCity"))).sendKeys(universitycity);
		System.out.println(planname + " University City entered");
		report.allurereports(driver, planname + " University city entered");
	}

	public void enterUniversityState(WebDriver driver, Properties prop, String universitystate, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewUniversityState"))).sendKeys(universitystate);
		System.out.println(planname + " University State entered");
		report.allurereports(driver, planname + " University state entered");
	}

	public void enterUniversityCountry(WebDriver driver, Properties prop, String planname) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("NewUniversityCountry"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("NewUniversityCountrySelect"))).click();
		System.out.println(planname + " University Country selected");
		report.allurereports(driver, planname + " University Country Selected");
	}

	public void enterSponsorname(WebDriver driver, Properties prop, String sponsorname, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorName"))).sendKeys(sponsorname);
		System.out.println(planname + " Sponsor name entered");
		report.allurereports(driver, planname + " Sponsor name entered");
	}

	public void enterSponsorAddress(WebDriver driver, Properties prop, String sponsoraddress, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorAddress"))).sendKeys(sponsoraddress);
		System.out.println(planname + " Sponsor Address entered");
		report.allurereports(driver, planname + " Sponsor Address entered");
	}

	public void enterSponsorCity(WebDriver driver, Properties prop, String sponsorcity, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorCity"))).sendKeys(sponsorcity);
		System.out.println(planname + " Sponsor City entered");
		report.allurereports(driver, planname + " Sponsor City entered");
	}

	public void enterSponsorState(WebDriver driver, Properties prop, String sponsorstate, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorState"))).sendKeys(sponsorstate);
		System.out.println(planname + " Sponsor State entered");
		report.allurereports(driver, planname + " Sponsor State entered");
	}

	public void enterSponsorCountry(WebDriver driver, Properties prop, String planname) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorCountry"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorCountrySelect"))).click();
		System.out.println(planname + " Sponsor Country entered");
		report.allurereports(driver, planname + " Sponsor Country entered");
	}

	public void enterSponsorDOB(Properties prop, WebDriver driver, String sponsordob, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorDOB"))).sendKeys(sponsordob);
		System.out.println(planname + " Sponsor DOB entered");
		report.allurereports(driver, planname + " Sponsor DOB entered");
	}

	public void enterSponsorRelation(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorRelation"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("NewSponsorRelationSelect"))).click();
		System.out.println(planname + " Sponsor relation entered");
		report.allurereports(driver, planname + " Sponsor Relation entered");
	}

	public void enterCourseName(WebDriver driver, Properties prop, String coursename, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewCourseName"))).sendKeys(coursename);
		System.out.println(planname + " Course name entered");
		report.allurereports(driver, planname + " Course name entered");
	}

	public void enterCourseFee(WebDriver driver, Properties prop, String coursefee, String planname) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("NewCourseFee"))).sendKeys(coursefee);
		System.out.println(planname + " Course Fee entered");
		report.allurereports(driver, planname + " Course Fee entered");
	}

	public void enterSemesterDuration(WebDriver driver, Properties prop, String semesterduration, String planname)
			throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("SemesterDuration"))).sendKeys(semesterduration);
		System.out.println(planname + " Course Fee entered");
		report.allurereports(driver, planname + " Semester Duration Entered");
	}

	public void enterCourseDuration(WebDriver driver, Properties prop, String planname) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("NewCourseDuration"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("NewCourseDurationSelect"))).click();
		System.out.println(planname + " Course Duration selected");
		report.allurereports(driver, planname + " Course Duration selected");
	}

	public void NPStep3(Properties prop, WebDriver driver, String planname, int i, XSSFSheet sheet) throws Exception {
		Thread.sleep(4000);
		String email = sheet.getRow(i).getCell(17).getStringCellValue();
		enterEmail(prop, driver, email);
		report.allurereports(driver, planname + " Email entered");
		System.out.println(planname + " Email entered");
		String pincode = sheet.getRow(i).getCell(18).getStringCellValue();
		selectPincode(driver, prop, pincode);
		report.allurereports(driver, planname + " Pincode/City selected");
		System.out.println(planname + " Pincode/City selected");
		ReusableFunctions.scroll(0, 50, driver);
		String address = sheet.getRow(i).getCell(19).getStringCellValue();
		enterAddress(prop, driver, address);
		report.allurereports(driver, planname + " Address entered");
		System.out.println(planname + " Address entered");
		String alternateno = sheet.getRow(i).getCell(20).getStringCellValue();
		enterAlternateNo(prop, driver, alternateno);
		report.allurereports(driver, planname + " AlternateNo Entered");
		System.out.println(planname + " AlternateNo Entered");
		clickDeclaration(prop, driver, planname);
		report.allurereports(driver, planname + " Declaration checked");
		System.out.println(planname + " Declaration checked");
		clickcontinue(prop, driver);
		report.allurereports(driver, planname + " Pay now clicked");
		System.out.println(planname + " Pay now clicked");
		Thread.sleep(3000);

	}

	public void enterEmail(Properties prop, WebDriver driver, String email) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPEmail"))).sendKeys(email);
	}

	public void selectPincode(WebDriver driver, Properties prop, String pincode) throws Exception {
//		driver.findElement(By.xpath(prop.getProperty("XpathNPPincode"))).sendKeys(prop.getProperty("Pincode1"));
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPPincode"))).sendKeys(prop.getProperty("Pincode2"));
//		Thread.sleep(1000);
		// driver.findElement(By.xpath(prop.getProperty("XpathNPPincodeSelect"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPPincode"))).sendKeys(pincode);

	}

	public void enterAddress(Properties prop, WebDriver driver, String address) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNPAddress"))).sendKeys(address);
	}

	public void enterAlternateNo(Properties prop, WebDriver driver, String alternateno) throws Exception {
		Thread.sleep(1000);
//		long number = ReusableFunctions.enterMobileNumber();
		driver.findElement(By.xpath(prop.getProperty("XpathNPAltMobile"))).sendKeys(alternateno);
		ReusableFunctions.scroll(0, 150, driver);
		Thread.sleep(2500);
	}

	public void clickDeclaration(Properties prop, WebDriver driver, String planname) throws Exception {
		Thread.sleep(1000);
		Thread.sleep(500);
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
		} else {
			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
			driver.findElement(By.xpath(prop.getProperty("XpathNPKYCDeclaration"))).click();
		}
	}

}
