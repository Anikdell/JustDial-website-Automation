package com.hackathon.carwashservices;

import java.util.Scanner;

import com.hackathon.Driver.BrowserDriver;
import com.hackathon.freelisting.Freelisting;
import com.hackathon.carwashservices.CarWashServices;

public class Main {

	  public static void main(String[] args) throws Exception {
	        // create BrowerDriver instance
	        BrowserDriver bd = new BrowserDriver();  //Create the object of BrowserDriver class
	        System.out.println("Choose the Browser");  
	        System.out.println("1.Chrome");
	        System.out.println("2.Edge");
	        //create scanner instance
	        Scanner sc = new Scanner(System.in);
	        //get user input
	        int choice = sc.nextInt();

	        //verify the choice
	        if(choice == 1) {
	           bd.initializeDriver("chrome");
	        }else {
	        	bd.initializeDriver("edge");
	        } 

	    }
}