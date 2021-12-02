package Demo.UIAutomation.Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sukumar
 *
 */

public class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
			
	@SuppressWarnings("deprecation")
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	protected WebElement waitForElementToAppear(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	protected void selectValueFromDrpDown(By locator, String value) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
		select.selectByValue(value);
	}
	
	protected void waitAndClick(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	protected boolean isElementDisplayed(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
	}
	
	protected void enterText(By locator, String data) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(data);
	}
	
	protected boolean textNotEqualNull(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText() != null;
	}
	
	protected List<WebElement> getListOfElements(By locator){
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
