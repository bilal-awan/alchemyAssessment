package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class googleMapHomePage {
  
	@FindBy(xpath="//input[@id='searchboxinput']")
	WebElement searchBoxInputField;
	
	@FindBy(xpath="//div[@role='gridcell']//descendant::span[@class='ZHeE1b-LaJeF ZHeE1b-LaJeF-tPcied-dkl3Ye']")
	WebElement[] searchResults;
	
	WebDriver driver;
	
	//constructor
	public googleMapHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterSerachKey(String input) {
		searchBoxInputField.sendKeys(input);
	}
	
	
	public WebElement[] getSearchResults()
	{
		return searchResults;
	}
	
}
