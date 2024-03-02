package com.hackathon.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Highlight{
		 
	public static void highlightElement(WebDriver driver, WebElement element) {
		        try {
		            JavascriptExecutor js = (JavascriptExecutor) driver;

		            // Store the original element style
		            String originalStyle = element.getAttribute("style");
  
		            String borderColor = "red";
		            String backgroundColor = "yellow";
		            
		            // Use JavaScript to set the element's border and background colors
		            js.executeScript("arguments[0].style.border='2px solid " + borderColor + "';"
		                    + "arguments[0].style.backgroundColor='" + backgroundColor + "';", element);
		            

	

		            // Wait for a short duration
		            Thread.sleep(500);

		            // Restore the original element style
		            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
