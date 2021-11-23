package step_Definitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddBeneficiary;
import pages.AddBillerObjects;

public class Login_Steps {
    WebDriver driver=null;
    //WebElement login;
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside step:user is on the login page");
		String projectPath= System.getProperty("user.dir");
		System.out.println("Project path is : "+ projectPath);
	   
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    driver= new ChromeDriver(); 
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.navigate().to("http://41.215.180.245:8085/Retail/#/login");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside step:user enters username and password");
	    
	    WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        WebElement login=driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div/div/div[2]/form/button/p"));
        username.sendKeys("testuser2");
        password.sendKeys("Test@1234"); 
        login.click();
		
		
	}

	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("Inside step:click on login button");
	    WebElement payments=driver.findElement(By.xpath("//*[@id=\"Layout\"]/div/div/div[2]/div[1]/a[5]/h2"));
		payments.click();
	    
	}

	@Then("user is able to add biller")
	public void user_is_able_to_see_dashboard() {
		System.out.println("user is able to add biller");
		AddBillerObjects objects = new AddBillerObjects(driver);
		WebElement addBiller=driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='ZMW'])[2]/following::h3[1]"));
		addBiller.click();
	    
	    Select select = new Select(objects.SelectDropDown());
	    select.selectByValue("MLife");
	    objects.AccountNo().sendKeys("0011030014698");
	    objects.ShortName().sendKeys("nikz");
	    objects.submitButton().click();
	   
	   
	    String addBillerVerification = driver.findElement( By.xpath("//*[starts-with (text(),'Biller Beneficiary Added Successfully')]")).getText();
	    Assert.assertTrue("Biller Beneficiary Added not Successfully", addBillerVerification.contains("Biller Beneficiary Added Successfully"));
	   
	    driver.navigate().to("http://41.215.180.245:8085/Retail/#/dashboard");
	   
	  
	}
	@Then("user is able to add beneficiary")
	public void user_is_able_to_add_beneficiary() {
		System.out.println("user is able to add beneficiary");
		AddBeneficiary objects = new AddBeneficiary(driver);
	    
		objects.Transfers().click();
		objects.AddBeneficiaryTransfers().click();
		objects.internalBeneficiary().click();
		objects.NickNameinternalBeneficiary().sendKeys("Nikkz");
		objects.AccountNointernalBeneficiary().sendKeys("0011030014698");
		objects.ConfirmAcNointernalBeneficiary().sendKeys("0011030014698");
		objects.TransfersLimitInternalBeneficiary().sendKeys("3");
		objects.SubmitInternalBeneficiary().click();
		objects.ConfirmSubmit().click();
		objects.OTP().sendKeys("1234");
		objects.OTPSubmit().click();
		String addBeneficiaryVerification = driver.findElement( By.xpath("//*[starts-with (text(),'Internal account transfer Beneficiary Added Successfully')]")).getText();
		Assert.assertTrue("Internal account transfer Beneficiary not Added Successfully", addBeneficiaryVerification.contains("Internal account transfer Beneficiary Added Successfully"));
	}

}

