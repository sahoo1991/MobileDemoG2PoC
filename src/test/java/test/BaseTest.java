package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import reportsUtil.ExtentLogging;

public class BaseTest {
	
	public AppiumDriver<MobileElement> driver;
	public ExtentLogging eLog;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeTest
	public void beforeTest() {
		
	}
	@AfterTest
	public void afterTest() {
		
	}
	

}
