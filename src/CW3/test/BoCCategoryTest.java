import org.junit.jupiter.api.DisplayName;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.security.InvalidParameterException;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;


class BoCCategoryTest {

    // Author: Leshan Tan (sqylt2)
    // Last Modified: 2021/4/24 21:17
    @Test
    void BocCategory()throws NoSuchFieldException, IllegalAccessException{
        List BoCCategoryNameList = new ArrayList(); // create a list to store the name of the category instances
        int times = 0; // the count of instances to be created
        while(times < 10){
            BoCCategory instance = new BoCCategory();
            final Field fieldName = instance.getClass().getDeclaredField("CategoryName");
            final Field fieldBudget = instance.getClass().getDeclaredField("CategoryBudget");
            final Field fieldSpend = instance.getClass().getDeclaredField("CategorySpend");
            fieldName.setAccessible(true); // get access to the private fields
            fieldBudget.setAccessible(true);
            fieldSpend.setAccessible(true);
            String name = (String) fieldName.get(instance); // get the CategoryName and assign it to name
            BoCCategoryNameList.add(name); // add name to the list
            assertEquals(new BigDecimal("0.00"),fieldBudget.get(instance),"Field CategoryBudget didn't match"); // check CategoryBudget
            assertEquals(new BigDecimal("0.00"), fieldSpend.get(instance),"Field CategorySpend didn't match"); // check CategorySpend
            for (int n=0;n<times;n++){ // to check if the CategoryName if unique, hence comparing each name with all previous instances' names in the list
                assertNotEquals(BoCCategoryNameList.get(n), name,"Constructor did not create unique Category Name");
            }
            times++;
        }
    }

    // Author: Ziyi Wang (scyzw10)
    // Last Modified: 2021/4/24 23:03
    @ParameterizedTest
    @CsvSource({"test1","test2","test3","testWithMoreThan15Chars"})
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
            }catch (Exception e){
                assertThat(e.getMessage(),containsString("Category Name at most 15 characters."));
            }
            fail("it failed");
        }

    }


    //author: Yingxiao Huo
    //Last Modified time: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/categoryNameGetter.csv"})
    void categoryName(String name, String expection) throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory Test_getter = new BoCCategory();
        final Field field_getName = Test_getter.getClass().getDeclaredField("CategoryName");
        field_getName.setAccessible(true);
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
            if (name.length() > 15){
                try {
                    field_getName.set(Test_getter, name);
                    final String result = (String) Test_getter.CategoryName();
                    fail();
                }catch (Exception ex2){
                    assertEquals(expection, ex2.getMessage());
                }
            }
            else {
                field_getName.set(Test_getter, name);
                final String result = Test_getter.CategoryName();
                assertEquals(result, expection);
            }
        }
    }

    //Author: Yicun Duan (scyyd3)
    //Last Modified: 2021/4/24 15:41
    @ParameterizedTest
    @CsvFileSource(resources = {"getBudgetTest.csv"})
    void categoryBudget(BigDecimal budget, BigDecimal expectBudget) throws NoSuchFieldException, IllegalAccessException {
        if (budget != null || expectBudget != null) {
            final BoCCategory budgetTest = new BoCCategory();
            final Field field = budgetTest.getClass().getDeclaredField("CategoryBudget");
            field.setAccessible(true);
            field.set(budgetTest, budget);

            final BigDecimal result = budgetTest.CategoryBudget();
            assertEquals(result, expectBudget, "CategoryBudget() function doesn't return an expected result.");
        } else {
            final BoCCategory test_instance = new BoCCategory();
            assertEquals(new BigDecimal("0.00"), test_instance.CategoryBudget(), "When using default constructor, CategoryBudget is not 0.00 (BigDecimal). Or it is not of type BigDecimal.");
        }
    }

    // Author: Leshan Tan
    // Last Modified: 2021/4/23
    @Test
    void categorySpend() throws  NoSuchFieldException{
        final BoCCategory boc = new BoCCategory();
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend");
        fieldSpend.setAccessible(true);
        assertEquals(new BigDecimal("0.00"), boc.CategorySpend(),"Field CategorySpend wasn't retrieved properly");
    }


    @ParameterizedTest
    @CsvFileSource(resources = {"categorySpend.csv"})
    void categorySpendWithInputs(String input, String expectation) throws  NoSuchFieldException, IllegalAccessException{
        final BoCCategory boc = new BoCCategory();
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend");
        fieldSpend.setAccessible(true);
        fieldSpend.set(boc, new BigDecimal(input));
        assertEquals( new BigDecimal(expectation), boc.CategorySpend(), "Field CategorySpend wasn't retrieved properly");
    }

    //author: Yingxiao Huo
    //Last modified time: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/categoryNameSetter.csv"})
    void setCategoryName(String name, String expection) throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory Test_setter = new BoCCategory();
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
                    try {
                        Test_setter.setCategoryName(name);
                        fail();
                    }catch (Exception ex2){
                        assertEquals(expection, ex2.getMessage());
                    }
                }else {
                    Test_setter.setCategoryName(name);
                    final Field field_setname = Test_setter.getClass().getDeclaredField("CategoryName");
                    field_setname.setAccessible(true);
                    assertEquals(expection, field_setname.get(Test_setter));
                }
            }
    }
    

    // Author: Ziyi Wang
    // Last modified: 2021/4/23 19:31
