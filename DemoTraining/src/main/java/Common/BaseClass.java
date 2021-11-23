package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseClass {
	
	@Test
	public static void InitializeBrowser() {
		
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		
		System.setProperty("webdriver.chrome.driver", ProjectPath+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
	}

}
