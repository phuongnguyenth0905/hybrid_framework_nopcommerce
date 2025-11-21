package reportConfig;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtentTestListenerV5 implements ITestListener {

	 private static final Logger log = LogManager.getLogger(AllureTestListener.class);

	    // Screenshot for Allure
	    @Attachment(value = "Screenshot of {0}", type = "image/png")
	    public static byte[] saveScreenshotPNG(String testName, WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }

	    // Text log for Allure
	    @Attachment(value = "Log", type = "text/plain")
	    public static String saveTextLog(String message) {
	        return message;
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        Throwable error = result.getThrowable();
	        String testName = result.getMethod().getMethodName();

	        // Lấy dòng lỗi ngắn gọn
	        String shortMessage = "Unknown error";
	        if (error != null && error.getMessage() != null) {
	            shortMessage = error.getMessage().split("\\n")[0];
	            if (shortMessage.length() > 120) {
	                shortMessage = shortMessage.substring(0, 120) + "...";
	            }
	        }

	        // Log gọn gàng ra console
	        log.error("❌ FAILED: {}", testName);
	        log.error("➡ Reason: {}", shortMessage);

	        // Gửi lỗi vào Allure Report (nếu bạn bật Allure)
	        saveTextLog("FAILED: " + testName + " | Reason: " + shortMessage);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        log.info("✅ PASSED: {}", result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        log.warn("⚠️ SKIPPED: {}", result.getMethod().getMethodName());
	    }
	}