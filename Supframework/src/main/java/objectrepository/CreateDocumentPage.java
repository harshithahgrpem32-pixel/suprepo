package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocumentPage {

	@FindBy(xpath = "(//input[@class='detailedViewTextBox'])[1]")
	private WebElement title;
	
	@FindBy(xpath = "//input[@name='filename']")
	private WebElement filename;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement savebtn;
	
	public CreateDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getFilename() {
		return filename;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void uploadDocument(String DOCUMENTNAME)
	{
		getTitle().sendKeys(DOCUMENTNAME);
		getFilename().sendKeys("C:\\Users\\sys\\Desktop\\createdocument.xlsx");
		getSavebtn().click();
	}

	
}
