package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.basemethod;

public class Loginpage extends basemethod{

	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginbtnhome;
	
	@FindBy(xpath="//input[@id='inlineRadio1']")
	WebElement mobilebtn;
	
	@FindBy(xpath="//input[@id='inlineRadio2']")
	WebElement emailbtn;
	
	@FindBy(xpath="(//div[@class=' flag-dropdown'])[2]")
	WebElement mobilecodeclick;
	
	@FindBy(xpath="(//div[@class='flag in'])[3]")
	WebElement indiabtnclick;
	
	@FindBy(xpath="//div[@class='input-group mb-3'] //input[@placeholder='+91 01234 56789']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="(//div[.='Log In'])[3]")
	WebElement loginsubmitbtn;
	
	@FindBy(xpath="//a//label//span[.='Login']")
	WebElement loginbtninsignup;
	
	@FindBy(xpath="//div[@class=\"btn-close account-modal-close pt-2\"]")
	WebElement closebtninlogin; 
	
	@FindBy(xpath="(//button[.='BOOK NOW'])[2]")
	WebElement booknow;
	
	//Method for loginpage constructor
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}

	//Method to fill login data using xpath locator to sendkeys and clickbtn method to click
	public Loginpage logindetails(String number,String password) throws InterruptedException {
		clickbtnjs(loginbtninsignup);
//		clickbtnjs(mobilebtn);
//		clickbtn(mobilecodeclick);
//		clickbtn(indiabtnclick);
		xpathandsendkeys1("//div[@class='input-group mb-3'] //input[@placeholder='+91 01234 56789']",number);
		xpathandsendkeys1("//input[@id='password']",password);
		clickbtnjs(loginsubmitbtn);
		Thread.sleep(2000);
		return this;
		
	}
	
}


