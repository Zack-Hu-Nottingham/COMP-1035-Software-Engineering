import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class BoCCategoryTest {
    // Author: Lin Chen (biylc2)
    // Last Modified: 2021/04/28
    // Reason: Cause the Category0 is unique, so if I want to test Unknown category, the categoryNum should be set to 0 after each testing")
    @AfterEach
    void teardown() throws NoSuchFieldException, IllegalAccessException {
        BoCCategory instance = new BoCCategory();
        final Field field = instance.getClass().getDeclaredField("categoryNum");
        field.setAccessible(true);
        field.set(instance,0);
    }

    // Author: Leshan Tan (sqylt2), Yingxiao Huo (scyyh9)
    // Last Modified: 2021/4/28 19:43
    @Test
    @DisplayName("Test for default constructor")
    void BocCategory()throws NoSuchFieldException, IllegalAccessException{
        ArrayList<String> BoCCategoryNameList = new ArrayList<String>(); // create a list to store the name of the category instances
        int times = 0; // the count of instances to be created
        while(times < 10){
            BoCCategory instance = new BoCCategory(); // create an instance
            final Field fieldName = instance.getClass().getDeclaredField("CategoryName"); // get the field CategoryName
            final Field fieldBudget = instance.getClass().getDeclaredField("CategoryBudget"); // get the fieldBudget
            final Field fieldSpend = instance.getClass().getDeclaredField("CategorySpend"); // get the fieldSpend
            fieldName.setAccessible(true); // get access to the private fields
            fieldBudget.setAccessible(true);
            fieldSpend.setAccessible(true);
            String name = (String) fieldName.get(instance); // get the CategoryName and assign it to name
            BoCCategoryNameList.add(name); // add name to the list
            if (times == 0){ // when it is the first category instance, its name should be "Unknown"
                assertEquals("Unknown", fieldName.get(instance),"Field CategoryName for the first instance didn't match" );
            } else { // otherwise, its name will be "New Category1", "New Category2" etc.
                assertEquals("New Category" + times, fieldName.get(instance),"Field CategoryName didn't match" );
            }
            assertEquals(new BigDecimal("0.00"),fieldBudget.get(instance),"Field CategoryBudget didn't match"); // check CategoryBudget
            assertEquals(new BigDecimal("0.00"), fieldSpend.get(instance),"Field CategorySpend didn't match"); // check CategorySpend
            for (int n=0;n<times;n++){ // to check if the CategoryName if unique, hence comparing each name with all previous instances' names in the list
                assertNotEquals(BoCCategoryNameList.get(n), name,"Constructor did not create unique Category Name");
            }
            times++; // count ++
        }
    }


    // Author: Ziyi Wang (scyzw10), Leshan Tan (sqylt2)
    // Last Modified: 2021/4/24 23:03
    @ParameterizedTest
    @CsvSource({"test1","test2","test3","testWithMoreThan15Chars"})
    @DisplayName("Test for Main Constructor")
    void MainBocCategory(String cName) throws NoSuchFieldException, IllegalAccessException {
        if (cName.length() <= 15) {
            BoCCategory cMain1 = new BoCCategory(cName);

            // get access to the private variables
            final Field fieldName = cMain1.getClass().getDeclaredField("CategoryName");
            final Field fieldBudget = cMain1.getClass().getDeclaredField("CategoryBudget");
            final Field fieldSpend = cMain1.getClass().getDeclaredField("CategorySpend");
            fieldName.setAccessible(true);
            fieldBudget.setAccessible(true);
            fieldSpend.setAccessible(true);
            // check CategoryBudget
            assertEquals(new BigDecimal("0.00"),fieldBudget.get(cMain1),"CategoryBudget didn't match");
            // check CategorySpend
            assertEquals(new BigDecimal("0.00"), fieldSpend.get(cMain1),"CategorySpend didn't match");
            // check CategoryName
            assertEquals(cName, fieldName.get(cMain1), "CategoryName didn't match");
        }else{
            try {
                BoCCategory cMain2 = new BoCCategory(cName);
                fail("it failed");
            }catch (Exception e){
                assertThat(e.getMessage(),containsString("Category Name at most 15 characters."));
            }
        }

    }


    // Author: Yingxiao Huo (scyyh9), Leshan Tan (sqylt2)
    // Last Modified time: 2021/4/21 11:23
    @ParameterizedTest
    @CsvFileSource(resources = {"/cate_categoryNameGetter.csv"})
    @DisplayName("Test for category name getter")
    void categoryName(String name, String expection) throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory Test_getter = new BoCCategory();
        final Field field_getName = Test_getter.getClass().getDeclaredField("CategoryName");
        field_getName.setAccessible(true);
        //If name is null, program should throw a exception with a message "Name is not set."
        if (name == null){
            try {
                field_getName.set(Test_getter, name);
                final String result = Test_getter.CategoryName();
                fail();
            }catch (Exception ex1){
                assertEquals(expection, ex1.getMessage());
            }
        }
        else{
            //Because if user enter a string longer than 15 characters, category setter will take a substring which is 15 characters.
            //So, category name getter should not get a name longer than 15 characters.
            //If name longer than 15 characters, program should throw a exception with a message "Category name can not longer than 15 characters."
            if (name.length() > 15){
                try {
                    field_getName.set(Test_getter, name);
                    final String result = (String) Test_getter.CategoryName();
                    fail();
                }catch (Exception ex2){
                    assertEquals(expection, ex2.getMessage());
                }
            }
            //Normal case.
            else {
                field_getName.set(Test_getter, name);
                final String result = Test_getter.CategoryName();
                assertEquals(result, expection);
            }
        }
    }

    //Author: Yicun Duan (scyyd3), Lin Chen(biylc2)
    //Last Modified: 2021/4/28 01:17
    //Reason: (1) Check whether the returned budget is expected.
    //        (2) Check whether the type and format of the returned budget is correct.
    @ParameterizedTest
    @CsvFileSource(resources = {"cate_getBudget.csv"})
    @DisplayName("Test for category budget getter")
    void categoryBudget(BigDecimal budget, BigDecimal expectBudget) throws NoSuchFieldException, IllegalAccessException {
        if (budget != null || expectBudget != null) {
            //test whether the returned budget is expected
            final BoCCategory budgetTest = new BoCCategory();
            final Field field = budgetTest.getClass().getDeclaredField("CategoryBudget");
            field.setAccessible(true);
            field.set(budgetTest, budget);

            final BigDecimal result = budgetTest.CategoryBudget();
            assertEquals(result, expectBudget, "CategoryBudget() function doesn't return an expected result.");
        } else {
            //test whether type and format are correct
            final BoCCategory test_instance = new BoCCategory();
            assertEquals(new BigDecimal("0.00"), test_instance.CategoryBudget(), "When using default constructor, CategoryBudget is not 0.00 (BigDecimal). Or it is not of type BigDecimal.");
        }
    }


    // Author: Leshan Tan (sqylt2), Ziyi Wang (scyzw10)
    // Last Modified: 2021/4/23 13:15
    @Test
    @DisplayName("Test for category spend getter")
    void categorySpend() throws  NoSuchFieldException{
        final BoCCategory boc = new BoCCategory(); // create an instance using default constructor
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend"); // get the field CategorySpend
        fieldSpend.setAccessible(true); // get access to private field
        assertEquals(new BigDecimal("0.00"), boc.CategorySpend(),"Field CategorySpend wasn't retrieved properly"); // the initial CategorySpend should be BigDecimal("0.00")
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"cate_categorySpend.csv"}) // get the input  and output source
    @DisplayName("Test for category spend getter with parameters")
    void categorySpendWithInputs(String input, String expectation) throws  NoSuchFieldException, IllegalAccessException{
        final BoCCategory boc = new BoCCategory(); // create an instance using default constructor
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend"); // get the field CategorySpend
        fieldSpend.setAccessible(true); // get access to private field
        fieldSpend.set(boc, new BigDecimal(input)); // set the CategorySpend to the input value in categorySpend.csv
        assertEquals( new BigDecimal(expectation), boc.CategorySpend(), "Field CategorySpend wasn't retrieved properly"); // field CategorySpend should be what we expected
    }


    //author: Yingxiao Huo (scyyh9), Ziyi Wang (scyzw10)
    //Last modified time: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/cate_categoryNameSetter.csv"})
    @DisplayName("Test for category name setter")
    void setCategoryName(String name, String expection) throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory Test_setter = new BoCCategory();
        //If name is null, program should throw a exception with a message "Name is not set."
        if (name == null){
            try {
                Test_setter.setCategoryName(null);
                fail();
            }catch (Exception ex1){
                assertEquals(expection, ex1.getMessage());
            }
        }
        else {
            if (name.length() > 15){
                //try {
                //    Test_setter.setCategoryName(name);
                //    fail();
                //}catch (Exception ex2){
                //    assertEquals(expection, ex2.getMessage());
                //}
                //if user enter a name longer than 15 characters, take substring which is 15 characters.
                Test_setter.setCategoryName(name);
                final Field field_setname = Test_setter.getClass().getDeclaredField("CategoryName");
                field_setname.setAccessible(true);
                assertEquals(expection, field_setname.get(Test_setter));
            }else {
                //Normal case.
                Test_setter.setCategoryName(name);
                final Field field_setname = Test_setter.getClass().getDeclaredField("CategoryName");
                field_setname.setAccessible(true);
                assertEquals(expection, field_setname.get(Test_setter));
            }
        }
    }


    // Author: Ziyi Wang (scyzw10), Yingxiao Huo (scyyh9)
    // Last modified: 2021/4/27 20:05
    @ParameterizedTest
    @CsvFileSource(resources = { "cate_setCategoryBudget.csv" })
    @DisplayName("Test for category budget setter")
    void setCategoryBudget(float input1, String expect, int expectcomp) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory setCBudget = new BoCCategory();    //new object

        setCBudget.setCategoryBudget(input1);    // set the budget
        // try to get the private variable CategoryBudget
        final Field field = setCBudget.getClass().getDeclaredField("CategoryBudget");
        field.setAccessible(true);

        final BigDecimal nbud = new BigDecimal(expect);   // expected amount of new budget after setCategoryBudget()
        BigDecimal result = (BigDecimal) field.get(setCBudget);  // store the CategoryBudget in result
        int equals = result.compareTo(nbud); // compare the actual with nbud(expected number)
        assertEquals(expectcomp,equals,"The budget set inside is incorrect.");
    }
    // Author: Ziyi Wang
    // Last modified: 2021/4/23 19:31
    // test before fixing the source code
