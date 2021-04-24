# Test Plan (and eventually Test Report) - Example Template

|Contents|
|--------|
|[Team Management](#team-management)|
|[Test Plan](#test-plan)|
|[Jump to Class:](#class)|
|[Jump to Class:](#class)|
|[Jump to Class:](#class)|


## Team Management
We split the whole project into 6 subtask: 

- write the test script for three classes
- fix the code for three classes and add test script as well.

Therefore, we set 6 milestone. In each milestone, we would assign different issue to each team member
and the guy who is responsible for the issue would create a new branch for that issue. Finally when all the job is done,  one of our teammate would manage merge all these branches.
At the beginning of each milestone, we would hold a meeting. During that time, we would create issues, set a due date and assign to different people.   


Report here, by the end of the assignment, how the team has managed the project, e.g.: used version control, organised meetings, divided work, used labels, milestones, issues, etc. etc.

## Test Plan
###*This is just an example!!*

### Class: BoCTransaction

#### Function: transactionTime()

| Function : | transactionTime() |
| :-----------|--------------|
| Test Date : | 2021/04/21 22:46 |
| Tester : | Zixiang Hu (scyzh6) |

&nbsp;

|Test1:  | TS-Transaction 6-1 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | "wzy-hzx", new BigDecimal("2000"), 2 |
| **Expected Outcome**      | test.transactionTime() != null |
| **Test Outcome**          | test.transactionTime() != null |
| **Result**                       | Passed |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

&nbsp;

| Test1:                           | TS-Transaction 6-2             |
| :------------------------------- | ------------------------------ |
| **Constructor**                  | Deault constructor             |
| **Inputs**                       | No parameter                   |
| **Expected Outcome**             | test.transactionTime() == null |
| **Test Outcome**                 | test.transactionTime() == null |
| **Result**                       | Passed                         |
| **Reason for Failure**           | \                              |
| **What is Done to Make it Pass** | \         



### Class: BoCCategory

#### Function: BocCategory()

| Function : | BocCategory() |
| :-----------|--------------|
| Test Date : | 2021/04/22 9:20 |
| Tester : | Leshan Tan (sqylt2) |

&nbsp;

|Test1:  | TS-Category 1-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | test.CategoryName == "New Category", test.CategoryBudget == new BigDecimal("0.00"), test.CategorySpend == new BigDecimal("0.00") |
| **Test Outcome**          | test.CategoryName == "New Category", test.CategoryBudget == new BigDecimal("0.00"), test.CategorySpend == new BigDecimal("0.00") |
| **Result**                       | Passed |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |


### **Class:** &nbsp; BoCCategory

#### **Function :** &nbsp; toString()

| Function : | toString()|
| :-----------|--------------|
| Test Date : | 2021/04/18 21:14 |
| Tester : | Lin CHEN (biylc2) |

&nbsp;

|Test1:  | TS-Category 12-1 |
|:---------                 |-----------------            |
| **Constructor**           |    Default constructor       |
| **Inputs**                |    No parameter             |
| **Expected Outcome**      |   "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"      |
| **Test Outcome**          | "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"     |
| **Result**                       |  Pass    |
| **Reason for Failure**           |  \   |
| **What is Done to Make it Pass** |  \   |

&nbsp;

|Test2:  | TS-Category 12-2 |
|:---------                 |-----------------           |
| **Constructor**           |     Parameter constructor       |
| **Inputs**                |    CategoryName: "Negative"; CategoryBudget: BigDecimal("10000.00"); CategorySpend: BigDecimal("20000.00")    |
| **Expected Outcome**      |  "Negative(¥10000.00) - Est. ¥20000.00 (¥-10000.00 Overspent)"    |
| **Test Outcome**          |  "Negative(¥10000.00) - Est. ¥20000.00 (¥-10000.00 Remaining)"     |
| **Result**                       |  Fail   |
| **Reason for Failure**           | \     |
| **What is Done to Make it Pass** |  \   |``



&nbsp;
### Class: BoCTransaction

#### Function: setTransactionName()

| Function : | setTransactionName() |
| :-----------|--------------|
| Test Date : | 2021/04/24 14:38 |
| Tester : | Zixiang Hu (scyzh6) |

&nbsp;

|Test1:  | TS-Transaction 2-1 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><th>transactionTime</th><tr><td>"A test"</td><td>200</td><td>2</td><td>current time</td></tr></table> |
| **Test Outcome**          | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><th>transactionTime</th><tr><td>"A test"</td><td>200</td><td>2</td><td>current time</td></tr></table> | |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

|Test2:  | TS-Transaction 2-2 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>""</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction name should not be null. " |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;

|Test3:  | TS-Transaction 2-3 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Delta for two Date object created at the same time is less than 1 |
| **Test Outcome**          | Delta for two Date object created at the same time is less than 1 |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;

|Test4:  | TS-Transaction 2-4 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>200</td><td>-2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction name should not be null. " |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;


|Test5:  | TS-Transaction 2-5 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"A test"</td><td>-200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction budget should greater than zero." |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;


|Test5:  | TS-Transaction 2-6 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th><th>transactionBudget</th><th>transactioncategory</th><tr><td>"Transaction name with more than 25 char"</td><td>200</td><td>2</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "Transaction name should be shorter than 25 characters." |
| **Test Outcome**          | Failed with message "No exception thrown." |
| **Result**                       | Fail |
| **Reason for Failure**           | The source code do not support exception throw yet. |
| **What is Done to Make it Pass** | \ |
&nbsp;
