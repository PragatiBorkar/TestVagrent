package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	
	
	public static WebDriver OpenChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\classs\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
		
		}
	
	
	
	
	
	
	
	
	
	
	
}
