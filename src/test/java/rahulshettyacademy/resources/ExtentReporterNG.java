package rahulshettyacademy.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "/reports/index.html";
            File reportFile = new File(path);
            reportFile.getParentFile().mkdirs(); // Ensure /reports folder is created

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportFile);
            reporter.config().setReportName("Web Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Rahul Shetty");
        }
        return extent;
    }
}
