package factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import utility.Utility;

public class DriverFactory {

	private DriverFactory() {
	}

	public synchronized static WebDriver getDriver() throws MalformedURLException {
		WebDriver driver;
		String browserName = Utility.getConfigurationProperty("browser").toLowerCase();
//		System.out.println("getDriver");
		if (Utility.getConfigurationProperty("remote").toLowerCase().equals("true")) {
			// capabilities
			// {"browserName":"chrome","browserVersion":"120.0","goog:chromeOptions":{"binary":"/usr/bin/google-chrome"},
			// "platformName":"linux","se:noVncPort":7900,"se:vncEnabled":true}
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("browserName", Utility.getConfigurationProperty("browser").toLowerCase());
//			dc.setCapability("browserVersion", Utility.getConfigurationProperty("browser_version").toLowerCase());
			dc.setCapability("platformName", Utility.getConfigurationProperty("os").toLowerCase());
			driver = new RemoteWebDriver(new URL(Utility.getConfigurationProperty("grid_url")), dc);

		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Instantiating driver");
			driver = new ChromeDriver();
		
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		
		} else {
			throw new IllegalArgumentException();
		}
		
		return driver;
	}
}
