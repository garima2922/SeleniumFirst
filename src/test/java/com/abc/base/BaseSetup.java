package com.abc.base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.abc.utils.CaptureScreenshots;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseSetup {
	public WebDriver driver;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	//static Logger logger =LogManager.getLogger(BaseSetup.class.getName());

	@BeforeSuite
	public void initialiseReport() {
		
		ExtentSparkReporter extsprak = new ExtentSparkReporter("report.html"); // child
		extsprak.config().setReportName("Abc Project");
		extsprak.config().setTheme(Theme.DARK);
		extsprak.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
		extentReport = new ExtentReports();
		extentReport.attachReporter(extsprak);
		
	}

	@AfterSuite
	public void generateReport() {
		extentReport.flush();
	}

	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser, ITestContext context) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		//logger.info("launching the browser");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		extentTest = extentReport.createTest(context.getName());
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
		driver = null;
		//logger.info("closing browser");
	}

	@AfterMethod
	public void failedCapture(Method m, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = null;
			screenshotPath = CaptureScreenshots.captureScreenshot(result.getMethod().getMethodName(), driver);
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(result.getThrowable());
		}
	}

}
