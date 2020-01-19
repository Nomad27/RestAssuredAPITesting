# RestAssuredAPITesting
Rest APIs Testing

# Project Structure
The project follows the standard Maven structure, so all the tests go in the src/test/java folder.We have used the RestAssured Automation tool to automate the Rest APIs.For reporting we have used the Allure with Testng.

Pre-requisite - Eclipse,Java should be installed on the machine

              - Download the Maven and Allure for Reporting
              
                Download link for Allure, Please choose *.zip file for windows 
                https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.10.0/
                
                Download link for Maven
                https://maven.apache.org/download.cgi
                
              - Extract the Maven and Allure into the C Folder (ex: C:\apache-maven-3.6.3, C:\allure-2.10.0)
                Add "C:\allure-2.10.0\bin", "C:\apache-maven-3.6.3\bin" to system PATH.
                
                Please check if the Allure and apache is insatlled or not                
                Run the allure --version, mvn --version command on command prompt.
                
# Project Configuration Steps 

               1.Clone this repository CLONE

               2.Import project in Eclipse as a Maven Project

               3.Run clean install target of Maven project

               4.Right click on 'testng.xml'

               5.Run as TestNG suite

               6.Location of report (Refresh the project to find report folder "allure-results").Reports will be in Json format here.
  
               7. Please open the windows command prompt and run the 
               C:\Users\*\>allure serve *\RestAssuredAPITesting\allure-results (It will generate the report and you will see the test                  reports in the browser).
  
                
 Referneces: https://docs.qameta.io/allure/
