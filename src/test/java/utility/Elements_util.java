package utility;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.Basepage;

public class Elements_util extends Basepage{

	public Elements_util(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath = "//*[contains(@text, 'WebView3')]")
	private MobileElement web_view3;
	
	public List<MobileElement> get_elements(AppiumDriver<MobileElement> driver) {
		
		List<MobileElement> elements = driver.findElementsByXPath("//*[contains(@text, 'WebView3')]");
		return elements;
	}

}
