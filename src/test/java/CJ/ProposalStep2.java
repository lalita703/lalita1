//package CJ;
//
//import java.util.Properties;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import utils.ReportGenerator;
//import utils.ReusableFunctions;
//
//public class ProposalStep2 {
//	ReportGenerator report = new ReportGenerator();
//	public void enterProposalStep2Details(Properties prop, WebDriver driver, String InsurerGender, String Option,
//			String ProposerGender, String Planname) throws Exception {
//		System.out.println(Planname+" On Proposal Step2");
//		report.setupresult(Planname, "On Proposal Step2");
//		enterPersonalDetails(prop, driver, InsurerGender, Planname);
//		System.out.println(Planname+" Personal Details Entered");
//		report.setupresult(Planname, "Personal Details Entered");
//		enterNomineeDetails(prop, driver,Planname);
//		System.out.println(Planname+" Nominee Details Entered");
//		report.setupresult(Planname, "Nominee Details Entered");
//		enterProposerDetails(Option, prop, driver, ProposerGender);
//		System.out.println(Planname+" Proposer Details Entered and proceed clicked");
//		report.setupresult(Planname, "Proposer Details Entered and proceed clicked");
//
//	}
//
//	public void enterPersonalDetails(Properties prop, WebDriver driver, String InsurerGender, String Planname)
//			throws Exception {
//		ReusableFunctions.scroll(0, 100, driver);
//		enterInsurerName(prop, driver);
//		selectInsurerGender(prop, driver, InsurerGender);
//		enterInsurerpassport(prop, driver);
//		if (Planname.equalsIgnoreCase("NIA")) {
//			enterInsurerpassportexpiry(prop, driver);
//		}
//	}
//
//	public void enterInsurerName(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathTravellerName")))
//				.sendKeys(ReusableFunctions.name(6)+" "+ReusableFunctions.name(5));
//	}
//
//	public void enterInsurerpassportexpiry(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathPassportExpiry"))).click();
//		String xpath = "/html/body/section/form/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]/div/div/div[2]/div[2]/div["
//				+ PreQuotesStep2.weeknum() + "]/div[" + PreQuotesStep2.daynum() + "]";
//		driver.findElement(By.xpath(xpath)).click();
//
//	}
//
//	public void selectInsurerGender(Properties prop, WebDriver driver, String InsurerGender) throws Exception {
//		Thread.sleep(1000);
//		if (InsurerGender.equalsIgnoreCase("Male")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathMaleGender"))).click();
//		} else if (InsurerGender.equalsIgnoreCase("Female")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathFemaleGender"))).click();
//		}
//	}
//
//	public void enterInsurerpassport(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathPassport"))).sendKeys(ReusableFunctions.passport());
//	}
//
//	public void enterNomineeDetails(Properties prop, WebDriver driver,String planname) throws Exception {
//		ReusableFunctions.scroll(0, 175, driver);
//		enterNomineeName(prop, driver);
//		if(planname.equalsIgnoreCase("Oriental")|| planname.equalsIgnoreCase("MultiOriental")) {
//			selectNomineeRelationOriental(prop, driver);
//		}else {
//			selectNomineeRelation(prop, driver);
//		}
//		Thread.sleep(1000);
//		if(planname.equalsIgnoreCase("TataAIG") || planname.equalsIgnoreCase("MultiTata")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathNomineeDeclaration"))).click();
//		}
//
//	}
//
//	public void enterNomineeName(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathNominee"))).sendKeys(ReusableFunctions.name(5)+" "+ReusableFunctions.name(4));
//		;
//	}
//
//	public void selectNomineeRelation(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.xpath(prop.getProperty("XpathNomineeRelation")));
//		Select op1 = new Select(element);
//		op1.selectByValue(prop.getProperty("NomineeRelation"));
//	}
//	public void selectNomineeRelationOriental(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.xpath(prop.getProperty("XpathNomineeRelation")));
//		Select op1 = new Select(element);
//		op1.selectByValue(prop.getProperty("NomineeRelationOriental"));
//	}
//
//	public void enterProposerDetails(String Option, Properties prop, WebDriver driver, String Gender) throws Exception {
//		Thread.sleep(1000);
//		if (Option.equalsIgnoreCase("Yes")) {
//			ReusableFunctions.scroll(0, 500, driver);
//			enterProposerEmail(prop, driver);
//			selectProposerPincode(driver, prop);
//			selectProposercity(driver, prop);
//			enterProposerAddress(prop, driver);
//			enterProposerAlternateNo(prop, driver);
//		//	ReusableFunctions.scroll(0, 150, driver);
//			driver.findElement(By.xpath(prop.getProperty("XpathProceed"))).click();
//		} else if (Option.equalsIgnoreCase("No")) {
//			ReusableFunctions.scroll(0, 350, driver);
//			driver.findElement(By.xpath(prop.getProperty("XpathSameAsAbove"))).click();
//			enterProposerName(prop, driver);
//			selectProposerGender(prop, driver, Gender);
//			selectProposerDOB(prop, driver);
//			enterProposerEmail(prop, driver);
//			selectProposerPincode(driver, prop);
//			selectProposercity(driver, prop);
//			enterProposerAddress(prop, driver);
//			selectProposerRelation(prop, driver);
//			enterProposerAlternateNo(prop, driver);
//			ReusableFunctions.scroll(0, 100, driver);
//			driver.findElement(By.xpath(prop.getProperty("XpathProceed"))).click();
//
//		}
//	}
//
//	public void selectProposerRelation(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.xpath(prop.getProperty("XpathProposerRelation")));
//		Select op1 = new Select(element);
//		op1.selectByValue(prop.getProperty("ProposerRelation"));
//	}
//
//	public void enterProposerAlternateNo(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		long number=ReusableFunctions.enterMobileNumber();
//		driver.findElement(By.xpath(prop.getProperty("XpathProposerAlternateNo")))
//				.sendKeys(String.valueOf(number));
//		ReusableFunctions.scroll(0, 150, driver);
//		Thread.sleep(1000);
//	}
//
//	public void enterProposerName(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathProposerName"))).sendKeys(ReusableFunctions.name(5)+" "+ReusableFunctions.name(5));
//	}
//
//	public void enterProposerAddress(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathProposerAddress"))).sendKeys(ReusableFunctions.address());
//	}
//
//	public void enterProposerEmail(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathProposerEmail"))).sendKeys("adityajain@policybazaar.com");
//		//driver.findElement(By.xpath(prop.getProperty("XpathProposerEmail"))).sendKeys(ReusableFunctions.name(7)+"@tesla.com");
//	}
//
//	public void selectProposercity(WebDriver driver, Properties prop) {
//		WebElement element = driver.findElement(By.xpath(prop.getProperty("XpathProposerCity")));
//		Select op1 = new Select(element);
//		op1.selectByIndex(1);
//	}
//
//	public void selectProposerGender(Properties prop, WebDriver driver, String ProposerGender) {
//		if (ProposerGender.equalsIgnoreCase("Male")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathProposerMaleGender"))).click();
//		} else if (ProposerGender.equalsIgnoreCase("Female")) {
//			driver.findElement(By.xpath(prop.getProperty("XpathProposerFemaleGender"))).click();
//		}
//
//	}
//
//	public void selectProposerDOB(Properties prop, WebDriver driver) throws Exception {
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathProposerDOB"))).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathProperDOBDate"))).click();
//	}
//
//	public void selectProposerPincode(WebDriver driver, Properties prop) throws Exception {
//		driver.findElement(By.xpath(prop.getProperty("XpathProposerPincode"))).sendKeys(prop.getProperty("Pincode"));
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(prop.getProperty("XpathProposerSelectPin"))).click();
//
//	}
//}
