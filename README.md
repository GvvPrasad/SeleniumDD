#### Description
It is a Java Selenium DataDriven Framework made with Maven & TestNG for Web Applications. 

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

#### Usage
Clone the project

```
git clone https://github.com/GvvPrasad/frameworkStructure.git
```

Configure build path to generate Excel Reports Using "ATExcelReport". The "ATExcelReport" Jar files are located in the "JarFiles" Folder 

#### Data File Design
![Data File Design](https://github.com/GvvPrasad/javaSeleniumFramework/blob/master/JarFiles/DataFileTemplate.PNG)

#### Naming Convention
* Project -		camelCase (mixed case with the first letter lowercase and with the first letter of each internal word capitalized)
* Packages -	All lowercases, reverse domain name with package name
* Classes -		Mixed case with the first letter of each internal word capitalized 
* Variables -	camelCase (mixed case with the first letter lowercase and with the first letter of each internal word capitalized)
* Methods -		camelCase (mixed case with the first letter lowercase and with the first letter of each internal word capitalized)

#### Package's Details
* apis -		It contains the Test Cases for testing API's of  "Get, Post, Put and Delete"
* common -		It contains several Methods that are useful while creating testcases 
* config -		It contains the properties files of the Application, Mails and logs
* links -		It contains the TestCases for checking links and 404 links in a given single web page 		
* listeners -	It contains TestNGListener, RetryAnalzer 
* locators -	It contains the locators files of the application
* testscripts - It contains the Base file and Test Case Scripts
* utilities -	It contains Excel utilities, Reports generation file, Email and application config files

#### WorkFlow
A TestScript is created only with testSecenario with "@Test" TestNG attribute.<br>
When TestScript is executed, 1st Base Class is executed it contain the Browser and Application Url Details, it get it's data from AppConfig and AppProperties.<br>
The Locators values are present in Locators package, the TestData pass to the locators by using "getData" Method present in the ExcelUtil Class file from ExcelSheet. <br>
If Testcase is fail, the TestCase method is sent to RetryAnalyzer call file and execute again(base on condition) if it reach the max count then it is consider as Failed testcase and it moves to TestNGListener and a screenshot is taken.<br>
After all Testcase are completed HTML and Excel Reports are generated. 
         
#### Pending
* Checking Data has Date value or not
* Writing Data into Excel
* API Testing using Json File