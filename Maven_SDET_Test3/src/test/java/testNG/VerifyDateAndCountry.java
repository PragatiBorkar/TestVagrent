package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
		String releseDate=searchPage.getReleseDate();
		System.out.println("Relese Date Of Movie On IMDB="+releseDate);
		String country=searchPage.getCountry();
		System.out.println("Country Name Of Movie On IMDB="+country);
		
		
		
		
		
		driver.get("https://www.imdb.com/");
		iMDB_Page=new IMDB_Page(driver);

		String data1=Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		iMDB_Page.sendinputOnSearchField(data1);
		

		iMDB_Page.clickOnsearchButton();
		iMDB_Page.clickOnMovieName();
		iMDB_Page.scrollDownToDetails();
		String releseDate1=iMDB_Page.getReleseDate();
		System.out.println("Relese Date Of Movie On Wiki="+releseDate1);
		String country1 =iMDB_Page.getCountry();
		System.out.println("Country Name Of Movie On Wiki="+country1);
		
		if(releseDate.equals(releseDate1))
		{
			System.out.println("Relese date Are Same So Test case is =PASS");
		}
		else 
		{
			System.out.println("Relese date Are not Same So Test case is = FAIL");
		}
		
		if(country.equals(country1))
		{
			System.out.println("Country Name Are Same So Test case is =PASS");
		}
		else 
		{
			System.out.println("Country Name Are not Same So Test case is =FAIL");
		}
		
		
		
	}
	
	

	    @AfterClass
	    public void clearObject (){
		searchPage=null;
		iMDB_Page=null;
	
      }


	   @AfterTest
	   public void closeBrowser(){
		driver.close();
		driver=null;
		System.gc();
     }
	
	
	
}
