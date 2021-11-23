package stepDefnitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.LoginPageObjects;
import Pages.PatientsPageObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;

	
	@RunWith(Cucumber.class)
	public class LoginStep {

		WebDriver driver;
		WebDriverWait wait;

		@Given("^Application is launched$")
	    public void application_is_launched(DataTable data) throws Throwable {
			List<List<String>> obj = data.asLists();
			// Getting the automation project path
			String ProjectPath = System.getProperty("user.dir");

			// Initialize the driver
			System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(obj.get(0).get(0));

		}
		
		@When("^User login into the application using username and password$")
	    public void user_login_into_the_application_using_username_and_password(DataTable data) throws Throwable {
			LoginPageObjects objects = new LoginPageObjects(driver);
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(objects.LoginBtn()));
			List<List<String>> obj = data.asLists();
			wait.until(ExpectedConditions.elementToBeClickable(objects.UsernameField()));
			objects.UsernameField().sendKeys(obj.get(0).get(0));
			objects.PasswordField().sendKeys(obj.get(0).get(1));
			objects.LoginBtn().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.GetUserDropDown()));
			objects.GetUserDropDown().click();
			wait.until(ExpectedConditions.elementToBeClickable(objects.getUserName()));
			String userNameActual = objects.getUserName().getText();
			
			if (userNameActual.contains(obj.get(0).get(2))) {
				Assert.assertTrue(true);
				System.out.println("Verify user login executed and passed successfully");

			} else {
				Assert.fail();
				System.out.println("Test case verification failed");

			}
			
			
		}
		
		@When("^Naviagte to create patient page and add patient$")
	    public void naviagte_to_create_patient_page_and_add_patient() throws Throwable {
	       PatientsPageObjects objects = new PatientsPageObjects(driver);
	       objects.ClinicsModule().click();
	       objects.AddPatientSubModule().click();
	    }

	    @When("^Create a new patient$")
	    public void create_a_new_patient() throws Throwable {
	    	
	    	System.out.println("test");
	        
	    }
		}
		


