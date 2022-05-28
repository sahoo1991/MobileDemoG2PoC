package reportsUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotsFactory {
	
	public String takeScreenPrintAndReturnPath(WebDriver driver, String stepName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy HH-mm-ss");
		String formattedDate = now.format(format);
		FileHandler.copy(src, new File(System.getProperty("user.dir")+"/screenshots/"+formattedDate.toString()+stepName+".png"));
		return System.getProperty("user.dir")+"\\screenshots\\"+formattedDate.toString()+stepName+".png";
		
	}

}
