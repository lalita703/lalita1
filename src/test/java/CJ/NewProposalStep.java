//package CJ;
//
//import java.util.Properties;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import utils.ReportGenerator;
//import utils.ReusableFunctions;
//
//public class NewProposalStep {
//	ReportGenerator report = new ReportGenerator();
//	CheckOut co = new CheckOut();
//
//	public void ProposalStep(Properties prop, WebDriver driver, String Gender, String planname) throws Exception {
//		report.allurereports(driver,planname+ " On New Proposal-Step 1");
//		System.out.println(planname + "On New Proposal-Step 1");
//		NPStep1(prop, driver, Gender, planname);
//		report.allurereports(driver,planname+ " On New Proposal-Step 2");
//		System.out.println(planname + "On New Proposal-Step 2");
//		NPStep2(prop, driver, planname);
//		report.allurereports(driver,planname+ " On New Proposal-Step 3");
//		System.out.println(planname + "On New Proposal-Step 3");
//		NPStep3(prop, driver, planname);
//		co.NewProposalaccept(prop, driver, planname);
//	}
//
//	public void NPStep1(Properties prop, WebDriver driver, String Gender, String planname) throws Exception {
//		enterName(prop, driver);
//		report.allurereports(driver,planname+ " Name entered");
//		System.out.println(planname + "Name entered");
//		selectGender(prop, driver, Gender);
//		report.allurereports(driver,planname+ " Gender Selected");
//		System.out.println(planname + "Gender Selected");
//		enterDOB(prop, driver);
//		report.allurereports(driver,planname+ " DOB Entered");
//		System.out.println(planname + "DOB Entered");
//		clickcontinue(prop, driver);
//	}
//
//	public void NPStep2(Properties prop, WebDriver driver, String planname) throws Exception {
//		if (planname.equalsIgnoreCase("Care") || planname.equalsIgnoreCase("StudentCare")
//				|| planname.equalsIgnoreCase("MultiCare")|| planname.equalsIgnoreCase("Chola")) {
//			careQ1(prop, driver);
//			ReusableFunctions.scroll(0, 400, driver);
//			careQ2(prop, driver);
//			clickcontinue(prop, driver);
//		} else {
//			clickcontinue(prop, driver);
//		}
//	}
//
//	public void NPStep3(Properties prop, WebDriver driver, String planname) throws Exception {
//		enterpassport(prop, driver);
//		report.allurereports(driver,planname+ " Passport entered");
//		System.out.println(planname + "Passport entered");
//		enterEmail(prop, driver);
//		report.allurereports(driver,planname+ " Email entered");
//		System.out.println(planname + "Email entered");
//		ReusableFunctions.scroll(0, 300, driver);
//		selectPincode(driver, prop);
//		report.allurereports(driver,planname+ " Pincode/City selected");
//		System.out.println(planname + "Pincode/City selected");
//		ReusableFunctions.scroll(0, 50, driver);
//		enterAddress(prop, driver);
//		report.allurereports(driver,planname+ " Address entered");
//		System.out.println(planname + "Address entered");
//		enterAlternateNo(prop, driver);
//		report.allurereports(driver,planname+ " AlternateNo Entered");
//		System.out.println(planname + "AlternateNo Entered");
//		ReusableFunctions.scroll(0, 200, driver);
//		enterNomineeName(prop, driver);
//		report.allurereports(driver,planname+ " Nominee name entered");
//		System.out.println(planname + "Nominee name entered");
//		Thread.sleep(1000);
//		selectNomineeRelation(prop, driver, planname);
//		report.allurereports(driver,planname+ " Nominee relation selected");
//		System.out.println(planname + "Nominee relation selected");
//		clickDeclaration(prop, driver, planname);
//		report.allurereports(driver,planname+ " Declaration checked");
//		System.out.println(planname + "Declaration checked");
//		clickcontinue(prop, driver);
//		report.allurereports(driver,planname+ " Pay now clicked");
//		System.out.println(planname + "Pay now clicked");
//
//	}
//
//	public void enterName(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPName")))
//				.sendKeys(ReusableFunctions.name(6) + " " + ReusableFunctions.name(5));
//	}
//
//	public void selectGender(Properties prop, WebDriver driver, String InsurerGender) throws Exception {
//		Thread.sleep(1000);
//		if (InsurerGender.equalsIgnoreCase("Male")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathNPMale"))).click();
//		} else if (InsurerGender.equalsIgnoreCase("Female")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathNPFemale"))).click();
//		}
//	}
//
//	public void enterDOB(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPDOB"))).sendKeys("26011997");
//	}
//
//	public void clickcontinue(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPContinue"))).click();
//	}
//
//	public void careQ1(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ1"))).click();
//	}
//
//	public void careQ2(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPCareQ2"))).click();
//	}
//
//	public void enterpassport(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPPassport"))).sendKeys(ReusableFunctions.passport());
//	}
//
//	public void enterEmail(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPEmail"))).sendKeys("adityajain@policybazaar.com");
//	}
//
//	public void selectPincode(WebDriver driver, Properties prop) throws Exception {
//		driver.findElement(By.xpath(prop.getProperty("XpathNPPincode"))).sendKeys(prop.getProperty("Pincode1"));
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPPincode"))).sendKeys(prop.getProperty("Pincode2"));
//		Thread.sleep(1000);
//		//driver.findElement(By.xpath(prop.getProperty("XpathNPPincodeSelect"))).click();
//		Thread.sleep(1000);
//
//	}
//
//	/*
//	 * public void selectCity(WebDriver driver, Properties prop) { WebElement
//	 * element = driver.findElement(By.xpath(prop.getProperty("XpathNPCity")));
//	 * Select op1 = new Select(element); op1.selectByValue("1"); }
//	 */
//
//	public void enterAddress(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPAddress"))).sendKeys(ReusableFunctions.address());
//	}
//
//	public void enterAlternateNo(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		long number = ReusableFunctions.enterMobileNumber();
//		driver.findElement(By.xpath(prop.getProperty("XpathNPAltMobile"))).sendKeys(String.valueOf(number));
//		ReusableFunctions.scroll(0, 150, driver);
//		Thread.sleep(2500);
//	}
//
//	public void enterNomineeName(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPNomineeName")))
//				.sendKeys(ReusableFunctions.name(5) + " " + ReusableFunctions.name(4));
//		;
//	}
//
//	public void selectNomineeRelation(Properties prop, WebDriver driver, String planname) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPNomineeRelation"))).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNPNomineeSelect"))).click();
//	}
//
//	public void clickDeclaration(Properties prop, WebDriver driver, String planname) throws Exception {
//		Thread.sleep(1000);
//
//		if (planname.equalsIgnoreCase("TataAIG") || planname.equalsIgnoreCase("StudentTata")
//				|| planname.equalsIgnoreCase("MultiTata")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathNPTataCheck"))).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
//		} else {
//			driver.findElement(By.xpath(prop.getProperty("XpathNPDeclaration"))).click();
//		}
//	}
//
//}
