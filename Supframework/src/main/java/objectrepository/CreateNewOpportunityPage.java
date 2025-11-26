package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.Webdriverutilities;

public class CreateNewOpportunityPage {

	Webdriverutilities wlib = new Webdriverutilities();

	@FindBy(xpath = "(//input[@class='detailedViewTextBox'])[1]")
	private WebElement opportunityname;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement orgimg;

	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath = "//select[@name='sales_stage']")
	private WebElement saleStagedd;
	
	@FindBy(xpath = "//option[@value='Needs Analysis']")
	private WebElement needAnalysisOpt;

	public CreateNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityname() {
		return opportunityname;
	}

	public WebElement getOrgimg() {
		return orgimg;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	

	public WebElement getSaleStagedd() {
		return saleStagedd;
	}
	
	

	public WebElement getNeedAnalysisOpt() {
		return needAnalysisOpt;
	}

	public void createOpportunity(String OPPORTUNITY, WebDriver driver,String ORGNAME) {
		getOpportunityname().sendKeys(OPPORTUNITY);
		getOrgimg().click();
		String parentwindow = wlib.getParentWindow(driver);
		wlib.switchToChildWindow(driver, parentwindow);
		Searchorg sp = new Searchorg(driver);
		sp.getSearchtxt().sendKeys(ORGNAME);
		sp.getSearchbtn().click();
		sp.getOrglinks().click();
		wlib.parentWindow(driver, parentwindow);
		getSavebtn().click();

	}
	
	public void createOpportunityWithsales(String OPPORTUNITY, WebDriver driver,String ORGNAME) {
		getOpportunityname().sendKeys(OPPORTUNITY);
		getOrgimg().click();
		String parentwindow = wlib.getParentWindow(driver);
		wlib.switchToChildWindow(driver, parentwindow);
		Searchorg sp = new Searchorg(driver);
		sp.getSearchtxt().sendKeys(ORGNAME);
		sp.getSearchbtn().click();
		sp.getOrglinks().click();
		wlib.parentWindow(driver, parentwindow);
		getSaleStagedd().click();
		getNeedAnalysisOpt().click();
		getSavebtn().click();
	}

}
