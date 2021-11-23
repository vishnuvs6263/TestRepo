package TestFunctions;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Pages.LoginPageObjects;
import Pages.MenuTabObjects;
import Pages.OrderPlacementPageObjects;
import Pages.OrderSummaryPageObjects;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class QWQER_SC_003_Customer_VerifyDeliveredOrderStatus extends BaseClass {
	public static WebDriverWait wait;
	public static TouchActions Actions;
	public static String senderAddressActual = null;
	public static String senderLandmarkActual = null;
	public static String ReceiverNameActual = null;
	public static String ReceiverMobActual = null;
	public static String ReceiverAddressActual = null;
	public static String ReceiverLandmarkActual = null;
	public static String CountryCode = null;
	public static String stringvalueofTotalAmount = null;
	public static String stringvalueofFinalAmount = null;
	public static double ActualTotalAmount = 0;
	public static double ActualFinalAmountAfterDiscount = 0;
	public static String SelectedProductWeight = null;
	public static String OrderID;
	public static MobileElement element;
	public static double ActualDistance = 0;
	public static String ActualTime = null;
	public static String OTP = null;

	@Parameters({ "platformName", "PlatFormVersion", "udid", "deviceName", "AVD", "appPackage", "appActivity" })
	@BeforeClass
	public void Login(String platformName, String PlatFormVersion, String udid, String deviceName, String AVD,
			String appPackage, String appActivity) throws MalformedURLException, InterruptedException {
		BaseClass base = new BaseClass();
		base.initializeDriver(platformName, PlatFormVersion, udid, deviceName, AVD, appPackage, appActivity);
		wait = new WebDriverWait(driver, 40);
		LoginPageObjects objects = new LoginPageObjects(driver);
		if (objects.AllowBtnSize().size() > 0) {
			objects.AllowBtn().click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(objects.NoneoftheaboveBtn()));
		objects.NoneoftheaboveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.UsernameField()));
		objects.UsernameField().sendKeys(prop.getProperty("userMobNum"));
		driver.hideKeyboard();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Password()));
		objects.Password().sendKeys(prop.getProperty("Password"));
		driver.hideKeyboard();
		objects.LoginBtn().click();
	}

	// Verify the login
	@Test(priority = 1)
	public void VerifyDeliveredOrderDetails() throws InterruptedException {
		MenuTabObjects objects = new MenuTabObjects(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.ImageView[@resource-id='com.qwqer.customer:id/map_imageview_hamburger']")));
		objects.HomeMenuBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.MyOrdersBtn()));
		objects.MyOrdersBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CompletedTab()));
		objects.CompletedTab().click();
		Thread.sleep(5000);
		String OrderIdPrefix = "Order: #";
		String fullXpath = "//android.widget.TextView[@text='" + OrderIdPrefix + QWQER_SC_001_Customer_PlaceOrder.OrderID + "']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fullXpath)));
		driver.findElement(By.xpath(fullXpath)).click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.GetMyOrdersStatus()));
		String finalOrderStatus = objects.GetMyOrdersStatus().getText();
		if (finalOrderStatus.contentEquals("Delivered")) {
			Assert.assertEquals(finalOrderStatus,"Delivered");
			System.out.println("The delivery of the producted is successfully completed ");
					
		} else {
			Assert.fail();
		}
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();
	}
	
	@Test(priority = 2)
	public void AddPicupAddressDetails() throws InterruptedException {
		OrderPlacementPageObjects objects = new OrderPlacementPageObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.PickAddressField()));
		objects.PickAddressField().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SearchPlacesField()));
		objects.SearchPlacesField().sendKeys(prop.getProperty("PickupSpot"));
		wait.until(ExpectedConditions.elementToBeClickable(objects.SearchedAddressSelectPickup()));
		objects.SearchedAddressSelectPickup().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DetailAddressField()));
		objects.DetailAddressField().sendKeys(prop.getProperty("SenderAddress"));
		objects.LandmarkField().sendKeys(prop.getProperty("SenderLandMark"));
		objects.SaveAddressCheckBox().click();
		objects.ContinueBtn().click();

	}

	@Test(priority = 3)
	public void AddDeliveryAddressDetails() throws InterruptedException {
		OrderPlacementPageObjects objects = new OrderPlacementPageObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.DeliverAddressField()));
		objects.DeliverAddressField().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.SearchPlacesField()));
		objects.SearchPlacesField().sendKeys(prop.getProperty("ReceiverSpot"));
		wait.until(ExpectedConditions.elementToBeClickable(objects.SearchedAddressSelectDelivery()));
		objects.SearchedAddressSelectDelivery().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DeliveryCustName()));
		objects.DeliveryCustName().sendKeys(prop.getProperty("ReceiverCustName"));
		objects.DeliveryCustMob().sendKeys(prop.getProperty("ReceiverCustMobNum"));
		objects.DetailAddressField().sendKeys(prop.getProperty("ReceiverDetailAddress"));
		objects.LandmarkField().sendKeys(prop.getProperty("ReceiverLandMark"));
		objects.SaveAddressCheckBox().click();
		objects.ContinueBtn().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.ContinueBtn()));
		objects.ContinueBtn().click();

	}

	@Test(priority = 4)
	public void AddProductDetails() throws InterruptedException {
		OrderSummaryPageObjects objects = new OrderSummaryPageObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.SelectProductWeight()));
		objects.SelectProductWeight().click();
		objects.BrowseImageBtn().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(objects.TakePicFromCamera()));
		objects.TakePicFromCamera().click();
		Thread.sleep(3000);

		if (objects.AllowBtnSize().size() > 0) {
			objects.AllowBtn().click();
			objects.AllowBtn().click();

		}
		Thread.sleep(3000);
		// wait.until(ExpectedConditions.elementToBeClickable(objects.PermissionallowBtn()));
		// objects.PermissionallowBtn().click();
		// wait.until(ExpectedConditions.elementToBeClickable(objects.CnfrnNextBtn()));
		// objects.CnfrnNextBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CameraShutterBtn()));
		objects.CameraShutterBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CameraDoneBtn()));
		objects.CameraDoneBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ImageCropBtn()));
		objects.ImageCropBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ProductDesc()));
		objects.ProductDesc().sendKeys(prop.getProperty("ProductDescription"));
		objects.SpclInstruction().sendKeys(prop.getProperty("SpecialInstruction"));
		objects.ContinueBtn().click();
	}

	@Test(priority = 5)
	public void VerifySenderDetails() throws InterruptedException {
		OrderSummaryPageObjects objects = new OrderSummaryPageObjects(driver);
		// Verify Sender Address
		wait.until(ExpectedConditions.elementToBeClickable(objects.TotalAmount()));
		senderAddressActual = objects.GetSenderAddress().getText();
		if (senderAddressActual.contains(prop.getProperty("SenderAddress"))) {
			Assert.assertTrue(senderAddressActual.contains(prop.getProperty("SenderAddress")));
			System.out.println("The product has to be picked up from the Address : " + senderAddressActual);
		} else {
			Assert.fail();
		}
		// Verify Reciever Address
		senderLandmarkActual = objects.GetSenderLandmark().getText();
		if (senderLandmarkActual.contains(prop.getProperty("SenderLandMark"))) {
			Assert.assertTrue(senderLandmarkActual.contains(prop.getProperty("SenderLandMark")));
			System.out.println(
					"The product has to be picked up from the Address with landmark : " + senderLandmarkActual);
		} else {
			Assert.fail();
		}
	}

	@Test(priority = 6)
	public void VerifyReceiverDetails() throws InterruptedException {
		OrderSummaryPageObjects objects = new OrderSummaryPageObjects(driver);
		// Verify Receiver Name
		wait.until(ExpectedConditions.elementToBeClickable(objects.TotalAmount()));
		ReceiverNameActual = objects.GetReceiverName().getText();
		if (ReceiverNameActual.equals(prop.getProperty("ReceiverCustName"))) {
			Assert.assertEquals(ReceiverNameActual, prop.getProperty("ReceiverCustName"));
			System.out.println("The product has to be picked up from the person : " + ReceiverNameActual);
		} else {
			Assert.fail();
		}
		// Verify Receiver Mobile Number
		wait.until(ExpectedConditions.elementToBeClickable(objects.TotalAmount()));
		ReceiverMobActual = objects.GetReceiverPhone().getText();
		String ReceiverMobNumber = ReceiverMobActual.substring(ReceiverMobActual.lastIndexOf("1") + 1);
		System.out.println(ReceiverMobNumber);
		if (ReceiverMobNumber.equals(prop.getProperty("ReceiverCustMobNum"))) {
			Assert.assertEquals(ReceiverMobNumber, (prop.getProperty("ReceiverCustMobNum")));
			System.out.println(
					"The product has to be picked up from the customer with mob number : " + ReceiverMobNumber);
		} else {
			Assert.fail();
		}
		// Verify Reciever Address
		wait.until(ExpectedConditions.elementToBeClickable(objects.TotalAmount()));
		ReceiverAddressActual = objects.GetReceiverAddress().getText();
		if (ReceiverAddressActual.contains(prop.getProperty("ReceiverDetailAddress"))) {
			Assert.assertTrue(ReceiverAddressActual.contains(prop.getProperty("ReceiverDetailAddress")));
			System.out.println("The product has to be picked up from the Address : " + ReceiverAddressActual);
		} else {
			Assert.fail();
		}
		// Verify Reciever Address
		ReceiverLandmarkActual = objects.GetReceiverLandmark().getText();
		if (ReceiverLandmarkActual.contains(prop.getProperty("ReceiverLandMark"))) {
			Assert.assertTrue(ReceiverLandmarkActual.contains(prop.getProperty("ReceiverLandMark")));
			System.out.println(
					"The product has to be picked up from the Address with landmark : " + ReceiverLandmarkActual);
		} else {
			Assert.fail();
		}

	}

	@Test(priority = 7)
	public void VerifyProductDetails() throws InterruptedException {
		OrderSummaryPageObjects objects = new OrderSummaryPageObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.TotalAmount()));
		stringvalueofTotalAmount = objects.TotalAmount().getText();
		ActualTotalAmount = StringHelper.getDoubleValue(stringvalueofTotalAmount);
		stringvalueofFinalAmount = objects.AmountAfterDiscount().getText();
		ActualFinalAmountAfterDiscount = StringHelper.getDoubleValue(stringvalueofFinalAmount);
		String Distance = objects.GetDeliveryDistance().getText();
		String ActualDistanceText = Distance.substring(Distance.lastIndexOf(": ") + 1);
		String ActualDistanceSpace = ActualDistanceText.substring(0, ActualDistanceText.lastIndexOf(" ") + 1);
		String ActDist = ActualDistanceSpace.substring(0, ActualDistanceSpace.lastIndexOf(" ") + 1);
		ActualDistance = StringHelper.getDoubleValue(ActDist);
		String GetActualTime = objects.GetDeliveryTime().getText();
		ActualTime = GetActualTime.substring(0, GetActualTime.indexOf(" ") + 1);
		String visibleText = "CONFIRM ORDER";
		element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))"));
