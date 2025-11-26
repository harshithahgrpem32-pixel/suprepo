package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerLead;
	
	public LeadInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderLead() {
		return headerLead;
	}

}
