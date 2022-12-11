package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.IMDB_Page;
import pages.SearchPage;
import setup.Base;
import utils.Utility;

public class VerifyDateAndCountry extends Base{

	
	
	WebDriver driver;
	SearchPage searchPage;
	IMDB_Page iMDB_Page;
	
	
	@Parameters("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName){
		
		if(browserName.equals("Chrome"))
			{
				driver=OpenChromeBrowser();
			}
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	   }
	
	
	@Test
	public void verifyReleseDateAndCountryNameOnWiki() throws EncryptedDocumentException, IOException {
		
		searchPage=new SearchPage(driver);
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		
		
		String data=Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		searchPage.sendinputOnSearchField(data);
		
		
		
		searchPage.clickOnSearchButton();
		searchPage.clickOnMovieName();
		searchPage.getReleseDate();
		searchPage.getCountry();
		
		
		
		
		
		
		
		driver.get("https://www.imdb.com/");
		iMDB_Page=new IMDB_Page(driver);
		
		
		String data1=Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		iMDB_Page.sendinputOnSearchField(data1);
		
		
		
		iMDB_Page.clickOnsearchButton();
		iMDB_Page.clickOnMovieName();
		iMDB_Page.scrollDownToDetails();
		iMDB_Page.getReleseDate();
		iMDB_Page.getCountry();
		
			
		
	}
	
	

	    @AfterClass
	    public void clearObject (){
		searchPage=null;
	
      }


	   @AfterTest
	   public void closeBrowser(){
		driver.close();
		driver=null;
		System.gc();
     }
	
	
	
}
