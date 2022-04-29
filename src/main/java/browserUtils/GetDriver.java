package browserUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GetDriver {
	
	public AppiumDriver<MobileElement> getDriver(String driverName) throws MalformedURLException {
		
		AppiumDriver<MobileElement> driver = getDriverInstance(driverName);
		return driver;
		
	}
	
	private AppiumDriver<MobileElement> getDriverInstance(String driverName) throws MalformedURLException {
		File f = new File("src/test/resources/app");
		File fs = new File(f, "ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "sahoo_emulator");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		return new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

}
