package pages.test;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import factory.DriverFactory;
import manager.TestManager;
import utility.Utility;

public abstract class BaseTest {

	protected WebDriver driver;
	private String driverSessionId = null;
	public static Logger logger;

	static {
		logger = Logger.getLogger("TestLogger");
		PropertyConfigurator.configure("./src/test/resources/log4j.properties");
	}
	@BeforeClass()
	public void setUp() throws MalformedURLException, InterruptedException {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.get(Utility.getConfigurationProperty("env_url"));
//		print the session id of the driver
		driverSessionId = ((RemoteWebDriver) driver).getSessionId().toString();
		System.out.println(driverSessionId);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public Object getCurrentObject() {
		return this;
	}

	public void addLog(String logMessage) {
		TestManager.addLogToTest(getCurrentObject(), logMessage);
		Reporter.log(logMessage);

	}

	public void addAuthor(String author) {
		TestManager.assignAuthorToTest(getCurrentObject(), author);
	}
}
