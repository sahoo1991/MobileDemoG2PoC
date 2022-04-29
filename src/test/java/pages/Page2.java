package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Page2 extends Basepage{
	
	public Page2(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath = "//*[contains(@text, 'Auto Complete')]")
	private MobileElement autocomplete_link;
	
	public void clickOnAutoComplete() throws InterruptedException{
		
		autocomplete_link.click();
	}


}
