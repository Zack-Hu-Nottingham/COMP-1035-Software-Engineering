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