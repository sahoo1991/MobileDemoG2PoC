package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class InvaFreshLandPage{
	
	private AppiumDriver<MobileElement> driver;

	private By userNamelabel = By.xpath("//android.view.ViewGroup//android.widget.TextView[contains(@text, 'User Name')]/following-sibling::android.widget.EditText");
	private By pwdNameLabel = By.xpath("//android.widget.TextView[contains(@text, 'Password')]/..//android.view.ViewGroup//android.widget.EditText");
	private By landPageLogo = By.xpath("//android.view.ViewGroup/android.widget.ImageView[2]");
	private By logInButton = By.xpath("//android.widget.TextView[contains(@text, 'Sign In')]");
	private By homePage = By.xpath("//android.widget.TextView[contains(@text,'Abbotsville')]");
	private By userNameRequired = By.xpath("//android.widget.TextView[contains(@text, 'User Name is a required field')]");
	private By passwordRequired = By.xpath("//android.widget.TextView[contains(@text, 'Password is a required field')]");
	
	
	public InvaFreshLandPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public boolean checkLogo() {
		return driver.findElement(landPageLogo).isDisplayed();
	}
	
	public boolean checkUserNameLable() {
		return driver.findElement(userNamelabel).isDisplayed();
	}

	public boolean checkPasswordLable() {
		return driver.findElement(pwdNameLabel).isDisplayed();
	}
	public boolean checkLogInButtonLable() {
		return driver.findElement(logInButton).isDisplayed();
	}
	public boolean checkUnameErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		MobileElement uElem = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(userNameRequired));
		return uElem.isDisplayed();
	}
	public boolean checkPwdErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		MobileElement pElem = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequired));
		return pElem.isDisplayed();
	}
	public boolean checkHomePage() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		MobileElement homeElem = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
		return homeElem.isDisplayed();
	}
	public void enterUserName(String uName) {
		driver.hideKeyboard();
		driver.findElement(userNamelabel).sendKeys(uName);
		
	}
	public void enterPassword(String pwd) {
		driver.findElement(pwdNameLabel).sendKeys(pwd);
		
	}
	public void clickLogin() {
		driver.findElement(logInButton).click();
		
	}

}
