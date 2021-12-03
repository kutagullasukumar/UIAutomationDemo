package Demo.UIAutomation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sukumar
 *
 */

public class PropertyReader {

	public Properties props = new Properties();
	private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public Properties readProperties() {
		
		try {
			props.load(new FileInputStream(Drivers.CONFIG_PATH));
			props.load(new FileInputStream(Drivers.LOCATORS_PATH));
			props.load(new FileInputStream(Drivers.TESTDATA_PATH));
			LOGGER.log(Level.INFO, "Reading properties file data");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
}
