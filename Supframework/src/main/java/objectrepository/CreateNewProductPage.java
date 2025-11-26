package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameTF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement file;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getProductNameTF() {
		return productNameTF;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getFile() {
		return file;
	}


	public void uploadFiles(String PRODUCTNAME) 
	{
	   getProductNameTF().sendKeys(PRODUCTNAME);
	   getFile().sendKeys("C:\\Users\\sys\\Pictures\\Screenshots\\Screenshot (13).png");
	   getFile().sendKeys("C:\\Users\\sys\\Pictures\\Screenshots\\Screenshot (14).png");
	   getFile().sendKeys("C:\\Users\\sys\\Pictures\\Screenshots\\Screenshot (15).png");
	   getFile().sendKeys("C:\\Users\\sys\\Pictures\\Screenshots\\Screenshot (16).png");
	   getFile().sendKeys("C:\\Users\\sys\\Pictures\\Screenshots\\Screenshot (17).png");
	   getFile().sendKeys("C:\\Users\\sys\\Pictures\\Screenshots\\Screenshot (18).png");
	   getSaveBtn().click();
		
	}
}
