package pages.test;

import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_003_HeroTest extends BaseTest {

	@Test(groups = "smoke" , description = "PageTest2 test1 description" )
	public void TC_001_Hero_Test() {
		addAuthor("Janathan");
		GooglePage gp = new GooglePage(driver);
		addLog("Entering 'Hero Splender' text in textfox", "info");
		gp.enterTextInSearchBox("Hero Splender");
		addLog("Selecting first option from suggestion list", "info");
		gp.selectOptionFromSuggestionList();
//		Assert.assertTrue(false);
		addLog("clicking on link", "info");
		gp.clickOnLink();
	}

}
