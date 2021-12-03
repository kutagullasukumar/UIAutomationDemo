/**
 * 
 */
package Demo.UIAutomation.Utils;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

/**
 * @author Sukumar
 *
 */
public interface Drivers {
	
	public static final String curDir = System.getProperty("user.dir");
	public static final String CONFIG_PATH = curDir + "\\Resources\\Config.properties";
	public static final String LOCATORS_PATH = curDir + "\\Resources\\Locators.properties";
	public static final String TESTDATA_PATH = curDir + "\\Resources\\TestData.properties";
	
}
