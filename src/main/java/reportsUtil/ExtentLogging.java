package reportsUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ExtentLogging {
public void passLog(String testStep, ExtentReports report, ExtentTest logger) {
		
		logger.log(Status.PASS, testStep);
		report.flush();
	}
	
	public void infoLog(String testStep, ExtentReports report, ExtentTest logger) {
		
		logger.log(Status.INFO, testStep);
		report.flush();
	}
	
	public void failLog(String testStep, ExtentReports report, ExtentTest logger) {
		
		logger.log(Status.FAIL, testStep);
		report.flush();
	}
	
	public void failLogWithScreenshot(String testStep, ExtentReports report, ExtentTest logger, WebDriver driver) throws IOException {
		
		ScreenShotsFactory sc = new ScreenShotsFactory();
		String screenshotpath = sc.takeScreenPrintAndReturnPath(driver, testStep);
		logger.fail(testStep, MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		report.flush();
	}


}
