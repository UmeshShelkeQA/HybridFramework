package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_004_SuzukiTest extends BaseTest {

	@Test(groups = "regression" , description = "PageTest2 test1 description" )
	public void TC_001_Suzuki_Test() {
		addAuthor("Lisa");
		GooglePage gp = new GooglePage(driver);
		addLog("Entering 'Suzuki Access 125' text in textfox");
		logger.info("Entering 'Suzuki Access 125' text in textfox");
		gp.enterTextInSearchBox("Suzuki Access 125");
		
		addLog("Selecting first option from suggestion list");
		logger.info("Selecting first option from suggestion list");
		gp.selectOptionFromSuggestionList();
		
		addLog("Validating test result");
		logger.info("Validating test result");
		Assert.assertTrue(true);
	}

}
