/**
 * 
 */
package Demo.UIAutomation.Utils;

import java.io.File;

/**
 * @author Sukumar
 *
 */
public interface Constants {
	
	public static final String curDir = System.getProperty("user.dir");
	public static final String CONFIG_PATH = curDir + "/Resources/Config.properties";
	public static final String LOCATORS_PATH = curDir + "/Resources/Locators.properties";
	public static final String TESTDATA_PATH = curDir + "/Resources/TestData.properties";
	public static final String CHROMEDRIVER_PATH= curDir + "/Resources" + File.separator + "/Drivers/chromedriver";
	
}
