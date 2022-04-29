package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Page1 extends Basepage{

	public Page1(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath = "//*[contains(@text, 'Views')]")
	private MobileElement view_link;
	
	public void clickOnViews() throws InterruptedException{
		
		view_link.click();
	}

}
