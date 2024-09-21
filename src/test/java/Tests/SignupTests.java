package Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.basemethod;
import Pages.Signuppage;

public class SignupTests extends basemethod {
	
	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest
	public void beforetest() {
		excelsheet="Capstone2";
		sheetname="Signup";
	}
	
  @Test(dataProvider="readingdatafromexcel",groups= {"regression"},description="Signup Test",priority=1)
  public void signuptest(String first,String last,String number,String email,String newpswd,String cpswd) throws InterruptedException {
	  Signuppage sign=new Signuppage(driver);
	  sign.signupbtnclick();
	  sign.switchtowindow();
	  sign.titleclick();
	  sign.firstnameenter(first);
	  sign.lastnameenter(last);
	  sign.countryselection();
	  sign.dobbutton();
	  sign.flagboxclick(number);
	  sign.emailidenter(email);
	  sign.newpasswrd(newpswd);
	  sign.confirmpasswrd(cpswd);
	  Thread.sleep(2000);
	  sign.agree();
	  Thread.sleep(5000);
	  sign.submit();
  }
  
}
