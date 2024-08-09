package pages;

import browserUtils.GetDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public AppiumDriver<MobileElement> driver;

	public BasePage() {
		this.driver = new GetDriver().getDriver();
	}


}
