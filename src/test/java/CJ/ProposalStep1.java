/*
 * package CJ;
 * 
 * import java.util.Properties;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * utils.ReportGenerator; import utils.ReusableFunctions;
 * 
 * public class ProposalStep1 { ReportGenerator report = new ReportGenerator();
 * PreQuotesStep5 pq5 = new PreQuotesStep5();
 * 
 * 
 * public void setProposal(Properties prop, WebDriver driver, String planname)
 * throws Exception { Thread.sleep(5000); report.allurereports(driver,
 * "On ProposalStep1"); // setoldProposalStep1(prop, driver, planname);
 * setnewProposalStep1(prop, driver, planname);
 * 
 * 
 * if (driver.getCurrentUrl().contains("step1")) { Thread.sleep(5000);
 * setnewProposalStep1(prop, driver, planname);
 * 
 * } else { Thread.sleep(5000); nps.ProposalStep(prop, driver, gender,
 * planname); }
 * 
 * 
 * }
 * 
 * public void setoldProposalStep1(Properties prop, WebDriver driver, String
 * planname) throws Exception { report.allurereports(driver,
 * "On Proposal Step1"); selectDOB(prop, driver); report.allurereports(driver,
 * "DOB Selected"); submit(prop, driver); report.allurereports(driver,
 * "Submit clicked on Proposal Step 1"); }
 * 
 * public void selectDOB(Properties prop, WebDriver driver) throws Exception {
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathDOB"))).click();
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathDate"))).click(); }
 * 
 * public void submit(Properties prop, WebDriver driver) throws Exception {
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathSubmit"))).click(); }
 * 
 * public void setStudentProposalStep1(Properties prop, WebDriver driver, String
 * planname) throws Exception { selectDOB(prop, driver); submit(prop, driver);
 * 
 * }
 * 
 * public void setnewProposalStep1(Properties prop, WebDriver driver, String
 * planname) throws Exception { if (planname.equalsIgnoreCase("Bajaj") ||
 * planname.equalsIgnoreCase("StudentBajaj")) { Thread.sleep(1000);
 * enterDOB(prop, driver); System.out.println(planname + " DOB Entered");
 * report.allurereports(driver,planname+ " DOB Entered"); ReusableFunctions.scroll(0, 300,
 * driver); Thread.sleep(1000); clickcontinue(prop, driver);
 * System.out.println(planname + " PS1 Continue clicked");
 * report.allurereports(driver,planname+ " PS1 Continue clicked"); } else if
 * (planname.equalsIgnoreCase("Care") ||
 * planname.equalsIgnoreCase("StudentCare") ||
 * planname.equalsIgnoreCase("MultiCare")) { Thread.sleep(1000); enterDOB(prop,
 * driver); System.out.println(planname + " DOB Entered");
 * report.allurereports(driver,planname+ " DOB Entered"); ReusableFunctions.scroll(0, 300,
 * driver); Thread.sleep(1000); clickcontinue(prop, driver);
 * System.out.println(planname + " PS1 Continue clicked");
 * report.allurereports(driver,planname+ " PS1 Continue clicked"); } else if
 * (planname.equalsIgnoreCase("Reliance") ||
 * planname.equalsIgnoreCase("StudentReliance") ||
 * planname.equalsIgnoreCase("MultiReliance")) { Thread.sleep(1000);
 * enterDOB(prop, driver); System.out.println(planname + " DOB Entered");
 * report.allurereports(driver,planname+ " DOB Entered"); ReusableFunctions.scroll(0, 300,
 * driver); Thread.sleep(1000); clickcontinue(prop, driver);
 * System.out.println(planname + " PS1 Continue clicked");
 * report.allurereports(driver,planname+ " PS1 Continue clicked"); } else if
 * (planname.equalsIgnoreCase("Digit")) { Thread.sleep(1000); //
 * ContinuetoTravellers(prop, driver); enterDOB(prop, driver);
 * System.out.println(planname + " DOB Entered"); report.allurereports(driver,
 * "DOB Entered"); ReusableFunctions.scroll(0, 300, driver); Thread.sleep(1000);
 * clickcontinue(prop, driver); System.out.println(planname +
 * " PS1 Continue clicked"); report.allurereports(driver,
 * "PS1 Continue clicked"); } else if (planname.equalsIgnoreCase("TataAIG") ||
 * planname.equalsIgnoreCase("StudentTata") ||
 * planname.equalsIgnoreCase("MultiTata")) { Thread.sleep(1000); //
 * ContinuetoTravellers(prop, driver); //
 * System.out.println(planname+" Continue to Travellers clicked"); //
 * report.allurereports(driver,planname+ " Continue to Travellers clicked");
 * Thread.sleep(1000); enterDOB(prop, driver); System.out.println(planname +
 * " DOB Entered"); report.allurereports(driver,planname+ " DOB Entered");
 * ReusableFunctions.scroll(0, 300, driver); Thread.sleep(1000);
 * clickcontinue(prop, driver); System.out.println(planname +
 * " PS1 Continue clicked"); report.allurereports(driver,
 * "PS1 Continue clicked"); } else if (planname.equalsIgnoreCase("RSA") ||
 * planname.equalsIgnoreCase("StudentRSA") ||
 * planname.equalsIgnoreCase("MultiRSA")) { Thread.sleep(1000); //
 * ContinuetoTravellers(prop, driver); enterDOB(prop, driver);
 * System.out.println(planname + " DOB Entered"); report.allurereports(driver,
 * "DOB Entered"); ReusableFunctions.scroll(0, 300, driver); Thread.sleep(1000);
 * clickcontinue(prop, driver); System.out.println(planname +
 * " PS1 Continue clicked"); report.allurereports(driver,
 * "PS1 Continue clicked"); } else if (planname.equalsIgnoreCase("NIA") ||
 * planname.equalsIgnoreCase("StudentNIA")) { Thread.sleep(1000); //
 * ContinuetoTravellers(prop, driver); enterDOB(prop, driver);
 * System.out.println(planname + " DOB Entered"); report.allurereports(driver,
 * "DOB Entered"); ReusableFunctions.scroll(0, 300, driver); Thread.sleep(1000);
 * clickcontinue(prop, driver); System.out.println(planname +
 * " PS1 Continue clicked"); report.allurereports(driver,
 * "PS1 Continue clicked"); } else if (planname.equalsIgnoreCase("SBI")) {
 * Thread.sleep(1000); // ContinuetoTravellers(prop, driver); enterDOB(prop,
 * driver); System.out.println(planname + " DOB Entered");
 * report.allurereports(driver,planname+ " DOB Entered"); ReusableFunctions.scroll(0, 300,
 * driver); Thread.sleep(1000); clickcontinue(prop, driver);
 * System.out.println(planname + " PS1 Continue clicked");
 * report.allurereports(driver,planname+ " PS1 Continue clicked"); } else if
 * (planname.equalsIgnoreCase("Niva")) { Thread.sleep(1000); enterDOB(prop,
 * driver); System.out.println(planname + " DOB Entered");
 * report.allurereports(driver,planname+ " DOB Entered"); ReusableFunctions.scroll(0, 300,
 * driver); Thread.sleep(1000); // try { // pq5.enterMobileNumber(prop, driver);
 * // System.out.println(planname+" Mobile Number Entered"); //
 * report.allurereports(driver,planname+ " Mobile Number Entered"); // } catch (Exception
 * e) { // System.out.println("Not skipMobile"); // } clickcontinue(prop,
 * driver); System.out.println(planname + " PS1 Continue clicked");
 * report.allurereports(driver,planname+ " PS1 Continue clicked"); } else if
 * (planname.equalsIgnoreCase("Oriental") ||
 * planname.equalsIgnoreCase("MultiOriental")) { Thread.sleep(1000);
 * enterDOB(prop, driver); System.out.println(planname + " DOB Entered");
 * report.allurereports(driver,planname+ " DOB Entered"); ReusableFunctions.scroll(0, 300,
 * driver); Thread.sleep(1000); clickcontinue(prop, driver);
 * System.out.println(planname + " PS1 Continue clicked");
 * report.allurereports(driver,planname+ " PS1 Continue clicked"); }
 * 
 * }
 * 
 * 
 * public void ContinuetoTravellers(Properties prop, WebDriver driver) throws
 * Exception { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathContinuetoTravellers"))).
 * click(); }
 * 
 * 
 * public void enterDOB(Properties prop, WebDriver driver) throws Exception {
 * Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathEnterDOB"))).sendKeys(
 * "26011997"); }
 * 
 * public void clickcontinue(Properties prop, WebDriver driver) throws Exception
 * { Thread.sleep(1000);
 * driver.findElement(By.xpath(prop.getProperty("XpathContinue"))).click(); }
 * 
 * }
 */