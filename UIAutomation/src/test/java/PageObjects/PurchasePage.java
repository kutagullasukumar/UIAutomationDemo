package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Demo.UIAutomation.Utils.BasePage;

/**
 * @author Sukumar
 *
 */

public class PurchasePage extends BasePage {

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
	}
}
 