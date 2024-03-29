package pages.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import pages.GooglePage;

public class TC_002_ActivaTest extends BaseTest {

	@Test(groups = "smoke" ,description = "PageTest2 test1 description" )
	public void TC_001_Activa_Test() {
		addAuthor("Lisa");
		GooglePage gp = new GooglePage(driver);
		addLog("Entering 'Activa' text in textfox");
		logger.info("Entering 'Activa' text in textfox");
		gp.enterTextInSearchBox("Activa");
		
		addLog("Selecting first option from suggestion list");
		logger.info("Selecting first option from suggestion list");
		gp.selectOptionFromSuggestionList();
		
		addLog("Skipping test intentially");
		throw new SkipException("Skipping test intentially");
//		Assert.assertTrue(true);
	}

}
