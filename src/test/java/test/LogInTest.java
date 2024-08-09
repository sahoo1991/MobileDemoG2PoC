package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import data.FoodDataDetails;
import data.EnergyTracker;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browserUtils.GetDriver;
import pages.*;
import reportsUtil.ExtentAppiumReport;
import reportsUtil.ExtentLogging;

public class LogInTest extends BaseTest{

	TrackLandingPage trackLandingPage;
	LogInScreen logInScreen;
	HomePage homePage;
	LogFood logFood;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		eLog = new ExtentLogging();
		report = ExtentAppiumReport.getExtentReport();
		driver = new GetDriver().getDriver();
		trackLandingPage = new TrackLandingPage(driver);
		logInScreen = new LogInScreen(driver);
		homePage = new HomePage(driver);
		logFood = new LogFood(driver);

	}


	@Test(dataProvider = "LoginDataProvider", dataProviderClass = utility.ExcelDataProvier.class)
	public void logFoodE2E(String uName, String pwd) throws InterruptedException, FileNotFoundException, IOException {

		String testCaseName = "Verify Food item is Logged e2e";
		logger = report.createTest(testCaseName);
		eLog.infoLog(testCaseName, report, logger);
		// Verify landing page
		Assert.assertTrue(trackLandingPage.checkLandingPage(), "Landing page not displayed");
		trackLandingPage.clickLogin();
//		Enter user name and pwd
		logInScreen.enterUserName(uName);
		eLog.passLog("Entered User Name success", report, logger);
		logInScreen.enterPassword(pwd);
		eLog.passLog("Entered Password success", report, logger);
		logInScreen.clickLogin();
		Assert.assertTrue(homePage.checkHomeScreen(), "Home page not displayed after login");
		eLog.passLog("Verified home page after login", report, logger);
		Assert.assertTrue(homePage.checkSmartSearchPopup(), "Smart search pop up not displayed on home screen");
		eLog.passLog("Verified smart search pop up on home screen", report, logger);
		homePage.clickFinishButton();
		eLog.passLog("clicked finish button", report, logger);
		EnergyTracker initialEnergyTracker = homePage.storeEnergyTracker();
		eLog.passLog("Stored initial tracker result", report, logger);
		homePage.searchFood("meat");
		eLog.passLog("Searched the food - meat", report, logger);
		homePage.clickFirstSearchResult();
		eLog.passLog("clicked first result", report, logger);
		logFood.checkEditQuantityPopUp();
		eLog.passLog("Verified Edit quantity pop up", report, logger);
		logFood.clickFinishButton();
		eLog.passLog("clicked finish button", report, logger);
		FoodDataDetails foodDataDetails = logFood.storeFoodDetails();
		eLog.passLog("Stored the product details", report, logger);
		logFood.clickLogFood();
		eLog.passLog("clicked Log food button", report, logger);
		homePage.clickFinishButton();
		eLog.passLog("clicked finish button", report, logger);
		EnergyTracker finalEnergyTracker = homePage.storeEnergyTracker();
		eLog.passLog("Stored updated energy tracker", report, logger);
		homePage.verifyEnergyTrackerUpdated(initialEnergyTracker, finalEnergyTracker, foodDataDetails);
		eLog.passLog("Verified energy tracker updated successfully", report, logger);
		homePage.verifyItemDetailsInTracker(foodDataDetails);
		eLog.passLog("Verified product logged successfully", report, logger);
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