//    @Test
//    void setCategoryBudget(){
//        final BoCCategory stest = new BoCCategory();    //new object
//
//        float input = 20.00F;
//        //argument passed to setCategoryBudget is incompatible with the type expected
//        stest.setCategoryBudget(input);    // set the budget with float type
//    }

    // Author : LinCHEN(biylc2)
    // Last Modify: 2021/04/24 20:44
    @DisplayName("tests for add Expense")
    @ParameterizedTest
    @CsvSource({",Illegal input","-2e12,-Illegal input","-2.134,Illegal input","0.00,0.00","+.0,+.0","2e12,2e12","2.13443343,2.13443343","2147483647.0012343,2147483647.0012343"})

    void addExpenseTest(String bigNumber,String expected) {

        BoCCategory addT1= new BoCCategory("Tester");
        BigDecimal fiNum= null;
        //only match positive numbers without negative sign



        if(bigNumber == null){
            try{
                addT1.addExpense(new BigDecimal(bigNumber));
            }catch (NullPointerException e1){
                assertThat(e1.getMessage(), containsString(expected));
                return;
            }
        }
        boolean strResult1= bigNumber.matches("[+]?[0-9]+.?[0-9]{0,32}[Ee]?[+-]?[0-9]?[1-9]");
        boolean strResult2 = bigNumber.matches("[+]?[0-9]{0,12}+.?[0-9]{0,16}");

        if(strResult1==false){
            if (strResult2== false){
                try{
                    addT1.addExpense(new BigDecimal(bigNumber));
                }catch (IllegalArgumentException e2){
                    assertThat(e2.getMessage(), containsString(expected));
                }
                fail("The expected error messsage doesn't print as expected");
            }
        }
        try{
            fiNum= new BigDecimal(bigNumber);
        }catch (Exception e3){
            assertEquals(e3.getMessage(),"The big decimal cannot be created");
        }



        addT1.addExpense(fiNum);
        BigDecimal expectedNum=new BigDecimal(expected);
        assertEquals(0,expectedNum.compareTo(addT1.CategorySpend()));

        //BigDecimal value = addT1.CategorySpend().add(fiNum);
        //assertEquals(value,addT1.CategorySpend());


    }

    // Author: Ziyi Wang (scyzw10)
    // Last Modified: 2021/04/22 16:58
    @Ignore
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
    @Ignore
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
            System.out.println("The Exception has been thrown!");
        }
        //fail("it failed");
    }

    // Author: Ziyi Wang (scyzw10)
    // Last Modified: 2021/04/22 20:38
    @Ignore
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
            System.out.println("The Exception has been thrown!");
        }
        //fail("it failed");
    }

    // Author: Ziyi Wang
    // Last modified: 4/25 12:31
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
                System.out.println("The Exception has been thrown!");
            }
            //  fail("it failed");
        }else if (comp2 == -1){     // if BigDecimal(input2) < 0
            try {
                removeE.removeExpense(new BigDecimal(input2));
            } catch (Exception e) {
                assertThat(e.getMessage(), containsString("The valueToRemove must be >= 0"));
                System.out.println("The Exception has been thrown!");
            }
            // fail("it failed");
        }else{  // if all the input is correct then compare the result
            removeE.removeExpense(new BigDecimal(input2));    // remove the expense
            BigDecimal result = (BigDecimal) field.get(removeE);  //store the private CategorySpend in the result
            int equals = result.compareTo(expexpense);   //compare the expected expense with the actual number
            assertEquals(expectation, equals);   //the input expectation store the value of the expected compare value(equals)
        }
    }

    //Author:LinCHEN(biylc2)
    //Last Modify:2021/04/21
    @Test
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
    @ParameterizedTest
    @CsvFileSource(resources = {"/getRemainingBudgetTest.csv"})
    void getRemainingBudget(BigDecimal budget, BigDecimal spend, BigDecimal expectRemain) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory remainTest =  new BoCCategory();
        final Field field_budget = remainTest.getClass().getDeclaredField("CategoryBudget");
        field_budget.setAccessible(true);
        field_budget.set(remainTest, budget);
        final Field field_spend = remainTest.getClass().getDeclaredField("CategorySpend");
        field_spend.setAccessible(true);
        field_spend.set(remainTest, spend);

        final BigDecimal result = remainTest.getRemainingBudget();

        assertEquals(result, expectRemain);

    }

    // Author:LinCHEN(biylc2)
    // Last Modify:2021/04/24

    @Test
    void testToString() throws IllegalAccessException, NoSuchFieldException {
        //default constructor
        BoCCategory boc1= new BoCCategory();
        String a="New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)";
        assertEquals(a,boc1.toString());

        //constructor with parameter
        BoCCategory boc2= new BoCCategory("Positive");
        Field field1=boc2.getClass().getDeclaredField("CategoryBudget");
        ((Field) field1).setAccessible(true);
        field1.set(boc2,new BigDecimal("3457834.023423"));
        Field field2=boc2.getClass().getDeclaredField("CategorySpend");
        field2.setAccessible(true);
        field2.set(boc2,new BigDecimal("667433.00564"));

        String b="Positive(¥3457834.023423) - Est. ¥667433.00564 (¥2790401.017783 Remaining)";
        assertEquals(b,boc2.toString());

        BoCCategory boc3= new BoCCategory("Negative");
        Field field3=boc3.getClass().getDeclaredField("CategoryBudget");
        field3.setAccessible(true);
        field3.set(boc3,new BigDecimal("10000.00"));
        Field field4=boc3.getClass().getDeclaredField("CategorySpend");
        field4.setAccessible(true);
        field4.set(boc3,new BigDecimal("20000.00"));

        String c="Negative(¥10000.00) - Est. ¥20000.00 (¥10000.00 Overspent)";
        assertEquals(c,boc3.toString());

    }



}