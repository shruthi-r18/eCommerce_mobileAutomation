package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class launchGoogleApp {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver driver;
		URL appiumServer = new URL("http://0.0.0.0:4723/wd/hub");
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "8");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("appPackage", "com.costco.app.android");
		dc.setCapability("appActivity",".ui.main.MainActivity");
		 driver = new AndroidDriver(appiumServer, dc);
		 System.out.println("App Launched");
	        //Thread.sleep(5000);
	        
	}

}
