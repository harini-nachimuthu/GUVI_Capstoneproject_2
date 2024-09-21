package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.basemethod;


public class Signuppage extends basemethod {
	
	String homepagehandle;
  
	@FindBy(xpath="(//div[contains(text(),'Signup')])[1]")
	WebElement signupweb;
	
	@FindBy(xpath="//div//select[@class='form-control form-select ']")
	WebElement titleclickweb;
	
	@FindBy(xpath="//div//input[@id='first_name']")
	WebElement firstnameenter;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastnameenter;
	
	@FindBy(xpath="//div//select[@class='form-control form-select']")
	WebElement countryselect;
	
	@FindBy(xpath="//input[@id='dobDate']")
	WebElement dobclick;
	
	@FindBy(xpath="//select//option[@value='7']")
	WebElement monthselect;
	
	@FindBy(xpath="//select//option[@value='2000']")
	WebElement yearselect;
	
	@FindBy(xpath="//div[.='20']")
	WebElement dateselect;
	
	@FindBy(xpath="(//div[@class=' flag-dropdown'])[1]")
	WebElement flagboxclickweb;
	
	@FindBy(xpath="//ul//li//span[.='India']")
	WebElement  flagcountryclickweb;
	
	@FindBy(xpath="input[placeholder='+91 01234 56789']")
	WebElement phonenumberkey;
	
	@FindBy(xpath="//input[@id='email_id']")
	WebElement emailidweb;
	
	@FindBy(xpath="//div//input[@id='new-password']")
	WebElement newpasswordweb;
	
	@FindBy(xpath="//div//input[@id='c-password']")
	WebElement confirmpasswordweb;
	
	@FindBy(xpath="//div//input[@id='defaultCheck1']")
	WebElement checkboxclickweb;
	
	@FindBy(xpath="//a//button[.='Submit']")
	WebElement submitbtnclickweb;
	
	//Signuppage construtor
	public Signuppage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}

	//Click on signup button located in homepage.Before that storing the current window page in  homepagehandle
	public Signuppage signupbtnclick() throws InterruptedException {
		homepagehandle = driver.getWindowHandle();
		clickbtn(signupweb);
		return this;
	}
	
	//After clicking signup in homepage switch to new window if this not equal to homepagehandle
	public Signuppage switchtowindow() throws InterruptedException {
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(homepagehandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
		Thread.sleep(2000);
		return this;
	}
	
	//Click on title to select either "Mr" or "Mrs" or "Ms" using Select class to select them by visible text
	public Signuppage titleclick() {
		WebElement titleDropdown = wait.until(ExpectedConditions.visibilityOf(titleclickweb));
		Select selectTitle = new Select(titleDropdown);
        selectTitle.selectByVisibleText("Mr");
		return this;
	}
	
	//Method to sendkeys using xpath locators
	public Signuppage firstnameenter(String firstname) {
		xpathandsendkeys1("//input[@id='first_name']", firstname);
		return this;
	}
	
	//Method to sendkeys using xpath locators
	public Signuppage lastnameenter(String lastname) {
		xpathandsendkeys1("//input[@id='last_name']", lastname);
		return this;
	}
	
	//Method to select country using select class
	public Signuppage countryselection() {
		WebElement selectcountry = wait.until(ExpectedConditions.visibilityOf(countryselect));
		Select country = new Select(selectcountry);
		country.selectByVisibleText("India ");
		return this;
	}
	
	//Method to select Date of birth
	public Signuppage dobbutton() throws InterruptedException {
		Thread.sleep(500);
		clickbtnjs(dobclick);
		Thread.sleep(500);
		clickbtnjs(monthselect);
		Thread.sleep(500);
		clickbtnjs(yearselect);
		Thread.sleep(500);
		clickbtnjs(dateselect);
		Thread.sleep(500);
		return this;
	}
	
	//Method to send mobile numberusing xpath locators
	public Signuppage flagboxclick(String number) throws InterruptedException {
		xpathandsendkeys1("(//input[@placeholder='+91 01234 56789'])[1]", number);
		Thread.sleep(1000);
		return this;
	}
	
	//Method to send emailid using xpath locators
	public Signuppage emailidenter(String emailid) throws InterruptedException {
		xpathandsendkeys1("//input[@id='email_id']",emailid);
		Thread.sleep(1000);
		return this;
	}
	
	//Method to send new password using xpath locators	
	public Signuppage newpasswrd(String password) throws InterruptedException {
		xpathandsendkeys1("//div//input[@id='new-password']", password);
		Thread.sleep(500);
		return this;
	}
	//Method to send confirm password using xpath locators
	public Signuppage confirmpasswrd(String cpasswrd) throws InterruptedException {
		xpathandsendkeys1("//div//input[@id='c-password']", cpasswrd);
		Thread.sleep(1000);
		return this;
	}
	
	//Method to click agree button
	public Signuppage agree() throws InterruptedException {
		bothclickbtnjs(checkboxclickweb);
		Thread.sleep(2000);
		return this;
	}
	
	//Method to click submit button
	public Signuppage submit() throws InterruptedException {
		Thread.sleep(2000);
		if(submitbtnclickweb.isDisplayed()&&submitbtnclickweb.isEnabled()) {
			bothclickbtnjs(submitbtnclickweb);
			System.out.println("Signup is successfull...");
		}else {
			System.out.println("Button is not enabled for clicking ...");
		}
		
		return this;
	}
}
