package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInfoPage {
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerDoc;
	
	public DocumentInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderDoc() {
		return headerDoc;
	}
	
	

}
