package Common;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {
	ChromeDriverService Capabilities;

	public static WebDriver driver;
	public static Properties prop;

	@BeforeMethod
	public void InitializeBrowser() throws Exception {

		// Read data from excel
		String projectpath = System.getProperty("user.dir");
		// Read data from config file
		System.out.println(projectpath);
	
	}

	@DataProvider(name = "ObjectRepository")
	public Object[][] locators() throws Exception {
		Object[][] data = ReadExcelData.testData(
				"C:\\Users\\vishnuvs\\eclipse-workspace\\MassEmail\\ExcelUtils\\Sales.xlsx",
				"Sheet1");
		return data;
	}


	
}
