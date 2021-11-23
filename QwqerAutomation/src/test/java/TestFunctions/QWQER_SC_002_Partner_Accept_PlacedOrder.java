package TestFunctions;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Common.BaseClass;
import Common.StringHelper;
import Pages.DriverApp_LoginPageObjects;
import Pages.DriverApp_MenuTabObjects;
import Pages.DriverApp_PlacedOrderObjects;
import Pages.LoginPageObjects;
import Pages.MenuTabObjects;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class QWQER_SC_002_Partner_Accept_PlacedOrder extends BaseClass {
	public static WebDriverWait wait;
	public static MobileElement element;
	public static String pickedupstatus = null;
	public static String DriverID = null;

	@Parameters({ "platformName", "PlatFormVersion", "udid", "deviceName", "AVD", "appPackage", "appActivity" })
	@BeforeClass
	public void DriverLogin(String platformName, String PlatFormVersion, String udid, String deviceName, String AVD,
			String appPackage, String appActivity) throws MalformedURLException, InterruptedException {
		BaseClass base = new BaseClass();
		base.initializeDriver(platformName, PlatFormVersion, udid, deviceName, AVD, appPackage, appActivity);
		wait = new WebDriverWait(driver, 40);
		DriverApp_LoginPageObjects objects = new DriverApp_LoginPageObjects(driver);
		if (objects.AllowBtnSize().size() > 0) {
			objects.AllowBtn().click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(objects.NoneoftheaboveBtn()));
		objects.NoneoftheaboveBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.UsernameField()));
		objects.UsernameField().sendKeys(prop.getProperty("DriveruserMobNum"));
		// driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Password()));
		objects.Password().sendKeys(prop.getProperty("DriverPassword"));
		driver.hideKeyboard();
		objects.LoginBtn().click();
	}

	// Verify the login
	@Test(priority = 1)
	public void DriverVerifyLogin() throws InterruptedException {
		DriverApp_MenuTabObjects objects = new DriverApp_MenuTabObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.HomeMenuBtn()));
		objects.HomeMenuBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.DriverName()));
		String DriverIDRawData = objects.GetDriverId().getText();
		DriverID = DriverIDRawData.substring(DriverIDRawData.lastIndexOf("#") + 1);
		objects.DriverName().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.GetDriverNameField()));
		String ActualDriverName = objects.GetDriverNameField().getText();
		if (ActualDriverName.contentEquals(prop.getProperty("DriverUserName"))) {
			Assert.assertEquals(ActualDriverName,
					prop.getProperty("DriverUserName", "Verify partner login executed and passed successfully"));
			System.out.println("User " + ActualDriverName + " has signed in to the application successfully");
			objects.BackBtn().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.HomeMenuBtn()));

		} else {
			Assert.fail("Verification failed");
			System.out.println("Login verification failed");
		}
	}

	// Verify the login
	@Test(priority = 2)
	public void DriverVerifyPlacedOrderDetails() throws InterruptedException {
		try {
			DriverApp_PlacedOrderObjects objects = new DriverApp_PlacedOrderObjects(driver);
			wait.until(ExpectedConditions.elementToBeClickable(objects.MyOrdersBtn()));
			driver.findElement(By.xpath(
					"//android.widget.TextView[@text='Order: #" + QWQER_SC_001_Customer_PlaceOrder.OrderID + "']"))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.PartnerGetDistance()));
			String getDistance = objects.PartnerGetDistance().getText();
			String ActualDistPartnerAppString = getDistance.substring(0, getDistance.indexOf(" ") + 1);
			double ActualDistPartnerApp = StringHelper.getDoubleValue(ActualDistPartnerAppString);
			String getTime = objects.PartnerGetTime().getText();
			String ActualTimePartnerApp = getTime.substring(0, getTime.indexOf(" ") + 1);
			// Verify the distance
			if (ActualDistPartnerApp == (QWQER_SC_001_Customer_PlaceOrder.ActualDistance)) {
				Assert.assertEquals(QWQER_SC_001_Customer_PlaceOrder.ActualDistance, ActualDistPartnerApp);
				System.out.println("The distance to be delivered is successfully verified");
				System.out.println("The distance to which order has to be delivered is : "
						+ QWQER_SC_001_Customer_PlaceOrder.ActualDistance + " km");
			} else {
				Assert.fail("Distance verification failed");
			}
			// verify delivery time
			if (ActualTimePartnerApp.contentEquals(QWQER_SC_001_Customer_PlaceOrder.ActualTime)) {
				Assert.assertEquals(ActualTimePartnerApp, (QWQER_SC_001_Customer_PlaceOrder.ActualTime));
				System.out.println("The time to be delivered is successfully verified");
				System.out.println("The time allowed for delivering the product is : "
						+ QWQER_SC_001_Customer_PlaceOrder.ActualTime + " mins");
			} else {
				Assert.fail("Distance verification failed");
			}

			// verify the payment mode
			String paymentMode = objects.PaymentModeText().getText();
			if (paymentMode.contentEquals("Cash on Pick up")) {
				Assert.assertEquals(paymentMode, "Cash on Pick up");
				System.out.println("Payment mode verified successfully");
				System.out.println("Payment to be collected as : " + paymentMode);
			} else {
				Assert.fail("Payment mode verification failed");
			}

			// verify sender name
			String senderName = objects.GetSenderName().getText();
			if (senderName.contentEquals(prop.getProperty("UserName"))) {
				Assert.assertEquals(senderName, prop.getProperty("UserName"));
				System.out.println("Sender name verified successfully");
				System.out.println("The product have to be collected from the sender named : " + senderName);
			} else {
				Assert.fail("Sender name verification failed");
			}

			// verify sender address
			String senderAddress = objects.GetSenderAddress().getText();
			if (senderAddress.contains(prop.getProperty("SenderAddress"))) {
				Assert.assertTrue(senderAddress.contains(prop.getProperty("SenderAddress")));
				System.out.println("Sender address verified successfully");
				System.out.println("The product have to be collected from the sender of address : " + senderAddress);
			} else {
				Assert.fail("Sender address verification failed");
			}

			// verify sender Mob
			String senderMobNumFull = objects.GetSenderMob().getText();
			String senderMobNum = senderMobNumFull.substring(senderMobNumFull.lastIndexOf("1") + 1);
			System.out.println(senderMobNum);
			if (senderMobNum.contentEquals(prop.getProperty("userMobNum"))) {
				Assert.assertEquals(senderMobNum, prop.getProperty("userMobNum"));
				System.out.println("Sender mobile number verified successfully");
				System.out
						.println("The product have to be collected from the sender of mobile number : " + senderMobNum);
			} else {
				Assert.fail("Sender mobile number verification failed");
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void AcceptSenderOrReceiverDetails() throws InterruptedException {
		DriverApp_PlacedOrderObjects objects = new DriverApp_PlacedOrderObjects(driver);
		String visibleText = "ACCEPTED";
		element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))"));
		wait.until(ExpectedConditions.elementToBeClickable(objects.GetReceiverName()));

		// verify receiver name
		String receiverName = objects.GetReceiverName().getText();
		if (receiverName.contentEquals(prop.getProperty("ReceiverCustName"))) {
			Assert.assertEquals(receiverName, prop.getProperty("ReceiverCustName"));
			System.out.println("Reciever name verified successfully");
			System.out.println("The product have to be delivered to the receiver named : " + receiverName);
		} else {
			Assert.fail("Receiver name verification failed");
		}

		// verify receiver address
		String receiverAddress = objects.GetReceiverAddress().getText();
		if (receiverAddress.contains(prop.getProperty("ReceiverDetailAddress"))) {
			Assert.assertTrue(receiverAddress.contains(prop.getProperty("ReceiverDetailAddress")));
			System.out.println("Receiver address verified successfully");
			System.out.println("The product have to be delivered to the receiver of address : " + receiverAddress);
		} else {
			Assert.fail("Receiver address verification failed");
		}

		// verify Receiver mobile
		String receiverMobNumFull = objects.GetReceiverNum().getText();
		String receiverMobNum = receiverMobNumFull.substring(receiverMobNumFull.lastIndexOf("1") + 1);
		if (receiverMobNum.contentEquals(prop.getProperty("ReceiverCustMobNum"))) {
			Assert.assertEquals(receiverMobNum, prop.getProperty("ReceiverCustMobNum"));
			System.out.println("Receiver mobile number verified successfully");
			System.out.println("The product have to be delivered to the reciever of mobile number : " + receiverMobNum);
		} else {
			Assert.fail("Receiver mobile number verification failed");
		}

		// Verify product weight
		String Productweight = objects.PartnerGetItemWeight().getText();
		if (Productweight.contentEquals(prop.getProperty("ProductWeight"))) {
			Assert.assertEquals(Productweight, QWQER_SC_001_Customer_PlaceOrder.SelectedProductWeight);
			System.out.println("Product weight verified successfully");
			System.out.println("Product to be delivered with weight : " + Productweight);
		} else {
			Assert.fail("Product weight verification failed");
		}
		// Verify product description
		String ProductDesc = objects.PartnerGetItemDesc().getText();
		if (ProductDesc.contentEquals(prop.getProperty("ProductDescription"))) {
			Assert.assertEquals(ProductDesc, prop.getProperty("ProductDescription"));
			System.out.println("Product description verified successfully");
			System.out.println("Product to be delivered with description : " + Productweight);
		} else {
			Assert.fail("Product description verification failed");
		}
		// Verify product instruction
		String ProductInstruction = objects.PartnerGetItemInstruction().getText();
		if (ProductInstruction.contentEquals(prop.getProperty("SpecialInstruction"))) {
			Assert.assertEquals(ProductInstruction, prop.getProperty("SpecialInstruction"));
			System.out.println("Product special instruction verified successfully");
			System.out.println("Product to be delivered with special instruction : " + Productweight);
		} else {
			Assert.fail("Product special instruction verification failed");
		}

	}

	@Test(priority = 4)
	public void AcceptPlacedOrder() throws InterruptedException {
		DriverApp_PlacedOrderObjects objects = new DriverApp_PlacedOrderObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.AcceptOrderBtn()));
		objects.AcceptOrderBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AcceptConfirmBtn()));
		objects.AcceptConfirmBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.PickedUpBtn()));
		String time = driver.getDeviceTime();
		System.out.println(time);
		String pickedupstatus = objects.PickedUpBtn().getText();
		if (pickedupstatus.contentEquals("PICKED UP")) {
			Assert.assertEquals(pickedupstatus,"PICKED UP");
			System.out.println("The delivery of the producted is confirmed by our partner : "
					+ prop.getProperty("DriverUserName") + " with Id : " + DriverID);
		} else {
			Assert.fail();
		}
		
		

	}
	
	@Test(priority = 5)
	public void PickUpandDeliverOrder() throws InterruptedException {
		DriverApp_PlacedOrderObjects objects = new DriverApp_PlacedOrderObjects(driver);
		wait.until(ExpectedConditions.elementToBeClickable(objects.PickedUpBtn()));
		objects.PickedUpBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.AcceptConfirmBtn()));
		String amountToBeCollectedmessage = objects.CnfrmBtnText().getText();
		String TextSplit = amountToBeCollectedmessage.substring(amountToBeCollectedmessage.lastIndexOf("Rs ") + 1);
		String finalAmount = TextSplit.substring(0,TextSplit.indexOf(" is"));
		double getamount = StringHelper.getDoubleValue(finalAmount);
if(getamount==QWQER_SC_001_Customer_PlaceOrder.ActualFinalAmountAfterDiscount) {
	Assert.assertEquals(getamount, QWQER_SC_001_Customer_PlaceOrder.ActualFinalAmountAfterDiscount);
	System.out.println("Final amountto be paid verified successfully");
	System.out.println("The amount to be collected from the customer is Rs : "+getamount);
}else {
	Assert.fail("Amount verification failed");
}
		objects.AcceptConfirmBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.Partner_DeliveredBtn()));
		objects.Partner_DeliveredBtn().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.EnterOTP()));
		objects.EnterOTP().sendKeys(QWQER_SC_001_Customer_PlaceOrder.OTP);
		driver.hideKeyboard();
		objects.CustRating().click();
		wait.until(ExpectedConditions.elementToBeClickable(objects.ConfirmDeliveryBtn()));
		objects.ConfirmDeliveryBtn().click();
		System.out.println("Product delivered successfully and the payment of Rs : "+getamount+" has been collected.");
		
	}
}
