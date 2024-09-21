package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.basemethod;
import Pages.validatepage;

public class validatetest extends basemethod{
	
	//Before execution of test this method get excel file name and sheet name from that datas will read out.(Data Driven testing)
	@BeforeTest
	public void before() {
		excelsheet="Capstone2";
		sheetname="Validatebtns";
	}
	
	@Test(dataProvider="readingdatafromexcel",groups= {"regression"},description="Validation Test",priority=5)
	public void validate(String xpath1,String xpath2,String text) throws InterruptedException {
	  validatepage validate=new validatepage(driver);
	  validate.validatehomebtns(xpath1,xpath2,text);
	}
}
