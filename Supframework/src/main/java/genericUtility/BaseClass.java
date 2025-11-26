package genericUtility;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class BaseClass {
	public Webdriverutilities wlib = new Webdriverutilities();
	public Databaseutilities dlib = new Databaseutilities();
	public Excelutilities elib = new Excelutilities();
	public Propertyfileutilities plib = new Propertyfileutilities();
	public Javautilities jlib = new Javautilities();

	public WebDriver driver = null;
	public static WebDriver sdriver; 
	
	@BeforeSuite(alwaysRun = true)//(groups = {"smoke testing","regression testing"})
	public void beforeSuite() {
		System.out.println("DB connection");
	dlib.getDBConnection();
	}

	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)//(groups = {"smoke testing","regression testing"})
	public void beforeClass() throws IOException {
		//String BROWSER = browser;
	String	BROWSER=plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		sdriver	= driver;
		
		driver.get(URL);
		wlib.windowMaximize(driver);
		System.out.println("before class");
	}

	@BeforeMethod(alwaysRun = true)//(groups = {"smoke testing","regression testing"})
	public void beforeMethod() throws IOException {
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		wlib.waitForPageToLoad(driver, 10);
		System.out.println("before method");
	}

	@AfterMethod(alwaysRun = true)//(groups = {"smoke testing","regression testing"})
	public void afterMethod() {
		HomePage hp = new HomePage(driver);
		hp.logout();
		System.out.println("after method");
	}

	@AfterClass(alwaysRun = true)//(groups = {"smoke testing","regression testing"})
	public void afterClass() {
		driver.quit();
		System.out.println("after class");
	}

	@AfterSuite(alwaysRun = true)//(groups = {"smoke testing","regression testing"})
	public void afterSuite() {
		System.out.println("close DB");
	}

}
