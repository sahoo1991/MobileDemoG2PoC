package browserUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import browserUtils.GetDriverProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GetDriver {

	public AppiumDriver<MobileElement> getDriver() {

		AppiumDriver<MobileElement> driver = getDriverInstance();
		return driver;

	}

	private AppiumDriver<MobileElement> getDriverInstance()  {
		GetDriverProperties gp = new GetDriverProperties();
		File f = new File("src/test/resources/app");
		File fs = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		try {
			fs = new File(f, gp.getAPKInfo());
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, gp.getDeviceName());
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, gp.getAutomationName());
			cap.setCapability(CapabilityType.PLATFORM_NAME, gp.getPlatFormName());
			cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
			return new AppiumDriver<>(new URL(gp.getAppiumURL()), cap);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
