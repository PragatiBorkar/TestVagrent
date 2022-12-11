package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	
	@FindBy (xpath="//input[@placeholder='Search Wikipedia']")
	private WebElement searchBox;
	
	
	
	@FindBy (xpath="//input[@id='searchButton']")
	private WebElement searchButton;
	
	 

	@FindBy (xpath="//a[@title='Pushpa: The Rise']")
	private WebElement movieName;
	
	

	@FindBy (xpath="(//td[@class='infobox-data'])[10]")
	private WebElement releseDate;
	

	@FindBy (xpath="(//td[@class='infobox-data'])[12]")
	private WebElement country;
	
	
	
	

	   public SearchPage(WebDriver driver ){
	   	PageFactory.initElements(driver, this);
	   	this.driver=driver;
	   }
	   
	   

		public void sendinputOnSearchField(String name1) {
			searchBox.sendKeys(name1);
		}
	   
		public void clickOnSearchButton() {
			searchButton.click();
		}
		
		
		public void clickOnMovieName() {
			movieName.click();
		}
		
		public void getReleseDate() {
			
			String Date=releseDate.getText();
			System.out.println(Date);
			
		}
		
		public void getCountry() {
			String countryName=country.getText();
			System.out.println(countryName);
		}
		
		
		
		
		
	
}
