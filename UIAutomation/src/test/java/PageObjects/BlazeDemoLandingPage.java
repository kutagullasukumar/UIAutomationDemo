package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Demo.UIAutomation.Utils.BasePage;

/**
 * @author Sukumar
 *
 */

public class BlazeDemoLandingPage extends BasePage {

	private WebDriver driver;
	
	public BlazeDemoLandingPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 
	 * @param locator
	 * @return string
	 */
	public String getText(String locator) {
		return waitForElementToAppear(By.xpath(locator)).getText();
	}
	
	/**+
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectValueFromDrpDown(String locator, String value) {
		selectValueFromDrpDown(By.name(locator), value);
	}
	
	/**+
	 * 
	 * @param locator
	 */
	public void clickBtn(String locator) {
		waitAndClick(By.xpath(locator));
	}
	
	/**+
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isDisplayed(String locator) {
		return isElementDisplayed(By.xpath(locator));
	}
}
