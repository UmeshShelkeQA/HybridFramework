package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utility;

public class GooglePage {
	
	WebDriver driver;
	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(xpath = "(//ul[@role='listbox'])[1]/li")
	private List<WebElement> suggestions;

	//intentianally adding wrong xpath 
	@FindBy(xpath = "(//ul[@role='listfbox'])[1]/li")
	private WebElement link;
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTextInSearchBox(String text) {
		searchBox.sendKeys(text);
	}

	public void selectOptionFromSuggestionList() {
		try {
			Thread.sleep(3000);
			for (WebElement ele : suggestions) {
				ele.click();
				break;
			}
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clickOnLink() {
		Utility.waitElementToBeVisible(driver, link, 3).click();
	}
}
