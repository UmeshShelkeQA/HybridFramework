package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_003_HeroTest extends BaseTest {

	@Test(groups = "regression" , description = "PageTest2 test1 description" )
	public void TC_001_Hero_Test() {
		addAuthor("Janathan");
		GooglePage gp = new GooglePage(driver);
		addLog("Entering 'Hero Splender' text in textfox");
		logger.info("Entering 'Hero Splender' text in textfox");
		gp.enterTextInSearchBox("Hero Splender");
		
		addLog("Selecting first option from suggestion list");
		logger.info("Selecting first option from suggestion list");
		gp.selectOptionFromSuggestionList();
		Assert.assertTrue(false);
		
	}

}
