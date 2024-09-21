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

public class Primarypassengerpage extends basemethod{
  
	//Method for Primarypassengerpage constructor
	public Primarypassengerpage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}

	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-14lw9ot r-1f0042m r-80ewyj r-15d164r r-1pcd2l5\"]/div[2]/div/div[2]/div/div/div[1]/div/div//div/div[1]")
	WebElement primarycheckbox;
	
	@FindBy(xpath="(//div[.='Title*'])[2]/following::div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-1ugchlj r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-19554kt r-184en5c\"]")
	WebElement primarytitle;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-rs99b7 r-g93hjn r-1g94qm0 r-yfq7p9 r-1w50u8q r-u8s1d r-19554kt r-8fdsdq']/div[1]/div[.='Mr']")
	WebElement primarytitleselect;
	
	@FindBy(xpath="(//input[@type='text'])[6]")
	WebElement primaryfirstname;
	
	@FindBy(xpath="(//input[@type='text'])[7]")
	WebElement primarylastname;
	
	@FindBy(xpath="(//input[@type='text'])[8]")
	WebElement primarymobilenumber;
	
	@FindBy(xpath="//div[@data-testid='traveller-0-travel-info-cta']")
	WebElement nextpassenger;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-1kihuf0 r-ometjm r-1251kcm r-13qz1uu\"]/div/div[2]/div/div/div[2]")
	WebElement Passengercontinuebtn;
	
	@FindBy(xpath="//div[@data-testid=\"bookingFlow-seats-add-cta\"]")
	WebElement addseats;
	
	@FindBy(xpath="(//div[.='7A'])[6]")
	WebElement seatselect;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-15bsvpr r-1w50u8q r-ah5dr5 r-1otgn73\"]")
	WebElement selectmeals;
	
	@FindBy(xpath="//div[@data-testid=\"add-ons-continue-footer-button\"]")
	WebElement addoncontinuebtn;
	
	@FindBy(xpath="(//p[@class='tt_skip_link'])[1]")
	WebElement skipbtn;
	
	//Method filling primary passenger details..
	public Primarypassengerpage primarypassengerdetails() throws InterruptedException {
		clickbtn(primarycheckbox);
		clickbtn(primarytitle);
		clickbtn(primarytitleselect);
		//xpathwebandsend(primaryfirstname,"Arun");
		//xpathwebandsend(primarylastname,"Kumar");
		//xpathwebandsend(primarymobilenumber,"9514248426");
		//clickbtn(Passengercontinuebtn);
		Thread.sleep(3000);
		//clickbtn(addoncontinuebtn);
		return this;
	}
	
	//Method used to click passengerpage continue button to move with addon page
	public Primarypassengerpage passengercontinuebtn() throws InterruptedException { 
		clickbtn(Passengercontinuebtn);
		System.out.println("Passenger details are filled and moved on to addon page");
		//clickbtn(addseats);
		//clickbtn(seatselect);
		//bothclickbtnjs(selectmeals);
		bothclickbtnjs(addoncontinuebtn);
		System.out.println("Addon continue page is done and clicked...");
		Thread.sleep(5000);
		
		
		
		return this;
	}
}

