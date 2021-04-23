import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.InvalidParameterException;


import java.lang.reflect.Field;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class BoCCategoryTest {

    // Author: Leshan Tan
    // Last Modified: 2021/4/21
    @Test
    void BocCategory()throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory boc = new BoCCategory();
        final Field fieldName = boc.getClass().getDeclaredField("CategoryName");
        final Field fieldBudget = boc.getClass().getDeclaredField("CategoryBudget");
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend");
        fieldName.setAccessible(true);
        fieldBudget.setAccessible(true);
        fieldSpend.setAccessible(true);
        assertEquals("New Category", fieldName.get(boc),"Field CategoryName didn't match");
        assertEquals(new BigDecimal("0.00"),fieldBudget.get(boc),"Field CategoryBudget didn't match");
        assertEquals(new BigDecimal("0.00"), fieldSpend.get(boc),"Field CategorySpend didn't match");
    }

    @Test
    void BocCategory()throws NoSuchFieldException, IllegalAccessException{
        final BoCCategory boc = new BoCCategory();
        final Field fieldName = boc.getClass().getDeclaredField("CategoryName");
        final Field fieldBudget = boc.getClass().getDeclaredField("CategoryBudget");
        final Field fieldSpend = boc.getClass().getDeclaredField("CategorySpend");
        fieldName.setAccessible(true);
        fieldBudget.setAccessible(true);
        fieldSpend.setAccessible(true);
        assertEquals("New Category", fieldName.get(boc),"Field CategoryName didn't match");
        assertEquals(new BigDecimal("0.00"),fieldBudget.get(boc),"Field CategoryBudget didn't match");
        assertEquals(new BigDecimal("0.00"), fieldSpend.get(boc),"Field CategorySpend didn't match");
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

    //Author: Yicun Duan
    //Last Modified: 2021/4/21
    @ParameterizedTest
    @CsvFileSource(resources = {"getBudgetTest.csv"})
    void categoryBudget(String budget) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory budgetTest =  new BoCCategory();
        final Field field = budgetTest.getClass().getDeclaredField("CategoryBudget");
        field.setAccessible(true);
        field.set(budgetTest, new BigDecimal(budget));

        final BigDecimal result = budgetTest.CategoryBudget();

        assertEquals(result, new BigDecimal(budget));

    }

    @Test
    void categorySpend() {
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
    @Test
    // the input number could not be negative
    void removeExpense2() {
        BoCCategory tcate = new BoCCategory();  //new object

        double input = -20.0;
        BigDecimal expense = new BigDecimal(input); //the amount of expense need to be removed
        int comp = expense.compareTo(new BigDecimal(0));    //if expense < 0, then comp = -1

        if (comp == -1) {
            throw new InvalidParameterException("The expense must be >= 0");
        }

        try {
            tcate.removeExpense(expense);    // the actual value
            //fail("it failed");
        } catch(InvalidParameterException e) {
                System.out.println("Exception is thrown!");
        }
        fail("it failed");
    }

    //Author: Ziyi Wang
    // 2021/04/22 20:38
    @Test
    // the input number could not be larger than the original CategorySpend
    void removeExpense3() throws NoSuchFieldException, IllegalAccessException {
        BoCCategory ttt= new BoCCategory();

        double input1 = 1000.0;
        double input2 = 10000.0;
        ttt.addExpense(new BigDecimal(input1)); //origin amount in the spend
        ttt.removeExpense(new BigDecimal(input2));  // the actual value after subtract
        //try to access the private value CategorySpend
        final Field field = ttt.getClass().getDeclaredField("CategorySpend");
        field.setAccessible(true);

        BigDecimal result = (BigDecimal) field.get(ttt);    //store the CategorySpend in result
        int comp = result.compareTo(new BigDecimal(0)); //if result < 0, then comp = -1

        if (comp == -1) {
            throw new InvalidParameterException("The CategorySpend is must be >= 0");
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
    void getRemainingBudget(String budget, String spend, String remain) throws NoSuchFieldException, IllegalAccessException {
        final BoCCategory remainTest =  new BoCCategory();
        final Field field_budget = remainTest.getClass().getDeclaredField("CategoryBudget");
        field_budget.setAccessible(true);
        field_budget.set(remainTest, new BigDecimal(budget));
        final Field field_spend = remainTest.getClass().getDeclaredField("CategorySpend");
        field_spend.setAccessible(true);
        field_spend.set(remainTest, new BigDecimal(spend));

        final BigDecimal result = remainTest.getRemainingBudget();

        assertEquals(result, new BigDecimal(remain));

    }


        //default constructor
        //Author:LinCHEN(biylc2)
        //Last Modify:2021/04/21
    @Test
    void testToString1() {
        BoCCategory boc1= new BoCCategory();
        String a="New Category(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)";
        assertEquals(a,boc1.toString());
    }

        //constructor with parameter
        //Author:LinCHEN(biylc2)
        //Last Modify:2021/04/21
    @Test
    void testToString2() throws IllegalAccessException, NoSuchFieldException {
        BoCCategory boc1= new BoCCategory("Negative");
        Field field1=boc1.getClass().getDeclaredField("CategoryBudget");
        field1.setAccessible(true);
        field1.set(boc1,new BigDecimal("10000.00"));
        Field field2=boc1.getClass().getDeclaredField("CategorySpend");
        field2.setAccessible(true);
        field2.set(boc1,new BigDecimal("20000.00"));


        String a="Negative(¥10000.00) - Est. ¥20000.00 (¥-10000.00 Overspent)";
        assertEquals(a,boc1.toString());
    }

        //constructor with parameter
        //Author:LinCHEN(biylc2)
        //Last Modify:2021/04/21
    @Test
    void testToString3() throws IllegalAccessException, NoSuchFieldException {
        BoCCategory boc2= new BoCCategory("Positive");
        Field field1=boc2.getClass().getDeclaredField("CategoryBudget");
        field1.setAccessible(true);
        field1.set(boc2,new BigDecimal("3457834.023423"));
        Field field2=boc2.getClass().getDeclaredField("CategorySpend");
        field2.setAccessible(true);
        field2.set(boc2,new BigDecimal("667433.00564"));

        String a="Positive(¥3457834.023423) - Est. ¥667433.00564 (¥2790401.017783 Remaining)";
        assertEquals(a,boc2.toString());
    }


}