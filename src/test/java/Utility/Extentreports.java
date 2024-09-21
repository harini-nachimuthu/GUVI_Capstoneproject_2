package Utility;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreports {
  
	public static ExtentReports getreport() {
		//Path to store report generated
		String path="C:\\Users\\harin\\eclipse-workspace\\Capstone_2\\Report_generation\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		//setting up reporter name,Document title and theme of the web browser
		reporter.config().setReportName("Spicejet Website");
		reporter.config().setDocumentTitle("Spicejet flight booking");
		reporter.config().setTheme(Theme.DARK);
		
		
		ExtentReports extents=new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Environment variable path: ", path);
		return extents;
		
	}
}
