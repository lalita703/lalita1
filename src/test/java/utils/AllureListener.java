package utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureListener extends TestListenerAdapter {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] saveScreenshot(WebDriver driver) {
       // WebDriver driver = getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Step("{0}")
    public static void allureLogStep(String stepDescription) {
        // This step is used to add a description to the Allure report
    }

    @Step("{0}")
    public static void allureLogStepWithScreenshot(WebDriver driver,String stepDescription) {
        saveScreenshot(driver);
        allureLogStep(stepDescription);
    }

    public static void logStep(String stepDescription) {
        allureLogStep(stepDescription);
    }

    public static void logStepWithScreenshot(WebDriver driver,String stepDescription) {
        saveScreenshot(driver);
        allureLogStep(stepDescription);
    }

    public void onTestFailure(WebDriver driver,ITestResult iTestResult) {
        saveScreenshot(driver);
        saveTextLog("Test failed: " + iTestResult.getMethod().getMethodName());
    }
}
