package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.offset.PointOption;

public class OrderPlacementPageObjects {
AppiumDriver driver;
	
	public OrderPlacementPageObjects(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath = "//android.widget.TextView[@text='Pickup at …']")WebElement pickupAddField;
	@FindBy(xpath = "//android.widget.TextView[@text='Deliver to …']")WebElement deliverAddField;
	@FindBy(xpath = "//android.widget.EditText[@text='Search places']")WebElement searchPlacesField;
	@FindBy(xpath = "//android.widget.TextView[@text='Pettah']")WebElement SearchedAddressSelectPickup;
	@FindBy(xpath = "//android.widget.TextView[@text='Kazhakkoottam']")WebElement SearchedAddressSelectDelivery;
	@FindBy(xpath = "//android.widget.EditText[@text='House No./Street Name(Eg. 24B, Sastri Lange)']")WebElement DetailAddressField;
	@FindBy(xpath = "//android.widget.EditText[@text='Landmark']")WebElement LandmarkField;
	@FindBy(xpath = "//android.widget.CheckBox[@text='Save this address']")WebElement SaveAddressCheckBox;
	@FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")WebElement ContinueBtn;
	@FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")List <WebElement> ContinueBtnSize;
	@FindBy(xpath = "//android.widget.EditText[@text='Name']")WebElement DeliveryCustName;
	@FindBy(xpath = "//android.widget.EditText[@text='Phone']")WebElement DeliveryCustMob;
	//Home page live tracking button
	@FindBy(xpath = "//android.widget.Button[@resource-id='com.qwqer.customer:id/btTrackOrder']")List<WebElement> TrackNowBtn;
//Map elements 
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='My Location']")PointOption MapLocation;
	@FindBy(className = "android.view.View")PointOption MapMarker;
	
	
	public WebElement PickAddressField() {
		return pickupAddField;
	}
	public WebElement DeliverAddressField() {
		return deliverAddField;
	}
	public WebElement SearchPlacesField() {
		return searchPlacesField;
	}
	public WebElement SearchedAddressSelectPickup() {
		return SearchedAddressSelectPickup;
	}
	public WebElement SearchedAddressSelectDelivery() {
		return SearchedAddressSelectDelivery;
	}
	public WebElement DetailAddressField() {
		return DetailAddressField;
	}
	public WebElement LandmarkField() {
		return LandmarkField;
	}
	public WebElement SaveAddressCheckBox() {
		return SaveAddressCheckBox;
	}
	public WebElement ContinueBtn() {
		return ContinueBtn;
	}
	public WebElement DeliveryCustName() {
		return DeliveryCustName;
	}
	public WebElement DeliveryCustMob() {
		return DeliveryCustMob;
	}
	
	public List<WebElement> TrackNowBtn() {
		return TrackNowBtn;
	}
	
	public PointOption MapLocation() {
		return MapLocation;
	}
	public List<WebElement> ContinueBtnSize() {
		return ContinueBtnSize;
	}

	
	public PointOption MapMarker() {
		return MapMarker;
	}
}
