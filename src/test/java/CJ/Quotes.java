package CJ;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ReportGenerator;
import utils.ReusableFunctions;

public class Quotes {
	ReportGenerator report = new ReportGenerator();
	ReusableFunctions reusableFunctions = new ReusableFunctions();

	public void selectPlan(String planname, WebDriver driver, Properties prop) throws Exception {
		report.allurereports(driver, planname + " On Quotes Page");
		Thread.sleep(6000);
//		String XpathQuotesWait = prop.getProperty("XpathQuotesWait");
//		ReusableFunctions.waitForPageToLoad(driver,XpathQuotesWait);
		if (planname.equalsIgnoreCase("Care")) {
			String XpathNivaSkip = prop.getProperty("XpathNivaSkip");
			try {
				reusableFunctions.selectelement(driver, "124");
				Thread.sleep(1000);
				reusableFunctions.selectelementxpath(driver, XpathNivaSkip);
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("Reliance")) {
			try {
				reusableFunctions.selectelement(driver, "74");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("Bajaj")) {
			try {
				reusableFunctions.selectelement(driver, "49543");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("TataAig")) {
			try {
				reusableFunctions.selectelement(driver, "80068");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("Niva")) {
			String XpathNivaSkip = prop.getProperty("XpathNivaSkip");
			try {
				reusableFunctions.selectelement(driver, "76995");
				Thread.sleep(1000);
				reusableFunctions.selectelementxpath(driver, XpathNivaSkip);
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("Digit")) {
			try {
				reusableFunctions.selectelement(driver, "79635");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("NIA")) {
			try {
				reusableFunctions.selectelement(driver, "20328");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("Chola")) {
			try {
				reusableFunctions.selectelement(driver, "20021");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("RSA")) {
			try {
				try {
					reusableFunctions.selectelement(driver, "83");
					System.out.println(planname + "Travel Shield Selected");
					report.allurereports(driver, planname + " Plan Selected");
				} catch (Exception e) {
					reusableFunctions.selectelement(driver, "368");
					System.out.println(planname + "Leisure Trip Selected");
					report.allurereports(driver, planname + " Plan Selected");
				}
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("SBI")) {
			try {
				reusableFunctions.selectelement(driver, "351");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("Oriental")) {
			try {
				reusableFunctions.selectelement(driver, "32679");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("NIC")) {
			try {
				reusableFunctions.selectelement(driver, "77649");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("ICICI")) {
			try {
				reusableFunctions.selectelement(driver, "80673");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("HDFC")) {
			try {
				reusableFunctions.selectelement(driver, "46928");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		}
		Thread.sleep(3000);
	}

	public void selectPlanFeature(String planname, WebDriver driver, Properties prop) throws Exception {
		report.allurereports(driver, planname + " On Quotes Page");
		Thread.sleep(3000);
		String XpathFeaturePopUp = prop.getProperty("XpathFeaturePopUp");
		String XpathFeaturePopUpBuy = prop.getProperty("XpathFeaturePopUpBuy");
		if (planname.equalsIgnoreCase("TataAIG")) {
			try {
				reusableFunctions.selectelementxpath(driver, XpathFeaturePopUp);
				System.out.println(planname + " Feature Popup shown");
				report.allurereports(driver, planname + " Feature Popup shown");
				Thread.sleep(1000);
				reusableFunctions.selectelementxpath(driver, XpathFeaturePopUpBuy);
				System.out.println(planname + " Feature Popup buy now Selected");
				report.allurereports(driver, planname + " Feature Popup buy now Selected");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		}
	}

	public void selectPlanTravelPartner(String planname, WebDriver driver, Properties prop) throws Exception {
		report.allurereports(driver, planname + " On Quotes Page");
		Thread.sleep(7000);
		if (planname.equalsIgnoreCase("TravelPartnerReliance")) {
			try {
				reusableFunctions.selectelement(driver, "74904");
				// driver.findElement(By.id("74904")).click();
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("TravelPartnerAdityaBirla")) {
			Thread.sleep(1000);
			try {
				Thread.sleep(2000);
				reusableFunctions.selectelement(driver, "74906");
//				driver.findElement(By.id("74906")).click();
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("TravelPartnerTataAIG")) {
			try {
				Thread.sleep(2000);
				reusableFunctions.selectelement(driver, "74907");
//				driver.findElement(By.id("74907")).click();
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("TravelPartnerBajaj"))
			try {
				Thread.sleep(2000);
				reusableFunctions.selectelement(driver, "79233");
//				driver.findElement(By.id("79233")).click();
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}

	}

	public void selectPlanCompare(String planname, WebDriver driver, Properties prop) throws Exception {
		report.allurereports(driver, planname + " On Quotes Page");
		Thread.sleep(3000);
		String XpathCompareOne = prop.getProperty("XpathCompareOne");
		String XpathCompareTwo = prop.getProperty("XpathCompareTwo");
		String XpathCompare = prop.getProperty("XpathCompare");
		String XpathCompareBuy = prop.getProperty("XpathCompareBuy");
		if (planname.equalsIgnoreCase("TataAIG")) {
			try {
				reusableFunctions.selectelementxpath(driver, XpathCompareOne);
				System.out.println(planname + " Compare one clicked");
				report.allurereports(driver, planname + " Compare one clicked");
				Thread.sleep(1000);
				reusableFunctions.selectelementxpath(driver, XpathCompareTwo);
				System.out.println(planname + " Compare two clicked");
				report.allurereports(driver, planname + " Compare two clicked");
				Thread.sleep(1000);
				reusableFunctions.selectelementxpath(driver, XpathCompare);
				System.out.println(planname + " Compare clicked");
				report.allurereports(driver, planname + " Compare clicked");
				Thread.sleep(2000);
				System.out.println(planname + " Compare Popup shown");
				report.allurereports(driver, planname + " Compare Popup shown");
				Thread.sleep(5000);
				reusableFunctions.selectelementxpath(driver, XpathCompareBuy);
				System.out.println(planname + " Compare Buy clicked");
				report.allurereports(driver, planname + " Compare Buy clicked");
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println(planname + " Plan Disabled/Not selected");
				report.allurereports(driver, planname + " Plan Disabled/Not selected");
				Assert.fail(planname + "Plan Disabled");
			}
		}
	}

	public void selectMulti(WebDriver driver, Properties prop, String planname) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("XpathMultiSelect"))).click();
		System.out.println(planname + " Multi Trip option selected");
		report.allurereports(driver, planname + " Multi Trip option selected");
		Thread.sleep(5000);
		driver.findElement(By.id("30_days")).click();
		System.out.println(planname + " 30 days selected");
		report.allurereports(driver, planname + " 30 days selected");
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("XpathMultiApply"))).click();
		System.out.println(planname + " Multi trip applied");
		report.allurereports(driver, planname + " Multi trip applied");
		Thread.sleep(5000);
	}

	public void MultiPlan(String planname, WebDriver driver, Properties prop) throws Exception {
		Thread.sleep(5000);
		if (planname.equalsIgnoreCase("MultiReliance")) {
			try {
				reusableFunctions.selectelement(driver, "69");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + "  Plan Disabled/Not selected");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("MultiTata")) {
			try {
				reusableFunctions.selectelement(driver, "94");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + "  Plan Disabled/Not selected");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("MultiRSA")) {
			try {
				reusableFunctions.selectelement(driver, "373");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + "  Plan Disabled/Not selected");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("MultiCare")) {
			try {
				driver.findElement(By.xpath(prop.getProperty("XpathSumFilter"))).click();
				driver.findElement(By.xpath(prop.getProperty("XpathAmountSelection"))).click();
				// driver.findElement(By.xpath(prop.getProperty("XpathAccept"))).click();
				Thread.sleep(2000);
				reusableFunctions.selectelement(driver, "145");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + "  Plan Disabled/Not selected");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("MultiOriental")) {
			try {
				reusableFunctions.selectelement(driver, "20018");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + "  Plan Disabled/Not selected");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		}
	}

	public void selectMultiPlan(String planname, WebDriver driver, Properties prop) throws Exception {
		selectMulti(driver, prop, planname);
		MultiPlan(planname, driver, prop);
	}

	public void selectStudent(WebDriver driver, Properties prop, String planname) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("XpathStudentSelect"))).click();
		System.out.println(planname + " Student option selected");
		report.allurereports(driver, planname + " Student option selected");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("XpathStudentTravellerSelect"))).click();
		System.out.println(planname + " Student traveller selected");
		report.allurereports(driver, planname + " Student traveller selected");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath(prop.getProperty("XpathStudentDuration")));
		Select op1 = new Select(element);
		op1.selectByValue(prop.getProperty("StudentDuration"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("XpathStudentApply"))).click();
		System.out.println(planname + " Student option applied");
		report.allurereports(driver, planname + " Student option applied");
		Thread.sleep(5000);
	}

	public void StudentPlan(String planname, WebDriver driver, Properties prop) throws Exception {
		Thread.sleep(5000);
		if (planname.equalsIgnoreCase("StudentCare")) {
			try {
				reusableFunctions.selectelement(driver, "304");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + " Plan Disabled");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("StudentReliance")) {
			try {
				reusableFunctions.selectelement(driver, "55477");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + " Plan Disabled");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("StudentBajaj")) {
			try {
				reusableFunctions.selectelement(driver, "17");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + " Plan Disabled");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("StudentTata")) {
			try {
				reusableFunctions.selectelement(driver, "98");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + " Plan Disabled");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("StudentRSA")) {
			try {
				reusableFunctions.selectelement(driver, "368");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + " Plan Disabled");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("StudentNiva")) {
			try {
				reusableFunctions.selectelement(driver, "15747");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + " Plan Disabled");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		} else if (planname.equalsIgnoreCase("StudentNIA")) {
			try {
				driver.findElement(By.xpath(prop.getProperty("XpathStudentSumFilter"))).click();
				driver.findElement(By.xpath(prop.getProperty("XpathStudentAmountSelection"))).click();
				driver.findElement((By.xpath(prop.getProperty("XpathStudentAccept")))).click();
				reusableFunctions.selectelement(driver, "189");
				System.out.println(planname + " Selected");
				report.allurereports(driver, planname + " Plan Selected");
			} catch (Exception e) {
				report.allurereports(driver, planname + " Plan Disabled");
				System.out.println(planname + "Plan Disabled");
				Assert.fail(planname + "Plan Disabled");
			}
		}
	}

	public void selectStudentPlan(String planname, WebDriver driver, Properties prop) throws Exception {
		selectStudent(driver, prop, planname);
		StudentPlan(planname, driver, prop);
	}

	public void selectplanpayfirst(String planname, WebDriver driver, Properties prop) throws Exception {
		if (planname.contains("Multi")) {
			selectMultiPlan(planname, driver, prop);
		} else if (planname.contains("Student")) {
			selectStudentPlan(planname, driver, prop);
		} else {
			selectPlan(planname, driver, prop);
		}
	}

	public void selectplanFeature(String planname, WebDriver driver, Properties prop) throws Exception {
		Thread.sleep(1000);
		selectPlanFeature(planname, driver, prop);
	}

}
