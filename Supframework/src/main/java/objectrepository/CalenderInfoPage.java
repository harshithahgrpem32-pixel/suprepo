package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderInfoPage {
	
	@FindBy(xpath = "//a[@href='index.php?action=DetailView&module=Calendar&record=268&activity_mode=Events&viewtype=calendar&parenttab=My Home Page']")
	private WebElement eventInfo;
	
	public CalenderInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEventInfo() {
		return eventInfo;
	}

}
