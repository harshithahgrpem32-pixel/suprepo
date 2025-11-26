package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastnametf;
	
	@FindBy(xpath = "//input[@name='company']")
	private WebElement companytf;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	
	public CreateNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnametf() {
		return lastnametf;
	}

	public WebElement getCompanytf() {
		return companytf;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createLeadWithComp(String LASTNAME,String COMPANY)
	{
		getLastnametf().sendKeys(LASTNAME);
		getCompanytf().sendKeys(COMPANY);
		getSavebtn().click();
	}
	
	
}
