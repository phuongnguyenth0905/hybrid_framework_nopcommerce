package reportConfig;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.chaintest.service.ChainPluginService;

import commons.BaseTest;

public class ChainTestReport extends ChainTestListener {

    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        try {
            Map<String, String> sysInfo = new HashMap<>();
            sysInfo.put("Project Name", "Orange HRM");
            sysInfo.put("Execution Environment", "Local");
            sysInfo.put("Test Environment", "QA");
            sysInfo.put("Browser Name", "Chrome");
            ChainPluginService.getInstance().addSystemInfo(sysInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestStart(ITestResult result) {
        try {
            super.onTestStart(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult result) {
        try {
            super.onTestSuccess(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        try {
            WebDriver driver = null;
            Object currentClass = result.getInstance();
            try {
                Object testClass = result.getInstance();
                driver = ((BaseTest) testClass).getDriver();
            } catch (Exception e) {
            }
            if (driver != null) {
                byte[] imageBytes = null;
                TakesScreenshot ts = (TakesScreenshot) driver;
                imageBytes = ts.getScreenshotAs(OutputType.BYTES);
                ChainTestListener.embed(imageBytes, "image/png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        try {
            super.onTestSkipped(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext testContext) {
        try {
            super.onFinish(testContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onExecutionFinish() {
        try {
            super.onExecutionFinish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
