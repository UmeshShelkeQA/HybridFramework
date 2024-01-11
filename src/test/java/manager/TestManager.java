package manager;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.test.BaseTest;
import utility.Utility;

public class TestManager {

	private static ExtentReports extent = ReportManager.getReportManager().getExtentReporter();
	private static Map<Object, ExtentTest> testMapper = new HashMap<>();

	private static String getMethodName(ITestResult result) {
		// return current calling tests method name
		return result.getMethod().getConstructorOrMethod().getName();
	}

	public synchronized static void onTestStart(Object runningTestObject, ITestResult result) {
		// adding test in mapper, //passing test name and test description to
		// createTest(name,description)
		
		ExtentTest test = extent.createTest( getMethodName(result), result.getMethod().getDescription());

		WebDriver driver = ((BaseTest) result.getInstance()).getWebDriver();
		RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
		String platformName = remoteDriver.getCapabilities().getPlatformName().toString();

		test.assignDevice(platformName)
			.assignDevice(remoteDriver.getCapabilities().getBrowserName())
			.assignCategory(result.getMethod().getGroups()) // adding groups to the test cases
			.log(Status.INFO, "Execution Started ");

		testMapper.put(runningTestObject, test);
	}

	public synchronized static void onTestSuccess(Object runningTestObject, ITestResult result) {
		if (testMapper.containsKey(runningTestObject)) {
			ExtentTest test = testMapper.get(runningTestObject);
			test.log(Status.PASS, "Test Passed");
			removeTestFromTestMapper(runningTestObject);
		}
	}

	public synchronized static void onTestFailure(Object runningTestObject, ITestResult result) {
		BaseTest baseTest = (BaseTest) (result.getInstance());

		String imageBase64 = Utility.getScreenshotAsBase64(baseTest.getWebDriver());
		System.out.println("Test Failure");
		String destinationFilePath = Utility.getScreenshotAsFile(baseTest.getWebDriver(), getMethodName(result));
		if (testMapper.containsKey(runningTestObject)) {
			ExtentTest test = testMapper.get(runningTestObject);
			test.log(Status.FAIL, result.getThrowable())
				.addScreenCaptureFromBase64String(imageBase64);
			test.addScreenCaptureFromPath(destinationFilePath);
			
			removeTestFromTestMapper(runningTestObject);
		}
	}

	public synchronized static void onTestSkipped(Object runningTestObject, ITestResult result) {
		if (testMapper.containsKey(runningTestObject)) {
			ExtentTest test = testMapper.get(runningTestObject);
			test.log(Status.SKIP, result.getThrowable());
			removeTestFromTestMapper(runningTestObject);
		}
	}

	public static synchronized void onFinish() {
		// writes/updates the test information of reporter to the destination type(HTML file)
		extent.flush();
	}

	public static ExtentTest getExtentTest(Object runningTestObject) {
		return testMapper.get(runningTestObject);
	}

	public synchronized static void addLogToTest(Object runningTestObject, String logMsg) {
		if (testMapper.containsKey(runningTestObject)) {
			ExtentTest test = testMapper.get(runningTestObject);
			test.log(Status.INFO, logMsg);
		}
	}

	public synchronized static void assignAuthorToTest(Object runningTestObject, String authorName) {
		if (testMapper.containsKey(runningTestObject)) {
			ExtentTest test = testMapper.get(runningTestObject);
			test.assignAuthor(authorName);
		}
	}

	private synchronized static void removeTestFromTestMapper(Object runningTestObject) {
		extent.flush();
		testMapper.remove(runningTestObject);
	}
}
