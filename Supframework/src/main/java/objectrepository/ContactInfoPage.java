package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(className = "dvHeaderText")
	private WebElement contactinfo;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startdatetf;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement enddatetf;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactinfo() {
		return contactinfo;
	}

	public WebElement getStartdatetf() {
		return startdatetf;
	}

	public WebElement getEnddatetf() {
		return enddatetf;
	}
	
	
	

}
