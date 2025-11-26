package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderPage {
	
	@FindBy(xpath = "(//img[@src='themes/images/cal_add.gif'])[1]")
	private WebElement plusImg;
	
	@FindBy(xpath = "(//td[@class='cellNormal'])[1]")
	private WebElement cell1;
	
	public CalenderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusImg() {
		return plusImg;
	}

	public WebElement getCell1() {
		return cell1;
	}
}
