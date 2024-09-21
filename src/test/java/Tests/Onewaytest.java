package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.basemethod;
import Pages.Loginpage;
import Pages.Passengerpage;
import Pages.Primarypassengerpage;
import Pages.Trippage;
import Pages.Signuppage;

public class Onewaytest extends basemethod{

	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest
	public void beforetest() {
		excelsheet="Capstone2";
		sheetname="Defaultpassengersdetails";
	}
  
  @Test(dataProvider="readingdatafromexcel",groups= {"regression"},description="Oneway Test",priority=3) 
  public void oneway(String firstname,String lastname,String mobilenumber,String emailid,String town) throws InterruptedException {
//	  Signuppage sign=new Signuppage(driver);
//	  sign.signupbtnclick();
//	  sign.switchtowindow();
//	  Loginpage log=new Loginpage(driver); 
//	  log.crctlogindata();
	  Trippage triponeobj=new Trippage(driver);
	  triponeobj.onewaydata1();
	  Passengerpage passenger=new Passengerpage(driver);
	  passenger.passengersdefaultdetails(firstname, lastname, mobilenumber,emailid ,town );
	  Primarypassengerpage primary=new Primarypassengerpage(driver);
	  primary.primarypassengerdetails();
	  primary.passengercontinuebtn();
	  Thread.sleep(5000); 
  }
}
