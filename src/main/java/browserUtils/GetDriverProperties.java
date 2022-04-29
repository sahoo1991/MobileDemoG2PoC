package browserUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class GetDriverProperties {
	
	
	public String getDeviceName() throws IOException {
		
		Properties prop = getPropertyObject();
		return prop.getProperty("deviceName");
		
	}
	
	public String getAppiumURL() throws IOException {
		Properties prop = getPropertyObject();
		return prop.getProperty("appiumURL");
		
	}
	
	private Properties getPropertyObject() throws IOException {
		
		
		Properties prop = new Properties();
		String path = Paths.get("").toAbsolutePath().normalize().toString()+"\\mobileConfig.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		return prop;
	}

}
