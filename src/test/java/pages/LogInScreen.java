package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInScreen {

	private AppiumDriver<MobileElement> driver;

	private By logInButton = By.xpath("//android.widget.TextView[@text=\"Login\"]");
	private By emailField = By.xpath("//android.widget.EditText[@text=\"Email\"]");
	private By passWordField = By.xpath("//android.widget.EditText[@text=\"Password\"]");


	public LogInScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public boolean checkLogInScreenDisplayed() {
		return driver.findElement(logInButton).isDisplayed();
	}


	public void enterUserName(String uName) {
		driver.hideKeyboard();
		driver.findElement(emailField).sendKeys(uName);

	}
	public void enterPassword(String pwd) {
		driver.findElement(passWordField).sendKeys(pwd);

	}
	public void clickLogin() {
		driver.findElement(logInButton).click();

	}

}
