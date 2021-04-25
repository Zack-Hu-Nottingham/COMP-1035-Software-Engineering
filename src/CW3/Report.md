# Test Plan (and eventually Test Report) - Example Template

|Contents|
|--------|
|[Timeline / Milestone](#milestone-and-the-time-line-of-our-project)|
|[Team Management](#team-management)|
|[Test Plan](#test-plan)|
|[Jump to Class:](#class)|
|[Jump to Class:](#class)|
|[Jump to Class:](#class)|



### MileStone and the Time Line of our project
![timeline.png](\timeline.png)
### What is the processing flow of our group?
We split the whole project can be split into ***two phase***: **unit test**  and **integration test**. <br>
In the **unit test part**, we set 4 milestone in total. Firstly is write test script and test plan for the two class and then is fix the code according to the test result eg. which test failed and what made the test fail. <br>
In the **integration part**, we mainly focus on **write test script** and **fix code** for **BoCAPP.java**, which would invoke a lot of predefined method. Thankfully, as all the predefined method(BoCTransaction.java BoCCategory.java) are fixed and work properly(***I think it would be best if it is the case, hhh***), there would not have error raised by these method . In this part, we would set two milestones, the first one is write test script and test the code, the second one is fix the code and make it pass the test.
### Three main stage:
- Write test script and fix the source code for BoCTransaction.java
- Write test script and fix the source code for BoCCategory.java
- Write test script and fix the source code for BoCApp.java

### Team management 
- **Working team:**
  - Team A: Ziyi Wang, Zixiang Hu
  - Team B: Yingxiao Huo, Yicun Duan
  - Team C: Leshan Tan, Lin Chen 
- **QA team:**
  - Zixiang Hu
#### Explanation for teams:
1. Each working team has two members, though they work for different part of the project parallely, but when they solved merge conflicts by themselves and raise merge request, the other member **should have a look** and check if he did the wrong thing (delete someone else's code by mistake).
2. We would suggest to let member who raise merge request to deal with merge conflicts by themselves, as he is the one who knows what changes are made and should responsible for the merge. After he solved the conflict, his teammate should **cross validate** his merge request, that is why we have two members in one group.
#### When and how often we have meetings?
**Normally**, before starting to work on a new milestone, we would have a meeting at library. 
If an **emergency** occurs we would hold a meeting as well. For example, Bryan said that for one test we are supposed to write in a test method... We had a long (horrible) meeting that day try to figure out how to make it.

#### What we do during the meeting?
During the meeting we would together figure out what are the codes doing, how are we going to write the test script and reach consensus on the interface of different method. After that, create all the issues and add corresponding discription, labels and milestone. We would also evaluate the work load of each issue and accoring to that assign to different team. 
#### How group members cooperate use gitlab?
When some one met with bug/problem that he can not solve, he could raise an issue and assign to QA team or someone who know, other group member if have suggestions could comment as well.

#### How do we make use of version control?


Report here, by the end of the assignment, how the team has managed the project, e.g.: used version control, organised meetings, divided work, used labels, milestones, issues, etc. etc.

# **Test Plan && Test Log**

## **Class : BoCTransaction**

 ### **Function:** &nbsp; &nbsp; **BoCTransaction**

| Test Plan  |            |
| :-----------|--------------|
| Test Date : | 2021/04/18 16:54 |
| Tester : | Leshan Tan (sqylt2) |

&nbsp;

|TestID:  | TS-Transaction 1-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default Constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | <table border="1"><tr><td>test.transactionName == "[Pending Transaction]"</td></tr><tr><td>test.transactionValue == null</td></tr><tr><td>test.transactionCategory == 0</td></tr><tr><td>test.transactionTime == null</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><td>test.transactionName == null</td></tr><tr><td>test.transactionValue == null</td></tr><tr><td>test.transactionCategory == 0</td></tr><tr><td>test.transactionTime == null</td></tr></table> |
| **Result**                       | Fail |
| **Reason for Failure**           | The transactionName of the instance created by default constructor should be "[Pending Transaction]", not null |
| **What is Done to Make it Pass** | \ |

&nbsp;
&nbsp;
 

 ### **Function:** &nbsp; &nbsp; **MainBoCTransaction()**

| Test Plan | |
| :-----------|--------------|
| Test Date : | 2021/04/24 14:38 |
| Tester : | Zixiang Hu (scyzh6) |

&nbsp;

|TestID:  | TS-Transaction 2-1 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><th>transactionTime</th><tr><td>"A test"</td><td>200</td><td>2</td><td>current time</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><th>transactionTime</th><tr><td>"A test"</td><td>200</td><td>2</td><td>current time</td></tr></table> | |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

|TestID:  | TS-Transaction 2-2 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>""</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction name should not be null. " |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;

|TestID:  | TS-Transaction 2-3 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Delta for two Date object created at the same time is less than 1 |
| **Test Outcome**          | Delta for two Date object created at the same time is less than 1 |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

|TestID:  | TS-Transaction 2-4 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>200</td><td>-2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction name should not be null. " |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;


|TestID:  | TS-Transaction 2-5 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>-200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction budget should greater than zero." |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;


|TestID:  | TS-Transaction 2-6 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"Transaction name with more than 25 char"</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction name should be shorter than 25 characters." |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;



 

 ### **Function:** &nbsp; **transactionValue()**

| Test Plan |  |
| :-----------|--------------|
| Test Date : | 2021/04/18 14:35 |
| Tester : | Leshan Tan (sqylt2) |

&nbsp;

|TestID:  | TS-Transaction 4-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default Constructor |
| **Inputs**                | <table border="1"><tr><th>TransactionValue: </th></tr><tr><td>BigDecimal("0.001")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>TransactionValue: </th></tr><tr><td>BigDecimal("0.001")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>TransactionValue: </th></tr><tr><td>BigDecimal("0.001")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

&nbsp;

 

 ### **Function:** &nbsp; **transactionTime()**

| Test Plan |  |
| :-----------|--------------|
| Test Date : | 2021/04/21 22:46 |
| Tester : | Zixiang Hu (scyzh6) |

&nbsp;

|TestID:  | TS-Transaction 6-1 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>200</td><td>2</td></tr><tr><td>"Another test"</td><td>200</td><td>3</td></tr><tr><td>null</td><td>null</td><td>2</td></tr></table> |
| **Expected Outcome**      | current time |
| **Test Outcome**          | current time |
| **Result**                       | Passed |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

&nbsp;
      


&nbsp;
 

 ### **Function:** &nbsp; **setTransactionName()**

| Test Plan |  |
| :-----------|--------------|
| Test Date : | 2021/04/23 9:38 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;

|TestID:  | TS-Transaction 7-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"Eren Joker"</td></tr><tr><td>"你好"</td></tr><tr><td>"\alpha"</td></tr><tr><td>" "</td></tr><tr><td>"\&nbsp;"</td></tr><tr><td>"86"</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"Eren Joker"</td></tr><tr><td>"你好"</td></tr><tr><td>"\alpha"</td></tr><tr><td>" "</td></tr><tr><td>"\&nbsp;"</td></tr><tr><td>"86"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"Eren Joker"</td></tr><tr><td>"你好"</td></tr><tr><td>"\alpha"</td></tr><tr><td>" "</td></tr><tr><td>"\&nbsp;"</td></tr><tr><td>"86"</td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;

|TestID:  | TS-Transaction 7-2 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"123456789abcdefghijklmnopqrst"</td></tr><tr><td>"What have you done? Eren! You killed all people! No, just 80%. Thank you, Eren."</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"123456789abcdefghijklmnop"</td></tr><tr><td>"What have you done? Eren!"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"123456789abcdefghijklmnopqrst"</td></tr><tr><td>"What have you done? Eren! You killed all people! No, just 80%. Thank you, Eren."</td></tr></table> |
| **Result**                       | Fail |
| **Reason for Failure**           | The program cannnot truncate the string when it is longer than 25 characters. |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;

|TestID:  | TS-Transaction 7-3 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th></tr><tr><td>null</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "The transactionName is invalid." |
| **Test Outcome**          | "IllegalArgumentException is not thrown out." |
| **Result**                       | Fail |
| **Reason for Failure**           | The program cannot throw out an exception when the input string is null. |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;

|TestID:  | TS-Transaction 7-4 |
|:---------                 |-----------------           |
| **Constructor**           | BoCTransaction("defaultname", BigDecimal(999.00), 1) |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"Eren Joker"</td></tr></table> |
| **Expected Outcome**      | Throw `[UnsupportedOperationException]`: "Transaction name cannot be repeatedly set." |
| **Test Outcome**          | "Expected java.lang.Exception to be thrown, but nothing was thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The program cannot throw out an exception when the transaction name is set twice. |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;

|TestID:  | TS-Transaction 7-5 |
|:---------                 |-----------------           |
| **Constructor**           | BoCTransaction("defaultname", null, 2) |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"886"</td></tr></table> |
| **Expected Outcome**      | Throw `[UnsupportedOperationException]`: "Transaction name cannot be repeatedly set." |
| **Test Outcome**          | "Expected java.lang.Exception to be thrown, but nothing was thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The program cannot throw out an exception when the transaction name is set twice. |
| **What is Done to Make it Pass** | \ |
&nbsp;


&nbsp;
 

&nbsp;
 ### **Function:** &nbsp; **transactionName()**

| Test Plan |  |
| :-----------|--------------|
| Test Date : | 2021/04/21 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;

|TestID:  | TS-Transaction 8-1 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><td>Yingxiao Huo</td></tr><tr><td>null</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><td>Yingxiao Huo</td></tr><tr><td>name is not set</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><td>Yingxiao Huo</td></tr><tr><td>null</td></tr></table> |
| **Result**                       | failed: 1, passed: 1 |
| **Reason for Failure**           | NUll is not detected |
| **What is Done to Make it Pass** | \ |

&nbsp;


### **Function:** &nbsp; **setTransactionValue()**

| Test Plan |  |
| :-----------|--------------|
| Test Date : | 2021/04/24 |
| Tester : | Lin Chen (biylc2) |

|TestID:  | TS-Transaction 9-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>null</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[NullPointerException]`:"The value cannot be null"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td> no `[NullPointerException]` is thrown</td></tr></table> |
| **Result**                       | Fail |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | Judge whether the input is null. If it is null throw a **NullPointerException** with the correct error message:"The value cannot be null"  |



|TestID:  | TS-Transaction 9-2 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>"123hello"</td><td>"test"</td><td>" "</td></tr><tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[NumberFormatException]`:to be thrown</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td> `[NumberFormatException]` is thrown </td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

|TestID:  | TS-Transaction 9-3 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>"-0e2"</td><td>""0e2"</td><td>"0e14"</td><td>"-0.0"--"-0.0000000000000000"</td></tr><tr><td>"0000"</td><td>"+0"</td><td>"-0"</td><td>"+.0"</td><td>"-.0"</td></tr><tr><td>"-214414123471.17649173641"</td><td>"-1.0"</td><td>"-209.00"</td><td>"-1.23E10"</td><td>"-0.1"--"-0.0000000000000001"</td></tr><tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[IllegalArgumentException]`:"The value should be a positive number, the set fails"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>no IllegalArgumentException is thrown </td></tr></table> |
| **Result**                       | Fail |
| **Reason for Failure**           | no IllegalArgumentException is thrown |
| **What is Done to Make it Pass** | Judge whether the input is non-positive. If it is, throw an **IllegalArgumentException** with the correct error message:"The value should be a positive number, the set fails"  |


|TestID:  | TS-Transaction 9-4 |
|:---------                 |-----------------   |
| **Constructor**           | Default constructor|
| **Inputs**                | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>"1e+3"</td><td>"1e3"</td><td>"1.E+3"</td><td>"1.25e+3"</td><td>"0.1"-"0.0000000000000001"</td></tr><tr></tr><td>"2147483647.000002"</td><td>"9812457361.34653734"</td><td>"1.00"</td><td>"20.01"</td><tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>The test pass</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>The test pass </td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |


|TestID:  | TS-Transaction 9-5 (setTwice)|
|:---------                 |-----------------           |
| **Constructor**           | Default constructor with above set value /parameter constructer|
| **Inputs**                | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>"1e+3"</td><td>"1e3"</td><td>"1.E+3"</td><td>"1.25e+3"</td><td>"0.1"-"0.0000000000000001"</td></tr><tr></tr><td>"2147483647.000002"</td><td>"9812457361.34653734"</td><td>"1.00"</td><td>"20.01"</td><tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>`[UnsupportedOperationException]`:"The value cannot be set twice"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td> no`[UnsupportedOperationException] is thrown</td></tr></table> |
| **Result**                       |Fail |
| **Reason for Failure**           | no`[UnsupportedOperationException] is thrown|
| **What is Done to Make it Pass** |Using `[isComplete]` function to judge whether the transaction value has been set. If it has been set, an **UnsupportedOperationException** will be thrown with error message "The value cannot be set twice" |


&nbsp;
## **Test Log**
| TestID |CodeModification|Reviewer| Attempt1 |Attempt2 |
| :-----------|-----|--------------|---|--|
| TS-Transaction 9-1|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/25 11:34 |\  |Fail| Pass+ |
| TS-Transaction 9-2|\ |\ |Pass+ | Pass+ |
| TS-Transaction 9-3|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/25 11:34 |\ |Fail| Pass+ |
| TS-Transaction 9-4|\ | \ |Pass+ | Pass+ |
| TS-Transaction 9-5|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/25 11:34 |\ |Fail| Pass+ |
 
&nbsp;

 ### **Function:** &nbsp; isComplete()
| Test Plan |  |
| :-----------|--------------|
| Test Date : | 2021/04/24 |
| Tester : | Lin Chen (biylc2) |

|TestID:  | TS-Transaction 10-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | none |
| **Expected Outcome**      | 4 |
| **Test Outcome**          | 4 |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

|TestID:  | TS-Transaction 10-2 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>BoCTransaction("Tester","980.98",0)</td></tr><tr><td>BoCTransaction(null,"980.98",0)</td></tr><tr><td>BoCTransaction("Tester",null,0)</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>setTransactionValue</th></tr><tr><td>1</td></tr><tr><td>3</td></tr><tr><td>2</td></tr></table>|
| **Test Outcome**          |<table border="1"><tr><th>setTransactionValue</th></tr><tr><td>1</td></tr><tr><td>3</td></tr><tr><td>2</td></tr></table>|
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |


&nbsp;

## **Test Log**
| TestID |CodeModification|Reviewer| Attempt1 |Attempt2 |
| :-----------|-----|--------------|---|--|
| TS-Transaction 10-1|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/24 14:25|\  |Pass+ | Pass+ |
| TS-Transaction 10-2|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/24 14:25 |\ |Pass+ | Pass+ |

 

 ### **Function:** &nbsp; toString()

| Test Plan | toString() |
| :-----------|--------------|
| Test Date : | 2021/04/21 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;

|TestID:  | TS-Transaction 11-1 |
|:---------                 |-----------------           |
| **Constructor**           | Main constructor |
| **Inputs**                |  <table><tr><th>Name</th><th>Value</th><th>result</th></tr><tr><td>"Yingxiao Huo"</td><td>100</td><td>"Yingxiao Huo - ¥100"</td></tr><tr><td>"Yicun Duan"</td><td>9999999</td><td>"Yicun Duan - ¥9999999"</td></tr><tr><td>"Zixiang Hu"</td><td>-123123</td><td>"Value can not be negative number"</td></tr><tr><td>"Boon Giin Lee"</td><td>0</td><td>"Boon Giin Lee - ¥0"</td></tr><tr><td>null</td><td>1</td><td>"Unknown Name - ¥1"</td></tr><tr><td>Bob</td><td>null</td><td>"Bob - ¥Uknown value"</td></tr><tr><td>null</td><td>null</td><td>"Unknown Name - ¥Uknown value"</td></tr></table>|
| **Expected Outcome**      | <table><tr><td>"Yingxiao Huo - ¥100"</td></tr><tr><td>"Yicun Duan - ¥9999999"</td></tr><tr><td>"Value can not be negative number"</td></tr><tr><td>"Boon Giin Lee - ¥0"</td></tr><tr><td>"Unknown Name - ¥1"</td></tr><tr><td>"Bob - ¥Uknown value"</td></tr><tr><td>"Unknown Name - ¥Uknown value"</td></tr> </table>|
| **Test Outcome**          | <table><tr><td>"Yingxiao Huo - ¥100"</td></tr><tr><td>"Yicun Duan - ¥9999999"</td></tr><tr><td>"Zixiang Hu - ¥-123123"</td></tr><tr><td>"Boon Giin Lee - ¥0"</td></tr><tr><td>"null - ¥1"</td></tr><tr><td>"Bob - ¥null"</td></tr><tr><td>"null - ¥null"</td></tr> </table>|
| **Result**                       | Passed :3, failed:4 |
| **Reason for Failure**           | Negative number and NULL are not detected |
| **What is Done to Make it Pass** | \ |

&nbsp;


&nbsp;
  

 ### **Function:** &nbsp; BocCategory()

| Test Plan | BocCategory() |
| :-----------|--------------|
| Test Date : | 2021/04/22 21:20 |
| Tester : | Leshan Tan (sqylt2) |

&nbsp;

|TestID:  | TS-Category 1-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | <table border="1"><tr><td>test.CategoryName is unique among different instances</td></tr><tr><td>test.CategoryBudget == new BigDecimal("0.00")</td></tr><tr><td>test.CategorySpend == new BigDecimal("0.00")</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><td>test.CategoryName is the same among different instances</td></tr><tr><td>test.CategoryBudget == new BigDecimal("0.00")</td></tr><tr><td>test.CategorySpend == new BigDecimal("0.00")</td></tr></table> |
| **Result**                       | Fail |
| **Reason for Failure**           | The implementation of Category Default Constructor is wrong, since it always create instances with the same name "New Category" |
| **What is Done to Make it Pass** | \ |
&nbsp;

  

 ### **Function:** &nbsp; BocCategory(String newTitle)

| Function :  | BocCategory()       |
| :---------- | ------------------- |
| Test Date : | 2021/04/24 23:07    |
| Tester :    | Ziyi Wang (scyzw10) |

| TestID:                           | TS-Category 2-1                                              |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Main constructor                                             |
| **Inputs**                       | BoCCategory *<u>cMain1</u>* =**BoCCategory**(*cName*);<br><table> <th colspan = "4">cName</th> <tr><td>"test1"</td><td>"test2" </td><td>"test3" </td><td>"testWithMoreThan15Chars" </td></tr></table>|
| **Expected Outcome**             | <table> <tr><th rowspan = "3">1~3.</th> <td>`cMain1.CategoryName` == cName;</td> </tr><tr><td>`cMain1.CategorySpend` == new BigDecimal("0.00");</td></tr><tr><td>`cMain1.CategoryBudget` == new BigDecimal("0.00");</td></tr><tr><th>4. </th><td>Throw an exception *containsString("Category Name at most 15 characters.")* </td></tr></table>|
| **Test Outcome**                 | <table> <tr><th rowspan = "3">1~3.</th> <td> `cMain1.CategoryName` == cName;</td> </tr><tr><td>`cMain1.CategorySpend` == new BigDecimal("0.00");</td></tr><tr><td>`cMain1.CategoryBudget` == new BigDecimal("0.00");</td></tr><tr><th>4. </th><td>org.opentest4j.AssertionFailedError: it failed </td></tr></table>|
| **Result**                       | <table> <tr><td>P</td><td> P</td><td> P</td><td> F </td></table> |
| **Reason for Failure**           | The source code does not take the exception into account     |
| **What is Done to Make it Pass** | Add exception to the source code                             |

##### Test After Fixing the Source Code

| TestID:               | TS-Category 2-1                                              |
| :------------------- | ------------------------------------------------------------ |
| **Constructor**      | Main constructor                                             |
| **Inputs**           | BoCCategory *<u>cMain1</u>* =**BoCCategory**(*cName*);<br><table> <th colspan = "4">cName</th> <tr><td>"test1"</td><td>"test2" </td><td>"test3" </td><td>"testWithMoreThan15Chars" </td></tr></table>|
| **Expected Outcome** | <table> <tr><th rowspan = "3">1~3.</th> <td>`cMain1.CategoryName` == cName;</td> </tr><tr><td>`cMain1.CategorySpend` == new BigDecimal("0.00");</td></tr><tr><td>`cMain1.CategoryBudget` == new BigDecimal("0.00");</td></tr><tr><th>4. </th><td>print *"The Exception has been thrown!"*</td></tr></table> |
| **Test Outcome**     | <table> <tr><th rowspan = "3">1~3.</th> <td>`cMain1.CategoryName` == cName;</td> </tr><tr><td>`cMain1.CategorySpend` == new BigDecimal("0.00");</td></tr><tr><td>`cMain1.CategoryBudget` == new BigDecimal("0.00");</td></tr><tr><th>4. </th><td>*"The Exception has been thrown!"*</td></tr></table>|
| **Result**           | Pass                                                         |



  

 ### **Function:** &nbsp; categoryName()

| Test Plan | categoryName() |
| :-----------|--------------|
| Test Date : | 2021/04/23 20:36 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;


&nbsp;

|TestID:  | TS-Category 3-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/>|
| **Expected Outcome**      | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> |
| **Test Outcome**          | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;


&nbsp;
  

 ### **Function:** &nbsp; categoryBudget()

| Test Plan | categoryBudget() |
| :-----------|--------------|
| Test Date : | 2021/04/23 18:32 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;


&nbsp;

|TestID:  | TS-Category 4-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>CategoryBudget: </th></tr><tr><td>BigDecimal("100")</td></tr><tr><td>BigDecimal("100000000000")</td></tr><tr><td>BigDecimal("7.77E+10")</td></tr><tr><td>BigDecimal("456e-9")</td></tr><tr><td>BigDecimal("01010101000")</td></tr><tr><td>BigDecimal("314.15926")</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>CategoryBudget: </th></tr><tr><td>BigDecimal("100")</td></tr><tr><td>BigDecimal("100000000000")</td></tr><tr><td>BigDecimal("7.77E+10")</td></tr><tr><td>BigDecimal("456e-9")</td></tr><tr><td>BigDecimal("01010101000")</td></tr><tr><td>BigDecimal("314.15926")</td></tr></table> |
| **Test Outcome**          |<table border="1"><tr><th>CategoryBudget: </th></tr><tr><td>BigDecimal("100")</td></tr><tr><td>BigDecimal("100000000000")</td></tr><tr><td>BigDecimal("7.77E+10")</td></tr><tr><td>BigDecimal("456e-9")</td></tr><tr><td>BigDecimal("01010101000")</td></tr><tr><td>BigDecimal("314.15926")</td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;

|TestID:  | TS-Category 4-2 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | BigDecimal("0.00") |
| **Test Outcome**          | BigDecimal("0.00") |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;



 ### **Function:** &nbsp; CategorySpend()

| Test Plan | CategorySpend() |
| :-----------|--------------|
| Test Date : | 2021/04/23 11:45 |
| Tester : | Leshan Tan (sqylt2) |

&nbsp;

|TestID:  | TS-Category 5-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | new BigDecimal("0.00") |
| **Test Outcome**          | new BigDecimal("0.00") |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;


|TestID:  | TS-Category 5-2 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>CategorySpend: </th></tr><tr><td>BigDecimal("0")</td></tr><tr><td>BigDecimal("0.000")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>CategorySpend: </th></tr><tr><td>BigDecimal("0")</td></tr><tr><td>BigDecimal("0.000")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>CategorySpend: </th></tr><tr><td>BigDecimal("0")</td></tr><tr><td>BigDecimal("0.000")</td></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("1.00000")</td></tr><tr><td>BigDecimal("100000")</td></tr><tr><td>BigDecimal("100000.00000")</td></tr><tr><td>BigDecimal("999999999999999")</td></tr><tr><td>BigDecimal("999999999999999.999999999999999")</td></tr><tr><td>BigDecimal("0001010010")</td></tr><tr><td>BigDecimal("3.1415926535E+8")</td></tr><tr><td>BigDecimal("3.1415926535E-8")</td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;


&nbsp;
  

 ### **Function:** &nbsp; setCategoryName()

| Test Plan | setCategoryName() |
| :-----------|--------------|
| Test Date : | 2021/04/23 20:41 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;

&nbsp;

|TestID:  | TS-Category 6-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/>|
| **Expected Outcome**      | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> |
| **Test Outcome**          | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> |


&nbsp;

 

#### **Function :** &nbsp; addExpense()


| Test Plan | addExpense()|
| :-----------|--------------|
| Test Date : | 2021/04/24 |
| Tester : | Lin Chen (biylc2) |
&nbsp;

|TestID:  | TS-Category 8-1 |
|:---------                 |-----------------            |
| **Constructor**           |   Main constructor with settled categoryname("Tester")      |
| **Inputs**    |<table border="1"><tr><th>addExpense</th></tr><tr><td>null</td></tr></table> |
| **Expected Outcome**  | <table border="1"><tr><th>addExpense</th></tr><tr><td>`[NullPointerException]`:"Illegal input"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>addExpense</th></tr><tr><td>Error message is not correct </td></tr></table> |
| **Result**                       | Fail |
| **Reason for Failure**           | Error message is not correct |
| **What is Done to Make it Pass** | Judge when the input is null, then the function will throw a NullPointerException with error message "Illegal input"  |
&nbsp;

|TestID:  | TS-Category 8-2 |
|:---------                 |-----------------            |
| **Constructor**           |   Main constructor with settled categoryname("Tester")      |
| **Inputs**    |<table border="1"><tr><th>addExpense</th></tr><tr><td>"-2e12"</td><td>"-2.134"</td></tr></table> |
| **Expected Outcome**  | <table border="1"><tr><th>addExpense</th></tr><tr><td>`[IllegalArgumentException]`:"Illegal input"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>addExpense</th></tr><tr><td>No exception caught</td></tr></table> |
| **Result**                       | Fail |
| **Reason for Failure**           | No exception caught |
| **What is Done to Make it Pass** | Judge whether the input contains a negative sign, then the function will throw an IllegalArgumentTransaction with error message "Illegal input" |
&nbsp;

&nbsp;
|TestID:  | TS-Category 8-3 |
|:---------                 |-----------------            |
| **Constructor**           |  Main constructor with settled categoryname("Tester")      |
| **Inputs**    |<table border="1"><tr><th>addExpense</th></tr><tr><td>"0.00</td><td>"2.13443343"</td><td>"2e12"</td><td>"2147483647.0012343</td><td>"+.0"</td></tr></table> |
| **Expected Outcome**  | <table border="1"><tr><th>addExpense</th></tr><tr><td>"0.00</td><td>"2.13443343"</td><td>"2e12"</td><td>"2147483647.0012343</td><td>"+.0"</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>addExpense</th></tr><tr><td>"0.00</td><td>"2.13443343"</td><td>"2e12"</td><td>"2147483647.0012343</td><td>"+.0"</td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;

## **Test Log**
| TestID |CodeModification|Reviewer| Attempt1 |Attempt2 |
| :-----------|-----|--------------|---|--|
| TS-Category 8-1|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/25 15:16 |\  |Fail| Pass+ |
| TS-Category 8-2|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/25 15:16 |\ |Fail| Pass+ |
| TS-Category 8-3|\ |\ |Pass+| Pass+ |

&nbsp;



 

#### **Function :** &nbsp; resetBudgetSpend()


| Test Plan | resetBudgetSpend()|
| :-----------|--------------|
| Test Date : | 2021/04/18 |
| Tester : | Lin Chen (biylc2) |
&nbsp;

|TestID:  | TS-Category 10-1 |
|:---------                 |-----------------            |
| **Constructor**           |    Default constructor       |
| **Inputs**                |    CategorySpend = new BigDecimal("20000.0292")         |
| **Expected Outcome**      |   "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"      |
| **Test Outcome**          |   "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"     |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

&nbsp;
&nbsp;

&nbsp;
  

 ### **Function:** &nbsp; getRemainingBudget()

| Test Plan | getRemainingBudget() |
| :-----------|--------------|
| Test Date : | 2021/04/23 19:48 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;


&nbsp;

|TestID:  | TS-Category 11-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>CategoryBudget: </th></tr><tr><td>BigDecimal("100")</td></tr><tr><td>BigDecimal("100000000000")</td></tr><tr><td>BigDecimal("3.1415926")</td></tr></table> <br/> <table border="1"><tr><th>CategorySpend: </th></tr><tr><td>BigDecimal("99")</td></tr><tr><td>BigDecimal("100000000000")</td></tr><tr><td>BigDecimal("4.1415926")</td></tr></table>|
| **Expected Outcome**      | <table border="1"><tr><th>RemainingBudget: </th></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("0")</td></tr><tr><td>BigDecimal("-1.0000000")</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>RemainingBudget: </th></tr><tr><td>BigDecimal("1")</td></tr><tr><td>BigDecimal("0")</td></tr><tr><td>BigDecimal("-1.0000000")</td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;






&nbsp;
 

#### **Function :** &nbsp; toString()

| Test Plan | toString()|
| :-----------|--------------|
| Test Date : | 2021/04/18 21:14 |
| Tester : | Lin Chen (biylc2)|

&nbsp;

|TestID:  | TS-Category 12-1 |
|:---------                 |-----------------            |
| **Constructor**           |    Default constructor      |
| **Inputs**                |    No parameter             |
| **Expected Outcome**      |   "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"      |
| **Test Outcome**          | "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"     |
| **Result**                       |  Pass    |
| **Reason for Failure**           |  \   |
| **What is Done to Make it Pass** |  \   |

&nbsp;

|TestID:  | TS-Category 12-2 |
|:---------                 |-----------------           |
| **Constructor**           |     Main constructor       |
| **Inputs**                |    CategoryName: "Negative"; CategoryBudget: BigDecimal("10000.00"); CategorySpend: BigDecimal("20000.00")    |
| **Expected Outcome**      |  "Negative(¥10000.00) - Est. ¥20000.00 (¥10000.00 Overspent)"    |
| **Test Outcome**          |  "Negative(¥10000.00) - Est. ¥20000.00 (¥-10000.00 Remaining)"     |
| **Result**                       |  Fail   |
| **Reason for Failure**           | The category Number is negative  |
| **What is Done to Make it Pass** | Detect when the budget number is negative,change the printed message  |


&nbsp;

|TestID:  | TS-Category 12-3 |
|:---------                 |-----------------           |
| **Constructor**           |     Main constructor       |
| **Inputs**                |    CategoryName: "Positive"; CategoryBudget: BigDecimal("3457834.023423"); CategorySpend: BigDecimal("667433.00564")    |
| **Expected Outcome**      |  "Positive(¥3457834.023423) - Est. ¥667433.00564 (¥2790401.017783 Remaining)"    |
| **Test Outcome**          |  "Positive(¥3457834.023423) - Est. ¥667433.00564 (¥2790401.017783 Remaining)"     |
| **Result**                       |  Pass   |
| **Reason for Failure**           | \     |
| **What is Done to Make it Pass** |  \   |

&nbsp;

## **Test Log**
| TestID |CodeModification|Reviewer| Attempt1 |Attempt2 |
| :-----------|-----|--------------|---|--|
| TS-Category 12-1|\ |\  |Fail| Pass+ |
| TS-Category 12-2|**Modifier:** Lin Chen(biylc2) **Modify Time:** 2021/04/24 23:27 |\ |Fail| Pass+ |
| TS-Category 12-3|\ |\ |Pass+| Pass+ |

&nbsp;

&nbsp;

  

 ### **Function:** &nbsp;  transactionCategory()

| Function :  | transactionCategory() |
| :---------- | --------------------- |
| Test Date : | 2021/4/18 21:15       |
| Tester :    | Ziyi Wang (scyzw10)             |

| TestID:                           | TS-Transaction 5-1                                           |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Default constructor                                          |
| **Inputs**                       | **BoCTransaction**("wzy", new BigDecimal("2000"), *input*);<table><tr><th colspan = "4">*input*</th></tr> <tr> <td>0</td><td> 1</td><td>5</td><td> 100</td></tr></table> |
| **Expected Outcome**             | <table> <tr><th colspan = "4">*.**transactionCategory()**</th></td><tr><td> 0 </td><td> 1 </td><td>  5</td><td>100</td></tr></table>           |
| **Test Outcome**                 | <table> <tr><td>0 </td><td> 1 </td><td>5</td><td>100 </td></tr></table>     |
| **Result**                       | Pass                                                         |
| **Reason for Failure**           | /                                                            |
| **What is Done to Make it Pass** | /                                                            |



  

 ### **Function:** &nbsp;  setCategoryBudget()

| Test Plan | setCategoryBudget() |
| :-----------|--------------|
| Test Date : | 2021/4/23 19：24 |
| Tester : | Ziyi Wang (scyzw10) |

| TestID:                           | TS-Category7-1                                               |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Main constructor                                        |
| **Inputs**                       |  **setCategoryBudget**(*input*)<table> <tr><th>*input*</th><td> 20.0F</td></tr></table>         |
| **Expected Outcome**             | could not compile                                            |
| **Test Outcome**                 | java: incompatible types: float cannot be converted to java.math.BigDecimal |
| **Result**                       | Fail                                                         |
| **Reason for Failure**           | the type of the parameter is different                       |
| **What is Done to Make it Pass** | change the type of the argument of **setCategoryBudget**(BigDecimal newValue) in the **BoCCatrgory.java** to float type. |



### Class: &nbsp; BoCCategory

 ### **Function:** &nbsp;  removeExpense()

| Function: |removeExpense() |
| :-----------|--------------|
| Test Date: |2021/4/22 20:38 |
| Tester: | Ziyi Wang (scyzw10) |
&nbsp;

|TestID:  | TS-Category 9-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table><tr><th> **addExpense**(new BigDecimal(*input1*))</th> </tr><tr><th> **removeExpense**(new BigDecimal(*input2*))</th></tr><tr><th>BigDecimal **expense** = new BigDecimal(*input3*)</th></tr></table><table><tr><th>*input1*</th><td>"0.0"</td><td>"1000.0"</td><td>"1000.0"</td><td>"1000.0"</td><td>"1000.0"</td><td>"1000.0"</td><td>"1000.0"</td><td>"100"</td><td>"100"</td><td>"100" </td><td>"2.0"</td><td>"3.0"</td><td>"10.0"</td><td>"200.0"</td><td>"10000"</td><td>"1000000.0000"</td></tr> <tr><th>*input2*</th><td> "0.0"</td><td>"100"</td><td>"800"</td><td>"200.02"</td><td>"200.02"</td><td>"200.02"</td><td>"200.0002"</td><td>"0.1"</td><td>"0.01"</td><td>"0.001"</td><td>"2.0"</td><td>"3.0"</td><td>"10.0"</td><td>"200.0"</td><td>"1314.1314521"</td><td>"1000000.0000"</td></tr><tr><th> *input3*</th><td>"0.0"</td><td>"900"</td><td>"200"</td><td>"799.98"</td><td>"700"</td><td>"800"</td><td>"799.9998"</td><td>"99.9"</td><td>"99.99"</td><td>"99.999"</td><td>"0"</td><td>"0"</td><td>"0"</td><td>"0" </td><td>"8685.8685479"</td><td>"0"</td></tr></table> |
| **Expected Outcome**      | <table><tr><th colspan = "16">**CategorySpend**(BigDecimal).`compareTo`(**expense**)</th></tr> <tr><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td><td>-1</td><td>0</td><td> 0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0 </td></tr></table>|
| **Test Outcome**          | <table><tr><td>0</td><td>0</td><td>0</td><td>0</td><td>1</td><td>-1</td><td>0</td><td> 0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td><td>0</td></tr></table> |
| **Result**                       | Pass |
| **Reason for Failure**           | / |
| **What is Done to Make it Pass** | / |

&nbsp;

| TestID:                           | TS-Category 9-2                                              |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Default constructor                                          |
| **Inputs**                       | **removeExpense**(new BigDecimal(*input2*)); <table><tr><th>*input2*</th><td>"-20.0"</td><td>"-30.0"</td><td>"-50.0"</td></tr></table> |
| **Expected Outcome**             | <table><tr><th>all 3 expected</th><td>throw InvalidParameterException("The expense must be >= 0")</td></tr></table> |
| **Test Outcome**                 | <table><tr><th>all 3 outcome</th><td>org.opentest4j.AssertionFailedError: it failed </td></tr></table>|
| **Result**                       | Fail                                                         |
| **Reason for Failure**           | The source does not take the exception into account          |
| **What is Done to Make it Pass** | Add exception to the source code                             |

##### Test After Fixing the Source Code

| TestID:               | TS-Category 9-2                                              |
| :------------------- | ------------------------------------------------------------ |
| **Constructor**      | Default constructor                                          |
| **Inputs**           | **removeExpense**(new BigDecimal(*input2*)); <table><tr><th>*input2*</th><td>"-20.0"</td><td>"-30.0"</td><td>"-50.0"</td></tr></table> |
| **Expected Outcome** | <table><tr><th>all 3 expected</th><td>print "The Exception has been thrown!" </td></tr></table>|
| **Test Outcome**     | <table><tr><th>all 3 outcome</th><td>"The Exception has been thrown!"  </td></tr></table>|
| **Result**           | Pass                                                         |



| TestID:                           | TS-Category 9-3                                              |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Main constructor                                             |
| **Inputs**                       | <table><tr><th>**addExpense**(new BigDecimal(*input1*))</th></tr><tr><th> **removeExpense**(new BigDecimal(*input2*))</th></tr></table><table><tr><th> *input1*</th><td>"200.0"</td><td>"200.0"</td><td>"1000.0"</td></tr><tr><th> *input2*</th><td>"300.0"</td><td>"400.0" </td><td>"10000.0"</td></tr></table>|
| **Expected Outcome**             | <table><tr><th>all 3 expected</th><td>throw InvalidParameterException("The CategorySpend is must be >= 0")</td></tr></table> |
| **Test Outcome**                 | <table><tr><th>all 3 outcome</th><td>org.opentest4j.AssertionFailedError: it failed</td></tr></table>|
| **Result**                       | Fail                                                         |
| **Reason for Failure**           | The source does not take the exception into account          |
| **What is Done to Make it Pass** | Add exception to the source code                             |

##### Test After Fixing the Source Code

| TestID:               | TS-Category 9-3                                              |
| :------------------- | ------------------------------------------------------------ |
| **Constructor**      | Main constructor                                             |
| **Inputs**           | <table><tr><th>**addExpense**(new BigDecimal(*input1*))</th></tr><tr><th> **removeExpense**(new BigDecimal(*input2*))</th></tr></table><table><tr><th> *input1*</th><td>"200.0"</td><td>"200.0"</td><td>"1000.0"</td></tr><tr><th> *input2*</th><td>"300.0"</td><td>"400.0" </td><td>"10000.0"</td></tr></table>|
| **Expected Outcome** | <table><tr><th>all 3 expected</th><td>print "The Exception has been thrown!" </td></tr></table>|
| **Test Outcome**     | <table><tr><th>all 3 outcome</th><td>"The Exception has been thrown!" </td></tr></table>|
| **Result**           | Pass                                                         |





### Class: BoCApp

 ### **Function:** &nbsp; categoryOverview()

| Test Plan | categoryOverview() |
| :-----------|--------------|
| Test Date : | 2021/04/24 10:09 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;

&nbsp;

|TestID:  | TS-App 3-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table><tr><th>CategoryName: </th><th>CategoryBudget: </th></tr><tr><td>"Unknown"</td><td>&nbsp;</td></tr><tr><td>"Bills"</td><td>BigDecimal("120.00")</td></tr><tr><td>"Groceries"</td><td>BigDecimal("75.00")</td></tr><tr><td>"Soical"</td><td>BigDecimal("100.00")</td></tr></table> |
| **Expected Outcome**      | <p>1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)<br>2) Bills(¥120.00) - Est. ¥0.00 (¥120.00 Remaining)<br>3) Groceries(¥75.00) - Est. ¥0.00 (¥75.00 Remaining)<br>4) Social(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)</p> |
| **Test Outcome**          | <p>1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)<br>2) Bills(¥120.00) - Est. ¥0.00 (¥120.00 Remaining)<br>3) Groceries(¥75.00) - Est. ¥0.00 (¥75.00 Remaining)<br>4) Social(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)</p> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

## Test Log
&nbsp;

### Class BoCTransaction
