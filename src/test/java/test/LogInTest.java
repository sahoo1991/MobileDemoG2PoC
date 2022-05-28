package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import browserUtils.GetDriver;
import pages.InvaFreshLandPage;
import reportsUtil.ExtentAppiumReport;
import reportsUtil.ExtentLogging;

public class LogInTest extends BaseTest{
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		eLog = new ExtentLogging();
		report = ExtentAppiumReport.getExtentReport();
		driver = new GetDriver().getDriver();
		
	}
	
	
	@Test
	public void logInHomePageLabelTest() throws InterruptedException {
		String testCaseName = "Verify element labels on landing page";
		logger = report.createTest(testCaseName);
		eLog.infoLog(testCaseName, report, logger);

//		Verify User name Field label
		InvaFreshLandPage ilp = new InvaFreshLandPage(driver);
		boolean result = ilp.checkUserNameLable();
		Assert.assertTrue(result, "User Name label not displayed on the login page");	
		eLog.passLog("Verified User name field is present on login page", report, logger);
//		Verify password label
		boolean resultPassword = ilp.checkPasswordLable();
		Assert.assertTrue(resultPassword, "Password label not displayed on the login page");	
		eLog.passLog("Verified Password field is present on login page", report, logger);
//		verify logo
		boolean resultLogo = ilp.checkLogo();
		Assert.assertTrue(resultLogo, "Logo not displayed on the login page");	
		eLog.passLog("Verified Logo image is present on login page", report, logger);
//		verify login button
		boolean resultLogInButton = ilp.checkLogInButtonLable();
		Assert.assertTrue(resultLogInButton, "LogIn Button not displayed on the login page");	
		eLog.passLog("Verified Login button is present on login page", report, logger);
		
		
	}
	
	@Test(dataProvider = "LoginDataProvider", dataProviderClass = utility.ExcelDataProvier.class)
	public void logInTest(String uName, String pwd) throws InterruptedException, FileNotFoundException, IOException {
		
		String testCaseName = "Verify login with valid credentials";
		logger = report.createTest(testCaseName);
		eLog.infoLog(testCaseName, report, logger);

//		Enter user name and pwd
		InvaFreshLandPage ilp = new InvaFreshLandPage(driver);
		ilp.enterUserName(uName);
		eLog.passLog("Entered User Name success", report, logger);
		ilp.enterPassword(pwd);
		eLog.passLog("Entered Password success", report, logger);
		ilp.clickLogin();
		boolean result = ilp.checkHomePage();
		Assert.assertTrue(result, "Home page not displayed after login");	
		eLog.passLog("Verified home page after login", report, logger);
		
		
	}
	
	@Test(enabled = true)
	public void logInTestWithOutCredentials() throws InterruptedException {
		String testCaseName = "Verify error message displayed when username and password is blank";
		logger = report.createTest(testCaseName);
		eLog.infoLog(testCaseName, report, logger);

//		Verify User name Field
		InvaFreshLandPage ilp = new InvaFreshLandPage(driver);
		ilp.clickLogin();
		eLog.passLog("Clicked signin button with out email and password", report, logger);
		boolean result = ilp.checkUnameErrorMessage();
		Assert.assertTrue(result, "User Name error message should be displayed on the login page but did not");	
		eLog.passLog("Verified User name field error message when uname is left blank", report, logger);
//		Verify password label
		boolean resultPassword = ilp.checkPwdErrorMessage();
		Assert.assertTrue(resultPassword, "Password label error message should be displayed on the login page but did not");	
		eLog.passLog("Verified Password field error message when password is left blank", report, logger);
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		  if(result.getStatus() == ITestResult.FAILURE){
			  eLog.failLog(result.getThrowable().toString(), report, logger);
			  eLog.failLogWithScreenshot(result.getName(), report, logger, driver);
		  }
		  driver.quit();
		  eLog.infoLog("Finished execution", report, logger);
		
	}
	
	
}
