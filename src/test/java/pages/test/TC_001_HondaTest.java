package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_001_HondaTest extends BaseTest {

	@Test(groups = "smoke" ,description = "PageTest2 test1 description" )
	public void TC_001_Honda_Test() {
		addAuthor("Umesh");
		GooglePage gp = new GooglePage(driver);
		addLog("Entering 'Honda' text in textfox");
		logger.info("Entering 'Honda' text in textfox");
		gp.enterTextInSearchBox("Honda");
		
		addLog("Selecting first option from suggestion list");
		logger.info("Selecting first option from suggestion list");
		gp.selectOptionFromSuggestionList();
		
		addLog("Validating test result");
		logger.info("Validating test result");
		Assert.assertTrue(true);
	}

}
