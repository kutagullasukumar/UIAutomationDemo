package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Demo.UIAutomation.Utils.BasePage;

/**
 * @author Sukumar
 *
 */

public class ConfirmationPage extends BasePage {

private WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 
	 * @param locator
	 * @return boolean
	 * Iterate over table data and checks the cell has data in the page
	 */
	public boolean verifyTableDataNotNull(String locator) {
		boolean status = false;
		List<WebElement> elementsList = getListOfElements(By.xpath(locator));
		
		for (WebElement webElement : elementsList) {
			if(webElement.getText() != null) {
				status = true;
			}
		}
		return status;
	}
}
