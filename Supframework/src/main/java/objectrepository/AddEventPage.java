package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventPage {
	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement eventNameTF;
	
	@FindBy(xpath = "//input[@id='jscal_field_date_start']")
	private WebElement eventStartDate;
	
	@FindBy(xpath = "//input[@id='jscal_field_due_date']")
	private WebElement eventEndDate;
	
	@FindBy(xpath = "//input[@name='eventsave']")
	private WebElement savebtn;
	
	public AddEventPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEventNameTF() {
		return eventNameTF;
	}

	public WebElement getEventStartDate() {
		return eventStartDate;
	}

	public WebElement getEventEndDate() {
		return eventEndDate;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createCalenderEvent(String EVENTNAME,String STARTDATE,String ENDDATE) 
	{
		
		getEventNameTF().sendKeys(EVENTNAME);
		getEventStartDate().clear();
		getEventStartDate().sendKeys(STARTDATE);
		getEventEndDate().clear();
		//getEventEndDate().sendKeys(ENDDATE);
		getSavebtn().click();
		
	}

}
