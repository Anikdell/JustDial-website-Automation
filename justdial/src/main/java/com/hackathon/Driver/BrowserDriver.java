package com.hackathon.Driver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.hackathon.carwashservices.CarWashServices;
import com.hackathon.fitness.Gym;
import com.hackathon.freelisting.Freelisting;
import com.hackathon.utils.ExtentReport;



public class BrowserDriver {
	
	  WebDriver driver; //it holds the instance for browser automation
	  String baseUrl = "https://www.justdial.com/";  // This is our suggested url
	  
	  //Created all the classes instance
	  CarWashServices cws = new CarWashServices();
	  Freelisting lg = new Freelisting();
	  ExtentReports extent=ExtentReport.generateExtent() ;
      

	  @SuppressWarnings("deprecation")
	public void initializeDriver(String browser) throws Exception{
	        //Check if parameter passed as 'chrome'
	        if(browser.equalsIgnoreCase("chrome")){
	        	//set path to chromedriver.exe
	            System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\Driver\\chromedriver.exe");
	            
	        	ChromeOptions options = new ChromeOptions();
	    		options.addArguments("--disable-blink-features=AutomationControlled");
	    	     options.addArguments("--disable-notifications");
	    		WebDriver driver = new ChromeDriver(options);
	    		Actions actions = new Actions(driver);
	            driver.manage().window().maximize();
	            initiateWebPage(driver);
	           
	        }
	        //Check if parameter passed as 'edge'
	        else if(browser.equalsIgnoreCase("edge")) {
              //set path to IE.exe
              System.setProperty("webdriver.msedge.driver","C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\Driver\\msedgedriver.exe");
              EdgeOptions options = new EdgeOptions();
              options.addArguments("--disable-blink-features=AutomationControlled");
              //create edge instance
              driver = new EdgeDriver();
              initiateWebPage(driver);
	        }
	        else{
	            //If no browser passed throw exception
	            System.out.println("Entered Browser is not available");
	        }

	        Thread.sleep(5000);
	        
	     }
	    

           public void initiateWebPage(WebDriver driver) throws InterruptedException{
               driver.manage().window().maximize();
                //Go to the website
                driver.get(baseUrl);
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               cws.carwash(driver,extent);
               Thread.sleep(3000);
               lg.log(driver,extent);
               Thread.sleep(3000);
               Gym.gym(driver,extent);
               driver.quit();
	
          }
	

}

