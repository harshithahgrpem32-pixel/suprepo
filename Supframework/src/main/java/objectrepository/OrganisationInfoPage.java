package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	
	@FindBy(className = "dvHeaderText")
	private WebElement headermsg;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phonenumbermsg;
	
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeadermsg() {
		return headermsg;
	}

	public WebElement getPhonenumbermsg() {
		return phonenumbermsg;
	}
	
	
}
