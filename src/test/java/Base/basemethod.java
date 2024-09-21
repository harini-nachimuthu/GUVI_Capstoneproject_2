package Base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utility.utils;

public class basemethod extends utils {
	
	public String url="https://www.spicejet.com/";

	//This method will be executed before the method of every tests
    @BeforeMethod
    @Parameters("browser")
    public void beforeSuite(String browser) {
        launchingbrowserandurl(browser,url);
    }

    //This method used to retrieve data from excel using dataprovider
    @DataProvider(name="readingdatafromexcel")
    public String[][] readingexcel() throws IOException{
    	return gettingdatafromexcel(excelsheet,sheetname);
    }
    
    //This method will be executed after the method of every tests
     @AfterMethod
     public void afterSuite() {
         quitbrowser();
     }
}
