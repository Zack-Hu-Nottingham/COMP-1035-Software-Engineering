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

### **Class:** &nbsp; BoCCategory

#### **Function :** &nbsp; toString()

| Function : | toString()|
| :-----------|--------------|
| Test Date : | 2021/04/18 21:14 |
| Tester : | LinCHEN (biylc2)|

&nbsp;

|Test1:  | TS-Category 12-1 |
|:---------                 |-----------------            |
| **Constructor**           |    Deault constructor       |
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
| **What is Done to Make it Pass** |  \   |



### Class:nbsp;  BoCCategory

#### Function:  setCategoryBudget()

| Function : | setCategoryBudget() |
| :-----------|--------------|
| Test Date : | 2021/4/23 19：24 |
| Tester : | Ziyi Wang |

| Test1:                           | TS-Category7-1                                               |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Parameter constructor                                        |
| **Inputs**                       | 1. **setCategoryBudget**(*input*)<br>*input*= 20.0F;         |
| **Expected Outcome**             | could not compile                                            |
| **Test Outcome**                 | java: incompatible types: float cannot be converted to java.math.BigDecimal |
| **Result**                       | Fail                                                         |
| **Reason for Failure**           | the type of the parameter is different                       |
| **What is Done to Make it Pass** | change the type of the argument of **setCategoryBudget**(BigDecimal newValue) in the **BoCCatrgory.java** to float type. |