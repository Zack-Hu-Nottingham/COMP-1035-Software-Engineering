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

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.InvalidParameterException;


import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class BoCCategoryTest {



    // Author: Leshan Tan
    // Last Modified: 2021/4/22
    @Test
    void BocCategory() throws NoSuchFieldException, IllegalAccessException{
        List BoCCategoryNameList = new ArrayList();
        int times = 0;
        while(times < 10){
            BoCCategory instance = new BoCCategory();
            final Field fieldName = instance.getClass().getDeclaredField("CategoryName");
            final Field fieldBudget = instance.getClass().getDeclaredField("CategoryBudget");
            final Field fieldSpend = instance.getClass().getDeclaredField("CategorySpend");
            fieldName.setAccessible(true);
            fieldBudget.setAccessible(true);
            fieldSpend.setAccessible(true);
            String name = (String) fieldName.get(instance);
            BoCCategoryNameList.add(name);
            assertEquals(new BigDecimal("0.00"),fieldBudget.get(instance),"Field CategoryBudget didn't match");
            assertEquals(new BigDecimal("0.00"), fieldSpend.get(instance),"Field CategorySpend didn't match");
            for (int n=0;n<times;n++){
                assertNotEquals(BoCCategoryNameList.get(n), name,"Constructor did not create unique Category Name");
            }
            times++;
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
        field_getName.set(Test_getter, name);
        final String result = (String) Test_getter.CategoryName();
        assertEquals(result, expection);
    }

    //Author: Yicun Duan (scyyd3)
    //Last Modified: 2021/4/23 18:36
    @ParameterizedTest
    @CsvFileSource(resources = {"getBudgetTest.csv"})
    void categoryBudget(String budget, String expectBudget) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory budgetTest =  new BoCCategory();
        final Field field = budgetTest.getClass().getDeclaredField("CategoryBudget");
        field.setAccessible(true);
        field.set(budgetTest, new BigDecimal(budget));

        final BigDecimal result = budgetTest.CategoryBudget();

        assertEquals(result, new BigDecimal(expectBudget), "CategoryBudget() function doesn't return an expected result.");
    }

    //Author: Yicun Duan (scyyd3)
    //Last Modified: 2021/4/23 18:40
    @Test
    void categoryBudget_NullTest(){
        final BoCCategory test_instance = new BoCCategory();

        assertEquals(new BigDecimal("0.00"), test_instance.CategoryBudget(), "When using default constructor, CategoryBudget is not 0.00 (BigDecimal). Or it is not of type BigDecimal.");
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
        Test_setter.setCategoryName(name);
        final Field field_setname = Test_setter.getClass().getDeclaredField("CategoryName");
        field_setname.setAccessible(true);
        assertEquals(expection, field_setname.get(Test_setter));
    }
    
    @Test
    void setCategoryBudget() {
    }

    @Test
    void addExpense() {
    }

    //Author: Ziyi Wang
    // 2021/04/22 16:58
    @Ignore
    @ParameterizedTest
    @CsvFileSource(resources = {"cate_removeExpense.csv"})
    void removeExpense1(float input1,float input2, float input3, int expectation) throws NoSuchFieldException, IllegalAccessException {
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

    //Author: Ziyi Wang
    // 2021/04/22 19:45
    @Ignore
    @ParameterizedTest
    @ValueSource(floats = {-20.0F, -30.0F, -50.0F})
    // the input number could not be negative
    void removeExpense2(float input) {
        BoCCategory tcate = new BoCCategory();  //new object

        try {
            tcate.removeExpense(new BigDecimal(input));    // the actual value
        } catch(Exception e) {
            assertThat(e.getMessage(),containsString("The expense must be >= 0"));
        }
        fail("it failed");
    }

    //Author: Ziyi Wang
    // 2021/04/22 20:38
    @Ignore
    @ParameterizedTest
    @CsvSource({"200.0, 300.0","200.0,400.0","1000.0,10000.0"})
    // the input number could not be larger than the original CategorySpend
    void removeExpense3(float input1,float input2) throws NoSuchFieldException, IllegalAccessException {
        BoCCategory ttt= new BoCCategory();

        ttt.addExpense(new BigDecimal(input1)); //origin amount in the spend
        try {
            ttt.removeExpense(new BigDecimal(input2));     // the actual value
        } catch(Exception e) {
            assertThat(e.getMessage(),containsString("The CategorySpend is must be >= 0"));
        }
        fail("it failed");
    }

    // Author: Ziyi Wang
    // Last modified: 4/24 21:48
    @ParameterizedTest
    @CsvFileSource(resources = {"cate_removeExpense.csv"})
    void removeExpense(float input1,float input2, float expect, int expectation) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory removeE = new BoCCategory();  //new object

        //removeE.CategorySpend = new BigDecimal(20000);  ==> since the CategorySpend is private -> could not change
        removeE.addExpense(new BigDecimal(input1));   //use addExpense() to save an initial value in it
        removeE.removeExpense(new BigDecimal(input2));    // remove the expense
        //get the private variable
        final Field field = removeE.getClass().getDeclaredField("CategorySpend");
        field.setAccessible(true);

        final BigDecimal expexpense = new BigDecimal(expect);  //the expected amount of expense after remove
        BigDecimal result = (BigDecimal) field.get(removeE);  //store the private CategorySpend in the result

        if (input1 < input2) {
            try {
                removeE.removeExpense(new BigDecimal(input2));     // the actual value
            } catch(Exception e) {
                assertThat(e.getMessage(),containsString("The CategorySpend is must be >= 0"));
            }
            fail("it failed");
        }else if (input2 < 0){
            try {
                removeE.removeExpense(new BigDecimal(input2));
            } catch (Exception e) {
                assertThat(e.getMessage(), containsString("The expense must be >= 0"));
            }
            fail("it failed");
        }else{  // if the input is correct then compare the result
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
        assertEquals(new BigDecimal("0.00"),result1);

    }

    //Author: Yicun Duan
    //Last Modified: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"/getRemainingBudgetTest.csv"})
    void getRemainingBudget(String budget, String spend, String expectRemain) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory remainTest =  new BoCCategory();
        final Field field_budget = remainTest.getClass().getDeclaredField("CategoryBudget");
        field_budget.setAccessible(true);
        field_budget.set(remainTest, new BigDecimal(budget));
        final Field field_spend = remainTest.getClass().getDeclaredField("CategorySpend");
        field_spend.setAccessible(true);
        field_spend.set(remainTest, new BigDecimal(spend));

        final BigDecimal result = remainTest.getRemainingBudget();

        assertEquals(result, new BigDecimal(expectRemain));

    }


        //Author:LinCHEN(biylc2)
        //Last Modify:2021/04/24

    @Test
    void testToString() throws IllegalAccessException, NoSuchFieldException {
        //default constructor
        BoCCategory boc1= new BoCCategory();
        String a="New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)";
        assertEquals(a,boc1.toString());

        //constructor with parameter
        BoCCategory boc2= new BoCCategory("Positive");
        Field field1=boc2.getClass().getDeclaredField("CategoryBudget");
        field1.setAccessible(true);
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

        String c="Negative(¥10000.00) - Est. ¥20000.00 (¥-10000.00 Overspent)";
        assertEquals(c,boc3.toString());

    }


}