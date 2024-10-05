package testcases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelReader;

public class TravelPartnerProposal
{
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
		final XSSFSheet sheet = ExcelReader.readExcelFile("TravelPartner");
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
		XSSFSheet sheet = ExcelReader.readExcelFile("TravelPartner");
		if (cell.equalsIgnoreCase("Reliance")) {
			TravelPartnerReliance tpreliance = new TravelPartnerReliance();
			tpreliance.beforetest();
			tpreliance.test(rowIndex, sheet);
		}
		else if (cell.equalsIgnoreCase("AdityaBirla")) {
			TravelPartnerAdityaBirla tpadityabirla = new TravelPartnerAdityaBirla();
			tpadityabirla.beforetest();
			tpadityabirla.test(rowIndex, sheet);
		} 
		else if (cell.equalsIgnoreCase("TataAIG")) {
			TravelPartnerTataAIG tptataaig = new TravelPartnerTataAIG();
			tptataaig.beforetest();
			tptataaig.test(rowIndex, sheet);
		} 
		else if (cell.equalsIgnoreCase("Bajaj")) {
			TravelPartnerBajaj tpbajajallianz = new TravelPartnerBajaj();
			tpbajajallianz.beforetest();
			tpbajajallianz.test(rowIndex, sheet);
			
			
		} 

	}

}