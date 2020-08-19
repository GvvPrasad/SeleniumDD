#### Description
It is a Java Selenium DataDriven Framework made with Maven & TestNG for Web Applications in GUI & Non-GUI Mode.<br>
It can also used for testing Rest API's functionality using Rest-Assured.

#### Project Structure
```
  Root
    ├── src/main/java
    │	├── Base
    │	├── Common
    │	├── Config
    │	│	└── ObjectRepository
    │	│	└── PropertiesFile
    │	├── Listeners
    │	└── Utilities
    ├── src/main/resources
    │	├── App.properties
    │	└── log4j2.xml  	
    ├── src/test/java    
    │	├── Apis
    │	├── Links
    │	├── Locators
    │	└── TestScripts
    ├── src/test/resources
    │	└── Test Data Files
    ├── Files
    ├── JarFiles
    ├── Logs
    ├── Reports
    ├── ScreenShots
    └── testNG.xml
```

#### Data File Design
![Data File Design](https://github.com/GvvPrasad/javaSeleniumFramework/blob/master/Files/DataFileTemplate.PNG)

#### Package's Details
|Package Names|Description           							                                                                               |
|:------------|:-------------------------------------------------------------------------------------------------------------------------------|
|Base		  | It consists of Base class file where we initiate Browser and its Desired Capabilities, initiate of Reports and closing Browser |
|Common		  |	It consists of several common methods which can be used across entire application like wait, screenshot, scroll, Mouse Events  |
|Config		  |	It consists of ObjectRepository, here we define all the variable and properties file to access ".properties" file		       |
|Listeners	  |	It consists of TestNG Listeners and RetryAnalyzer		                                                                       |
|Utilities	  |	It consists of Utilities of Excel files, Reports and Email 		                                                               |
|Apis		  |	It consists of API test case of POST, GET, PUT and DELETE                                                        		       |
|Links		  |	It consists of class file for checking the all the links and for 404Errors and other domain		                               |
|Locators     |	It consists of locators for each web page in separate class file 		                                                       |
|TestScripts  |	It consists of test scripts files as class files                		                                                       |

#### WorkFlow
 

#### Usage
Clone the project

```
git clone https://github.com/GvvPrasad/frameworkStructure.git
```

Configure build path to generate Excel Reports Using "ATExcelReport". The "ATExcelReport" Jar files are located in the "JarFiles" Folder 
         
#### Pending/Issues
* Methods related to Dates
* Writing into excel dynamically
* Attaching the screen to reports