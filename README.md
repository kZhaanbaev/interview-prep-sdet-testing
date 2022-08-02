

#### What is POM (Page Object Model)?
Page Object Model is a Design Pattern which has become popular in Selenium Test Automation. It is widely used design pattern in Selenium for enhancing test maintenance and reducing code duplication. The benefit is that if the UI changes for the page, the tests themselves don’t need to change, only the code within the page object needs to change. Subsequently, all changes to support that new UI is located in one place.

##### What is a framework?
A testing framework is a set of guidelines or rules used for creating and designing test cases. A framework is comprised of a combination of practices and tools that are designed to help QA professionals test more efficiently.

##### What are the advantages of the Automation framework?
* Improved test efficiency.
* Lower maintenance costs.
* Minimal manual intervention.
* Maximum test coverage.
* Reusability of code.

##### What are the different types of frameworks?
* Data Driven Testing Framework
* Keyword Driven Testing Framework
* Test Driven Development framework (TDD)
* Behavior Driven Development Framework (BDD)
* Hybrid Testing Framework

##### How to take screenshots in WebDriver?**
Refer Screenshot class in utils package

##### Why do we use TestNg or Junit?
Testing Frameworks gives us many types of verification types, makes it easier to see each test case if it passed or not, generates report for all executed test cases.
<br/>
Benefits:
* Test cases can be grouped easily and prioritized easily.
* Generating HTML report of test runs.
* Parallel execution of test cases is possible.
* It allows to define dependent test cases and each test case is independent to other test case.
* Test logs can be generated.
* Parameterization is possible.
* Test cases can be executed on multiple browsers.
* It can be easily integrated with Maven, Jenkins etc.
* Assert class is used for verification in TestNG framework.

##### How to run the test script in TestNG?
* Right click at Test method and execute
* Right click at Test class and execute
* Right click at testng.xml file and execute

##### What are the annotations used in the TestNG?
_What is the sequence of execution of all the annotations in TestNG?_
* BeforeSuite.
* BeforeTest.
* BeforeClass.
* BeforeMethod.
* Test Case.
* AfterMethod.
* AfterClass.
* AfterTest.

##### How to set the priorities in TestNG?
_@Test(priority = 1)_
<br/>
By default priority is 0, but can be positive and negative numbers.

##### Define grouping in TestNG?
As the name indicates, grouping in TestNG lets you group multiple test methods in named groups. Through groups in TestNG, you have the provision to run a particular set of tests that belong to a group or multiple groups.
<br/> Refer to testng.xml file.

##### What is invocationCount in TestNG?
Invocation count determines how many times test will execute. For EX: Execute test 7 times.
<br/>
_@Test(invocationCount=7)_

##### How can we disable the test case from running?
_@Test(enabled = false)_

##### What is the difference between soft assertion and hard assertion?
_Hard Asserts_ are used when you want to halt the execution of the test script (or test method) when the assert condition does not match with the expected result. 
<br/>_Soft Asserts_ are used when the test script (or test method) need not be halted when the assertion condition does not meet the expected result.

##### What is Maven?
Maven is a powerful project management tool that is based on POM (project object model). It is used for projects build, dependency and documentation.

_Benefits_
* Maven can add all the dependencies required for the project automatically by reading pom file.
* One can easily build their project to jar,war etc. as per their requirements using Maven.
* Maven makes easy to start project in different environments and one doesn’t needs to handle the dependencies injection, builds, processing, etc.
* Adding a new dependency is very easy. One has to just write the dependency code in pom file.

##### Explain what is POM?
A Project Object Model or POM is the fundamental unit of work in Maven. It is an XML file that contains information about the project and configuration details used by Maven to build the project.

##### List out what are the build phases in Maven?
* _clean_: clears out target folder
* _validate_: check if all information necessary for the build is available
* _compile_: compile the source code
* _test-compile_: compile the test source code
* _test_: run unit tests
* _verify_: Verifying the generated distributed package.
* _package_: package compiled source code into the distributable format (jar, war, …)
* _integration-test_: process and deploy the package if needed to run integration tests
* _install_: install the package to a local repository
* _deploy_: copy the package to the remote repository

##### What are different types of Build Profiles?
* _Per Project_ − Defined in the project POM file, pom.xml.
* _Per User_ − Defined in Maven settings xml file (%USER_HOME%/.m2/settings.xml).
* _Global_ − Defined in Maven global settings xml file (%M2_HOME%/conf/settings.xml)

##### What Is Maven Archetype?
Archetype is a Maven project templating toolkit. An archetype is defined as an original
pattern or model from which all other things of the same kind are made.

##### What Is Target, Source & Test Folders In Maven?
* Target: folder holds the compiled unit of code as part of the build process.
* Source: folder usually holds java source codes.
* Test: directory contains all the unit testing codes.

##### What does @DataProvider annotation do?
DataProvider feature is one of the important features provided by TestNG. 
<br/>It is the second way of passing parameters to test methods.
It allows the users to write data-driven tests in which we can run multiple times the same test method with different sets of test data.
<br/>The sets of test data can be any format. We can pass parameters or complex parameters to the test methods by using data provider as it is not possible to do this from XML.
<br/>The complex parameters can be complex objects, object read from a property file, or a database, etc that are created using Java technologies.

##### How do you exclude a group from the test execution cycle?**
We can exclude specific group by <exclude> tags in testng.xml file

##### How to run test form command line?
 * To run sml runner file: _mvn test -DsuiteXmlFile=testng.xml_
 * To run a test class: _mvn -Dtest=LoginTest test_
 * To run a test method in class: _mvn -Dtest=LoginTest#test01 test_

