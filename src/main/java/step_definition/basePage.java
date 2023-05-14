package step_definition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class basePage {

	public basePage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".resourceId(\"com.solodroid.solomerce:id/recycler_view\")).flingToEnd(1)."
			+ "scrollIntoView(new UiSelector().text(\"Animal Jumpsuit for Newborn Baby\"))")
	public   WebElement product_01;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Animal Jumpsuit for Newborn Baby\")")
	public WebElement product_jumpsuit;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.solodroid.solomerce:id/btn_add_cart\")")
	public   WebElement addToCart;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.solodroid.solomerce:id/userInputDialog\")")
	public   WebElement numberOfItems;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public   WebElement saveItem;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
	public   WebElement cancelItem;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	public   WebElement backButton;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()"
			+ ".resourceId(\"com.solodroid.solomerce:id/recycler_view\")).flingToEnd(1)."
			+ "scrollIntoView(new UiSelector().text(\"Robot Vacuum Cleaner Wellcomm Home 2.0\"))")
	public   WebElement product_add;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"My Cart\"])[2]")
	public   WebElement viewCart;
 
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Search…\"]")
	public  WebElement searchButton;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/search_src_text")
	public WebElement searchTextBox;
	
@AndroidFindBy(uiAutomator = "new UiSelector().text(\"CHECKOUT\")")
public WebElement checkout;

@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.solodroid.solomerce:id/edt_name\")") 
public WebElement checkout_name;

@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.solodroid.solomerce:id/edt_email\")")  
public WebElement checkout_email;

@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.solodroid.solomerce:id/edt_phone\")")  
public WebElement checkout_phone;

@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.solodroid.solomerce:id/edt_address\")")  
public WebElement checkout_address;

@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.solodroid.solomerce:id/btn_submit_order\")")   
public WebElement processCheckout ;

	

	public   void swipe(int x, int x1, AndroidDriver driver) {
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(x, 800)).waitAction().moveTo(PointOption.point(x1, 800)).release().perform();
	}

	public   void scroll(int y, int y1, AndroidDriver driver) {
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(400, y)).waitAction().moveTo(PointOption.point(400, y1)).release().perform();
	}

	public   void changeOrientationPotrait(AndroidDriver driver) {
		if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)) {
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
	}

	public   void unlockDevice(AndroidDriver driver) {
		if (driver.isDeviceLocked()) {
			driver.unlockDevice();
		}
	}
	public boolean searchProduct(AndroidDriver driver) {
		boolean isFound=false;
		if(searchButton.isDisplayed()) {
			searchButton.click();
			searchTextBox.sendKeys("Mini Digital Speaker");
			driver.hideKeyboard();
			isFound=true;
			
		}else {
			System.out.println("Search button not displayed");
		}
		return isFound;
	}

	public   void selectSearchProduct(AndroidDriver driver) {
		product_01.click();
	}

	public   boolean addProductToCart(AndroidDriver driver) {
		boolean isClicked = false;
		if (addToCart.isDisplayed()) {
			addToCart.click();
			isClicked = true;
		} else {
			System.out.println("Add to cart button not displayed");
		}
		return isClicked;
	}

	public   boolean defaultQuantity(AndroidDriver driver) throws InterruptedException {
		boolean isDone = false;
		if (numberOfItems.isDisplayed()) {
			numberOfItems.sendKeys("1");
			if (saveItem.isDisplayed()) {
				saveItem.click();
				isDone = true;
			} else {
				System.out.println("Add button is not displayed");
			}
		} else {
			System.out.println("quantity fiels is not displayed");
		}
		return isDone;
	}

	public   boolean updateQuantity(AndroidDriver driver) throws InterruptedException {
		boolean isDone = false;
		if (numberOfItems.isDisplayed()) {
			numberOfItems.sendKeys("4");
			if (saveItem.isDisplayed()) {
				saveItem.click();
				isDone = true;
			} else {
				System.out.println("Add button is not displayed");
			}
		} else {
			System.out.println("quantity fiels is not displayed");
		}
		return isDone;
	}

	public   boolean cancelAddToCart(AndroidDriver driver) {
		boolean isClicked = false;
		if (cancelItem.isDisplayed()) {
			cancelItem.click();
			isClicked = true;
		} else {
			System.out.println("cancel button not displayed");
		}
		return isClicked;

	}

	public   boolean backToSearchProduct(AndroidDriver driver) {
		boolean isClicked = false;
		if (backButton.isDisplayed()) {
			backButton.click();
			isClicked = true;
		} else {
			System.out.println("back button not displayed");
		}
		return isClicked;

	}

	public   void addMoreProductToCart(AndroidDriver driver) {
		product_add.click();
	}

	public   boolean viewCart(AndroidDriver driver) {
		boolean isClicked = false;
		if (viewCart.isDisplayed()) {
			viewCart.click();
			isClicked = true;
		} else {
			System.out.println("cart button not displayed");
		}
		return isClicked;
	}
	public   boolean updateCart(AndroidDriver driver) {
		boolean isDone= true;
		if(processCheckout.isDisplayed()) {
			checkout_name.clear();
			checkout_name.sendKeys("George");
			checkout_email.clear();
			checkout_email.sendKeys("george@gmail.com");
			checkout_phone.clear();
			checkout_phone.sendKeys("423-432-8765");
			checkout_address.clear();
			checkout_address.sendKeys("Happy shopping lane, ca ");
			processCheckout.click();
		}else {
			isDone=false;
			System.out.println("process checkout button not displayed");
		}
return isDone;
	}

	public   boolean checkout(AndroidDriver driver) {
		return true;
	}

	public   boolean category(AndroidDriver driver) {
		return true;// go to category select something
	}

	public   boolean help(AndroidDriver driver) {
		return true;// go to help select something
	}

	public   boolean profile(AndroidDriver driver) {
		return true;// go to profile select something
	}
}
