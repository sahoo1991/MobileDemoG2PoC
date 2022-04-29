package test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import browserUtils.GetDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.Page1;
import reports.ExtentAppiumReport;
import reports.ExtentLogging;
import utility.Elements_util;
import utility.Scrolling;

public class ScrollTest {
	
	public AppiumDriver<MobileElement> driver;
	public ExtentLogging eLog;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		eLog = new ExtentLogging();
		report = ExtentAppiumReport.getExtentReport();
		String testCaseName = this.getClass().getName();
		driver = new GetDriver().getDriver("Android");
		logger = report.createTest(testCaseName);
		eLog.infoLog(testCaseName, report, logger);
		
	}
	
	@Test
	public void scrollTest() throws InterruptedException {
		Page1 page1_obj = new Page1(driver);
		page1_obj.clickOnViews();
		Scrolling scroll = new Scrolling();
		Elements_util el = new Elements_util(driver);
		while (el.get_elements(driver).size() == 0) {
			
			scroll.scroll_down(driver);
			
		}
		eLog.passLog("Scrolled successful", report, logger);
		
		System.out.println("scrolling completed and element found");
	}
	@AfterMethod
	public void afterMethod() {
		  driver.quit();
		  eLog.infoLog("Finished execution", report, logger);
		
	}
	
}
