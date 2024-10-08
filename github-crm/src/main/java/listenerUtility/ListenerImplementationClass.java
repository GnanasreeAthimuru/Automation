package listenerUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseUtility.BaseClass;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class ListenerImplementationClass implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Execution started and Report confguration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("VTIGER CRM");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.STANDARD);
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Execution completed and Report backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"==START");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"==SUCCESS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"==FAILED");
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String dateAndTime=jutil.getCurrentDateAndTimeForSS();
		try {
			wutil.takeScreenshotOfWebPage(BaseClass.sdriver, methodName+"_"+dateAndTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"==SKIPPED");
	}
	
	
}


	
