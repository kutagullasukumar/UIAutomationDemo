package PageObjects;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Demo.UIAutomation.Utils.BasePage;

/**
 * @author Sukumar
 *
 */

public class BlazeDemoLandingPage extends BasePage {
	private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
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
		LOGGER.log(Level.INFO, "Entering text into " + locator + "field.");
		return waitForElementToAppear(By.xpath(locator)).getText();
	}
	
	/**+
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectValueFromDrpDown(String locator, String value) {
		selectValueFromDrpDown(By.name(locator), value);
		LOGGER.log(Level.INFO, "Selecting value from " + locator + " dropdown field.");
	}
	
	/**+
	 * 
	 * @param locator
	 */
	public void clickBtn(String locator) {
		waitAndClick(By.xpath(locator));
		LOGGER.log(Level.INFO, "Clicking " + locator);
	}
	
	/**+
	 * 
	 * @param locator
	 * @return boolean
	 */
	public boolean isDisplayed(String locator) {
		LOGGER.log(Level.INFO, "validating " + locator + " displayed");
		return isElementDisplayed(By.xpath(locator));
	}
}
