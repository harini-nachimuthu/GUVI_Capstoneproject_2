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
import org.testng.annotations.Test;

import Base.basemethod;

public class validatepage extends basemethod{
 
	@FindBy(xpath="(//div[contains(text(),'check-in')])[1]")
	WebElement checkin;
	
	@FindBy(xpath="(//div[contains(text(),'flight status')])[1]")
	WebElement flightstatus;
	
	@FindBy(xpath="(//div[contains(text(),'manage booking')])[1]")
	WebElement managebooking;
	
	//Method used for validatepage constructor
	public validatepage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver; 
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}

	//Method used to check given button in homepage is clickable
	public validatepage validatehomebtns(String xpath1,String xpath2,String text) throws InterruptedException {
		WebElement data=driver.findElement(By.xpath(""+xpath1+""));
		if(data.isDisplayed()&& data.isEnabled()) {
			clickbtn(data);
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""+xpath2+"")))!=null) {
				System.out.println(data.getText()+" - Validation sucessfull : "+text);
			}else {
				System.out.println(data.getText()+" - Validation not successfull : "+text);
			}
		}else {
			System.out.println("Validation not successfull");
		}
		return this;
	}
}
