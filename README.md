# JustDial-website-Automation


## Team Members
	1. Anik Mitra  


Problem Statement : Identify Car Wash Services.
1. Display 5 Car washing services name, near your location with highest rating on top.
3. Try to register for Free Listing, fill the form with any one input invalid (example: phone); Capture the error message & display.
4. From Fitness, go to Gym and retrieve all sub-menu items and store in a List; Display the same.
	
	

## Key Automation Scope
1. Handling Alert, search option
2. Multiple navigation path for one page
3. Filling form (in different objects in web page)
4. Capture warning message
5. Extract menu items & store in collections
6. Navigating back to home page

### Objectives

## 1. Go to "JustDial" website abd search for "car Wash Services", sort the results by 'ratings" and fetch the name as well as rating of top 5 car wash services, in descending order of their ratings (eg: 5.0>4.8>4.6...);

## 2. Go to the FreeListing section on the Justdial website, try to register for free listing by filling the form with any one input as invalid (we have choosen "Phone number"), capture and fetch the error message.      

## 3. Go the fitness section on the JustDial website, go to "Gym" and retrieve all the sub-menu facilities of Gym and store it in a list along with the Gym name. 



The project will provide an automated solution to perform these tasks efficiently, saving time and effort for the user. It aims to streamline the process of **  on the JustDial website.

### The project is organized into 8 classes:

*Classes*: Contains the following classes:
   		          1. Main.java
                2. BrowserDriver.java
                3. CarwashServices.java
                4. FreeListing.java
                5. Gym.java
                6. Highlight.java
                7. Screenshot.java
                8. ExtentReport.java
    	       


### How to Run the Project

	1. Import the project into Eclipse IDE. It will automatically open the Package Explorer.
	2. Download the appropriate drivers for your web browser version from the internet.
	3. After downloading the drivers, extract them and copy them. Go back to Eclipse IDE, right-click on the project folder, and paste the drivers.
	4. Expand src/main/java, then expand the Utilities package, and open DriverSetup.java.
	5. In the DriverSetup class, go to the Webdriver class and provide the path to the drivers according to your configuration. You can get the path of the drivers by right-clicking on the project folder, selecting Properties, and navigating to the location where you pasted the drivers.
	6. Open the application.properties file and specify the browser you want to use for automation by removing "chrome" from the second line.
	7. You can now run the program by opening src/test/java, expanding the Test package, and opening Main.java. You can run the tests by clicking "Run as Java Application"
### Key Automation Scope

	The automation script aims to achieve the following key objectives:

         Handling different browser windows
         Handling dropdown option
         Handling  to home page
         Extract multiple date & store in list
         Data Driven approach
         Cross Browser

### Technology & Tools Used:

        -Selenium WebDriver
        -Java
        -Maven
        -POM
        -Java
        -HTML Extent Report




### Changes made from the given cases:
-Did not fetch phone numbers
-Did not filter the results with only rating more than 4. 




By automating these tasks, the script provides an efficient solution for users to retrieve information from the Justdial website, saving time and effort.

*******************************************************FILES DESCRIPTION**************************************************************

1.src/main/java - There are three packages present in this folder.
     ->Property:In this package we have config.properties. In this File we have to give from user to use which browser 
     chrome/microsoftedge etc.
2.JRE System Library: In this File we have all dependencies of JAR.files.         
3.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. 
  when a Maven build is executed, Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.   
4.Drivers- In this folder, the chorme driver,microsoftedge and gecko driver are present
5.ScreenShot:There are images of different test cases.
6.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project 
  such as dependencies, build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes 
  the goal.
 
***************************************************************************************************************************************
