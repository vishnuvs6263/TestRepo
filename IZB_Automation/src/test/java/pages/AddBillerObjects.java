package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import step_Definitions.Login_Steps;

public class AddBillerObjects {
	WebDriver driver;

	public AddBillerObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//select[@name='merchant']")
	WebElement SelectDropDown;

	public WebElement SelectDropDown() {
		return SelectDropDown;

	}
	@FindBy(xpath = "//input[@name='serviceNumber']")
	WebElement AccountNo;

	public WebElement AccountNo() {
		return AccountNo;

	}
	@FindBy(xpath = "//input[@name='shortName']")
	WebElement ShortName;

	public WebElement ShortName() {
		return ShortName;

	}
	@FindBy(xpath = "//div[@id='Layout']/div/div/div/div[2]/div[2]/div[2]/div/form/div[4]/div/button/p")
	WebElement submitButton;

	public WebElement submitButton() {
		return submitButton;
		
	}
	
}
