package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LoginPageObjects {
	AppiumDriver driver;
	
	public LoginPageObjects(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(xpath = "//android.widget.Button[@text='ALLOW']")List<WebElement> allowBtnSize;
	@FindBy(xpath = "//android.widget.TextView[@text='Continue with']")List<WebElement> SuggestionBtnSize;
	@FindBy(xpath = "//android.widget.Button[@text='ALLOW']")WebElement allowBtn;
	@FindBy(xpath = "//android.widget.EditText[@text='Mobile Number']")WebElement username;
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.qwqer.customer:id/login_edittext_password']")WebElement pswrd;
	@FindBy(xpath = "//android.widget.Button[@text='LOGIN']")WebElement loginBtn;
	@FindBy(xpath = "//android.widget.Button[@text='NONE OF THE ABOVE']")WebElement NoneoftheaboveBtn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/login_textview_mobile_error']")WebElement MobNumMandatoryMsg;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.qwqer.customer:id/login_textview_password_error']")WebElement PasswordMandatoryMsg;
	public WebElement UsernameField() {
		return username;
	}
	public WebElement Password() {
		return pswrd;
	}
	public WebElement LoginBtn() {
		return loginBtn;
	}
	public List<WebElement> SuggestionBtnSize() {
		return SuggestionBtnSize;
	}
	
	public List<WebElement> AllowBtnSize() {
		return allowBtnSize;
	}
	public WebElement AllowBtn() {
		return allowBtn;
	}
	public WebElement NoneoftheaboveBtn() {
		return NoneoftheaboveBtn;
	}
	
	public WebElement MobNumMandatoryMsg() {
		return MobNumMandatoryMsg;
	}
	public WebElement PasswordMandatoryMsg() {
		return PasswordMandatoryMsg;
	}

}
