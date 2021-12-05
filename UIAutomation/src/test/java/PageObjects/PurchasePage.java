package PageObjects;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Demo.UIAutomation.Utils.BasePage;
import Demo.UIAutomation.Utils.Utils;

/**
 * @author Sukumar
 *
 */

public class PurchasePage extends BasePage {

	private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private WebDriver driver;
	
	public PurchasePage(WebDriver driver) {
		super(driver);
	}
	
	/**+
	 * 
	 * @param locator
	 * @param data
	 */
	public void enterText(String locator, String data) {
		enterText(By.id(locator), data);
		LOGGER.log(Level.INFO, "Enter data into " + locator + "field.");
	}
	
	public double getPrice(String locator) {
		return Utils.getPriceFromString(getTextFromLocator(By.xpath(locator)));
	}
}
 