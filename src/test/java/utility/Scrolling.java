package utility;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scrolling {
	
	public void scroll_down(AppiumDriver<MobileElement> driver) {
		
		Dimension dimension = driver.manage().window().getSize();
		
		int start_y = dimension.height * 4/5;
		int end_y = dimension.height / 8;
		int fix_x = dimension.width /2;
		
		new TouchAction(driver).press(PointOption.point(fix_x, start_y))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(fix_x, end_y))
		.release().perform();
	}

}
