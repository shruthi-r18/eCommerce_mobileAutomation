package tests;



import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import step_definition.basePage;

public class appFunctions extends baseapp {
	  AndroidDriver driver;
	  basePage bp ;
	@BeforeMethod
	public   void launchApp() throws MalformedURLException {
		
		driver=baseapp.launchApp(driver);
		bp= new basePage(driver);
		
	}
	@Test(priority = 1)
	public   void scrollSwipeFunction() throws InterruptedException {
		Thread.sleep(3000);
		bp.swipe(959,52, driver);
		Thread.sleep(3000);
		bp.swipe(52,959, driver);
		Thread.sleep(3000);
		bp.scroll(1000,50, driver);
	}
	@Test(priority = 2)
	public  void searchProduct() throws InterruptedException {
		Thread.sleep(3000);
		assertTrue(bp.searchProduct(driver),"product should be found");
		
	}
	
	@Test(priority = 2)
	public  void scrollAndSelectFunction() throws InterruptedException {
		Thread.sleep(3000);
		bp.selectSearchProduct(driver);
		
	}
	@Test(priority = 3)
	public   void addProductToCart() throws InterruptedException {
		Thread.sleep(3000);
		bp.selectSearchProduct(driver);
		Thread.sleep(3000);
		assertTrue(bp.addProductToCart(driver),"added to cart button should be clicked");
		Thread.sleep(3000);
		assertTrue(bp.defaultQuantity(driver),"product should be added to cart");
	}
	@Test(priority = 4)
	public  void cancelAddToCart() throws InterruptedException {
		Thread.sleep(3000);
		bp.selectSearchProduct(driver);
		Thread.sleep(3000);
		assertTrue(bp.addProductToCart(driver),"added to cart button should be clicked");
		Thread.sleep(3000);
		assertTrue(bp.cancelAddToCart(driver),"product should not be added to cart");
	}
	@Test(priority = 5)
	public  void UpdateQuantity() throws InterruptedException {
		Thread.sleep(3000);
		bp.selectSearchProduct(driver);
		Thread.sleep(3000);
		assertTrue(bp.addProductToCart(driver),"added to cart button should be clicked");
		Thread.sleep(3000);
		assertTrue(bp.updateQuantity(driver),"product should be added to cart");
	}
	
	@Test(priority = 6)
	public  void addMoreProductsToCart() throws InterruptedException {
//		Thread.sleep(3000);
//		bp.addMoreProductToCart();
		Thread.sleep(3000);
		assertTrue(bp.addProductToCart(driver),"added to cart button should be clicked");
		Thread.sleep(3000);
		assertTrue(bp.defaultQuantity(driver),"product should be added to cart");
		Thread.sleep(3000);
		assertTrue(bp.backToSearchProduct(driver),"product screen should be displayed");
		Thread.sleep(3000);
		bp.addMoreProductToCart(driver);
		Thread.sleep(3000);
		assertTrue(bp.addProductToCart(driver),"added to cart button should be clicked");
		Thread.sleep(3000);
		assertTrue(bp.defaultQuantity(driver),"product should be added to cart");
	}
	@Test(priority = 7)
	public  void viewCart() throws InterruptedException {
		Thread.sleep(3000);
		assertTrue(bp.viewCart(driver)," cart  should be displayed");
		
	}
	@Test(priority = 8)
	public  void updateCart() throws InterruptedException {
		Thread.sleep(3000);
		 assertTrue(bp.updateCart(driver)," Changes in cart  should be done");
	}
	@Test(priority = 10)
	public  void Checkout() throws InterruptedException {
		Thread.sleep(3000);
		assertTrue(bp.checkout(driver)," checkout  should be done");
	}
//	@Test
//	public  void scrollSwipeFunction() {
//		
//	}
}
