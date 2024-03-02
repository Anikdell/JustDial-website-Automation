package com.hackathon.freelisting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.hackathon.utils.Highlight;
import com.hackathon.utils.Screenshot;

public class Freelisting {

	public  void log(WebDriver driver,ExtentReports extent) throws InterruptedException {
		// TODO Auto-generated method stub

        // Wait for 5 sec for Simulate human-like interaction
        Thread.sleep(5000);
       
        ExtentTest test;


        //Click Free Listing 
        test = extent.createTest(" Clicked on free listing");
	    test.info("Clicked on free listing");
        WebElement freeListingLink = driver.findElement(By.xpath("//*[text()='Free Listing']"));
        Highlight.highlightElement(driver, freeListingLink);
        freeListingLink.click();
        Screenshot.takeScreenshot(driver, "free_listing_page");
        test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\free_listing_page.png").build());
        test.pass("Test Passed");
        
        //Wait for 3 second for appering the freelisting form appear
        Thread.sleep(3000);
        
        // Fill the Company Name
        test = extent.createTest(" Enter company name");
	     test.info("Test Started");
        WebElement companyNameInput = driver.findElement(By.id("fcom"));
        Highlight.highlightElement(driver, companyNameInput);
        companyNameInput.sendKeys("Example company");
        Thread.sleep(3000);
        test.pass("Test Passed");
        
        // Click titel dropdown
        test = extent.createTest(" Click on title dropdown");
	     test.info("Test Started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement titleDropDown = driver.findElement(By.xpath("//span[@class='slct']/span[2]"));
        Highlight.highlightElement(driver, titleDropDown);
        titleDropDown.click();
        test.pass("Test Passed");
        
        
        test = extent.createTest(" Click on type of title ");
	     test.info("Test Started");
	    // Select titel dropdown as Mr.
        WebElement titleMr = driver.findElement(By.xpath("//a[normalize-space()='Mr']"));
        Highlight.highlightElement(driver, titleMr);
        titleMr.click();
        Thread.sleep(3000);
        test.pass("Test Passed");
        
        test = extent.createTest(" Enter first name");
	    test.info("Test Started");
        // Fill the First Name
        WebElement firstNameInput = driver.findElement(By.id("fname"));
        Highlight.highlightElement(driver, firstNameInput);
        firstNameInput.sendKeys("Anik");
        test.pass("Test Passed");
        Thread.sleep(3000);
        
        
        test = extent.createTest(" Enter last name");
	     test.info("Test Started");
        // Fill the Last Name
        WebElement lastNameInput = driver.findElement(By.id("lname"));
        Highlight.highlightElement(driver, lastNameInput);
        lastNameInput.sendKeys("Mitra");
        test.pass("Test Passed");
        Thread.sleep(3000);
        
        test = extent.createTest("Entered mobile number");
	     test.info("Test Started");
        // Fill the Mobile Number
        WebElement mobileInput = driver.findElement(By.id("fmb0"));
        Highlight.highlightElement(driver, mobileInput);
        mobileInput.sendKeys("62875");
        test.pass("Test Passed");
        Thread.sleep(3000);
        
        test = extent.createTest(" Click on submit button");
	     test.info("Test Started");
        // Click on the Submit button
        WebElement submitButton = driver.findElement(By.xpath("//*[text()='Submit']"));
        Highlight.highlightElement(driver, submitButton);
        submitButton.click();
        Thread.sleep(3000);
        
        test = extent.createTest(" Captur error message");
	    test.info("Captur error message");
	     
        // Capture and display the error message
        WebElement errorMessage = driver.findElement(By.id("fmb0Err"));
        Screenshot.takeScreenshot(driver, "error_message");
        test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\error_message.png").build());
        System.out.println("Error Message: " + errorMessage.getText());
        test.pass("Test Passed");
        
    	//To create new report
        extent.flush();
        
        //navigate back to homepage
        driver. navigate(). back();
        System.out.println("--------------------------------------------------");
	}

}
