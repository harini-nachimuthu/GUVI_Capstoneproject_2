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

public class Childpassengerpage extends basemethod {
	

	 @FindBy(xpath="//div[contains(text(),'Passenger 2')]")
	//div[contains(text(),'Passenger 2')]
	 WebElement passenger2;
  
  	@FindBy(xpath="(//div[.='Title*'])[2]/following::div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-1ugchlj r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-19554kt r-184en5c\"]")
	WebElement p2title;
	
	@FindBy(xpath="//div[@class=\"css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-rs99b7 r-g93hjn r-1g94qm0 r-yfq7p9 r-1w50u8q r-u8s1d r-19554kt r-8fdsdq\"]/div[2]")
	WebElement p2titleselect;
	
	@FindBy(xpath="//input[@data-testid='traveller-1-first-traveller-info-input-box']")
	WebElement p2firstname;
	
	@FindBy(xpath="//input[@data-testid=\"traveller-1-last-traveller-info-input-box\"]")
	WebElement p2lastname;
  
	//Method used Childpassengerpage constructor
	public Childpassengerpage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}
	
	//Methd used to fill child passenger details
	public Childpassengerpage passengertwo() throws InterruptedException{
		clickbtn(passenger2);
		clickbtn(p2title);
		clickbtn(p2titleselect);
		xpathwebandsend(p2firstname,"Aravind");
		xpathwebandsend(p2lastname,"Kumar");
		Thread.sleep(3000);
		return this;
	}
}
