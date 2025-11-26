package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productname;
	
	@FindBy(xpath="(//input[@accesskey='S'])[1]")
	private WebElement savebtn;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	

}
