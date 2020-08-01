#### Description
It is a Java Selenium DataDriven Framework made with Maven & TestNG for Web Applications in GUI & Non-GUI Mode.<br>
It can also used for testing Rest API's functionality using Rest-Assured.

#### Project Structure
```
  Root
    ├── src/test
    │	├── Apis
    │	├── Common
    │	├── Config
    │	├── Links
    │	├── Listeners
    │	├── Locators
    │	├── Test Scripts
    │	└── Utilities  	
    ├── Files    
    ├── JarFiles
    ├── Logs
    ├── Reports
    ├── ScreenShots
    ├── TestDataFiles
    ├── pom.xml
    └── testNG.xml
```

#### Data File Design
![Data File Design](https://github.com/GvvPrasad/javaSeleniumFramework/blob/master/Files/DataFileTemplate.PNG)

#### Package's Details
* apis -		It contains the TestCases for testing Rest API's of  "Get, Post, Put and Delete"
* common -		It contains several Methods that are useful while creating and Executing TestCases 
* config -		It contains the properties files of the Application, Mails, logs & ObjectRepository
* links -		It contains the TestCases for checking links and 404 Errors in a given single web page 		
* listeners -	It contains TestNGListener, RetryAnalzer 
* locators -	It contains the locators files of the application
* testscripts - It contains the Base file and TestCase Scripts
* utilities -	It contains ExcelUtilities, Reportgeneration and Mail configuration  

#### WorkFlow
![Data File Design](https://github.com/GvvPrasad/javaSeleniumFramework/blob/master/Files/AuroWorkFlow.png)


When TestScript / testNG.xml is executed, 1st Base Class is executed it contain the Browser and Application Url Details, it get it's data from AppConfig, AppConfig get details from AppProperties.<br>

The TestData is taken from the Excel Sheet with the help of ExcelMethods contains in the ExcelUtilities File.<br>
 
The Locators values are present in Locators package, the TestData pass to the locators by using "getData" Method present in the ExcelUtil and by "@DataProvide" TestNG annotation<br>

If the Testcase is fail, the TestCase method is sent to RetryAnalyzer, the method will execute again(base on condition) if it reach the max count then it is consider as Failed testcase and it moves to TestNGListener and a screenshot is taken.<br>

<b>Optional</b><br> 
After all Testcase are completed logs, HTML and Excel Reports are generated.<br>
The Reports can be sent as mail also. 

#### Usage
Clone the project

```
git clone https://github.com/GvvPrasad/frameworkStructure.git
```

Configure build path to generate Excel Reports Using "ATExcelReport". The "ATExcelReport" Jar files are located in the "JarFiles" Folder 
         
#### Pending/Issues
* Methods related to Dates