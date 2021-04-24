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


&nbsp;
### Class: BoCTransaction

#### Function: setTransactionName()

| Function : | setTransactionName() |
| :-----------|--------------|
| Test Date : | 2021/04/23 9:38 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;

|Test1:  | TS-Transaction 7-1 |
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

|Test2:  | TS-Transaction 7-2 |
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

|Test3:  | TS-Transaction 7-3 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th></tr><tr><td>""</td></tr></table> |
| **Expected Outcome**      | Throw `[IllegalArgumentException]`: "The transactionName is invalid." |
| **Test Outcome**          | "IllegalArgumentException is not thrown out." |
| **Result**                       | Fail |
| **Reason for Failure**           | The program cannot throw out an exception when the input string is empty. |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;

|Test4:  | TS-Transaction 7-4 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>transactionName: </th></tr><tr><td>"Joker is myself"</td></tr><tr><td>"Joker is myself" (set again)</td></tr></table> |
| **Expected Outcome**      | Throw `[UnsupportedOperationException]`: "Transaction name cannot be repeatedly set." |
| **Test Outcome**          | "UnsupportedOperationException is not thrown out." |
| **Result**                       | Fail |
| **Reason for Failure**           | The program cannot throw out an exception when two transactions have the same name. |
| **What is Done to Make it Pass** | \ |
### Class: BoCTransaction

$nbsp
#### Function: transactionName()

| Function : | transactionName() |
| :-----------|--------------|
| Test Date : | 2021/04/21 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;

|Test1:  | TS-Transaction 8-1 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | "test0" |
| **Expected Outcome**      | Test_getter.transactionName() == "test0" |
| **Test Outcome**          | Test_getter.transactionName() == "test0" |
| **Result**                       | Passed |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

&nbsp;
### Class: BoCTransaction

#### Function: toString()

| Function : | toString() |
| :-----------|--------------|
| Test Date : | 2021/04/21 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;

|Test1:  | TS-Transaction 9-1 |
|:---------                 |-----------------           |
| **Constructor**           | main constructor |
| **Inputs**                | "Boon Giin Lee" "0" |
| **Expected Outcome**      | Test_toString.toString() == "Boon Giin Lee - ¥0" |
| **Test Outcome**          | Test_toString.toString() == "Boon Giin Lee - ¥0" |
| **Result**                       | Passed |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |

&nbsp;


&nbsp;
### Class: BoCCategory

#### Function: BocCategory()

| Function : | BocCategory() |
| :-----------|--------------|
| Test Date : | 2021/04/22 21:20 |
| Tester : | Leshan Tan (sqylt2) |

&nbsp;

|Test1:  | TS-Category 1-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | test.CategoryName is unique among different instances, test.CategoryBudget == new BigDecimal("0.00"), test.CategorySpend == new BigDecimal("0.00") |
| **Test Outcome**          | test.CategoryName is the same among different instances, test.CategoryBudget == new BigDecimal("0.00"), test.CategorySpend == new BigDecimal("0.00") |
| **Result**                       | Fail |
| **Reason for Failure**           | The implementation of Category Default Constructor is wrong, since it always create instances with the same name "New Category" |
| **What is Done to Make it Pass** | \ |
&nbsp;

&nbsp;
### Class: BoCCategory

#### Function: categoryName()

| Function : | categoryName() |
| :-----------|--------------|
| Test Date : | 2021/04/23 20:36 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;


&nbsp;

|Test1:  | TS-Category 3-1 |
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
### Class: BoCCategory

#### Function: categoryBudget()

| Function : | categoryBudget() |
| :-----------|--------------|
| Test Date : | 2021/04/23 18:32 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;


&nbsp;

|Test1:  | TS-Category 4-1 |
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

|Test2:  | TS-Category 4-2 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | BigDecimal("0.00") |
| **Test Outcome**          | BigDecimal("0.00") |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;



#### Function: CategorySpend()

| Function : | CategorySpend() |
| :-----------|--------------|
| Test Date : | 2021/04/23 11:45 |
| Tester : | Leshan Tan (sqylt2) |

&nbsp;

|Test1:  | TS-Category 5-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | No parameter |
| **Expected Outcome**      | new BigDecimal("0.00") |
| **Test Outcome**          | new BigDecimal("0.00") |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;


