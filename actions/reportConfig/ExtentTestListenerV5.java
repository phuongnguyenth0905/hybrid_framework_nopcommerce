package reportConfig;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import commons.BaseTest;

public class ExtentTestListenerV5 implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Tạo instance report trước khi chạy suite
        ExtentManager.createInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        // flush cuối suite
        ExtentManager.getExtent().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Tạo test entry lúc bắt đầu test method
        String testName = result.getMethod().getMethodName();
        String desc = "Executing: " + result.getMethod().getDescription() != null
                ? result.getMethod().getDescription()
                : testName;
        ExtentManager.startTest(testName, desc);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS,
                MarkupHelper.createLabel(result.getName() + " - PASSED", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        // screenshot base64
        try {
            String base64Screenshot = "data:image/png;base64," +
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

            ExtentManager.getTest().log(Status.FAIL, result.getThrowable());
            ExtentManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Failed Screenshot");
            ExtentManager.getTest().log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + " - FAILED", ExtentColor.RED));
        } catch (Exception e) {
            // nếu chụp bị lỗi vẫn log exception
            ExtentManager.getTest().log(Status.FAIL, "Exception while taking screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP,
                MarkupHelper.createLabel(result.getName() + " - SKIPPED", ExtentColor.ORANGE));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentManager.getTest().log(Status.FAIL,
                MarkupHelper.createLabel(result.getName() + " - Failed with Percentage", ExtentColor.RED));
    }
}
