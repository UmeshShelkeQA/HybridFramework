package listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import manager.TestManager;
import pages.test.BaseTest;


public class TestListener extends BaseTest implements ITestListener{

//	ExtentReports extent = ReportManager.getReportManager().getExtentReporter();
	private Object getCurrentTestClassObject(ITestResult result){
		BaseTest baseTest = (BaseTest) result.getInstance();
		return baseTest.getCurrentObject();
	}
	public void onTestStart(ITestResult result) {
		
		System.out.println("OnTestStart : " + getCurrentTestClassObject(result));
		TestManager.onTestStart( getCurrentTestClassObject(result) , result);
	}
	public void onTestSuccess(ITestResult result) {
		TestManager.onTestSuccess(getCurrentTestClassObject(result), result);
	}
	public void onTestFailure(ITestResult result) {
		TestManager.onTestFailure(getCurrentTestClassObject(result), result);
	}

	public void onTestSkipped(ITestResult result) {
		TestManager.onTestSkipped(getCurrentTestClassObject(result), result);
	}
	public void onFinish(ITestContext context) {
		//writes/updates the test information of reporter to the destination type(HTML file) 
		System.out.println("onFinish");
		TestManager.onFinish();
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
	}

}
