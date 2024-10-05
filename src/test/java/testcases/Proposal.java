
package testcases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.ExcelReader;

public class Proposal {

	@BeforeSuite
	public void kill() throws Exception { //
		// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T"); //
//		report.setnorun();
	}

	@AfterSuite
	public void sendemail() throws Exception { // //
//  report.generateReport(); // email.sendemail(); // driver.close(); 
	}

	@Test
	public void proposal() throws Exception {
		final XSSFSheet sheet = ExcelReader.readExcelFile("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for (int i = 1; i <= rowCount; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("y")) {
				String cell = sheet.getRow(i).getCell(1).getStringCellValue();
				if (cell.equalsIgnoreCase("Care")) {
					try {
						Care care = new Care();
						care.beforetest();
						care.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("Reliance")) {
					try {
						Reliance reliance = new Reliance();
						reliance.beforetest();
						reliance.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("Bajaj")) {

					try {
						Bajaj bajaj = new Bajaj();
						bajaj.beforetest();
						bajaj.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}

				} else if (cell.equalsIgnoreCase("TataAIG")) {
					try {
						TataAIG tataaig = new TataAIG();
						tataaig.beforetest();
						tataaig.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("Niva")) {
					try {
						Niva niva = new Niva();
						niva.beforetest();
						niva.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("Digit")) {
					try {
						Digit digit = new Digit();
						digit.beforetest();
						digit.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("Chola")) {
					try {
						Chola chola = new Chola();
						chola.beforetest();
						chola.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("RSA")) {
					try {
						RSA rsa = new RSA();
						rsa.beforetest();
						rsa.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("NIA")) {
					try {
						NIA nia = new NIA();
						nia.beforetest();
						nia.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("Oriental")) {
					try {
						Oriental oriental = new Oriental();
						oriental.beforetest();
						oriental.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("SBI")) {
					try {
						SBI sbi = new SBI();
						sbi.beforetest();
						sbi.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("MultiTripReliance")) {
					try {
						MultiTripReliance multitripreliance = new MultiTripReliance();
						multitripreliance.beforetest();
						multitripreliance.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("MultiTripTata")) {
					try {
						MultiTripTata multitriptata = new MultiTripTata();
						multitriptata.beforetest();
						multitriptata.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("MultiTripOriental")) {
					try {
						MultiTripOriental multitriporiental = new MultiTripOriental();
						multitriporiental.beforetest();
						multitriporiental.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("MultiTripRSA")) {
					try {
						MultiTripRSA multitriprsa = new MultiTripRSA();
						multitriprsa.beforetest();
						multitriprsa.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("MultiTripCare")) {
					try {
						MultiTripCare multitripcare = new MultiTripCare();
						multitripcare.beforetest();
						multitripcare.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("StudentCare")) {
					try {
						StudentCare studentcare = new StudentCare();
						studentcare.beforetest();
						studentcare.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("StudentReliance")) {
					try {
						StudentReliance studentreliance = new StudentReliance();
						studentreliance.beforetest();
						studentreliance.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("StudentBajaj")) {
					try {
						StudentBajaj studentbajaj = new StudentBajaj();
						studentbajaj.beforetest();
						studentbajaj.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("StudentTata")) {
					try {
						StudentTata studenttata = new StudentTata();
						studenttata.beforetest();
						studenttata.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred  : " + e.getMessage());
					}
				} else if (cell.equalsIgnoreCase("StudentRSA")) {
					try {
						StudentRSA studentrsa = new StudentRSA();
						studentrsa.beforetest();
						studentrsa.test(i, sheet);
					} catch (Exception e) {
						System.out.println("An exception occurred: " + e.getMessage());
					}
				}

			} else {
			}
		}
	} // Add other else-if conditions for the remaining cells }

}
