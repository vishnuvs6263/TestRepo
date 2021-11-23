package TestPack;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCase1 extends baseClass2 {
	public static WebDriverWait wait;
	public static AndroidDriver<AndroidElement> driver;

	@Test(priority = 1, alwaysRun = true)
	public static void Login() throws MalformedURLException, InterruptedException {
		driver = capabilities();
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(prop.getProperty("mobNumField"))));
		// Enter username
		driver.findElement(By.xpath(prop.getProperty("mobNumField")))
				.sendKeys(prop.getProperty("mobNumber"));

		// Enter Password
		driver.findElement(By.xpath(prop.getProperty("passField"))).sendKeys(prop.getProperty("password"));

		// Login
		driver.findElement(By.xpath(prop.getProperty("loginBtn"))).click();
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public static void Logout() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(prop.getProperty("logoutImgBtnClass"))));
		driver.findElement(By.className(prop.getProperty("logoutImgBtnClass"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("logoutConfirmBtn"))));
		driver.findElement(By.xpath(prop.getProperty("logoutConfirmBtn"))).click();

	}

	@Test(priority = 2)
	public static void NeuroTest() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Neuro \r\n" + "Profile']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Neuro \r\n" + "Profile']")).click();

	}
}
