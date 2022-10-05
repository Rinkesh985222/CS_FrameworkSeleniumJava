package com.mystore.testcases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.mystore.utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//public static WebDriver driver;

	public static Logger logger;

	Readconfig readconfig=new Readconfig();
	String url=readconfig.getbaseurl();
    //String browser=readconfig.getbrowser();
	
	public static WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		
		switch(browser.toLowerCase())
		{
		
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();

			break;

		case "msedge":

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		default:
        driver = null;
     	break;
            
		}

		//implicit wait of 10 second
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       //for logging
       logger = LogManager.getLogger("MyStoreV1");
       
     //open url
		
     		driver.get(url);
     		logger.info("url opened");
      
    }
    
	@AfterClass
	public void tearDown() {
		
	driver.close();
		driver.quit();
	}
	
	public void capturescreenshot(WebDriver driver, String testname) throws IOException  {
		
		
		//capture full page screenshot
		//step1:convert webdriver object to TakesScreenshot interface
		
		TakesScreenshot screenshot= ((TakesScreenshot)driver);
		
		//Step2:call getScreenshotAs method to create image file
		
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		
        File dest=new File(System.getProperty("user.dir")+"//screenshots//"+testname+".png");
       
        //Step3:Copy Image file to destination
         FileUtils.copyFile(src, dest);

	} 

}

