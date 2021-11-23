package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class DriverApp_PlacedOrderObjects {
	
AppiumDriver driver;
	
	public DriverApp_PlacedOrderObjects(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath = "//android.widget.TextView[@text='My Orders']")WebElement MyOrdersBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.partner:id/confirm_button_accept']")WebElement AcceptOrderBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.partner:id/confirmation_yes_button']")WebElement AcceptConfirmBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.partner:id/confirm_button_pickup']")WebElement PickedUpBtn;
	
	//Product details
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/details_textview_distance']")WebElement PartnerGetDistance;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/details_textview_time_est']")WebElement PartnerGetTime;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/details_textview_time_est']")WebElement PartnerAppFinalAmount;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/details_textview_payment_mode']")WebElement PaymentModeText;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/confirm_textview_weight']")WebElement PartnerGetItemWeight;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/confirm_textview_description']")WebElement PartnerGetItemDesc;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/confirm_textview_special_instruction']")WebElement PartnerGetItemInstruction;
	
	
	//Get sender and receiver details
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/order_textview_sender_name']")WebElement GetSenderName;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/order_textview_sender_phone']")WebElement GetSenderMob;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/order_textview_sender_address']")WebElement GetSenderAddress;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/order_textview_receiver_name']")WebElement GetReceiverName;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/order_textview_receiver_phone']")WebElement GetReceiverNum;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/order_textview_receiver_address']")WebElement GetReceiverAddress;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.partner:id/confirmation_message_textview']")WebElement CnfrmBtnText;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.partner:id/confirm_button_delivered']")WebElement Partner_DeliveredBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.partner:id/confirm_button_undelivered']")WebElement Partner_UnDeliveredBtn;
	
	
	//Enter OTP
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.qwqer.partner:id/otp_edittext_input']")WebElement EnterOTP;
	@FindBy(xpath = "//android.widget.RatingBar[@resource-id='com.qwqer.partner:id/delivery_confirm_ratingbar']")WebElement CustRating;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.partner:id/delivered_button_confirm']")WebElement ConfirmDeliveryBtn;
	
	
	
	
	public WebElement MyOrdersBtn() {
		return MyOrdersBtn;
	}
	
	public WebElement AcceptOrderBtn() {
		return AcceptOrderBtn;
	}
	
	public WebElement AcceptConfirmBtn() {
		return AcceptConfirmBtn;
	}
	
	public WebElement PickedUpBtn() {
		return PickedUpBtn;
	}
	
	public WebElement PartnerGetDistance() {
		return PartnerGetDistance;
	}
	public WebElement PartnerGetTime() {
		return PartnerGetTime;
	}
	public WebElement PartnerAppFinalAmount() {
		return PartnerAppFinalAmount;
	}
	public WebElement PaymentModeText() {
		return PaymentModeText;
	}
	public WebElement PartnerGetItemWeight() {
		return PartnerGetItemWeight;
	}
	public WebElement PartnerGetItemDesc() {
		return PartnerGetItemDesc;
	}
	public WebElement PartnerGetItemInstruction() {
		return PartnerGetItemInstruction;
	}
	public WebElement GetSenderName() {
		return GetSenderName;
	}
	public WebElement GetSenderMob() {
		return GetSenderMob;
	}
	public WebElement GetSenderAddress() {
		return GetSenderAddress;
	}
	public WebElement GetReceiverName() {
		return GetReceiverName;
	}
	public WebElement GetReceiverNum() {
		return GetReceiverNum;
	}
	public WebElement GetReceiverAddress() {
		return GetReceiverAddress;
	}
	
	public WebElement Partner_DeliveredBtn() {
		return Partner_DeliveredBtn;
	}
	
	public WebElement Partner_UnDeliveredBtn() {
		return Partner_UnDeliveredBtn;
	}
	
	public WebElement CnfrmBtnText() {
		return CnfrmBtnText;
	}
	
	public WebElement EnterOTP() {
		return EnterOTP;
	}
	public WebElement CustRating() {
		return CustRating;
	}
	public WebElement ConfirmDeliveryBtn() {
		return ConfirmDeliveryBtn;
	}
	

	
}
