# PayBox
To run the test cases follow below steps:
1. Download the project.
2. Access the run.bat file at the root directory. Edit the bat file and change the dir to the root folder where the project gets downloaded.

Alternatively,
1. Open the terminal\command prompt and navigate to the root directory of the project where the project is downloaded.
2. Type and run mvn clean install.

The test classes take parameters from the testng.xml file for browser value and folder name for adding new folders and uploading files. Feel free to change these values to test with different inputs. 

NOTE: Because of captcha, the data driven login test cases may fail. You may have to manually login to execute the captcha and then run the data driver login test cases again. 

The project uses:
Java version 1.8
Selenium version 3
TestNG as a Testing Framework
Maven to add dependencies and to run testng.xml file
WebDriverManager to dynamically install and use drivers for browser
Apache POI for Data Driven Testing
Page Object Model for storing page objects and actions performed on them.
TestUtils class to provide utility methods for reading from and writing to xls\xlsx files, explicit wait for web elements, and so on.


Description of all the Classes are available as comments at the beginning of each class.
