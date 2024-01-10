package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides Implementation to IListeners interface of testNG
 * @author Vikas 
 *
 */
public class ListenersImplementationClass implements ITestListener{

	 ExtentReports report;
	 ExtentTest test;
	 
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== test script exicution started====");
	
		// creeate a test script - recognise 
		 test = report.createTest(testScriptName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Passed ====");
		
		//log the success
		test.log(Status.PASS,testScriptName+" == Pass ==" );
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ScreenShot
		//Exception for failure 
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Failed ====");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		// log for failure
		test.log(Status.FAIL, testScriptName+" ==Fail ==");
		test.log(Status.INFO,result.getThrowable());
		
		// ScreenShot
		String screenshotName=testScriptName + new JavaUtility().getSystemDate();
		
		WebDriverUtility w = new WebDriverUtility();
		try {
			
			String path = w.captureScreenShot(BaseClass.sdriver, screenshotName);
		 test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+" ==== Skipped ====");
		
		//Exception for failure
				System.out.println(result.getThrowable());
			
		// log for skip
				test.log(Status.SKIP, testScriptName+"== Skipped == ");
				test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite execution started =====");
		
		//Basic Report Configuration // Report-31-12-2023-08-04-20.html
		 ExtentSparkReporter html = new ExtentSparkReporter(".//ExtentReports//Report-"+ new JavaUtility().getSystemDate()+".html" );
		 html.config().setTheme(Theme.DARK);
		 html.config().setDocumentTitle("Execution Report");
		 html.config().setReportName("Vtiger execution Report");
		 
		 report = new ExtentReports();
		 report.attachReporter(html);
		 report.setSystemInfo("Base Browser", " Edge");
		 report.setSystemInfo("Base plateform", "windows");
		 report.setSystemInfo("Base Environment", "Testing");
		 report.setSystemInfo("Reporter Name", "Vikas");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite Execution Finished ====");
		//Report generation
		report.flush();
		
		
	}

	
}
