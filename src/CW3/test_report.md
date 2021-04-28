# Test Report

| Contents                                               |
| :----------------------------------------------------- |
| [Team Management](#team-management)                    |
| [Test Specification](#test-specification)              |
| [Test Plan](#test-plan)                                |
| [Jump to Class: BoCTransaction](#class-boctransaction) |
| [Jump to Class: BoCCategory](#class-boccategory)       |
| [Jump to Class: BoCApp](#class-bocapp)                 |

## Team Management
Report here, by the end of the assignment, how the team has managed the project, e.g.: used version control, organised meetings, divided work, used labels, milestones, issues, etc. etc.

###  1. Team orgnization
#### 1.1. The Test and Develop Team
* Teams for **BoCCategory class**
    * `Team A` 
        * **Lin Chen** (20215609 @biylc2)
        * **Leshan Tan** (20215578 @sqylt2)
    * `Team B`
        * **Ziyi Wang** ()
        * **Zixiang Hu** (20215538 @scyzh6)
    * `Team C` 
        * **Yicun Duan** ()
        * **Yingxiao Huo** ()

* Teams for **BoCTransaction / BoCApp class**

    `The reason for doing team change is until April 19th , we are taught QA team. We think it is important so we adjust our strategy`

    * `Team A` 
        * **Lin Chen** (20215609 @biylc2)
        * **Yicun Duan** ()
    * `Team B` 
        * **Ziyi Wang** ()
        * **Leshan Tan** (20215578 @sqylt2)
        * **Yingxiao Huo**()

* Tasks:

    1. Follow the guidelines introduced in the lecture to do Test Driven Development. They are:
        * Create a unit test that fails.
        * Write the unit tests that are complied and sufficiently good enough.
        * Write the production codes that pass the unit tests.

    2. Work in paires to test functions and fix bugs.
        * One person checkes / reviews while other person codes.
        * Take turns to write functions and check codes.
        * For both team members,after testing, filling the test report is expected.  

    3. Change pairs for good practice formally spread
      
    4. By the end of the program, they will have to check the program with the QA member again.



#### 1.2. The QA Member

*   **Zixiang Hu** (20215538 @scyzh6)

* Tasks:
  1. Design the team [workflow](#2-workflow-and-discussions) and documentation system to ensure work efficiency and traceability;
  2. Define [standards](#44-standard-quality-check-requirements) and make sure all of the doucumented / changed file meets the requirements
  3. Approve merge requests only if the changes meet the specifications.
  4. Arrange meetings for the error collection and expected improvements after each stage is finished
  5. Encourage to comment and in the GitLab.
  6. Make sure everyone has his/her tasks using [Milestones](and remind them to complete it on time.
  7. Help team members with technical issues and introduce useful [methods](junit.md) to solve the problem.
  8. Hold discussions for some difficult problem happened while coding/ testing
  9. Check the test coverage and do the `version control`

### 2. Workflow and Discussions

1. **[Overview]**

    <img src="timeline.png" height = 400>

1. **[Meeting]** All members discuss and design a template documentation of test plan and test log.

1. **[Milestone]** :  ***"Write test script for BoC Transaction Class"***

   **[Duedate]**:  ***"Apr 22, 2021"***
   
    * **[Assignment]** `Team A`: ~Issue Assigned:  #7 make test plan and implement test code for `BoCTransaction` on a separated branch.
    * **[Assignment]** `Team B`: ~Issue Assigned: #6 make test plan and implement test code for `BoCCategory` on a separated branch.
 * **[Assignment]** `Team C`: ~Issue Assigned: #4, #5 make test plan and implement test code for `BoCCategory` on a separated branch.
   
    * **[Problem solving]** ~ Cannot open idea projects using Eclipse. (Finally we decide to configure the same working environment, and run on the same ide: IDEA)
    * **[Discussion]** ~ Discuss how to use git to make our project in order [~ see Git usage].
    * **[Meeting]** ~ Introduce how to use `csvSourceFile` and how to test `Setter` and `Getter` together.
    * **[Discussion]** ~ Discuss what the default constructer actually do and the expected output.
    * **[Discussion]** ~ Discuss how to test `Date` object.
    * **[Discussion]** ~ Discuss how to test the `BigDecimal` type using as it can accept 4 types.
    * **[Discussion]** ~Discuss how to test main constructor in just one method
    * **[OfficeHour]** ~Ask teacher the list of 
    problems we encountered [Question](question.md)
    * **[Meeting]** How to combine separate methods into one file. 
    * **[+ [Review] +]** Check all the functions are tested and swap to check others' codings. Check the variety use of assert functions.
    * **[+ [Merge] +]** After each issue is solved, we merge that branch of issue into master.


2. **[Milestone]** : ***"Write the test script for BoC Category Class"***
    **[Duedate]**:  ***"Apr 25, 2021"***
    
    * **[Assign & [+ Branch +]]** `Team A`: ~Issue Assigned: #14, #18, #20, #23, #26, #27 make test plan and implement test code for `BoCTransaction` on a separated branch 
    * **[Assign & [+ Branch +]]** `Team B`: ~Issue Assigned: #12, #13, #15, #16, #17, #19, #21, #25 Fix `BoCCategory` following TDD on a separated branch.
    * **[Meeting]** ~Reorganize our team and make Zixiang Hu to be our QA member,reassign the tasks.
    * **[Meeting]** ~What exceptions are expected to thrown for each cases.
    * **[Discussion&&OfficeHour]** ~ How to test a unique Category name of the default constructor of `BoCCategory`.
    * **[Comment]** ~ What is the acceptable parameter for setCategoryBudget function. 
    * **[Comment]** ~ How to test null input from the csv file.
* **[ProblemLeaving]** ~ Cannot use `Arguments.of` @MethodSource
    * **[+ [Review] +]** ~Completeness of our function test
* **[Discussion]** ~Two ways of testing addExpense function,which one is more logical.
    * **[Meeting]** Error collections/Improvements and uncompleted tasks. Swap to review others' coding and inspect various method for testing.
    * **[+ [Merge] +]** After each issue is solved, we merge that branch of issue into master.
    
3. **[Milestone]**:  ***"Fix script for BoC Transaction Class"***

    **[Duedate]**:  ***"Apr 27, 2021"***

    * **[Assign & [+ Branch +]]** `Team A`: ~Issue Assigned: #44, #45, #48 Each team member fix corresponding part of `BoCCategory` following TDD on a separated branch.
    * **[Assign & [+ Branch +]]** `Team B`: ~Issue Assigned: #21, #28, #37, #46, #47 Each team member fix corresponding part of `BoCCategory` following TDD on a separated branch.
    * **[Discussion]** ~When to fix bugs: before the app test or after the app test
    * **[Meeting]** ~ How to create unique default constructor.
    * **[Comment]** ~When to fix setCategoryBudget as it will influence BoCApp. 
    * **[Meeting]** ~Refactoring code together
    * **[+ [Review] +]** ~ Completeness of our function test
    * **[Comment]** ~Change for the return type of isComplete function .
    * **[Discussion]** ~ Discuss the format of the test log.
    * **[+ [Merge] +]** The report with test log and refactored function.
    * **[Meeting]** ~ Change the format of the test function and test log.
    * **[+[Review]+]** ~ Swap to check team members' function and give some suggestions

4. **[Milestone]**:  ***"Fix script for BoC Category Class"***
    **[Duedate]**:  ***"Apr 27, 2021"***
    
    * **[Assign]** ~ Done
    * **[Meeting]** ~ Introduce a static function and global varibles used for all the tests in the BoCAppTest class. 
    * **[Discussion]** ~Discuss about other methods for testing the I/O
    * **[Meeting]** ~ Discuss all the possible situations that may happen in the AppTest.
* **[+ [Coverage Test] +]** ~ Check the test code coverage using `run with Coverage` in the IDEA.
  
1. **[Milestone]**:  ***"Write the test script for BoCApp Main Class"***
   
    * **[Assign]**:  ***"Apr 27, 2021"***
    * **[Meeting]** Refactor main method together.
    * **[Discussion]** ~Discuss how to solve the problem caused by the difference between'\r\n' '\n' in windows and linux system(one of our teammate use ubutu to write & run the code)


### 3. `GitLab` Usage
1. Issues
    * Issues are used for fixing specific bugs,we have an issue for each function test. If the function requires code modification, a new issue is created for fixing this bug.
    * Each issue have a corresponding branch with a specific branch name created by Git. However, branch in early stage is deleted, as at that time we thought leave all the branches there is messy.
    * When developers encounter a problem,they may comment below their issues. If others can solve the problem, they will give their answers under the comment. It helps the coodination between team members.
    * `Assignee` ,` Due date` --- who will solve the problem and by when. QA member will check the due date and remind the team member if the task is overdue.
    * `Labels`, `Milestone` --- for which subproject and the type of issue.
    * **[+ Create merge request and branch +]** : After an issue is fixed, it should be merged into the master branch after being checked.

2. Labels
    * ~"" Lists to-do items as reminders.
    * ~Doing Ongoing events - should be finished before the due date.
    * ~Done Archives finished tasks.
    * ~Discussion Record meetings and discuss problems one encounters with the whole team.
    * ~Tips Share methodologies, tools, experiences with the whole team.
    * ~Bugs Report bugs find for later analysis.
3. Issue Boards
    * An overview of all the tasks and progress.
4. Commit messages
    * Commit messages mainly tells what the modification has been done on which test.
5. Milestones
    * Are used to assign a subproject,which consists of lots of issues. And it can be used to track the the completeness of subprocess, the participations of team members.
6. Merge Requests
    * Are expected to have `pictures` of what modifications have been done to the file and its output(for test). `[newly improved for readability]`
    * All merge request should be approved by Zixiang Hu after checking the correctness.

7. Tags
    * Tags will be used for version control.


### 4. Quality Assurance
#### 4.1 Pair programming
  * One person thinks/checkes while other person codes. And the pair changes.
#### 4.2 Code Review
  * The QA member will mainly focus on this problem and associate with the team member directly whether by discussion or using comment.
  * Have a meeting about error collections after each stage
#### 4.3 Regression Testing 
  * Regression Testing are required each time the code is modifies to ensure that other functions can process correctly.

#### 4.4 `[Standard quality check requirements]`
  * Use table to check whether meet the requirements after fixing.

#### 4.5 Independent QA Team
  * Regularly check submitted code and provide suggestions accordingly.
  * Ensure the style consistency among the whole project.
### 5. Traceability
#### 5.1 Cross-Reference
  * Unique IDs are assign to each test plan and test log

    **Format**:
    * `TS`-test type,`AS`-attempt type
    * Function name
    * The number of the subtest according to the requirements and its test case number.

* Theses IDs are referenced among:
    * `Test Plan` and `Test Log` documentation, where these IDs are defined;
    * `JUnit` test code using `@DisplayName` before each test;
    * `[Bug reports]`

#### 5.2 History
  * Code modifications:
    * `When`: In the function, it used last modified time, but in the `Test Log`, all the test times are expected.
    * `Why`: Why change this code.
    * `Who`: The tester or modifier.
    * `How`: Written in the `Test Log` or in the merge request pics.

### 6. Standards
 #### 6.1 Programming standards
 * Software: IntelliJ IDEA 
 * Environment: Java version 15.0.2 
 * Coding conventions:
   * `Naming variables`: Camel case / related to its purpose
   * `Naming file names`: Underscore case
   * `Naming functions`: relate to the method's functionality
   * Have method header format
   * Add `comments`
   * depth of conditional nesting cannot be more than 10 lines
   * length of code are expected to be in 50 lines
   * No duplicate code in the same class or other class
   * Declare global variables only if necessary to use in the other methods
   * Double check creation of static variables inside a class;
    * Avoid accessing variables directly from other classes instead use getter and setter methods

 #### 6.2 Standard quality check requirements
1. Control the visibility of information in a program 
1. Check all inputs for validity 
1. Provide a handler for all exceptions
1. Minimize the use of error-prone constructs 
1. Provide restart capabilities 
1. Check array bounds 
1. Include timeouts when calling external components 
1. Name all constants that represent real-world values

![Detailed](standards_for_check.png)

### Methods
[Docs for using methods](junit.md)







## Test Specification


### Test importance marking system

| Importance Level |   Importance   | Description                                                  | Example                                                      |
| :--------------: | :------------: | ------------------------------------------------------------ | ------------------------------------------------------------ |
|        1         |   **`Low`**    | whether the program provides smooth **user experience**      | Spelling errors in prompt messages.                          |
|        2         | **`Moderate`** | whther the program properly handles **rare exceptional usage** | A transaction value of 3E9.                                  |
|        3         |  **`Major`**   | whether the program properly handles **common exceptional usage** | A negative transaction value.                                |
|        4         | **`Critical`** | whether the program processes **normal usage** as expected   | A normal transaction record.                                 |
|        5         |  **`Fatal`**   | whether the program properly handles exceptions which may **mess up user data** | When user edits a transaction, another transaction is actually modified. |

`Note that "mess up user data" is of highest importance because this is a FINANCIAL app where wrong data is severer than program crash.`

### Test Coverage

| Line Coverage | Function Coverage | Condition Coverage |Path Coverage |
|----|--|---|-- |
|BoCCategory| | | |
|BoCTransaction| | | |
|BoCApp| | | |
![testCoverage]()



## Test Plan and Test Log

### Class: `BoCTransaction`

|Test ID|Type|Inputs|Expected Outcome|Importance|
|----|---------|------|----------------|-------|
|**[TS-Transaction 1-1]**|**[Validation Test]:**<br>Test constructor with no parameters|-|<table border="1"><tr><td>test.transactionName == "[Pending Transaction]"</td></tr><tr><td>test.transactionValue == null</td></tr><tr><td>test.transactionCategory == 0</td></tr><tr><td>test.transactionTime == new Date() // current time</td></tr></table>||
|**[TS-Transaction 1-1]**|||||
|**[TS-Transaction 2-1]**|||||
|**[TS-Transaction 2-2]**|||||
|**[TS-Transaction 2-3]**|||||
|**[TS-Transaction 2-4]**|||||
|**[TS-Transaction 2-5]**|||||
|**[TS-Transaction 2-6]**|||||
|**[TS-Transaction 3-1]**|[Validation Test]|Yingxiao Huo|Yingxiao Huo||
|**[TS-Transaction 3-2]**|[Defect Test]|null|name is not set.||
|**[TS-Transaction 4-1]**|**[Validation Test]:**<br>Test the transactionValue() with default constructor| <table border="1"><tr><th>TransactionValue: </th></tr><tr><td>BigDecimal("0.001")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> | <table border="1"><tr><th>TransactionValue: </th></tr><tr><td>BigDecimal("0.001")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> ||
|**[TS-Transaction 5-1]**|||||
|**[TS-Transaction 6-1]**|||||
|**[TS-Transaction 7-1]**|||||
|**[TS-Transaction 7-2]**|||||
|**[TS-Transaction 7-3]**|||||
|**[TS-Transaction 7-4]**|||||
|**[TS-Transaction 8-1]**|**[Defect Test]:**<br>Test value set to be null| <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>null</td></tr></table> |<table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[NullPointerException]`:"The value cannot be null"</td></tr></table> ||
|**[TS-Transaction 8-2]**|**[Defect Test]:**<br>Test value set to contain invalid characters|<table border="1"><tr><th colspan="3">setTransactionValue</th></tr><tr><td>"123hello"</td><td>"test"</td><td>" "</td></tr><tr></table>|<table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[NumberFormatException]`:to be thrown</td></tr></table>||
|**[TS-Transaction 8-3]**|**[Defect Test]:**<br>Test non-positive value number |<table border="1"><tr><th colspan="5">setTransactionValue</th></tr><tr><td>"-0e2"</td><td>""0e2"</td><td>"0e14"</td><td>"-0.0"--"-0.0000000000000000"</td><td></td></tr><tr><td>"0000"</td><td>"+0"</td><td>"-0"</td><td>"+.0"</td><td>"-.0"</td></tr><tr><td>"-214414123471.17649173641"</td><td>"-1.0"</td><td>"-209.00"</td><td>"-1.23E10"</td><td>"-0.1"--"-0.0000000000000001"</td></tr><tr></table>|<table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[IllegalArgumentException]`:"The value should be a positive number, the set fails"</td></tr></table> ||
|**[TS-Transaction 8-4]**|**[Validation Test]:**<br>Test to set the positive number once with default constructor| <table border="1"><tr><th colspan="5">setTransactionValue</th></tr><tr><td>"1e+3"</td><td>"1e3"</td><td>"1.E+3"</td><td>"1.25e+3"</td><td>"0.1"-"0.0000000000000001"</td></tr><tr><td>"2147483647.000002"</td><td>"9812457361.34653734"</td><td>"1.00"</td><td>"20.01"</td><td></td></tr></table> | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>The test pass</td></tr></table>||
|**[TS-Transaction 8-5]**|**[Defect Test]:**<br> Set value twice with both default constructor and main constructor|<table border="1"><tr><th>setTransactionValue</th></tr><tr><td>setTransactionValue(new BigDecimal("900.00"))</td></tr></table> |<table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[UnsupportedOperationException]`:"The value cannot be set twice"</td></tr></table>||
|**[TS-Transaction 9-1]**|||||
|**[TS-Transaction 10-1]**|**[Validation Test]:**<br>Test the isComplete with default constructor|-|<table border="1"><tr><th>isComplete</th></tr><tr><td>4</td></tr></table>||
|**[TS-Transaction 10-2]**|**[Validation Test]:**<br>Test the isComplete with main constructor by manually setting transactionName/transactionValue to null| <table border="1"><tr><th>isComplete</th></tr><tr><td>**transactionName:** "Tester" **transactionValue:** "980.98"</td></tr><tr><td>**transactionName:** null **transactionValue:** "980.98"</td></tr><tr><td>**transactionName:** "Tester" **transactionValue:** null</td></tr></table>|<table border="1"><tr><th>isComplete</th></tr><tr><td>1</td></tr><tr><td>3</td></tr><tr><td>2</td></tr></table>||
|**[TS-Transaction 11-1]**|**[Defect Test]:**<br>Test when value is negative number, value is null.<br>**[Validation Test]:**<br>Test the toString manually.|<table><tr><th>Name</th><th>Value</th></tr><tr><td>"Yingxiao Huo"</td><td>100</td></tr><tr><td>"Yicun Duan"</td><td>9999999</td></tr><tr><td>"Zixiang Hu"</td><td>-123123</td></tr><tr><td>"Boon Giin Lee"</td><td>0</td>></tr><tr><td>null</td><td>1</td></tr><tr><td>Bob</td><td>null</td></tr></table>|<table><tr><td>"Yingxiao Huo - ¥100 Date: [CURRENT DATE]"</td></tr><tr><td>"Yicun Duan - ¥9999999 Date: [CURRENT DATE]"</td></tr><tr><td>"Value can not be negative number"</td></tr><tr><td>"Boon Giin Lee - ¥0 Date: [CURRENT DATE]"</td></tr><tr><td>"Unknown Name - ¥1 Date: [CURRENT DATE]"</td></tr><tr><td>"Bob - ¥Uknown value Date: [CURRENT DATE]"</td></tr> </table>||


#### Test Log

|Test ID|Attempt-1|Modification|Attempt-2|Modification|Attempt-3|Modification|Integration Test|
|---|---|---|---|---|---|---|---|
|**[TS-Transaction 1-1]**|**[Result]:** `Fail`<br> **[Time]**:`2021/04/18 16:54`<br>**[Tester]**:`Leshan Tan (sqylt2)` <br>**[Platform]**: `MacOS-IDEA`| **[Modifier]**: `Leshan Tan (sqylt2)`<br> **[Content (M)]**:<br> ***Before***: `transactionName = null;`<br> ***After***:  `transactionName = "[Pending Transaction]";`|**[Result]**: `Pass` <br> **[Time]**: `2021/04/22 18:12`<br> **[Tester]**: `Leshan Tan (sqylt2)`<br> **[Platform]**: `MacOS-IDEA`|-|**[Result]**: `Pass` <br> **[Time]**: `2021/04/26 9:05`<br> **[Tester]**: `Leshan Tan (sqylt2)`<br> **[Platform]**: `MacOS-IDEA`|-|-|
|**[TS-Transaction 2-1]**||||||||
|**[TS-Transaction 2-2]**||||||||
|**[TS-Transaction 2-3]**||||||||
|**[TS-Transaction 2-4]**||||||||
|**[TS-Transaction 2-5]**||||||||
|**[TS-Transaction 2-6]**||||||||
|**[TS-Transaction 3-1]**|**[Result]:**<br>Pass<br>**[Time]:**<br>2021/04/21<br>22:24<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA|||||||
|**[TS-Transaction 3-2]**|**[Result]:**<br>Fail<br>**[Time]:**<br>2021/04/21<br>22:30<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA|**[Modifier]**<br>Yingxiao Huo(scyyh9)<br>**[Content(A)]:**<br>`if(transactionName == null;){`<br>`throw new IllegalArgumentException("Name is not set");}`<br>`else if(name.length() > 25){`<br>`throw new IllegalArgumentException("Name can not be longer than 25 characters.");}` |**[Result]:**<br>Pass<br>**[Time]:**<br>2021/04/21<br>22:34<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA|||||
|**[TS-Transaction 4-1]**|**[Result]:** `Pass`<br> **[Time]**:`2021/04/18 16:54`<br>**[Tester]**:`Leshan Tan (sqylt2)` <br>**[Platform]**: `MacOS-IDEA`|||||||
|**[TS-Transaction 5-1]**||||||||
|**[TS-Transaction 6-1]**||||||||
|**[TS-Transaction 7-1]**||||||||
|**[TS-Transaction 7-2]**||||||||
|**[TS-Transaction 7-3]**||||||||
|**[TS-Transaction 7-4]**||||||||
|**[TS-Transaction 8-1]**||||||||
|**[TS-Transaction 8-2]**||||||||
|**[TS-Transaction 8-3]**||||||||
|**[TS-Transaction 8-4]**||||||||
|**[TS-Transaction 8-5]**||||||||
|**[TS-Transaction 9-1]**||||||||
|**[TS-Transaction 10-1]**||||||||
|**[TS-Transaction 10-2]**||||||||
|**[TS-Transaction 11-1]**|**[Result]:**<br>Fail<br>**[Time]:**<br>2021/04/21<br>16:44<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA|**[Modifier]**<br>Yingxiao Huo(scyyh9)<br>**[Content(A)]:**<br>`if (transactionName == null){`<br>`throw new IllegalException("Name is not set.");}`<br>`if (transactionValue.compareTo(new BigDecimal("0.00")) == -1){`<br>`throw new IllegalArgumentException("Value can not be negative number");}`|**[Result]:**<br>Fail<br>**[Time]:**<br>2021/04/21<br>16:57<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA|**[Modifier]**<br>Yingxiao Huo(scyyh9)<br>**[Content(M)]:**<br>***Before:*** <br>`return transactionName + " - ¥" + transactionValue.toString();`<br> ***After:*** <br> `return transactionName + " - ¥" + transactionValue.toString() + " Date: " + transactionTime;`|**[Result]:**<br>Pass<br>**[Time]:**<br>2021/04/27<br>21:17<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA||||


### Class: `BoCCategory`

#### Test Plan

|Test ID|Type|Inputs|Expected Outcome|Importance|
|----|---------|------|----------------|-------|
|**[TS-Category 1-1]**|||||
|**[TS-Category 2-1]**|||||
|**[TS-Category 3-1]**|**[Defect Test]:**<br>set name is null, is longer than 15 characters.|<table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>^%&^%^</td></tr><tr><td>()*&*%Abc</td></tr><tr><td>12345</td></tr><tr><td>asdddasdasdasdacacwawcacw</td></tr></table> <br/>|<table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>^%&^%^</td></tr><tr><td>()*&*%Abc</td></tr><tr><td>12345</td></tr><tr><td>Category name can not longer than 15 characters.</td></tr></table> <br/>|<table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>^%&^%^</td></tr><tr><td>()*&*%Abc</td></tr><tr><td>12345</td></tr><tr><td>asdddasdasdasdacacwawcacw</td></tr></table> <br/>|
|**[TS-Category 4-1]**|||||
|**[TS-Category 5-1]**|||||
|**[TS-Category 5-2]**|||||
|**[TS-Category 6-1]**|**[Defect Test]:**<br>Test when name is null, is longer than 15 character, is special characters.|<table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>//awdaw</td></tr><tr><td>^$^$^&%</td></tr><tr><td>asdsadadwadawdasdascsgrsrgdrsgdgg</td></tr><tr><td>null</td></tr></table> <br/>|<table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>//awdaw</td></tr><tr><td>^$^$^&%</td></tr><tr><td>asdsadadwadawda</td></tr><tr><td>name can not be null</td></tr></table> <br/>|<table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>//awdaw</td></tr><tr><td>^$^$^&%</td></tr><tr><td>asdsadadwadawdasdascsgrsrgdrsgdgg</td></tr><tr><td>null</td></tr></table> <br/>|
|**[TS-Category 7-1]**|||||
|**[TS-Category 8-1]**|**[Defect Test]:**<br>Test add value set to be null |<table border="1"><tr><th>addExpense</th></tr><tr><td>null</td></tr></table> |<table border="1"><tr><th>addExpense</th></tr><tr><td>`[NullPointerException]`:"Illegal input"</td></tr></table>||
|**[TS-Category 8-2]**|**[Defect Test]:**<br>Test add value set to be negative number|<table border="1"><tr><th colspan="2">addExpense</th></tr><tr><td>"-2e12"</td><td>"-2.134"</td></tr></table>|<table border="1"><tr><th>addExpense</th></tr><tr><td>`[IllegalArgumentException]`:"Illegal input"</td></tr></table>||
|**[TS-Category 8-3]**|**[Validation Test]:**<br>Test add value set to be negative number |<table border="1"><tr><th colspan="5">addExpense</th></tr><tr><td>"0.00</td><td>"2.13443343"</td><td>"2e12"</td><td>"2147483647.0012343</td><td>"+.0"</td></tr></table> |<table border="1"><tr><th colspan="5">addExpense</th></tr><tr><td>"0.00</td><td>"2.13443343"</td><td>"2e12"</td><td>"2147483647.0012343</td><td>"+.0"</td></tr></table> ||
|**[TS-Category 9-1]**|||||
|**[TS-Category 9-2]**|||||
|**[TS-Category 9-3]**|||||
|**[TS-Category 10-1]**|**[Validation Test]:**<br>Test with spend number set|<table border="1"><tr><th>resetBudgetSpend</th></tr><tr><td>CategorySpend = new BigDecimal("20000.0292")</td></tr></table>|<table border="1"><tr><th>resetBudgetSpend</th></tr><tr><td> "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"</td></tr></table>||
|**[TS-Category 11-1]**|||||
|**[TS-Category 12-1]**|**[Validation Test]:**<br>Test with spend number set|-|<table border="1"><th>toString</th></tr><tr><td>"[New Category0](Budget: ¥0.00) - ¥0.00 (¥0.00 Remaining)"</td></tr></table>||
|**[TS-Category 12-2]**||<table border="1"><th>toString</th></tr><tr><td>**CategoryBudget :** "3457834.023423" **CategorySpend :** "667433.00564"</td></tr></table>|<table border="1"><th>toString</th></tr><tr><td>"[Positive](Budget: ¥3457834.023423) - ¥667433.00564 (¥2790401.017783 Remaining)"</td></tr></table>||
|**[TS-Category 12-3]**||<table border="1"><th>toString</th></tr><tr><td>**CategoryBudget :** "10000.00" **CategorySpend :** "20000.00"</td></tr></table>|<table border="1"><th>toString</th></tr><tr><td>""[Negative](Budget: ¥10000.00) - ¥20000.00 (¥10000.00 Overspent)"</td></tr></table>||



#### Test Log
|Test ID|Attemp-1|Modification|Attemp-2|Modification|Attemp-3|Modification|Integration Test|
|-|-|-|-|-|-|-|-|
|**[TS-Category 1-1]**||||||
|**[TS-Category 2-1]**||||||
|**[TS-Category 3-1]**|**[Result]:**<br>Fail<br>**[Time]:**<br>2021/04/23<br>20:41<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA|**[Modifier]**<br>Yingxiao Huo(scyyh9)<br>**[Content(A)]:**<br>`if (categoryName == null){`<br>`throw new IllegalException("Name is not set.");}`<br>`else if (CategoryName.length() > 15){`<br>`throw new IllegalArgumentException("Category name can not longer than 15 characters.");}`|**[Result]:**<br>Pass<br>**[Time]:**<br>2021/04/23<br>22:07<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA||||
|**[TS-Category 4-1]**||||||
|**[TS-Category 5-1]**||||||
|**[TS-Category 5-2]**||||||
|**[TS-Category 6-1]**|**[Result]:**<br>Fail<br>**[Time]:**<br>2021/04/21<br>18:16<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA|**[Modifier]**<br>Yingxiao Huo(scyyh9)<br>**[Content(A)]:**<br>`if (categoryName == null or newName.isBlank()){`<br>`throw new IllegalException("Name is not set.");}`<br>`else if (CategoryName.length() > 15){`<br>`CategoryName = newName.substring(0,15);}`|**[Result]:**<br>Pass<br>**[Time]:**<br>2021/04/28<br>22:26<br>**[Tester]:**<br>Yingxiao Huo<br>(scyyh9)<br>**[Platform]:**<br>Windows-IDEA||||
|**[TS-Category 7-1]**||||||
|**[TS-Category 8-1]**||||||
|**[TS-Category 8-2]**||||||
|**[TS-Category 8-3]**||||||
|**[TS-Category 9-1]**||||||
|**[TS-Category 9-2]**||||||
|**[TS-Category 9-3]**||||||
|**[TS-Category 10-1]**||||||
|**[TS-Category 11-1]**||||||
|**[TS-Category 12-1]**||||||
|**[TS-Category 12-2]**||||||
|**[TS-Category 12-3]**||||||



### Class: `BoCApp`

#### Test Plan

|Test ID|Type|Inputs|Expected Outcome|Importance|
|----|---------|------|----------------|-------|
|**[TS-App 1-1]**|||||
|**[TS-App 2-1]**|||||
|**[TS-App 3-1]**|||||
|**[TS-App 4-1]**|||||
|**[TS-App 5-1]**|||||
|**[TS-App 5-2]**|||||
|**[TS-App 6-1]**|||||
|**[TS-App 7-1]**|||||

#### Test Log
|Test ID|Attemp-1|Modification|Attemp-2|Modification|Attemp-3|Modification|Integration Test|
|-|-|-|-|-|-|-|-|
|**[TS-App 1-1]**||||||
|**[TS-App 2-1]**||||||
|**[TS-App 3-1]**||||||
|**[TS-App 4-1]**||||||
|**[TS-App 5-1]**||||||
|**[TS-App 5-2]**||||||
|**[TS-App 6-1]**||||||
|**[TS-App 7-1]**||||||



