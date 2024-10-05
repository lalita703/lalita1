package utils;

import java.io.FileInputStream;
import java.io.IOException;

//import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

//	final static String filePath = "D:\\Aditya2Workspace\\TravelAutomation\\data\\TravelAutomation.xlsx";
	final static String filePath = "./data/TravelAutomation.xlsx";

	public static void main(String args[]) throws IOException {

		readExcelFile("read");
	}

	public static XSSFSheet readExcelFile(String sheet) throws IOException {
		// Path of the excel file

		XSSFWorkbook work = null;

		try {

			FileInputStream file = new FileInputStream(filePath);
			work = new XSSFWorkbook(file);
			return work.getSheet(sheet);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (work != null) {
				work.close();

			}
		}
		return null;

	}

}