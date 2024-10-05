/*
 * package testcases;
 * 
 * import java.io.File; import java.io.FileInputStream; import
 * java.io.IOException; import java.text.DecimalFormat;
 * 
 * import org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class ads { public static void main(String[] args) { // Provide the
 * path of the Excel file // mobilenumber nm= new mobilenumber(); DecimalFormat
 * decimalformat = new DecimalFormat("0"); File file = new
 * File("D:\\AdityaWorkspace\\TravelAutomation - Copy\\mobile.xlsx"); try { //
 * Create an object of FileInputStream class to read the Excel file
 * FileInputStream inputStream = new FileInputStream(file);
 * 
 * // Create an object of XSSFWorkbook class to handle the workbook XSSFWorkbook
 * workbook = new XSSFWorkbook(inputStream);
 * 
 * // Get the sheet index or sheet name XSSFSheet sheet =
 * workbook.getSheetAt(0); // Index starts from 0
 * 
 * // Loop through the rows of the sheet for (int i = 1; i <=
 * sheet.getLastRowNum(); i++) { XSSFRow row = sheet.getRow(i);
 * 
 * // Get the cell values from the row String username =
 * row.getCell(0).getStringCellValue(); // String
 * password=row.getCell(1).getStringCellValue(); String password =
 * String.valueOf( decimalformat.format(row.getCell(1).getNumericCellValue()));
 * // String password = new Integer().toString();
 * 
 * 
 * // Print the cell values
 * 
 * if(username.equalsIgnoreCase("y")) { try { // nm.checking(password); } catch
 * (Exception e) { System.out.println(password); } }
 * 
 * }
 * 
 * // Close the workbook and input stream workbook.close(); inputStream.close();
 * } catch (IOException e) { e.printStackTrace(); } } }
 */