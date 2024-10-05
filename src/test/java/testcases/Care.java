package testcases;

import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import CJ.CheckOut;
import CJ.Email;
import CJ.NewPreQuotes;
import CJ.NewProposalStep1;
import CJ.Quotes;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReportGenerator;
import utils.ReusableFunctions;

public class Care {
	public static WebDriver driver;
	static ReusableFunctions resfun = new ReusableFunctions();
	Quotes quotes = new Quotes();
	CheckOut co = new CheckOut();
	Email email = new Email();
	ReportGenerator report = new ReportGenerator();
	NewProposalStep1 nps1 = new NewProposalStep1();
	NewPreQuotes npq = new NewPreQuotes();

	@BeforeSuite
	public void kill() throws Exception {
//		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		report.setnorun();
	}

	@AfterSuite
	public void sendemail() throws Exception { //
		report.generateReport();
		// email.sendemail();
		// driver.close();
	}

	@BeforeTest
	public void beforetest() throws Exception {
		String jenkinsUrl = System.getenv("JENKINS_URL");
		if (jenkinsUrl != null) {
			System.out.println("Running on Jenkins");
			Properties prop = resfun.readPropertiesFile("config.properties");
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch = new ChromeOptions();
			// ch.addArguments("--remote-allow-origins=*");
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

//	@BeforeTest
//	public void beforetest() throws Exception {
//		Properties prop = resfun.readPropertiesFile("config.properties");
////		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverpath"));
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		Thread.sleep(3000);
//		driver.get(prop.getProperty("url"));
//		Thread.sleep(1000);
//	}

	@Test
	public void test(int i, XSSFSheet sheet) throws Exception {
		Properties prop = resfun.readPropertiesFile("config.properties");
		npq.selectCountry(prop, driver, "Care", i, sheet);
		npq.selectTripDuration(prop, driver, "Care");
		npq.selectMemberAndPED(prop, driver, "Care", i, sheet);
		npq.setMobilePopup(prop, driver, "Care", i, sheet);
		quotes.selectPlan("Care", driver, prop);
		Thread.sleep(1000);
		nps1.ProposalStep(prop, driver, "Care", i, sheet);

	}

}
