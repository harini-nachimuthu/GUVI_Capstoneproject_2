package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utils {
	//Initialising varaiable
	public static WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public String excelsheet;
	public String sheetname;

	//Launching browser and url
	public void launchingbrowserandurl(String browser, String url) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
//			options.addArguments("--headless"); 
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("-private");
//			options.addArguments("--headless"); 
			driver = new FirefoxDriver(options);
		} else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--incognito");
			options.addArguments("--headless"); 
			driver = new ChromeDriver(options);
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(55));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(45));
	}
	
	//Methode using close to close the browser
	public void closebrowser() {
		if (driver != null) {
			driver.close();
		}
	}
	
	//Method is using quit to quit the browser
	public void quitbrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	//Method is using click to click button using webdriverwait to check their visibility and element to be clickable
    public void clickbtn(WebElement ele) throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOf(ele));
    	wait.until(ExpectedConditions.elementToBeClickable(ele));
    	ele.click();
    }

    //Method is using id locator to check visibility of element and sendkeys
    public void idandsendkeys(String id, String keys) {
    	WebElement Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))); 
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Field);
    	Field.clear();
        Field.sendKeys(keys);
    }
    
  //Method is using xpath locator to check visibility of element and sendkeys 
    public void xpathandsendkeys1(String xpath, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(text);
    }
    
    //Method is using to read the data from excel sheet
    public String[][] gettingdatafromexcel(String excelsheet,String sheetname) throws IOException{
    	XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\harin\\eclipse-workspace\\Capstone_2\\Excelsheet\\"+excelsheet+".xlsx");
    	XSSFSheet sheet=book.getSheet(sheetname);
    	int rowcount=sheet.getLastRowNum();
    	int columncount=sheet.getRow(0).getLastCellNum();
    	
    	String[][] data=new String[rowcount][columncount];
    	
    	for(int i=1;i<=rowcount;i++) {
    		XSSFRow row=sheet.getRow(i);
    		for(int j=0;j<columncount;j++) {
    			XSSFCell cell=row.getCell(j);
    			
    			if(cell==null) {
    				data[i-1][j]="";
    			}else {
    				switch(cell.getCellType()) {
    				case STRING:
    					data[i-1][j]=cell.getStringCellValue();
    					break;
    				case NUMERIC:
    					data[i-1][j]=String.valueOf(cell.getNumericCellValue());
    					break;
    				case BOOLEAN:
    					data[i-1][j]=String.valueOf(cell.getBooleanCellValue());
    					break;
    				case FORMULA:
    					data[i-1][j]=cell.getCellFormula();
    					break;
    				default:
                        data[i-1][j] = "";
    				}
    			}
    		}
    	}
    	return data;
    }
   
    //Method used to check actual and expected text 
    public void actandexpec(String xpath,String expectedtext) {
    	WebElement actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""+xpath+"")));
        String actualtext=actual.getText();
        System.out.println("Actual text is :"+ actualtext);
        System.out.println("Expected text is : "+expectedtext);
        if (actualtext.equals(expectedtext)) {
            System.out.println("Test Passed: Actual text: " + actualtext + " | Expected text: " + expectedtext);
        } else {
            System.out.println("Test Failed: Actual text: " + actualtext + " | Expected text: " + expectedtext);
        }
        
        
    }
    
    //Method used to check visibility of webelement and sendkeys
   public void xpathwebandsend(WebElement web,String keys) {
	   wait.until(ExpectedConditions.visibilityOf(web));
	   wait.until(ExpectedConditions.elementToBeClickable(web)).sendKeys(keys); 
   }
   
   //Method is using xpath locator to find element and click the button using javascriptexecutor
   public void clickbtnxpath(String xpath) {
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		   WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		   js.executeScript("arguments[0].scrollIntoView(true);", ele);
		   js.executeScript("arguments[0].click()", ele);
		   String data=ele.getText();
		   System.out.println("Validation successfull: "+data);
   }
   
   //Method used to click the button with help of actions class
   public void actionbtnclick(WebElement ele){
			Actions act = new Actions(driver);
			act.click(ele).build().perform();
	}

   //Method used to click button using javascriptexecutor
   public void clickbtnjs(WebElement ele) throws InterruptedException {
   	wait.until(ExpectedConditions.visibilityOf(ele));
   	wait.until(ExpectedConditions.elementToBeClickable(ele));
   	js.executeScript("arguments[0].scrollIntoView(true);", ele);
   	ele.click();
   }
   
   //Method used to takescreeshot 
   public String takeScreenshot(String screenshotName,String browser) throws IOException {
       File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
       String filename = browser+"_"+screenshotName + "_" + time + ".png";
       String path = "C:\\Users\\harin\\eclipse-workspace\\Capstone_2\\Screenshots\\" + filename;
       System.out.println("Screenshot" +path);
       File dest = new File(path);
       FileUtils.copyFile(src, dest);
       return path;
   }
   
   //Method used to click button using webdriverwait and click that button using javascriptexecutor
   public void bothclickbtnjs(WebElement ele) throws InterruptedException {
	   	wait.until(ExpectedConditions.visibilityOf(ele));
	   	wait.until(ExpectedConditions.elementToBeClickable(ele));
	   	js.executeScript("arguments[0].scrollIntoView(true);", ele);
	   	js.executeScript("arguments[0].click()", ele);
	   }
}
