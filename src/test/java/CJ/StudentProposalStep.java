/*
 * package CJ;
 * 
 * import java.util.Properties; import org.openqa.selenium.By; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.ui.Select;
 * 
 * import utils.ReportGenerator; import utils.ReusableFunctions;
 * 
 * public class StudentProposalStep { ReportGenerator report = new
 * ReportGenerator();
 * 
 * public void enterStudentProposalDetails(Properties prop, WebDriver driver,
 * String InsurerGender, String Option, String ProposerGender, String Planname)
 * throws Exception { report.setupresult(Planname, "On Proposal Step2");
 * enterPersonalDetails(prop, driver, InsurerGender, Planname);
 * report.setupresult(Planname, "Personal Details Entered");
 * enterNomineeDetails(prop, driver, Planname); report.setupresult(Planname,
 * "Nominee Details Entered");
 * enterStudentDetails(prop,driver,Planname,Option,ProposerGender);
 * 
 * }
 * 
 * 
 * public void enterPersonalDetails(Properties prop, WebDriver driver, String
 * InsurerGender, String Planname) throws Exception {
 * ReusableFunctions.scroll(0, 100, driver); enterInsurerName(prop, driver);
 * selectInsurerGender(prop, driver, InsurerGender); enterInsurerpassport(prop,
 * driver); if (Planname.equalsIgnoreCase("StudentNIA")) {
 * enterInsurerpassportexpiry(prop, driver); } } public void
 * enterInsurerName(Properties prop, WebDriver driver) throws Exception {
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathTravellerName")))
 * .sendKeys(ReusableFunctions.name(6)+" "+ReusableFunctions.name(5)); } public
 * void selectInsurerGender(Properties prop, WebDriver driver, String
 * InsurerGender) throws Exception { Thread.sleep(1000); if
 * (InsurerGender.equalsIgnoreCase("Male")) {
 * driver.findElement(By.xpath(prop.getProperty("XpathMaleGender"))).click(); }
 * else if (InsurerGender.equalsIgnoreCase("Female")) {
 * driver.findElement(By.xpath(prop.getProperty("XpathFemaleGender"))).click();
 * } } public void enterInsurerpassport(Properties prop, WebDriver driver)
 * throws Exception { Thread.sleep(1000);
 * 
 * driver.findElement(By.xpath(prop.getProperty("XpathPassport"))).sendKeys(
 * ReusableFunctions.passport()); } public void
 * enterInsurerpassportexpiry(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathPassportExpiry"))).click()
 * ; String xpath =
 * "/html/body/section/form/div/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]/div/div/div[2]/div[2]/div["
 * + PreQuotesStep2.weeknum() + "]/div[" + PreQuotesStep2.daynum() + "]";
 * driver.findElement(By.xpath(xpath)).click();
 * 
 * } public void enterNomineeDetails(Properties prop, WebDriver driver,String
 * planname) throws Exception { ReusableFunctions.scroll(0, 175, driver);
 * enterNomineeName(prop, driver); selectNomineeRelation(prop, driver);
 * Thread.sleep(500); if(planname.equalsIgnoreCase("StudentTata") ) {
 * driver.findElement(By.xpath(prop.getProperty("XpathNomineeDeclaration"))).
 * click(); }
 * 
 * } public void enterNomineeName(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathNominee"))).sendKeys(
 * ReusableFunctions.name(5)+" "+ReusableFunctions.name(4)); ; } public void
 * selectNomineeRelation(Properties prop, WebDriver driver) throws Exception {
 * Thread.sleep(1000); WebElement element =
 * driver.findElement(By.xpath(prop.getProperty("XpathNomineeRelation")));
 * Select op1 = new Select(element);
 * op1.selectByValue(prop.getProperty("NomineeRelation")); } public void
 * enterUniversityName(WebDriver driver, Properties prop) throws Exception{
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("UniversityName"))).sendKeys(
 * "IIT"); } public void enterUniversityAddress(WebDriver driver, Properties
 * prop) throws Exception{ Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("UniversityAddress"))).
 * sendKeys("123 N CENTRAL"); } public void enterUniveristyCity(WebDriver
 * driver, Properties prop) throws Exception{ Thread.sleep(3000);
 * driver.findElement(By.xpath(prop.getProperty("UniveristyCity"))).sendKeys(
 * "Kanpur"); } public void enterUniversityState(WebDriver driver, Properties
 * prop) throws Exception{ Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("UniversityState"))).
 * sendKeys("Uttar Pradesh"); } public void enterUniversityCountry(WebDriver
 * driver, Properties prop) throws Exception{ Thread.sleep(1000); WebElement
 * element =
 * driver.findElement(By.xpath(prop.getProperty("UniversityCountry"))); Select
 * op1 = new Select(element);
 * op1.selectByValue(prop.getProperty("UniversityCountryCode")); } public void
 * enterSponsorname(WebDriver driver, Properties prop) throws Exception{
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("SponsorName"))).
 * sendKeys("Mukesh Ambani"); } public void enterSponsorAddress(WebDriver
 * driver, Properties prop) throws Exception{ Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("SponsorAddress"))).
 * sendKeys("123 N CENTRAL"); } public void enterSponsorAddressNIA(WebDriver
 * driver, Properties prop) throws Exception{ Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("SponsorAddressNIA"))).
 * sendKeys("123 N CENTRAL"); } public void enterSponsorCity(WebDriver driver,
 * Properties prop) throws Exception{ Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("SponsorCity"))).sendKeys(
 * "KANPUR"); } public void enterSponsorState(WebDriver driver, Properties prop)
 * throws Exception{ Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("SponsorState"))).
 * sendKeys("Uttar Pradesh"); } public void enterSponsorCountry(WebDriver
 * driver, Properties prop) throws Exception{ Thread.sleep(1000); WebElement
 * element = driver.findElement(By.xpath(prop.getProperty("SponsorCountry")));
 * Select op1 = new Select(element);
 * op1.selectByValue(prop.getProperty("SponsorCountryCode")); } public void
 * enterSponsorDOB(Properties prop, WebDriver driver) throws Exception {
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathSponsorDOB"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathSponsorDOBDate"))).click()
 * ; } public void enterSponsorDOBRSA(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathSponsorDOBRSA"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathSponsorDOBDateRSA"))).
 * click(); } public void enterSponsorDOBTata(Properties prop, WebDriver driver)
 * throws Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathSponsorDOBTata"))).click()
 * ; Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathSponsorDOBDateTata"))).
 * click(); } public void enterSponsorRelation(Properties prop, WebDriver
 * driver) throws Exception { Thread.sleep(1000); WebElement element =
 * driver.findElement(By.xpath(prop.getProperty("XpathSponsorRelation")));
 * Select op1 = new Select(element);
 * op1.selectByValue(prop.getProperty("SponsorRelation")); } public void
 * enterCourseName(WebDriver driver, Properties prop) throws Exception{
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("CourseName"))).sendKeys("BTech"
 * ); } public void enterCourseFee(WebDriver driver, Properties prop) throws
 * Exception{ Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("CourseFee"))).sendKeys("70000")
 * ; } public void enterCourseDuration(WebDriver driver, Properties prop) throws
 * Exception{ Thread.sleep(1000); WebElement element =
 * driver.findElement(By.xpath(prop.getProperty("XpathCourseDuration"))); Select
 * op1 = new Select(element);
 * op1.selectByValue(prop.getProperty("CourseDuration")); } public void
 * enterCourseDurationTata(WebDriver driver, Properties prop) throws Exception{
 * Thread.sleep(1000); WebElement element =
 * driver.findElement(By.xpath(prop.getProperty("XpathCourseDurationTata")));
 * Select op1 = new Select(element);
 * op1.selectByValue(prop.getProperty("CourseDuration")); }
 * 
 * public void enterStudentDetails(Properties prop, WebDriver driver, String
 * planname,String Option,String ProposerGender) throws Exception { if
 * (planname.equalsIgnoreCase("StudentCare")) { ReusableFunctions.scroll(0, 250,
 * driver); enterUniversityName(driver, prop); enterUniversityAddress(driver,
 * prop); enterSponsorname(driver, prop); enterSponsorState(driver, prop);
 * enterSponsorRelation(prop, driver); enterSponsorDOB(prop, driver);
 * enterCourseName(driver, prop); Thread.sleep(1000);
 * enterStudentProposerDetails(Option, prop, driver, ProposerGender); } else if
 * (planname.equalsIgnoreCase("StudentReliance")) { ReusableFunctions.scroll(0,
 * 250, driver); enterUniversityName(driver, prop);
 * enterUniversityAddress(driver, prop); enterUniveristyCity(driver, prop);
 * enterUniversityState(driver, prop); enterUniversityCountry(driver, prop);
 * enterSponsorname(driver, prop); enterSponsorAddress(driver, prop);
 * enterSponsorCity(driver, prop); enterSponsorState(driver, prop);
 * enterSponsorCountry(driver, prop); ReusableFunctions.scroll(0, 250, driver);
 * Thread.sleep(1000); enterCourseFee(driver, prop);
 * enterCourseDuration(driver,prop); Thread.sleep(1000);
 * enterStudentProposerDetails(Option, prop, driver, ProposerGender); } else if
 * (planname.equalsIgnoreCase("StudentRSA")) { ReusableFunctions.scroll(0, 250,
 * driver); enterUniversityName(driver, prop); enterUniversityAddress(driver,
 * prop); ReusableFunctions.scroll(0, 100, driver); enterUniveristyCity(driver,
 * prop); enterUniversityState(driver, prop); ReusableFunctions.scroll(0, 100,
 * driver); enterUniversityCountry(driver, prop); enterSponsorname(driver,
 * prop); ReusableFunctions.scroll(0, 100, driver); enterSponsorAddress(driver,
 * prop); enterSponsorCity(driver, prop); enterSponsorState(driver, prop);
 * enterSponsorCountry(driver, prop); enterSponsorDOBRSA(prop, driver);
 * enterSponsorRelation(prop, driver); enterCourseName(driver, prop);
 * enterCourseFee(driver, prop); Thread.sleep(1000);
 * enterStudentProposerDetails(Option, prop, driver, ProposerGender); }else if
 * (planname.equalsIgnoreCase("StudentBajaj")) { Thread.sleep(1000);
 * enterStudentProposerDetails(Option, prop, driver, ProposerGender); }else if
 * (planname.equalsIgnoreCase("StudentTata")) { ReusableFunctions.scroll(0, 250,
 * driver); enterUniversityName(driver, prop); enterUniversityAddress(driver,
 * prop); enterCourseName(driver, prop); enterCourseDurationTata(driver,prop);
 * enterSponsorname(driver, prop); enterSponsorRelation(prop, driver);
 * ReusableFunctions.scroll(0, 100, driver); enterSponsorDOBTata(prop, driver);
 * Thread.sleep(1000); enterStudentProposerDetails(Option, prop, driver,
 * ProposerGender); }else if (planname.equalsIgnoreCase("StudentNIA")) {
 * ReusableFunctions.scroll(0, 250, driver); enterUniversityName(driver, prop);
 * enterUniversityAddress(driver, prop); enterSponsorname(driver, prop);
 * enterSponsorAddressNIA(driver, prop); Thread.sleep(1000);
 * enterStudentProposerDetails(Option, prop, driver, ProposerGender); }
 * 
 * } public void enterStudentProposerDetails(String Option, Properties prop,
 * WebDriver driver, String Gender) throws Exception { Thread.sleep(1000); if
 * (Option.equalsIgnoreCase("Yes")) { ReusableFunctions.scroll(0, 500, driver);
 * Thread.sleep(2000); enterProposerEmail(prop, driver);
 * ReusableFunctions.scroll(0, 250, driver); selectProposerPincode(driver,
 * prop); selectProposercity(driver, prop); enterProposerAddress(prop, driver);
 * enterProposerAlternateNo(prop, driver); ReusableFunctions.scroll(0, 150,
 * driver);
 * driver.findElement(By.xpath(prop.getProperty("XpathProceed"))).click(); }
 * else if (Option.equalsIgnoreCase("No")) { ReusableFunctions.scroll(0, 500,
 * driver);
 * driver.findElement(By.xpath(prop.getProperty("XpathSameAsAbove"))).click();
 * Thread.sleep(2000); enterProposerName(prop, driver);
 * selectProposerGender(prop, driver, Gender); selectProposerDOB(prop, driver);
 * enterProposerEmail(prop, driver); ReusableFunctions.scroll(0, 250, driver);
 * selectProposerPincode(driver, prop); selectProposercity(driver, prop);
 * enterProposerAddress(prop, driver); selectProposerRelation(prop, driver);
 * ReusableFunctions.scroll(0, 50, driver); enterProposerAlternateNo(prop,
 * driver); ReusableFunctions.scroll(0, 150, driver);
 * driver.findElement(By.xpath(prop.getProperty("XpathProceed"))).click();
 * 
 * } } public void selectProposerRelation(Properties prop, WebDriver driver)
 * throws Exception { Thread.sleep(1000); WebElement element =
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerRelation")));
 * Select op1 = new Select(element);
 * op1.selectByValue(prop.getProperty("ProposerRelation")); }
 * 
 * public void enterProposerAlternateNo(Properties prop, WebDriver driver)
 * throws Exception { Thread.sleep(1000); long
 * number=ReusableFunctions.enterMobileNumber();
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerAlternateNo")))
 * .sendKeys(String.valueOf(number)); }
 * 
 * public void enterProposerName(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerName"))).sendKeys(
 * ReusableFunctions.name(5)+" "+ReusableFunctions.name(5)); }
 * 
 * public void enterProposerAddress(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerAddress"))).
 * sendKeys(ReusableFunctions.address()); }
 * 
 * public void enterProposerEmail(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(2000);
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerEmail"))).sendKeys
 * ("adityajain@policybazaar.com");
 * //driver.findElement(By.xpath(prop.getProperty("XpathProposerEmail"))).
 * sendKeys(ReusableFunctions.name(7)+"@tesla.com"); }
 * 
 * public void selectProposercity(WebDriver driver, Properties prop) {
 * WebElement element =
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerCity"))); Select
 * op1 = new Select(element); op1.selectByIndex(1); }
 * 
 * public void selectProposerGender(Properties prop, WebDriver driver, String
 * ProposerGender) { if (ProposerGender.equalsIgnoreCase("Male")) {
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerMaleGender"))).
 * click(); } else if (ProposerGender.equalsIgnoreCase("Female")) {
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerFemaleGender"))).
 * click(); }
 * 
 * }
 * 
 * public void selectProposerDOB(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerDOB"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathProperDOBDate"))).click();
 * }
 * 
 * public void selectProposerPincode(WebDriver driver, Properties prop) throws
 * Exception {
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerPincode"))).
 * sendKeys(prop.getProperty("Pincode")); Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathProposerSelectPin"))).
 * click();
 * 
 * }
 * 
 * 
 * }
 * 
 */