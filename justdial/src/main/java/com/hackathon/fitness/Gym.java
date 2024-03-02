package com.hackathon.fitness;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.hackathon.utils.Highlight;
import com.hackathon.utils.Screenshot;

public class Gym{
	public static void gym(WebDriver driver,ExtentReports extent) throws InterruptedException {
		
		ExtentTest test;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
	    System.out.println("NAME OF GYM SUBMENU");
	    System.out.println("----------");
	    
		//create a list to store the name of dropdown options
		List<String> optionNames = new ArrayList<>();
        
	    test = extent.createTest(" Click on gym");
	    test.info("Test Started");
		//fetch the webelement of gym
		WebElement gym = driver.findElement(By.xpath("//div[text()='GYM']"));
		Highlight.highlightElement(driver, gym);
        //click on gym element
		gym.click();
        Thread.sleep(3000);
        Screenshot.takeScreenshot(driver, "gym_page");
        test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\gym_page.png").build());
        test.pass("Test Passed");
      
        test = extent.createTest(" Click on sub menu dropdown");
	    test.info("Click on sub menu dropdown");
        //fetch the webelement of dropdown icon to retrieve option name
        WebElement subMenuDropDown = driver.findElement(By.xpath("//div[text()='Services & Amenities']"));
        Thread.sleep(1000);
        Highlight.highlightElement(driver, subMenuDropDown);
        //click on dropdown icon
        subMenuDropDown.click();
        Screenshot.takeScreenshot(driver, "submenu");
        test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\submenu.png").build());
        test.pass("Test Passed");
        
        test = extent.createTest(" Store the submenu name in list");
	    test.info("Test Started");
       // Locate all the  elements (dropdown options)
        for(int i = 1; i < 4 ; i++) {
        	 WebElement dropDownOptions = driver.findElement(By.xpath("//body/div/section/section/div/div[4]/div/div/div/ul/div/div/ul/li["+i+"]/label/div/span[1]"));
             String optionName = dropDownOptions.getText();
             optionNames.add(optionName);
        }
        test.pass("Test Passed");

 
        test = extent.createTest(" Display the submenu names");
	    test.info("Test Started");
        // Iterate through the options and print on the console

          for(String option:optionNames) {
        	  System.out.println(option);
        	  
          }
          test.pass("Test Passed");
          
      	  //To create new report
          extent.flush();
    }
	
}