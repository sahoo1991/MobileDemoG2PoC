package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackLandingPage {

	private AppiumDriver<MobileElement> driver;

	private By logInViaEmailButton = By.xpath("//android.widget.TextView[@text=\"Login via Email\"]");


	public TrackLandingPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public boolean checkLandingPage() {
		return driver.findElement(logInViaEmailButton).isDisplayed();
	}


	public void clickLogin() {
		driver.findElement(logInViaEmailButton).click();

	}

}