//    @Ignore
//    @Test
//    void setCategoryBudget(){
//        final BoCCategory stest = new BoCCategory();    //new object
//
//        float input = 20.00F;
//        //argument passed to setCategoryBudget is incompatible with the type expected
//        stest.setCategoryBudget(input);    // set the budget with float type
//    }


    // Author : Lin Chen (biylc2), Yicun Duan (scyyd3)
    // Last Modify: 2021/04/24 20:44
    @DisplayName("Tests for add Expense")
    @ParameterizedTest
    @CsvSource({",Illegal input","-2e12,Illegal input","-2.134,Illegal input","0.00,0.00","+.0,+.0","2e12,2e12","2.13443343,2.13443343","2147483647.0012343,2147483647.0012343"})
    void addExpenseTest(String bigNumber,String expected) {

        BoCCategory addT1= new BoCCategory("Tester");
        //If bigNumber is null,the exception is expected with correct error message "Illegal input"
        if(bigNumber==null) {
            try {
                addT1.addExpense(new BigDecimal(bigNumber));
                assertNotNull(bigNumber, "The input Number cannot be null");
            } catch (NullPointerException e1) {
                try{
                    addT1.addExpense(null);
                }catch(NullPointerException e2) {
                    assertTrue(e2.getMessage().contains(expected));
                    return;
                }
            }
        }

        boolean strResult1= bigNumber.matches("[+]?[0-9]+.?[0-9]{0,32}[Ee]?[+-]?[0-9]?[1-9]");
        boolean strResult2 = bigNumber.matches("[+]?[0-9]{0,12}+.?[0-9]*");
        // If the bigNumber is not using scientific notation or negative
        if(strResult1==false){
            //If the bigNumber is negative
            if (strResult2== false){
                try{
                    addT1.addExpense(new BigDecimal(bigNumber));
                    fail("Illegal argument haven't been caught");
                }catch (IllegalArgumentException e2){
                    assertTrue(e2.getMessage().contains(expected));
                    return;
                }
            }
        }

        // Compare the result with expected number
        addT1.addExpense(new BigDecimal(bigNumber));
        BigDecimal expectedNum= new BigDecimal(expected);
        assertEquals(0,expectedNum.compareTo(addT1.CategorySpend()));
    }


    // Author: Ziyi Wang (scyzw10)
    // Last Modified: 2021/04/22 16:58
    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = {"cate_removeExpense.csv"})
    void removeExpense1(String input1,String input2, String input3, int expectation) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory ttest = new BoCCategory();

        ttest.addExpense(new BigDecimal(input1));
        ttest.removeExpense(new BigDecimal(input2));    // the actual value
        final Field field = ttest.getClass().getDeclaredField("CategorySpend");
        field.setAccessible(true);

        //ttest.CategorySpend = new BigDecimal(20000);  ==> since the CategorySpend is private -> could not change
        final BigDecimal expense = new BigDecimal(input3);
        BigDecimal result = (BigDecimal) field.get(ttest);
        int equals= result.compareTo(expense);
        assertEquals(expectation,equals);
    }


    // Author: Ziyi Wang (scyzw10)
    // Last Modified: 2021/04/22 19:45
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"-20.0", "-30.0", "-50.0"})
    // the input number could not be negative
    void removeExpense2(String input) {
        BoCCategory tcate = new BoCCategory();  //new object

        try {
            tcate.removeExpense(new BigDecimal(input));    // the actual value
            fail("it failed");
        } catch(Exception e) {
            assertThat(e.getMessage(),containsString("The valueToRemove must be >= 0"));
        }
        //fail("it failed");
    }


    // Author: Ziyi Wang (scyzw10)
    // Last Modified: 2021/04/22 20:38
    @Disabled
    @ParameterizedTest
    @CsvSource({"200.0, 300.0","200.0,400.0","1000.0,10000.0"})
    // the input number could not be larger than the original CategorySpend
    void removeExpense3(String input1,String input2) {
        BoCCategory ttt= new BoCCategory();

        ttt.addExpense(new BigDecimal(input1)); //origin amount in the spend
        try {
            ttt.removeExpense(new BigDecimal(input2));     // the actual value
        } catch(Exception e) {
            assertThat(e.getMessage(),containsString("The CategorySpend is must be >= 0"));
        }
        //fail("it failed");
    }


    // Author: Ziyi Wang (scyzw10)
    // Last modified: 4/25 12:31
    @DisplayName("Tests for remove Expense")
    @ParameterizedTest
    @CsvFileSource(resources = {"cate_removeExpense.csv"})
    void removeExpense(String input1,String input2, String expect, int expectation) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory removeE = new BoCCategory();  //new object

        //removeE.CategorySpend = new BigDecimal(20000);  ==> since the CategorySpend is private -> could not change
        removeE.addExpense(new BigDecimal(input1));   //use addExpense() to save an initial value in it
        //get the private variable
        final Field field = removeE.getClass().getDeclaredField("CategorySpend");
        field.setAccessible(true);

        final BigDecimal expexpense = new BigDecimal(expect);  //the expected amount of expense after remove

        int comp1 = new BigDecimal(input1).compareTo(new BigDecimal(input2));
        int comp2 = new BigDecimal(input2).compareTo(new BigDecimal("0.00"));
        // if BigDecimal(input1) < BigDecimal(input2)
        if (comp1 == -1) {
            try {
                removeE.removeExpense(new BigDecimal(input2));     // the actual value
            } catch(Exception e) {
                assertThat(e.getMessage(),containsString("The CategorySpend is must be >= 0"));
            }
            //  fail("it failed");
        }else if (comp2 == -1){     // if BigDecimal(input2) < 0
            try {
                removeE.removeExpense(new BigDecimal(input2));
            } catch (Exception e) {
                assertThat(e.getMessage(), containsString("The valueToRemove must be >= 0"));
            }
            // fail("it failed");
        }else{  // if all the input is correct then compare the result
            removeE.removeExpense(new BigDecimal(input2));    // remove the expense
            BigDecimal result = (BigDecimal) field.get(removeE);  //store the private CategorySpend in the result
            int equals = result.compareTo(expexpense);   //compare the expected expense with the actual number
            assertEquals(expectation, equals);   //the input expectation store the value of the expected compare value(equals)
        }
    }


    // Author:Lin Chen (biylc2), Yicun Duan (biylc2)
    // Last Modify: 2021/04/21 22:14
    @Test
    @DisplayName("Tests for reset budget")
    void resetBudgetSpend() throws NoSuchFieldException, IllegalAccessException {
        BoCCategory reset1= new BoCCategory("Reset");
        Field field1=reset1.getClass().getDeclaredField("CategorySpend");
        field1.setAccessible(true);
        field1.set(reset1,new BigDecimal("20000.0292"));
        reset1.resetBudgetSpend();
        BigDecimal result1= (BigDecimal) field1.get(reset1);

        assertTrue(result1.compareTo(new BigDecimal("0.00"))==0,"Respend test pass");

    }

    //Author: Yicun Duan (scyyd3)
    //Last Modified: 2021/4/24 15:27
    //Reason: Find whether the returned remaining budget is correct.
    @ParameterizedTest
    @MethodSource("parameterGenerator")
    @DisplayName("Tests for get remaining budget")
    void getRemainingBudget(BigDecimal budget, BigDecimal spend, BigDecimal expectRemain) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory remainTest =  new BoCCategory();
        //get access to "CategoryBudget"
        final Field field_budget = remainTest.getClass().getDeclaredField("CategoryBudget");
        field_budget.setAccessible(true);
        field_budget.set(remainTest, budget);
        //get access to "CategorySpend"
        final Field field_spend = remainTest.getClass().getDeclaredField("CategorySpend");
        field_spend.setAccessible(true);
        field_spend.set(remainTest, spend);

        final BigDecimal result = remainTest.getRemainingBudget();

        assertEquals(result, expectRemain);

    }

    private static Stream<Arguments> parameterGenerator() {
        return Stream.of(Arguments.of(new BigDecimal("100"), new BigDecimal("99"), new BigDecimal("1")),
                         Arguments.of(new BigDecimal("100000000000"), new BigDecimal("100000000000"), new BigDecimal("0")),
                         Arguments.of(new BigDecimal("3.1415926"), new BigDecimal("4.1415926"), new BigDecimal("-1.0000000")));
    }


    // Author:Lin Chen (biylc2)
    // Last Modify:2021/04/28 0:11

    static Stream <Arguments> compString() {
        return Stream.of(
                Arguments.of(new BoCCategory(), "", "", "[Unknown](Budget: ¥0.00) - ¥0.00 (¥0.00 Remaining)"),
                Arguments.of(new BoCCategory(), "", "", "[New Category1](Budget: ¥0.00) - ¥0.00 (¥0.00 Remaining)"),
                Arguments.of(new BoCCategory("Positive"), "3457834.023423", "667433.00564", "[Positive](Budget: ¥3457834.02) - ¥667433.01 (¥2790401.02 Remaining)"),
                Arguments.of(new BoCCategory("Negative"), "10000.0", "20000.0", "[Negative](Budget: ¥10000.00) - ¥20000.00 (¥10000.00 Overspent)")
        );
    };

    @ParameterizedTest
    @MethodSource("compString")
    @DisplayName("Test for toString")
    void testToString(BoCCategory a,String budget,String spend,String expected) throws IllegalAccessException, NoSuchFieldException {
        // Judge whether it is a default constructor
        if(budget.equals("")){
            assertEquals(expected,a.toString());
            return;
        }
        // If they are using paramitive constructor
        // It should can only have two decimal numbers
        Field field1= a.getClass().getDeclaredField("CategoryBudget");
        ((Field) field1).setAccessible(true);
        field1.set(a,new BigDecimal(budget));
        Field field2=a.getClass().getDeclaredField("CategorySpend");
        field2.setAccessible(true);
        field2.set(a,new BigDecimal(spend));
        assertEquals(expected,a.toString());


    }
}