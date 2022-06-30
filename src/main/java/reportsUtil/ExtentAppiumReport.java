package reportsUtil;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentAppiumReport {

	private static ExtentReports report;

	private ExtentAppiumReport() {

	}


	public static ExtentReports getExtentReport() {

		synchronized (ExtentAppiumReport.class) {
			if (report == null) {

				ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
				String configPath = System.getProperty("user.dir");
				try {
					spark.loadXMLConfig(new File(configPath+"/report-config.xml"));
				}catch(IOException e) {
					e.printStackTrace();
				}

				report = new ExtentReports();
				report.attachReporter(spark);
				report.attachReporter(spark);
				report.setSystemInfo("OS", System.getProperty("os.name"));
				report.setSystemInfo("Laptop Model", "HP Probook Core i5 8th Gen");
				report.setSystemInfo("HostName", "sahoo Testing Academy");
				report.setSystemInfo("User Name", "Sangrambadi");
				report.setSystemInfo("Browser Type", "Appium Automation");

			}
			return report;
		}


	}

}
