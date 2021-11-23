package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MenuTabObjects {
	AppiumDriver driver;
	
	public MenuTabObjects(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.qwqer.customer:id/map_imageview_hamburger']")WebElement HomeMenuBtn;
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Logout']")WebElement logoutBtn;
	@FindBy(xpath = "//android.widget.Button[@text='Yes']")WebElement logoutCnfrmBtn;
	@FindBy(className = "android.widget.TextView")WebElement CustomerName;
	@FindBy(className = "android.widget.RelativeLayout")WebElement OuterSpace;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.qwqer.customer:id/profile_imageview_back_arrow']")WebElement BackBtn;
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='My Orders']")WebElement MyOrdersBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/details_textview_status']")WebElement GetMyOrdersStatus;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.customer:id/details_button_cancel_order']")WebElement CancelOrderBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.customer:id/confirmation_yes_button']")WebElement CnfrmCancelOrderBtn;
	@FindBy(className = "android.widget.TextView")List <MobileElement> GetOTP;
	//Order Completed Tab
	@FindBy(xpath = "//android.widget.TextView[@text='Completed']")WebElement CompletedTab;
	
	
	public WebElement HomeMenuBtn() {
		return HomeMenuBtn;
	}
	public WebElement LogoutBtn() {
		return logoutBtn;
	}
	public WebElement LogoutCnfrmBtn() {
		return logoutCnfrmBtn;
	}

	public WebElement CustomerName() {
		return CustomerName;
	}
	public WebElement OuterSpace() {
		return OuterSpace;
	}
	public WebElement BackBtn() {
		return BackBtn;
	}
	public WebElement MyOrdersBtn() {
		return MyOrdersBtn;
	}
	public WebElement GetMyOrdersStatus() {
		return GetMyOrdersStatus;
	}
	public WebElement CancelOrderBtn() {
		return CancelOrderBtn;
	}
	public WebElement CnfrmCancelOrderBtn() {
		return CnfrmCancelOrderBtn;
	}
	
	public List <MobileElement> GetOTP() {
		return GetOTP;
	}
	
	public WebElement CompletedTab() {
		return CompletedTab;
	}
	

}
