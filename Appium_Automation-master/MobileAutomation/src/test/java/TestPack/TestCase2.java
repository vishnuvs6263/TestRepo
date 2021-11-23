package TestPack;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCase2 extends baseClass2 {
	public static WebDriverWait wait;
	public static AndroidDriver<AndroidElement> driver;


@Test
public static void signUp() throws InterruptedException, MalformedURLException {
	driver = capabilities();
	wait = new WebDriverWait(driver, 40);
	driver.findElement(By.xpath(prop.getProperty("signUpHereBtn"))).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath(prop.getProperty("signUpPasswordField"))).sendKeys(prop.getProperty("newPassword"));
	driver.findElement(By.xpath(prop.getProperty("confirmPasswordField"))).sendKeys(prop.getProperty("newPassword"));
	driver.findElement(By.xpath(prop.getProperty("continueBtn"))).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath(prop.getProperty("signUpMobNumField"))).sendKeys(prop.getProperty("signUpMob"));
	driver.findElement(By.xpath(prop.getProperty("signUpEmailField"))).sendKeys(prop.getProperty("signUpEmail"));
	driver.findElement(By.xpath(prop.getProperty("reqOTPBtn"))).click();
}

	 

}
