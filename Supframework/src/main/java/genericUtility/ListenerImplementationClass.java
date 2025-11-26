package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener ,ISuiteListener
{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//actual execution starts from here
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" --> executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		String methodName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String time =new Date().toString().replace(" ", "_").replace(":","_");
		File dst = new File(".\\Screenshot\\"+methodName+"_"+time+".png");
		try {
			FileUtils.copyFile(src, dst);
			String path = dst.getAbsolutePath();
		} catch (IOException e) {
			
		}
		test.addScreenCaptureFromBase64String(methodName);
		test.log(Status.FAIL, methodName+" --> is failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" --> skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		//create extent report
		String time =new Date().toString().replace(" ", "_").replace(":","_");
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report"+time+".html");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTiger_Automation");
		htmlreport.config().setDocumentTitle("VTiger");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("Base_Platform", "Windows-10");
		report.setSystemInfo("Base_URL", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Harshitha");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

	@Override
	public void onStart(ISuite suite) {
		String time =new Date().toString().replace(" ", "_").replace(":","_");
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report"+time+".html");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTiger_Automation");
		htmlreport.config().setDocumentTitle("VTiger");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("Base_Platform", "Windows-10");
		report.setSystemInfo("Base_URL", "http://localhost:8888");
		report.setSystemInfo("ReporterName", "Harshitha");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		
	}
	
	
	

}
