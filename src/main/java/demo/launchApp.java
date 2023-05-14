package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class launchApp {
	static AndroidDriver driver;
	public static void swipe(int x, int x1, AndroidDriver driver) {
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(x, 800)).waitAction().moveTo(PointOption.point(x1, 800)).release().perform();
	}
	public static void scroll(int y, int y1, AndroidDriver driver) {
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(400,y)).waitAction().moveTo(PointOption.point(400,y1)).release().perform();
	}
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//AppiumDriver driver; when you want to use  both android and ios in your framework
		
		URL appiumServer = new URL("http://0.0.0.0:4723/wd/hub");
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "8");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("appPackage", "com.solodroid.solomerce");
		dc.setCapability("appActivity",".activities.ActivitySplash");
//		dc.setCapability("unlockType","pin");
//		dc.setCapability("unlockPin","2012");
//		
        driver = new AndroidDriver(appiumServer, dc);
//        if(driver.isDeviceLocked()) {
//     	   driver.unlockDevice();
//        }
        System.out.println("App Launched");
        Thread.sleep(5000);
//        Activity newSms =new Activity("com.samsung.android.messaging","ui.WithActivity");
//        driver.startActivity(newSms);
//        Thread.sleep(5000);
//        driver.navigate().back();
        
//        launchApp.swipe(959,52, driver);
//        launchApp.swipe(52,959, driver);
//        launchApp.scroll(1000,50, driver);
        driver.findElement(ByAndroidUIAutomator.AndroidUIAutomator("new UiScrollable(new UiSelector()"
        		+ ".resourceId(\"com.solodroid.solomerce:id/recycler_view\")).flingToEnd(1)."
        		+ "scrollIntoView(new UiSelector().text(\"Animal Jumpsuit for Newborn Baby\"))")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().resourceId(\"com.solodroid.solomerce:id/btn_add_cart\")")).click();
        
        Thread.sleep(5000);
        driver.findElement(ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().resourceId(\"com.solodroid.solomerce:id/userInputDialog\")")).sendKeys("1");
        
        Thread.sleep(5000);
        driver.findElement(ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")")).click();
        driver.findElement(ByAndroidUIAutomator.AndroidUIAutomator("new UiSelector().resourceId(\"Navigate up\")")).click();
//       frame  android:id/content
        driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
        driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("Mini Digital Speaker");
       driver.hideKeyboard();
       System.out.println("selected item should be displayed");
//       
//       if(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)) {
//    	   driver.rotate(ScreenOrientation.PORTRAIT);
//       }
//        
//       
        
	}

}
