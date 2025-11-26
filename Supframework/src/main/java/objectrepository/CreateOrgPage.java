package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.Webdriverutilities;

public class CreateOrgPage {
	
	Webdriverutilities wlib=new Webdriverutilities();
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgname;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement savebtn;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement orgdd;
	
	@FindBy(xpath = "//option[@value='Healthcare']")
	private WebElement healthoption;
	
	@FindBy(name="phone")
	private WebElement phonenumber;
	
	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getOrgdd() {
		return orgdd;
	}

	public WebElement getHealthoption() {
		return healthoption;
	}

	public WebElement getPhonenumber() {
		return phonenumber;
	}
	
    public void createOrgName(String ORGNAME)
    {
    	getOrgname().sendKeys(ORGNAME);
		getSavebtn().click();
    }
	
    public void createOrgNameWithInd(String ORGNAME)
    {
    	getOrgname().sendKeys(ORGNAME);
    	wlib.selectByVisibleText(getOrgdd(),getHealthoption().getText());
		getSavebtn().click();
    }
    
    public void createOrgNameWithPhoneNum(String ORGNAME,String PHONENUMBER )
    {
    	getOrgname().sendKeys(ORGNAME);
		getPhonenumber().sendKeys(PHONENUMBER);
		getSavebtn().click();
    }

}
