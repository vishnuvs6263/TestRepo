package TestPack;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class baseClass2 {
	
	public static AndroidDriver<AndroidElement> driver;
	public static Properties prop;
	//@BeforeMethod
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{
		
		try {
		DesiredCapabilities cap = new DesiredCapabilities();
		String projectpath = System.getProperty("user.dir");
		prop = new Properties();

		FileInputStream fis = new FileInputStream(projectpath + "/Configuration/Config.properties");
		prop.load(fis);
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.UDID, prop.getProperty("UDID"));
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		cap.setCapability(MobileCapabilityType.APPLICATION_NAME, prop.getProperty("appName"));
			
			  cap.setCapability("appPackage", prop.getProperty("appPackageName"));
			  cap.setCapability("appActivity", prop.getProperty("appActivityName"));
			 
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		}catch(Exception exp) {
			System.out.println("The cause is :"+exp.getCause());
			System.out.println("The message is :"+exp.getMessage());
			exp.printStackTrace();
			
		}
		return driver;
		
		
		
	}
	/*
	 * @AfterSuite public void tearDown() { driver.close(); driver.quit();
	 * 
	 * }
	 */
}
