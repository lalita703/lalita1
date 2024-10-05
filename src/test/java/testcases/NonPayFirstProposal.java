
package testcases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;

public class NonPayFirstProposal {

	@BeforeSuite
	public void kill() throws Exception { //
		// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T"); //
//		report.setnorun();
	}

	@AfterSuite
	public void sendemail() throws Exception { // //
//  report.generateReport(); // email.sendemail(); // driver.close(); 
	}

	@DataProvider(name = "testData")
	public Object[][] getTestData() throws Exception {
		final XSSFSheet sheet = ExcelReader.readExcelFile("Proposal");
		int rowCount = sheet.getLastRowNum();
		int dataRowCount = 0;
		for (int i = 1; i <= rowCount; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("y")) {
				dataRowCount++;
			}
		}

		Object[][] testData = new Object[dataRowCount][2];
		int dataIndex = 0;
		for (int i = 1; i <= rowCount; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("y")) {
				String cell = sheet.getRow(i).getCell(1).getStringCellValue();
				testData[dataIndex][0] = cell;
				testData[dataIndex][1] = i;
				dataIndex++;
			}
		}

		return testData;
	}

	@Test(dataProvider = "testData")
	public void executeTestCase(String cell, int rowIndex) throws Exception {
		XSSFSheet sheet = ExcelReader.readExcelFile("Proposal");
		if (cell.equalsIgnoreCase("Care")) {
			Care care = new Care();
			care.beforetest();
			care.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("Reliance")) {
			Reliance reliance = new Reliance();
			reliance.beforetest();
			reliance.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("Bajaj")) {
			Bajaj bajaj = new Bajaj();
			bajaj.beforetest();
			bajaj.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("TataAIG")) {
			TataAIG tataaig = new TataAIG();
			tataaig.beforetest();
			tataaig.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("Niva")) {
			Niva niva = new Niva();
			niva.beforetest();
			niva.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("Digit")) {
			Digit digit = new Digit();
			digit.beforetest();
			digit.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("Chola")) {
			Chola chola = new Chola();
			chola.beforetest();
			chola.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("RSA")) {
			RSA rsa = new RSA();
			rsa.beforetest();
			rsa.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("NIA")) {
			NIA nia = new NIA();
			nia.beforetest();
			nia.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("Oriental")) {
			Oriental oriental = new Oriental();
			oriental.beforetest();
			oriental.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("SBI")) {
			SBI sbi = new SBI();
			sbi.beforetest();
			sbi.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("NIC")) {
			NIC nic = new NIC();
			nic.beforetest();
			nic.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("ICICI")) {
			ICICI icici = new ICICI();
			icici.beforetest();
			icici.test(rowIndex, sheet);
		}else if (cell.equalsIgnoreCase("HDFC")) {
			HDFC hdfc = new HDFC();
			hdfc.beforetest();
			hdfc.test(rowIndex, sheet);
		}else if (cell.equalsIgnoreCase("MultiTripReliance")) {
			MultiTripReliance multitripreliance = new MultiTripReliance();
			multitripreliance.beforetest();
			multitripreliance.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("MultiTripTata")) {
			MultiTripTata multitriptata = new MultiTripTata();
			multitriptata.beforetest();
			multitriptata.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("MultiTripOriental")) {
			MultiTripOriental multitriporiental = new MultiTripOriental();
			multitriporiental.beforetest();
			multitriporiental.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("MultiTripRSA")) {
			MultiTripRSA multitriprsa = new MultiTripRSA();
			multitriprsa.beforetest();
			multitriprsa.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("MultiTripCare")) {
			MultiTripCare multitripcare = new MultiTripCare();
			multitripcare.beforetest();
			multitripcare.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("StudentCare")) {
			StudentCare studentcare = new StudentCare();
			studentcare.beforetest();
			studentcare.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("StudentReliance")) {
			StudentReliance studentreliance = new StudentReliance();
			studentreliance.beforetest();
			studentreliance.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("StudentBajaj")) {
			StudentBajaj studentbajaj = new StudentBajaj();
			studentbajaj.beforetest();
			studentbajaj.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("StudentTata")) {
			StudentTata studenttata = new StudentTata();
			studenttata.beforetest();
			studenttata.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("StudentRSA")) {
			StudentRSA studentrsa = new StudentRSA();
			studentrsa.beforetest();
			studentrsa.test(rowIndex, sheet);
		} else if (cell.equalsIgnoreCase("StudentNiva")) {
			StudentNiva studentniva = new StudentNiva();
			studentniva.beforetest();
			studentniva.test(rowIndex, sheet);
		}

	}

}
