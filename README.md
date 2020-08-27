#### Description
It is a Selenium Java DataDriven Framework made with Maven & TestNG for Web Applications in GUI & Non-GUI Mode.<br>
It also consists of Rest-Assured methods for testing Rest API's

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
    │		└── Email
    │		└── Excel
    │		└── ReportsGeneration
    ├── src/main/resources
    │	├── App.properties
    │	└── log4j2.xml  	
    ├── src/test/java    
    │	├── Links
    │	├── Locators
    │	└── TestScripts
    ├── src/test/resources
    │	└── Test Data Files
    ├── DownloadFiles
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
|Package Names|Description           							                                                                                   |
|:------------|:-----------------------------------------------------------------------------------------------------------------------------------|
|Base		  | It consists of Base class file where we initiate Browser and its Desired Capabilities, initiate of Reports and closing Browser     |
|Common		  |	It consists of several common methods which can be used across entire application like wait, screenshot, scroll, Mouse Events etc  |
|Config		  |	It consists of ObjectRepository, here we define all the variable and properties file to access ".properties" file		           |
|Listeners	  |	It consists of TestNG Listeners and RetryAnalyzer		                                                                           |
|Utilities	  |	It consists of Utilities of Excel files, Reports and Email 		                                                                   |
|Links		  |	It consists of class file for checking the all the links and for 404Errors and other domain		                                   |
|Locators     |	It consists of locators for each web page in separate class file 		                                                           |
|TestScripts  |	It consists of test scripts files as class files                		                                                           |

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