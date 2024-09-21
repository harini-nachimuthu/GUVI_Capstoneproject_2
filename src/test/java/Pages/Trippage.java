package Pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.basemethod;

public class Trippage extends basemethod{
  
	//Method for Tripage constructor
	public Trippage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
	}

	@FindBy(xpath="//div[@data-testid='one-way-radio-button']/div[2]")
	WebElement onewaybtn;
	
	@FindBy(xpath="(//div[contains(text(),'round trip')])[1]")
	WebElement roundwaybtn;
	
	@FindBy(xpath="(//div[text()='From']/following::input)[1]")
	WebElement frombtn;
	
	@FindBy(xpath="(//div[text()='To']/following::input)[1]")
	WebElement tobtn;
	
	@FindBy(xpath="//div[.='Return Date']/following::div[.='Select Date'][1]")
	WebElement returndateclickbtn;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-18u37iz\"]/div[@data-testid='undefined-month-May-2025']/div[@class=\"css-1dbjc4n\"]/div[4]/div[6]")
	WebElement returndateselect;
	
	@FindBy(xpath="//div[text()='Return Date']/following-sibling::div[text()='Select Date']/following::div[contains(@data-testid, 'undefined-month-May-2025')]/div[4]/div[6]")
	WebElement returndateselect1;

	
	@FindBy(xpath="//div[@data-testid='home-page-travellers']/div[2]")
	WebElement passengerselectbtn;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh\"]//div[@class=\"css-1dbjc4n\"]/div[1]/div[1]/div[2]//div[3]")
	WebElement adultadditionclick;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh\"]//div[@class=\"css-1dbjc4n\"]/div[1]/div[2]//div[2]//div[3]")
	WebElement childadditionclick;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh\"]//div[@class=\"css-1dbjc4n\"]/div[1]/div[3]//div[2]//div[3]")
	WebElement infantadditionclick;
	
	@FindBy(xpath="//div[.='Currency']/following::div[1]")
	WebElement currencytypeclick;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh\"]/div[@class=\"css-1dbjc4n\"]/div[1]/div[.='INR']")
	WebElement inrcurrencybtnclick;
	
	@FindBy(xpath="//div[@data-testid=\"home-page-flight-cta\"]")
	WebElement searchflightbtnclick;
	
	@FindBy(xpath="(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73'])[1]")
	WebElement closebtn;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep']/div[3]/div[2]")
	WebElement continuebtnclick;
	
	//Method used to fill details to search for flights in oneway trip
	public Trippage onewaydata1() throws InterruptedException {
				
		clickbtn(onewaybtn);
		xpathwebandsend(frombtn,"DEL");
		xpathwebandsend(tobtn,"HYD");
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73'])[1]")) != null) {
		    clickbtn(closebtn);
		}
		clickbtn(returndateclickbtn);
		clickbtn(returndateselect);
		clickbtn(passengerselectbtn);
//		clickbtn(adultadditionclick);
		clickbtn(currencytypeclick);
		clickbtn(inrcurrencybtnclick);
		clickbtn(searchflightbtnclick);
		if(wait.until(ExpectedConditions.elementToBeClickable(continuebtnclick))!=null) {
			clickbtn(continuebtnclick);
			System.out.println("Flights are available...");
		}else {
			System.out.println("There is no availability of flight on these days.Please choose another...");
		}
		
		return this;
	}
	
	//Method used to fill details to search for flights in round trip
	public Trippage roundwaydata() throws InterruptedException {
		
		clickbtn(roundwaybtn);
		xpathwebandsend(frombtn,"Del");
		xpathwebandsend(tobtn,"HYD");
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73'])[1]")) != null) {
		    clickbtn(closebtn);
		}
		clickbtn(returndateclickbtn);
		clickbtn(returndateselect);
		clickbtn(passengerselectbtn);
//		clickbtn(adultadditionclick);
		clickbtn(childadditionclick);
		clickbtn(currencytypeclick);
		clickbtn(inrcurrencybtnclick);
		clickbtn(searchflightbtnclick);
		System.out.println("Moved to next page looking for continue button after selecting flight");
		if(wait.until(ExpectedConditions.elementToBeClickable(continuebtnclick))!=null) {
			clickbtn(continuebtnclick);
			System.out.println("Flights are available...");
		}else if(wait.until(ExpectedConditions.elementToBeClickable(continuebtnclick))==null){
			System.out.println("There is no availability of flight on these days.Please choose another...");
		}
		return this;
	}
	
	
	
}
