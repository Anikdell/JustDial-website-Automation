package com.hackathon.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports generateExtent() {
		// TODO Auto-generated method stub
		ExtentReports extent;
		 extent = new ExtentReports();
		  ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\DELL\\OneDrive\\Desktop\\Hackathon\\New folder\\justdial\\extentreport\\extentreport.html");
		  extent.attachReporter(htmlReporter);
		  return extent;


	}

}

