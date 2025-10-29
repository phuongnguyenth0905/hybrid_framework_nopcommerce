package reportConfig;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import freemarker.log.Logger;
import commons.GlobalConstants;

public class ExtentManager {
    // single ExtentReports instance
    private static ExtentReports extent;
    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();

    // tạo (hoặc trả về) instance ExtentReports
    public synchronized static ExtentReports createInstance() {
        if (extent == null) {
            String reportPath = GlobalConstants.ROOT_FOLDER + "/test-output/ExtentReportV5/Report.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation HTML Report");
            spark.config().setReportName("Automation Test Report");
            spark.config().setTimelineEnabled(true);
            spark.config().setEncoding("utf-8");
            spark.config().setTheme(Theme.STANDARD);
            extent = new ExtentReports();
            
            extent.attachReporter(spark);
            extent.setSystemInfo("Company", "Automation FC");
            extent.setSystemInfo("Project", "Test ExtentReports");
            extent.setSystemInfo("Team", "Test Automation VN");
            extent.setSystemInfo("OS", GlobalConstants.OS_NAME);
            extent.setSystemInfo("JDK", GlobalConstants.JAVA_VERSION);
        }
        return extent;
    }

    // getter để listener gọi flush()
    public synchronized static ExtentReports getExtent() {
    	 if (extent == null) {

             // ⚙️ TẮT TOÀN BỘ FREEMARKER DEBUG
             try {
                 Logger.selectLoggerLibrary(Logger.LIBRARY_NONE);
             } catch (Exception e) {
                 System.err.println("Freemarker logger suppression failed: " + e.getMessage());
             }

             ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent/index.html");
             spark.config().setReportName("Automation Report");
             spark.config().setDocumentTitle("Test Report");
             extent = new ExtentReports();
             extent.attachReporter(spark);
         }
         return extent;
     }
    

    // start test cho thread hiện tại
    public synchronized static ExtentTest startTest(String testName, String desc) {
        ExtentTest test = createInstance().createTest(testName, desc);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }

    // lấy test object của thread hiện tại
    public synchronized static ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }
}