//Perform the action on the element
		element.click();

//Perform the action on the element
		wait.until(ExpectedConditions.elementToBeClickable(objects.CnfrmOrderBtn()));

		// Verify the product weight
		String ActualProductWeight = objects.GetProductWeight().getText();
		SelectedProductWeight = objects.SelectProductWeight().getText();
		if (ActualProductWeight.equals(SelectedProductWeight)) {
			Assert.assertEquals(ActualProductWeight, SelectedProductWeight);
			System.out.println("The actual weight of the product is " + ActualProductWeight);
		} else {
			Assert.fail();
		}

		// Verify the product description
		String ActualProductDesc = objects.GetProductDescription().getText();
		if (ActualProductDesc.equals(prop.getProperty("ProductDescription"))) {
			Assert.assertEquals(ActualProductDesc, prop.getProperty("ProductDescription"));
			System.out.println("The actual description of the product is " + ActualProductDesc);
		} else {
			Assert.fail();
		}
		// Verify the product description
		String ActualSpclInstruction = objects.GetSpecialInstruction().getText();
		if (ActualSpclInstruction.equals(prop.getProperty("SpecialInstruction"))) {
			Assert.assertEquals(ActualSpclInstruction, prop.getProperty("SpecialInstruction"));
			System.out.println("The actual description of the product is " + ActualSpclInstruction);
		} else {
			Assert.fail();
		}

	}

	@Test(priority = 8)
	public void PlaceOrder() throws InterruptedException {
		OrderSummaryPageObjects objects = new OrderSummaryPageObjects(driver);
		objects.CashOnPickupBtn().click();
		objects.CnfrmOrderBtn().click();
		String date_time = driver.getDeviceTime("dd-mm-yyyy");
		System.out.println(date_time);
		wait.until(ExpectedConditions.elementToBeClickable(objects.ViewOrderBtn()));
		OrderID = objects.GetOrderId().getText();
		// Verify the message
		String successmessage = "Your order is successfully placed.";
		String ActualMessage = objects.OrderSuccessMessage().getText();
		if (ActualMessage.equals(successmessage)) {
			Assert.assertEquals(ActualMessage, successmessage);
			System.out.println("Your order " + OrderID + " is successfully placed");
		} else {
			Assert.fail();
		}
		objects.PlaceNewOrderBtn().click();

	}



	@Test(priority = 9)
	public void CancelPlacedOrder() throws InterruptedException {
		MenuTabObjects objects = new MenuTabObjects(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.ImageView[@resource-id='com.qwqer.customer:id/map_imageview_hamburger']")));
		objects.HomeMenuBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.MyOrdersBtn()));
		objects.MyOrdersBtn().click();
		String OrderIdPrefix = "Order: #";
		String fullXpath = "//android.widget.TextView[@text='" + OrderIdPrefix + OrderID + "']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fullXpath)));
		driver.findElement(By.xpath(fullXpath)).click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.GetMyOrdersStatus()));
		String visibleText = "CANCEL ORDER";
		element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))"));

		wait.until(ExpectedConditions.elementToBeClickable(objects.CancelOrderBtn()));
		objects.CancelOrderBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.CnfrmCancelOrderBtn()));
		objects.CnfrmCancelOrderBtn().click();
		// Verify Cancelled Status
		String updatedStatus = "Cancelled";
		element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ updatedStatus + "\").instance(0))"));
		wait.until(ExpectedConditions.elementToBeClickable(objects.GetMyOrdersStatus()));
		String currentorderStatus = objects.GetMyOrdersStatus().getText();
		if (updatedStatus.equals(currentorderStatus)) {
			Assert.assertEquals(updatedStatus, currentorderStatus);
			System.out.println("The order id : " + OrderID + " is successfully cancelled by the customer");
			driver.navigate().back();
		} else {
			Assert.fail();
		}

	}

	@Test(enabled = false)
	public void Logout() throws MalformedURLException, InterruptedException {
		MenuTabObjects objects = new MenuTabObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeMenuBtn()));
		objects.HomeMenuBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.LogoutBtn()));
		objects.LogoutBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.LogoutCnfrmBtn()));
		objects.LogoutCnfrmBtn().click();
		driver.navigate().back();
	}

	
}
