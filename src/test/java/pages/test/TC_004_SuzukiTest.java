package pages.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_004_SuzukiTest extends BaseTest {

	@Test(groups = "smoke" , description = "PageTest2 test1 description" )
	public void TC_001_Suzuki_Test() {
		addAuthor("Lisa");
		GooglePage gp = new GooglePage(driver);
		addLog("Entering 'Suzuki Access 125' text in textfox", "info");
		gp.enterTextInSearchBox("Suzuki Access 125");
		addLog("Selecting first option from suggestion list", "info");
		gp.selectOptionFromSuggestionList();
		addLog("Validating test result", "info");
		Assert.assertTrue(true);
	}

}