|Test2:  | TS-Category 5-2 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | set `CategorySpend` to new BigDecimal() <table><td>0</td><td>0.000</td><td>1</td><td>1.00000</td><td>100000</td><td>100000.000000</td><td>999999999999999</td><td>999999999999999.999999999999999</td></table> |
| **Expected Outcome**      | new BigDecimal() <table><td>0</td><td>0.000</td><td>1</td><td>1.00000</td><td>100000</td><td>100000.000000</td><td>999999999999999</td><td>999999999999999.999999999999999</td></table>  |
| **Test Outcome**          | new BigDecimal() <table><td>0</td><td>0.000</td><td>1</td><td>1.00000</td><td>100000</td><td>100000.000000</td><td>999999999999999</td><td>999999999999999.999999999999999</td></table>  |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;


&nbsp;
### Class: BoCCategory

#### Function: setCategoryName()

| Function : | setCategoryName() |
| :-----------|--------------|
| Test Date : | 2021/04/23 20:41 |
| Tester : | Yingxiao Huo (scyyh9) |

&nbsp;

&nbsp;

|Test1:  | TS-Category 6-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/>|
| **Expected Outcome**      | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> |
| **Test Outcome**          | <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> <table border="1"><tr><th>Yingxiao Huo </th></tr><tr><td>Yicun Duan</td></tr><tr><td>Zixiang Hu</td></tr><tr><td>Lin Chen</td></tr><tr><td>Leshan Tan</td></tr><tr><td>Ziyi Wang</td></tr><tr><td>Boon Giin Lee</td></tr><tr><td>null</td></tr></table> <br/> |



&nbsp;

### **Class:** &nbsp; BoCCategory

#### **Function :** &nbsp; resetBudgetSpend()


| Function : | resetBudgetSpend()|
| :-----------|--------------|
| Test Date : | 2021/04/18 21:14 |
| Tester : | Lin CHEN (biylc2) |
&nbsp;

|Test1:  | TS-Category 10-1 |
|:---------                 |-----------------            |
| **Constructor**           |    Default constructor       |
| **Inputs**                |    No parameter             |
| **Expected Outcome**      |   "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"      |
| **Test Outcome**          | "New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)"     |
&nbsp;

&nbsp;
### Class: BoCCategory

#### Function: getRemainingBudget()

| Function : | getRemainingBudget() |
| :-----------|--------------|
| Test Date : | 2021/04/23 19:48 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;


&nbsp;

|Test1:  | TS-Category 11-1 |
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
### **Class:** &nbsp; BoCCategory

#### **Function :** &nbsp; toString()

| Function : | toString()|
| :-----------|--------------|
| Test Date : | 2021/04/18 21:14 |
| Tester : | LinCHEN (biylc2)|

&nbsp;

|Test1:  | TS-Category 12-1 |
|:---------                 |-----------------            |
| **Constructor**           |    Default constructor      |
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

&nbsp;

|Test2:  | TS-Category 12-3 |
|:---------                 |-----------------           |
| **Constructor**           |     Parameter constructor       |
| **Inputs**                |    CategoryName: "Positive"; CategoryBudget: BigDecimal("3457834.023423"); CategorySpend: BigDecimal("667433.00564")    |
| **Expected Outcome**      |  "Positive(¥3457834.023423) - Est. ¥667433.00564 (¥2790401.017783 Remaining)"    |
| **Test Outcome**          |  "Positive(¥3457834.023423) - Est. ¥667433.00564 (¥2790401.017783 Remaining)"     |
| **Result**                       |  Pass   |
| **Reason for Failure**           | \     |
| **What is Done to Make it Pass** |  \   |

&nbsp;

### Class: &nbsp; BoCCategory

#### Function:  removeExpense()

| Function: |removeExpense() |
| :-----------|--------------|
| Test Date: |2021/4/22 20:38 |
| Tester: | Ziyi Wang |
&nbsp;

