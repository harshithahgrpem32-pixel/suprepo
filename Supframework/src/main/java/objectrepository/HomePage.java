package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calendar;
	
	@FindBy(xpath="//a[@href='index.php?module=Leads&action=index']")
	private WebElement leads;
	
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organisations;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	
	@FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
	private WebElement opportunities;
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement products;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorbtn;
	
	@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
	private WebElement signoutlink;
	
	@FindBy(xpath = "//a[@href='index.php?module=Documents&action=index']")
	private WebElement documentlink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getLeads() {
		return leads;
	}

	public WebElement getOrganisations() {
		return organisations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getAdministratorbtn() {
		return administratorbtn;
	}

	public WebElement getSignoutbtn() {
		return signoutlink;
	}

	public WebElement getOpportunities() {
		return opportunities;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getDocumentlink() {
		return documentlink;
	}
	
	public void logout()
	{
		administratorbtn.click();
		signoutlink.click();
	}
	
	
	

}
