package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Allure;

public class ReportGenerator {
	public static LinkedHashMap<String, String> list = new LinkedHashMap<String, String>();

	public void setnorun() {
		list.put("Care", "NoRun");
		list.put("Reliance", "NoRun");
		list.put("Bajaj", "NoRun");
		list.put("TataAIG", "NoRun");
		list.put("Niva", "NoRun");
		list.put("Digit", "NoRun");
		list.put("Chola", "NoRun");
		list.put("RSA", "NoRun");
		list.put("SBI", "NoRun");
		list.put("Oriental", "NoRun");
		list.put("Chola", "NoRun");
		list.put("NIC", "NoRun");
		list.put("NIA", "NoRun");
		list.put("MultiReliance", "NoRun");
		list.put("MultiTata", "NoRun");
		list.put("MultiRSA", "NoRun");
		list.put("MultiCare", "NoRun");
		list.put("MultiOriental", "NoRun");
		list.put("StudentCare", "NoRun");
		list.put("StudentReliance", "NoRun");
		list.put("StudentBajaj", "NoRun");
		list.put("StudentTata", "NoRun");
		list.put("StudentRSA", "NoRun");
		list.put("StudentNiva", "NoRun");
//		list.put("StudentNIA", "NoRun");
	}

	public void setupresult(String planname, String message) {
		list.replace(planname, message);
	}

	public void generateReport() {
		String outputFilePath = "D:\\AdityaWorkspace\\TravelAutomation\\AutomationResult.txt";
		File file = new File(outputFilePath);

		BufferedWriter bf = null;

		try {

			// create new BufferedWriter for the output file
			bf = new BufferedWriter(new FileWriter(file));

			// iterate map entries
			for (Map.Entry<String, String> entry : list.entrySet()) {

				// put key and value separated by a colon
				bf.write(entry.getKey() + "\t" + "------" + "\t" + entry.getValue());

				// new line
				bf.newLine();
			}

			bf.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {

				// always close the writer
				bf.close();
			} catch (Exception e) {
			}
		}
	}

	public void allurereports(WebDriver driver, String comment) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		// Add comment
//        String comment = "This is a screenshot of the page after performing test steps.";
		Allure.addAttachment("Comment", comment);

		// Attach screenshot to Allure report
		Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));

	}

}
