package com.hackathon.carwashservices;

import java.time.Duration;
import java.util.List; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.util.concurrent.Service;
import com.hackathon.utils.Highlight;
import com.hackathon.utils.Screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class CarWashServices {

	public  void carwash(WebDriver driver,ExtentReports extent) throws InterruptedException {

        ExtentTest test ;
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		 test = extent.createTest(" Click on Dismiss button ");
	     test.info("Click on Dismiss button");
		// Dissmiss the loginpage popup 
		WebElement dissmiss = driver.findElement(By.xpath("//body/div/div/section/div/section[1]/div/div/div[2]/span"));
		Thread.sleep(1000);
		Screenshot.takeScreenshot(driver, "loginpage");
		test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\loginpage.png").build());
		Highlight.highlightElement(driver, dissmiss);
		dissmiss.click();
		test.pass("Test Passed");
		Thread.sleep(3000);

		// Coming to Homepage it will take screensort
		test = extent.createTest(" Homepage");
		test.info("Homepage");
		Screenshot.takeScreenshot(driver, "Homepage");
		test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\Homepage.png").build());
		
		// Locate the search input field and enter "Car washing services" as the search
		test = extent.createTest(" Enter input in seach");
	    test.info("Enter input in seach");
		WebElement searchInput = driver.findElement(By.xpath("//input[@id='main-auto']"));
		Highlight.highlightElement(driver, searchInput);
		searchInput.click();
		searchInput.sendKeys("Car wash services");
		Screenshot.takeScreenshot(driver, "searchPage");
		test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\searchPage.png").build());
		test.pass("Test Passed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// adding 3 second wait before searching
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Highlight.highlightElement(driver, dissmiss);
		// searching will start
		searchInput.sendKeys(Keys.ENTER);

		// Wait 5 second for the results to load
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
	    test = extent.createTest(" Click on dropdown to filter option");
	    test.info("Test Started");
		// sorting the results by ratings
		WebElement sortdropdwn = driver.findElement(By.xpath("//div[@class='jsx-6ab5af3a8693e5db font15 fw500 mr-6']"));
		Thread.sleep(3000);
		Highlight.highlightElement(driver, sortdropdwn);
		sortdropdwn.click();

		// Wait for 3 second forthe dropdown menu to appear
		Thread.sleep(3000);

		// Selecting "rating" from the drop down list
		WebElement ratingMenu = driver.findElement(By.xpath("//body/div/section/section/div/div[4]/div/div/div/ul/div/div/ul/li[2]/label/div/span[2]"));
		Highlight.highlightElement(driver, ratingMenu);
		ratingMenu.click();
		test = extent.createTest(" car_service_page");
	    test.info("car_service_page");
	    // Wait 3 second for the results to sort and load
		Thread.sleep(3000);
		Screenshot.takeScreenshot(driver, "car_service_page");
		test.log(Status.INFO, "Step details", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\ScreenShot\\car_service_page.png").build());
		test.pass("Test Passed");

	    test = extent.createTest("Display car wash services name");
	    test.info("Test Started");
		// Fetch the top 5 car wash services name as well as rating of services in the console
		for (int j = 1; j < 6; j++) {
			List<WebElement> serviceName = driver.findElements(By.xpath("//*[@id=\"jdresult_box\"]/div[1]/div/div[1]//h2"));
			List<WebElement> ratings = driver.findElements(By.xpath("//body/div/section/section/div/div[5]/div/div/div/div[\"+j+\"]/div/div/div/div[2]/div[1]/div[1]"));
			WebElement ss = serviceName.get(j);
			WebElement rr = ratings.get(j);
			System.out.printf(ss.getText() + " ");//It will print service name Of top 5 car wash services
			Thread.sleep(3000);
			System.out.println("" + rr.getText());//It will print rating Of top 5 car wash services
			System.out.println("--------------------------------------------------");
		}

		System.out.println("--------------------------------------------------");
		test.pass("Test Passed");
		
		//To create new report
		extent.flush();

		// wait for results to get printed before quitting the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//navigate back to homepage
		driver. navigate(). back();
	}

}
