package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.basemethod;
import Pages.Loginpage;
import Pages.Signuppage;

public class Logintest extends basemethod {
	
	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest
	public void before() {
		excelsheet="Capstone2";
		sheetname="Login";
	}
	
  @Test(dataProvider="readingdatafromexcel",groups= {"regression"},description="Login Test",priority=2)
  public void login(String number,String password,String xpath1,String expected) throws InterruptedException {
	  Signuppage sign=new Signuppage(driver);
	  sign.signupbtnclick();
	  sign.switchtowindow();
	  Loginpage log=new Loginpage(driver); 
	  log.logindetails(number, password);
	  actandexpec(xpath1,expected); 
  }
  
 
}
