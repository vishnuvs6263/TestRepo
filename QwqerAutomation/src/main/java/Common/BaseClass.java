package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AppiumDriver driver;
	public static DesiredCapabilities desiredCapabilities;
	public static Properties prop;


	public void initializeDriver(String platformName,String PlatFormVersion, String udid, String deviceName, String AVD, String appPackage, String appActivity) throws MalformedURLException {

		try {
			desiredCapabilities = new DesiredCapabilities();
			String projectpath = System.getProperty("user.dir");
			prop = new Properties();

			FileInputStream fis = new FileInputStream(projectpath + "/Configuration/Config.properties");
			prop.load(fis);

			desiredCapabilities.setCapability("platformName", platformName);
			desiredCapabilities.setCapability("platformVersion", PlatFormVersion);
			desiredCapabilities.setCapability("udid", udid);
			desiredCapabilities.setCapability("deviceName", deviceName);
			desiredCapabilities.setCapability("avd", AVD);
			desiredCapabilities.setCapability("appPackage", appPackage);
			desiredCapabilities.setCapability("appActivity", appActivity);

			URL url = new URL("http://127.0.0.1:4723/wd/hub");

			driver = new AndroidDriver(url, desiredCapabilities);
			String sessionId = driver.getSessionId().toString();

		} catch (Exception exp) {
			System.out.println("The cause is :" + exp.getCause());
			System.out.println("The message is :" + exp.getMessage());
			exp.printStackTrace();

		}

	}

	public void getScreenShot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E://ScreenShots//" + result + "failure.png"));
	}

	public void takeScreenShot(String result) throws IOException {
		String timeStamp;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		FileUtils.copyFile(scrFile, new File("E://ScreenShots//" + result + timeStamp + ".png"));
	}
}
/*
 * @AfterSuite public void tearDown() { driver.close(); driver.quit();
 * 
 * }
 */
