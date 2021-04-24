import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;


class BoCCategoryTest {

    @Test
    void categoryName() {
    }

    @Test
    void categoryBudget() {
    }

    @Test
    void categorySpend() {
    }

    @Test
    void setCategoryName() {
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
    @Ignore
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

    // Author: Ziyi Wang
    // Last modified: 4/24 17:14
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

        //if input2(the value of expense need to remove) < 0, then comp = -1
        int comp1 = (new BigDecimal(input2)).compareTo(new BigDecimal(0));
        if (comp1 == -1) {
            throw new InvalidParameterException("The expense must be >= 0");
        }

        //if result(the value of CategorySpend after remove) < 0, then comp = -1
        int comp2 = result.compareTo(new BigDecimal(0));
        if (comp2 == -1) {
            throw new InvalidParameterException("The CategorySpend is must be >= 0");
        }

        // if the input is correct then compare the result
        int equals= result.compareTo(expexpense);   //compare the expected expense with the actual number
        assertEquals(expectation,equals);   //the input expectation store the value of the expected compare value(equals)
    }

    @Test
    void resetBudgetSpend() {
    }

    @Test
    void getRemainingBudget() {
    }

    @Test
    void testToString() {
    }
}