package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class OrderSummaryPageObjects {
AppiumDriver driver;
	
	public OrderSummaryPageObjects(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.qwqer.customer:id/order_imageview_expand']")WebElement addressExpandBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/order_textview_sender_address']")WebElement GetSenderAddress;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/order_textview_sender_landmark']")WebElement GetSenderLandmark;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/order_textview_receiver_name']")WebElement GetReceiverName;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/order_textview_receiver_address']")WebElement GetReceiverAddress;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/order_textview_receiver_landmark']")WebElement GetReceiverLandmark;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/order_textview_receiver_phone']")WebElement GetReceiverPhone;
	@FindBy(xpath = "//android.widget.TextView[@text='0 - 5 Kg']")WebElement SelectProductWeight;
	//Image Upload
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.qwqer.customer:id/order_imageview_add_image']")WebElement BrowseImageBtn;
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.qwqer.customer:id/photo_linear_from_camera']")WebElement TakePicFromCamera;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.camera2:id/shutter_button']")WebElement CameraShutterBtn;
	@FindBy(xpath = "//android.widget.ImageButton[@resource-id='com.android.camera2:id/done_button']")WebElement CameraDoneBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/crop_image_menu_crop']")WebElement ImageCropBtn;
	
	//Product Description
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.qwqer.customer:id/order_edittext_item_desc']")WebElement ProductDesc;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.qwqer.customer:id/order_edittext_special_instruction']")WebElement SpclInstruction;
	@FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")WebElement ContinueBtn;
	@FindBy(xpath = "//android.widget.Button[@text='ALLOW']")List<WebElement> allowBtnSize;
	@FindBy(xpath = "//android.widget.Button[@text='ALLOW']")WebElement allowBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")WebElement PermissionallowBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.camera2:id/confirm_button']")WebElement CnfrnNextBtn;
	
	
	//Get Product Details
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/confirm_textview_amount']")WebElement TotalAmount;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/confirm_textview_total']")WebElement AmountAfterDiscount;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/confirm_textview_weight']")WebElement GetProductWeight;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/tvItemCategory']")WebElement GetProductCategory;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/confirm_textview_description']")WebElement GetProductDescription;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/confirm_textview_special_instruction']")WebElement GetSpecialInstruction;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/payment_options_textview_value']")WebElement CashOnPickupBtn;
	@FindBy(xpath = "//android.widget.Button[@text='CONFIRM ORDER']")WebElement CnfrmOrderBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/success_textview_order_id']")WebElement GetOrderId;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.customer:id/success_button_view_order']")WebElement ViewOrderBtn;
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.customer:id/success_button_new_order']")WebElement PlaceNewOrderBtn;
	@FindBy(xpath = "//android.widget.TextView[@text='Your order is successfully placed.']")WebElement OrderSuccessMessage;
	
	//Get distance and Time
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/confirm_textview_distance']")WebElement GetDeliveryDistance;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/confirm_textview_time']")WebElement GetDeliveryTime;
	
	//Order Completed Tab
		@FindBy(xpath = "//android.widget.TextView[@text='Completed']")WebElement CompletedTab;
		
		@FindBy(xpath = "//android.widget.Spinner[@resource-id='com.qwqer.customer:id/spItemCategory']")WebElement DropDownBtn;
		@FindBy(xpath = "//android.widget.TextView[@text='Groceries/Food/Beverages']")WebElement DropDownOption;
		@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.qwqer.customer:id/order_imageview_expand']")WebElement ExpandBtn;
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/track_textview_placed']")WebElement TimeTrack;
	public WebElement addressExpandBtn() {
		return addressExpandBtn;
	}
	public WebElement GetSenderAddress() {
		return GetSenderAddress;
	}
	public WebElement GetSenderLandmark() {
		return GetSenderLandmark;
	}
	public WebElement GetReceiverName() {
		return GetReceiverName;
	}
	public WebElement GetReceiverAddress() {
		return GetReceiverAddress;
	}
	public WebElement GetReceiverLandmark() {
		return GetReceiverLandmark;
	}
	
	public WebElement GetReceiverPhone() {
		return GetReceiverPhone;
	}
	public WebElement SelectProductWeight() {
		return SelectProductWeight;
	}
	
	//Image
	public WebElement BrowseImageBtn() {
		return BrowseImageBtn;
	}
	public WebElement TakePicFromCamera() {
		return TakePicFromCamera;
	}
	public WebElement CameraShutterBtn() {
		return CameraShutterBtn;
	}
	public WebElement CameraDoneBtn() {
		return CameraDoneBtn;
	}
	public WebElement ImageCropBtn() {
		return ImageCropBtn;
	}
	//Product Desc
	public WebElement ProductDesc() {
		return ProductDesc;
	}
	public WebElement SpclInstruction() {
		return SpclInstruction;
	}
	public WebElement ContinueBtn() {
		return ContinueBtn;
	}
	public List<WebElement> AllowBtnSize() {
		return allowBtnSize;
	}
	public WebElement AllowBtn() {
		return allowBtn;
	}
	public WebElement PermissionallowBtn() {
		return PermissionallowBtn;
	}
	public WebElement CnfrnNextBtn() {
		return CnfrnNextBtn;
	}
	//Product Details
	public WebElement TotalAmount() {
		return TotalAmount;
	}
	public WebElement AmountAfterDiscount() {
		return AmountAfterDiscount;
	}
	public WebElement GetProductWeight() {
		return GetProductWeight;
	}
	
	public WebElement GetProductCategory() {
		return GetProductCategory;
	}
	public WebElement GetProductDescription() {
		return GetProductDescription;
	}
	public WebElement GetSpecialInstruction() {
		return GetSpecialInstruction;
	}
	public WebElement CashOnPickupBtn() {
		return CashOnPickupBtn;
	}
	public WebElement CnfrmOrderBtn() {
		return CnfrmOrderBtn;
	}
	
	public WebElement GetOrderId() {
		return GetOrderId;
	}
	public WebElement ViewOrderBtn() {
		return ViewOrderBtn;
	}
	public WebElement PlaceNewOrderBtn() {
		return PlaceNewOrderBtn;
	}
	public WebElement OrderSuccessMessage() {
		return OrderSuccessMessage;
	}
	public WebElement GetDeliveryDistance() {
		return GetDeliveryDistance;
	}

	public WebElement GetDeliveryTime() {
		return GetDeliveryTime;
	}

	public WebElement CompletedTab() {
		return CompletedTab;
	}
	
	public WebElement DropDownBtn() {
		return DropDownBtn;
	}
	
	public WebElement DropDownOption() {
		return DropDownOption;
	}
	public WebElement ExpandBtn() {
		return ExpandBtn;
	}
	
	public WebElement TimeTrack() {
		return TimeTrack;
	}
}
