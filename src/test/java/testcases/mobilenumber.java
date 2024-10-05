/*
 * package testcases;
 * 
 * import java.util.Properties; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import CJ.PreQuotesStep1; import
 * CJ.PreQuotesStep2; import CJ.PreQuotesStep3; import CJ.PreQuotesStep4; import
 * CJ.PreQuotesStep5; import utils.ReusableFunctions;
 * 
 * public class mobilenumber {
 * 
 * public void checking(String mobile) throws Exception {
 * 
 * ReusableFunctions resfun = new ReusableFunctions(); Properties prop =
 * resfun.readPropertiesFile("config.properties"); WebDriver driver;
 * System.setProperty("webdriver.chrome.driver",
 * prop.getProperty("driverpath")); driver = new ChromeDriver();
 * driver.manage().window().maximize(); Thread.sleep(3000);
 * driver.get(prop.getProperty("url")); Thread.sleep(1000); PreQuotesStep1 pq1 =
 * new PreQuotesStep1(); PreQuotesStep2 pq2 = new PreQuotesStep2();
 * PreQuotesStep3 pq3 = new PreQuotesStep3(); PreQuotesStep4 pq4 = new
 * PreQuotesStep4(); PreQuotesStep5 pq5 = new PreQuotesStep5();
 * //pq1.setPreQuotesStep1(prop, driver, "USA", "Bajaj");
 * pq2.setPreQuotesStep2(prop, driver, "Bajaj"); pq3.setPreQuotesStep3(prop,
 * driver, "25", "Bajaj"); pq4.PEDSelectionNo(prop, driver, "Bajaj");
 * pq5.checkPrequotesStep5(prop, driver, mobile); }
 * 
 * }
 */