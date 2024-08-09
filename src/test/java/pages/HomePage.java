package pages;

import data.EnergyTracker;
import data.FoodDataDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	private AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	private By searchFoodField = By.xpath("//android.widget.EditText[@text=\"Search foods to log\"]");
	private By smartSearchPopup = By.xpath("//android.widget.TextView[@text=\"Smart Search\"]");
	private By finishButton = By.xpath("//android.widget.TextView[@text=\"Finish\"]");

	private By firstSearchResult = By.xpath("//android.widget.ImageView");

	private By calIntake = By.xpath("//android.widget.TextView[contains(@text, \"cal intake\")]");
	private By calBurnt = By.xpath("//android.widget.TextView[contains(@text, \"cal burned\")]");
	private By calRemaining = By.xpath("//android.widget.TextView[contains(@text, \"remaining\")]");
	private By totalCarb = By.xpath("//android.widget.TextView[@text=\"Carb\"]/preceding-sibling::android.widget.TextView");
	private By totalProtein = By.xpath("//android.widget.TextView[@text=\"Protein\"]/preceding-sibling::android.widget.TextView");
	private By totalFat = By.xpath("//android.widget.TextView[@text=\"Fat\"]/preceding-sibling::android.widget.TextView");


	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public boolean checkHomeScreen() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchFoodField));
		return driver.findElement(searchFoodField).isDisplayed();
	}

	public boolean checkSmartSearchPopup() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(smartSearchPopup));
		return driver.findElement(smartSearchPopup).isDisplayed();
	}

	public void clickFinishButton() {
		wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
	}

	public void searchFood(String foodName) {
		wait.until(ExpectedConditions.elementToBeClickable(searchFoodField));
		driver.findElement(searchFoodField).click();
		driver.findElement(searchFoodField).sendKeys(foodName);
	}

	public void clickFirstSearchResult() {
		wait.until(ExpectedConditions.elementToBeClickable(firstSearchResult)).click();
	}

	public EnergyTracker storeEnergyTracker(){
		EnergyTracker initialEnergyTracker = new EnergyTracker();
		initialEnergyTracker.setCalIntake(wait.until(ExpectedConditions.visibilityOfElementLocated(calIntake)).getText().split(" ")[0]);
		initialEnergyTracker.setCalBurnt(driver.findElement(calBurnt).getText().split(" ")[0]);
		initialEnergyTracker.setCalRemaining(driver.findElement(calRemaining).getText().split(" ")[1]);
		initialEnergyTracker.setProtein(driver.findElement(totalProtein).getText().split("g")[0]);
		initialEnergyTracker.setCarb(driver.findElement(totalCarb).getText().split("g")[0]);
		initialEnergyTracker.setFat(driver.findElement(totalFat).getText().split("g")[0]);
		return initialEnergyTracker;
	}

	public void verifyEnergyTrackerUpdated(EnergyTracker initial, EnergyTracker updated, FoodDataDetails food) {
        Assert.assertEquals(Integer.parseInt(updated.getCalIntake()), Integer.parseInt(initial.getCalIntake()) + Integer.parseInt(food.getTotalCal()), "Cal intake not updated correctly");
        Assert.assertEquals(Integer.parseInt(updated.getCalBurnt()), Integer.parseInt(initial.getCalBurnt()), "Cal burnt not updated correctly");
        Assert.assertEquals(Integer.parseInt(updated.getCalRemaining()), Integer.parseInt(initial.getCalRemaining()) - Integer.parseInt(food.getTotalCal()), "Cal remaining not updated correctly");
        Assert.assertEquals(Integer.parseInt(updated.getCarb()), Integer.parseInt(initial.getCarb()) + Integer.parseInt(food.getCarb()), "Carb  not updated correctly");
        Assert.assertEquals(Integer.parseInt(updated.getFat()), Integer.parseInt(initial.getFat()) + Integer.parseInt(food.getFat()), "Fat not updated correctly");
        Assert.assertEquals(Integer.parseInt(updated.getProtein()), Integer.parseInt(initial.getProtein()) + Integer.parseInt(food.getProtein()), "Protein not updated correctly");

	}
	public void verifyItemDetailsInTracker(FoodDataDetails food) {
		String time = food.getTimeWhenTaken().toUpperCase();
		String itemNameLocator = String.format("((//android.widget.TextView[@text=\"%s\"]/../../../../../../following-sibling::android.view.ViewGroup)[1]//android.widget.ImageView/following-sibling::android.widget.TextView)[1]", time);
		String itemSubNameLocator = String.format("((//android.widget.TextView[@text=\"%s\"]/../../../../../../following-sibling::android.view.ViewGroup)[1]//android.widget.ImageView/following-sibling::android.widget.TextView)[2]", time);
		String itemCalLocator = String.format("((//android.widget.TextView[@text=\"%s\"]/../../../../../../following-sibling::android.view.ViewGroup)[1]//android.widget.ImageView/following-sibling::android.widget.TextView)[3]", time);
		Assert.assertEquals(food.getItemName(), driver.findElement(By.xpath(itemNameLocator)).getText());
		Assert.assertEquals(food.getQuantity()+ " "+food.getItemSubtype(), driver.findElement(By.xpath(itemSubNameLocator)).getText().toLowerCase());
		Assert.assertEquals(food.getTotalCal(), driver.findElement(By.xpath(itemCalLocator)).getText());
	}



}
