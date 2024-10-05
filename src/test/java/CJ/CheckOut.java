package CJ;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.ReportGenerator;
import utils.ReusableFunctions;

public class CheckOut {
	ReportGenerator report = new ReportGenerator();

	public void accept(Properties prop, WebDriver driver, String planname) throws Exception {
		report.allurereports(driver, planname + " On Checkout page");
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//label[@id='disclaimer']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		clickPayNow(prop, driver);
		finalresultlive(driver, planname);
	}

	public void NewProposalaccept(Properties prop, WebDriver driver, String planname) throws Exception {
		report.allurereports(driver, planname + " On ProposalStep3 page");
		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("qa")) {
			if (driver.getCurrentUrl().contains("payment")) {
				selectNetbanking(driver, prop);
				finalresultqa(driver, planname, prop);
			} else if (driver.getCurrentUrl().contains("checkout")) {
				System.out.println(planname + " Payment Failure");
			}
		} else {
			Thread.sleep(2000);
			finalresultlive(driver, planname);
		}
	}
	
	public void NewExpressProposalaccept(Properties prop, WebDriver driver, String planname) throws Exception {
		report.allurereports(driver, planname + " On Express payment page");
		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("qa")) {
			if (driver.getCurrentUrl().contains("payment")) {
				selectNetbanking(driver, prop);
				finalresultqa(driver, planname, prop);
			} else if (driver.getCurrentUrl().contains("checkout")) {
				System.out.println(planname + " Payment Failure");
			}
		} else {
			Thread.sleep(2000);
			finalresultlive(driver, planname);
		}
	}

	public void NewProposalacceptmulti(Properties prop, WebDriver driver, String planname) throws Exception {
		report.allurereports(driver, planname + " On ProposalStep3 page");
		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("qa")) {
			if (driver.getCurrentUrl().contains("payment")) {
				selectNetbanking(driver, prop);
				finalresultqa(driver, planname, prop);
			} else if (driver.getCurrentUrl().contains("checkout")) {
				System.out.println(planname + " Payment Failure");
			}

		} else {
			Thread.sleep(2000);
			Multifinalresultlive(driver, planname);

		}

	}

	public void NewProposalacceptstudent(Properties prop, WebDriver driver, String planname) throws Exception {
		report.allurereports(driver, planname + " On ProposalStep3 page");
		Thread.sleep(2000);
		if (driver.getCurrentUrl().contains("qa")) {
			if (driver.getCurrentUrl().contains("payment")) {
				selectNetbanking(driver, prop);
				finalresultqa(driver, planname, prop);
			} else if (driver.getCurrentUrl().contains("checkout")) {
				System.out.println(planname + " Payment Failure");
			}
		} else {
			Thread.sleep(2000);
			Studentfinalresultlive(driver, planname);
		}
	}

	public void Multiaccept(Properties prop, WebDriver driver, String planname) throws Exception {
		report.allurereports(driver, planname + " On Checkout page");
		Thread.sleep(3000);
		ReusableFunctions.scroll(0, 100, driver);
		driver.findElement(By.xpath(prop.getProperty("XpathDisclaimer"))).click();
		Thread.sleep(1000);
		clickPayNow(prop, driver);
		Multifinalresultlive(driver, planname);
	}

