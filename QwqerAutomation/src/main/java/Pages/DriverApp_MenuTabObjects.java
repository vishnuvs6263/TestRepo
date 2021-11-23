package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class DriverApp_MenuTabObjects {
	AppiumDriver driver;
	
	public DriverApp_MenuTabObjects(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.qwqer.partner:id/imageview_hamburger']")WebElement HomeMenuBtn;
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Logout']")WebElement logoutBtn;
	@FindBy(xpath = "//android.widget.Button[@text='Yes']")WebElement logoutCnfrmBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/drawer_header_title']")WebElement DriverName;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.qwqer.partner:id/profile_edittext_fullname']")WebElement GetDriverNameField;
	@FindBy(className = "android.widget.RelativeLayout")WebElement OuterSpace;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.qwqer.partner:id/profile_imageview_back_arrow']")WebElement BackBtn;
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='My Orders']")WebElement MyOrdersBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/details_textview_status']")WebElement GetMyOrdersStatus;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.customer:id/details_button_cancel_order']")WebElement CancelOrderBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.customer:id/confirmation_yes_button']")WebElement CnfrmCancelOrderBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/drawer_header_subtitle']")WebElement GetDriverId;
	
	public WebElement HomeMenuBtn() {
		return HomeMenuBtn;
	}
	public WebElement LogoutBtn() {
		return logoutBtn;
	}
	public WebElement LogoutCnfrmBtn() {
		return logoutCnfrmBtn;
	}

	public WebElement DriverName() {
		return DriverName;
	}
	
	public WebElement GetDriverNameField() {
		return GetDriverNameField;
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
	public WebElement GetDriverId() {
		return GetDriverId;
	}
}
