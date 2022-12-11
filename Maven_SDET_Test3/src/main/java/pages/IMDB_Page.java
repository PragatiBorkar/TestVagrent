package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDB_Page {

	
	WebDriver driver;
	

	@FindBy (xpath="//input[@placeholder='Search IMDb']")
	private WebElement imdbSearchField;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy (xpath="(//a[text()='Pushpa: The Rise - Part 1'])[1]")
	private WebElement movieName;
	
	@FindBy (xpath="(//div[@class='ipc-title__wrapper'])[7]")
	private WebElement details;
	
	@FindBy (xpath="(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[23]")
	private WebElement releseDate;
	
	@FindBy (xpath="(//a[@class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link'])[24]")
	private WebElement country;
	
	
	
	
	  public IMDB_Page(WebDriver driver ){
	  PageFactory.initElements(driver, this);
	  this.driver=driver;
	   }
	   
	   

		public void sendinputOnSearchField(String name) {
			imdbSearchField.sendKeys(name);
		}
	
		public void clickOnsearchButton() {
			searchButton.click();
		}
		
		
		public void clickOnMovieName() {
			movieName.click();
		}
		
		
		public void scrollDownToDetails() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", details);
		
		}
		
		
		public void getReleseDate() {
			
			String Date1=releseDate.getText();
			System.out.println(Date1);
			
		}
		
		public void getCountry() {
			String countryName1=country.getText();
			System.out.println(countryName1);
		}
		
	
	
	
	
	
	
	
	
	
	
}
