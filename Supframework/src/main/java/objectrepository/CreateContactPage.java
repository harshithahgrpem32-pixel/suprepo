package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.Webdriverutilities;

public class CreateContactPage {
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement orgimg;
	
	@FindBy(name="support_start_date")
	private WebElement supportstartdate;
	
	@FindBy(name="support_end_date")
	private WebElement supportenddate;
	
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement savebtn;
	
	public CreateContactPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getOrgimg() {
		return orgimg;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getSupportstartdate() {
		return supportstartdate;
	}

	public WebElement getSupportenddate() {
		return supportenddate;
	}

	public void createLastName(String LASTNAME)
	{
		getLastname().sendKeys(LASTNAME);
		getSavebtn().click();
	}
	
	public void createLastNameWithOrg(WebDriver driver, String LASTNAME,String ORGANISATIONNAME)
	{   
		Webdriverutilities wlib=new Webdriverutilities();
		getLastname().sendKeys(LASTNAME);
		getOrgimg().click();
		String PARENTWINDOW = wlib.getParentWindow(driver);
		wlib.switchToChildWindow(driver, PARENTWINDOW);
		Searchorg sp = new Searchorg(driver);
		sp.getSearchtxt().sendKeys(ORGANISATIONNAME);
		sp.getSearchbtn().click();
		sp.getOrglinks().click();
		wlib.parentWindow(driver, PARENTWINDOW);
		getSavebtn().click();
	}
	
	public void createLastNameWithSupportDate(String LASTNAME,String STARTDATE,String ENDDATE)
	{
		getLastname().sendKeys(LASTNAME);
		getSupportstartdate().clear();
		getSupportstartdate().sendKeys(STARTDATE);
		getSupportenddate().clear();
		getSupportenddate().sendKeys(ENDDATE);
		getSavebtn().click();
	}
	
	
}
