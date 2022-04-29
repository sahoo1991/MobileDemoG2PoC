package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Page3 extends Basepage{
	
	public Page3(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath = "//*[contains(@text, '3. Scroll')]")
	private MobileElement scroll_link;
	
	public void getScrollText() throws InterruptedException{
		
		Thread.sleep(2000);
		System.out.println(scroll_link.getText());
	}


}
