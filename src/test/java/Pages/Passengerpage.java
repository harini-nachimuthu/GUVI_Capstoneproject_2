package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.basemethod;

public class Passengerpage extends basemethod{
  
	@FindBy(xpath="(//div[.='Title*'])[1]/following::div[@data-testid=\"title-contact-detail-card\"]")
	WebElement defaulttitle;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-rs99b7 r-g93hjn r-1g94qm0 r-h3f8nf r-1w50u8q r-u8s1d r-y3rmyz r-8fdsdq\"]/div/div/div/div[1]/div[.='Mr']")
	WebElement defaulttitleselect;
	
	@FindBy(xpath="(//div[@class=\"css-1dbjc4n\"])[5]/div[2]/input[@data-testid='first-inputbox-contact-details']")
	WebElement defaultfirstname;

	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement defaultlastname;
	
	@FindBy(xpath="//div[.='Contact Number*']/following::div[1]/div")
	WebElement defaultcountrycode;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-1dqxon3 r-u8s1d r-12kfsgm r-8fdsdq']/div[2]/div[101]/div[1]/div[1]")
	WebElement defaultindiacountrycode;
	
	@FindBy(xpath="//div[@id='primary-contact-details']/div[3]//div[4]/div/div[2]/input[@data-testid=\"contact-number-input-box\"]")
	WebElement defaultmobilenumber;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-18u37iz r-1g94qm0 r-mhe3cw']/div[1]/div/div/div[2]/input[@data-testid=\"emailAddress-inputbox-contact-details\"]")
	WebElement defaultemailid;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-18u37iz r-1g94qm0 r-mhe3cw']/div[2]/div[2]")
	WebElement defaultcountryname;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-6e0ovw r-8fdsdq']/div[2]/div[@class=\"css-1dbjc4n r-1niwhzg r-1loqt21 r-1otgn73 r-lrvibr\"]/div[.='India']")
	WebElement defaultindiacountry;
	
	@FindBy(xpath="(//input[@type='text'])[5]")
	WebElement defaulttown;
	
	//Method for Passengerpage constructor
	public Passengerpage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}

	//method used to fill default passenger details to get flight status and for emergency to call the passenger
	public Passengerpage passengersdefaultdetails(String firstname,String lastname,String mobilenumber,String emailid,String town) throws InterruptedException {
		clickbtn(defaulttitle);
		clickbtn(defaulttitleselect);
		xpathwebandsend(defaultfirstname,firstname);
		xpathwebandsend(defaultlastname,lastname);
		clickbtn(defaultcountrycode);
		clickbtn(defaultindiacountrycode);
		xpathwebandsend(defaultmobilenumber,mobilenumber);
		xpathwebandsend(defaultemailid,emailid);
		clickbtn(defaultcountryname);
		clickbtn(defaultindiacountry);
		xpathwebandsend(defaulttown,town);
		return this;
	}
	
	
}
