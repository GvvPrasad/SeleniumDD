# Selenium DD Framework

#### Description
A framework that is made with Selenium and TestNG with Java Programming language which can be used to create web-based automation scripts.<br>

#### Project Structure
```
  Root
    ├── src/main/java
    │	├── Base
    │	├── init
    │	│	└── Email
    │	│	└── ObjectRepository
    │	│	└── PropertiesFile
    │	│	└── ReportsGeneration
    │	├── listeners
    │	└── Utilities
    │		 └── BrowserUtil
    │		 └── CommomMethods
    │		 └── DataBase
    │		 └── ExcelUtil
    │		 └── WebElements
    ├── src/main/resources
    │	├── App.properties
    │	└── log4j2.xml  	
    ├── src/test/java    
    │	├── Links
    │	├── PageObjects
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

#### Package's Details
|Package Names|Description           							                                                                                   |
|:------------|:-----------------------------------------------------------------------------------------------------------------------------------|
|Base		  | Here we initiate Browser and its Desired Capabilities, initiate of Reports and closing Browser     |
|init		  |	It consists of Email Program, ObjectRepository Properties File and Reports Generation File |
|Listeners	  |	It consists of TestNG Listeners and RetryAnalyzer		                                                                           |
|Utilities	  |	It consists of Utilities of Browser, Web Elements, Excel, Database and commom Methods 		                                                                   
|Links		  |	It consists of class file for checking the all the links and for 404Errors and other domain		                                   |
|PageObjects  |	It consists of locators for each web page in separate class file 		                                                           |
|TestScripts  |	It consists of test scripts files as class files                		                                                           |


#### Data File Design
![Data File Design](https://github.com/GvvPrasad/javaSeleniumFramework/blob/master/Files/TestDataTemplate.PNG)


#### WorkFlow
 

#### Usage
Clone the project

```
git clone https://github.com/GvvPrasad/SeleniumDD.git
```

Configure build path to generate Excel Reports Using "ATExcelReport". The "ATExcelReport" Jar files are located in the "JarFiles" Folder 
         
#### Pending/Issues
* Methods to Dates
* Create Excel file, sheet, row, column  
* Writing into excel dynamically