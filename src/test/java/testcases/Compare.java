package testcases;

import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CJ.CheckOut;
import CJ.NewPreQuotes;
import CJ.NewProposalStep1;
import CJ.PreQuotesStep1;
import CJ.PreQuotesStep2;
import CJ.PreQuotesStep3;
import CJ.PreQuotesStep4;
import CJ.PreQuotesStep5;
import CJ.Quotes;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReusableFunctions;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.JavascriptExecutor;

//@Listeners({AllureListener.class})
public class Compare {
	public static WebDriver driver;
	static ReusableFunctions resfun = new ReusableFunctions();
	PreQuotesStep1 pq1 = new PreQuotesStep1();
	PreQuotesStep2 pq2 = new PreQuotesStep2();
	PreQuotesStep3 pq3 = new PreQuotesStep3();
	PreQuotesStep4 pq4 = new PreQuotesStep4();
	PreQuotesStep5 pq5 = new PreQuotesStep5();
	Quotes quotes = new Quotes();
	CheckOut co = new CheckOut();
	NewProposalStep1 nps1 = new NewProposalStep1();
	NewPreQuotes npq = new NewPreQuotes();
	
	@BeforeTest
	public void beforetest() throws Exception {
		 String jenkinsUrl = System.getenv("JENKINS_URL");
	//	 AllureListener.setDriver(driver);
		if (jenkinsUrl  != null) {
			 System.out.println("Running on Jenkins");
			Properties prop = resfun.readPropertiesFile("config.properties");
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch = new ChromeOptions();
			// ch.addArguments("--remote-allow-origins=*");
			//ch.setCapability("goog:loggingPrefs", "{browser: 'ALL'}");
			ch.addArguments("--headless");
			ch.addArguments("--window-size=1920,1080");
			ch.addArguments("--start-maximized");
			driver = new ChromeDriver(ch);
			driver.get(prop.getProperty("url"));
			Thread.sleep(2000);
		} else {
			System.out.println("Running locally");
			Properties prop = resfun.readPropertiesFile("config.properties");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.get(prop.getProperty("url"));
			Thread.sleep(1000);    
		}
	}
	
	@Test
	public void test(int i, XSSFSheet sheet) throws Exception {
		Properties prop = resfun.readPropertiesFile("config.properties");
		npq.selectCountry(prop, driver, "TataAig", i, sheet);
		npq.selectTripDuration(prop, driver,"TataAig");
		npq.selectMemberAndPED(prop, driver, "TataAig", i, sheet);
		npq.setMobilePopup(prop, driver, "TataAig", i, sheet);
		quotes.selectPlanCompare("TataAig", driver, prop);
		nps1.ProposalStep(prop, driver, "TataAig", i, sheet);

	}
	
//	@AfterTest
//	public void afterTest() {
//	    // your existing code to quit/close driver
//	    AllureListener.setDriver(null);
//	}

}
