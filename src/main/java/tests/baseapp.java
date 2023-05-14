package tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class baseapp {

	public static ThreadLocal<AndroidDriver> threadlocaldriver = new ThreadLocal<AndroidDriver>();
	protected static ExtentReports extent = new ExtentReports();
	protected static ExtentHtmlReporter report = null;
	public static ExtentTest test = null;
	protected static Logger logger = LogManager.getLogger("");
	
	@BeforeSuite
	public void setup() {
		logger.debug("baseTest: setup  report configuration started");
		String sFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		 String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+sFileNamePrefix+"_SFDC.html";
		 report = new ExtentHtmlReporter(filePath);
		 extent.attachReporter(report);
		 logger.debug("baseTest: setup  report configuration completed");
			}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
		logger.debug("baseTest: tearDown  complete");
	}

//	@BeforeMethod
//	public void setDriver( AndroidDriver driver) throws MalformedURLException {
//		 driver = baseapp.launchApp(driver);
//		logger.debug("baseTest: setDriver  driver congiguration complete");
//		threadlocaldriver.set(driver);
//		logger.debug("baseapp: setDriver  driver saved on to threadlocal object");
//		//baseapp.test = extent.createTest(name.getName());
////		logger.debug("baseTest: setDriver  test object created");
//	}

	public static WebDriver getdriver() {
		logger.debug("baseTest: getdriver driver configuratin retrieved from the thread");
		return threadlocaldriver.get();
	}
@AfterMethod
	public void removeDriver() {
	//baseapp.getdriver().close();
		threadlocaldriver.remove();
		logger.debug("baseTest: removeDriver  driver congiguration removed from thread");
	}
	public  static AndroidDriver launchApp(AndroidDriver driver) throws MalformedURLException {
		URL appiumServer = new URL("http://0.0.0.0:4723/wd/hub");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "8");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("appPackage", "com.solodroid.solomerce");
		dc.setCapability("appActivity", ".activities.ActivitySplash");
//	dc.setCapability("unlockType","pin");
//	dc.setCapability("unlockKey","2012");
//	
		driver = new AndroidDriver(appiumServer, dc);
		threadlocaldriver.set(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
