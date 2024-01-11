package pages.test;

import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_002_ActivaTest extends BaseTest {

	@Test(groups = "smoke" ,description = "PageTest2 test1 description" )
	public void TC_001_Activa_Test() {
		addAuthor("Lisa");
		GooglePage gp = new GooglePage(driver);
		addLog("Entering 'Activa' text in textfox", "info");
		gp.enterTextInSearchBox("Activa");
		addLog("Selecting first option from suggestion list", "info");
		gp.selectOptionFromSuggestionList();
//		Assert.assertTrue(false);
		addLog("clicking on link", "info");
		gp.clickOnLink();
	}

}
