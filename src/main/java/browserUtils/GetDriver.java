package browserUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GetDriver {
	
	public AppiumDriver<MobileElement> getDriver() throws IOException {
		
		AppiumDriver<MobileElement> driver = getDriverInstance();
		return driver;
		
	}
	
	private AppiumDriver<MobileElement> getDriverInstance() throws IOException {
		GetDriverProperties gp = new GetDriverProperties();
		File f = new File("src/test/resources/app");
		File fs = new File(f, gp.getAPKInfo());
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, gp.getDeviceName());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, gp.getAutomationName());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, gp.getPlatFormName());
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		return new AppiumDriver<MobileElement>(new URL(gp.getAppiumURL()), cap);
	}

}
