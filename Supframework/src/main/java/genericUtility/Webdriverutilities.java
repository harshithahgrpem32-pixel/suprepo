package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutilities {
	
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	public void waitForPageToLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void waitForTitleContain(WebDriver driver,String title,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForElementVisible(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForUrlContains(WebDriver driver,String url,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	public void waitForElementClickable(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void presenceOfElementLocated(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	
	public void selectByIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	
	
	
	
	public void hover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void click(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}	
	
	public void clickAndHold(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	public void sendKeysToElement(WebDriver driver,WebElement element,CharSequence keys)
	{
		Actions act=new Actions(driver);
		act.sendKeys(element, keys);
	}
	
    
	
	public String getParentWindow(WebDriver driver)
	{
	String	parentWindow=driver.getWindowHandle();
	return parentWindow;
	}
	
	public Set<String> getAllWindows(WebDriver driver)
	{
		return driver.getWindowHandles();
	}
	
	public  void switchToWindowByHandle(WebDriver driver,String windowHandle)
	{
		driver.switchTo().window(windowHandle);
	}
	
	public void switchToChildWindow(WebDriver driver,String parentWindow)
	{
	Set<String>	childwindows=driver.getWindowHandles();
	for(String childwindow:childwindows)
	{
		if(!parentWindow.equals(childwindow))
		{
			driver.switchTo().window(childwindow);
			break;
		}
	}
	//return driver;
	}
	
	public void parentWindow(WebDriver driver,String parentWindow)
	{
		driver.switchTo().window(parentWindow);
	}
	
	public void closeCurrentWindow(WebDriver driver)
	{
		driver.close();
	}
	
	public void closeAllWindow(WebDriver driver)
	{
		driver.quit();
	}
	
	public String getWindowTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	
	
	public void switchToFrameIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameName(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToFrameId(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	
	public void switchToFrameAddress(WebDriver driver,WebElement frameelement)
	{
		driver.switchTo().frame(frameelement);
	}
	
	public void switchToDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchToParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void alertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	public void sendTextToAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	
	public WebDriver launchChromeWithoutNotification()
	{
		ChromeOptions opts=new ChromeOptions();
		opts.addArguments("--disable-notifications");
		return new ChromeDriver(opts);
	}
	
	public WebDriver launchFirefoxWithoutnotification()
	{
		FirefoxOptions opts=new FirefoxOptions();
		opts.addPreference("dom.webnotifications.enabled", false);
		return new FirefoxDriver(opts);	
	}
	
	
	public void uploadFile(WebDriver driver,WebElement fileelement, String filepath)
	{
		fileelement.sendKeys(filepath);
	}
	
	 
	
	public void takeScreenshot(WebDriver driver,String filepath) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File temp=ts.getScreenshotAs(OutputType.FILE);
	      File  perm=new File(filepath);
	      FileUtils.copyFile(temp, perm);
	}
	
	public void takeScreenshotElement(WebElement element,String filepath) throws IOException
	{
	  File	temp=element.getScreenshotAs(OutputType.FILE);
	  File perm=new File(filepath);
	  org.openqa.selenium.io.FileHandler.copy(temp, perm);
	}
	
	public void disableElementId(WebDriver driver,String idvalue,String text)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('" + idvalue + "').value='" + text + "'");
	}
	
	public void disableElementWithoutId(WebDriver driver,WebElement element,String text)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+text+"'",element);
	}
	
	public void scrollBy(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(x,y)");
	}
	
	public void scrollUptoElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void scrollToEnd(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void toZoomin(WebDriver driver,int zoomvalue)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='"+zoomvalue+"%'");
	}

}