|Test1:  | TS-Category 9-1 |
|:---------                 |-----------------           |
| **Constructor**           | Parameter constructor |
| **Inputs**                | 1. **addExpense**(new BigDecimal(*input1*)); <br>where *input1*=0.0\|1000.0\|1000.0\|1000.0\|1000.0\|1000.0\|1000.0\|100\|100\|100 \|2.0\|3.0\|10.0\|200.0\|10000\|1000000.0000;<br>2. **removeExpense**(new BigDecimal(*input2*)); <br>*input2*= 0.0\|100\|800\|200.02\|200.02\|200.02\|200.0002\|0.1\|0.01\|0.001\|2.0 \|3.0\|10.0\|200.0\|1314.1314521\|1000000.0000;<br>3. BigDecimal **expense** = new BigDecimal(*input3*); <br>where *input3* = 0.0\|900\|200\|799.98\|700\|800\|799.9998\|99.9\|99.99\|99.999\|0\|0\|0\|0\|7685.8685479\| 0; |
| **Expected Outcome**      | **CategorySpend**(BigDecimal).`compareTo`(**expense**): <br>0\|0\|0\|0\|1\|-1\| 0\| 0\|0\| 0\|0\|0\|0\|0\|0\|0 |
| **Test Outcome**          | 0\|0\|0\|1\|1\|-1\|-1\|-1\|1\|-1\|0\|0\|0\|0\|1\|0 |
| **Result**                       | P P P F P P F F F F P P P P F P |
| **Reason for Failure**           | Maybe sth. went wrong in **addExpense**() or **removeExpense**() |
| **What is Done to Make it Pass** |  |

| Test2:                           | TS-Category 9-2                                              |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Parameter constructor                                        |
| **Inputs**                       | 1. **removeExpense**(new BigDecimal(*input*)); <br>where *input* = -20.0; |
| **Expected Outcome**             | throw InvalidParameterException("The expense must be >= 0")  |
| **Test Outcome**                 | java.security.InvalidParameterException: The expense must be >= 0 |
| **Result**                       | Pass                                                         |
| **Reason for Failure**           | /                                                            |
| **What is Done to Make it Pass** | /                                                            |

| Test3:                           | TS-Category 9-3                                              |
| :------------------------------- | ------------------------------------------------------------ |
| **Constructor**                  | Parameter constructor                                        |
| **Inputs**                       | 1. **addExpense**(new BigDecimal(*input1*)); <br>where *input1*=1000.0;<br>2. **removeExpense**(new BigDecimal(*input2*)); <br>*input2*= 10000.0; |
| **Expected Outcome**             | throw new InvalidParameterException("The CategorySpend is must be >= 0"); |
| **Test Outcome**                 | java.security.InvalidParameterException: The CategorySpend is must be >= 0 |
| **Result**                       | Pass                                                         |
| **Reason for Failure**           | /                                                            |
| **What is Done to Make it Pass** | /                                                            |
| **What is Done to Make it Pass** |  \   |

&nbsp;
### Class: BoCApp

#### Function: categoryOverview()

| Function : | categoryOverview() |
| :-----------|--------------|
| Test Date : | 2021/04/24 10:09 |
| Tester : | Yicun Duan (scyyd3) |

&nbsp;

&nbsp;

|Test1:  | TS-App 3-1 |
|:---------                 |-----------------           |
| **Constructor**           | Default constructor |
| **Inputs**                | <table><tr><th>CategoryName: </th><th>CategoryBudget: </th></tr><tr><td>"Unknown"</td><td>&nbsp;</td></tr><tr><td>"Bills"</td><td>BigDecimal("120.00")</td></tr><tr><td>"Groceries"</td><td>BigDecimal("75.00")</td></tr><tr><td>"Soical"</td><td>BigDecimal("100.00")</td></tr></table> |
| **Expected Outcome**      | <p>1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)<br>2) Bills(¥120.00) - Est. ¥0.00 (¥120.00 Remaining)<br>3) Groceries(¥75.00) - Est. ¥0.00 (¥75.00 Remaining)<br>4) Social(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)</p> |
| **Test Outcome**          | <p>1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)<br>2) Bills(¥120.00) - Est. ¥0.00 (¥120.00 Remaining)<br>3) Groceries(¥75.00) - Est. ¥0.00 (¥75.00 Remaining)<br>4) Social(¥100.00) - Est. ¥0.00 (¥100.00 Remaining)</p> |
| **Result**                       | Pass |
| **Reason for Failure**           | \ |
| **What is Done to Make it Pass** | \ |
&nbsp;