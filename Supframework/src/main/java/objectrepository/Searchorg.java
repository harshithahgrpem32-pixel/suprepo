package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchorg {
	@FindBy(id="search_txt")
	private WebElement searchtxt;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchbtn;
	
	@FindBy(xpath ="//a[@id='1']")
	private WebElement orglinks;
	
	public Searchorg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getOrglinks() {
		return orglinks;
	}
	
	

}
