package Demo.UIAutomation.Utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Sukumar
 *
 */
public class BaseTest implements Constants {

	private final static Logger LOGGER = 
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static Properties properties = new PropertyReader().readProperties();
	
	public static Properties getProperties() {
		return properties;
	}

	public static void setProperties(Properties properties) {
		BaseTest.properties = properties;
	}

	private static String browserName;

	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	public static  void setDriver() {
		getBrowser();
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;
		default:
			throw new RuntimeException("No driver has been configured");
		}
		getDriver().get(properties.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		LOGGER.log(Level.INFO, "Initialized " + browserName + " driver.");
	}

	public static Browsers getBrowser() {
		browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
			return Browsers.CHROME;
		else if (browserName.equalsIgnoreCase("edge"))
			return Browsers.EDGE;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public static void closeBrowser()
	{
		driver.get().close();
		driver.remove();
		LOGGER.log(Level.INFO, "Closed " + browserName + " driver.");
	}
}