//	public void Studentaccept(Properties prop, WebDriver driver, String planname) throws Exception {
//		report.allurereports(driver, planname + " On Checkout page");
//		Thread.sleep(5000);
//		ReusableFunctions.scroll(0, 100, driver);
//		driver.findElement(By.xpath(prop.getProperty("XpathDisclaimer"))).click();
//		Thread.sleep(1000);
//		clickPayNow(prop, driver);
//		Studentfinalresultlive(driver, planname);
//
//	}

	public void selectNetbanking(WebDriver driver, Properties prop) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNetBanking1"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNetBanking2"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathNetBanking3"))).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath(prop.getProperty("XpathNetBanking4"))).click();
		Thread.sleep(1500);
	}

	public void finalresultlive(WebDriver driver, String planname) throws Exception {
		Thread.sleep(20000);

		if (!driver.getCurrentUrl().contains("payment")) {
			System.out.println(planname + " Payment failure");
			String checkouturl = driver.getCurrentUrl();
			if (planname.equalsIgnoreCase("Care")) {
				report.setupresult("Care", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("Digit")) {
				report.setupresult("Digit", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("Reliance")) {
				report.setupresult("Reliance", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("TataAig")) {
				report.setupresult("TataAIG", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("RSA")) {
				report.setupresult("RSA", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("NIA")) {
				report.setupresult("NIA", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("SBI")) {
				report.setupresult("SBI", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("Bajaj")) {
				report.setupresult("Bajaj", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("Niva")) {
				report.setupresult("Niva", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("Oriental")) {
				report.setupresult("Oriental", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("Chola")) {
				report.setupresult("Chola", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("NIC")) {
				report.setupresult("NIC", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			}
		} else {
			System.out.println(planname + " Payment success");
			if (planname.equalsIgnoreCase("Care")) {
				report.setupresult("Care", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("Digit")) {
				report.setupresult("Digit", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("Reliance")) {
				report.setupresult("Reliance", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("TataAig")) {
				report.setupresult("TataAIG", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("RSA")) {
				report.setupresult("RSA", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("NIA")) {
				report.setupresult("NIA", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("SBI")) {
				report.setupresult("SBI", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("Bajaj")) {
				report.setupresult("Bajaj", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("Niva")) {
				report.setupresult("Niva", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("Oriental")) {
				report.setupresult("Oriental", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("Chola")) {
				report.setupresult("Chola", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("NIC")) {
				report.setupresult("NIC", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			}
			driver.close();
		}
	}

	public void Multifinalresultlive(WebDriver driver, String planname) throws Exception {
		Thread.sleep(4000);
		if (!driver.getCurrentUrl().contains("payment")) {
			System.out.println(planname + " Payment failure");
			String checkouturl = driver.getCurrentUrl();
			if (planname.equalsIgnoreCase("MultiReliance")) {
				report.setupresult("MultiReliance", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("MultiRSA")) {
				report.setupresult("MultiRSA", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("MultiTata")) {
				report.setupresult("MultiTata", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("MultiOriental")) {
				report.setupresult("MultiOriental", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("MultiCare")) {
				report.setupresult("MultiCare", "Not gone to PG :" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			}
		} else {
			System.out.println(planname + " Payment success");
			if (planname.equalsIgnoreCase("MultiReliance")) {
				report.setupresult("MultiReliance", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("MultiRSA")) {
				report.setupresult("MultiRSA", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("MultiTata")) {
				report.setupresult("MultiTata", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("MultiCare")) {
				report.setupresult("MultiCare", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("MultiOriental")) {
				report.setupresult("MultiOriental", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			}
			driver.close();
		}
	}

	public void Studentfinalresultlive(WebDriver driver, String planname) throws Exception {
		Thread.sleep(4000);
		if (!driver.getCurrentUrl().contains("payment")) {
			System.out.println(planname + " Payment failure");
			String checkouturl = driver.getCurrentUrl();
			if (planname.equalsIgnoreCase("StudentBajaj")) {
				report.setupresult("StudentBajaj", "Not gone to PG:" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("StudentCare")) {
				report.setupresult("StudentCare", "Not gone to PG:" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("StudentReliance")) {
				report.setupresult("StudentReliance", "Not gone to PG:" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("StudentRSA")) {
				report.setupresult("StudentRSA", "Not gone to PG:" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("StudentTata")) {
				report.setupresult("StudentTata", "Not gone to PG:" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			} else if (planname.equalsIgnoreCase("StudentNIA")) {
				report.setupresult("StudentNIA", "Not gone to PG:" + checkouturl);
				report.allurereports(driver, planname + " Not gone to PG");
			}
		} else {
			System.out.println(planname + " Payment success");
			if (planname.equalsIgnoreCase("StudentBajaj")) {
				report.setupresult("StudentBajaj", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("StudentCare")) {
				report.setupresult("StudentCare", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("StudentReliance")) {
				report.setupresult("StudentReliance", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("StudentRSA")) {
				report.setupresult("StudentRSA", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("StudentTata")) {
				report.setupresult("StudentTata", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			} else if (planname.equalsIgnoreCase("StudentNIA")) {
				report.setupresult("StudentNIA", "gone to PG");
				report.allurereports(driver, planname + " Gone to PG");
			}
			driver.close();
		}
	}

	public void finalresultqa(WebDriver driver, String planname, Properties prop) throws Exception {
		Thread.sleep(4000);
		String pay = driver.findElement(By.xpath(prop.getProperty("XpathResultQA"))).getText();

		if (pay.equals("Payment Successful !") && driver.getCurrentUrl().contains("thanks")) {
			System.out.println(planname + " Booking Success");
		//	driver.close();
		} else {
			System.out.println(planname + " Booking failed");
		}
	}

	public void valueselection(Properties prop, WebDriver driver, String value, String xpath) throws Exception {

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(xpath));
		Select op1 = new Select(element);
		op1.selectByValue(value);
	}

	public void selectDisclaimer(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("XpathselectDisclaimer"))).click();
		Thread.sleep(5000);
	}

	public void clickPayNow(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPayNow"))).click();
		Thread.sleep(4000);
	}

	public void enterDebitCardDetails(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("XpathDebitCard"))).sendKeys("5123456789012346");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathDebitCardName"))).sendKeys("test");
	}

	public void selectDebitCardMonth(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String month = "//*[@id=\"debitMonth\"]";
		valueselection(prop, driver, "05", month);
	}

	public void selectDebitCardYear(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		String year = "//*[@id=\"debitYear\"]";
		valueselection(prop, driver, "2022", year);
	}

	public void enterDebitCardCVV(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathDebitCVV"))).sendKeys("123");

	}

	public void selectPayNow(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("XpathPaymentPayNow"))).click();

	}

	public void enterOTP(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("XpathOTP"))).sendKeys("123456");

	}

	public void OTPSubmit(Properties prop, WebDriver driver) throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.xpath(prop.getProperty("XpathOTPSubmit"))).click();
	}

}
