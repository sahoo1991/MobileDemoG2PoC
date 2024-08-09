package pages;

import data.FoodDataDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogFood {

	private AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	private By editQuantityPopup = By.xpath("//android.widget.TextView[@text=\"Edit Quantity\"]");
	private By finishButton = By.xpath("//android.widget.TextView[@text=\"Finish\"]");

	private By itemQuantity = By.xpath("(//android.widget.ImageView/following-sibling::android.view.ViewGroup)[1]//android.widget.EditText");

	private By itemSubType = By.xpath("((//android.widget.ImageView//following-sibling::android.view.ViewGroup)[1]//android.widget.TextView)[1]");

	private By itemName = By.xpath("((//android.widget.ImageView//following-sibling::android.view.ViewGroup)[1]//android.widget.TextView)[2]");
	private By totalCal = By.xpath("//android.widget.TextView[@text=\"Total Calories\"]/following-sibling::android.widget.TextView");
	private By protein = By.xpath("//android.widget.TextView[@text=\"Protein\"]/preceding-sibling::android.widget.TextView");
	private By carb = By.xpath("//android.widget.TextView[@text=\"Carb\"]/preceding-sibling::android.widget.TextView");
	private By fat = By.xpath("//android.widget.TextView[@text=\"Fat\"]/preceding-sibling::android.widget.TextView");
	private By time = By.xpath("//android.widget.TextView[@text=\"When:\"]/following-sibling::android.widget.TextView");
	private By logFoodButton = By.xpath("//android.widget.TextView[@text=\"Log 1 Food\"]");
	public LogFood(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public boolean checkEditQuantityPopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(editQuantityPopup));
		return driver.findElement(editQuantityPopup).isDisplayed();
	}

	public void clickLogFood() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logFoodButton)).click();
	}

	public void clickFinishButton() {
		driver.findElement(finishButton).click();
	}

	public FoodDataDetails storeFoodDetails() {
		FoodDataDetails foodDataDetails = new FoodDataDetails();
		foodDataDetails.setItemName(wait.until(ExpectedConditions.visibilityOfElementLocated(itemName)).getText());
		foodDataDetails.setItemSubtype(driver.findElement(itemSubType).getText());
		foodDataDetails.setQuantity(driver.findElement(itemQuantity).getText());
		foodDataDetails.setTotalCal(driver.findElement(totalCal).getText());
		foodDataDetails.setTimeWhenTaken(driver.findElement(time).getText().split(",")[1].trim());
		foodDataDetails.setCarb(driver.findElement(carb).getText().split("g")[0]);
		foodDataDetails.setFat(driver.findElement(fat).getText().split("g")[0]);
		foodDataDetails.setProtein(driver.findElement(protein).getText().split("g")[0]);
		return foodDataDetails;
	}




}
