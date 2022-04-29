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
import pages.Page2;
import pages.Page3;
import reports.ExtentAppiumReport;
import reports.ExtentLogging;

public class ClickTest{
	
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
	public void clickTest() throws InterruptedException {
		
		Page1 page1_obj = new Page1(driver);
		Page2 page2_obj = new Page2(driver);
		Page3 page3_obj = new Page3(driver);
		
		page1_obj.clickOnViews();
		eLog.passLog("Clicked On Views", report, logger);
		page2_obj.clickOnAutoComplete();
		eLog.passLog("Clicked On Autocomplete", report, logger);
		page3_obj.getScrollText();
		eLog.passLog("Clicked On getScrolledText", report, logger);
		
		
	}
	
	@AfterMethod
	public void afterMethod() {
		  driver.quit();
		  eLog.infoLog("Finished execution", report, logger);
		
	}
	
	
}
